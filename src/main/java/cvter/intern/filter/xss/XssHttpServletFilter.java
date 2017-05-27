package cvter.intern.filter.xss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 包装原生servlet对象，处理xss问题
 */
public class XssHttpServletFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(XssHttpServletFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        try {
            XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(request);
            chain.doFilter(xssRequest, response);
        } catch (Exception e) {
            LOGGER.error("Xss过滤器，包装request对象失败");
            chain.doFilter(request, response);
        }
    }

}