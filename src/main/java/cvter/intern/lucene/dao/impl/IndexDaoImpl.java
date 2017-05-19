package cvter.intern.lucene.dao.impl;

import cvter.intern.lucene.IndexManager;
import cvter.intern.lucene.dao.IndexDao;
import cvter.intern.lucene.datasource.DataSource;
import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.model.Index;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 索引操作实现类
 * <p>
 * Created by cvter on 2017/5/19.
 */
public class IndexDaoImpl implements IndexDao {

    private static Analyzer analyzer = null;
    private static Directory directory = null;

    private static IndexWriter indexWriter = null;
    private static DirectoryReader ireader = null;

    private static org.apache.lucene.search.IndexSearcher indexSearcher = null;

    private static Class indexClass = BookIndex.class;

    private static Logger logger = LoggerFactory.getLogger(IndexDaoImpl.class);

    /**
     * 创建当前文件目录的索引
     *
     * @param dataSource 数据源
     * @return 是否成功
     */
    @Override
    public boolean createIndex(DataSource dataSource) throws Exception {
        List<Index> bookIndices = dataSource.getIndexData();

        for (Index bookIndex : bookIndices) {
            try {
                analyzer = new IKAnalyzer(true);
                directory = FSDirectory.open(new File(IndexManager.INDEX_DIR));

                File indexFile = new File(IndexManager.INDEX_DIR);
                if (!indexFile.exists()) {
                    indexFile.mkdirs();
                }
                IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_4, analyzer);
                indexWriter = new IndexWriter(directory, config);

                java.lang.reflect.Field[] fields = indexClass.getDeclaredFields();

                Document document = new Document();
                for (java.lang.reflect.Field f : fields) {
                    f.setAccessible(true);
                    document.add(new TextField(f.getName(), f.get(bookIndex).toString(), Field.Store.YES));
                }

                indexWriter.addDocument(document);
                indexWriter.commit();

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
     * @param nDocs      N
     * @return
     * @throws Exception
     */
    @Override
    public List<Index> searchIndexTopN(String text, String queryField, int nDocs) throws Exception {
        List<Index> indexList = new ArrayList<>();

        directory = FSDirectory.open(new File(IndexManager.INDEX_DIR));
        analyzer = new IKAnalyzer(true);
        ireader = DirectoryReader.open(directory);
        indexSearcher = new org.apache.lucene.search.IndexSearcher(ireader);

        QueryParser parser = new QueryParser(Version.LUCENE_4_10_4, queryField, analyzer);
        parser.setDefaultOperator(QueryParser.AND_OPERATOR);
        Query query = parser.parse(text);

        TopDocs topDocs = indexSearcher.search(query, nDocs);
        System.out.println("命中：" + topDocs.totalHits);
        ScoreDoc[] hits = topDocs.scoreDocs;

        indexList = setIndexList(hits);
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
    private List<Index> setIndexList(ScoreDoc[] hits) throws IOException {
        List<Index> indexList = new ArrayList<>();

        for (int i = 0; i < hits.length; i++) {
            Document hitDoc = indexSearcher.doc(hits[i].doc);

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
    @Override
    public List<Index> searchIndexPaginated(String text, String queryField, int currentPage, int pageSize) throws Exception {
        List<Index> indexList = searchIndexTopN(text, queryField, IndexManager.nDocs);

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
    @Override
    public boolean updateIndex(List<Index> indices) throws Exception {
        return false;
    }

    /**
     * 删除索引
     *
     * @param indices
     * @return
     * @throws Exception
     */
    @Override
    public boolean deleteIndex(List<Index> indices) throws Exception {
        return false;
    }

    /**
     * 清除索引
     */
    @Override
    public void clearIndex() throws Exception {
        File fileIndex = new File(IndexManager.INDEX_DIR);
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
            if (indexWriter != null) {
                indexWriter.close();
            }
            if (ireader != null) {
                ireader.close();
            }
            if (directory != null) {
                directory.close();
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
