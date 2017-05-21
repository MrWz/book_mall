package cvter.intern.dao;

import cvter.intern.model.UserRole;
import cvter.intern.model.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleDao {

    int insert(UserRole record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

//    int insertSelective(UserRole record);
//
//    List<UserRole> selectByExample(UserRoleExample example);
//
//    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);
//
//    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);
//
//    int updateByPrimaryKeySelective(UserRole record);
//
//    int countByExample(UserRoleExample example);
//
//    int deleteByExample(UserRoleExample example);

}