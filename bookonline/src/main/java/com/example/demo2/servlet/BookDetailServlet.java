package com.example.demo2.servlet;

import com.example.demo2.entity.Book;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/detail/*")
public class BookDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestPath = req.getRequestURI().trim();
        int position = requestPath.lastIndexOf("/");
        String id =requestPath.substring(position + 1);
        ServletContext sc =  this.getServletContext();
        List<Book> booklist = (List<Book>)sc.getAttribute("booklist");
        for(Book book : booklist){
            if(Integer.parseInt(id)  == book.getId()){
                req.setAttribute("book",book);
                resp.setContentType("type/plain;charset=utf-8");
                req.getRequestDispatcher("/book_detail.jsp").forward(req, resp);

            }
        }
    }
}
