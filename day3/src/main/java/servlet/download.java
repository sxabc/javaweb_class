package servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/dl")
public class download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/images/"+filename);
        InputStream is=new FileInputStream(realPath);
        resp.setHeader("content-disposition","attachment;filename="+filename);
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len;
        while ((len = is.read(buff)) !=-1){
            sos.write(buff,0,len);
        }
        sos.close();
        is.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }


}
