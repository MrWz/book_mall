package cvter.intern.service;

import cvter.intern.model.Panic;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface PanicService {
    int save(Panic record);

    int update(Panic record);

    Panic selectByUID(String uid);

    int deleteByUid(String uid);

    List<Panic> selectAll();
}
