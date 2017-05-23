package cvter.intern.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.service.IndexBookService;
import cvter.intern.lucene.service.impl.IndexBookServiceImpl;
import cvter.intern.model.Book;
import cvter.intern.model.Msg;
import cvter.intern.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    public Msg list(@RequestParam(defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 7);
        List<Book> allBook = bookService.selectAll();
        PageInfo page = new PageInfo(allBook, 5);

        return Msg.success().add("page", page);
    }

    @ResponseBody
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public Msg list(@PathVariable String uid) {
        Book book = bookService.selectByUid(uid);

        return Msg.success().add("book", book);
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
            @RequestParam(value = "pa", defaultValue = "1") Integer pn,
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
    @Authorization
    @ResponseBody
    @RequestMapping(path = {"/panic"}, method = RequestMethod.POST)
    public Msg bookPanic(@RequestParam String userUid,
                         @RequestParam String bookUid,
                         @RequestParam String tokenUid) {

        List<Book> books = new ArrayList<>();
        books.add(new Book());
        books.add(new Book());
        books.add(new Book());

        return Msg.success().add("books", books);

    }
}
