package cvter.intern.controller;

import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.authorization.manager.TokenManager;
import cvter.intern.authorization.model.TokenModel;
import cvter.intern.model.Msg;
import cvter.intern.model.User;
import cvter.intern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/user/v1")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    TokenManager tokenManager;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Msg login(HttpSession session, String username, String password) {
        boolean flag = userService.checkLogin(username, password);
        if (flag) {
            User user = userService.selectByName(username);
            // 生成一个 token，保存用户登录状态
            TokenModel model = tokenManager.createToken(user.getUid());
            session.setAttribute("UID", model.toString());
            session.setAttribute("user", user);
            return Msg.success().setMessage("请去首页进行选购").add("userinfo", user);

        }
        return Msg.fail().setMessage("用户名或者密码错误");
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Msg register(HttpSession session, String username, String password) {
        boolean flag = userService.checkRegister(username, password);
        if (flag) {
            User user = userService.selectByName(username);
            // 生成一个 token，保存用户登录状态
            TokenModel model = tokenManager.createToken(user.getUid());
            session.setAttribute("UID", model.toString());
            session.setAttribute("user", user);
            return Msg.success().add("description", "注册成功");

        }
        return Msg.fail().add("description", "用户名已存在");
    }

    @Authorization
    @ResponseBody
    @RequestMapping(value = "/logoff", method = RequestMethod.POST)
    public Msg loginOff(HttpSession session) {

        User user = (User) session.getAttribute("user");
        tokenManager.deleteToken(user.getUid());

        return Msg.success().setMessage("注销成功");

    }
}
