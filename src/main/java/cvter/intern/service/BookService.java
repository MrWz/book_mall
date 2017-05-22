package cvter.intern.service;

import cvter.intern.model.BookInfo;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface BookService {

    BookInfo selectByUid(String uid);

    List<BookInfo> selectAll(int m,int n);

    int save(BookInfo bookInfo);

    int update(BookInfo bookInfo);

    int deleteByUid(String uid);
}
