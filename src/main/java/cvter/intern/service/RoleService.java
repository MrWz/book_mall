package cvter.intern.service;

import cvter.intern.model.RoleInfo;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface RoleService {

    int save(RoleInfo roleInfo);

    int deleteByUid(String uid);

    int update(RoleInfo roleInfo);

    RoleInfo selectByUid(String uid);

    List<RoleInfo> selectAll();
}
