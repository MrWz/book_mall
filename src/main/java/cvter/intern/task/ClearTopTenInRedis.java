package cvter.intern.task;

import cvter.intern.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by cvter on 2017/5/31.
 */
@Service
@EnableScheduling
public class ClearTopTenInRedis {

    @Autowired
    private JedisPool jedisPool;

    @Scheduled(cron = "0 59 23 ? * WED ")   //每周清空缓存
    public void count() {
        Jedis jedis = jedisPool.getResource();
        jedis.del(Constants.TOP_TEN_KEY);

        jedis.close();
    }
}
