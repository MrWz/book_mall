package cvter.intern.dao;

import cvter.intern.model.DiscountInfo;
import cvter.intern.model.DiscountInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiscountInfoMapper {
    int countByExample(DiscountInfoExample example);

    int deleteByExample(DiscountInfoExample example);

    int deleteByPrimaryKey(String uid);

    int insert(DiscountInfo record);

    int insertSelective(DiscountInfo record);

    List<DiscountInfo> selectByExample(DiscountInfoExample example);

    DiscountInfo selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") DiscountInfo record, @Param("example") DiscountInfoExample example);

    int updateByExample(@Param("record") DiscountInfo record, @Param("example") DiscountInfoExample example);

    int updateByPrimaryKeySelective(DiscountInfo record);

    int updateByPrimaryKey(DiscountInfo record);
}