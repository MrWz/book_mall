package cvter.intern.service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cvter on 2017/5/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PanicServiceTest {
    @Autowired
    private PanicService panicService;
    @Test
    public void save() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void selectByUID() throws Exception {
    }

    @Test
    public void deleteByUid() throws Exception {
    }

    @Test
    public void selectAll() throws Exception {
    }

    @Test
    public void bookPanic() throws Exception {
    }
}