<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String basePath = request.getContextPath();%>
<div id="" class="member-bar">
    <div id="" class="add-member-div">
        <div style="float: left;" data-toggle="modal" data-target="#memberManager">
            <img src="http://localhost:8080/PMS/data/add_project_user.jpg" alt="" class="add-member">
        </div>
        <div class="add-member-info">
            <div>
                <span>分享链接邀请成员</span>
                <span id="copy-sign" class="glyphicon glyphicon-ok-sign copy-sign" aria-hidden="true" title="复制链接"></span>
            </div>
            <div class="add-member-url">
                <span id="add-member-url">${projectDTO.addMemberUrl }</span>
                <input id="add-member-url-input" value="${projectDTO.addMemberUrl }" style="display: none; width: 140px;">
                <span class="glyphicon glyphicon-remove-sign" style="display: none; cursor: pointer;"></span>
            </div>
        </div>
    </div>
    <c:forEach items="${projectUserDTOs }" var="projectUserDTO">
        <div class="member-li">
            <div class="avatar img-circle img-24 member" style="background-image:url(${projectUserDTO.userImage});"></div>
            <div class="member-info">
                <span class="member-name">${projectUserDTO.userName}(${projectUserDTO.jobNumber}) </span><br>
                <span class="member-email">${projectUserDTO.userEmail}</span>
            </div>
        </div>
    </c:forEach>
    <footer id="showMoreMemberInfo" class="project-user-footer">
        <div class="more-info">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        </div>
    </footer>
</div>

<!-- 成员管理 -->
<div class="modal fade" id="memberManager" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" style="top: 80px;width: 544px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel">成员管理</h4>
      </div>
      <div class="modal-body">
        <label for="recipient-name" class="control-label url-label">通过链接添加成员</label>
        <input type="text" class="form-control add-member-url" value="${projectDTO.addMemberUrl }">
        <span class="glyphicon glyphicon-refresh refresh-url"></span>
        <br>
        <div class="member-li member-mamager-li">
            <div class="avatar img-circle img-24 member" style="background-image:url(${projectDTO.creatorImage});"></div>
            <div class="member-info">
                <span class="member-name">${projectDTO.creatorName }(${projectDTO.creatorEmail }) </span><br>
                <span class="member-email">拥有者</span>
            </div>
        </div>
        <c:forEach items="${projectUserDTOs }" var="projectUserDTO">
            <c:if test="${projectUserDTO.userId != projectDTO.creatorId }">
            <div class="member-li member-mamager-li">
                <input type="hidden" name="projectUserId" value="${projectUserDTO.id }">
                <div class="avatar img-circle img-24 member" style="background-image:url(${projectUserDTO.userImage});"></div>
                <div class="member-info" style="width: 200px;">
                    <span class="member-name">${projectUserDTO.userName }(${projectUserDTO.userEmail }) </span><br>
                    <c:choose>
                        <c:when test="${projectUserDTO.isManager }">
                            <span class="member-email">管理员</span>
                        </c:when>
                        <c:when test="${!projectUserDTO.isManager }">
                            <span class="member-email">成员</span>
                        </c:when>
                    </c:choose>
                </div>
                <div class="member-button-div">
	                <c:choose>
	                    <c:when test="${projectUserDTO.isManager }">
	                        <button type="button" class="btn btn-primary update-member-privilege-button">取消管理员</button>
	                    </c:when>
	                    <c:when test="${!projectUserDTO.isManager }">
	                        <button type="button" class="btn btn-primary update-member-privilege-button">设为管理员</button>
	                    </c:when>
	                </c:choose>
                    <button type="button" class="btn btn-danger remove-member-button" data-dismiss="modal">移除成员</button>
                </div>
            </div>
            </c:if>
        </c:forEach>
      </div>
    </div>
  </div>    
</div>