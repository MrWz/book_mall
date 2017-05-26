package cvter.intern.enums;

/**
 * Created by cvter on 2017/5/25.
 */
/**
 * 使用枚举表述常量数据字典
 */
public enum  PanicStatEnum {

        SUCCESS(1, "秒杀成功"),
        END(0, "秒杀结束"),
        REPEAT_KILL(-1, "重发秒杀"),
        INNER_ERROR(-2, "系统异常"),
        DATA_REWRITE(-3, "数据篡改");

        private int state;

        private String stateInfo;

        private PanicStatEnum(int state, String stateInfo) {
            this.state = state;
            this.stateInfo = stateInfo;
        }

        public int getState() {
            return state;
        }

        public String getStateInfo() {
            return stateInfo;
        }

        public static PanicStatEnum stateOf(int index) {
            for (PanicStatEnum state : values()) {
                if (state.getState() == index) {
                    return state;
                }
            }
            return null;
        }
}

