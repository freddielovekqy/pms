<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath();  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade edit-project-model" id="editProject" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">编辑项目</h4>
            </div>
            <div class="modal-body">
                <form class="updateProjectForm">
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">项目名称</label>
                        <input type="text" class="form-control project-name" name="name" required="required" value="${projectDTO.name }">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="control-label">项目描述</label>
                        <textarea class="form-control" name="description">${projectDTO.description }</textarea>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="control-label">项目公开性</label>
                        <select class="form-control" name="isPublic">
                            <c:if test="${projectDTO.isPublic eq 1}">
                                <option value="1">公开项目（所有访客可见）</option>
                                <option value="0">私有项目（仅项目成员可见）</option>
                            </c:if>
                            <c:if test="${projectDTO.isPublic eq 0}">
                                <option value="0">私有项目（仅项目成员可见）</option>
                                <option value="1">公开项目（所有访客可见）</option>
                            </c:if>
                        </select>
                    </div>
                    <input type="hidden" name="id" value="${projectDTO.id }">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary update-project-button" data-dismiss="modal">更新</button>
            </div>
        </div>
    </div>
</div>