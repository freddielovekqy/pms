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
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/project/project_menu.css" /
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/project/edit_project.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/schedule/schedule.css" />
    <title>Online Exam System</title>
</head>
<body  class="vertical-scroll windows chrome with-mini-member-bar" data-category="home" style="min-height:154px;background-color: #eee;overflow: auto;">
    <f:block name="header"/>
    <f:block name="member_bar"/>
    <div id="content" class="clearfix">
        <f:block name="project_menu"/>
        <button type="button" class="btn btn-default create-schedule-button" data-toggle="modal" data-target="#newSchedule">新增日程</button>

        <div class="panel panel-default schedule-table">
          <!-- Table -->
            <table class="table" style="table-layout: fixed;">
                <thead>
                    <th width="60px">编号</th>
                    <th width="250px">名称</th>
                    <th width="300px">描述</th>
                    <th width="100px">日程地点</th>
                    <th width="87px">开始时间</th>
                    <th width="120px">预计时间(小时)</th>
                    <th width="100px"></th>
                </thead>
                <c:forEach items="${scheduleDTOs }" var="scheduleDTO">
                    <tr class="schedule ${scheduleDTO.id }">
                        <td class="scheduleId">${scheduleDTO.id }</td>
                        <td class="scheduleName">${scheduleDTO.name }</td>
                        <td class="scheduleDescription">${scheduleDTO.description }</td>
                        <td class="schedulePlace">${scheduleDTO.place }</td>
                        <td class="scheduleStartTimeStr">${scheduleDTO.startTimeStr }</td>
                        <td class="scheduleTime">${scheduleDTO.time }</td>
                        <td>
                            <a><span class="glyphicon glyphicon-pencil" data-toggle="modal" data-target="#editSchedule"></span></a>&nbsp;
                            <a><span class="glyphicon glyphicon-trash"></span> </a>&nbsp;
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <f:block name="create_schedule"/>
    <f:block name="edit_schedule"/>
    <f:block name="edit_project"/>
</body>
<script type="text/javascript" src="<%=basePath %>/static/js/plugin/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/plugin/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/plugin/Chart.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/header.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/project/memberBar.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/schedule/schedule.js"></script>
</html>