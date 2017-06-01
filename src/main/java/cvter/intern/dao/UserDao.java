package cvter.intern.dao;

import cvter.intern.model.User;

import java.util.List;

public interface UserDao {

    User selectByName(String name);

    /**
     * 增加记录
     */
    int insert(User record);

    /**
     * 删除记录
     */
    int deleteByPrimaryKey(String uid);

    /**
     * 更新记录
     */
    int updateByPrimaryKey(User record);

    /**
     * 查询
     */
    User selectByPrimaryKey(String uid);

    /**
     * 查询全部
     */
    List<User> selectAll(int m, int n);

}