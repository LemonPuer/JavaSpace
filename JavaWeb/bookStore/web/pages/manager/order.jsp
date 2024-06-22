<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看订单</title>
    <%@include file="/pages/comment/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">查看订单</span>
    <%@include file="/pages/comment/welcome.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
        </tr>
        <c:if test="${empty sessionScope.all}">
            <tr>
                <td colspan="4">没有订单!</td>
            </tr>
        </c:if>
        <c:if test="${!empty sessionScope.all}">
            <c:forEach items="${sessionScope.all}" var="order">
                <tr>
                    <td>${order.createTime}</td>
                    <td>${order.allPrice}</td>
                    <c:if test="${order.status==-1}"><td>未发货</td></c:if>
                    <c:if test="${order.status==0}"><td>已发货</td></c:if>
                    <c:if test="${order.status==1}"><td>已签收</td></c:if>
                    <td><a class="details" href="orderServlet?action=getDetails&orderId=${order.orderId}&a=0">查看详情</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
<%@ include file="/pages/comment/foot.jsp" %>
</body>
</html>