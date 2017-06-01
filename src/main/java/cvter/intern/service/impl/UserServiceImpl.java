package cvter.intern.service.impl;

import cvter.intern.authorization.manager.RedisTokenManager;
import cvter.intern.dao.*;
import cvter.intern.exception.BusinessException;
import cvter.intern.exception.ExceptionCode;
import cvter.intern.exception.ParameterException;
import cvter.intern.model.*;
import cvter.intern.service.UserService;
import cvter.intern.utils.*;
import cvter.intern.vo.BookInShopCar;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cvter.intern.exception.ExceptionCode.EX_10001;
import static cvter.intern.exception.ExceptionCode.EX_20008;
import static cvter.intern.exception.ExceptionCode.EX_20009;
import static cvter.intern.utils.RoleUtil.ROLE_1;
import static cvter.intern.utils.RoleUtil.ROLE_2;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserBookDao userBookDao;

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    RedisTokenManager redisTokenManager;

    @Autowired
    RedisLockUtil redisLockUtil;

    @Autowired
    private ShopCarDao shopCarDao;

    @Autowired
    private RedisCountHotBookUtil redisCountHotBookUtil;

    /**
     * 更新购物车
     *
     * @param userUid
     * @param bookUid
     * @param count
     * @return
     */
    @Override
    public Boolean updateShopCar(String userUid, String bookUid, int count) {
        boolean flag=StringUtils.isBlank(userUid);
        if (flag) {
            throw new ParameterException(EX_10001.getMessage());
        }

        ShopCar car=shopCarDao.selectByUuidAndBuid(userUid, bookUid, false);
        if (car != null) {
            if(count==0){
                --count;
            }
            int oldNum=car.getNums();
            int newNum=oldNum + count;
            car.setNums(newNum);
            car.setUpdateTime(new Date());
            shopCarDao.updateByPrimaryKey(car);
            return true;
        }
        return false;
    }

    /**
     * 删除购物车中指定的一本
     *
     * @param userUid
     * @param bookUid
     * @return
     */
    public Boolean deleteOneBook(String userUid, String bookUid) {
        boolean flag=StringUtils.isBlank(userUid);
        if (flag) {
            throw new ParameterException(EX_10001.getMessage());
        }
        ShopCar car=shopCarDao.selectByUuidAndBuid(userUid, bookUid, false);
        if (car != null) {
            car.setDeleted(true);
            car.setUpdateTime(new Date());
            shopCarDao.updateByPrimaryKey(car);
            return true;
        }
        return false;
    }

    /**
     * 清空购物车
     *
     * @param userUid
     * @return
     */
    @Override
    public Boolean clearShopCar(String userUid) {
        boolean flag=StringUtils.isBlank(userUid);
        if (flag) {
            throw new ParameterException(EX_10001.getMessage());
        }
        List<ShopCar> listShopCar=shopCarDao.selectByUseUid(userUid, false);

        Date date=new Date();
        for (int i=0; i < listShopCar.size(); ++i) {
            listShopCar.get(i).setDeleted(true);
            listShopCar.get(i).setUpdateTime(date);
            shopCarDao.updateByPrimaryKey(listShopCar.get(i));
        }
        return true;
    }

    /**
     * 获取用户的购物车信息
     *
     * @param userUid
     * @return
     */
    @Override
    public List<BookInShopCar> getShopCar(String userUid) {
        boolean flag=StringUtils.isAnyBlank(userUid);
        if (flag) {
            throw new ParameterException(EX_10001.getMessage());
        }
        List<BookInShopCar> bookList=new ArrayList(10);

        List<ShopCar> listShopCar=shopCarDao.selectByUseUid(userUid, false);
        if (listShopCar.isEmpty()) {//用户购物车为空
            return bookList;
        }

        for (int i=0; i < listShopCar.size(); ++i) {
            Book book=bookDao.selectByBookUid(listShopCar.get(i).getBookUid());
            String uid=book.getUid();
            String name=book.getName();
            String author=book.getAuthor();
            int price=book.getPrice();
            int nums=listShopCar.get(i).getNums();

            BookInShopCar bookInShopCar=new BookInShopCar(uid, name, author, price, nums);
            bookList.add(bookInShopCar);
        }
        return bookList;
    }

    /**
     * 添加购物车
     *
     * @param userUid
     * @param bookUid
     * @param nums
     * @return
     */
    @Override
    public Boolean addShopCar(String userUid, String bookUid, int nums) {
        boolean flag=StringUtils.isAnyBlank(userUid, bookUid);
        if (flag) {
            throw new ParameterException(EX_10001.getMessage());
        }
        Date date=new Date();

        ShopCar car=shopCarDao.selectByUuidAndBuid(userUid, bookUid, false);
        /**
         * 如果用户购物车中已经有该书且未被逻辑删除，则只更新数量和时间即可
         * 反之插入一条新的记录
         */
        if (car != null) {
            int newNums=car.getNums() + nums;
            car.setNums(newNums);
            car.setUpdateTime(date);
            shopCarDao.updateByPrimaryKey(car);
            return true;
        }
        ShopCar shopCar=new ShopCar(userUid, bookUid, nums, false, date, date);
        shopCarDao.insert(shopCar);

        return true;
    }

    /**
     * 购买图书(订单处理)
     *
     * @param userUid
     * @param bookUid
     * @param nums
     * @return
     */
    @Override
    public Boolean buy(String userUid, String bookUid, int nums) {
        Boolean flag=StringUtils.isAnyBlank(userUid, bookUid);
        if (flag) {
            throw new ParameterException(EX_10001.getMessage());
        }
        Date date=new Date();
        Book book=(Book) redisCountHotBookUtil.getInRedis(bookUid, Book.class);//在Redis中查询，未查询到，在去Mysql中查找。
        if (book == null) {
            Book bk=bookDao.selectByBookUid(bookUid);
            redisCountHotBookUtil.putRedis(bk, Book.class);
            book=bk;
        }
        boolean lockStatus=redisLockUtil.getLock("redisKey-" + book.getUid(), 3 * 1000);
        if (lockStatus) {
            book=(Book)redisCountHotBookUtil.getInRedis(bookUid, Book.class);
            int newStock=book.getStock() - nums;
            if (newStock < 0) {
                redisLockUtil.unLock("redisKey-" + book.getUid());
                return false;
            }
            book.setStock(newStock);
            book.setUpdateTime(date);
            bookDao.updateByPrimaryKey(book);
            /**
             *更新表之后，必须得更新缓存
             */
            redisCountHotBookUtil.putRedis(book, Book.class);
            redisLockUtil.unLock("redisKey-" + book.getUid());
        } else {
            throw new BusinessException(ExceptionCode.EX_20002.getCode(), ExceptionCode.EX_20002.getMessage());
        }

        deleteOneBook(userUid, bookUid);//将该商品从用户的购物车中去掉
        UserBook userBook=userBookDao.selectByUuidAndBuid(userUid, bookUid, false);
        /**
         * 如果用户购买表中已经有该书且未是通过正常通道购买而来，则只更新数量和时间即可
         * 反之，要构建一个新的记录插入数据库
         */
        if (userBook != null) {
            int newNums=userBook.getBuyNums() + nums;
            userBook.setBuyNums(newNums);
            userBook.setUpdateTime(date);
            userBookDao.updateByPrimaryKey(userBook);
            return true;
        }
        UserBook newUserBook=new UserBook(userUid, bookUid, book.getPrice(), nums, false, false, date, date);
        userBookDao.insert(newUserBook);
        return true;
    }

    /**
     * 验证登录是否成功
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Boolean checkLogin(String username, String password) {
        Boolean flag=StringUtils.isAnyBlank(username, password);
        if (flag) {
            throw new ParameterException(EX_10001.getMessage());
        }

        User user=(User) redisCountHotBookUtil.getInRedis(username, User.class);
        if (user == null) {
            User us=selectByName(username);
            redisCountHotBookUtil.putRedis(us, User.class);
            user=us;
        }
        if (user != null) {
            /**
             * 验证权限
             */
            String uid=user.getUid();
            UserRole userRole=userRoleDao.selectByUserUid(uid);
            Role role=roleDao.selectByPrimaryKey(userRole.getRoleUid());
            if (role.getDescription().equals(ROLE_1.getRole())) {//权限不对，抛出异常
                throw new BusinessException(ExceptionCode.EX_30001.getCode(), ExceptionCode.EX_30001.getMessage());
            }
            /**
             * 验证密码正确性
             */
            String mdPwd=user.getPassword();
            String mdPassword=Md5SaltUtil.getMD5(password, uid);
            if (mdPwd.equals(mdPassword)) {
                return true;
            }
            return false;////密码错误
        }
        return false;//用户不存在
    }

    /**
     * 验证注册是否成功
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public Boolean checkRegister(String username, String password) {
        Boolean flag=StringUtils.isAnyBlank(username, password);
        if (flag) {
            throw new ParameterException(EX_10001.getMessage());
        }

        String pt="^[0-9a-zA-Z]+$";
        boolean boolName=username.matches(pt);
        if (username.length() < 6 || username.length() > 15 || !boolName) {
            throw new ParameterException(EX_20008.getMessage());
        }
        boolean boolPwd=username.matches(pt);
        if (password.length() < 6 || password.length() > 15 || !boolPwd) {
            throw new ParameterException(EX_20009.getMessage());
        }

        Role role;
        UserRole userRole;
        User userInfo=(User) redisCountHotBookUtil.getInRedis(username, User.class);//在Redis中查询
        if (userInfo == null) {
            User us=selectByName(username);
            redisCountHotBookUtil.putRedis(us, User.class);
            userInfo=us;
        }
        if (userInfo == null) {//用户不存在
            String uid=UIDUtil.getRandomUID();
            String mdPassword=Md5SaltUtil.getMD5(password, uid);
            Date date=new Date();
            User user=new User(uid, username, mdPassword, false, date, date);
            save(user);

            redisCountHotBookUtil.putRedis(user, User.class);//用户注册后，将用户信息放到Redis中
            role=roleDao.selectByDescription(ROLE_2.getRole());
            String roleUid=role.getUid();

            userRole=new UserRole(uid, roleUid, false, date, date);
            userRoleDao.insert(userRole);

            return true;
        } else {//用户已存在
            return false;
        }
    }

    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }


    /**
     * 增加记录
     *
     * @param record
     * @return
     */
    public int save(User record) {
        return userDao.insert(record);
    }

    /*
     * 验证管理员登录
     * @param username  用户名
     * @param password  密码
     * @return
     */
    public boolean checkAdimLogin(String username, String password) {

        if (StringUtils.isAnyEmpty(username, password)) {
            throw new ParameterException("用户名或密码不为空");
        }
        User userInfo=userDao.selectByName(username);
        String uid=userInfo.getUid();
        UserRole userRole=userRoleDao.selectByUserUid(uid);
        Role role=roleDao.selectByPrimaryKey(userRole.getRoleUid());
        if (role.getDescription().equals(ROLE_2.getRole())) {//权限不对，抛出异常
            throw new BusinessException(ExceptionCode.EX_30001.getCode(), ExceptionCode.EX_30001.getMessage());
        }
        return Md5SaltUtil.getMD5(password, userInfo.getUid()).equals(userInfo.getPassword());
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return userDao.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(User record) {
        return userDao.updateByPrimaryKey(record);
    }

    /**
     * 查询
     */
    public User selectByUid(String uid) {
        return userDao.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<User> selectAll(int m, int n) {
        return userDao.selectAll(m, n);
    }
}
