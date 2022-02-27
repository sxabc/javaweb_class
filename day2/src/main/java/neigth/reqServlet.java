package neigth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/result")
public class reqServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getProtocol());
        System.out.println(req.getContextPath());
        System.out.println(req.getCookies());
        System.out.println(req.getServletPath());
        System.out.println(req.getQueryString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getProtocol());
//        System.out.println(req.getContextPath());
//        System.out.println(req.getParameter("password"));
        String name = req.getParameter("name");
        System.out.println(name);
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("content-type","text/plain;charset=utf-8");
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().println(name);
        resp.getWriter().close();
    }
}
