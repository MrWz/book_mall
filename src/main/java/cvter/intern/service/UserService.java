package cvter.intern.service;

import cvter.intern.model.User;

import java.util.List;

/**
 * Created by cvter on 2017/5/15.
 */
public interface UserService {

    User selectById(int id);

    User selectByUid(String uid);

    List<User> selectAll();

    int save(User user);

    int update(User user);

    int delete(User user);

    int deleteById(int id);
}
