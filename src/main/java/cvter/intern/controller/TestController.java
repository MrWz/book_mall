package cvter.intern.controller;

import cvter.intern.model.Msg;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cvter on 2017/5/27.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    @ResponseBody
    @RequestMapping("/testxss")
    public Msg testXSS(String xssStr) {
        System.out.println(xssStr);

        System.out.println(StringEscapeUtils.escapeHtml4(xssStr));
        return Msg.success().add("a", xssStr).add("b", StringEscapeUtils.escapeHtml4(xssStr));
    }
}
