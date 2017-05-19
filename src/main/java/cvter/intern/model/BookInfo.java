package cvter.intern.model;

import java.util.Date;

public class BookInfo {
    private Integer id;

    private String uid;

    private String name;

    private String author;

    private Integer price;

    private Integer stock;

    private Boolean deleted;

    private Date createTime;

    public BookInfo(String uid, String name, String author, Integer price, Integer stock, Boolean deleted, Date createTime, Date updateTime, String description) {
        this.uid = uid;
        this.name = name;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.description = description;
    }

    public BookInfo(){
        super();
    }
    private Date updateTime;

    private String description;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}