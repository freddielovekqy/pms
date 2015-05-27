<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath(); %>
<%@ taglib prefix="f" uri="../../pms.tld"%>

<header id="navigator" class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="nav-first">
            <a class="logo" data-gta="event" data-label="enter portal by logo">PMS</a>
        </div>
        <div class="pull-left clearfix nav-handler-set">
            <div class="nav-handler"> 
                <a class="projects-handler" href="<%=basePath %>/project/showProjectList" data-gta="event" data-label="return project or portal"> 项目 </a> 
            </div> 
            <div class="nav-handler"> 
                <a class="organization-switcher-handler" data-gta="event" data-label="open organization switch menu">欢迎使用项目管理系统 </a> 
            </div> 
            
        </div>
        <div class="pull-right clearfix">
            <div class="nav-handler nav-separate">
                <a class="create-handler guide-handler" data-guide="navCreate" data-toggle="modal" data-target="#newProject" data-gta="event" data-label="create project or organization"> 
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>创建 </a>
            </div>
            <div class="nav-handler nav-separate my-set">
                <a data-toggle="dropdown" data-gta="event" data-label="user bar|show user menu">
                    <div class="avatar img-circle img-24" style="background-image:url(${sessionScope.currentUser.image});"></div>
                    <span class="user-name"  data-toggle="modal" data-target="#profile">${sessionScope.currentUser.name}</span>
                </a>
            </div>
            <div class="nav-handler search"> 
                <a class="search-handler" data-gta="event" data-label="enter search">
                    <span class="glyphicon glyphicon-search"></span>
                </a> 
            </div>
        </div>
    </div>
</header>

<!-- 创建项目 -->
<f:block name="create_project"/>

<!-- Profile -->
<div class="modal fade" id="profile" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <a href="<%=basePath%>/user/initEditUser">个人设置</a>
                <a href="<%=basePath%>/user/logout">退出登录</a>
            </div>
        </div>
    </div>
</div>