package cvter.intern.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cvter.intern.lucene.IndexManager;
import cvter.intern.lucene.dao.impl.IndexDaoImpl;
import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.model.Index;
import cvter.intern.lucene.service.IndexBookService;
import cvter.intern.lucene.service.impl.IndexBookServiceImpl;
import cvter.intern.model.Book;
import cvter.intern.model.Msg;
import cvter.intern.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cvter on 2017/5/18.
 */
@Controller
@RequestMapping("/book/v1")
public class BookController extends BaseController {

    @Autowired
    private BookServiceImpl bookService;

    @ResponseBody
    @RequestMapping("/list")
    public Msg list(){
//        List<Book> allBook=bookService.selectByPaginate(0,4);
        PageHelper.startPage(2,5);
        List<Book> allBook=bookService.selectAll();
        PageInfo page = new PageInfo(allBook, 5);

        for(Book item : allBook) {
            System.out.println(item.getId());
        }
        long total = page.getTotal(); //获取总记录数
        System.out.println("页数：" + page.getPageNum());
        System.out.println("页数：" + page.getPages());
        System.out.println("页大小：" + page.getPageSize());
        System.out.println("EndRoW：" + page.getEndRow());
        System.out.println("PrePage：" + page.getPrePage());
        System.out.println("AllMessage：" + page.getList());
        System.out.println("PrePage：" + page.toString());

       return Msg.success().add("page",page);
//        return "list";
    }

    /**
     * 图书搜索
     *
     * @param bookName
     * @param bookAuthor
     * @param bookDescription
     * @return
     */
    @ResponseBody
    @RequestMapping(path = {"/search"})
    public Msg bookSearch(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(required = false) String bookName,
            @RequestParam(required = false) String bookAuthor,
            @RequestParam(required = false) String bookDescription) throws Exception {

        if (StringUtils.isEmpty(bookName) && StringUtils.isEmpty(bookAuthor) && StringUtils.isEmpty(bookDescription)) {
            return Msg.fail().setCode(400);
        }

        IndexBookService indexBookService = new IndexBookServiceImpl();

        List<Book> bookInfos = indexBookService.searchBookPaginated("summary", BookIndex.DESCRIPTION, pn, 5);

        return Msg.success().add("bookList", bookInfos);

    }

    /**
     * 图书抢购
     *
     * @param userUid
     * @param bookUid
     * @param tokenUid
     * @return
     */
    @ResponseBody
    @RequestMapping(path = {"/panic"}, method = RequestMethod.POST)
    public Msg bookPanic(@RequestParam String userUid,
                         @RequestParam String bookUid,
                         @RequestParam String tokenUid) {

        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());

        return Msg.success().add("fromServer", "Hello").add("books", books);

    }
}
