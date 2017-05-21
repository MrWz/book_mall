package cvter.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/admin/index")
    public String adminIndex() {
        return "admin/manager";
    }
}
