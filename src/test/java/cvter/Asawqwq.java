package cvter;

import cvter.intern.dao.RoleInfoMapper;
import cvter.intern.model.RoleInfo;
import cvter.intern.model.RoleInfoExample;
import cvter.intern.service.BookService;
import cvter.intern.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by cvter on 2017/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class Asawqwq{

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    private RoleInfo roleInfo=new RoleInfo(1,"mm","pp",false,new Date(1),new Date(1));

    @Autowired
    private RoleService roleService;

    @Autowired
    private BookService bookService;

    @Test
    public void testSelectRole(){
        RoleInfoExample example = new RoleInfoExample();
        example.createCriteria().andIdEqualTo(2);
//        roleInfoMapper.insert(roleInfo);
//        roleInfoMapper.selectByPrimaryKey("mm");
//        roleInfoMapper.updateByPrimaryKey(roleInfo);
//        roleInfoMapper.deleteByPrimaryKey("mm");
//        roleService.deleteByUid("mm");
        roleService.save(roleInfo);
//        roleService.update(roleInfo);
    }
}