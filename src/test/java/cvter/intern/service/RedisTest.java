package cvter.intern.service;

import cvter.intern.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by cvter on 2017/5/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-redis.xml")
public class RedisTest {

    @Autowired
    private RedisTemplate<String,Book> redisTemplate;

    @Test
    public void testSet(){
        Book book = new Book();
        book.setPrice(128);
        book.setUid(UUID.randomUUID().toString());

        redisTemplate.boundValueOps("mapei").set(book);
    }

    @Test
    public void testGet(){
        System.out.println(redisTemplate.boundValueOps("mapei").get());
    }
}
