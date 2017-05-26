package cvter.intern.dao;

import cvter.intern.model.Panic;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

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

    int reduceNumber(@Param(value="uid")String uid, @Param(value="killTime") Date killTime);
    /**
     * 更新记录
     */
    int updateByPrimaryKey(Panic record);

    /**
     * 查询抢购对象
     */
    Panic selectByPrimaryKey(String  uid);

//    int insertSelective(Panic record);
//
//    List<Panic> selectByExample(PanicInfoExample example);
//
//    int updateByExampleSelective(@Param("record") Panic record, @Param("example") PanicInfoExample example);
//
//    int updateByExample(@Param("record") Panic record, @Param("example") PanicInfoExample example);
//
//    int updateByPrimaryKey(Panic record);
//
//    int countByExample(PanicInfoExample example);
//
//    int deleteByExample(PanicInfoExample example);

}