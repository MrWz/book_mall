package cvter.intern.dao;

import cvter.intern.model.Discount;

public interface DiscountDao {

    /**
     * 增加记录
     */
    int insert(Discount record);

    /**
     * 删除记录
     */
    int deleteByPrimaryKey(String uid);

    /**
     * 更新记录
     */
    int updateByPrimaryKey(Discount record);

    /**
     * 查询
     */
    Discount selectByPrimaryKey(String uid);

}