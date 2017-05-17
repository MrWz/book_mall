package cvter.intern.service.impl;

import cvter.intern.dao.HobbyInfoMapper;
import cvter.intern.model.HobbyInfo;
import cvter.intern.model.RoleInfo;
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

    public int save(HobbyInfo record) {
        return hobbyInfoMapper.insert(record);
    }

    public HobbyInfo selectByUID(String uid) {
        return hobbyInfoMapper.selectByPrimaryKey(uid);
    }

    public int update(HobbyInfo record) {
        return hobbyInfoMapper.updateByPrimaryKey(record);
    }

    public int deleteByUid(String uid) {
        return hobbyInfoMapper.deleteByPrimaryKey(uid);
    }

    public List<HobbyInfo> selectAll() {
        return null;
    }
}
