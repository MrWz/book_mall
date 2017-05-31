package cvter.intern.service.impl;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import cvter.intern.model.Panic;
import cvter.intern.service.PanicRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by cvter on 2017/5/26.
 */
@Repository
public class PanicRedisImpl implements PanicRedis{

    @Autowired
    private JedisPool jedisPool;

    private RuntimeSchema<Panic> schema = RuntimeSchema.createFrom(Panic.class);

//    public PanicRedisImpl(String ip, int port) {
//        jedisPool = new JedisPool(ip, port);
//    }

    public Panic getPanic(String panicId) {
        // redis操作逻辑
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "panic:" + panicId;
                // 并没有实现内部序列化操作
                // get -> byte[] -> 反序列化 -> object[Panic]
                // 采用自定义序列化
                // protostuff : pojo.
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {
                    Panic pbook = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, pbook, schema);
                    // seckill被反序列化
                    return pbook;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String putPanic(Panic panicId) {
        // set Object(Seckill) -> 序列号 -> byte[]
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "panicId:" + panicId.getId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(panicId, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                // 超时缓存
                int timeout = 60 * 60;//一小时
                String result = jedis.setex(key.getBytes(), timeout, bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e){
        }
        return null;
    }
}
