package com.example.day4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.URLPermission;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/servletC")
@Slf4j
public class servletC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = "你好";
        value = URLEncoder.encode(value, StandardCharsets.UTF_8);
        log.info(value);
        req.setAttribute("name",value);
        req.getRequestDispatcher("/servletD").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
