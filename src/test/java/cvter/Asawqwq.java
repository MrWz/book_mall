package cvter;

import cvter.intern.dao.PanicInfoMapper;
import cvter.intern.dao.RoleInfoMapper;
import cvter.intern.model.PanicInfo;
import cvter.intern.model.RoleInfo;
import cvter.intern.model.RoleInfoExample;
import cvter.intern.service.DiscountService;
import cvter.intern.service.PanicService;
import cvter.intern.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by cvter on 2017/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class Asawqwq{

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PanicInfoMapper panicInfoMapper;

    @Autowired
    private PanicService panicService;

    @Autowired
    private DiscountService discountService;

   // private RoleInfo roleInfo;
    
    //@Autowired
    //private RoleService roleService;

    @Test
    public void testSelectRole(){
//        RoleInfoExample example = new RoleInfoExample();
//        example.createCriteria().andIdEqualTo(2);
       // roleInfo.setUid("11111");
       // roleInfoMapper.insert(roleInfo);
       //roleInfoMapper.selectByExample(example);

        //roleInfoMapper.selectByPrimaryKey("mm");
        //roleInfoMapper.deleteByPrimaryKey("mm");
        //roleInfoMapper.insert(new RoleInfo(1,"nn","dd",false,new Date(2015),new Date(2015)));
        //roleInfoMapper.updateByPrimaryKey(new RoleInfo(1,"mm","dd",false,new Date(2015),new Date(2015)));

//        panicInfoMapper.selectByPrimaryKey("mm");
//        panicInfoMapper.deleteByPrimaryKey("mm");
//        panicInfoMapper.insert(new PanicInfo(1,"mm",(byte)2,6,new Date(2015),new Date(2015),false,new Date(2015),new Date(2015)));
//        panicService.deleteByUid("mm");
//        discountService.selectByUID("mm");
        System.out.println(roleService.selectByUid("72297c8842604c059b05d28bfb11d10b"));

    }
}
