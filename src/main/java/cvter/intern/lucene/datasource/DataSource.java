package cvter.intern.lucene.datasource;

import cvter.intern.lucene.model.Index;

import java.util.List;

/**
 * Created by cvter on 2017/5/18.
 */
public interface DataSource {

    List<Index> getIndexData();

    void setIndexData(List<Index> indices);
}
