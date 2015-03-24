<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/login.css" />
<title>Login</title>
</head>
<body>
  <div class="jumbotron" style="padding-left: 100px">
    <h1>Hello, world!</h1>
    <p>Welcome to PMS.</p>
    <p><a class="btn btn-info btn-lg" href="#" role="button">Learn more</a></p>
  </div>
  <div class="form-horizontal loginForm">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="email" id="email" placeholder="请输入邮箱">
      <span class="glyphicon form-control-feedback" style="padding-right: 20px"></span>
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码">
      <span class="glyphicon form-control-feedback" style="padding-right: 20px"></span>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">登陆</button>
      <button type="button" class="btn btn-default" id="reset" style="margin-left: 40px">重置</button>
      <button type="button" class="btn btn-link" style="margin-left: 110px;">注册新账户</button>
    </div>
  </div>
</div>

<div id="errorModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">提示</h4>
      </div>
      <div class="modal-body">
        <p>用户名或密码错误！</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/dist/js/npm.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/user.js"></script>
</html>