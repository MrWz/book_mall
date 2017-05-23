package cvter.intern.redis.service;

/**
 * Created by cvter on 2017/5/23.
 */
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * Created by cvter on 2017/5/23.
 */
public interface RedisService {

    Object vget(String key);

    <T extends Serializable> boolean vput(String key, T val);

    void deleteKey(String key);

    boolean vsetnx(String key,String value);

    boolean vset(String key,String value);
//    boolean hput(Serializable key, Serializable field, Serializable val);
//
//    Object hget(Serializable key, Serializable field);
//
//    void hdel(Serializable key);
//
//    <T> T hget(Serializable key, Class<? extends T> clazz);
//
//    Boolean getLock(String key, Long timeout, Boolean wait);
//
//    boolean hputSetWithExpire(Serializable tableKey, Set set, long expire);
//
//    Long vincrement(String key, long i);
//
//    Long vincrement(String key, long i, long expire);
}
