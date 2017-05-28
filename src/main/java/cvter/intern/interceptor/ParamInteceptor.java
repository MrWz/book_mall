package cvter.intern.interceptor;

import cvter.intern.utils.ResponseUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created by cvter on 2017/5/27.
 */
public class ParamInteceptor implements HandlerInterceptor {
    public ParamInteceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Enumeration<String> keys=httpServletRequest.getParameterNames();
        String password=null;
        String rePassword=null;
        while (keys.hasMoreElements()) {
            String k=keys.nextElement();
            if (StringUtils.equals(k, "password")) {
                password=httpServletRequest.getParameter(k);
            }
            if (StringUtils.equals(k, "rePassword")) {
                rePassword=httpServletRequest.getParameter(k);
            }
            if (StringUtils.equals(k, "nums")) {
                String nums=httpServletRequest.getParameter(k);
                String pt="^[0-9]+$";
                boolean flag=nums.matches(pt);
                if (!flag) {
                    System.out.println("数量只能为数字哦");
                    ResponseUtil.write(httpServletResponse, 20005, "数量只能为数字哦");
                    return false;
                }
            }
            if (StringUtils.equals(k, "username") || StringUtils.equals(k, "password")) {
                String val=httpServletRequest.getParameter(k);
                String pt="^[0-9a-zA-Z]+$";
                boolean flag=val.matches(pt);
                if (val.length() < 6 || val.length() > 15 || !flag) {
                    System.out.println("----------------------------------用户名或密码非法");
                    ResponseUtil.write(httpServletResponse, 20005, "用户名或密码非法");
                    return false;
                }
            }
        }
        if (!StringUtils.isAnyBlank(password, rePassword)) {
            if (!StringUtils.equals(password, rePassword)) {
                System.out.println("----------------------------------两次密码不一致");
                ResponseUtil.write(httpServletResponse, 20005, "两次密码不一致");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
