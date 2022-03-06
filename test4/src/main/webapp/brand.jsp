<%@ page import="com.example.test4.entity.brand" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xzp
  Date: 2022/3/3
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <link rel="stylesheet" href="brandstyle.css"/>
  <link class="cssdeck" rel="stylesheet" href="/maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
</head>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<body>
<%
  List<brand> brands = (List<brand>) request.getAttribute("brands");
%>
<section>
  <!--for demo wrap-->

  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
      <tr>
        <th><input type="checkbox"></th>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
      </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody id="aaa">
<%--      <%--%>
<%--        for (brand brand : brands) {--%>
<%--      %>--%>
<%--      <tr>--%>
<%--        <td><%=brand.getId()%>--%>
<%--        </td>--%>
<%--        <td><%=brand.getBrandName()%>--%>
<%--        </td>--%>
<%--        <td><%=brand.getCompanyName()%>--%>
<%--        </td>--%>
<%--        <td><%=brand.getOrdered()%>--%>
<%--        </td>--%>
<%--        <td><%=brand.getDescription()%>--%>
<%--        </td>--%>
<%--        <td>--%>
<%--          <%--%>
<%--            if (brand.getStatus() == 0) {--%>
<%--          %>--%>
<%--          禁用--%>
<%--          <%--%>
<%--          } else {--%>
<%--          %>--%>
<%--          启用--%>
<%--          <%--%>
<%--            }--%>
<%--          %>--%>
<%--        </td>--%>
<%--        <td>--%>
<%--          <a href="${pageContext.request.contextPath}/selectById?id=<%=brand.getId()%>">修改</a>--%>
<%--          <a href="${pageContext.request.contextPath}/delete?id=<%=brand.getId()%>">删除</a>--%>
<%--        </td>--%>
<%--      </tr>--%>
<%--      <%--%>
<%--        }--%>
<%--      %>--%>

      </tbody>
    </table>

  </div>
</section>
<!-- follow me template -->
<div class="made-with-love">
  <form method="get" action="#">
    当前状态：<input type="text">
    公司名称：<input type="text">
    商品名称：<input type="text">
    <input type="submit" value="搜索">
  </form>
  <a href="#">添加</a>
  <br>
  <a href="#">上一页</a>
  <a href="#">下一页</a>
</div>
</body>
<script >
  window.onload=function (){
    axios({
      method:"get",
      url:"/index1"
    }).then(function (resp){
      let brands=resp.data;
      let tableDate=''

      for (let i=0;i<brands.length;i++){
        let brand=brands[i];
        tableDate +='<tr>\n' +
                            '<th><input type="checkbox"></th>'+
                '                                           <td> '+brand["id"]+' </td>\n' +
                '                                        <td>'+brand["brandName"]+' </td>\n' +
                '                                       <td>'+brand["companyName"]+' </td>\n' +
                '                                       <td>'+brand["ordered"]+' </td>\n' +
                '                                       <td>'+brand["description"]+' </td>\n' +
                '                                        <td>'+brand["status"]+' </td>\n' +
                '                                        <td>\n' +
                '                                            <a href="${pageContext.request.contextPath}/selectById?id='+brand["id"]+'">修改</a>\n' +
                '                                           <a href="${pageContext.request.contextPath}/delete?id='+brand["id"]+'">删除</a>\n' +
                '                                       </td>\n' +
                '                                   </tr>';
      }
      document.getElementById("aaa").innerHTML=tableDate;
    });

  }
</script>
</html>