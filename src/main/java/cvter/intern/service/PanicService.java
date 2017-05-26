package cvter.intern.service;

import cvter.intern.dto.Exposer;
import cvter.intern.dto.PanicExecution;
import cvter.intern.exception.PanicClose;
import cvter.intern.exception.PanicException;
import cvter.intern.exception.RepetePanic;
import cvter.intern.model.Book;
import cvter.intern.model.Panic;

import java.util.Date;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface PanicService {
    boolean save(Panic record);

    int update(Panic record);

    Panic selectByUID(String uid);

    int deleteByUid(String uid);

    List<Panic> selectAll();

    boolean bookPanic(int nums, int curPrice, String startTime, String endTime,String uid);

    /**
     * 秒杀开启时输出秒杀接口地址，否则输出系统时间和秒杀时间
     */

    Exposer exportPanicUrl(String bookId);

    /**
     * 执行秒杀操作
     */
    PanicExecution executePanic(String bookId, String userId);
    //throws PanicClose,RepetePanic,PanicException;
}
