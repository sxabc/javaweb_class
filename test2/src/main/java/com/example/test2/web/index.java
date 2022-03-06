package com.example.test2.web;


import com.example.test2.entity.brand;
import com.example.test2.entity.user;
import com.example.test2.service.brandservice;
import com.example.test2.service.userservice;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/index")
public class index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        brandservice bs = new brandservice();
        List<brand> brands = bs.selectAll();
        request.setAttribute("brands", brands);
        request.getRequestDispatcher("/brand.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
