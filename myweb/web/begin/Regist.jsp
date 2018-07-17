<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <meta charset="utf-8">
   <title>注册</title>
   <script src="../other/jquery-3.3.1.js"></script>
   <link rel="stylesheet" href="../other\bootstrap-3.3.7-dist\css\bootstrap.css">  
   <script src="../other\bootstrap-3.3.7-dist\js\bootstrap.js"></script>
   <style type="text/css">
   	.hidden{
   		display:none;
   	}
   	.full{
   		width:100%;
   	}
   </style>
   <script type="text/javascript">
		function check(){
			var password1 = document.getElementById("password1");
			var password2 = document.getElementById("password2");
			var userid = document.getElementById("userid");
			var reg=/^[0-9]{1,5}$/;
			if(userid.value.length>5){
				alert("用户编号不能超过五位");
				return false;
			}
			if(password1.value!=password2.value){
				alert("两次密码输入不同，请重新输入");
				return false;
			}
			return true;
		}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<h2>请输入相关信息</h2>
				<form action="/myweb/CustomerRegister" method="post" onSubmit="return check()">
					<div class="form-group">
					    <label>用户名</label>
					    <input type="text" class="form-control" name="username">
					</div>
					<div class="form-group">
					    <label>编号</label>
					    <input type="text" class="form-control" name="userid" placeholder="请输入不超过五位的字符" id="userid">
					</div>
					<div class="form-group">
					    <label>电话号码</label>
					    <input type="text" class="form-control" name="telephone">
					</div>
					<div class="form-group">
					    <label>密码</label>
					    <input type="password" class="form-control" id="password1" name="password">
					</div>
					<div class="form-group">
					    <label>确认密码</label>
					    <input type="password" class="form-control" id="password2">
					</div>
					<div class="form-group hidden" id="alert">
						<div class="alert alert-warning" role="alert">用户编号已存在，请重新输入</div>
					</div>
					<input type="submit" class="btn btn-primary full" id="submit" value="提交"/>
				</form>
			</div>
		</div>
	</div>
</body>
<%String success =(String) session.getAttribute("success");
  if(success!=null&&success.equals("1")){
  	session.removeAttribute("success");
%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#alert").removeClass("hidden");
	});
</script>
<%}%>
</html>