package cvter.intern.model;

import java.util.Date;

public class BookBooktag {
    private Integer id;

    private String bookUid;

    private String booktagUid;

    private Boolean deleted;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookUid() {
        return bookUid;
    }

    public void setBookUid(String bookUid) {
        this.bookUid = bookUid == null ? null : bookUid.trim();
    }

    public String getBooktagUid() {
        return booktagUid;
    }

    public void setBooktagUid(String booktagUid) {
        this.booktagUid = booktagUid == null ? null : booktagUid.trim();
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

    public BookBooktag(String bookUid, String booktagUid, Boolean deleted, Date createTime, Date updateTime) {
        this.bookUid = bookUid;
        this.booktagUid = booktagUid;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}