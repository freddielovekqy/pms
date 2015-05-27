<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="../../pms.tld"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/dist/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/header.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/main.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/user/add-project-member.css" />
    <title>main</title>
</head>
<body class="vertical-scroll windows chrome with-mini-member-bar" data-category="home" 
    style="min-height:154px;background-color: #eee;">
    <f:block name="header"/>
    
    <div id="projects" class="projects">
        <div id="" class="project-block">
            <span>查看项目</span>
            <br><br>
            <div id="" class="project">
                <div id="projectAttr" class="project-attr">
                    <input type="hidden" id="projectId" value="${projectDTO.id }">
                    <h3 class="project-name">${projectDTO.name }</h3>
                    <span class="project-intro">${projectDTO.description }</span>
                </div>
            </div>
        </div>
        <div class="project-detail-info">
            <span>详细信息</span>
            <div class="info">
                <div class="info-item">
                    <label class="info-label">项目名称</label><br>
                    <span class="info-text">${projectDTO.name }</span>
                </div>
                <div class="info-item">
                    <label class="info-label">描述</label><br>
                    <span class="info-text">${projectDTO.description }</span>
                </div>
                <div class="info-item">
                    <label class="info-label">创建人</label><br>
                    <span class="info-text">${projectDTO.creatorName }</span>
                </div>
                <div class="info-item">
                    <label class="info-label">创建时间</label><br>
                    <span class="info-text">${projectDTO.createTimeStr }</span>
                </div>
                <div class="info-item">
                    <label class="info-label">是否公开</label><br>
                    <c:choose>
                        <c:when test="${projectDTO.isPublic == 1}">
                            <span class="info-text">是</span>
                        </c:when>
                        <c:otherwise>
                            <span class="info-text">否</span>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
        <div class="join-project-button">
            <button type="button" class="btn btn-primary btn-lg" id="joinInProject">加 入 项 目</button>
        </div>
    </div>
</body>
<script type="text/javascript" src="<%=basePath %>/static/js/plugin/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/header.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/user/add_project_member.js"></script>
</html>