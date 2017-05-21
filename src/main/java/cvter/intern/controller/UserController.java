package cvter.intern.controller;

import cvter.intern.model.Msg;
import cvter.intern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/user/v1")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    /*
    * 登录处理
    * */
    @RequestMapping("/login")
    public Msg login(ModelMap model, String username, String password) {
        if (username != null) {
            boolean flag = userService.checkLogin(username, password);
            if (flag) {

                return Msg.success().add("description", "请去首页进行选购");
            } else {
                return Msg.fail().add("description", "用户名或者密码错误");
            }
        } else {
            return Msg.fail();
        }
    }

    /*
    * 注册处理
    * */
    @RequestMapping("/register")
    public String register(ModelMap model, String username, String password) {
        if (username != null) {

//            String mdPassword = Md5SaltUtil.getMD5(password, "uid");
//            Date date = new Date();
//
////            UserInfo user = new UserInfo(999, UIDUtil.getRandomUID(), username, mdPassword, false, date, date);
//            userService.save(user);
//
//            System.out.println("======" + mdPassword);
//
//            String pwd = userService.selectByName(username);
//            System.out.println("======" + pwd);
        }
        return "";
    }
}