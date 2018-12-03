<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2018/11/30
  Time: 下午8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆页面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".name input").focus(function(){
                $(this).prev("i").css({"background-image":"url${pageContext.request.contextPath}/(img/user2.png)"});
            });
            $(".name input").blur(function(){
                $(this).prev("i").css({"background-image":"url(${pageContext.request.contextPath}/img/user1.png)"});
            });
            $(".password input").focus(function(){
                $(this).prev("i").css({"background-image":"url(${pageContext.request.contextPath}/img/password2.png)"});
            });
            $(".password input").blur(function(){
                $(this).prev("i").css({"background-image":"url(img/password1.png)"});
            });
        });
    </script>
</head>
<body>
<div class="container">
    <div class="wrap">
        <header><em>Hospital Remainder System</em></header>
        <article>
            <section>
                <aside>
                    <em>
                        <img src="${pageContext.request.contextPath}/img/user.png">
                    </em>
                    <form action="${pageContext.request.contextPath}/LoginCheck" method="post">
                        <p class="name"><i></i><input type="text" name="userName" name="userName" class="userName" placeholder="Please enter your ID"</p>
                        <p class="password"><i></i><input type="password" name="password" class="pwd" placeholder="Please enter your password"></p>
                        <button>Login</button>
                        <div class="clear"></div>
                    </form>
                </aside>

            </section>
        </article>

    </div>
</div>
</body>
</html>

