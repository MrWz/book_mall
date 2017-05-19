package cvter.intern.lucene;

import cvter.intern.lucene.dao.IndexDao;
import cvter.intern.lucene.datasource.DataSource;
import cvter.intern.lucene.model.Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * 索引管理器
 * <p>
 * Created by cvter on 2017/5/18.
 */
public class IndexManager {

    public static String INDEX_DIR = null;         //索引目录
    public static int nDocs;                       //索引目录

    private static IndexDao indexDao;
    private static IndexManager indexManager;
    private static Logger logger = LoggerFactory.getLogger(IndexManager.class);

    private IndexManager(Class<IndexDao> clazz) {

        //加载配置文件
        Properties prop = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("common.properties");
        try {
            prop.load(is);

            INDEX_DIR = prop.getProperty("indexPath", "luceneIndex");
            nDocs = Integer.parseInt(prop.getProperty("nDocs", "100"));

            indexDao = clazz.newInstance();
        } catch (IOException e) {
            logger.error("加载配置文件出错");
        } catch (IllegalAccessException e) {
            logger.error("实例化Impl对象失败");
        } catch (InstantiationException e) {
            logger.error("实例化Impl对象失败");
        }

    }

    /**
     * 创建索引管理器
     *
     * @return 返回索引管理器对象
     */
    public static <T extends IndexDao> IndexManager builder(Class<T> clazz) {
        if (indexManager == null) {
            indexManager = new IndexManager((Class<IndexDao>) clazz);
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

        try {
            return indexDao.createIndex(dataSource);
        } catch (Exception e) {
            return false;
        }
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
    public List<Index> searchIndexTopN(String text, String queryField, int nDocs) throws Exception {

        return indexDao.searchIndexTopN(text, queryField, nDocs);
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
    public List<Index> searchIndexPaginated(String text, String queryField, int currentPage, int pageSize) throws Exception {

        return indexDao.searchIndexPaginated(text, queryField, currentPage, pageSize);
    }

    /**
     * 清除索引
     */
    public void clearIndex() {
        try {
            indexDao.clearIndex();
        } catch (Exception e) {
            logger.error("清除索引出错");
        }
    }
}
