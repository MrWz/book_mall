package cvter.intern.lucene.dao;

import cvter.intern.lucene.datasource.DataSource;
import cvter.intern.lucene.model.Index;

import java.util.List;

/**
 * 索引操作接口
 * <p>
 * Created by cvter on 2017/5/19.
 */
public interface IndexDao {

    boolean createIndex(DataSource dataSource) throws Exception;

    List<Index> searchIndexTopN(String text, String queryField, int nDocs) throws Exception;

    List<Index> searchIndexPaginated(String text, String queryField, int currentPage, int pageSize) throws Exception;

    boolean updateIndex(List<Index> indices) throws Exception;

    boolean deleteIndex(List<Index> indices) throws Exception;

    void clearIndex() throws Exception;
}
