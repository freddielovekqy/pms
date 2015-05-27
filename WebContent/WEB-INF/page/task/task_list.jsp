<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="../../pms.tld"%>
<% String basePath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/dist/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/header.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/user/member_bar.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/project/project_menu.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/task/edit_task.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/project/edit_project.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/task/task_list.css" />
    <title>任务板</title>
</head>
<body class="vertical-scroll windows chrome with-mini-member-bar" data-category="home" style="min-height:154px;background-color: #eee;overflow: auto;">
    <f:block name="header"/>
    <f:block name="member_bar"/>
    
    <div id="content" class="clearfix">
        <f:block name="project_menu"/>
    
        <select class="form-control sprint-list">
            <c:choose>
                <c:when test="${sprintDTOs != null }">
                    <c:forEach items="${sprintDTOs }" var="sprintDTO">
                        <option value="${sprintDTO.id }">${sprintDTO.name }</option>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <option>暂无迭代</option>
                </c:otherwise>
            </c:choose>
        </select>
    
        <div class="panel panel-default task-table">
          <!-- Table -->
          <table class="table" style="table-layout: fixed;">
            <thead>
	            <th width="25px"></th>
	            <th width="60px">编号</th>
	            <th width="510px">名称</th>
	            <th width="100px">状态</th>
	            <th width="87px">预计时间</th>
	            <th width="120px">任务总时间</th>
	            <th>剩余时间</th>
	            <th>拥有者</th>
	            <th width="100px"></th>
	        </thead>
            <c:forEach items="${ticketDTOs }" var="ticketDTO">
                <tr class="${ticketDTO.serialStr }-data">
                    <td>
                        <c:if test="${ticketDTO.taskCount > 0 }">
                            <span class="glyphicon glyphicon-plus show-more-task" title="展示任务"> </span>
                        </c:if>
                        <input type="hidden" class="ticket" value="${ticketDTO.id }">
                    </td>
                    <td>${ticketDTO.serialNumber } </td>
                    <td title="${ticketDTO.serialStr }：${ticketDTO.name }">${ticketDTO.serialStr }：${ticketDTO.name }</td>
                    <td>${ticketDTO.state }</td>
                    <td>${ticketDTO.planEst }</td>
                    <td>${ticketDTO.taskEst }</td>
                    <td>${ticketDTO.todo }
                        <c:if test="${ticketDTO.blocked}">
                            <img src="http://localhost:8080/PMS/data/lock.png" class="lock">
                        </c:if>
                    </td>
                    <td>${ticketDTO.ownerName }</td>
                    <td>
                        <a><span class="glyphicon glyphicon-pencil" data-toggle="modal" data-target="#editTicket"></span></a>&nbsp;
                        <a><span class="glyphicon glyphicon-trash"></span> </a>&nbsp;
                        <a><span title="添加任务" class="glyphicon glyphicon-plus-sign" data-toggle="modal" data-target="#newTask"></span></a>
                    </td>
                </tr>
            </c:forEach>
          </table>
        </div>
        <nav>
          <ul class="pagination page">
            <c:choose>
                <c:when test="${pagination != null}">
                    <li class="disabled"><a  aria-label="Previous" class="pagination"><span aria-hidden="true">&laquo;</span></a></li>
                    <li class="active"><a class="pagination pageCount1">1 <span class="sr-only">1</span></a></li>
                    <c:if test="${pagination.totalPageCount >= 2 }">
                        <c:forEach var="i" begin="2" end="${pagination.totalPageCount }">
                            <li ><a class="pagination pageCount${i }">${i } <span class="sr-only">${i }</span></a></li>
                        </c:forEach>
                    </c:if>
                    <li><a aria-label="Next" class="pagination"><span aria-hidden="true">&raquo;</span></a></li>
                </c:when>
            </c:choose>
          </ul>
        </nav>
    </div>
    <f:block name="edit_task"/>
    <f:block name="create_task"/>
    <f:block name="edit_project"/>
    <f:block name="edit_ticket"/>
</body>
<script type="text/javascript" src="<%=basePath %>/static/js/plugin/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/plugin/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/header.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/project/memberBar.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/task/editTask.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/ticket/editTicket.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/task/taskList.js"></script>
</html>