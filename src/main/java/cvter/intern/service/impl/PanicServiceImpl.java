package cvter.intern.service.impl;

import cvter.intern.dao.PanicInfoMapper;
import cvter.intern.model.PanicInfo;
import cvter.intern.service.PanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service

public class PanicServiceImpl implements PanicService{

    @Autowired
    private PanicInfoMapper panicInfoMapper;

    /**
     * 增加记录
     */
    public int save(PanicInfo record)
    {
        return panicInfoMapper.insert(record);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return panicInfoMapper.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(PanicInfo record) {return panicInfoMapper.updateByPrimaryKey(record);}

    /**
     * 查询
     */
    public PanicInfo selectByUID(String uid) {
        return panicInfoMapper.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<PanicInfo> selectAll() {
        return null;
    }
}
