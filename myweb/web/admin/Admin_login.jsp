<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!--仅仅是在用户登录jsp的基础上删除了一些功能-->

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <meta charset="utf-8">
   <title>登录</title>
   <script src="../other/jquery-3.3.1.js"></script>
   <link rel="stylesheet" href="../other\bootstrap-3.3.7-dist\css\bootstrap.css">  
   <script src="../other\bootstrap-3.3.7-dist\js\bootstrap.js"></script>
   <style type="text/css">
	#submit,#regist{
		width:100%;
	}
	.hidden{
		display:none;
	}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<h1>欢迎进入Saimot网上商城管理系统</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<form action="/myweb/AdminLogin" method="post">   <!--链接到管理员身份验证servlet-->
					<div class="form-group has-feedback" id="input1">
						<div class="input-group">
      						<div class="input-group-addon"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></div>
      						<input type="text" class="form-control" placeholder="请输入管理员账号" name="username" id="username">
    					</div>
					</div>
					<div class="form-group has-feedback" id="input2">
						<div class="input-group">
      						<div class="input-group-addon"><span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span></div>
      						<input type="password" class="form-control" placeholder="请输入密码" name="password" id="password">
      						<div class="input-group-addon"><span class="glyphicon glyphicon-eye-close" aria-hidden="true" id="view"></span></div>
    					</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="登录" id="submit">
					</div>
					<div class="form-group">
						<div class="alert alert-warning hidden" role="alert" id="alert">用户名或密码错误，请重新输入</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
  		$("#view").click(function(){
  			var attr = $("#password").attr("type");
  			if(attr=="password"){
  				$("#password").attr("type","text");
  				$("#view").removeClass("glyphicon-eye-close");
  				$("#view").addClass("glyphicon-eye-open");
  			}
  			else{
  				$("#password").attr("type","password");
  				$("#view").removeClass("glyphicon-eye-open");
  				$("#view").addClass("glyphicon-eye-close");
  			}
  		});

  		$("#username").bind('input propertychange',function(){
			$("#input1").addClass("has-success");
		});

		$("#password").bind('input propertychange',function(){
			$("#input2").addClass("has-success");
		});
	});

	<%String success = (String)session.getAttribute("success");     //登录失败还是需要返回一个值给用户看
	  if(success!=null&&success.equals("1")){
		  session.removeAttribute("success");
	%>
	$(document).ready(function(){
		$("#input1,#input2").addClass("has-error");
		$("#alert").removeClass("hidden");

		$("#username,#password").bind('input propertychange',function(){
			$("#alert").addClass("hidden");
		});

		$("#username").bind('input propertychange',function(){
			$("#input1").removeClass("has-error");
		});

		$("#password").bind('input propertychange',function(){
			$("#input2").removeClass("has-error");
		});
	});
	<%}%>
</script>
</html>
