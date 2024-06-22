<%--
  Created by IntelliJ IDEA.
  User: 16958
  Date: 2022/10/29
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="get">
    用户名:
    <input type="text" name="name" value="${cookie.name.value}"/><br>
    密码:
    <input type="password" name="password"><br>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
