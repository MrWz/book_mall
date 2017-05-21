package cvter.intern.controller;

import cvter.intern.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/admin/v1")
public class AdminController extends BaseController {
    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "adminlogin";
    }

    @RequestMapping("/index")
    public String index() {

        //User userInfo=new User(3, UIDUtil.getRandomUID(),"admin","min", false,new Date(0),new Date(0));
        //  userService.save(userInfo);
        // userInfo=userService.checkAdminLogin(uid,)

        return "index";
    }
}
