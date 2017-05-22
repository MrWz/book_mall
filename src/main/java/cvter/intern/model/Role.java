package cvter.intern.model;

import java.util.Date;

public class Role extends AbstractParent{
    private String description;

    public Role() {
        super();
    }

    public Role(String uid, String description, Boolean deleted, Date createTime, Date updateTime) {
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