package cvter.intern.service.impl;

import cvter.intern.dao.UserDao;
import cvter.intern.exception.ParameterException;
import cvter.intern.model.User;
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


    /*
         * 验证登录是否成功
         * */
    @Override
    public Boolean checkLogin(String username, String password) {
            User user =selectByName(username);


            if(user ==null){//用户不存在
                return false;
            } else{//用户已存在
                String mdPwd=user.getPassword();
                String uid=user.getUid();
                String mdPassword= Md5SaltUtil.getMD5(password,uid);
                if(mdPwd.equals(mdPassword)){
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
            User userInfo=selectByName(username);
            if(userInfo==null){//用户不存在
                String uid=UIDUtil.getRandomUID();
                String mdPassword= Md5SaltUtil.getMD5(password,uid);
                Date date=new Date();
                User user=new User(uid,username,mdPassword,false,date,date);
                save(user);
                return true;
            }
            else{//用户已存在
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


      if(StringUtils.isAnyEmpty(username,password)){
          throw new ParameterException("用户名或密码不为空");
      }
      User userInfo=userDao.selectByName(username);

      if(password.equals(userInfo.getPassword())){
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
    public List<User> selectAll(int m, int n) {return userDao.selectAll(m,n);}

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
