package cvter.intern.service.impl;

import cvter.intern.dao.UserDao;
import cvter.intern.model.User;
import cvter.intern.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cvter on 2017/5/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public User getByUid(String uid) {
        return userDao.getByUid(uid);
    }

    public List<User> getPaginate(int currentPage, int pageSize) {
        return userDao.getPaginate(currentPage, pageSize);
    }

    @Transactional(rollbackFor = Exception.class)
    public int save(User user) {
        return userDao.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public int update(User user) {
        return userDao.update(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(User user) {
        return userDao.delete(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public int deleteByUid(int uid) {
        return userDao.deleteByUid(uid);
    }
}