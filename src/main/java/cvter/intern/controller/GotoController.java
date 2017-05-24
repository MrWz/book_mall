package cvter.intern.controller;

import cvter.intern.authorization.annotation.Authorization;
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

    @RequestMapping
    public String index() {
        return "index";
    }


    @Authorization
    @RequestMapping(value = "/admin")
    public String adminIndex() {
        return "admin/manager";
    }


    @RequestMapping(value = "/admin/login")
    public String adminLogin() {
        return "admin/login";
    }

    @RequestMapping(value = "/book/detail")
    public String detail() {
        return "detail";
    }
}
