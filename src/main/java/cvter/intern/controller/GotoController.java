package cvter.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @RequestMapping(value = "/book/panic")
    public String panic() {
        return "panic";
    }

    @RequestMapping(value = "/book/search")
    public String search() {
        return "result";
    }

    @RequestMapping(value = "/book/shopcar")
    public String shopCar() {
        return "shopcar";
    }
}
