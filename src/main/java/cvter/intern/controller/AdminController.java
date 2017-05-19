package cvter.intern.controller;

import cvter.intern.model.UserInfo;
import cvter.intern.service.UserService;
import cvter.intern.utils.TIMEUtil;
import cvter.intern.utils.UIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/admin/v1")
public class AdminController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "adminlogin";
    }

    @RequestMapping("/index")
    public String index(String user,String password){
        if(user.equals("admin")&&password.equals("123456")){
            return "index";
        }else{
            return "adminlogin";
        }
        //UserInfo userInfo=new UserInfo(3, UIDUtil.getRandomUID(),"admin","min", false,new Date(0),new Date(0));
        //userService.save(userInfo);
        // userInfo=userService.checkAdminLogin(uid,)



    }
}
