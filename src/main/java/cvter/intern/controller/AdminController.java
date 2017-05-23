package cvter.intern.controller;

import cvter.intern.exception.BusinessException;
import cvter.intern.model.Book;
import cvter.intern.model.Msg;
import cvter.intern.service.BookService;
import cvter.intern.service.UserService;
import cvter.intern.utils.UIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
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
    public Msg index(@RequestParam String username, @RequestParam String password) {
        if (userService.checkAdimLogin(username, password)) {
            return Msg.success().add("description","您已登录成功");
        }
        throw new BusinessException(50000,"用户名或密码错误");
    }

    @ResponseBody
    @RequestMapping(value = "/book/add",method = RequestMethod.POST)
    public Msg bookAdd(Book book) {
    if(bookService.save(book)){
        return Msg.success().setMessage("图书上架成功");
    }
        return Msg.success().setMessage("图书上架失败");
    }

    @ResponseBody
    @RequestMapping(value = "/book/del", method = RequestMethod.POST)
    public Msg bookDel(@RequestParam String uid) {
        if(bookService.bookDel(uid)){
            return Msg.success().setMessage("图书删除成功");
        }
        return Msg.success().setMessage("图书删除失败");
    }

    @ResponseBody
    @RequestMapping(value = "/book/adjust/price",method = RequestMethod.POST)
    public Msg bookAdjustPrice(@RequestParam String uid,@RequestParam int price) {
        bookService.bookAdjustPrice(uid,price);
        return Msg.success().setMessage("图书调价成功");
    }

    @ResponseBody
    @RequestMapping(value="/book/adjust/stock",method = RequestMethod.POST)
    public Msg bookAdjustStock(@RequestParam String uid,@RequestParam int stock) {
        bookService.bookAdjustStock(uid,stock);
        return Msg.success().setMessage("图书调库存成功");
    }
}
