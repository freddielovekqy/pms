<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath();  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="projects" class="projects">
    <div id="" class="">
        <span class="my-project-title">个人项目</span>
        <br/><br>
        <c:choose>
            <c:when test="${not empty onlineProjectDTOs }">
                <c:forEach var="projectDTO" items="${onlineProjectDTOs}" varStatus="status">
                    <div id="" class="project">
                        <div id="projectAttr" class="project-attr">
                            <h3 class="project-name">${projectDTO.name }</h3>
                            <span class="project-intro">${projectDTO.description }</span>
                            <input type="hidden" class="projectId" value="${projectDTO.id }">
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <div class="no-project">
                    <span>没有项目</span>&nbsp;&nbsp;
                    <a>创建</a>
                </div>
            </c:otherwise>
        </c:choose>
        
    </div>
    <div id="" class="filed-projects">
        <span class="filed-project-title">已归档项目</span>
        <br><br>
        <c:if test="${not empty filedProjectDTOs }">
            <c:forEach var="projectDTO" items="${filedProjectDTOs}" varStatus="status">
                <div id="" class="project">
                    <div id="projectAttr" class="project-attr">
                        <h3 class="project-name">${projectDTO.name }</h3>
                        <span class="project-intro">${projectDTO.description }</span>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>