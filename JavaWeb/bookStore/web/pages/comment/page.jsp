<%--
  Created by IntelliJ IDEA.
  User: 16958
  Date: 2022/10/27
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.url}&pageNo=1">首页</a>
        <a href="${requestScope.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>

    <c:choose>
        <%--总页码小于等于 5 的情况，页码的范围是：1-总页码--%>
        <c:when test="${requestScope.page.allPage<=5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.allPage}"/>
        </c:when>
        <%--总页码大于 5 的情况--%>
        <c:when test="${requestScope.page.allPage>5}">
            <c:choose>
                <%--当前页码为前面 3 个：1，2，3 的情况，页码范围是：1-5--%>
                <c:when test="${requestScope.page.pageNo<=3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--当前页码为最后 3 个，页码范围是：总页码减 4 - 总页码--%>
                <c:when test="${requestScope.page.pageNo>requestScope.page.allPage-3}">
                    <c:set var="begin" value="${requestScope.page.allPage-4}"/>
                    <c:set var="end" value="${requestScope.page.allPage}"/>
                </c:when>
                <%--4，5，6，7，页码范围是：当前页码减 2 - 当前页码加 2--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i==requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i!=requestScope.page.pageNo}">
            <a href="${requestScope.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNo<requestScope.page.allPage}">
        <a href="${requestScope.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.url}&pageNo=${requestScope.page.allPage}">末页</a>
    </c:if>
    共${requestScope.page.allPage}页，${requestScope.page.allNote}条记录
    到第<input value="${requestScope.page.pageNo}" name="pn" id="pn_input"/>页
    <input id="butForPage" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            $("#butForPage").click(function () {
                var page = $("#pn_input").val();
                if (page >${requestScope.page.allPage}) {
                    page =${requestScope.page.allPage};
                } else if (page < 1) {
                    page = 1;
                }
                location.href = "${pageScope.basePath}${requestScope.url}&pageNo=" + page;
            });
        });
    </script>
</div>
