package cvter.intern.service.impl;

import cvter.intern.dao.DiscountDao;
import cvter.intern.model.Discount;
import cvter.intern.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountDao discountDao;

    /**
     * 增加记录
     */
    public int save(Discount record) {
        return discountDao.insert(record);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return discountDao.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(Discount record) {
        return discountDao.updateByPrimaryKey(record);
    }

    /**
     * 查询
     */
    public Discount selectByUID(String uid) {
        return discountDao.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<Discount> selectAll() {
        return null;
    }
}
