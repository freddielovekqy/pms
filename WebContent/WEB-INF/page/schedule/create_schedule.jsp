<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String basePath = request.getContextPath();  %>
<div class="modal fade" id="newSchedule" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">创建日程</h4>
      </div>
      <div class="modal-body">
        <form class="save-schedule-form">
          <div class="form-group">
            <label for="recipient-name" class="control-label">日程名称</label>
            <input type="text" class="form-control" name="name">
            <input type="hidden" name="projectId" value="${projectDTO.id }">
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
            <div class="input-append date" id="datetimepicker3" data-date="2015-2-3 13:30" data-date-format="yyyy-mm-dd HH:ii">
                <input class="span2 form-control" size="16" name="startTime" type="text" value="2015-2-3 13:30">
                <span class="add-on"><i class="icon-th"></i></span>
            </div>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">预计时长(小时)</label><br>
            <input type="text" class="form-control" name="time" value="2">
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary save-schedule-button" data-dismiss="modal">创建</button>
      </div>
    </div>
  </div>
</div>