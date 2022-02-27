package neigth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "parameterServlet",
        urlPatterns = "/param",
        initParams = {
                @WebInitParam(name = "a",value = "aaaaaaa"),
                @WebInitParam(name = "b",value = "bbbbbbbb")
        }
)
public class parameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String one = this.getInitParameter("a");
        String two = this.getInitParameter("b");
        PrintWriter pw = resp.getWriter();
        pw.println(one);
        pw.println(two);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
