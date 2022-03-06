<%--
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
    <form action="${pageContext.request.contextPath}/add" method="post" id="contact">
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
    <button id="btn">提交</button>


</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script><script>
    document.getElementById("btn").onclick=function(){
        var data={
            brandName:"",
            companyName:"",
            ordered:"",
            description:"",
            status:""
        }
        data.brandName = document.getElementById("brandName").value;
        data.companyName = document.getElementById("companyName").value;
        data.ordered = document.getElementById("ordered").value;
        data.description =document.getElementById("description").value;
        let status = document.getElementsByName("status");
        for (let i = 0; i < status.length; i++) {
            if (status[i].checked) {
                data.status = status[i].value;
            }
        }
        console.log(data)
        axios({
                  method: "post",
                  url: "/add1",
                  data: data
              }).then(function (resp) {
            if (resp.data!=null) {
                alert("aaa")
                location.href = "/index";
            }
        })

    }
</script>
</html>
