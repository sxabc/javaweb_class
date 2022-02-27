package com.example.day3;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is responseDemo1");
        //resp.setStatus(302);

        //resp.setHeader("location","/hello2");

        req.setAttribute("xzp","ahhhhhhh");
        req.getRequestDispatcher("/hello2").forward(req,resp);
    }
}