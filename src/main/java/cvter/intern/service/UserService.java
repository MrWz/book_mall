package cvter.intern.service;

import cvter.intern.model.User;

import java.util.List;

/**
 * Created by cvter on 2017/5/15.
 */
public interface UserService {

    List<User> getAllUser();

    User getUserByPhoneOrEmail(String emailOrPhone, Short state);

    User getUserById(Long userId);
}
