package com.example.test2.web;

import com.alibaba.fastjson.JSON;
import com.example.test2.entity.brand;
import com.example.test2.service.brandservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns="/add1")
public class add1 extends HttpServlet {
    private final brandservice bs = new brandservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader br = req.getReader();
        while ((line = br.readLine()) != null) {
            json.append(line);
            resp.getWriter().println("success");
        }
        brand brand = JSON.parseObject(json.toString(), brand.class);
        bs.add(brand);
        resp.getWriter().write("success");

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
