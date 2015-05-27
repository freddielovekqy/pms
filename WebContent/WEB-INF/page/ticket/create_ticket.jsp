<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="newTicket" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">新建功能模块</h4>
      </div>
      <div class="modal-body">
        <form class="save-ticket-form">
          <div class="form-group">
            <label for="recipient-name" class="control-label">功能模块名称</label>
            <input type="text" class="form-control" name="name">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">功能模块描述</label>
            <textarea class="form-control" name="description"></textarea>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="control-label">所属迭代</label>
            <select class="form-control" name="sprintId">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">功能模块类型</label><br>
            <select class="form-control" name="type">
                <option value="US">用例</option>
                <option value="DE">缺陷</option>
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">预估时间</label><br>
            <input type="text" class="form-control" name="planEst">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">状态</label><br>
            <select class="form-control" name="state">
                <option value="创建" class="state1">创建</option>
                <option value="正在工作" class="state2">正在工作</option>
                <option value="完成" class="state3">完成</option>
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">功能模块所属者</label>
            <select class="form-control" name="ownerId">
            </select>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary save-ticket-button" data-dismiss="modal">保存</button>
      </div>
    </div>
  </div>
</div>