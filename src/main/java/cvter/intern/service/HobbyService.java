package cvter.intern.service;

import cvter.intern.model.Hobby;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface HobbyService {
    public int save(Hobby record);

    Hobby selectByUID(String uid);

    int update(Hobby record);

    int deleteByUid(String uid);

    List<Hobby> selectAll();
}
