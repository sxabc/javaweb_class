<%@ page import="com.example.test4.entity.brand" %><%--
  Created by IntelliJ IDEA.
  User: xzp
  Date: 2022/3/3
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="addstyle.css"/>
</head>
<body>
<div class="container">
    <%
        brand brand = (brand) request.getAttribute("brand");
    %>
    <form action="${pageContext.request.contextPath}/updateBrand" method="post" id="contact">
        <input type="hidden" name="id" value="<%=brand.getId()%>">
        <table>
            <tr>
                <td>
                    <label for="brandName">
                        品牌名称
                    </label>
                </td>
                <td><input type="text" name="brandName" value="<%=brand.getBrandName()%>" id="brandName"></td>
            </tr>

            <tr>
                <td>
                    <label for="companyName">
                        企业名称
                    </label>
                </td>
                <td><input type="text" name="companyName" value="<%=brand.getCompanyName()%>" id="companyName"></td>
            </tr>

            <tr>
                <td>
                    <label for="ordered">
                        排序
                    </label>
                </td>
                <td><input type="text" name="ordered" value="<%=brand.getOrdered()%>" id="ordered"></td>
            </tr>

            <tr>
                <td>
                    <label for="description">
                        描述信息
                    </label>
                </td>
                <td>
                        <textarea name="description" rows="10" cols="50" id="description">
                              <%=brand.getDescription()%>
                        </textarea>
                </td>
            </tr>

            <tr>
                <td> 状态</td>
                <td>
                    <%
                        if (brand.getStatus() == 1) {
                    %>
                    <input name="status" type="radio" id="ok" value="1" checked>
                    <label for="ok">
                        启用
                    </label>
                    <input name="status" type="radio" id="no" value="0">
                    <label for="no">
                        禁用
                    </label>
                    <%
                    } else {
                    %>
                    <input name="status" type="radio" id="ok" value="1">
                    <label for="ok">
                        启用
                    </label>
                    <input name="status" type="radio" id="no" value="0" checked>
                    <label for="no">
                        禁用
                    </label>
                    <%
                        }
                    %>
                </td>
            </tr>
        </table>
        <fieldset>
            <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
        </fieldset>

    </form>
</div>
</body>
</html>
