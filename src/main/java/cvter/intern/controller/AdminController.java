package cvter.intern.controller;

import cvter.intern.exception.BusinessException;
import cvter.intern.model.Book;
import cvter.intern.model.Msg;
import cvter.intern.service.BookService;
import cvter.intern.service.UserService;
import cvter.intern.utils.UIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/admin/v1")
public class AdminController extends BaseController {
    @Resource
    private UserService userService;
    @Resource
    private BookService bookService;

    @RequestMapping(value = "/login",method= RequestMethod.GET)
    public String adminLogin() {
        return "adminLogin";
    }

    @ResponseBody
    @RequestMapping("/Index")
    public Msg index(String username, String password) {
        boolean flag=userService.checkAdimLogin(username, password);
        if (flag) {
            return Msg.success().add("description","您已登录成功");
        }
        throw new BusinessException(50000,"用户名或密码错误");
           // return Msg.fail().add("description","用户名或密码错误");
    }
    @RequestMapping(value = "/book/add",method = RequestMethod.GET)
    public String bookAdd() {
    return "bookAdd";
}
    @ResponseBody
    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public Msg bookAdd(@RequestParam String name, @RequestParam String author, @RequestParam int price,
                       @RequestParam int stock,String description){
        Date date=new Date();
        Book bookInfo=new Book(UIDUtil.getRandomUID(),name,author,price,stock,false,date,date,description);
        bookService.save(bookInfo);
        return Msg.success().add("description","图书上架成功");
}



    @RequestMapping(value = "/book/del", method = RequestMethod.GET)
    public String book_del() {
        return "bookDel";
    }
    @RequestMapping(value = "/book/del", method = RequestMethod.POST)
    public String bookDel(Book bookInfo) {
        return "bookDel";
    }

//    @RequestMapping("/book_/djust/price")
//    public String book/Adjus/Price() {
//        return "book_adjust_price";
//    }
//
//    @RequestMapping("/book/adjust/stock")
//    public String bookAdjustPrice() {
//        return "book_adjust_stock";
//    }
}
