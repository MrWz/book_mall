package cvter.intern.service;

import cvter.intern.dto.Exposer;
import cvter.intern.dto.PanicExecution;
import cvter.intern.exception.PanicClose;
import cvter.intern.exception.RepetePanic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

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

    @Test
    public void exportPanicUrl() throws Exception {
        //String id=1000;
        int id=1000;
        Exposer exposer=panicService.exportPanicUrl("id");
        System.out.println(exposer);
    }

    @Test
    public void executePanic() throws Exception {
        int bid=1000;
        int uid=1111;
        try{
            PanicExecution panicExecution=panicService.executePanic("bid","uid");
            System.out.println(panicExecution);
        }catch(RepetePanic e){
            System.out.println(e.getMessage());
        }catch (PanicClose e1){
            System.out.println(e1.getMessage());
        }
    }
}