package cvter.intern.service;

import cvter.intern.model.Book;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface BookService {

    Book selectByUid(String uid);

    List<Book> selectByPaginate(int m, int n);

    boolean save(Book book);

    boolean update(Book book);

    boolean deleteByUid(String uid);

    List<Book> selectAll();

    boolean bookDel(String uid);

    boolean bookAdjustPrice(String uid, int price);

    void bookAdjustStock(String uid, int stock);
}
