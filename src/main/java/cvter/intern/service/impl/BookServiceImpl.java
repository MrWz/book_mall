package cvter.intern.service.impl;
import cvter.intern.dao.BookBooktagDao;
import cvter.intern.dao.BookDao;
import cvter.intern.dao.BooktagDao;
import cvter.intern.exception.ParameterException;
import cvter.intern.model.Book;
import cvter.intern.model.BookBooktag;
import cvter.intern.model.Booktag;
import cvter.intern.model.Panic;
import cvter.intern.service.BookService;
import cvter.intern.service.PanicService;
import cvter.intern.utils.UIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Resource
    private BookService bookService;
    @Autowired
    private BooktagDao booktagDao;
    @Autowired
    private BookBooktagDao bookBooktagDao;

    public BookServiceImpl() {
        super();
    }

    /**
     * 增加记录
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(Book book,String bookType) {
        if (StringUtils.isAnyBlank(book.getName(), book.getAuthor(), book.getPrice() + "", book.getStock() + "", book.getDescription(),bookType)) {
            throw new ParameterException("参数为空");
        }
        book.setUid(UIDUtil.getRandomUID());
        Date date=new Date();
        Booktag booktag=booktagDao.selectByDescription(bookType);
        BookBooktag bookBooktag=new BookBooktag(book.getUid(),booktag.getUid(),false,date,date);
        bookBooktagDao.insert(bookBooktag);
        return bookDao.insert(book);
    }

    /**
     * 删除图书
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)

    public boolean bookDel(String uid) {
        if (StringUtils.isBlank(uid)) {
            throw new ParameterException("参数为空");
        }
        return bookService.deleteByUid(uid);
    }

    /**
     * 修改价钱
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)

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
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)

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
    @Override
    @Transactional(rollbackFor = Exception.class)
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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Book book) {
        return bookDao.updateByPrimaryKey(book);
    }

    /**
     * 查询
     */
    @Override
    public Book selectByUid(String uid) {
        return bookDao.selectByBookUid(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    @Override
    public List<Book> selectByPaginate(int m, int n) {
        return bookDao.selectByPaginate(m, n);
    }
}
