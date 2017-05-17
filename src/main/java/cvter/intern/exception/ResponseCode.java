package cvter.intern.exception;

/**
 * 请求API响应码接口
 * <p>
 * Created by huzunrong on 2017/5/17.
 */
public interface ResponseCode {

    /**
     * 获得响应码
     *
     * @return
     */
    int getCode();

    /**
     * 获得响应码对应的信息
     *
     * @return
     */
    String getMessage();

}
