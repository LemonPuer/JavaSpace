<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@include file="/pages/comment/head.jsp"%>
</head>
<body>
<jsp:forward page="clientServlet?action=cPage&pageNo=1"></jsp:forward>
</body>
</html>