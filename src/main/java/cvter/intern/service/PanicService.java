package cvter.intern.service;

import cvter.intern.model.PanicInfo;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface PanicService {
    int save(PanicInfo record);

    int update(PanicInfo record);

    PanicInfo selectByUID(String uid);

    int deleteByUid(String uid);

    List<PanicInfo> selectAll();
}
