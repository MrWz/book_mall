package cvter.intern.controller;

import cvter.intern.model.Msg;
import cvter.intern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/user/v1")
public class UserController {
    @Autowired
    UserService userService;

    /*
    * 登录处理
    * */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Msg login(ModelMap model, String username, String password) {
        boolean flag = userService.checkLogin(username, password);
        if (flag) {
            return Msg.success().add("description", "请去首页进行选购");

        } else {
            return Msg.fail().add("description", "用户名或者密码错误");
        }
    }
    /*
    * 注册处理
    * */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Msg register(ModelMap model, String username, String password) {
        boolean flag = userService.checkRegister(username, password);
        if (flag) {
            return Msg.success().add("description", "注册成功");

        } else {
            return Msg.fail().add("description", "用户名已存在");
        }
    }
}
