package cvter.intern.service.impl;

import cvter.intern.dao.BookDao;
import cvter.intern.dao.PanicDao;
import cvter.intern.dao.UserBookDao;
import cvter.intern.dto.Exposer;
import cvter.intern.dto.PanicExecution;
import cvter.intern.enums.PanicStatEnum;
import cvter.intern.exception.PanicClose;
import cvter.intern.exception.PanicException;
import cvter.intern.exception.ParameterException;
import cvter.intern.exception.RepetePanic;
import cvter.intern.model.Book;
import cvter.intern.model.Panic;
import cvter.intern.model.UserBook;
import cvter.intern.service.BookService;
import cvter.intern.service.PanicService;
import cvter.intern.utils.TimeUtil;
import cvter.intern.utils.UIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.util.LuceneTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Time;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class PanicServiceImpl implements PanicService {

    @Autowired
    private PanicDao panicDao;
    @Autowired
    private BookService bookService;
    @Resource
    private PanicService panicService;
    @Autowired
    private UserBookDao userBookDao;

    /**
     * 增加记录
     */
    public boolean save(Panic record) {
        return panicDao.insert(record);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return panicDao.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(Panic record) {
        return panicDao.updateByPrimaryKey(record);
    }

    /**
     * 查询
     */
    public Panic selectByUID(String uid) {
        return panicDao.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<Panic> selectAll() {
        return null;
    }


//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public boolean bookPanic(Panic pbook,String uid) {
//        if(StringUtils.isAnyEmpty(pbook.getNums()+"",pbook.getCurPrice()+"",pbook.getStartTime()+"",pbook.getEndTime()+"")){
//            throw new ParameterException("参数为空");
//        }
//        Book book=bookService.selectByUid(uid);
//        if(pbook.getNums()>book.getStock()){
//            return false;
//        }
//        book.setStock(book.getStock()-pbook.getNums());
//        bookService.update(book);
//        //pbook.setUid(UIDUtil.getRandomUID());
//        System.out.println(pbook.getUid()+pbook.getNums()+"---"+pbook.getCurPrice()+pbook.getEndTime()+pbook.getStartTime());
//       // return true;
//        //return panicDao.insert(pbook);
//
//
//        //System.out.println( strToDateLong(pbook.getStartTime()));
//        return panicService.save(pbook);
//        }

    /**
     * 发布抢购
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean bookPanic(int nums, int curPrice, String startTime, String endTime, String uid) {

        Date date = new Date();
        Book book = bookService.selectByUid(uid);
        if (nums > book.getStock()) {
            return false;
        }
        book.setStock(book.getStock() - nums);
        book.setUpdateTime(date);
        bookService.update(book);

        System.out.println(startTime);
        Panic pbook = new Panic(nums, curPrice, TimeUtil.strToDateLong(startTime), TimeUtil.strToDateLong(endTime), date, date);
        pbook.setUid(UIDUtil.getRandomUID());
        return panicService.save(pbook);
    }

    /**
     * 暴露秒杀接口
     */
    @Override
    public Exposer exportPanicUrl(String bookId) {
        Panic pbook = panicService.selectByUID(bookId);
        if (pbook == null) {
            return new Exposer(false, bookId);
        }
        Date startTime = pbook.getStartTime();
        Date endTime = pbook.getEndTime();
        // 系统当前时间
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, bookId, nowTime, startTime, endTime);
        }
        return new Exposer(true, bookId);
    }
/**
 *秒杀执行
 */
    @Override
    public PanicExecution executePanic(String bookId, String userId) {
        Date date = new Date();
        Panic pbook = panicDao.selectByPrimaryKey(bookId);
        try {
            int updateTime = panicDao.reduceNumber(bookId, date);
            if (updateTime <= 0) {
                throw new PanicClose("Panic is close");
            } else {

                UserBook userBook = new UserBook(userId, bookId, pbook.getCurPrice(), 1, true, false, date, date);
                int insertCount = userBookDao.insert(userBook);
                if (insertCount <= 0) {
                    //重复秒杀
                    throw new RepetePanic("panic repeted");
                } else {
                    return new PanicExecution(bookId, PanicStatEnum.SUCCESS, userBook);
                }
            }
        } catch(PanicClose e1){
            throw e1;
        }catch (RepetePanic e2){
            throw e2;
        }catch (Exception e) {
            //throw  new PanicException("panic is error"+e.getMessage());
            throw new PanicException("panic inner error:" + e.getMessage());
        }
    }
}
