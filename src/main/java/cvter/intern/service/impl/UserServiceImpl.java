package cvter.intern.service.impl;

import cvter.intern.dao.UserInfoMapper;
import cvter.intern.model.RoleInfo;
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

    @Override
    public String selectByName(String name) {
        return userInfoMapper.selectByName(name);
    }

    public int save(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    public UserInfo selectByUid(String uid) {
        return userInfoMapper.selectByPrimaryKey(uid);
    }

    public int update(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByUid(String uid) {
        return userInfoMapper.deleteByPrimaryKey(uid);
    }

//    public List<UserInfo> selectAll() {
//        return userInfoMapper.selectAll();
//    }
}
