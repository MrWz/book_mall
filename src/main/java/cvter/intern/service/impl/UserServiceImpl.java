package cvter.intern.service.impl;

import cvter.intern.dao.*;
import cvter.intern.exception.ParameterException;
import cvter.intern.model.*;
import cvter.intern.service.UserService;
import cvter.intern.utils.Md5SaltUtil;
import cvter.intern.utils.UIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserBookDao userBookDao;


    /*
    * 购买图书(订单处理)
    * */
    @Override
    public Boolean buy(String userUid, String bookUid,int num) {
        Boolean flag = StringUtils.isAnyBlank(userUid, bookUid);
        if (flag) {
            throw new ParameterException();
        }

        Date date=new Date();
        Book book=bookDao.selectByPrimaryKey(bookUid);

        int newStock=book.getStock()-num;
        if(newStock<0){
            return false;
        }
        book.setStock(newStock);
        book.setUpdateTime(date);
        bookDao.updateByPrimaryKey(book);

        UserBook userBook=new UserBook(userUid,bookUid,100,num,false,false,date,date);
        userBookDao.insert(userBook);

        return true;
    }

    /*
     * 验证登录是否成功
     * */
    @Override
    public Boolean checkLogin(String username, String password) {
        Boolean flag = StringUtils.isAnyBlank(username, password);
        if (flag) {
            throw new ParameterException();
        }
        User user = selectByName(username);
        if (user == null) {//用户不存在
            return false;
        } else {//用户已存在
            String mdPwd = user.getPassword();
            String uid = user.getUid();
            String mdPassword = Md5SaltUtil.getMD5(password, uid);
            if (mdPwd.equals(mdPassword)) {
                return true;
            } else {//密码错误
                return false;
            }
        }
    }

    /*
         * 验证注册是否成功
         * */
    @Override
    public Boolean checkRegister(String username, String password) {
        Boolean flag = StringUtils.isAnyBlank(username, password);
        if (flag) {
            throw new ParameterException();
        }
        Role role;
        UserRole userRole;
        User userInfo = selectByName(username);
        if (userInfo == null) {//用户不存在
            String uid = UIDUtil.getRandomUID();
            String mdPassword = Md5SaltUtil.getMD5(password, uid);
            Date date = new Date();
            User user = new User(uid, username, mdPassword, false, date, date);
            save(user);

            role = roleDao.selectByDescription("普通用户");
            String roleUid = role.getUid();
            userRole = new UserRole(uid, roleUid, false, date, date);
            userRoleDao.insert(userRole);

            return true;
        } else {//用户已存在
            return false;
        }
    }

    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }


    /**
     * 增加记录
     */

    public int save(User record) {
        return userDao.insert(record);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return userDao.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(User record) {
        return userDao.updateByPrimaryKey(record);
    }

    /**
     * 查询
     */
    public User selectByUid(String uid) {
        return userDao.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<User> selectAll(int m, int n) {
        return userDao.selectAll(m, n);
    }

    /**
     * 验证用户登录
     */
    public User checkAdminLogin(String uid, String username, String password) {
        User user = userDao.selectByPrimaryKey(uid);
        if (user != null && user.getName().equals(username) && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
