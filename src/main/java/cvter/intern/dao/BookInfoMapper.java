package cvter.intern.dao;

import cvter.intern.model.BookInfo;

public interface BookInfoMapper {

    /**
     * 增加记录
     */
    int insert(BookInfo record);

    /**
     * 删除记录
     */
    int deleteByPrimaryKey(String uid);

    /**
     * 更新记录
     */
    int updateByPrimaryKey(BookInfo record);

    /**
     * 查询记录
     */
    BookInfo selectByPrimaryKey(String uid);

}