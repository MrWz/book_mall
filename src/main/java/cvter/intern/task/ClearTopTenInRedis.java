package cvter.intern.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    final static String KEY="TOP-TEN";
    private static Logger logger=LoggerFactory.getLogger(ClearTopTenInRedis.class);

    @Scheduled(cron="0 41 16 ? * WED ")   //每周清空缓存
    public void count() {
        Jedis jedis=jedisPool.getResource();
        logger.info("-----------------------------------------清空缓存");
        jedis.del(KEY);
    }
}
