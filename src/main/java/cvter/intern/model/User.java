package cvter.intern.model;

import java.util.Date;

public class User extends AbstractParent{

    private String name;

    private String password;

    public User() {
        super();
    }

    public User(String uid, String name, String password, Boolean deleted, Date createTime, Date updateTime) {
        super(uid, createTime, updateTime, deleted);
        this.name = name;
        this.password = password;
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
}