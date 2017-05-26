package cvter.intern.exception;

/**
 * Created by cvter on 2017/5/25.
 */

/**
 * 重复秒杀
 */
public class RepetePanic extends PanicException{
    public RepetePanic(String message) {
        super(message);
    }

    public RepetePanic(String message, Throwable cause) {
        super(message, cause);
    }
}
