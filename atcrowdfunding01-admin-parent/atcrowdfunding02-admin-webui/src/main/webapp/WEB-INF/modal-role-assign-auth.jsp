<%--
  Created by IntelliJ IDEA.
  User: 16958
  Date: 2023/6/9
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="assignModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">尚筹网系统弹窗</h4>
            </div>
            <div class="modal-body">
                <ul id="authTreeDemo" class="ztree"></ul>
            </div>
            <div class="modal-footer">
                <button id="assignBtn" type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>
