package cvter.intern.service;

import cvter.intern.model.RoleInfo;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface RoleService {
    public int save(RoleInfo record);
    RoleInfo selectByUID(String uid);
    int update(RoleInfo record);
    int deleteByUid(String uid);
    List<RoleInfo> selectAll();
}
