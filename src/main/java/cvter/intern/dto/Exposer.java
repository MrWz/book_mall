package cvter.intern.dto;

import java.util.Date;

/**
 * Created by cvter on 2017/5/25.
 */
public class Exposer {

        // 是否开启秒杀
    private boolean exposed;

        // 抢购图书id
        private String bookId;

        // 系统当前时间（毫秒）
        private Date now;

        // 开启时间
        private Date start;

         // 结束时间
         private Date end;

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", bookId=" + bookId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public Exposer(boolean exposed, String bookId) {
        this.exposed = exposed;
        this.bookId = bookId;
    }

    public Exposer(boolean exposed, String md5, String bookId) {
        this.exposed = exposed;
        this.bookId = bookId;
    }

    public Exposer(boolean exposed, String md5, String bookId, Date now, Date start, Date end) {
        this.exposed = exposed;
        this.bookId = bookId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, String bookId, Date now, Date start, Date end) {
        this.exposed = exposed;
        this.bookId = bookId;
        this.now = now;
        this.start = start;
        this.end = end;
    }
}
