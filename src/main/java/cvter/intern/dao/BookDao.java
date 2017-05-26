package cvter.intern.dao;

import cvter.intern.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {

    /**
     * 增加记录
     */
    boolean insert(Book record);

    /**
     * 删除记录
     */
    boolean deleteByPrimaryKey(String uid);

    /**
     * 更新记录
     */
    boolean updateByPrimaryKey(Book record);

    /**
     * 查询记录
     */
    Book selectByBookUid(String uid);

    /**
     * 分页查询记录
     */
    List<Book> selectByPaginate(@Param(value = "m") int m, @Param(value = "n") int n);

    /*
    * 查询全部记录
    * */
    List<Book> selectAll();

}