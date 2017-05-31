package cvter.intern.interceptor;

import cvter.intern.service.PanicService;
import cvter.intern.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 统计controller层执行时间，时间三秒防刷功能
 */
public class PanicInteceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(PanicInteceptor.class);

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private PanicService panicService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        /*
         * 定时防刷新
         */
//        if (method.getName().equals("execute")) {
//
//            System.out.println("aaa");
//            ResponseUtil.write(response, 404, "抢购时间未到");
//            return false;
//        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;

        //Controller层执行时间统计
        if (logger.isDebugEnabled()) {
            logger.info("[" + handler + "] 执行时间为 : " + executeTime + "ms");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) throws Exception {
    }
}
