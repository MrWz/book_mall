package cvter.intern.service.impl;

import cvter.intern.dao.RoleInfoMapper;
import cvter.intern.model.RoleInfo;
import cvter.intern.service.RoleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleInfoMapper roleInfoMapper;

    public RoleServiceImpl() {
        super();
    }

    /**
     * 增加记录
     */
    public int save(RoleInfo roleInfo) {
        return roleInfoMapper.insert(roleInfo);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return roleInfoMapper.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(RoleInfo roleInfo) {
        return roleInfoMapper.updateByPrimaryKey(roleInfo);
    }

    /**
     * 查询记录
     */
    public RoleInfo selectByUid(String uid) {
        return roleInfoMapper.selectByPrimaryKey(uid);
    }

    //分表查询
    public List<RoleInfo> selectAll() {
        return null;
    }
}
