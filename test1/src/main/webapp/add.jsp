<%@ page import="com.example.test1.entity.brand" %><%--
  Created by IntelliJ IDEA.
  User: xzp
  Date: 2022/3/1
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/add" method="post">
    <table>
        <tr>
            <td>
                <label for="brandName">
                    品牌名称
                </label>
            </td>
            <td><input name="brandName" id="brandName" type="text"></td>
        </tr>

        <tr>
            <td>
                <label for="companyName">
                    企业名称
                </label>
            </td>
            <td><input name="companyName" id="companyName" type="text"></td>
        </tr>

        <tr>
            <td>
                <label for="ordered">
                    排序
                </label>
            </td>
            <td><input name="ordered" id="ordered" type="text"></td>
        </tr>

        <tr>
            <td>
                <label for="description">
                    描述信息
                </label>
            </td>
            <td>
                    <textarea rows="10" cols="50" name="description" id="description">
                  </textarea>
            </td>
        </tr>
        <tr>
            <td>
                状态
            </td>
            <td>
                <input name="status" type="radio" id="ok" value="1" checked>
                <label for="ok">
                    启用
                </label>
                <input name="status" type="radio" id="no" value="0">
                <label for="no">
                    禁用
                </label>
            </td>
        </tr>

    </table>

    <div style="padding-left: 20px;">
        <input type="submit" value="提交">
    </div>
</form>
</body>
</html>
