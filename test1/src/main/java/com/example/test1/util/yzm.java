package com.example.test1.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/code")
public class yzm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width=110;
        int height=40;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g=image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
        g.setColor(Color.black);
        g.drawRect(0,0,width+1,height+1);
        String str="dasjdkaljdlajslkjaslkjlksajdlkdjlasllljkjldjsaslkdj23123";
        Random random = new Random();
        String aa = "";
        for (int i=1;i<=4;i++){
            int r = random.nextInt(256);
            int g1 = random.nextInt(256);
            int b = random.nextInt(256);
//            Color color = new Color(r, g1, b);
            g.setColor(Color.black);
            int index=random.nextInt(str.length());
            char c = str.charAt(index);
            aa+=c;
            g.drawString(String.valueOf(c),width/5*i,height/2);
        }
        HttpSession session = req.getSession();
        session.setAttribute("yzm",aa);
        g.setColor(Color.BLUE);
        for (int i=0;i<10;i++){
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            int r = random.nextInt(256);
            int g1 = random.nextInt(256);
            int b = random.nextInt(256);
            g.setColor(Color.getHSBColor(r,g1,b));
            g.drawLine(x1,x2,y1,y2);
        }
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
