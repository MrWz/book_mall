package cvter.intern.utils;

/**
 * Created by cvter on 2017/5/19.
 */
public class JSONUtil{
    private int statusCode;
    private String message;
    private Object data;

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public JSONUtil(int statusCode, String message, Object data){
        this.statusCode=statusCode;
        this.message=message;
        this.data=data;
    }
}