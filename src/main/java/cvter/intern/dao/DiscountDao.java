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

//    int insertSelective(Discount record);
//
//    List<Discount> selectByExample(DiscountInfoExample example);
//
//    int updateByExampleSelective(@Param("record") Discount record, @Param("example") DiscountInfoExample example);
//
//    int updateByExample(@Param("record") Discount record, @Param("example") DiscountInfoExample example);
//
//    int updateByPrimaryKeySelective(Discount record);
//
//    int countByExample(DiscountInfoExample example);
//
//    int deleteByExample(DiscountInfoExample example);
}