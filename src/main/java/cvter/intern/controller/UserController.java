package cvter.intern.controller;

import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.model.Msg;
import cvter.intern.model.User;
import cvter.intern.service.UserService;
import org.apache.commons.lang3.StringUtils;
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
        String loginStatus=(String)session.getAttribute("isLogin");
        if(!StringUtils.isEmpty(loginStatus)){
            if(StringUtils.equals(loginStatus,"true")){
                return Msg.fail().setMessage("您已登录一个帐号，注销后才可以登录另一个");
            }
        }
        System.out.println("----------------checkLogin pre"+username+password);
        boolean flag = userService.checkLogin(username, password);
        System.out.println("----------------checkLogin after"+flag);
        if (flag) {
            User user=userService.selectByName(username);
            session.setAttribute("isLogin", "true");
            session.setAttribute("userUid",user.getUid());
            return Msg.success().setMessage("请去首页进行选购").add("userinfo",user);

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

            return Msg.success().setMessage("注册成功").add("userinfo",userService.selectByName(username));

        } else {
            return Msg.fail().setMessage("用户名已存在");
        }
    }

    /*
    * 购买处理
    * */
    @Authorization
    @ResponseBody
    @RequestMapping(path = {"/buy"})
    public Msg buy(HttpSession session,String bookUid, int num){
        String userUid=(String)session.getAttribute("userUid");
//            if(StringUtils.isEmpty(userUid)){
//            System.out.println("----------------"+userUid);
//            return Msg.fail().setMessage("请您先去登录");
//        }
        boolean flag=userService.buy(userUid,bookUid,num);

        if(flag){
            return Msg.success().setMessage("购买成功");
        }
        return Msg.fail().setMessage("库存不足");
    }
    @Authorization
    @ResponseBody
    @RequestMapping(value = "/logoff", method = RequestMethod.POST)
    public Msg loginOff(HttpSession session) {
        session.removeAttribute("isLogin");

        return Msg.success().setMessage("注销成功");
    }
}
