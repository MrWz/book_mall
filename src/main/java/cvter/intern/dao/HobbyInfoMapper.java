package cvter.intern.dao;

import cvter.intern.model.HobbyInfo;
import cvter.intern.model.HobbyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HobbyInfoMapper {
    int countByExample(HobbyInfoExample example);

    int deleteByExample(HobbyInfoExample example);

    int deleteByPrimaryKey(String uid);

    int insert(HobbyInfo record);

    int insertSelective(HobbyInfo record);

    List<HobbyInfo> selectByExample(HobbyInfoExample example);

    HobbyInfo selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") HobbyInfo record, @Param("example") HobbyInfoExample example);

    int updateByExample(@Param("record") HobbyInfo record, @Param("example") HobbyInfoExample example);

    int updateByPrimaryKeySelective(HobbyInfo record);

    int updateByPrimaryKey(HobbyInfo record);
}