<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath(); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="../../pms.tld"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/dist/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/dist/css/bootstrap-datetimepicker.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/header.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/user/member_bar.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/project/project_menu.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/project/edit_project.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/file/file.css" />
    <title>Online Exam System</title>
</head>
<body  class="vertical-scroll windows chrome with-mini-member-bar" data-category="home" style="min-height:154px;background-color: #eee;overflow: auto;">
    <f:block name="header"/>
    <f:block name="member_bar"/>
    
    <div id="content" class="clearfix">
    <f:block name="project_menu"/>
    <div class="file-main-div">
        <header class="library-header"> 
            <div class="library-title">文件库</div>
            <div class="library-header-handler">
                <span class="add-folder" data-toggle="modal" data-target="#newFolder">添加文件夹</span>
                <span id="uploadFile" class="file-name"></span>
                <input type="hidden" id="baseFilePath"/>
                <div class="fileUpload btn btn-primary">
                    <span class="glyphicon glyphicon-cloud-upload"></span>
                    <span class="file-button-value">选择文件</span>
                    <input id="uploadBtn" name="file" type="file" class="upload"/>
                </div>
            </div>  
        </header>
        <div class="library-handler-set clearfix"> 
            <div class="library-info-header"> 
                <span class="library-info-name"> 名称 </span> 
                <span class="library-info-size"> 大小 </span> 
                <span class="library-info-author"> 创建者 </span> 
                <span class="library-info-update"> 更新时间 </span> 
            </div>
        </div>
        <div class="folders">
        <c:forEach items="${folderDTOs }" var="folderDTO">
            <div class="library-info library-handler-set">
                <input type="hidden" class="folderId" id="folder${folderDTO.id }" value="${folderDTO.id }">
                <a class="library-info-name"> 
                    <span class="glyphicon glyphicon-folder-open icon-big-size"></span>
                    <span class="folderName" style="margin-left: 13px;">${folderDTO.name }</span>  
                </a> 
                <span class="library-info-size"> ${folderDTO.fileSize } </span> 
                <span class="library-info-author"> ${folderDTO.creatorName } </span> 
                <span class="library-info-update"> ${folderDTO.createTime } </span>
                <a class="glyphicon glyphicon-pencil edit-folder-icon" data-toggle="modal" data-target="#editFolder"></a>
                <a class="glyphicon glyphicon-trash remove-folder-icon"></a>
            </div>
        </c:forEach>
        </div>
    </div>
    <div class="modal fade" id="newFolder" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog new-folder-model">
            <div class="modal-content">
                <div class="modal-body">
                    <input type="text" id="newFolderName" placeholder="文件夹名称" class="form-control" style="width: 135px; display: inline;">
                    <button type="button" class="btn btn-primary new-folder-button" data-dismiss="modal">创建</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="editFolder" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog edit-folder-model">
            <div class="modal-content">
                <div class="modal-body">
                    <input type="hidden" id="editFolderId">
                    <input type="text" id="editFolderName" placeholder="文件夹名称" class="form-control" style="width: 135px; display: inline;">
                    <button type="button" class="btn btn-primary update-folder-name-button" data-dismiss="modal">更新</button>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="<%=basePath %>/static/js/plugin/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/plugin/ajaxfileupload.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/header.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/project/memberBar.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/file/file.js"></script>

</html>