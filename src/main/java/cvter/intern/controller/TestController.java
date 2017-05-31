package cvter.intern.controller;

import cvter.intern.model.Book;
import cvter.intern.model.Msg;
import cvter.intern.model.User;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cvter on 2017/5/27.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    @ResponseBody
    @RequestMapping("/testxss")
    public Msg testXSS(String xssStr) {
        System.out.println(xssStr);

        System.out.println(StringEscapeUtils.escapeHtml4(xssStr));
        return Msg.success().add("a", xssStr).add("b", StringEscapeUtils.escapeHtml4(xssStr));
    }

    @RequestMapping("/params")
    @ResponseBody
    public String params(@RequestParam String param) {
        System.out.println(param);
        return param;
    }

    @RequestMapping("/params/from/{from}/to/{to}")
    @ResponseBody
    public String params2(@PathVariable String from, @PathVariable String to) {
        System.out.println(from + "--" + to);
        return from + "--" + to;
    }

//    @RequestMapping(value = "/params/from/a/to/b", produces = "charset:")
//    @ResponseBody
//    public String params3() {
//        return "制造冲突";
//    }

    @ResponseBody
    @RequestMapping("/object")
    public String object(User user, Book book) {
        return user.toString() + "\n" + book.toString();
    }

//    @ResponseBody
//    @RequestMapping("/list")
//    public String list(UserListForm userListForm) {
//        return "userListForm size: " + userListForm.getUsers().size() + "\n"
//                + userListForm.toString();
//    }

    @ResponseBody
    @RequestMapping("/json")
    public String json(@RequestBody User user) {
        return "" + user;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String testDELETE(@RequestBody User user) {
        return "" + user;
    }

    @ResponseBody
    @RequestMapping("/header")
    public String header(@RequestHeader String uid) {
        return "uid->" + uid;
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("book")
    public void initBook(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("book.");
    }
}
