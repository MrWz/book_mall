package cvter.intern.exception;

/**
 * Created by cvter on 2017/5/25.
 */
public class PanicClose extends PanicException{
    public PanicClose(String message) {
        super(message);
    }

    public PanicClose(String message, Throwable cause) {
        super(message, cause);
    }
}
