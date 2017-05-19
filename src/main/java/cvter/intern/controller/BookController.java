package cvter.intern.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/book/v1")
public class BookController {
    @RequestMapping("/list")
    public String list(){
        return "list";
    }
}
