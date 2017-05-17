package cvter.intern.service;

import cvter.intern.model.HobbyInfo;
import cvter.intern.model.RoleInfo;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface HobbyService {
    public int save(HobbyInfo record);
    HobbyInfo selectByUID(String uid);
    int update(HobbyInfo record);
    int deleteByUid(String uid);
    List<HobbyInfo> selectAll();
}
