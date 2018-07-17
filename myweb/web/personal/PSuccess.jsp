<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!--需要从修改密码的jsp传一个参数过来，叫success好了，为“1”是成功，为“0”是失败-->
<%String success =(String) session.getAttribute("success");
  String piclocation=null;     //存储参数
  String text = null;
  if(success.equals("1")){
    session.removeAttribute("success");
		piclocation = "../picture/blue_smile.png";
		text = "修改成功！";
  }
  else{
  	piclocation = "../picture/blue_cry.png";
	  text = "修改失败！";
    session.removeAttribute("success");
  }
%>


<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <meta charset="utf-8">
   <title>修改</title>
   <script src="../other/jquery-3.3.1.js"></script>
   <link rel="stylesheet" href="../other\bootstrap-3.3.7-dist\css\bootstrap.css">  
   <script src="../other\bootstrap-3.3.7-dist\js\bootstrap.js"></script>
   <style type="text/css">
       .full{
        width:100%;
       }
       .space{
        height:10px;
       }
   </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row space"></div>
        <div class="row">
            <div class="col-md-2 col-md-offset-5">
                <img src="<%=piclocation%>">     <!--使用参数动态展示-->
            </div>
        </div>
        <div class="row">
            <div class="col-md-2 col-md-offset-5">
                <h1><%=text%></h1>              <!--使用参数动态展示-->
            </div>
        </div>
        <div class="row">
            <div class="col-md-2 col-md-offset-5">
                <a class="btn btn-primary full" href="/myweb/personal/Personal_password.jsp">点击返回</a>
            </div>
        </div>
    </div>
</body>
</html>