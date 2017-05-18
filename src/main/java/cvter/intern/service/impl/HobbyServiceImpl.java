package cvter.intern.service.impl;

import cvter.intern.dao.HobbyInfoMapper;
import cvter.intern.model.HobbyInfo;
import cvter.intern.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class HobbyServiceImpl implements HobbyService{
@Autowired
    private HobbyInfoMapper hobbyInfoMapper;

    /**
     * 增加记录
     */
    public int save(HobbyInfo record) {
        return hobbyInfoMapper.insert(record);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return hobbyInfoMapper.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(HobbyInfo record) {return hobbyInfoMapper.updateByPrimaryKey(record);}

    /**
     * 查询
     */
    public HobbyInfo selectByUID(String uid) {
        return hobbyInfoMapper.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<HobbyInfo> selectAll() {
        return null;
    }
}
