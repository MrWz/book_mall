package cvter.intern.dao;

import cvter.intern.model.Hobby;

public interface HobbyDao {

    /**
     * 增加记录
     */
    int insert(Hobby record);

    /**
     * 删除记录
     */
    int deleteByPrimaryKey(String uid);

    /**
     * 更新记录
     */
    int updateByPrimaryKey(Hobby record);

    /**
     * 查询
     */
    Hobby selectByPrimaryKey(String uid);

//    int insertSelective(Hobby record);
//
//    List<Hobby> selectByExample(HobbyInfoExample example);
//
//    int updateByExampleSelective(@Param("record") Hobby record, @Param("example") HobbyInfoExample example);
//
//    int updateByExample(@Param("record") Hobby record, @Param("example") HobbyInfoExample example);
//
//    int updateByPrimaryKeySelective(Hobby record);
//
//    int countByExample(HobbyInfoExample example);
//
//    int deleteByExample(HobbyInfoExample example);

}