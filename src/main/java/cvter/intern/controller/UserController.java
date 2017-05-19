package cvter.intern.controller;

import cvter.intern.model.UserInfo;
import cvter.intern.service.UserService;
import cvter.intern.utils.MD5Util;
import cvter.intern.utils.UIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

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
    @RequestMapping("/login")
    public String login(ModelMap model, String username, String password){

        if(username!=null){
            
        }
        return "login";
    }
/*
* 注册处理
* */
    @RequestMapping("/register")
    public String register(ModelMap model, String username, String password){
        if(username!=null){

            String mdPassword=MD5Util.getMD5(password);
            Date date=new Date();

            UserInfo user=new UserInfo(999, UIDUtil.getRandomUID(),username,mdPassword,false,date,date);
            userService.save(user);

            System.out.println("======"+mdPassword);

            String pwd=userService.selectByName(username);
            System.out.println("======"+pwd);
        }
        return "register";
    }

}
