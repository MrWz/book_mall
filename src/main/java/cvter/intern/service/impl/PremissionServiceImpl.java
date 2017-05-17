package cvter.intern.service.impl;

import cvter.intern.dao.PremissionInfoMapper;
import cvter.intern.model.PremissionInfo;
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
    private PremissionInfoMapper premissionInfoMapper;

    public PremissionServiceImpl() {
        super();
    }

    /**
     * 增加记录
     */
    public int save(PremissionInfo premissionInfo) {
        return premissionInfoMapper.insert(premissionInfo);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return premissionInfoMapper.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(PremissionInfo premissionInfo) {
        return premissionInfoMapper.updateByPrimaryKey(premissionInfo);
    }

    /**
     * 查询记录
     */public PremissionInfo selectByUid(String uid) {
        return premissionInfoMapper.selectByPrimaryKey(uid);
    }

    /**
     * 增加记录记录
     */public List<PremissionInfo> selectAll() {
        return null;
    }
}
