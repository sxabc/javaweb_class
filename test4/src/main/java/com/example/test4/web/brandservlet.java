package com.example.test4.web;

import com.example.test4.entity.brand;
import com.example.test4.entity.PageBean;


import com.example.test4.service.BrandServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/brand/*")
public class brandservlet extends baseServlet{

    private final BrandServiceImpl brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<brand> brands = brandService.selectAll();
        String jsonString = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader br = request.getReader();
        while ((line = br.readLine()) != null) {
            json.append(line);
        }
        brand brand = JSON.parseObject(json.toString(), brand.class);
        brandService.add(brand);
        response.getWriter().write("success");
    }

    public void deleteByIds( HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        BufferedReader br = request.getReader();
        String params = br.readLine();
        int[] ids = JSON.parseObject(params, int[].class);
        brandService.deleteByIds(ids);
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String currentPageStr = request.getParameter("currentPage");
        String pagesizeStr = request.getParameter("pagesize");
        int currentPage = Integer.parseInt(currentPageStr);
        int pagesize = Integer.parseInt(pagesizeStr);
        PageBean<brand> PageBean = brandService.selectByPage(currentPage, pagesize);
        String jsonString = JSON.toJSONString(PageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException {

        String currentPageStr = request.getParameter( "currentPage" );
        String pagesizeStr = request. getParameter( "pageSize" );
        int currentPage = Integer.parseInt( currentPageStr);
        int pagesize = Integer.parseInt(pagesizeStr) ;
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader br = request.getReader();
        while ((line = br.readLine()) != null) {json.append(line);
        }
        brand brand = JSON.parseObject( json.toString(),brand.class);
        PageBean<brand> PageBean = brandService.selectByPageAndCondition( currentPage,pagesize,brand ) ;
        String jsonString = JSON.toJSONString(PageBean);
        response.setContentType( "text/json;charset=utf-8" );
        response.getWriter().write(jsonString);
    }
}
