package cvter.intern.model;

import java.util.Date;

public class UserRole {
    private Integer id;

    private String userUid;

    private String roleUid;

    private Boolean deleted;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid == null ? null : userUid.trim();
    }

    public String getRoleUid() {
        return roleUid;
    }

    public void setRoleUid(String roleUid) {
        this.roleUid = roleUid == null ? null : roleUid.trim();
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