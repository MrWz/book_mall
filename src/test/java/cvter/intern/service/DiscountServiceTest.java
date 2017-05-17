package cvter.intern.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by cvter on 2017/5/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
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