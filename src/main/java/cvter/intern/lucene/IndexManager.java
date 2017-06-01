package cvter.intern.lucene;

import cvter.intern.lucene.datasource.DataSource;
import cvter.intern.lucene.model.BookIndex;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

/**
 * 索引管理器
 * <p>
 * Created by cvter on 2017/5/18.
 */
public class IndexManager {

    private static Logger logger = LoggerFactory.getLogger(IndexManager.class);

    private String indexDir;         //索引目录
    private int nDocs;               //搜索数目

    private Class indexClass = BookIndex.class;

    private Directory directory = null;
    private IndexWriter writer = null;
    private IndexReader reader = null;

    public IndexManager(String indexDir, int nDocs) {
        this.indexDir = indexDir;
        this.nDocs = nDocs;
    }

    /**
     * 创建当前文件目录的索引
     *
     * @param dataSource 数据源
     * @return 是否成功
     */
    public boolean createIndex(DataSource dataSource) {

        List<BookIndex> bookIndices = dataSource.getIndexData();

        for (BookIndex bookIndex : bookIndices) {
            try {
                // 创建分词器，标准分词器
                Analyzer analyzer = new IKAnalyzer(true);

                // 创建IndexWriter
                IndexWriterConfig cfg = new IndexWriterConfig(analyzer);

                // 指定索引库的地址
                directory = FSDirectory.open(FileSystems.getDefault().getPath(indexDir));

                writer = new IndexWriter(directory, cfg);

                File indexFile = new File(indexDir);
                if (!indexFile.exists()) {
                    indexFile.mkdirs();
                }

                java.lang.reflect.Field[] fields = indexClass.getDeclaredFields();

                Document document = new Document();
                for (java.lang.reflect.Field f : fields) {
                    f.setAccessible(true);
                    document.add(new TextField(f.getName(), f.get(bookIndex).toString(), Field.Store.YES));
                }

                writer.addDocument(document);
                writer.commit();

            } catch (Exception e) {
                logger.error(e.getMessage());
            } finally {
                close();
            }
        }

        return true;
    }

    /**
     * 查找索引，返回符合条件的前N项文件
     *
     * @param text       查找的字符串
     * @param queryField 查找的字符串类别
     * @return
     * @throws Exception
     */
    public List<BookIndex> doSearch(String text, String queryField) throws Exception {
        // 创建query对象
        Analyzer analyzer = new IKAnalyzer(true);
        // 使用QueryParser搜索时，需要指定分词器，搜索时的分词器要和索引时的分词器一致
        // 第一个参数：默认搜索的域的名称
        QueryParser parser = new QueryParser(queryField, analyzer);

        // 通过queryparser来创建query对象
        Query query = parser.parse(text);

        Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(indexDir));
        reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        // 通过searcher来搜索索引库
        // 第二个参数：指定需要显示的顶部记录的N条
        TopDocs topDocs = searcher.search(query, nDocs);

        // 根据查询条件匹配出的记录总数
        int count = topDocs.totalHits;
        System.out.println("匹配出的记录总数:" + count);
        // 根据查询条件匹配出的记录
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;

        List<BookIndex> indexList = setIndexList(scoreDocs, searcher);

        // 关闭资源
        close();

        return indexList;
    }

    /**
     * 将命中的索引转换
     *
     * @param hits
     * @return
     * @throws IOException
     */
    private List<BookIndex> setIndexList(ScoreDoc[] hits, IndexSearcher searcher) throws IOException {
        List<BookIndex> indexList = new ArrayList<>();

        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = searcher.doc(hits[i].doc);

            BookIndex bookIndex = new BookIndex();

            bookIndex.setUid(hitDoc.get(BookIndex.UID));
            bookIndex.setName(hitDoc.get(BookIndex.NAME));
            bookIndex.setAuthor(hitDoc.get(BookIndex.AUTHOR));
            bookIndex.setDescription(hitDoc.get(BookIndex.DESCRIPTION));

            indexList.add(bookIndex);
        }

        return indexList;
    }


    /**
     * 查找索引，返回符合条件的文件 -- 分页
     *
     * @param text        查找的字符串
     * @param queryField  查找的字符串类别
     * @param currentPage 当前页
     * @param pageSize    页的大小
     * @return
     * @throws Exception
     */
    public List<BookIndex> searchIndexPaginated(String text, String queryField, int currentPage, int pageSize) throws
            Exception {

        List<BookIndex> indexList = doSearch(text, queryField);

        int start = (currentPage - 1) * pageSize;
        int end = currentPage * pageSize;

        if (start < 0 || start > indexList.size()) {
            start = 0;
        }

        if (end < 0 || end > indexList.size()) {
            end = indexList.size();
        }

        return indexList.subList(start, end);
    }

    /**
     * 更新索引
     *
     * @param indices
     * @return
     * @throws Exception
     */

    public boolean updateIndex(List<BookIndex> indices) throws Exception {
        return false;
    }

    /**
     * 删除索引
     *
     * @param indices
     * @return
     * @throws Exception
     */
    public boolean deleteIndex(List<BookIndex> indices) throws Exception {
        return false;
    }

    /**
     * 清除索引
     */
    public void clearIndex() {
        File fileIndex = new File(indexDir);
        if (deleteDir(fileIndex)) {
            fileIndex.mkdir();
        } else {
            fileIndex.mkdir();
        }
    }

    /**
     * 删除文件目录下的所有文件
     *
     * @param file 要删除的文件目录
     * @return 如果成功，返回true.
     */
    private boolean deleteDir(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteDir(files[i]);
            }
        }
        file.delete();
        return true;
    }

    /**
     * 关闭资源
     */
    private void close() {
        try {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (directory != null) {
                directory.close();
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
