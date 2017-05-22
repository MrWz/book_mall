package cvter.intern.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cvter on 2017/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
@Service
public class BookServiceTest {

    @Autowired
    private BookService bookService;



    @Test
    public void testDelete(){
        Object[][] params = {
                {"1",0},
                {"2",0},
                {"3",1},
                {"51312",1},
                {"15135126",1},
        };
        for (int i = 0; i < params.length; i++) {
            String id = (String) params[i][0];
            int expResult = (int) params[i][1];
            Boolean status = bookService.deleteByUid(id);
            Assert.assertEquals(id,status);
        }
    }
}
