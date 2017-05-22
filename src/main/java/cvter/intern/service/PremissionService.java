package cvter.intern.service;

import cvter.intern.model.Premission;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface PremissionService {
    Premission selectByUid(String uid);

    List<Premission> selectAll();

    int save(Premission premission);

    int update(Premission premission);

    int deleteByUid(String uid);
}
