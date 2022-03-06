package com.example.day7.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Random;

//@WebFilter(urlPatterns = "/*",filterName = "characterfilter")
public class characterfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("项目初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String[] urls = {"/login.jsp","/img/","/css/","/js","/loginServlet","/register.jsp","/registerServlet","/verifyCodeServlet"};
        String url = request.getRequestURI().toString();
        for(String u : urls){
            if(url.contains(u)){
                filterChain.doFilter(request,servletResponse);
                return;
            }
        }
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        resp.setContentType("text/plain;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("项目结束化");
    }
}
