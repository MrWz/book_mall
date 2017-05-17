package cvter.intern.dao;

import cvter.intern.model.PremissionInfo;
import cvter.intern.model.PremissionInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PremissionInfoMapper {

    int insert(PremissionInfo record);

    int deleteByPrimaryKey(String uid);

    int updateByPrimaryKey(PremissionInfo record);

    PremissionInfo selectByPrimaryKey(String uid);

    //int countByExample(PremissionInfoExample example);

    //int deleteByExample(PremissionInfoExample example);

    //int insertSelective(PremissionInfo record);

    //List<PremissionInfo> selectByExample(PremissionInfoExample example);

    //int updateByExampleSelective(@Param("record") PremissionInfo record, @Param("example") PremissionInfoExample example);

    //int updateByExample(@Param("record") PremissionInfo record, @Param("example") PremissionInfoExample example);

    //int updateByPrimaryKeySelective(PremissionInfo record);

}