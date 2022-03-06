package com.example.test4.web;

import com.example.test4.entity.brand;
import com.example.test4.service.brandservice1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(urlPatterns = "/selectById")
@Slf4j
public class selectbyid extends HttpServlet {
    private final brandservice1 brandService = new brandservice1();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        log.info(id);
        brand brand = brandService.selectById(Integer.parseInt(id));
        request.setAttribute("brand", brand);
        request.getRequestDispatcher("/updata.jsp").forward(request, response);
    }
}
