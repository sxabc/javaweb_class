package com.example.test1.web;

import com.example.test1.entity.user;
import com.example.test1.service.userservice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class loginservlet extends HttpServlet {
    private final userservice userservice = new userservice();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user user = userservice.login(username, password);
        String remember = request.getParameter("remember");
        System.out.println(remember+"==================================");
        if(user != null){
            if("on".equals(remember)){
                System.out.println("记录cookie");
                Cookie cusername = new Cookie("username",username);
                Cookie cpassword = new Cookie("password",password);
                cusername.setMaxAge(60*60*24*7);
                cpassword.setMaxAge(60*60*24*7);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            String contextPath = request.getContextPath();
            System.out.println(contextPath);
            response.sendRedirect(contextPath + "/index");
        }else{
            request.setAttribute("message","用户名或者密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
