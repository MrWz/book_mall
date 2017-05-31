package cvter.intern.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.authorization.annotation.CurrentUser;
import cvter.intern.exception.BusinessException;
import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.service.IndexBookService;
import cvter.intern.model.Book;
import cvter.intern.model.Msg;
import cvter.intern.model.Panic;
import cvter.intern.model.User;
import cvter.intern.service.BookService;
import cvter.intern.service.PanicService;
import cvter.intern.service.UserService;
import cvter.intern.utils.RedisCountHotBookUtil;
import cvter.intern.utils.RedisTopTenUtil;
import cvter.intern.vo.BookInShopCar;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static cvter.intern.exception.ExceptionCode.EX_200003;
import static cvter.intern.exception.ExceptionCode.EX_20010;

/**
 * 图书Controller
 */
@Controller
@RequestMapping("/book/v1")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private IndexBookService indexBookService;

    @Autowired
    private RedisCountHotBookUtil redisCountHotBookUtil;

    @Autowired
    private RedisTopTenUtil redisTopTenUtil;

    @Autowired
    private PanicService panicService;

    /**
     * 获取图书列表
     *
     * @param pn            页码
     * @param pageSize      页大小
     * @param navigatePages 分页数量
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Msg list(@RequestParam(defaultValue="1") Integer pn,
                    @RequestParam(defaultValue="7") Integer pageSize,
                    @RequestParam(defaultValue="5") Integer navigatePages) {
        PageHelper.startPage(pn, pageSize);
        List<Book> allBook=bookService.selectAll();
        PageInfo page=new PageInfo(allBook, navigatePages);
        return Msg.success().add("page", page);
    }

    /**
     * 点击量前十图书(不够十本，全部返回)
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/hotBook")
    public Msg getTopTen() {
        Set<String> topTen=redisTopTenUtil.getInRedisTopTen();
        List<Book> topTenBook=new ArrayList(10);
        for (String bookUid : topTen) {
            Book book=(Book) redisCountHotBookUtil.getInRedis(bookUid, Book.class);//在Redis中查询，未查询到，在去Mysql中查找
            if (book == null) {
                Book bk=bookService.selectByUid(bookUid);
                redisCountHotBookUtil.putRedis(bk, Book.class);
                book=bk;
            }
            topTenBook.add(book);
        }
        Collections.reverse(topTenBook);
        return Msg.success().add("TOP-TEN", topTenBook);
    }

    /**
     * 获取图书详情
     *
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/detail/{uid}", method=RequestMethod.GET)
    public Msg list(@PathVariable String uid) {

        Book book=(Book) redisCountHotBookUtil.getInRedis(uid, Book.class);//在Redis中查询，未查询到，在去Mysql中查找

        redisTopTenUtil.putRedisTopTen(uid);//将图书id存到redis，统计热点图书。
        if (book == null) {
            Book bk=bookService.selectByUid(uid);
            redisCountHotBookUtil.putRedis(bk, Book.class);
            book=bk;
        }
        return Msg.success().add("book", book);
    }

    /**
     * 购买图书
     *
     * @param user
     * @param bookuid
     * @param nums
     * @return
     */
    @Authorization
    @ResponseBody
    @RequestMapping(value="/buy", method=RequestMethod.POST)
    public Msg buy(@CurrentUser User user, @RequestParam String bookuid, @RequestParam int nums) {
        boolean flag=userService.buy(user.getUid(), bookuid, nums);
        if (flag) {
            return Msg.success().setMessage("购买成功");
        }
        return Msg.fail().setMessage("库存不足");
    }

    /**
     * 获取购物车详情
     *
     * @param user
     * @return
     */
    @Authorization
    @ResponseBody
    @RequestMapping(value="/shopcar", method=RequestMethod.GET)
    public Msg shopCarGet(@CurrentUser User user) {
        List<BookInShopCar> bookList=userService.getShopCar(user.getUid());
        if (bookList.size() == 0) {
            return Msg.fail().setMessage("购物车空空如也");
        }
        return Msg.success().add("bookList", bookList);
    }

    /**
     * 清空购物车
     *
     * @param user
     * @param bookUid
     * @return
     */
    @Authorization
    @ResponseBody
    @RequestMapping(value="/shopcar/{bookUid}", method=RequestMethod.DELETE)
    public Msg shopCarDelete(@CurrentUser User user, @PathVariable String bookUid) {
        System.out.println(bookUid);
        /**
         * boouid为空就执行清空购物车
         * 反之，删除指定图书
         */
        if (!StringUtils.isEmpty(bookUid) && !"0".equals(bookUid)) {
            boolean flag=userService.deleteOneBook(user.getUid(), bookUid);
            if (flag) {
                return Msg.success().setMessage("删除成功");
            }
            return Msg.fail().setMessage("删除失败");
        }
        boolean flag=userService.clearShopCar(user.getUid());
        if (flag) {
            return Msg.success().setMessage("清空完毕");
        }
        return Msg.fail().setMessage("清空失败");
    }

    /**
     * 更新购物车
     *
     * @param user
     * @param bookuid
     * @param flag
     * @return
     */
    @Authorization
    @ResponseBody
    @RequestMapping(value="/shopcar", method=RequestMethod.PUT)
    public Msg shopCarPut(@CurrentUser User user, @RequestParam String bookuid, @RequestParam int flag) {
        boolean isTrue=userService.updateShopCar(user.getUid(), bookuid, flag);
        if (isTrue) {
            return Msg.success().setMessage("修改成功");
        }
        return Msg.success().setMessage("修改成功");
    }

    /**
     * 添加购物车
     *
     * @param bookuid
     * @param nums
     * @return
     */
    @Authorization
    @ResponseBody
    @RequestMapping(value="/shopcar", method=RequestMethod.POST)
    public Msg shopCarPost(@CurrentUser User user, @RequestParam String bookuid, @RequestParam String nums) {
        String pt="^[0-9]+$";
        boolean isNum=nums.matches(pt);
        if (!isNum) {
            throw new BusinessException(EX_20010.getCode(), EX_20010.getMessage());
        }
        int num=Integer.parseInt(nums);
        if (num <= 0) {
            throw new BusinessException(EX_200003.getCode(), EX_200003.getMessage());
        }
        boolean flag=userService.addShopCar(user.getUid(), bookuid, num);
        if (flag) {
            return Msg.success().setMessage("添加成功，尽快购买");
        }
        return Msg.fail().setMessage("添加失败");
    }


    /**
     * 图书搜索
     *
     * @param pn
     * @param pageSize
     * @param params
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(path={"/search"})
    public Msg bookSearch(
            @RequestParam(value="pn", defaultValue="1") Integer pn,
            @RequestParam(value="pageSize", defaultValue="5") Integer pageSize,
            @RequestParam(required=false) String params) throws Exception {
        params=URLDecoder.decode(params, "UTF-8");

        if (params == null || params.trim().length() == 0) {
            return Msg.fail().setMessage("传参错误");
        }
        List<Book> authors=indexBookService.searchBookTopN(params, BookIndex.AUTHOR, 100);
        List<Book> names=indexBookService.searchBookTopN(params, BookIndex.NAME, 100);
        List<Book> description=indexBookService.searchBookTopN(params, BookIndex.DESCRIPTION, 100);

        List bookInfos=new ArrayList();
        if (authors != null) {
            bookInfos.addAll(authors);
        }
        if (names != null) {
            bookInfos.addAll(names);
        }
        if (description != null) {
            bookInfos.addAll(description);
        }

        return Msg.success().add("bookList", bookInfos);

    }

    /**
     * 获取抢购图书列表
     *
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/panic/list", method = RequestMethod.POST)
    public Msg panicList(@RequestParam(defaultValue = "1") Integer pn,
                    @RequestParam(defaultValue = "7") Integer pageSize,
                    @RequestParam(defaultValue = "5") Integer navigatePages) {
        PageHelper.startPage(pn, pageSize);
        List<Panic> allPBook = panicService.selectAll();
        PageInfo page = new PageInfo(allPBook, navigatePages);
        return Msg.success().add("page", page);
    }

    /**
     * 获取抢购图书详情
     *
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/panic/detail/{uid}", method = RequestMethod.GET)
    public Msg panicDetil(@PathVariable String uid) {
        Panic panic = panicService.selectByUID(uid);
        return Msg.success().add("panic", panic);
    }

    /**
     * 图书抢购
     * @param bookUid
     * @param userUid
     * @return
     */
    // @Authorization
    @ResponseBody
        @RequestMapping(value="/panic", method = RequestMethod.POST)
        public Msg bookPanic(@RequestParam String bookUid,
                @RequestParam String userUid) {
            //@RequestParam String tokenUid
            if (panicService.executePanic(bookUid, userUid)) {
                return Msg.success().setMessage("抢购成功");
            }
            return Msg.success().setMessage("抢购失败");
    }
}
