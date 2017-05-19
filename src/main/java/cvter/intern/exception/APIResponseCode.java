package cvter.intern.exception;

/**
 * 封装请求API响应码
 * <p>
 * Created by huzunrong on 2017/5/17.
 */
public enum APIResponseCode implements ResponseCode {

    TWO_00(200, "请求成功"),

    FOUR_00(400, "用户请求的格式不正确"),
    FOUR_01(401, "未授权"),
    FOUR_04(404, "请求的资源不存在"),
    FOUR_05(405, "该http方法不被允许"),
    FOUR_10(410, "请求的资源不可得"),
    FOUR_29(429, "请求过多"),

    FIVE_00(500, "服务器异常");

    private int code;
    private String message;

    /**
     * 构造方法，默认private
     *
     * @param code
     *          状态码
     * @param message
     *          状态码描述
     */
    APIResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获得状态码
     *
     * @return
     */
    @Override
    public int getCode() {
        return code;
    }

    /**
     * 获得状态码描述
     *
     * @return
     */
    @Override
    public String getMessage() {
        return message;
    }
}
