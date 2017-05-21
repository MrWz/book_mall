package cvter.intern.model;

import org.junit.Test;

/**
 * Created by cvter on 2017/5/20.
 */
public class MsgTest {

    @Test
    public void success() throws Exception {
        System.out.println(Msg.success()
                .add("a", "b")
                .add("bookInfo", new BookInfo())
        );
    }

    @Test
    public void fail() throws Exception {
        System.out.println(Msg.fail()
                .add("a", "b")
                .add("bookInfo", new BookInfo())
        );
    }

}