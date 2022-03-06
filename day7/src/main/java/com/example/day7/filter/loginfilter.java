package com.example.day7.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.rmi.server.RemoteObject;

//@WebFilter(urlPatterns = "/*",filterName = "loginfilter")
public class loginfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String[] urls = {"/login.jsp","/img/","/css/","/js","/loginServlet","/users.jsp","/registerServlet","/verifyCodeServlet"};
        String url = request.getRequestURI().toString();
        for(String u : urls){
            if(url.contains(u)){
                filterChain.doFilter(request,servletResponse);
                return;
            }
        }
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        String message = "";
        if(user!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            message = "没有登录";
            request.setAttribute("message",message);
            request.getRequestDispatcher("/a.html").forward(request,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
