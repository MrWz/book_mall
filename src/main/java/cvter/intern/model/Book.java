package cvter.intern.model;

import java.util.Date;

public class Book extends AbstractParent{

    private String name;

    private String author;

    private Integer price;

    private Integer stock;

    private String description;

    public Book(String uid, String name, String author, Integer price, Integer stock, Boolean deleted, Date createTime, Date updateTime, String description) {
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

    public Book() {super();}

    public Book(String uid, Date createTime, Date updateTime, Boolean deleted, String name, String author, Integer price, Integer stock, String description) {
        super(uid, createTime, updateTime, deleted);
        this.name = name;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}