package cvter.intern.service.impl;

import cvter.intern.dao.BookDao;
import cvter.intern.exception.ParameterException;
import cvter.intern.model.Book;
import cvter.intern.service.BookService;
import cvter.intern.utils.UIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {

    @Resource
    private BookDao bookDao;
    @Resource
    private BookService bookService;

    public BookServiceImpl() {
        super();
    }

    /**
     * 增加记录
     */
    public boolean save(Book book) {
        if (StringUtils.isAnyBlank(book.getName(), book.getAuthor(), book.getPrice() + "", book.getStock() + "", book.getDescription())) {
            throw new ParameterException("参数为空");
        }
        book.setUid(UIDUtil.getRandomUID());
        return bookDao.insert(book);
    }

    /**
     * 删除图书
     */
    public boolean bookDel(String uid) {
        if (StringUtils.isBlank(uid)) {
            throw new ParameterException("参数为空");
        }
        return bookService.deleteByUid(uid);
    }

    /**
     * 修改价钱
     */
    public boolean bookAdjustPrice(String uid, int price) {
        if (StringUtils.isAnyBlank(uid, price + "")) {
            throw new ParameterException("参数为空");
        }
        Book book = bookService.selectByUid(uid);
        book.setPrice(price);
        book.setUpdateTime(new Date());
        return bookService.update(book);
    }

    /**
     * 修改库存
     */
    public void bookAdjustStock(String uid, int stock) {
        if (StringUtils.isAnyBlank(uid, stock + "")) {
            throw new ParameterException("参数为空");
        }
        Book book = bookService.selectByUid(uid);
        book.setStock(stock);
        book.setUpdateTime(new Date());
        bookService.update(book);
    }

    /**
     * 删除记录
     */
    public boolean deleteByUid(String uid) {
        return bookDao.deleteByPrimaryKey(uid);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectAll();
    }

    /**
     * 更新记录
     */
    public boolean update(Book book) {
        return bookDao.updateByPrimaryKey(book);
    }

    /**
     * 查询
     */
    public Book selectByUid(String uid) {
        return bookDao.selectByBookUid(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<Book> selectByPaginate(int m, int n) {
        return bookDao.selectByPaginate(m, n);
    }
}
