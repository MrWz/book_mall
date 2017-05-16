package cvter.intern.dao;

import cvter.intern.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cvter on 2017/5/15.
 */
@Repository
public interface UserDao {

    /**
     * 通过UID查找用户
     *
     * @param uid
     * @return
     */
    User getByUid(@Param("uid") String uid);

    /**
     * 查找所有用户
     *
     * @return
     */
    List<User> getPaginate(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

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
     * @param uid
     * @return
     */
    int deleteByUid(@Param("uid") int uid);
}
