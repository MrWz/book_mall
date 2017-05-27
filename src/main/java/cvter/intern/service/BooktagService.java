package cvter.intern.service;

import cvter.intern.model.Booktag;
import cvter.intern.model.Role;

import java.util.List;

/**
 * Created by cvter on 2017/5/27.
 */
public interface BooktagService {

    int save(Booktag booktag);

    int deleteByUid(String uid);

    int update(Booktag booktag);

    Booktag selectByUid(String uid);

    List<Booktag> selectAll();
}
