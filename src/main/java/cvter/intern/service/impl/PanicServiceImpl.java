package cvter.intern.service.impl;
import cvter.intern.dao.PanicDao;
import cvter.intern.dao.UserBookDao;
import cvter.intern.exception.BusinessException;
import cvter.intern.exception.ExceptionCode;
import cvter.intern.exception.ParameterException;
import cvter.intern.model.Book;
import cvter.intern.model.Panic;
import cvter.intern.model.UserBook;
import cvter.intern.service.BookService;
import cvter.intern.service.PanicRedis;
import cvter.intern.service.PanicService;
import cvter.intern.utils.RedisLockUtil;
import cvter.intern.utils.TimeUtil;
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
public class PanicServiceImpl implements PanicService {

    @Autowired
    private PanicDao panicDao;
    @Autowired
    private BookService bookService;
    @Resource
    private PanicService panicService;
    @Autowired
    private UserBookDao userBookDao;
    @Autowired
    private PanicRedis panicRedis;
    @Autowired
    RedisLockUtil redisLockUtil;
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
        return panicDao.selectAll();
    }

    /**
     * 发布抢购
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean bookPanic(int nums, int curPrice, String startTime, String endTime, String uid) {

        if(StringUtils.isAnyEmpty(nums+"",curPrice+"",startTime,endTime,uid)){
            throw new ParameterException("参数为空");
        }
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
        panicService.save(pbook);
        panicRedis.putPanic(pbook);
        return true;
    }

    /**
    *秒杀执行
    */
    @Transactional(rollbackFor = Exception.class)
    public boolean executePanic(String bookId, String userId){
        if(StringUtils.isAnyEmpty(bookId,userId)){
            throw new ParameterException("参数为空");
        }
    //缓存优化
    //1.访问redis
    Panic pbook= panicRedis.getPanic(bookId);
    if(pbook==null){
        //访问数据库
        pbook = panicDao.selectByPrimaryKey(bookId);
        if(pbook==null){
            throw new BusinessException(ExceptionCode.EX_20005.getCode(), ExceptionCode.EX_20005.getMessage());
        }else{
            panicRedis.putPanic(pbook);
        }
    }
        UserBook userBookHave=userBookDao.selectByUuidAndBuid(userId,bookId,true);
        if(userBookHave!=null){
            //重复抢购
            throw new BusinessException(ExceptionCode.EX_20003.getCode(), ExceptionCode.EX_20003.getMessage());
        }
        Date date = new Date();
        boolean lockStatus=redisLockUtil.getLock("redisKey-"+bookId,3*1000 );
        if(lockStatus){
            int updateTime = panicDao.reduceNumber(bookId, date);
            if (updateTime <= 0) {
                //抢购失败
                redisLockUtil.unLock("redisKey-"+bookId);
                throw new BusinessException(ExceptionCode.EX_20007.getCode(), ExceptionCode.EX_20007.getMessage());
            }
        }
        UserBook userBook = new UserBook(userId, bookId, pbook.getCurPrice(), 1, true, false, date, date);
        userBookDao.insert(userBook);
        redisLockUtil.unLock("redisKey-"+bookId);
        return true;
    }
}
