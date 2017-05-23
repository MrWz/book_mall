package cvter.intern.exception;

/**
 * 封装API异常码
 * <p>
 * Created by cvter on 2017/5/17.
 */
public enum ExceptionCode {

    EX_400(400, "用户请求的格式不正确"),
    EX_403(403, "禁止访问"),
    EX_404(404, "请求的资源不存在"),
    EX_405(405, "该http方法不被允许"),
    EX_500(500, "服务器异常"),

    //应该添加具体的业务异常
    EX_10000(10000, "业务异常"),




    EX_10001(10001, "参数异常"),
    EX_10002(10002, "Unknown异常"),
    /*
    * 数字2开头为普通用户异常
    * 数字3开头为管理员用户异常
    * */
    EX_20000(20000, "普通用户异常");

    private int code;
    private String message;

    /**
     * 构造方法，默认private
     *
     * @param code    状态码
     * @param message 状态码描述
     */
    ExceptionCode(int code, String message) {
        this.code=code;
        this.message=message;
    }

    /**
     * 获得状态码
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * 获得状态码描述
     *
     * @return
     */
    public String getMessage() {
        return message;
    }
}
