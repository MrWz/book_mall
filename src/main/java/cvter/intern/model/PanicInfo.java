package cvter.intern.model;

import java.util.Date;

public class PanicInfo {
    private Integer id;

    private String uid;

    private Byte nums;

    private Integer curPrice;

    private Date startTime;

    private Date endTime;

    public PanicInfo(Integer id, String uid, Byte nums, Integer curPrice, Date startTime, Date endTime, Boolean deleted, Date createTime, Date updateTime) {
        this.id = id;
        this.uid = uid;
        this.nums = nums;
        this.curPrice = curPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    private Boolean deleted;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}