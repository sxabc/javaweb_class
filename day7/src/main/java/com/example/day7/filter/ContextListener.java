package com.example.day7.filter;


/**
 * @Author 沈永康
 * @Date 2022/3/4 20:49
 * @Version 1.0
 */


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.util.HashMap;
import java.util.Map;

@WebListener
public class ContextListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
         private static Map<String,Object> sessionMap;
    public ContextListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("ContextLoaderListener初始化，加载资源....");
        sessionMap =new HashMap<>(8);
        sce.getServletContext().setAttribute("sessionMap",sessionMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("销毁，释放资源");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        System.out.println("sessionCreated 创建了新的会话");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        System.out.println("sessionDestroy,销毁的会话");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
        HttpSession session = sbe.getSession();
        System.out.println(session.getAttribute("username")+"online");
        sessionMap.put(session.getId(),session.getAttribute("username"));

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        HttpSession session = sbe.getSession();
        System.out.println(session.getAttribute("username")+"outline");
        sessionMap.put(session.getId(),session.getAttribute("username"));
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
