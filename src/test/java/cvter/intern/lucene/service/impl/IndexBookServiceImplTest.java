package cvter.intern.lucene.service.impl;

import cvter.intern.lucene.IndexManager;
import cvter.intern.lucene.dao.impl.IndexDaoImpl;
import cvter.intern.lucene.model.BookIndex;
import cvter.intern.model.Book;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cvter on 2017/5/24.
 */
public class IndexBookServiceImplTest {
    @Test
    public void searchBookTopN() throws Exception {
        IndexBookServiceImpl indexBookService = new IndexBookServiceImpl();
        List<Book> books = indexBookService.searchBookTopN("书名", BookIndex.NAME, 100);

        System.out.println(books);

        List<Book> authors = indexBookService.searchBookTopN("作者", BookIndex.AUTHOR, 1000);
        System.out.println(authors);

    }

    @Test
    public void searchBookPaginated() throws Exception {
    }

}