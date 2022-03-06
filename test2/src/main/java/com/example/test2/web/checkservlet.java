package com.example.test2.web;


import com.example.test2.entity.user;
import com.example.test2.service.userservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/check")
public class checkservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userservice userservice = new userservice();
        String username = req.getParameter("username");
        user user1 = user.builder().username(username).build();
        boolean flag = userservice.register(user1);
        resp.getWriter().write(String.valueOf(flag));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
