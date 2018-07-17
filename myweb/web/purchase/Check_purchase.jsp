<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!--需要从修改密码的jsp传一个参数过来，叫success好了，为“1”是成功，为“0”是失败-->
<%String success =(String) session.getAttribute("success");
  String piclocation=null;     //存储参数
  String text = null;
  if(success.equals("1")){
    session.removeAttribute("success");
	  piclocation = "../picture/selected.png";
	  text = "下单成功！";
  }
  else if(success.equals("0")){
  	piclocation = "../picture/close.png";
	  text = "下单部分失败！部分商品数量不足！";
    session.removeAttribute("success");
  }
  else{
  	piclocation = "../picture/close.png";
	text = "下单失败！商品数量不足！";
    session.removeAttribute("success");
  }
%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <meta charset="utf-8">
   <title>确认</title>
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
       .box{
            display: flex;
            flex-direction: row;
            flex-wrap:wrap;
            justify-content: flex-start;
            align-items:center;
        }
   </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row space"></div>
        <div class="row box">
            <div class="col-md-1 col-md-offset-5">
                <img src="<%=piclocation%>" width="50px" height="50px">  <!--使用变量填充图片地址-->
                <!--<img src="../picture/close.png">-->
            </div>
            <div class="col-md-2">
                <span><h1><%=text%></h1></span>    <!--使用变量填充文本-->
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-md-offset-5">
                <a class="btn btn-primary full" href="/myweb/personal/Personal.jsp">点击返回</a>  <!--返回哪个界面还需要斟酌，我觉得要不然返回主页好了，这里需要补充一下-->
            </div>
        </div>
    </div>
</body>
</html>