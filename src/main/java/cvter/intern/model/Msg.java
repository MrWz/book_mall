package cvter.intern.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cvter on 2017/5/20.
 */
public class Msg {

    private int code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMessage("处理成功");

        return msg;
    }

    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(500);
        msg.setMessage("处理异常");

        return msg;
    }

    public Msg add(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public Msg setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Msg setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Msg setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }
}
