package cvter.intern.dao;

import cvter.intern.model.UserInfo;
import cvter.intern.model.UserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper {

    String selectByName(String name);

    int countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    /**
     * 增加记录
     */
    int insert(UserInfo record);

    /**
     * 删除记录
     */
    int deleteByPrimaryKey(String uid);

    /**
     * 更新记录
     */
    int updateByPrimaryKey(UserInfo record);

    /**
     * 查询
     */
    UserInfo selectByPrimaryKey(String uid);

//    int insertSelective(UserInfo record);
//
//    List<UserInfo> selectByExample(UserInfoExample example);
//
//    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);
//
//    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);
//
//    int updateByPrimaryKey(UserInfo record);
//
//    int countByExample(UserInfoExample example);
//
//    int deleteByExample(UserInfoExample example);

}