package cvter.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cvter on 2017/5/21.
 */
@Controller
@RequestMapping("/")
public class GotoController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

//    @RequestMapping(value = "/admin/Index",method= RequestMethod.GET)
//    public String adminLogin() {
//        System.out.println("++++++++++");
//        return "adminLogin";
//    }
//
//    @RequestMapping(value = "/admin/Index",method= RequestMethod.POST)
//    public String adminIndex() {
//        System.out.println("-------");
//        return "admin/manager";

}
