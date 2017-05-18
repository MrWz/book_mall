package cvter.intern.lucene;

import java.util.List;

/**
 * Created by cvter on 2017/5/18.
 */
public interface DataSource {

    List<BookIndex> getBookData();

    void setBookData(List<BookIndex> bookData);
}
