package cvter.intern.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cvter.intern.model.UserInfo;
import cvter.intern.service.UserService;
import cvter.intern.utils.Md5SaltUtil;
import cvter.intern.utils.UIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;

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
                //采用json返回数据
                HashMap data=new HashMap<String,String>();
                data.put("description","请去首页进行选购");

                JSONUtil myJson=new JSONUtil(200,"登录成功",data);
                String json= JSON.toJSONString(myJson);
                model.addAttribute("myJson",json);
                return "login";
            }
            else{
                //采用json返回数据
                HashMap data=new HashMap<String,String>();
                data.put("description","用户名或者密码错误");
                JSONUtil myJson=new JSONUtil(201,"登录失败",data);
                String json= JSON.toJSONString(myJson);
                model.addAttribute("myJson",json);
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

            String mdPassword= Md5SaltUtil.getMD5(password, "uid");
            Date date=new Date();

            UserInfo user=new UserInfo(999, UIDUtil.getRandomUID(),username,mdPassword,false,date,date);
            userService.save(user);

            System.out.println("======"+mdPassword);

            String pwd=userService.selectByName(username);
            System.out.println("======"+pwd);
        }
    }
}