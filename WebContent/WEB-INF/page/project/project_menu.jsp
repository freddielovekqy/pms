<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String basePath = request.getContextPath(); %>
<nav class="project-nav-tabs">
    <a id="project" class="project" data-toggle="modal" data-target="#projects">
        <span>${projectDTO.name }</span>
        <span class="glyphicon glyphicon-chevron-down"></span>
    </a>
    <a href="<%=basePath %>/project/showProjectMainPage?projectId=${projectDTO.id}" class="project-nav-tab">主页</a>
    <a href="<%=basePath %>/task/showTaskListPage?projectId=${projectDTO.id}" class="project-nav-tab">任务板</a>
    <a href="<%=basePath %>/schedule/showScheduleList?projectId=${projectDTO.id}" class="project-nav-tab">日程表</a>
    <a href="<%=basePath %>/attachment/showFolderList?projectId=${projectDTO.id}" class="project-nav-tab">文件库</a>
    <a class="project-setting" data-toggle="modal" data-target="#editProject">
        <span>设置</span>
        <span class="glyphicon glyphicon-wrench"></span>
    </a>
    <input type="hidden" id="projectId" value="${projectDTO.id }">
</nav>

<div class="modal fade" id="projects" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog project-model">
        <div class="modal-content">
            <div class="modal-body">
                <c:forEach items="${projectDTOs }" var="projectDTO">
                    <a href="<%=basePath %>/project/showProjectMainPage?projectId=${projectDTO.id}">${projectDTO.name }</a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>