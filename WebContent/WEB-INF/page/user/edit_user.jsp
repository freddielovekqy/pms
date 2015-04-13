<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/user/create_edit_user.css" />
<title>修改信息</title>
</head>
<body>
  <img src="<%=basePath %>/static/image/topbanner.jpg" class="img-responsive" alt="Responsive image">
  <form role="form" action="updateUser" method="post" class="registerForm">
    <div class="form-group">
      <input type="email" readonly="readonly" value="${userDTO.email }" class="form-control input-lg" name="email" placeholder="邮箱">
    </div>
    <div class="form-group">
      <input type="text" class="form-control input-lg" value="${userDTO.name }" name="name" placeholder="姓名">
    </div>
    <div class="form-group">
      <input type="password" readonly="readonly" value="${userDTO.password }" class="form-control input-lg" name="password" placeholder="密码（至少6位）">
      <span>修改密码</span>
    </div>
    <button type="button" class="btn btn-primary btn-lg">保 存</button>
  </form>
</body>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/user/edit_user.js"></script>
</html>