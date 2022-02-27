package com.example.day1;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/hello4")
public class respvid extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("video/mp4");
        InputStream in = new FileInputStream("F:\\idea\\IdeaProjects\\demo2\\javaWeb\\day1\\src\\main\\java\\com\\example\\day1\\a.mp4");
        ServletOutputStream out = resp.getOutputStream();
        int read = 0;
        while ((read = in.read())!= -1){
            resp.getOutputStream().write(read);
        }
        resp.getOutputStream().close();
        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
