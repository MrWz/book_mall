package cvter.intern.service;

import cvter.intern.model.Book;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface BookService {

    Book selectByUid(String uid);

    List<Book> selectByPaginate(int m, int n);

    int save(Book book);

    int update(Book book);

    int deleteByUid(String uid);

    List<Book> selectAll();

}
