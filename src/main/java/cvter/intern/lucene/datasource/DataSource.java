package cvter.intern.lucene.datasource;

import cvter.intern.lucene.model.BookIndex;

import java.util.List;

/**
 * 构建图书检索数据源接口
 */
public interface DataSource {

    List<BookIndex> getIndexData();

    void setIndexData(List<BookIndex> indices);
}
