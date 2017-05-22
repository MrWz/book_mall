package cvter.intern.service.impl;

import cvter.intern.dao.PremissionDao;
import cvter.intern.model.Premission;
import cvter.intern.service.PremissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PremissionServiceImpl implements PremissionService {

    @Resource
    private PremissionDao premissionDao;

    public PremissionServiceImpl() {
        super();
    }

    /**
     * 增加记录
     */
    public int save(Premission premission) {
        return premissionDao.insert(premission);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return premissionDao.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(Premission premission) {
        return premissionDao.updateByPrimaryKey(premission);
    }

    /**
     * 查询记录
     */public Premission selectByUid(String uid) {
        return premissionDao.selectByPrimaryKey(uid);
    }

    /**
     * 增加记录记录
     */public List<Premission> selectAll() {
        return null;
    }
}
