<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath(); %>
<%@ taglib prefix="f" uri="../pms.tld"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/dist/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/header.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/main.css" />
	<title>main</title>
</head>
<body class="vertical-scroll windows chrome with-mini-member-bar" data-category="home" style="min-height:154px;background-color: #eee;">
	<f:block name="header"/>
	<f:block name="project_simple"/>
</body>
<script type="text/javascript" src="<%=basePath %>/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/dist/js/npm.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/header.js"></script>
</html>