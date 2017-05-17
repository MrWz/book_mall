package cvter.intern.exception;

/**
 * 封装请求API响应码
 * <p>
 * Created by huzunrong on 2017/5/17.
 */
public enum APIResponseCode implements ResponseCode {

    TWO_00(200, "服务器响应成功"),
    TWO_01(201, "新建或修改数据成功"),

    FOUR_00(400, "发出的请求有错误"),
    FOUR_01(401, "未授权"),
    FOUR_03(403, "用户没有权限"),
    FOUR_04(404, "访问不存在"),
    FOUR_05(405, "该http方法不被允许"),
    FOUR_06(406, "用户请求的格式不正确"),
    FOUR_10(410, "请求的资源不可得"),
    FOUR_22(422, "校验错误"),
    FOUR_29(429, "请求过多"),

    FIVE_00(500, "服务器异常");

    private int code;
    private String message;

    /**
     * 构造方法，默认private
     *
     * @param code
     * @param message
     */
    APIResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获得响应码
     *
     * @return
     */
    @Override
    public int getCode() {
        return code;
    }

    /**
     * 获得响应码对应的信息
     *
     * @return
     */
    @Override
    public String getMessage() {
        return message;
    }
}
