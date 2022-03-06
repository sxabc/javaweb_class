package com.example.test1.web;

import com.example.test1.entity.user;
import com.example.test1.service.userservice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/regist")
public class registservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String yzm = request.getParameter("yzm");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Object yzm1 = session.getAttribute("yzm");
        if(password1.equals(password2)&&yzm.equals(yzm1)){
            user user = new user();
            user.setUsername(username);
            user.setPassword(password1);
            userservice us = new userservice();
            boolean flag = us.register(user);
            if (flag) {
                response.getWriter().write("<script>alert('注册成功');location='/login.html';</script>");
            } else {
                response.getWriter().write("<script>alert('用户名已存在');location='/register.html';</script>");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
