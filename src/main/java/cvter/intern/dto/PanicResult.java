package cvter.intern.dto;

/**
 * Created by cvter on 2017/5/25.
 */
public class PanicResult<T> {
    private boolean success;

    private T data;

    private String error;

    public PanicResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public PanicResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "SeckillResult [success=" + success + ", data=" + data + ", error=" + error + "]";
    }
}
