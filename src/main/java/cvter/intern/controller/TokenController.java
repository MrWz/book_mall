package cvter.intern.controller;

import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.authorization.manager.TokenManager;
import cvter.intern.authorization.model.TokenModel;
import cvter.intern.model.Msg;
import cvter.intern.model.User;
import cvter.intern.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by cvter on 2017/5/23.
 */
@Controller
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    UserService userService;

    @Autowired
    TokenManager tokenManager;

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Msg login(@RequestParam String username, HttpSession session) {
        System.err.println("username -> " + username);
        Assert.notNull(username, "username can not be empty");
        User user = userService.selectByName(username);
        if (user == null) {
            return Msg.fail().setMessage("未注册");
        }

        // 生成一个 token，保存用户登录状态
        TokenModel model = tokenManager.createToken(user.getUid());
        session.setAttribute("UID", model.toString());
        return Msg.success();
    }

    @Authorization
    @ResponseBody
    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public Msg loginoff() {

        tokenManager.deleteToken("1");
        return Msg.success();
    }
}
