
<%@ page import="java.util.List" %>

<%@ page import="com.example.demo2.entity.Book" %>
<%@ page import="com.example.demo2.entity.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .bd {
            color: #d5d5d5;
            background-color: #545652;

            width: 100%;
            min-width: 950px;
            font: 12px Helvetica, Arial, sans-serif;
            line-height: 28px;

            display: flex;

        }

        .bd-item {
            padding-left: 12px;
            padding-right: 12px;
        }

        .title {
            color: #614e3c;
            margin-left: 10px;
            margin-top: 10px;
            font-size: 30px;
        }

        .nav-search {
            display: flex;
            align-content: center;
            padding-left: 180px;
            border-bottom: 1px solid #e5ebe4;
            padding-bottom: 20px;
        }

        .inp {
            float: left;
            width: 470px;
            height: 34px;
            text-align: center;
            margin-right: -3px;
            cursor: text;
            color: #111;
            background-image: url(//img3.doubanio.com/dae/accounts/resources/3e96b44/book/assets/nav_bk_bg.png?s=1);
            margin-top: 15px;
            margin-left: 50px;
        }

        .inp input {
            background: #fff;
            width: 96%;
            margin: 0;
            text-align: left;
            height: 30px;
            padding-left: 10px;
            -webkit-appearance: none;
            border: none;
        }

        .inp-btn {
            position: relative;
            left: -1px;
            width: 37px;
            height: 34px;
            zoom: 1;
            overflow: hidden;
            font: 12px Helvetica, Arial, sans-serif;
            line-height: 1.62;
            color: #111;
            margin-top: 15px;
        }

        .inp-btn input {
            width: 100%;
            height: 100%;
            font-size: 0;
            padding: 35px 0 0 0;
            overflow: hidden;
            color: transparent;
            cursor: pointer;
            margin-right: 3px;
            vertical-align: middle;
            background: url(//img3.doubanio.com/dae/accounts/resources/3e96b44/book/assets/nav_bk_bg.png?s=1) no-repeat 0 -40px;
            -webkit-appearance: none;
            border: none;
        }

        .nav-secondary {
            display: flex;
            font-size: 14px;
            color: #614e3c;
            margin-bottom: 20px;
            margin-top: 20px;
            padding-bottom: 20px;
            border-bottom: 1px solid #ddd;
            width: 700px;
        }

        .nav-secondary div {
            padding-left: 20px;
            padding-right: 20px;
        }

        .row {
            display: flex;
            flex-wrap: wrap;
            justify-content: flex-start;
        }

        .main {
            width: 1200px;
            display: flex;
            margin-left: 180px;
        }

        .col-2 {
            flex: 0 0 16.6%;
        }

        .card {
            display: block;
            width: 115px;
            height: 172px;
            align-self: flex-end;
            margin: 10px 0px 10px 0px;
        }

        .col-8 {
            flex: 0 0 66%;
        }

        .col-4 {
            flex: 0 0 33%;
        }

        .book-title {
            font-size: 14px;
            margin-bottom: 6px;
            line-height: 1.1;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            width: 115px;
        }

        .author {
            color: #333;
            width: 102px;
            font-size: 13px;
            margin-bottom: 6px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .info {
            margin: 10px 10px 10px 10px;
        }
    </style>
</head>
<body>
<%
    List<Book> booklist = (List<Book>) request.getAttribute("booklist");
    User user = (User) session.getAttribute("user");
    pageContext.setAttribute("user", user);
%>
<div>
    <div class="bd">
        <div class="bd-item">首页</div>
        <div class="bd-item">读书</div>
        <div class="bd-item">电音</div>
        <div class="bd-item">音乐</div>
        <div class="bd-item">同城</div>
        <div class="bd-item">小组</div>
        <div class="bd-item">阅读</div>
        <div class="bd-item">FM</div>
        <div class="bd-item">时间</div>

        <div style="display: flex; justify-content: center; align-content: center; position: absolute; right: 0">
            <%--根据user是否为空，显示不同的内容--%>
            <%
                if (user != null) {
            %>
            <div>
                <a href="${pageContext.request.contextPath}/user">
                    <img style="border-radius: 50%; width: 5vmin; height: 5vmin; object-fit: cover; object-position: center;" src="images/${user.avatar}" alt="" class="avatar">
                </a>
            </div>
            <div>
                <a href="${pageContext.request.contextPath}/logout">退出</a>
            </div>
            <%
            } else {
            %>
            <a href="${pageContext.request.contextPath}/login">去登录</a>
            <%
                }
            %>
        </div>
    </div>

    <div style="background-color: #f6f6f1" class="nav-search">
        <div class="title">在线书</div>
        <div class="inp">
            <input id="inp-query" name="search_text" size="22" maxlength="60" placeholder="书名、作者、ISBN"
                   value="" autocomplete="off">
        </div>
        <div class="inp-btn"><input type="submit" value="搜索"></div>
    </div>

    <div class="main">
        <div class="row col-8">
            <div class="nav-secondary">
                <div>购书单</div>
                <div>电子图书</div>
                <div>书店</div>
                <div>2021年度榜单</div>
            </div>

            <%
                for (Book book : booklist) {
                    pageContext.setAttribute("book", book);
            %>
            <div class="col-2 info">
                <a href="${pageContext.request.contextPath}/detail/${book.id}">
                    <img class="card" src="images/${book.cover}" alt="">
                </a>
                <p style="color: rgb(51, 119, 178)" class="book-title">${book.name}</p>
                <p class="author"> ${book.author}</p>
            </div>
            <%
                }
            %>
        </div>
        <div class="col-4">
            <img src="images/tag.png" style="width: 320px; height: 580px; margin-top: 20px" alt="">
        </div>
    </div>
</div>
</body>
</html>