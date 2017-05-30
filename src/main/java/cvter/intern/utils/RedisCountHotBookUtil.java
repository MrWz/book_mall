package cvter.intern.utils;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import cvter.intern.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by cvter on 2017/5/28.
 */
public class RedisCountHotBookUtil {
    @Autowired
    private JedisPool jedisPool;

    private RuntimeSchema<Book> schema=RuntimeSchema.createFrom(Book.class);

    public String putBook(Book book) {
        // set Object(Seckill) -> 序列号 -> byte[]
        try {
            Jedis jedis=jedisPool.getResource();
            try {
                String key="bookUid:" + book.getUid();
                byte[] bytes=ProtostuffIOUtil.toByteArray(book, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                // 超时缓存
                int timeout=60 * 60;//一小时
                String result=jedis.setex(key.getBytes(), timeout, bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Book getBook(String bookUid) {
        // redis操作逻辑
        try {
            Jedis jedis=jedisPool.getResource();
            try {
                String key="bookUid:" + bookUid;
                // 并没有实现内部序列化操作
                // get -> byte[] -> 反序列化 -> object[Panic]
                // 采用自定义序列化
                // protostuff : pojo.
                byte[] bytes=jedis.get(key.getBytes());
                if (bytes != null) {
                    Book book=schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, book, schema);
                    int timeout=60 * 60;//一小时
                    jedis.setex(key.getBytes(), timeout, bytes);
                    // seckill被反序列化
                    return book;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
        }
        return null;
    }
}
