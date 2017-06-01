package cvter.intern.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.authorization.annotation.CurrentUser;
import cvter.intern.authorization.manager.TokenManager;
import cvter.intern.authorization.model.TokenModel;
import cvter.intern.authorization.util.Constants;
import cvter.intern.exception.BusinessException;
import cvter.intern.model.*;
import cvter.intern.service.BookService;
import cvter.intern.service.PanicService;
import cvter.intern.service.SaleService;
import cvter.intern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 管理员操作类
 */
@Controller
@RequestMapping("/admin/v1")
public class AdminController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private BookService bookService;
    @Resource
    private PanicService panicService;
    @Autowired
    private TokenManager tokenManager;
    @Resource
    private SaleService saleService;

    /**
     * 管理员登录
     *
     * @param response 响应头
     * @param username 用户名
     * @param password 密码
     * @return 响应实体 {@link Msg}
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Msg login(HttpServletResponse response,
                     @RequestParam String username,
                     @RequestParam String password) {
        if (userService.checkAdimLogin(username, password)) {
            User user = userService.selectByName(username);
            // 生成一个 token，保存用户登录状态
            TokenModel model = tokenManager.createToken(user.getUid());
            response.setHeader(Constants.AUTHORIZATION, model.toString());
            return Msg.success().setMessage("您已登录成功");
        }
        throw new BusinessException(50000, "用户名或密码错误");
    }

    /**
     * 管理员退出登录
     *
     * @param user 注入的当前用户信息
     * @return 响应实体 {@link Msg}
     */
    @Authorization
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.DELETE)
    public Msg logoff(@CurrentUser User user) {
        tokenManager.deleteToken(user.getUid());
        return Msg.success().setMessage("成功退出");
    }

    /**
     *管理员图书上架
     *
     * @param book  上架图书
     * @param bookType  图书类型
     * @return 响应实体 {@link Msg}
     */
    @Authorization
    @ResponseBody
    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public Msg bookAdd(Book book,String bookType) {
        if (bookService.save(book,bookType)) {
            return Msg.success().setMessage("图书上架成功");
        }
        return Msg.success().setMessage("图书上架失败");
    }

    /**
     * 管理员图书下架
     *
     * @param bookUid  图书UID
     * @return 响应实体 {@link Msg}
     */
    //@Authorization
    @ResponseBody
    @RequestMapping(value = "/book/del/{bookUid}", method = RequestMethod.DELETE)
    public Msg bookDel(@PathVariable String bookUid) {
        if (bookService.bookDel(bookUid)) {
            return Msg.success().setMessage("图书删除成功");
        }
        return Msg.success().setMessage("图书删除失败");
    }

    /**
     * 图书价格和库存调整
     *
     * @param book  要调整图书
     * @return 响应实体 {@link Msg}
     */
    @Authorization
    @ResponseBody
    @RequestMapping(value = "/book/adjust", method = RequestMethod.PUT)
    public Msg bookAdjust(Book book) {
        bookService.bookAdjustPrice(book.getUid(), book.getPrice());
        bookService.bookAdjustStock(book.getUid(), book.getStock());
        return Msg.success().setMessage("图书信息更新成功");
    }

    /**
     * 查看日销售统计表
     *
     * @param pn
     * @param pageSize
     * @param navigatePages
     * @return
     */
    //@Authorization
    @ResponseBody
    @RequestMapping(value = "/book/sale", method = RequestMethod.POST)
    public Msg bookSale(@RequestParam(defaultValue = "1") Integer pn,
                        @RequestParam(defaultValue = "7") Integer pageSize,
                        @RequestParam(defaultValue = "5") Integer navigatePages){
        PageHelper.startPage(pn, pageSize);
        List<SaleSum> saleSums=saleService.saleTable();
        saleService.save(saleSums);

        PageInfo page = new PageInfo(saleSums, navigatePages);
        return Msg.success().add("page",page);
    }

    /**
     * 查看总销售表
     *
     * @param pn
     * @param pageSize
     * @param navigatePages
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/book/saleAll", method = RequestMethod.POST)
    public Msg bookSaleAll(@RequestParam(defaultValue = "1") Integer pn,
                        @RequestParam(defaultValue = "7") Integer pageSize,
                        @RequestParam(defaultValue = "5") Integer navigatePages){
        PageHelper.startPage(pn, pageSize);
        List<Sale> allSale=saleService.selectAll();
        PageInfo page = new PageInfo(allSale, navigatePages);
        return Msg.success().add("page",page);
    }
    /**
     * 管理员发布图书抢购
     *
     * @param nums  数量
     * @param curPrice  抢购价格
     * @param startTime  抢购开始时间
     * @param endTime   抢购结束时间
     * @param uid  抢购书UID
     * @return 响应实体 {@link Msg}
     */
    @Authorization
    @ResponseBody
    @RequestMapping(value="/book/panic",method = RequestMethod.POST)
    public  Msg bookPanic(int nums,int curPrice,String startTime,String endTime, String uid){

        if(panicService.bookPanic(nums,curPrice,startTime,endTime,uid)){
            return Msg.success().setMessage("抢购发布成功");
        }
        return Msg.success().setMessage("抢购发布失败");
    }
}
