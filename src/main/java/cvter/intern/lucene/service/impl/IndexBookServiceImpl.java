package cvter.intern.lucene.service.impl;

import cvter.intern.lucene.IndexManager;
import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.service.IndexBookService;
import cvter.intern.model.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cvter on 2017/5/21.
 */
public class IndexBookServiceImpl implements IndexBookService {

    @Autowired
    private IndexManager indexManager;

    @Override
    public List<Book> searchBookTopN(String text, String queryField, int nDocs) throws Exception {
        return getBook(indexManager.doSearch(text, queryField));
    }

    @Override
    public List<Book> searchBookPaginated(String text, String queryField, int currentPage, int pageSize) throws Exception {

        return getBook(indexManager.searchIndexPaginated(text, queryField, currentPage, pageSize));
    }

    private List<Book> getBook(List<BookIndex> bookIndeics) {
        List<Book> books = null;

        if (bookIndeics.size() > 0) {
            books = new ArrayList<>();
            for (BookIndex index :
                    bookIndeics) {
                Book book = new Book();
                book.setUid(index.getUid());
                book.setName(index.getName());
                book.setAuthor(index.getAuthor());
                book.setDescription(index.getDescription());
                books.add(book);
            }
        }
        return books;
    }
}
