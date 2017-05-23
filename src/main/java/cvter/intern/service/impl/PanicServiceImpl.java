package cvter.intern.service.impl;

import cvter.intern.dao.PanicDao;
import cvter.intern.model.Panic;
import cvter.intern.service.PanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service

public class PanicServiceImpl implements PanicService {

    @Autowired
    private PanicDao panicDao;

    /**
     * 增加记录
     */
    public int save(Panic record) {
        return panicDao.insert(record);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return panicDao.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(Panic record) {
        return panicDao.updateByPrimaryKey(record);
    }

    /**
     * 查询
     */
    public Panic selectByUID(String uid) {
        return panicDao.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<Panic> selectAll() {
        return null;
    }
}
