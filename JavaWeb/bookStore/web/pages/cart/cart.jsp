<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/comment/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a#aOrder").click(function (){
                if(${empty sessionScope.userId}){
                    alert("请先登录账号!");
                    return false;
                }
            });
            $("a.clear").click(function (){
                return confirm("确定要清空购物车吗？")
            });
            $("a.delete").click(function (){
                return confirm("确定要删除【" + $(this).parent().parent().find("td:first").text() +"】吗？");
            });
            $("td.bookCount").click(function () {
                var count = 1;
                if (this.firstChild.tagName != "INPUT") {
                    count = this.innerText;
                    this.innerHTML = "<input type='text' size=4/>";
                    var input = this.firstChild;
                    input.value = count;
                    input.select();
                    input.onchange = update;
                } else {
                    this.firstChild.select();
                    this.firstChild.onchange = update;
                }
            });

            function update() {
                var id = $(this).parent().attr("bookId");
                var count = this.value;
                if (confirm("确定要修改【" + $(this).parent().parent().find("td:first").text() + "】的数量吗？")) {
                    location.href = "cartServlet?action=update&id=" + id + "&count=" + count;
                }
            }
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/comment/welcome.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">
        <tr>
            <td colspan="5"><a href="index.jsp">购物车里没有商品，快去首页看看吧!</a></td>
        </tr>
    </table>
    </c:if>
    <c:if test="${!empty sessionScope.cart.items}">
        <c:forEach items="${sessionScope.cart.items}" var="item">
            <tr>
                <td>${item.value.name}</td>
                <td class="bookCount" bookId=${item.value.id}>${item.value.count}</td>
                <td>${item.value.price}</td>
                <td>${item.value.xprice}</td>
                <td><a class="delete" href="<%=basePath%>cartServlet?action=delete&id=${item.value.id}">删除</a></td>
            </tr>
        </c:forEach>
        </table>
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.allCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.allPrice}</span>元</span>
            <span class="cart_span"><a class="clear" href="<%=basePath%>cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a id="aOrder" href="orderServlet?action=addO">去结账</a></span>
        </div>
    </c:if>
</div>
<%@ include file="/pages/comment/foot.jsp" %>
</body>
</html>