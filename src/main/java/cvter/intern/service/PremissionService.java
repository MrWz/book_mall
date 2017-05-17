package cvter.intern.service;

import cvter.intern.model.PremissionInfo;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface PremissionService {
    PremissionInfo selectByUid(String uid);

    List<PremissionInfo> selectAll();

    int save(PremissionInfo premissionInfo);

    int update(PremissionInfo premissionInfo);

    int deleteByUid(String uid);
}
