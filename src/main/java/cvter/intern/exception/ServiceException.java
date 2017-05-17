package cvter.intern.exception;

/**
 * API响应自定义异常
 * <p>
 * Created by huzunrong on 2017/5/17.
 */
public class ServiceException extends RuntimeException {

    /**
     * 返回异常信息的接口
     */
    private ResponseCode ResponseCode;

    public ServiceException(ResponseCode ResponseCode) {
        this.ResponseCode = ResponseCode;
    }

    /**
     * 返回异常信息类
     *
     * @return
     */
    public ResponseCode getExceptionInterface() {
        return ResponseCode;
    }

}
