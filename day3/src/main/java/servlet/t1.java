package servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/t1path")
public class t1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        String bpath = context.getRealPath("/b.txt");
        System.out.println(bpath);
        String cpath = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(cpath);
        String apath = context.getRealPath("/WEB-INF/classes/com/example/demo1/a.java");
        System.out.println(apath);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
