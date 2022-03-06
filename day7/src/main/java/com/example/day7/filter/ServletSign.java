package com.example.day7.filter;


/**
 * @Author 沈永康
 * @Date 2022/3/4 21:03
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = "/signServlet")
public class ServletSign extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String username = request.getParameter("username");
      request.getSession().setAttribute("username",username);
      response.setContentType("text/html;charset=utf-8");
      response.sendRedirect("/users.jsp");
    }
}
