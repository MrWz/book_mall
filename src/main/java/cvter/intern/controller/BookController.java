package cvter.intern.controller;

import cvter.intern.model.BookInfo;
import cvter.intern.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/book/v1")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @RequestMapping("/list")
    public String list(){
        List<BookInfo> allBook=bookService.selectAll(0,1);

        System.out.println("allBook");
        for(BookInfo book:allBook){
            System.out.println(book.getName());
        }
        return "list";
    }
}
