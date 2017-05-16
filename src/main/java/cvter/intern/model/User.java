package cvter.intern.model;

/**
 * Created by cvter on 2017/5/14.
 */
public class User extends AbstractParent {

    private String name;                //对应表中name字段
    private String password;            //对应表中password字段

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", uid='" + uid + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null) return false;

        User user = (User) o;
        if (getId() == user.getId() && getUid() == user.getUid()) {
            return true;
        }

        return false;
    }

}
