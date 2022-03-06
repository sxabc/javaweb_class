<%--
  Created by IntelliJ IDEA.
  User: xzp
  Date: 2022/3/3
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="loginstyle.css"/>
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
        <div class="login-form">
            <div class="sign-in-htm">
                <form method="post" action="/login">
                    <div class="group">
                        <label for="user" class="label">Username</label>
                        <input id="user" name="username" type="text" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Password</label>
                        <input id="pass" name="password" type="password" class="input" data-type="password">
                    </div>
                    <div class="group">
                        <input id="check" type="checkbox" class="check" name="remember" checked>
                        <label for="check"><span class="icon"></span> Keep me Signed in</label>
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="Sign In">
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk" style="color: crimson">

                        <%
                            request.getAttribute("message");
                        %>${message}
                    </div>
                </form>
            </div>
            <div class="sign-up-htm">
                <form method="get" action="/check">
                    <div class="sign-up-htm">

                        <div class="group">
                            <label for="user" class="label">Username</label>
                            <input id="user" type="text" name="username" class="input">
                        </div>

                        <div class="group">
                            <label for="pass" class="label">Password</label>
                            <input id="pass" type="password" name="password1" class="input" data-type="password">
                        </div>

                        <div class="group">
                            <label for="pass" class="label">Repeat Password</label>
                            <input id="pass" type="password" name="password2" class="input" data-type="password">
                        </div>

                        <div class="group">
                            <label for="pass" class="label">CAPTCHA</label>
                            <input id="pass" type="text" name="yzm" class="input">
                        </div>

                        <img src="/code" >
                        <div class="group">
                            <input type="submit" class="button" value="Sign Up">
                        </div>


                        <div class="hr"></div>
                        <div class="foot-lnk">
                            <a><label for="tab-1">Already Member?</label></a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>
