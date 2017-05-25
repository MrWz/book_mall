package cvter.intern.controller;

import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.authorization.annotation.CurrentUser;
import cvter.intern.authorization.manager.TokenManager;
import cvter.intern.authorization.model.TokenModel;
import cvter.intern.authorization.util.Constants;
import cvter.intern.exception.BusinessException;
import cvter.intern.model.Book;
import cvter.intern.model.Msg;
import cvter.intern.model.User;
import cvter.intern.service.BookService;
import cvter.intern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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

    @Autowired
    private TokenManager tokenManager;

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

    @Authorization
    @ResponseBody
    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public Msg bookAdd(Book book) {
        if (bookService.save(book)) {
            return Msg.success().setMessage("图书上架成功");
        }
        return Msg.success().setMessage("图书上架失败");
    }

    @Authorization
    @ResponseBody
    @RequestMapping(value = "/book/del/{uids}", method = RequestMethod.DELETE)
    public Msg bookDel(@PathVariable String uids) {
        boolean flag = true;
        String[] uidArr = uids.split("-");
        for (int i = 0; i < uidArr.length; i++) {
            flag = bookService.bookDel(uids);
        }
        if (flag) {
            return Msg.success().setMessage("图书删除成功");
        }
        return Msg.success().setMessage("图书删除失败");
    }

    @Authorization
    @ResponseBody
    @RequestMapping(value = "/book/adjust", method = RequestMethod.PUT)
    public Msg bookAdjust(Book book) {
        bookService.bookAdjustPrice(book.getUid(), book.getPrice());
        bookService.bookAdjustStock(book.getUid(), book.getStock());

        return Msg.success().setMessage("图书信息更新成功");
    }

}
