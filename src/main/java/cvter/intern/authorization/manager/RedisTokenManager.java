package cvter.intern.authorization.manager;

import cvter.intern.authorization.model.TokenModel;
import cvter.intern.authorization.util.Constants;
import cvter.intern.utils.UIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 通过 Redis 存储和验证 token 的实现类
 */
public class RedisTokenManager implements TokenManager {

    @Autowired
    private JedisPool jedisPool;

    public TokenModel createToken(String userId) {
        Jedis jedis=jedisPool.getResource();
        // 使用 uuid 作为源 token
        String token=UIDUtil.getRandomUID();
        TokenModel model=new TokenModel(userId, token);
        // 存储到 redis 并设置过期时间
        jedis.set(userId, model.getToken());
        jedis.expire(userId, Constants.TOKEN_EXPIRES_HOUR);
        jedis.close();
        return model;
    }

    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param=authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        // 使用 userId 和源 token 简单拼接成的 token，可以增加加密措施
        String userId=param[0];
        String token=param[1];
        return new TokenModel(userId, token);
    }

    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }

        Jedis jedis=jedisPool.getResource();
        String token=jedis.get(model.getUserId());
        if (token == null || !token.equals(model.getToken())) {
            jedis.close();
            return false;
        }
        // 如果验证成功，说明此用户进行了一次有效操作，延长 token 的过期时间
        jedis.expire(model.getUserId(), Constants.TOKEN_EXPIRES_HOUR);
        jedis.close();
        return true;
    }

    public void deleteToken(String userId) {
        Jedis jedis=jedisPool.getResource();
        jedis.del(userId);
        jedis.close();
    }

    public boolean getLock(String key, String value) {
        /**
         * 锁超时时间，防止线程在入锁以后，无限的执行等待
         */
        int expireMsecs=10;

        /**
         * 锁等待时间，防止线程饥饿
         */
        int timeoutMsecs=10;

        Jedis jedis=jedisPool.getResource();
        long result=jedis.setnx(key, value);
        if (result == 1) {
            jedis.expire(key, expireMsecs);
            jedis.close();
            return true;
        }
        /*
        * 在等待时间内，轮询去尝试获取锁，当获取到则退出轮询
        * 在等待时间内为获取到，则也推出循环
        * */
        while (result == 0 && timeoutMsecs != 0) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            result=jedis.setnx(key, value);
            --timeoutMsecs;
        }
        /*
        * 在等待时间内获得锁的拥有权
        * */
        if (timeoutMsecs != 0) {
            jedis.expire(key, expireMsecs);
            jedis.close();
            return true;
        }
        /*
        * 在等待时间内未获得锁的拥有权
        * */
        jedis.close();
        return false;
    }

    public void unLock(String key) {
        Jedis jedis=jedisPool.getResource();
        jedis.del(key);
        jedis.close();
    }

}