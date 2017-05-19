package cvter.intern.service.impl;

import cvter.intern.dao.UserInfoMapper;
import cvter.intern.model.UserInfo;
import cvter.intern.service.UserService;
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
    /**
     * 增加记录
     */
    public int save(UserInfo record) {
        return userInfoMapper.insert(record);
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

    /**
     * 验证用户登录
     */
//    public UserInfo selectByUserAndPass(String username, String password) {
//        UserInfo userInfo=userInfoMapper.selectByPrimaryKey(username,password);
//        if(userInfo!=null&&userInfo.getName().equals(username)&&userInfo.getPassword().equals(password)){
//            return userInfo;
//        }
//        return null;
//    }
}
