<%--
  Created by IntelliJ IDEA.
  User: 16958
  Date: 2022/10/23
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty sessionScope.name}">
    <div>
        <a href="pages/user/login.jsp">登录</a> |
        <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
        <a href="index.jsp">返回首页</a>
    </div>
</c:if>
<c:if test="${!empty sessionScope.name}">
    <div>
        <span>欢迎<span class="um_span">${sessionScope.name}</span>光临尚硅谷书城</span>
        <a href="orderServlet?action=getMine">我的订单</a>
        <a href="pages/cart/cart.jsp">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>
        <a href="index.jsp">返回首页</a>
        <a href="userServlet?action=logout">注销</a>
    </div>
</c:if>