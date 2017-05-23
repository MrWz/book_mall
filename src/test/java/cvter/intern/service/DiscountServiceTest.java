package cvter.intern.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 测试DiscountService
 */
@RunWith(SpringJUnit4ClassRunner.class)
<<<<<<< HEAD
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
=======
@ContextConfiguration(locations = "classpath:applicationContext.xml")
>>>>>>> temp
@Service
public class DiscountServiceTest {

    @Resource
    private DiscountService discountService;

    @Test
    public void save() throws Exception {
        // discountService.save()
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void selectByUID() throws Exception {
        discountService.selectByUID("mm");
    }

    @Test
    public void deleteByUid() throws Exception {
    }

    @Test
    public void selectAll() throws Exception {
    }

}