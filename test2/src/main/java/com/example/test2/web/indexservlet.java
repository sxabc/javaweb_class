package com.example.test2.web;



import com.alibaba.fastjson.JSON;
import com.example.test2.entity.brand;
import com.example.test2.service.brandservice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/index1")
public class indexservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        brandservice bs = new brandservice();
        List<brand> brands = bs.selectAll();
        request.setAttribute("brands", brands);
        String a = JSON.toJSONString(brands);
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().write(String.valueOf(a));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
