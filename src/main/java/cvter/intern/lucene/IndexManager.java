package cvter.intern.lucene;

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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 索引管理器
 * <p>
 * Created by cvter on 2017/5/18.
 */
public class IndexManager {

    private static String INDEX_DIR = null;         //索引目录
    private static int nDocs;                       //查询数目

    private static IndexManager indexManager;
    private static Analyzer analyzer = null;
    private static Directory directory = null;

    private static IndexWriter indexWriter = null;

    private static Logger logger = LoggerFactory.getLogger(IndexManager.class);

    private IndexManager() {

        //加载配置文件
        Properties prop = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("common.properties");
        try {
            prop.load(is);

            INDEX_DIR = prop.getProperty("indexPath", "luceneIndex");
            nDocs = Integer.parseInt(prop.getProperty("nDocs", "100"));

        } catch (IOException e) {
            logger.error("加载配置文件出错");
        }
    }

    /**
     * 创建索引管理器
     *
     * @return 返回索引管理器对象
     */
    public static IndexManager getInstance() {
        if (indexManager == null) {
            indexManager = new IndexManager();
        }
        return indexManager;
    }

    /**
     * 创建当前文件目录的索引
     *
     * @param dataSource 数据源
     * @return 是否成功
     */
    public boolean createIndex(DataSource dataSource) {

        clearIndex();

        List<BookIndex> bookIndices = dataSource.getBookData();

        for (BookIndex bookData : bookIndices) {
            try {
                analyzer = new IKAnalyzer(true);
                directory = FSDirectory.open(new File(INDEX_DIR));

                File indexFile = new File(INDEX_DIR);
                if (!indexFile.exists()) {
                    indexFile.mkdirs();
                }
                IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_4, analyzer);
                indexWriter = new IndexWriter(directory, config);

                java.lang.reflect.Field[] bookFields = BookIndex.class.getDeclaredFields();

                Document document = new Document();
                for (java.lang.reflect.Field f : bookFields) {
                    f.setAccessible(true);
                    document.add(new TextField(f.getName(), f.get(bookData).toString(), Field.Store.YES));
                }

                indexWriter.addDocument(document);
                indexWriter.commit();
                closeWriter();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    /**
     * 查找索引，返回符合条件的文件
     *
     * @param text       查找的字符串
     * @param queryField 查找的字符串类别
     * @return
     */
    public List<BookIndex> searchIndex(String text, String queryField) {

        return searchIndexTopN(text, queryField, nDocs);
    }

    /**
     * 查找索引，返回符合条件的前N项文件
     *
     * @param text       查找的字符串
     * @param queryField 查找的字符串类别
     * @return
     */
    public List<BookIndex> searchIndexTopN(String text, String queryField, int nDocs) {

        List<BookIndex> bookIndexList = new ArrayList<BookIndex>();
        try {
            directory = FSDirectory.open(new File(INDEX_DIR));
            analyzer = new IKAnalyzer(true);
            DirectoryReader ireader = DirectoryReader.open(directory);
            org.apache.lucene.search.IndexSearcher isearcher = new org.apache.lucene.search.IndexSearcher(ireader);

            QueryParser parser = new QueryParser(Version.LUCENE_4_10_4, queryField, analyzer);
            parser.setDefaultOperator(QueryParser.AND_OPERATOR);
            Query query = parser.parse(text);

            TopDocs topDocs = isearcher.search(query, nDocs);
            System.out.println("命中：" + topDocs.totalHits);
            ScoreDoc[] hits = topDocs.scoreDocs;

            for (int i = 0; i < hits.length; i++) {
                Document hitDoc = isearcher.doc(hits[i].doc);
                if (!"".equals(hitDoc.get(queryField))) {

                    BookIndex bookIndex = new BookIndex();
                    bookIndex.setUid(hitDoc.get(BookIndex.UID));
                    bookIndex.setName(hitDoc.get(BookIndex.NAME));
                    bookIndex.setAuthor(hitDoc.get(BookIndex.AUTHOR));
                    bookIndex.setSummary(hitDoc.get(BookIndex.SUMMARY));

                    bookIndexList.add(bookIndex);
                }
            }

            ireader.close();
            directory.close();
        } catch (Exception e) {
            logger.error("查询索引出错");
        }

        return bookIndexList;
    }

    /**
     * 查找索引，返回符合条件的文件 -- 分页
     *
     * @param text       查找的字符串
     * @param queryField 查找的字符串类别
     * @return
     */
    public List<BookIndex> searchIndexPaginated(String text, String queryField, int currentPage, int pageSize) {

        List<BookIndex> bookIndexList = searchIndex(text, queryField);

        int start = (currentPage - 1) * pageSize;
        int end = currentPage * pageSize;

        if (start < 0 || start > bookIndexList.size()) {
            start = 0;
        }

        if (end < 0 || end > bookIndexList.size()) {
            end = bookIndexList.size();
        }

        return bookIndexList.subList(start, end);
    }

    /**
     * 清除索引
     */
    public void clearIndex() {
        File fileIndex = new File(INDEX_DIR);
        if (deleteDir(fileIndex)) {
            fileIndex.mkdir();
        } else {
            fileIndex.mkdir();
        }
    }

    /**
     * 关闭资源
     *
     * @throws Exception
     */
    private void closeWriter() throws Exception {
        if (indexWriter != null) {
            indexWriter.close();
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
}
