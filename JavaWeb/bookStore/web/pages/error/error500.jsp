<%--
  Created by IntelliJ IDEA.
  User: 16958
  Date: 2022/11/2
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>服务器内部错误</title>
    <%@include file="/pages/comment/head.jsp" %>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">出错啦!</span>
    <%@include file="/pages/comment/welcome.jsp" %>
</div>
<div id="main">
    <h1 align=center><a href="index.jsp">抱歉，服务器出错了，程序猿小哥正在抢修，回主页看看吧!</a></h1>
</div>
</body>
</html>
