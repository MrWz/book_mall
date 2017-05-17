package cvter.intern.dao;

import cvter.intern.model.PanicInfo;
import cvter.intern.model.PanicInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PanicInfoMapper {
    int countByExample(PanicInfoExample example);

    int deleteByExample(PanicInfoExample example);

    int deleteByPrimaryKey(String uid);

    int insert(PanicInfo record);

    int insertSelective(PanicInfo record);

    List<PanicInfo> selectByExample(PanicInfoExample example);

    PanicInfo selectByPrimaryKey(String  uid);

    int updateByExampleSelective(@Param("record") PanicInfo record, @Param("example") PanicInfoExample example);

    int updateByExample(@Param("record") PanicInfo record, @Param("example") PanicInfoExample example);

    int updateByPrimaryKeySelective(PanicInfo record);

    int updateByPrimaryKey(PanicInfo record);
}