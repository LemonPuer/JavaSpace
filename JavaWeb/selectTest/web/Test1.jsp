<%--
  Created by IntelliJ IDEA.
  User: 16958
  Date: 2022/10/22
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px" cellpadding="0px">
    <%
        for (int i = 1; i < 10; i++) {
    %>
    <tr>
        <%
            for (int j = i; j < 10; j++) {
        %>
        <td><%=i + "x" + j + "=" + i * j%>
        </td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
