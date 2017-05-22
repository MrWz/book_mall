package cvter.intern.service;

import cvter.intern.model.Book;
import cvter.intern.utils.UIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by cvter on 2017/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    public void selectByUid() throws Exception {
    }

    @Test
    public void selectByPaginate() throws Exception {
    }

    @Test
    public void save() throws Exception {
        for (int i = 0; i < 1000; i++) {
            Book book = new Book();
            book.setUid(UIDUtil.getRandomUID());
            book.setName("书名" + (i + 1));
            book.setAuthor("作者" + (i + 1));
            book.setDescription("描述" + (i + 1));
            book.setPrice(10 + i);
            book.setStock(i + 1);
            book.setDeleted(false);
            book.setCreateTime(new Date());
            book.setUpdateTime(new Date());
            bookService.save(book);
        }
        System.out.println("OK");
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void deleteByUid() throws Exception {
    }

    @Test
    public void selectAll() throws Exception {
    }

}