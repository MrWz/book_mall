package cvter.intern.service.impl;

import cvter.intern.dao.*;
import cvter.intern.exception.BusinessException;
import cvter.intern.exception.ExceptionCode;
import cvter.intern.exception.ParameterException;
import cvter.intern.model.*;
import cvter.intern.service.UserService;
import cvter.intern.utils.Md5SaltUtil;
import cvter.intern.utils.RedisLock;
import cvter.intern.utils.UIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static cvter.intern.utils.RoleUtil.ROLE_1;
import static cvter.intern.utils.RoleUtil.ROLE_2;

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

//    @Autowired
//    RedisTemplate redisTemplate;

    /*
    * 购买图书(订单处理)
    * */
    @Override
    public Boolean buy(String userUid, String bookUid, int num) {
        Boolean flag=StringUtils.isAnyBlank(userUid, bookUid);
        if (flag) {
            throw new ParameterException();
        }

        Date date=new Date();
        Book book=bookDao.selectByPrimaryKey(bookUid);
//        RedisLock lock = new RedisLock(redisTemplate, "mykey", 10000, 20000);
//
//        try{
//            if(lock.lock()){
//                //需要同步代码
//            }
//        }catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//            lock.unlock();
//        }


        int newStock=book.getStock() - num;
        if (newStock < 0) {
            return false;
        }
        book.setStock(newStock);
        book.setUpdateTime(date);
        bookDao.updateByPrimaryKey(book);


        List<UserBook> userBookList=userBookDao.selectByUserUid(userUid);
        for(UserBook tmp:userBookList){
//            System.out.println("++++++++"+tmp.getBuyNums());
        }
        UserBook userBook=new UserBook(userUid, bookUid, book.getPrice(), num, false, false, date, date);

        userBookDao.insert(userBook);

        return true;
    }

    /*
         * 验证登录是否成功
         * */
    @Override
    public Boolean checkLogin(String username, String password) {
        Boolean flag=StringUtils.isAnyBlank(username, password);
        if (flag) {
            throw new ParameterException(ExceptionCode.EX_10001.getMessage());
        }
        User user=selectByName(username);
        if (user != null) {
             /*
            * 验证权限
            * */
            String uid=user.getUid();

            UserRole userRole=userRoleDao.selectByUserUid(uid);

            Role role=roleDao.selectByPrimaryKey(userRole.getRoleUid());
            if(role.getDescription().equals(ROLE_1.getRole())){//权限不对，抛出异常
                throw new BusinessException(ExceptionCode.EX_30001.getCode(),ExceptionCode.EX_30001.getMessage());
            }
            /*
            * 验证密码正确性
            * */
            String mdPwd=user.getPassword();
            String mdPassword=Md5SaltUtil.getMD5(password, uid);
            if (mdPwd.equals(mdPassword)) {
                return true;
            }
                return false;////密码错误
        }
        return false;//用户不存在
    }

        /*
         * 验证注册是否成功
         * */
    @Override
    public Boolean checkRegister(String username, String password) {
        Boolean flag=StringUtils.isAnyBlank(username, password);
        if (flag) {
            throw new ParameterException();
        }
        Role role;
        UserRole userRole;
        User userInfo=selectByName(username);
        if (userInfo == null) {//用户不存在
            String uid=UIDUtil.getRandomUID();
            String mdPassword=Md5SaltUtil.getMD5(password, uid);
            Date date=new Date();
            User user=new User(uid, username, mdPassword, false, date, date);
            save(user);

            role=roleDao.selectByDescription(ROLE_2.getRole());
            String roleUid=role.getUid();
            userRole=new UserRole(uid, roleUid, false, date, date);
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

    //        @Override
    public boolean checkAdimLogin(String username, String password) {


        if (StringUtils.isAnyEmpty(username, password)) {
            throw new ParameterException("用户名或密码不为空");
        }
        User userInfo=userDao.selectByName(username);

        if (password.equals(userInfo.getPassword())) {
            return true;
        }
        return false;
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
        User user=userDao.selectByPrimaryKey(uid);
        if (user != null && user.getName().equals(username) && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
