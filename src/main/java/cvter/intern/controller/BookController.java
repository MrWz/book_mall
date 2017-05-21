package cvter.intern.controller;

import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.service.IndexBookService;
import cvter.intern.lucene.service.impl.IndexBookServiceImpl;
import cvter.intern.model.BookInfo;
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

    @RequestMapping("/list")
    public String list() {
        List<BookInfo> allBook = bookService.selectAll(0, 1);

        System.out.println("allBook");
        for (BookInfo book : allBook) {
            System.out.println(book.getName());
        }
        return "list";
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

        List<BookInfo> bookInfos = indexBookService.searchBookPaginated("summary", BookIndex.DESCRIPTION, pn, 5);

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

        List<BookInfo> bookInfos = new ArrayList<>();
        bookInfos.add(new BookInfo());
        bookInfos.add(new BookInfo());
        bookInfos.add(new BookInfo());

        return Msg.success().add("fromServer", "Hello").add("bookInfos", bookInfos);

    }
}
