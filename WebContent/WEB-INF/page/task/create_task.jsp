<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="newTask" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">创建新任务</h4>
      </div>
      <div class="modal-body">
        <form class="save-task-form">
          <div class="form-group">
            <label for="recipient-name" class="control-label">任务名称</label>
            <input type="text" class="form-control" name="name">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">任务描述</label>
            <textarea class="form-control" name="description"></textarea>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="control-label">所属功能模块</label>
            <select class="form-control" name="ticketId">
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">任务优先级</label>
            <select class="form-control" name="degree">
                <option value="1">普通</option>
                <option value="2">紧急</option>
                <option value="3">非常紧急</option>
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">任务时间</label><br>
            <span>总计时间</span>
            <input type="text" class="form-control small-text" name="estimate">
            <span>剩余时间</span>
            <input type="text" class="form-control small-text" name="todo">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">任务状态</label><br>
            <select class="form-control" name="state">
                <option class="state1" value="创建">创建</option>
                <option class="state2" value="正在工作">正在工作</option>
                <option class="state3" value="完成">完成</option>
            </select>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">是否阻塞</label><br>
            <label class="radio-inline">
                <input type="radio" name="blocked" id="blocked1" checked="checked" value="1"> 是
            </label>
            <label class="radio-inline">
                <input type="radio" name="blocked" id="blocked2" value="0"> 否
            </label>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">任务参与者</label>
            <select class="form-control" name="owner">
            </select>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary save-task-button" data-dismiss="modal">创建</button>
      </div>
    </div>
  </div>
</div>