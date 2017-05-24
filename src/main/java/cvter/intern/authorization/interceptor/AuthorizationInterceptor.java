package cvter.intern.authorization.interceptor;

import cvter.intern.authorization.annotation.Authorization;
import cvter.intern.authorization.manager.TokenManager;
import cvter.intern.authorization.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;

/**
 * 自定义拦截器，对请求进行身份验证
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenManager manager;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 从 header 中得到 token
//        String authentication = request.getHeader("UID");
        String authentication = session.getAttribute("UID") + "";

        TokenModel model = manager.getToken(authentication);
        // 验证 token
        if (manager.checkToken(model)) {
            // 如果 token 验证成功，将 token 对应的用户 id 存在 request 中，便于之后注入
            request.setAttribute("UID", model.getUserId());
            return true;
        }
        if (method.getAnnotation(Authorization.class) != null) {
            try {
                responseAuth(response, "[Please Login in first]");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    /**
     * 输出未登录状态信息
     *
     * @param response
     * @param msg
     * @throws IOException
     */
    private void responseAuth(HttpServletResponse response, String msg) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
        writer.write("{\n" +
                "\t\"code\": 401,\n" +
                "\t\"message\": \"" +
                msg
                + "\",\n" +
                "\t\"data\": null\n" +
                "}");
        writer.close();
    }
}
