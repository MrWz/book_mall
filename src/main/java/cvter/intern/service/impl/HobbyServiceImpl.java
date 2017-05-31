package cvter.intern.service.impl;

import cvter.intern.dao.HobbyDao;
import cvter.intern.model.Hobby;
import cvter.intern.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class HobbyServiceImpl implements HobbyService {

    @Autowired
    private HobbyDao hobbyDao;

    /**
     * 增加记录
     */
    @Transactional(rollbackFor = Exception.class)
    public int save(Hobby record) {
        return hobbyDao.insert(record);
    }

    /**
     * 删除记录
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteByUid(String uid) {
        return hobbyDao.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    @Transactional(rollbackFor = Exception.class)
    public int update(Hobby record) {
        return hobbyDao.updateByPrimaryKey(record);
    }

    /**
     * 查询
     */
    public Hobby selectByUID(String uid) {
        return hobbyDao.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<Hobby> selectAll() {
        return null;
    }
}
