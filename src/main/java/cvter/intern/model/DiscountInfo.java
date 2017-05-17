package cvter.intern.model;

import java.util.Date;

public class DiscountInfo {
    private Integer id;

    private String uid;

    private Integer discountPrice;

    private Integer discountNum;

    private Boolean deleted;

    private Integer validTime;

    private Date createTime;

    public DiscountInfo(Integer id, String uid, Integer discountPrice, Integer discountNum, Boolean deleted, Integer validTime, Date createTime, Date updateTime, Date endTime) {
        this.id = id;
        this.uid = uid;
        this.discountPrice = discountPrice;
        this.discountNum = discountNum;
        this.deleted = deleted;
        this.validTime = validTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.endTime = endTime;
    }

    private Date updateTime;

    private Date endTime;

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

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getDiscountNum() {
        return discountNum;
    }

    public void setDiscountNum(Integer discountNum) {
        this.discountNum = discountNum;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getValidTime() {
        return validTime;
    }

    public void setValidTime(Integer validTime) {
        this.validTime = validTime;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}