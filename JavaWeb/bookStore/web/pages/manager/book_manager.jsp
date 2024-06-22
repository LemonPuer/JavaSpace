<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@include file="/pages/comment/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.isDelete").click(function () {
                return confirm("确认要删除【" + $(this).parent().parent().find("td:first").text() + "】吗？");
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%@include file="/pages/comment/manage.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach begin="0" items="${requestScope.page.noteData}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="bookServlet?action=findBook&id=${book.id}&pageNo=${param.pageNo}">修改</a></td>
                <td><a class="isDelete" href="bookServlet?action=delete&id=${book.id}&pageNo=${param.pageNo}">删除
                </a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?action=add&pageNo=${requestScope.page.allPage}">添加图书</a></td>
        </tr>
    </table>
    <%@include file="/pages/comment/page.jsp"%>
</div>
<%@ include file="/pages/comment/foot.jsp" %>
</body>
</html>