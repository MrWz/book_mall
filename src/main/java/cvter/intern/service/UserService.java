package cvter.intern.service;
import cvter.intern.model.Book;
import cvter.intern.model.User;
import cvter.intern.vo.BookInShopCar;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface UserService {
    Boolean updateShopCar(String userUid,String bookUid,int count);

    Boolean deleteOneBook(String userUid,String bookUid);

    Boolean clearShopCar(String userUid);

    List<BookInShopCar> getShopCar(String userUid);

    Boolean addShopCar(String userUid,String bookUid,int nums);

    Boolean buy(String userUid,String bookUid,int nums);

    Boolean checkLogin(String username,String password);

    Boolean checkRegister(String username,String password);

    User selectByName(String name);

    int save(User record);

    boolean checkAdimLogin(String username,String password);

    User selectByUid(String uid);

    int update(User record);

    int deleteByUid(String uid);

    List<User> selectAll(int m, int n);
}
