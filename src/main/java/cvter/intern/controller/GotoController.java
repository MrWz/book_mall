package cvter.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 该Controller用于页面的跳转
 * <p>
 * Created by cvter on 2017/5/21.
 */
@Controller
@RequestMapping("/")
public class GotoController extends BaseController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


//    @RequestMapping(value = "/admin/index",method= RequestMethod.GET)
//    public String adminLogin() {
//        //System.out.println("++++++++++");
//        return "adminLogin";
//    }

    @RequestMapping(value = "/admin/index")
    public String adminIndex() {
        System.out.println("-------");
        return "admin/manager";
    }

    @RequestMapping(value = "/bookDetails",method = RequestMethod.GET)
    public String bookDetails(){
        return "detail";
    }
}
