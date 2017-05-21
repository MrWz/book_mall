package cvter.intern.controller;

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
public class UserController {
    @Autowired
    UserService userService;
/*
* 登录处理
* */
    @RequestMapping("/login")
    public String login(ModelMap model, String username, String password){
        if(username!=null){
            boolean flag=userService.checkLogin(username,password);
            if(flag){

                return "login";
            }
            else{
                //采用json返回数据

                return "login";
            }
        }
        else{
            return "login";
        }
    }
/*
* 注册处理
* */
    @RequestMapping("/register")
    public String register(ModelMap model, String username, String password){

        if(username!=null){

            boolean flag=userService.checkRegister(username,password);
            if(flag){

                return "register";
            }
            else{

                return "register";
            }
        }
        else{
            return "register";
        }
    }
}
