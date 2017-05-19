package cvter.intern.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cvter.intern.model.UserInfo;
import cvter.intern.service.UserService;
import cvter.intern.utils.JSONUtil;
import cvter.intern.utils.MD5Util;
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
            boolean flag=userService.checkRegister(username,password);
            if(flag){
                //采用json返回数据
                HashMap data=new HashMap<String,String>();
                data.put("description","您已注册成功，请先去登录");
                JSONUtil myJson=new JSONUtil(202,"注册成功",data);
                String json= JSON.toJSONString(myJson);
                model.addAttribute("myJson",json);
                return "register";
            }
            else{
                //采用json返回数据
                HashMap data=new HashMap<String,String>();
                data.put("description","用户名已被占用，请换一个试试");
                JSONUtil myJson=new JSONUtil(203,"注册失败",data);
                String json= JSON.toJSONString(myJson);
                model.addAttribute("myJson",json);
                return "register";
            }
        }
        else{
            return "register";
        }
    }
}
