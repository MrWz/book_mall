package cvter.intern.service.impl;

import cvter.intern.dao.PanicDao;
import cvter.intern.exception.ParameterException;
import cvter.intern.model.Book;
import cvter.intern.model.Panic;
import cvter.intern.service.BookService;
import cvter.intern.service.PanicService;
import cvter.intern.utils.TIMEUtil;
import cvter.intern.utils.UIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.util.LuceneTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service

public class PanicServiceImpl implements PanicService{

    @Autowired
    private PanicDao panicDao;
    @Autowired
    private BookService bookService;
    @Resource
    private PanicService panicService;

    /**
     * 增加记录
     */
    public boolean save(Panic record)
    {
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
    public int update(Panic record) {return panicDao.updateByPrimaryKey(record);}

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


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean bookPanic(int nums,int curPrice,String startTime,String endTime,String uid) {

        Date date=new Date();
        Book book=bookService.selectByUid(uid);
        if(nums>book.getStock()) {
            return false;
        }
        book.setStock(book.getStock()-nums);
        book.setUpdateTime(date);
        bookService.update(book);

        Panic pbook=new Panic(nums,curPrice, TIMEUtil.strToDateLong(startTime),TIMEUtil.strToDateLong(endTime),date,date);
        pbook.setUid(UIDUtil.getRandomUID());
        return panicService.save(pbook);
    }
}
