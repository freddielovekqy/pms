<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath();  %>
<div class="modal fade edit-project-model" id="newProject" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">创建新项目</h4>
            </div>
            <div class="modal-body">
                <form class="saveProjectForm">
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">项目名称</label>
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="control-label">项目描述</label>
                        <textarea class="form-control" name="description"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="control-label">项目公开性</label>
                        <select class="form-control" name="isPublic">
                            <option value="0">私有项目（仅项目成员可见）</option>
                            <option value="1">公开项目（所有访客可见）</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary save-project-button" data-dismiss="modal">创建</button>
            </div>
        </div>
    </div>
</div>