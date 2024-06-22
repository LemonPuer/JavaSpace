<%--
  Created by IntelliJ IDEA.
  User: 16958
  Date: 2022/11/1
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单商品</title>
    <%@include file="/pages/comment/head.jsp" %>
    <script type="text/javascript">
        $(function (){
            $("input#receive").click(function (){
                if(confirm("您确定要发货吗?")){
                    location.href="<%=basePath%>orderServlet?action=sent&orderId=${param.orderId}";
                }
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">订单详情</span>
    <%@include file="/pages/comment/welcome.jsp" %>
</div>
<div id="main">
    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
        </tr>
        <c:forEach items="${requestScope.details}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.count}</td>
                <td>${item.price}</td>
                <td>${item.xPrice}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4"><input id="receive" type="button" value="发货" /></td>
        </tr>
    </table>
</div>
<%@ include file="/pages/comment/foot.jsp" %>

</body>
</html>
