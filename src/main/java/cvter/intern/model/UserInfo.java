package cvter.intern.model;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private String uid;

    private String name;

    private String password;

    private Boolean deleted;

    public UserInfo(Integer id, String uid, String name, String password, Boolean deleted, Date createTime, Date updateTime) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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