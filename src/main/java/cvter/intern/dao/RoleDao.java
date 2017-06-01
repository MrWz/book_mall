package cvter.intern.dao;

import cvter.intern.model.Role;

public interface RoleDao {

    int insert(Role record);

    int deleteByPrimaryKey(String uid);

    int updateByPrimaryKey(Role record);

    Role selectByPrimaryKey(String uid);

    Role selectByDescription(String description);

}