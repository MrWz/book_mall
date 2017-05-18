package cvter.intern.lucene;

import java.util.List;

/**
 * Created by cvter on 2017/5/18.
 */
public class DBDataSource implements DataSource {

    private List<BookIndex> bookData;

    public DBDataSource() {
        loadDataFromDB();
    }

    public DBDataSource(List<BookIndex> bookData) {
        this.bookData = bookData;
    }

    @Override
    public List<BookIndex> getBookData() {
        return bookData;
    }

    @Override
    public void setBookData(List<BookIndex> bookData) {
        this.bookData = bookData;
    }

    private void loadDataFromDB() {
        //此处从数据库加载book信息
    }
}
