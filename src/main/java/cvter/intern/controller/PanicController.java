package cvter.intern.controller;

import cvter.intern.dto.Exposer;
import cvter.intern.dto.PanicExecution;
import cvter.intern.dto.PanicResult;
import cvter.intern.enums.PanicStatEnum;
import cvter.intern.exception.PanicClose;
import cvter.intern.exception.RepetePanic;
import cvter.intern.model.Panic;
import cvter.intern.service.PanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by cvter on 2017/5/25.
 */
@Controller
@RequestMapping("/panic")
public class PanicController {
    @Autowired
    private PanicService panicService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String list(){
        panicService.selectAll();
        return "yes";
    }

    @ResponseBody
    @RequestMapping(value = "/exposer", method = RequestMethod.POST)
    public PanicResult<Exposer> exposer(String uid) {
        PanicResult<Exposer> result;
        try {
            Exposer exposer = panicService.exportPanicUrl(uid);
            result = new PanicResult<Exposer>(true, exposer);
        } catch (Exception e) {
            result = new PanicResult<Exposer>(false, e.getMessage());
        }
        return result;
    }
//抢购执行

    @RequestMapping(value = "/execution", method = RequestMethod.POST)
    @ResponseBody
    public PanicResult<PanicExecution> execute(String bid,String uid) {
        try {
            PanicExecution execution = panicService.executePanic(bid,uid);
            return new PanicResult<PanicExecution>(true, execution);
        } catch (RepetePanic e) {
            PanicExecution execution = new PanicExecution(uid, PanicStatEnum.REPEAT_KILL);
            return new PanicResult<PanicExecution>(true, execution);
        } catch (PanicClose e) {
            PanicExecution execution = new PanicExecution(uid, PanicStatEnum.END);
            return new PanicResult<PanicExecution>(true, execution);
        } catch (Exception e) {
            PanicExecution execution = new PanicExecution(uid, PanicStatEnum.INNER_ERROR);
            return new PanicResult<PanicExecution>(true, execution);
        }
    }

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    @ResponseBody
    public PanicResult<Date> time() {
        Date now = new Date();
        return new PanicResult<Date>(true, now);
    }
}

