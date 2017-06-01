package cvter.intern.dao;

import cvter.intern.model.Panic;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PanicDao {

    /**
     * 增加记录
     */
    boolean insert(Panic record);

    /**
     * 删除记录
     */
    int deleteByPrimaryKey(String uid);

    /**
     * 减库存
     */
    int reduceNumber(@Param(value="uid") String uid, @Param(value="killTime") Date killTime);

    /**
     * 更新记录
     */
    int updateByPrimaryKey(Panic record);

    /**
     * 查询抢购对象
     */
    Panic selectByPrimaryKey(String uid);


    /**
     * 查询全部
     */
    List<Panic> selectAll();

}