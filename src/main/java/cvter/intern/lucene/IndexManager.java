package cvter.intern.lucene;

import cvter.intern.exception.BusinessException;
import cvter.intern.exception.ExceptionCode;
import cvter.intern.lucene.dao.IndexDao;
import cvter.intern.lucene.datasource.DataSource;
import cvter.intern.lucene.model.Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public static int nDocs;                                    //搜索数目

    private static IndexDao indexDao;
    private static IndexManager indexManager;
    private static Logger logger = LoggerFactory.getLogger(IndexManager.class);

    private IndexManager(Class<IndexDao> clazz) throws Exception {

        //加载配置文件
        Properties prop = new Properties();
        InputStream is = IndexManager.class.getClassLoader().getResourceAsStream("common.properties");

        prop.load(is);

        INDEX_DIR = prop.getProperty("indexPath", "D:/lucene/luceneIndex");
        nDocs = Integer.parseInt(prop.getProperty("nDocs", "1000"));

        indexDao = clazz.newInstance();
    }

    /**
     * 创建索引管理器
     *
     * @return 返回索引管理器对象
     */
    public static <T extends IndexDao> IndexManager builder(Class<T> clazz) {
        if (indexManager == null) {
            try {
                indexManager = new IndexManager((Class<IndexDao>) clazz);
            } catch (Exception e) {
                throw new BusinessException(10000, "全文检索初始化异常" + e.getMessage());
            }
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
            throw new BusinessException(ExceptionCode.EX_10000.getCode(), "创建索引异常");
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
    public List<Index> searchIndexTopN(String text, String queryField, int nDocs) {

        try {
            return indexDao.searchIndexTopN(text, queryField, nDocs);
        } catch (Exception e) {
            throw new BusinessException(ExceptionCode.EX_10000.getCode(), "搜索TopN异常" + e.getMessage());
        }
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
    public List<Index> searchIndexPaginated(String text, String queryField, int currentPage, int pageSize) {

        try {
            return indexDao.searchIndexPaginated(text, queryField, currentPage, pageSize);
        } catch (Exception e) {
            throw new BusinessException(ExceptionCode.EX_10000.getCode(), "分页搜索异常" + e.getMessage());
        }
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
