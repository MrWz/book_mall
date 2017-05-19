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

    /**
     * 增加记录
     */
    public int save(DiscountInfo record) {
        return discountInfoMapper.insert(record);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return discountInfoMapper.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(DiscountInfo record) {
        return discountInfoMapper.updateByPrimaryKey(record);
    }

    /**
     * 查询
     */
    public DiscountInfo selectByUID(String uid) {
        return discountInfoMapper.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<DiscountInfo> selectAll() {
        return null;
    }
}
