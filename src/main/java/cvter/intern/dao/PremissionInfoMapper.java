package cvter.intern.dao;

import cvter.intern.model.PremissionInfo;

public interface PremissionInfoMapper {

    /**
     * 增加记录
     */
    int insert(PremissionInfo record);

    /**
     * 删除记录
     */
    int deleteByPrimaryKey(String uid);

    /**
     * 更新记录
     */
    int updateByPrimaryKey(PremissionInfo record);

    /**
     * 查找记录
     */
    PremissionInfo selectByPrimaryKey(String uid);

}