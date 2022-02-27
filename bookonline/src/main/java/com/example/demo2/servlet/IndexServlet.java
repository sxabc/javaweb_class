package com.example.demo2.servlet;

import com.example.demo2.entity.Book;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        List<Book> booklist = (List<Book>) sc.getAttribute("booklist");
        req.setAttribute("booklist",booklist);
        resp.setContentType("type/plain;charset=utf-8");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
