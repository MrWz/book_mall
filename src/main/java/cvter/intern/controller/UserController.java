package cvter.intern.controller;

import cvter.intern.model.User;
import cvter.intern.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cvter on 2017/5/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(Model model) {
        log.info("查询所有用户信息");
        List<User> userList = userService.getPaginate(1, 4);
        log.info("users = {}" + userList);
        model.addAttribute("userList", userList);
        return "showUser";
    }
}
