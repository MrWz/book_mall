package cvter.intern.service;

import cvter.intern.model.Role;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface RoleService {

    int save(Role role);

    int deleteByUid(String uid);

    int update(Role role);

    Role selectByUid(String uid);

    List<Role> selectAll();
}
