package com.example.day3;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.Context;
import java.io.IOException;

@WebServlet(urlPatterns = "/context")
public class servletcontextdemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletContext sc1 = req.getServletContext();
        ServletContext sc2 = this.getServletContext();
//        System.out.println(sc1 == sc2);
        String filename = "a.jpg";
        String m = sc2.getMimeType(filename);
        System.out.println(m);
        sc2.setAttribute("data","hello world");
        resp.sendRedirect("/hello2");
    }
}
