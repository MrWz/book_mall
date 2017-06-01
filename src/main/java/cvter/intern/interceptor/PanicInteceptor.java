package cvter.intern.interceptor;

import cvter.intern.dao.PanicDao;
import cvter.intern.model.Panic;
import cvter.intern.service.PanicService;
import cvter.intern.utils.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Date;
import java.util.Enumeration;

/**
 * 判断抢购时间
 */
public class PanicInteceptor implements HandlerInterceptor {
    private static Logger logger=LoggerFactory.getLogger(PanicInteceptor.class);

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private PanicService panicService;

    @Autowired
    private PanicDao panicDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration<String> keys=request.getParameterNames();
        String bookUid=null;
        while (keys.hasMoreElements()) {
            String k=keys.nextElement();
            if (StringUtils.equals(k, "bookUid")) {
                bookUid=request.getParameter(k);
                break;
            }
        }
        Panic panic= panicDao.selectByPrimaryKey(bookUid);

        Date now=new Date();
        Date startDate=panic.getStartTime();
        Date endDate=panic.getEndTime();

        if(now.after(startDate) && now.before(endDate)){
            return true;
        }
        return false;
        /*
         * 定时防刷新
         */
//        if (method.getName().equals("execute")) {
//
//            System.out.println("aaa");
//            ResponseUtil.write(response, 404, "抢购时间未到");
//            return false;
//        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime=(Long) request.getAttribute("startTime");
        long endTime=System.currentTimeMillis();
        long executeTime=endTime - startTime;

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
