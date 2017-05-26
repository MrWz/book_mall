package cvter.intern.dto;

import cvter.intern.enums.PanicStatEnum;
import cvter.intern.model.UserBook;

/**
 * Created by cvter on 2017/5/25.
 */
/*
 * 封装秒杀执行后结果
 */
public class PanicExecution {

    private String bookId;

    //秒杀执行结果状态
         int state;

    // 状态标识
        private String stateInfo;

    // 秒杀成功对象
    private UserBook userBook;


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public UserBook getUserBook() {
        return userBook;
    }

    public void setUserBook(UserBook userBook) {
        this.userBook = userBook;
    }


    public PanicExecution(String bookId, PanicStatEnum statEnum) {
        this.bookId = bookId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    public PanicExecution(String bookId,PanicStatEnum statEnum, UserBook userBook) {
        this.bookId = bookId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.userBook = userBook;
    }

    @Override
    public String toString() {
        return "PanicExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", userBook=" + userBook +
                '}';
    }
}
