package cvter.intern.service.impl;

import cvter.intern.dao.RoleDao;
import cvter.intern.model.Role;
import cvter.intern.service.RoleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    public RoleServiceImpl() {
        super();
    }

    /**
     * 增加记录
     */
    @Transactional(rollbackFor = Exception.class)
    public int save(Role role) {
        return roleDao.insert(role);
    }

    /**
     * 删除记录
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteByUid(String uid) {
        return roleDao.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    @Transactional(rollbackFor = Exception.class)
    public int update(Role role) {
        return roleDao.updateByPrimaryKey(role);
    }

    /**
     * 查询记录
     */
    public Role selectByUid(String uid) {
        return roleDao.selectByPrimaryKey(uid);
    }

    //分表查询
    public List<Role> selectAll() {
        return null;
    }
}
