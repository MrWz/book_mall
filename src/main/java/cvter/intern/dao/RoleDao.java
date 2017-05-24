package cvter.intern.dao;

import cvter.intern.model.Role;
import cvter.intern.model.RoleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDao {

    int insert(Role record);

    int deleteByPrimaryKey(String uid);

    int updateByPrimaryKey(Role record);

    Role selectByPrimaryKey(String uid);

    Role selectByDescription(String description);

    int countByExample(RoleInfoExample example);

    int deleteByExample(RoleInfoExample example);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleInfoExample example);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleInfoExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleInfoExample example);

    int updateByPrimaryKeySelective(Role record);

}