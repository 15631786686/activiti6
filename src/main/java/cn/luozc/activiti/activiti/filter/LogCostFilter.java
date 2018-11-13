package cn.luozc.activiti.activiti.filter;

import com.alibaba.druid.util.PatternMatcher;
import com.alibaba.druid.util.ServletPathMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LogCostFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(LogCostFilter.class);
    private Set<String> excludesPattern;
    private String contextPath;
    private PatternMatcher pathMatcher = new ServletPathMatcher();
    @Override
    public void init(FilterConfig config) throws ServletException {
        String param = "*.js,*.css,*.jpg,*.png,*.ico,*.html,*.gif,/user/login";
        this.excludesPattern = new HashSet (Arrays.asList(param.split("\\s*,\\s*")));
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        ((HttpServletRequest) servletRequest).getSession().setAttribute("dataBase","activiti");

        //记录请求的信息
        logger.info("请求者IP = {},请求这主机名称 = {},服务器的主机名 = {}, 请求的端口号 = {},请求的URI = {},请求者的 URL = {}"
                ,servletRequest.getRemoteAddr(),servletRequest.getRemoteHost()
                ,servletRequest.getServerName(),servletRequest.getServerPort(),uri,url);


        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }

    public boolean isExclusion(String requestURI) {
        if (this.excludesPattern == null) {
            return false;
        } else {
            if (this.contextPath != null && requestURI.startsWith(this.contextPath)) {
                requestURI = requestURI.substring(this.contextPath.length());
                if (!requestURI.startsWith("/")) {
                    requestURI = "/" + requestURI;
                }
            }

            Iterator<String> var2 = this.excludesPattern.iterator();

            String pattern;
            do {
                if (!var2.hasNext()) {
                    return false;
                }

                pattern = var2.next();
            } while(!this.pathMatcher.matches(pattern, requestURI));

            return true;
        }
    }
}
