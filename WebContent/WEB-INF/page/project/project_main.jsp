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
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/project/project_main.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/task/edit_task.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/project/edit_project.css" />
    <title>Online Exam System</title>
</head>
<body  class="vertical-scroll windows chrome with-mini-member-bar" data-category="home" style="min-height:154px;background-color: #eee;overflow: auto;">
    <f:block name="header"/>
    <f:block name="member_bar"/>
    
    <div id="content" class="clearfix">
    <f:block name="project_menu"/>
    <div class="project-home-view">
        <div class="project-home-left">
            <div class="main-operation">
                <div class="avatar img-circle img-48 pull-left" style="background-image:url(${sessionScope.currentUser.image});"></div>
                <div class="creater-operation">
                    <div class="handler-wrap">
                        <a class="creator-handler task-creator-handler new-task" data-toggle="modal" data-target="#newTask" data-gta="event" data-label="home|create task"> 
                            <span class="glyphicon glyphicon-check" style="font-size: 31px;"></span><br> 
                            <span class="handler-title">新任务</span> 
                        </a>
                    </div>
                    <div class="handler-wrap">
                        <a class="creator-handler task-creator-handler new-ticket" data-toggle="modal" data-target="#newTicket" data-gta="event" data-label="home|create task"> 
                            <span class="glyphicon glyphicon-paperclip" style="font-size: 31px;"></span><br> 
                            <span class="handler-title">新功能</span> 
                        </a>
                    </div>
                    <div class="handler-wrap">
                        <a class="creator-handler task-creator-handler" data-gta="event" data-toggle="modal" data-target="#newSchedule" data-label="home|create task"> 
                            <span class="glyphicon glyphicon-calendar" style="font-size: 31px;"></span><br> 
                            <span class="handler-title">新日程</span> 
                        </a>
                    </div>
                    <div class="handler-wrap">
                        <a class="creator-handler task-creator-handler" data-toggle="modal" data-target="#newSprint" data-gta="event" data-label="home|create task"> 
                            <span class="glyphicon glyphicon-refresh" style="font-size: 31px;"></span><br> 
                            <span class="handler-title">新迭代</span> 
                        </a>
                    </div>
                </div>
            </div>
            <ul class="reviews-card-view">
                <li class="reviews-card">
                    <header class="card-header guide-handler"> 今日动态 </header>
                    <c:choose>
                        <c:when test="${! empty todayDynamic}">
                            <section class="card-content">
                                <c:forEach items="${todayDynamic }" var="dynamic">
                                    <ul class="reviews-list">
                                        <li class="open-detail">
                                            <div class="avatar img-circle img-24" style="background-image:url(${dynamic.creatorImage});float: left;"></div>
                                            <div class="review-body">
                                                <p class="review-title">
                                                    <span class="review-executor">${dynamic.creatorName }</span>
                                                    <span>${dynamic.description }</span>
                                                </p>
                                                <p class="review-content"> 
                                                     <c:choose>
                                                         <c:when test="${dynamic.type eq 'TA' }">
                                                             <span class="glyphicon glyphicon-check"></span>
                                                         </c:when>
                                                         <c:when test="${dynamic.type eq 'P' }">
                                                             <span class="glyphicon glyphicon-ruble"></span>
                                                         </c:when>
                                                         <c:when test="${dynamic.type eq 'SP' }">
                                                             <span class="glyphicon glyphicon-refresh"></span>
                                                         </c:when>
                                                         <c:when test="${dynamic.type eq 'SC' }">
                                                             <span class="glyphicon glyphicon-calendar"></span>
                                                         </c:when>
                                                         <c:otherwise>
                                                              <span class="glyphicon glyphicon-paperclip"></span>
                                                         </c:otherwise>
                                                     </c:choose>
                                                    <span class="hinted auto-hint" title="${dynamic.objectName }">${dynamic.objectName }</span> 
                                                </p>
                                            </div>
                                            <div class="review-timeline">
                                                <time style="color: #a6a6a6;">${dynamic.createDayTime }</time>
                                            </div>
                                        </li>
                                    </ul>
                                </c:forEach>
                            </section>
                        </c:when>
                        <c:otherwise>
                            <div class="no-dynamic">暂无动态</div>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li class="reviews-card">
                    <c:choose>
                        <c:when test="${! empty lastDateDynamic}">
                            <header class="card-header guide-handler"> ${lastDateDynamic[0].createDate }动态 </header>
                            <section class="card-content">
                                <c:forEach items="${lastDateDynamic }" var="dynamic">
                                    <ul class="reviews-list">
                                        <li class="open-detail">
                                            <div class="avatar img-circle img-24" style="background-image:url(${dynamic.creatorImage});float: left;"></div>
                                            <div class="review-body">
                                                <p class="review-title">
                                                    <span class="review-executor">${dynamic.creatorName }</span>
                                                    <span>${dynamic.description }</span>
                                                </p>
                                                <p class="review-content"> 
                                                    <c:choose>
                                                         <c:when test="${dynamic.type eq 'TA' }">
                                                             <span class="glyphicon glyphicon-check"></span>
                                                         </c:when>
                                                         <c:when test="${dynamic.type eq 'P' }">
                                                             <span class="glyphicon glyphicon-ruble"></span>
                                                         </c:when>
                                                         <c:when test="${dynamic.type eq 'SP' }">
                                                             <span class="glyphicon glyphicon-refresh"></span>
                                                         </c:when>
                                                         <c:when test="${dynamic.type eq 'SC' }">
                                                             <span class="glyphicon glyphicon-calendar"></span>
                                                         </c:when>
                                                         <c:otherwise>
                                                              <span class="glyphicon glyphicon-paperclip"></span>
                                                         </c:otherwise>
                                                     </c:choose>
                                                    <span class="hinted auto-hint" title="${dynamic.objectName }">${dynamic.objectName }</span> 
                                                </p>
                                            </div>
                                            <div class="review-timeline">
                                                <time style="color: #a6a6a6;">${dynamic.createDayTime }</time>
                                            </div>
                                        </li>
                                    </ul>
                                </c:forEach>
                            </section>
                        </c:when>
                        <c:otherwise>
                            <header class="card-header guide-handler"> 前日动态 </header>
                            <div class="no-dynamic">暂无动态</div>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div>
        <div class="project-home-right">
            <div class="pin-wrap">
                <div class="sprint-info-div">
                    <header class="card-header">
                        <span>当前迭代信息</span>  
                        <c:choose>
                            <c:when test="${projectDTO.sprintName != null }">
                                <span class="sprint-name">(${projectDTO.sprintName })</span>  
                                <input type="hidden" class="currentSprintId" value="${projectDTO.sprintId }">
                            </c:when>
                            <c:otherwise>
                                <span class="sprint-name">(尚无迭代)</span>  
                            </c:otherwise>
                        </c:choose>
                    </header>
                    <section class="card-content">
                        <ul class="sprint-statistics-list">
                            <li class="statistic-wrap"> 
                                <a class="statistic-total-tasks" data-gta="event" data-label="home|enter total tasks"> 
                                    <span class="muted">任务总数</span><br>
                                    <span class="statistic-count total-tasks">${totalTaskCount }</span> 
                                </a>
                            </li>
                            <li class="statistic-wrap"> 
                                <a class="statistic-done-tasks" data-gta="event" data-label="home|enter tasks done"> 
                                    <span class="muted">已完成任务</span><br> <span class="statistic-count done-tasks">${completedTaskCount }</span> 
                                </a>
                            </li>
                            <li class="statistic-wrap"> 
                                <a class="statistic-today-tasks" data-gta="event" data-label="home|enter left time"> 
                                    <span class="muted">剩余迭代时间</span><br> 
                                    <span class="statistic-count left-time">${restSprintTime }天</span>
                                    <c:if test="${restSprintTime <= 0}">
                                        <button style="display: none;" class="btn btn-info">推迟到明日</button>
                                    </c:if>
                                </a>
                            </li>
                        </ul>
                    </section>
                </div>
                <div class="task-chart">
                    <header class="card-header">最近任务进展</header>
                    <canvas id="taskChart" width="360" height="280" style="margin-left: 7px;"></canvas>
                    <input type="hidden" class="taskChartLabels" value="${labels }">
                    <input type="hidden" class="taskChartData" value="${data }">
                </div>
            </div>
        </div>
    </div>
</div>
<f:block name="create_task"/>
<f:block name="edit_project"/>
<f:block name="create_sprint"/>
<f:block name="create_ticket"/>
<f:block name="create_project"/>
<f:block name="create_schedule"/>
</body>
<script type="text/javascript" src="<%=basePath %>/static/js/plugin/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/plugin/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/plugin/Chart.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/header.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/ticket/editTicket.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/task/editTask.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/project/projectMain.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/project/memberBar.js"></script>

</html>