package cvter.intern.dao;

import cvter.intern.model.UserRole;

public interface UserRoleDao {

    int insert(UserRole record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(UserRole record);

    UserRole selectByUserUid(String userUid);
}