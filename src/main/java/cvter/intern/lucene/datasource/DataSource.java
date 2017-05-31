package cvter.intern.lucene.datasource;

import cvter.intern.lucene.model.BookIndex;

import java.util.List;

/**
 * Created by cvter on 2017/5/18.
 */
public interface DataSource {

    List<BookIndex> getIndexData();

    void setIndexData(List<BookIndex> indices);
}
