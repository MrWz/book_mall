package cvter.intern.service;

import cvter.intern.model.User;

import java.util.List;

/**
 * Created by cvter on 2017/5/15.
 */
public interface UserService {

    User getByUid(String uid);

    List<User> getPaginate(int currentPage, int pageSize);

    int save(User user);

    int update(User user);

    int delete(User user);

    int deleteByUid(int uid);
}
