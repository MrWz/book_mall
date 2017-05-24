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
    public void createToken() throws Exception {
        TokenModel token = tokenManager.createToken("hu");
        System.out.println(token.getUserId() + "---" + token.getToken());
    }

    @Test
    public void getToken() throws Exception {
        System.out.println(tokenManager.getToken("hu_5925a89837fd4222a5115cb5cf1f5bcc").getToken());
    }

    @Test
    public void checkToken() throws Exception {
        TokenModel token = tokenManager.getToken("hu_5925a89837fd4222a5115cb5cf1f5bcc");
        System.out.println(tokenManager.checkToken(token));
    }

    @Test
    public void deleteToken() throws Exception {
    }

}