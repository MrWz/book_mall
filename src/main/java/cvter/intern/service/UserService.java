package cvter.intern.service;
import cvter.intern.model.User;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface UserService {

    public Boolean buy(String userUid,String bookUid,int num);

    public Boolean checkLogin(String username,String password);

    public Boolean checkRegister(String username,String password);

    public User selectByName(String name);

    public int save(User record);

    public boolean checkAdimLogin(String username,String password);

    User selectByUid(String uid);

    int update(User record);

    int deleteByUid(String uid);

    List<User> selectAll(int m, int n);
}
