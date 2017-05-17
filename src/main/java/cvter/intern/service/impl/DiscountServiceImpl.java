package cvter.intern.service.impl;

import cvter.intern.dao.DiscountInfoMapper;
import cvter.intern.model.DiscountInfo;
import cvter.intern.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class DiscountServiceImpl implements DiscountService{
    @Autowired
    private DiscountInfoMapper discountInfoMapper;

    public DiscountServiceImpl() {
        super();
    }

    public int save(DiscountInfo record) {
        return discountInfoMapper.insert(record);
    }

    public int update(DiscountInfo record) {
        return discountInfoMapper.updateByPrimaryKey(record);
    }

    public DiscountInfo selectByUID(String uid) {
        return discountInfoMapper.selectByPrimaryKey(uid);
    }

    public int deleteByUid(String uid) {
        return discountInfoMapper.deleteByPrimaryKey(uid);
    }

    public List<DiscountInfo> selectAll() {
        return null;
    }
}
