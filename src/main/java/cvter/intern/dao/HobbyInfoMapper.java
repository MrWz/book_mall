package cvter.intern.dao;

import cvter.intern.model.HobbyInfo;
import cvter.intern.model.HobbyInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HobbyInfoMapper {

    /**
     * 增加记录
     */
    int insert(HobbyInfo record);

    /**
     * 删除记录
     */
    int deleteByPrimaryKey(String uid);

    /**
     * 更新记录
     */
    int updateByPrimaryKey(HobbyInfo record);

    /**
     * 查询
     */
    HobbyInfo selectByPrimaryKey(String uid);

//    int insertSelective(HobbyInfo record);
//
//    List<HobbyInfo> selectByExample(HobbyInfoExample example);
//
//    int updateByExampleSelective(@Param("record") HobbyInfo record, @Param("example") HobbyInfoExample example);
//
//    int updateByExample(@Param("record") HobbyInfo record, @Param("example") HobbyInfoExample example);
//
//    int updateByPrimaryKeySelective(HobbyInfo record);
//
//    int countByExample(HobbyInfoExample example);
//
//    int deleteByExample(HobbyInfoExample example);

}