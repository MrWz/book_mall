package cvter.intern.model;

import java.util.Date;

public class Discount extends AbstractParent{

    private Integer discountPrice;

    private Integer discountNum;

    private Integer validTime;

    private Date endTime;

    public Discount() {
        super();
    }

    public Discount(String uid, Integer discountPrice, Integer discountNum, Boolean deleted, Integer validTime, Date createTime, Date updateTime, Date endTime) {
        super(uid, createTime, updateTime, deleted);
        this.discountPrice = discountPrice;
        this.discountNum = discountNum;
        this.validTime = validTime;
        this.endTime = endTime;
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

    public Integer getValidTime() {
        return validTime;
    }

    public void setValidTime(Integer validTime) {
        this.validTime = validTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}