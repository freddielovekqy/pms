<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/dist/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/header.css" />
    <title>header</title>
</head>
<body class="vertical-scroll windows chrome with-mini-member-bar" data-category="home" style="min-height:154px">
    <header id="navigator" class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="nav-first">
                <a class="logo" data-gta="event" data-label="enter portal by logo">PMS</a>
            </div>
            <div class="pull-left clearfix nav-handler-set">
                <div class="nav-handler"> 
                    <a class="projects-handler" data-gta="event" data-label="return project or portal"> 项目 </a> 
                </div> 
                <div class="nav-handler"> 
                    <a class="organization-switcher-handler" data-gta="event" data-label="open organization switch menu"> 组织 </a> 
                </div> 
                <div class="nav-handler"> 
                    <a class="my-handler" data-gta="event" data-label="enter my"> 我的 
                        <span class="badge">${mesCount }</span> 
                    </a> 
                </div> 
                <div class="nav-handler"> 
                    <a class="inbox-handler" data-gta="event" data-label="enter inbox"> 收件箱 <span class="message-badge"></span> 
                    </a> 
                </div> 
            </div>
            <div class="pull-right clearfix">
                <div class="nav-handler nav-separate">
                    <a class="create-handler guide-handler" data-guide="navCreate" data-toggle="dropdown" data-gta="event" data-label="create project or organization"> 
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>创建 </a>
                </div>
                <div class="nav-handler nav-separate my-set">
                    <a data-toggle="dropdown" data-gta="event" data-label="user bar|show user menu">
                        <div class="avatar img-circle img-24" style="background-image:url(https://mailimg.teambition.com/logos/19.png);"></div>
                        <span class="user-name">王超</span>
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
    <div id="content" class="clearfix">
    </div>
</body>
<script type="text/javascript" src="<%=basePath %>/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/npm.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/header.js"></script>
</html>