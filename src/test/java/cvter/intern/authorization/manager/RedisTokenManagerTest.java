package cvter.intern.authorization.manager;

import cvter.intern.authorization.model.TokenModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cvter on 2017/5/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RedisTokenManagerTest {

    @Autowired
    private TokenManager tokenManager;

    @Test
    public void setRedis() throws Exception {
        TokenModel token = tokenManager.createToken("hu");
        System.out.println(token.getUserId() + "---" + token.getToken());
    }

    @Test
    public void createToken() throws Exception {
    }

    @Test
    public void getToken() throws Exception {
    }

    @Test
    public void checkToken() throws Exception {
    }

    @Test
    public void deleteToken() throws Exception {
    }

}