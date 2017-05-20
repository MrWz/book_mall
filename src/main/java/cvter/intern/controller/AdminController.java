package cvter.intern.controller;
import com.alibaba.fastjson.JSON;
import cvter.intern.model.BookInfo;
import cvter.intern.service.BookService;
import cvter.intern.service.UserService;
import cvter.intern.utils.JSONUtil;
import cvter.intern.utils.UIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

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
    public String login(ModelMap model,String username, String password) {
            return "adminlogin";
    }

    @RequestMapping("/Index")
    public String index(HttpServletRequest request, ModelMap model, String username, String password) {
        //Jedis jedis = new Jedis("localhost");
        boolean flag=userService.checkAdimLogin(username, password);
        HashMap data=new HashMap<String,String>();
        if (flag) {

            data.put("description","您已登录成功");
            JSONUtil myJson=new JSONUtil(300,"登录成功",data);
            String json= JSON.toJSONString(myJson);
            System.out.println(myJson.getStatusCode());
            System.out.println(json);
            model.addAttribute("myJson",json);
            return "Index";
        }

            data.put("description","用户名或密码错误");
            JSONUtil myJson=new JSONUtil(203,"登录失败",data);
            String json= JSON.toJSONString(myJson);
            model.addAttribute("myJson",json);
            return "adminlogin";

    }

@RequestMapping(value = "book_add",method = RequestMethod.PUT)
//@RequestMapping(value = "/book_add", method = RequestMethod.GET)
public String bookAdd() {
    return "book_add";
}

@RequestMapping(value = "/book_add", method = RequestMethod.POST)
//@ResponseBody

public String bookAdd(ModelMap model,@RequestParam String bookname, @RequestParam String author, @RequestParam int price, @RequestParam int stock, @RequestParam(value = "describe") String description) {

   // System.out.println(bookname);
    Date date=new Date();
    BookInfo bookInfo=new BookInfo(UIDUtil.getRandomUID(),bookname,author,price,stock,false,date,date,description);
    bookService.save(bookInfo);
    HashMap data=new HashMap<String,String>();
    data.put("description","图书上架成功");
    JSONUtil myJson=new JSONUtil(300,"上架成功",data);
    String json= JSON.toJSONString(myJson);
    System.out.println(myJson.getStatusCode());
    System.out.println(json);
    model.addAttribute("myJson",json);
    return "welcom";
}


//    @RequestMapping(value = "/book_del", method = RequestMethod.GET)
//    public String book_del() {
//        return "book_add";
//    }
    @RequestMapping(value = "/book_del", method = RequestMethod.POST)
    public String bookDel(BookInfo bookInfo) {

        return "book_del";
    }

//    @RequestMapping("/book_adjust_price")
//    public String bookAdjustPrice() {
//        return "book_adjust_price";
//    }
//
//    @RequestMapping("/book_adjust_stock")
//    public String bookAdjustPrice() {
//        return "book_adjust_stock";
//    }
}
