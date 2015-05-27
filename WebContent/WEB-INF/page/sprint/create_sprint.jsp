<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="modal fade" id="newSprint" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">创建新迭代</h4>
      </div>
      <div class="modal-body">
        <form class="save-sprint-form">
          <div class="form-group">
            <label for="recipient-name" class="control-label">迭代名称</label>
            <input type="text" class="form-control" name="name">
            <input type="hidden" name="projectId" value="${projectDTO.id }">
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">迭代描述</label>
            <textarea class="form-control" name="description"></textarea>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">开始时间</label><br>
            <div class="input-append date" id="datetimepicker1" data-date="2015-2-3 13:30" data-date-format="yyyy-mm-dd HH:ii">
                <input class="span2 form-control" size="16" name="startDate" type="text" value="2015-2-3 13:30">
                <span class="add-on"><i class="icon-th"></i></span>
            </div> 
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">结束时间</label><br>
            <div class="input-append date" id="datetimepicker2" data-date="2015-2-3 13:30" data-date-format="yyyy-mm-dd HH:ii">
                <input class="span2 form-control" size="16" name="endDate" type="text" value="2015-2-3 13:30">
                <span class="add-on"><i class="icon-th"></i></span>
            </div>
          </div>
          <div class="form-group">
            <label for="message-text" class="control-label">上一个迭代中未完成的订单任务处理方式</label>
            <div>
                <label class="radio-inline">
                  <input type="radio" name="isMove" id="inlineRadio1" value="1"> 移动到新的迭代
                </label>
                <label class="radio-inline">
                  <input type="radio" name="isMove" id="inlineRadio2" value="0"> 标记为完成
                </label>
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary save-sprint-button" data-dismiss="modal">创建</button>
      </div>
    </div>
  </div>
</div>