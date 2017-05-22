package cvter.intern.model;

import java.util.Date;

public class Panic extends AbstractParent{
    private Byte nums;

    private Integer curPrice;

    private Date startTime;

    private Date endTime;

    public Panic() {
        super();
    }

    public Panic(String uid, Byte nums, Integer curPrice, Date startTime, Date endTime, Boolean deleted, Date createTime, Date updateTime) {
        super(uid, createTime, updateTime, deleted);
        this.nums = nums;
        this.curPrice = curPrice;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Byte getNums() {
        return nums;
    }

    public void setNums(Byte nums) {
        this.nums = nums;
    }

    public Integer getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(Integer curPrice) {
        this.curPrice = curPrice;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}