package cvter.intern.service.impl;

import cvter.intern.dao.BookDao;
import cvter.intern.model.Book;
import cvter.intern.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;

    public BookServiceImpl() {
        super();
    }

    /**
     * 增加记录
     */
    public int save(Book book) {
        return bookDao.insert(book);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return bookDao.deleteByPrimaryKey(uid);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    /**
     * 更新记录
     */
    public int update(Book book) {
        return bookDao.updateByPrimaryKey(book);
    }

    /**
     * 查询
     */
    public Book selectByUid(String uid) {
        return bookDao.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<Book> selectByPaginate(int m, int n) {
        return bookDao.selectByPaginate(m,n);
    }
}
