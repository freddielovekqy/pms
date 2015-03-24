<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath();  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="projects" class="projects">
	<div id="" class="">
		<span class="my-project-title">个人项目</span>
		<br/><br>
		<c:forEach var="projectDTO" items="${projectDTOs}" varStatus="status">
			<div id="" class="project">
				<div id="projectAttr" class="project-attr">
					<h3 class="project-name">${projectDTO.name }</h3>
					<span class="project-intro">${projectDTO.description }</span>
				</div>
			</div>
		</c:forEach>
	</div>
	<div id="" class="filed-projects">
		<span class="filed-project-title">已归档项目</span>
		<br><br>
		<div id="" class="project">
			<div id="projectAttr" class="project-attr">
				<h3 class="project-name">PMS</h3>
				<span class="project-intro">项目管理系统</span>
			</div>
		</div>
	</div>
</div>