package cvter.intern.service.impl;

import cvter.intern.dao.UserInfoMapper;
import cvter.intern.model.UserInfo;
import cvter.intern.service.UserService;
import cvter.intern.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserInfoMapper userInfoMapper;


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

    @Override
    public boolean checkLogin(String username,String password) {
        /*if(username!=null){
            UserInfo userInfo=userInfoMapper.selectByName(username);
            System.out.println(userInfo.getPassword());
            if(MD5Util.verifyMD5(password,userInfo.getPassword())){
                return true;
            }
        }
        return false;*/
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
