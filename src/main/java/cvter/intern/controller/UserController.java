package cvter.intern.controller;

import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.authorization.annotation.CurrentUser;
import cvter.intern.authorization.manager.TokenManager;
import cvter.intern.authorization.model.TokenModel;
import cvter.intern.authorization.util.Constants;
import cvter.intern.model.Msg;
import cvter.intern.model.User;
import cvter.intern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户操作类
 */
@Controller
@RequestMapping("/user/v1")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenManager tokenManager;

    /**
     * 用户登录
     *
     * @param response 响应头
     * @param username 用户名
     * @param password 密码
     * @return 响应实体 {@link Msg}
     */
    @ResponseBody
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public Msg login(HttpServletResponse response, String username, String password) {
        boolean flag=userService.checkLogin(username, password);
        if (flag) {
            User user=userService.selectByName(username);
            // 生成一个 token，保存用户登录状态
            TokenModel model=tokenManager.createToken(user.getUid());
            response.setHeader(Constants.AUTHORIZATION, model.toString());
            response.setHeader("username", user.getName());
            return Msg.success().setMessage("请去首页进行选购").add("userinfo", user);
        }
        return Msg.fail().setMessage("用户名或者密码错误");
    }

    /**
     * 用户注册
     *
     * @param response 响应头
     * @param username 用户名
     * @param password 密码
     * @return 响应实体 {@link Msg}
     */
    @ResponseBody
    @RequestMapping(value="/login", method=RequestMethod.PUT)
    public Msg register(HttpServletResponse response, String username, String password) {
        boolean flag=userService.checkRegister(username, password);
        if (flag) {
            User user=userService.selectByName(username);
            // 生成一个 token，保存用户登录状态
            TokenModel model=tokenManager.createToken(user.getUid());
            response.setHeader(Constants.AUTHORIZATION, model.toString());
            response.setHeader("username", user.getName());
            return Msg.success().setMessage("注册成功").add("userinfo", user);
        }
        return Msg.fail().setMessage("用户名已存在");
    }

    /**
     * 用户退出登录
     *
     * @param user 注入的当前用户信息
     * @return 响应实体 {@link Msg}
     */
    @Authorization
    @ResponseBody
    @RequestMapping(value="/login", method=RequestMethod.DELETE)
    public Msg loginOff(@CurrentUser User user) {
        tokenManager.deleteToken(user.getUid());
        return Msg.success().setMessage("注销成功");

    }
}
