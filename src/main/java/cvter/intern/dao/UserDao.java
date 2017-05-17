package cvter.intern.dao;

import cvter.intern.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cvter on 2017/5/15.
 */
//@Repository
public interface UserDao {

    /**
     * 通过id查找用户
     *
     * @param id
     * @return
     */
    User selectById(@Param("id") int id);

    /**
     * 通过UID查找用户
     *
     * @param uid
     * @return
     */
    User selectByUid(@Param("uid") String uid);

    /**
     * 查找所有用户
     *
     * @return
     */
    List<User> selectAll();

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    int delete(User user);

    /**
     * 通过ID删除用户
     *
     * @param id
     * @return
     */
    int deleteById(@Param("id") int id);
}
