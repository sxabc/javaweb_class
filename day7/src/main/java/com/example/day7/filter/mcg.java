package com.example.day7.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
@WebFilter(urlPatterns = "/*")
public class mcg implements Filter {
    private final List<String> list = new ArrayList<>( );
    private final String methodName = "getParameter" ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            ServletContext servletContext = filterConfig.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/com.example.day7.filter/a.txt");
//            InputStream in=new FileInputStream(realPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(realPath), "utf8"));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
                System.out.println(line);
            }
            br.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest proxyReq =(ServletRequest) Proxy.newProxyInstance(servletRequest.getClass().getClassLoader(), servletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodName.equals(method.getName())){
                    String value = (String) method.invoke(servletRequest,args);
                    if (value != null) {
                        for (String str :list){
                            if (value.contains(str)){
                                value =value.replaceAll(str,"***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(servletRequest,args);
            }
        });
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(proxyReq, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
