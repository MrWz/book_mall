package cvter.intern.service;

import cvter.intern.model.RoleInfo;
import cvter.intern.model.UserInfo;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface UserService {
    public String selectByName(String name);
    public int save(UserInfo record);
    UserInfo selectByUid(String uid);
    int update(UserInfo record);
    int deleteByUid(String uid);
//    List<UserInfo> selectAll();
}
