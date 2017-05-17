package cvter.intern.service.impl;

import cvter.intern.dao.RoleInfoMapper;
import cvter.intern.model.RoleInfo;
import cvter.intern.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleInfoMapper roleInfoMapper;

    public int save(RoleInfo record) {
        return roleInfoMapper.insert(record);
    }

    public int update(RoleInfo record) {
        return  roleInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByUid(String uid) {
        return roleInfoMapper.deleteByPrimaryKey(uid);
    }

    public List<RoleInfo> selectAll() {
        return null;
    }

    public RoleInfo selectByUID(String uid) {
        return roleInfoMapper.selectByPrimaryKey(uid);
    }

// int insertSelective(RoleInfo record);


}
