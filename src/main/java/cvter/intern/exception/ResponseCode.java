package cvter.intern.exception;

/**
 * 请求API响应码接口
 * <p>
 * Created by huzunrong on 2017/5/17.
 */
public interface ResponseCode {

    /**
     * 获得状态码
     *
     * @return
     */
    int getCode();

    /**
     * 获得状态码描述
     *
     * @return
     */
    String getMessage();

}
