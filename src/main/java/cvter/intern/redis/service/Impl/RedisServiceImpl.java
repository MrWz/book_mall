package cvter.intern.redis.service.Impl;

import cvter.intern.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by cvter on 2017/5/23.
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 通过key得到value
     */
    @Override
    public Object vget(String key) {
        if(!redisTemplate.hasKey(key)){
            return null;
        }
        return redisTemplate.boundValueOps(key).get();
    }

    /**
     * 将key和value赋值，不覆盖
     */
    @Override
    public <T extends Serializable> boolean vput(String key, T val) {
        if(!redisTemplate.hasKey(key)){
            redisTemplate.boundValueOps(key).set(val);
            return true;
        }
        return false;
    }

    /**
     * 删除key
     */
    @Override
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 将key和value赋值，不覆盖
     */
    @Override
    public boolean vsetnx(String key, String value) {
        if(redisTemplate.hasKey(key)){
            return false;
        }
        redisTemplate.boundValueOps(key).set(value);
        return true;
    }

    /**
     * 将key和value赋值，覆盖
     */
    @Override
    public boolean vset(String key, String value) {
        redisTemplate.boundValueOps(key).set(value);
        return true;
    }
}
