<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@include file="/pages/comment/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("button.addCart").click(function () {
                var bookId = $(this).attr("bookId");
                <%--location.href = "<%=basePath%>cartServlet?action=addItem&id=" + bookId;--%>
                $.getJSON("ajaxServlet","action=addItem&id="+bookId,function (data){
                    $("span.allCount").text("您的购物车中有 " + data.allCount + " 件商品");
                    $("div.lastBook").html("您刚刚将<span style='color: red'>"+data.lastBook+"</span>加入到了购物车中");
                });
            });
        });
    </script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">网上书城</span>
    <%@include file="/pages/comment/welcome.jsp" %>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="clientServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询"/>
            </form>
        </div>
        <c:if test="${empty sessionScope.cart.items}">
            <div style="text-align: center">
                <span class="allCount"></span>
                <div class="lastBook">
                    <span >您的购物车暂时还没有商品</span>
                </div>
            </div>
        </c:if>
        <c:if test="${!empty sessionScope.cart.items}">
            <div style="text-align: center">
                <span class="allCount">您的购物车中有 ${sessionScope.cart.allCount} 件商品</span>
                <div class="lastBook">
                    您刚刚将<span style="color: red">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </div>
        </c:if>
        <c:forEach begin="0" items="${requestScope.page.noteData}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.img_path}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button bookId="${book.id}" class="addCart">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <%@include file="/pages/comment/page.jsp" %>
</div>
<%@include file="/pages/comment/foot.jsp" %>
</body>
</html>