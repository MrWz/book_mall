package cvter.intern.utils;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by cvter on 2017/5/19.
 */
public class Md5SaltUtilTest {

    @Test
    public void getMD5() throws Exception {

        String object = "1234567890";
        String salt = "hello";
        assertEquals("41D3943B0597F9CC84B5F094D64FF4E7", Md5SaltUtil.getMD5(object, salt));

        for (int i = 0; i < 100; i++) {
            object = new Random(999999999) + "";
            salt = new Random(999999999) + "";
            assertEquals(Md5SaltUtil.getMD5(object, salt), Md5SaltUtil.getMD5(object, salt));
        }

    }

}