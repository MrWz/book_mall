package cvter.intern.dao;

import cvter.intern.model.DiscountInfo;
import cvter.intern.model.DiscountInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiscountInfoMapper {

    /**
     * 增加记录
     */
    int insert(DiscountInfo record);

    /**
     * 删除记录
     */
    int deleteByPrimaryKey(String uid);

    /**
     * 更新记录
     */
    int updateByPrimaryKey(DiscountInfo record);

    /**
     * 查询
     */
    DiscountInfo selectByPrimaryKey(String uid);

//    int insertSelective(DiscountInfo record);
//
//    List<DiscountInfo> selectByExample(DiscountInfoExample example);
//
//    int updateByExampleSelective(@Param("record") DiscountInfo record, @Param("example") DiscountInfoExample example);
//
//    int updateByExample(@Param("record") DiscountInfo record, @Param("example") DiscountInfoExample example);
//
//    int updateByPrimaryKeySelective(DiscountInfo record);
//
//    int countByExample(DiscountInfoExample example);
//
//    int deleteByExample(DiscountInfoExample example);
}