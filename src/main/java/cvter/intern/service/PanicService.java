package cvter.intern.service;
import cvter.intern.model.Panic;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface PanicService {
    boolean save(Panic record);

    int update(Panic record);

    /**
     * 查询单个抢购记录
     */
    Panic selectByUID(String uid);

    int deleteByUid(String uid);

    /**
     * 查询所有抢购记录
     */
    List<Panic> selectAll();

    /**
     * 发布抢购
     */
    boolean bookPanic(int nums, int curPrice, String startTime, String endTime,String uid);

    /**
     * 执行秒杀操作
     */
    boolean executePanic(String bookId, String userId);
}
