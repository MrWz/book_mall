package cvter.intern.lucene;

/**
 * Created by cvter on 2017/5/18.
 */
public class BookIndex {

    public static String UID = "uid";
    public static String NAME = "name";
    public static String AUTHOR = "author";
    public static String SUMMARY = "summary";

    private String uid;
    private String name;
    private String author;
    private String summary;

    public BookIndex() {
    }

    public BookIndex(String uid, String name, String author, String summary) {
        this.uid = uid;
        this.name = name;
        this.author = author;
        this.summary = summary;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "BookIndex{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
