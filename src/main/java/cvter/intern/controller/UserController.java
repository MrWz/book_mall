package cvter.intern.controller;

import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.model.Msg;
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

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Msg login(HttpSession session, String username, String password) {
        boolean flag = userService.checkLogin(username, password);
        if (flag) {
            session.setAttribute("isLogin", "true");
            return Msg.success().setMessage("请去首页进行选购").add("userinfo",userService.selectByName(username));

        } else {
            return Msg.fail().setMessage("用户名或者密码错误");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Msg register(HttpSession session, String username, String password) {
        boolean flag = userService.checkRegister(username, password);
        if (flag) {
            session.setAttribute("isLogin", "true");
            return Msg.success().setMessage("注册成功");

        } else {
            return Msg.fail().setMessage("用户名已存在");
        }
    }

    /*
    * 购买处理
    * */
    @ResponseBody
    @RequestMapping(path = {"/buy"})
    public Msg buy(String userUid,String bookUid,int num){

        boolean flag=userService.buy(userUid,bookUid,num);

        if(flag){
            return Msg.success().add("description","请您在15分钟内前往支付界面支付");
        }

        return Msg.fail().add("description","库存不足");
    }
    @Authorization
    @ResponseBody
    @RequestMapping(value = "/logoff", method = RequestMethod.POST)
    public Msg loginOff(HttpSession session) {
        session.removeAttribute("isLogin");

        return Msg.success().setMessage("注销成功");

    }
}
