package cvter.intern.service;

import cvter.intern.model.Book;
import cvter.intern.utils.UIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;

/**
 * Created by cvter on 2017/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void selectByUid() throws Exception {
        System.out.println(bookService.selectByUid("fdb991ee90f4433ca6ac335ba6b6cd59"));
    }

    @Test
    public void selectByPaginate() throws Exception {
    }

    @Test
    public void save() throws Exception {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            Book book = new Book();
            book.setUid(UIDUtil.getRandomUID());
            book.setName("书名" + random.nextInt(1000));
            book.setAuthor("作者" + random.nextInt(1000));
            book.setDescription("描述" + random.nextInt(1000));
            book.setPrice(10 + random.nextInt(100));
            book.setStock(random.nextInt(30) + 1);
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
        System.out.println(bookService.selectAll().size());
    }

}