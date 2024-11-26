package com.example.dbcec.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

//    @Override
//    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
//        // 初始化逻辑
//        System.out.println("init");
//    }
    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        // 过滤器初始化
        System.out.println("111");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        // 登录验证逻辑
//        String token = httpServletRequest.getHeader("Authorization");
//        if (token == null || !isTokenValid(token)) {
//            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            return;
//        }

        // 如果验证通过，继续链路
        chain.doFilter(request, response);
    }

    private boolean isTokenValid(String token) {
        // 这里应该是验证token的逻辑，例如与数据库中的token比对
        // 假设token总是有效的
        return true;
    }

    @Override
    public void destroy() {
        // 过滤器销毁
    }
}