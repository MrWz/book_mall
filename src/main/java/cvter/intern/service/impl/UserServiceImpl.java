package cvter.intern.service.impl;

import cvter.intern.dao.UserDao;
import cvter.intern.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cvter.intern.model.User;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cvter on 2017/5/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
//???
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User selectById(int id) {
        return userDao.selectById(id);
    }

    public User selectByUid(String uid) {
        return userDao.selectByUid(uid);
    }

    public List<User> selectAll() {
        return userDao.selectAll();
    }

    public int save(User user) {
        return userDao.save(user);
    }

    public int update(User user) {
        return userDao.update(user);
    }

    public int delete(User user) {
        return userDao.delete(user);
    }

    public int deleteById(int id) {
        return userDao.deleteById(id);
    }
}