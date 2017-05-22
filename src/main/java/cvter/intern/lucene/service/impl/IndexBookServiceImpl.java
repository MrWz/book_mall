package cvter.intern.lucene.service.impl;

import cvter.intern.lucene.IndexManager;
import cvter.intern.lucene.dao.impl.IndexDaoImpl;
import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.model.Index;
import cvter.intern.lucene.service.IndexBookService;
import cvter.intern.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cvter on 2017/5/21.
 */
public class IndexBookServiceImpl implements IndexBookService {

    private IndexManager indexManager = IndexManager.builder(IndexDaoImpl.class);

    @Override
    public List<Book> searchBookTopN(String text, String queryField, int nDocs) throws Exception {

        return getBook(indexManager.searchIndexTopN(text, queryField, nDocs));
    }

    @Override
    public List<Book> searchBookPaginated(String text, String queryField, int currentPage, int pageSize) throws Exception {
        List<Book> Books = null;

        return getBook(indexManager.searchIndexPaginated(text, queryField, currentPage, pageSize));
    }

    private List<Book> getBook(List<Index> bookIndeics) {
        List<Book> Books = null;

        if (bookIndeics.size() > 0) {
            Books = new ArrayList<>();
            for (Index index :
                    bookIndeics) {
                if (index instanceof BookIndex) {
                    Book book = new Book();
                    book.setUid(((BookIndex) index).getUid());
                    book.setName(((BookIndex) index).getName());
                    book.setAuthor(((BookIndex) index).getAuthor());
                    book.setDescription(((BookIndex) index).getDescription());
                    Books.add(book);
                }
            }
        }
        return Books;
    }
}
