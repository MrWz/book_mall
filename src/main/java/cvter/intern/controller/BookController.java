package cvter.intern.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.authorization.manager.TokenManager;
import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.service.IndexBookService;
import cvter.intern.lucene.service.impl.IndexBookServiceImpl;
import cvter.intern.model.Book;
import cvter.intern.model.Msg;
import cvter.intern.model.User;
import cvter.intern.service.UserService;
import cvter.intern.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/book/v1")
public class BookController extends BaseController {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private UserService userService;

    @Autowired
    TokenManager tokenManager;


    /**
     * 获取图书列表
     *
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Msg list(@RequestParam(defaultValue = "1") Integer pn,
                    @RequestParam(defaultValue = "7") Integer pageSize,
                    @RequestParam(defaultValue = "5") Integer navigatePages) {
        PageHelper.startPage(pn, pageSize);
        List<Book> allBook = bookService.selectAll();
        PageInfo page = new PageInfo(allBook, navigatePages);

        return Msg.success().add("page", page);
    }

    /**
     * 获取图书详情
     *
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/detail/{uid}", method = RequestMethod.GET)
    public Msg list(@PathVariable String uid) {
        Book book = bookService.selectByUid(uid);

        return Msg.success().add("book", book);
    }

    /**
     * 购买图书
     *
     * @param bookuid
     * @param nums
     * @return
     */
//    @Authorization
    @ResponseBody
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public Msg buy(HttpSession session,@RequestParam String bookuid, @RequestParam int nums) {
        User user = (User) session.getAttribute("user");
        boolean flag=userService.buy(user.getUid(),bookuid,nums);

        if(flag){
            return Msg.fail().setMessage("购买成功");
        }
        return Msg.fail().setMessage("库存不足");
    }

    /**
     * 获取购物车详情
     *
     * @param bookuid
     * @param nums
     * @return
     */
    @Authorization
    @ResponseBody
    @RequestMapping(value = "/shopcar", method = RequestMethod.GET)
    public Msg shopCarGet(HttpSession session,@RequestParam String bookuid, @RequestParam String nums) {
        User user=(User)session.getAttribute("user");
        List<Book> bookList=userService.getShopCar(user.getUid());

        if(bookList.size()==0){
            return Msg.fail().setMessage("购物车空空如也");
        }
        return Msg.success().add("bookList", bookList);
    }

    /**
     * 删除购物车
     *
     * @param bookuid
     * @param nums
     * @return
     */
//    @Authorization
    @ResponseBody
    @RequestMapping(value = "/shopcar", method = RequestMethod.DELETE)
    public Msg shopCarDelete(@RequestParam String bookuid, @RequestParam String nums) {

        return Msg.fail().setMessage("接口正在处理中");
    }

    /**
     * 更新购物车
     *
     * @param bookuid
     * @param nums
     * @return
     */
//    @Authorization
    @ResponseBody
    @RequestMapping(value = "/shopcar", method = RequestMethod.PUT)
    public Msg shopCarPut(@RequestParam String bookuid, @RequestParam String nums) {

        return Msg.fail().setMessage("接口正在处理中");
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
    @RequestMapping(value = "/shopcar", method = RequestMethod.POST)
    public Msg shopCarPost(HttpSession session,@RequestParam String bookuid, @RequestParam int nums) {

        User user=(User)session.getAttribute("user");
        boolean flag=userService.addShopCar(user.getUid(),bookuid,nums);
        if(flag){
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
    @RequestMapping(path = {"/search"})
    public Msg bookSearch(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(required = false) String params) throws Exception {
        params = URLDecoder.decode(params, "UTF-8");

        if (params == null || params.trim().length() == 0) {
            return Msg.fail().setMessage("传参错误");
        }

        IndexBookService indexBookService = new IndexBookServiceImpl();

        List<Book> authors = indexBookService.searchBookTopN(params, BookIndex.AUTHOR, 100);
        List<Book> names = indexBookService.searchBookTopN(params, BookIndex.NAME, 100);
        List<Book> description = indexBookService.searchBookTopN(params, BookIndex.DESCRIPTION, 100);

        List bookInfos = new ArrayList();
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
     * 图书抢购
     *
     * @param userUid
     * @param bookUid
     * @param tokenUid
     * @return
     */
    @Authorization
    @ResponseBody
    @RequestMapping(path = {"/panic"}, method = RequestMethod.POST)
    public Msg bookPanic(@RequestParam String userUid,
                         @RequestParam String bookUid,
                         @RequestParam String tokenUid) {

        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());

        return Msg.success().add("books", books);

    }
}
