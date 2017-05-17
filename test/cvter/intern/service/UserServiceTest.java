package cvter.intern.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cvter on 2017/5/16.
 */
//整合junit和spring，让junit在启动时候加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件,需要用到的配置文件，如果是dao的话可以不用spring-mvc.xml
@ContextConfiguration({/*"classpath:spring-mvc.xml",*/ "classpath:spring-mybatis.xml"})
public class UserServiceTest {

//    @Resource /*或者 @Autowired */
//    private UserService userService;
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Test
//    public void getByUid() throws Exception {
//    }
//
//    @Test
//    public void getPaginate() throws Exception {
//        List<User> userList = userService.getPaginate(1, 5);
//        for (User user :
//                userList) {
//            System.out.println(user);
//        }
//        System.out.println(UIDUtil.getRandomUID());
//    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void deleteByUid() throws Exception {
    }

}