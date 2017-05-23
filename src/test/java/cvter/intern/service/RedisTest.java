package cvter.intern.service;

import cvter.intern.model.Book;
import cvter.intern.redis.service.RedisService;
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
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class RedisTest {

    @Autowired
    private RedisTemplate<String,Book> redisTemplate;

    @Autowired
    private RedisService redisService;

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

//    @Test
//    public void testRedis(){
//        redisService.deleteKey("mapei");
//    }

    @Test
    public void testvset(){
//        redisService.vset("mp","mapei");
//        System.out.println(redisService.vset("mp","mama"));
//        System.out.println(redisService.vget("mp"));
//        redisService.deleteKey("mp");
//        System.out.println(redisService.vget("mp"));
//        redisService.vput("wz","wangzhe");
//        redisService.vput("wz","wangwang");
//        System.out.println(redisService.vget("wz"));
        redisService.vset("mp","mapei");
        System.out.println(redisService.vget("mp"));
        System.out.println(redisService.vset("mp","mama"));
        System.out.println(redisService.vget("mp"));
        redisService.deleteKey("mp");
        System.out.println(redisService.vget("mp"));
        //redisService.deleteKey();
    }
}
