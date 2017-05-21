package cvter.intern.lucene.service;

import cvter.intern.model.BookInfo;

import java.util.List;

/**
 * Created by cvter on 2017/5/21.
 */
public interface IndexBookService {

    List<BookInfo> searchBookTopN(String text, String queryField, int nDocs) throws Exception;

    List<BookInfo> searchBookPaginated(String text, String queryField, int currentPage, int pageSize) throws Exception;

}
