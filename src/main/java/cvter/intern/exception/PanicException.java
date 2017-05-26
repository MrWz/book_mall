package cvter.intern.exception;

/**
 * Created by cvter on 2017/5/25.
 */
public class PanicException extends RuntimeException{
    public PanicException(String message) {
        super(message);
    }

    public PanicException(String message, Throwable cause) {
        super(message, cause);
    }
}
