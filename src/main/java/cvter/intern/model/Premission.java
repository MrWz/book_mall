package cvter.intern.model;

import java.util.Date;

public class Premission extends AbstractParent{
    private String description;

    public Premission() {
        super();
    }

    public Premission(String uid, Date createTime, Date updateTime, Boolean deleted, String description) {
        super(uid, createTime, updateTime, deleted);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}