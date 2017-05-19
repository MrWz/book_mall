package cvter.intern.controller;

import cvter.intern.model.BookInfo;
import cvter.intern.service.BookService;
import cvter.intern.service.UserService;
import cvter.intern.utils.UIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/admin/v1")
public class AdminController {
    @Resource
    private UserService userService;
    @Resource
    private BookService bookService;
    @RequestMapping("/login")
    public String login() {
        return "adminlogin";
    }

    @RequestMapping("/Index")
    public String index(String username, String password) {
        if (userService.checkLogin(username, password)) {
            return "Index";
        }
        return "adminlogin";
    }

//    @RequestMapping("/book_add")
//    public String book_add(String username,String author,int price,int stock,String describe) {
//        if(username!=null){
//            Date date=new Date();
//            BookInfo bookInfo=new BookInfo(UIDUtil.getRandomUID(),username,author,price,stock,false,date,date,describe);
//            bookService.save(bookInfo);
//            return "book_add";
//        }
//        return "book_add";
//
//    }
    @RequestMapping("/book_add")
    public String book_add(String username,String author) {

        if(username==null){
            System.out.println("null");
        }
        else{
            System.out.println("not null");
        }
        return "book_add";
    }



//    @RequestMapping("/book_del")
//    public String book_del() {
//        return "book_del";
//    }
//
//    @RequestMapping("/book_adjust_price")
//    public String book_adjust_price() {
//        return "book_adjust_price";
//    }
//
//    @RequestMapping("/book_adjust_stock")
//    public String book_adjust_stock() {
//        return "book_adjust_stock";
//    }
}
