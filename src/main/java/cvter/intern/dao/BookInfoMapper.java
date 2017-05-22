package cvter.intern.dao;

import cvter.intern.model.BookInfo;

import java.util.List;

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

    /**
     * 查询全部记录
     */
    List<BookInfo> selectAll(int m,int n);

}