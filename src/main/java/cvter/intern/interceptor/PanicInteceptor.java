package cvter.intern.interceptor;

import cvter.intern.dao.PanicDao;
import cvter.intern.model.Panic;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Enumeration;

/**
 * 判断抢购时间
 */
public class PanicInteceptor implements HandlerInterceptor {

    @Autowired
    private PanicDao panicDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration<String> keys = request.getParameterNames();
        String bookUid = null;
        while (keys.hasMoreElements()) {
            String k = keys.nextElement();
            if (StringUtils.equals(k, "bookUid")) {
                bookUid = request.getParameter(k);
                break;
            }
        }
        Panic panic = panicDao.selectByPrimaryKey(bookUid);

        Date now = new Date();
        Date startDate = panic.getStartTime();
        Date endDate = panic.getStartTime();

        if (now.after(startDate) && now.before(endDate)) {
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, Object o, Exception e) throws Exception {
    }
}
