package cvter.intern.model;

import java.util.Date;

/**
 * Created by cvter on 2017/5/14.
 */
public abstract class AbstractParent {

    protected int id;                   //对应表中id字段
    protected String uid;               //对应表中UID字段
    protected Date createTime;          //对应表中create_time字段
    protected Date updateTime;          //对应表中update_time字段
    protected int deleted;              //对应表中deleted字段

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
