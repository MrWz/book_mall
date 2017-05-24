package cvter.intern.lucene.model;

/**
 * Created by cvter on 2017/5/18.
 */
public class BookIndex implements Index {

    public static final String UID = "uid";
    public static final String NAME = "name";
    public static final String AUTHOR = "author";
    public static final String DESCRIPTION = "description";

    private String uid;
    private String name;
    private String author;
    private String description;

    public BookIndex() {
    }

    public BookIndex(String uid, String name, String author, String description) {
        this.uid = uid;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookIndex{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
