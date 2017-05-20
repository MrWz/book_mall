package cvter.intern.service.impl;

import cvter.intern.dao.UserInfoMapper;
import cvter.intern.model.UserInfo;
import cvter.intern.service.UserService;
import cvter.intern.utils.UIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserInfoMapper userInfoMapper;


    /*
         * 验证登录是否成功
         * */
    @Override
    public Boolean checkLogin(String username, String password) {
        if(username!=null){
            UserInfo userInfo=selectByName(username);
            if(userInfo==null){//用户不存在
                return false;
            } else{//用户已存在
                String mdPwd=userInfo.getPassword();
//                if(MD5Util.verifyMD5(password,mdPwd)){
//                    return true;
//                }
                if(password.equals(mdPwd)){
                    return true;
                }
                else{//密码错误
                    return false;
                }
            }
        }
        else{
            return false;
        }
    }

    /*
     * 验证注册是否成功
     * */
    @Override
    public Boolean checkRegister(String username, String password) {
        if(username!=null){
            UserInfo userInfo=selectByName(username);
            if(userInfo==null){//用户不存在
               // String mdPassword= MD5Util.getMD5(password);
                Date date=new Date();
                UserInfo user=new UserInfo(UIDUtil.getRandomUID(),username,password,false,date,date);
                save(user);
                return true;
            }
            else{//用户已存在
                System.out.println("======用户存在");
                return false;
            }
        }
        else{
            return false;
        }

    }

    @Override
    public UserInfo selectByName(String name) {
        return userInfoMapper.selectByName(name);
    }


    /**
     * 增加记录
     */

    public int save(UserInfo record) {
        return userInfoMapper.insert(record);
    }

//        @Override
public boolean checkAdimLogin(String username, String password) {
    UserInfo userInfo=userInfoMapper.selectByName(username);

        if(password.equals(userInfo.getPassword())){
            return true;
        }
        return false;
}
    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return userInfoMapper.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    /**
     * 查询
     */
    public UserInfo selectByUid(String uid) {
        return userInfoMapper.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<UserInfo> selectAll() {return null;}

}
