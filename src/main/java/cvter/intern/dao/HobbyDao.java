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

}