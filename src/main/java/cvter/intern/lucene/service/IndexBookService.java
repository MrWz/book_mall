package cvter.intern.lucene.service;

import cvter.intern.model.Book;

import java.util.List;

/**
 * 图书检索业务接口
 */
public interface IndexBookService {

    List<Book> searchBookTopN(String text, String queryField, int nDocs) throws Exception;

    List<Book> searchBookPaginated(String text, String queryField, int currentPage, int pageSize) throws Exception;

}
