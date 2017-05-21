package cvter.intern.dao;

import cvter.intern.model.Role;
import cvter.intern.model.RoleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleDao {
    int countByExample(RoleInfoExample example);

    int deleteByExample(RoleInfoExample example);

    int deleteByPrimaryKey(String uid);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleInfoExample example);

    Role selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleInfoExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleInfoExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}