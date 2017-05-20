package cvter.intern.controller;

import cvter.intern.lucene.IndexManager;
import cvter.intern.lucene.dao.impl.IndexDaoImpl;
import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.model.Index;
import cvter.intern.model.BookInfo;
import cvter.intern.model.Msg;
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
public class BookController {
    @RequestMapping("/list")
    public String list() {
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
    @RequestMapping(path = {"/search"}, method = RequestMethod.GET)
    public Msg bookSearch(@RequestParam(required = false) String bookName,
                          @RequestParam(required = false) String bookAuthor,
                          @RequestParam(required = false) String bookDescription) {

        if (StringUtils.isEmpty(bookName) && StringUtils.isEmpty(bookAuthor) && StringUtils.isEmpty(bookDescription)) {
            return Msg.fail().setCode(400);
        }

        try {
            IndexManager indexManager = IndexManager.builder(IndexDaoImpl.class);
            List<Index> bookList = indexManager.searchIndexTopN("summary", BookIndex.DESCRIPTION, 100);

            return Msg.success().add("bookList", bookList);
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail();
        }

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
