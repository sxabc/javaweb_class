package com.example.demo2.listen;

import com.example.demo2.entity.Book;
import com.example.demo2.entity.User;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import javax.naming.InitialContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebListener
public class ContentLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Tomcat启动了");
        //创建并生成用户数据列表
        List<User> userlist = new ArrayList<>(7);
        User[] users = {
                new User(1,"aaa@qq.com","aaa","aaa","aaa","aaa", LocalDate.of(2020,8,9)),
                new User(2,"bbb@qq.com","bbb","bbb","bbb","bbb", LocalDate.of(2020,8,9)),
                new User(3,"ccc@qq.com","ccc","ccc","ccc","ccc", LocalDate.of(2020,8,9)),
                new User(4,"ddd@qq.com","ddd","ddd","ddd","ddd", LocalDate.of(2020,8,9)),
                new User(5,"eee@qq.com","eee","eee","eee","eee", LocalDate.of(2020,8,9)),
                new User(6,"fff@qq.com","fff","fff","fff","fff", LocalDate.of(2020,8,9)),
                new User(7,"ggg@qq.com","ggg","ggg","ggg","ggg", LocalDate.of(2020,8,9))
        };
        userlist = Arrays.asList(users);

        List<Book> booklist = new ArrayList<>(7);
        Book[] books = {
                new Book(1,"qqq","/book1.jpeg","qqq"),
                new Book(2,"www","/book2.jpeg","www"),
                new Book(3,"eee","/book3.jpeg","eee"),
                new Book(4,"rrr","/book4.jpeg","rrr"),
                new Book(5,"ddd","/book5.jpeg","ddd"),
                new Book(6,"fff","/book6.jpeg","fff"),
                new Book(7,"aaa","/book7.jpeg","aaa")
        };
        booklist = Arrays.asList(books);

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("user",userlist);
        servletContext.setAttribute("booklist",booklist);
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Tomcat停止了");
    }
}
