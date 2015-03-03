<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/register.css" />
<title>注册 PMS账号</title>
</head>
<body>
    <img src="<%=basePath %>/static/image/topbanner.jpg" class="img-responsive" alt="Responsive image">
    <form role="form" action="" method="post" class="registerForm">
	  <div class="form-group">
	    <input type="email" class="form-control input-lg" id="email" placeholder="邮箱">
	  </div>
	  <div class="form-group">
        <input type="text" class="form-control input-lg" id="name" placeholder="姓名">
      </div>
      <div class="form-group">
        <input type="password" class="form-control input-lg" id="password" placeholder="密码（至少6位）">
      </div>
      <button type="button" class="btn btn-primary btn-lg" id="register" >注 册</button>
      <button type="submit" class="btn btn-default btn-lg loginButton">已有账号？登陆</button>
	 </form>
	 
</body>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/dist/js/npm.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/user.js"></script>
</html>