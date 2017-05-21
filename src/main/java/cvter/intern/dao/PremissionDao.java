package cvter.intern.dao;

import cvter.intern.model.Premission;

public interface PremissionDao {

    /**
     * 增加记录
     */
    int insert(Premission record);

    /**
     * 删除记录
     */
    int deleteByPrimaryKey(String uid);

    /**
     * 更新记录
     */
    int updateByPrimaryKey(Premission record);

    /**
     * 查找记录
     */
    Premission selectByPrimaryKey(String uid);

}