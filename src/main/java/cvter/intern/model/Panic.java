package cvter.intern.model;

import java.util.Date;

public class Panic extends AbstractParent{
    private int nums;

    private Integer curPrice;

    private Date startTime;

    private Date endTime;

    public Panic() {
        super();
    }

    public Panic(int nums, int curPrice, Date startTime, Date endTime,Date createTime, Date updateTime) {
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.nums = nums;
        this.curPrice = curPrice;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public int getCurPrice() {
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

    @Override
    public String toString() {
        return "Panic{" +
                "nums=" + nums +
                ", curPrice=" + curPrice +
                ", id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", uid='" + uid + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}