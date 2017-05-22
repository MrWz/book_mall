package cvter.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/admin/index")
    public String adminIndex() {
        return "admin/manager";
    }

    @RequestMapping("/bookDetails")
    public String bookDetails(){
        return "detail";
    }

}
