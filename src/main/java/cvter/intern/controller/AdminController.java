package cvter.intern.controller;

import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.authorization.manager.TokenManager;
import cvter.intern.authorization.model.TokenModel;
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
import javax.servlet.http.HttpSession;

/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/admin/v1")
public class AdminController extends BaseController {

    @Resource
    private UserService userService;
    @Resource
    private BookService bookService;

    @Autowired
    TokenManager tokenManager;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Msg login(HttpSession session, @RequestParam String username, @RequestParam String password) {
        if (userService.checkAdimLogin(username, password)) {
            User user = userService.selectByName(username);
            // 生成一个 token，保存用户登录状态
            TokenModel model = tokenManager.createToken(user.getUid());
            session.setAttribute("UID", model.toString());
            session.setAttribute("user", user);
            return Msg.success().setMessage("您已登录成功");
        }
        throw new BusinessException(50000, "用户名或密码错误");
    }

    @Authorization
    @ResponseBody
    @RequestMapping(value = "/logoff", method = RequestMethod.POST)
    public Msg logoff(HttpSession session) {
        User user = (User) session.getAttribute("user");
        session.invalidate();

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
