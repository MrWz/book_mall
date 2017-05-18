package cvter.intern.dao;

import cvter.intern.model.PanicInfo;
import cvter.intern.model.PanicInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PanicInfoMapper {

    /**
     * 增加记录
     */
    int insert(PanicInfo record);

    /**
     * 删除记录
     */
    int deleteByPrimaryKey(String uid);

    /**
     * 更新记录
     */
    int updateByPrimaryKey(PanicInfo record);

    /**
     * 查询
     */
    PanicInfo selectByPrimaryKey(String  uid);

//    int insertSelective(PanicInfo record);
//
//    List<PanicInfo> selectByExample(PanicInfoExample example);
//
//    int updateByExampleSelective(@Param("record") PanicInfo record, @Param("example") PanicInfoExample example);
//
//    int updateByExample(@Param("record") PanicInfo record, @Param("example") PanicInfoExample example);
//
//    int updateByPrimaryKey(PanicInfo record);
//
//    int countByExample(PanicInfoExample example);
//
//    int deleteByExample(PanicInfoExample example);

}