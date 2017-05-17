package cvter.intern.exception;

import org.junit.Test;

/**
 * Created by cvter on 2017/5/17.
 */
public class ServiceExceptionTest {

    @Test
    public void getExceptionInterface() throws Exception {
        try {
            throw new ServiceException(APIResponseCode.FOUR_10);
        } catch (ServiceException e) {
            System.out.println(e.getExceptionInterface().getMessage());
        }
    }
}