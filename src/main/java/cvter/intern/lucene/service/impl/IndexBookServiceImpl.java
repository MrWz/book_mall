package cvter.intern.lucene.service.impl;

import cvter.intern.lucene.IndexManager;
import cvter.intern.lucene.dao.impl.IndexDaoImpl;
import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.model.Index;
import cvter.intern.lucene.service.IndexBookService;
import cvter.intern.model.BookInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cvter on 2017/5/21.
 */
public class IndexBookServiceImpl implements IndexBookService {

    private IndexManager indexManager = IndexManager.builder(IndexDaoImpl.class);

    @Override
    public List<BookInfo> searchBookTopN(String text, String queryField, int nDocs) throws Exception {

        return getBookInfo(indexManager.searchIndexTopN(text, queryField, nDocs));
    }

    @Override
    public List<BookInfo> searchBookPaginated(String text, String queryField, int currentPage, int pageSize) throws Exception {
        List<BookInfo> bookInfos = null;

        return getBookInfo(indexManager.searchIndexPaginated(text, queryField, currentPage, pageSize));
    }

    private List<BookInfo> getBookInfo(List<Index> bookIndeics) {
        List<BookInfo> bookInfos = null;

        if (bookIndeics.size() > 0) {
            bookInfos = new ArrayList<>();
            for (Index index :
                    bookIndeics) {
                if (index instanceof BookIndex) {
                    BookInfo book = new BookInfo();
                    book.setUid(((BookIndex) index).getUid());
                    book.setName(((BookIndex) index).getName());
                    book.setAuthor(((BookIndex) index).getAuthor());
                    book.setDescription(((BookIndex) index).getDescription());
                    bookInfos.add(book);
                }
            }
        }
        return bookInfos;
    }
}
