package cvter.intern.model;

import java.util.Date;

public class RoleInfo {
    private Integer id;

    public RoleInfo(Integer id, String uid, String description, Boolean deleted, Date createTime, Date updateTime) {
        this.id = id;
        this.uid = uid;
        this.description = description;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    private String uid;

    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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