<%@ page import="com.example.test1.entity.user" %>
<%@ page import="com.example.test1.entity.brand" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
</head>
<body>
<%
    List<brand> brands = (List<brand>) request.getAttribute("brands");
%>
<div class="container">
    <input type="button" value="新增" id="add">
    <hr>
    <table>
        <tr>
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌介绍</th>
            <th>状态</th>
            <th>操作</th>
        </tr>

        <%
            for (brand brand : brands) {
        %>
        <tr>
            <td><%=brand.getId()%>
            </td>
            <td><%=brand.getBrandName()%>
            </td>
            <td><%=brand.getCompanyName()%>
            </td>
            <td><%=brand.getOrdered()%>
            </td>
            <td><%=brand.getDescription()%>
            </td>
            <td>
                <%
                    if (brand.getStatus() == 0) {
                %>
                禁用
                <%
                } else {
                %>
                启用
                <%
                    }
                %>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/selectById?id=<%=brand.getId()%>">修改</a>
                <a href="${pageContext.request.contextPath}/delete?id=<%=brand.getId()%>">删除</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <a href="add.jsp">增加</a>
</div>
</body>
</html>