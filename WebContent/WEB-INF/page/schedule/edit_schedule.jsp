<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String basePath = request.getContextPath();  %>
<div class="modal fade" id="editSchedule" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">修改日程</h4>
      </div>
      <div class="modal-body">
        <form class="update-schedule-form">
          <div class="form-group">
            <label for="recipient-name" class="control-label">日程名称</label>
            <input type="text" class="form-control" name="name">
            <input type="hidden" name="projectId" value="${projectDTO.id }">
            <input type="hidden" name="id">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">日程描述</label>
            <textarea class="form-control" name="description"></textarea>
          </div>
          <div class="form-group">
            <label for="recipient-name" class="control-label">日程地点</label>
            <input type="text" class="form-control" name="place">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">开始时间</label><br>
            <div class="input-append date" id="datetimepicker4" data-date="2015-2-3 13:30" data-date-format="yyyy-mm-dd HH:ii">
                <input class="span2 form-control" size="16" name="startTime" type="text">
                <span class="add-on"><i class="icon-th"></i></span>
            </div>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">预计时长(小时)</label><br>
            <input type="text" class="form-control" name="time">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary update-schedule-button" data-dismiss="modal">更新</button>
      </div>
    </div>
  </div>
</div>