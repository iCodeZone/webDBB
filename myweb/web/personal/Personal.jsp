<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <meta charset="utf-8">
   <title>个人信息</title>
   <script src="..\other/jquery-3.3.1.js"></script>
   <link rel="stylesheet" href="..\other\bootstrap-3.3.7-dist\css\bootstrap.css">  
   <script src="..\other\bootstrap-3.3.7-dist\js\bootstrap.js"></script>
   <style type="text/css">
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
        <div class="row box">
            <div class="col-md-2">
                <a href="#"><img src="/myweb/picture/Smile.png" width="150px" height="150px"></a>
            </div>
            <div class="col-md-3"><span><font size="50">${customer.cname}</font></span></div> <!--EL表达式-->
        </div>
        <div class="row space"></div>
        <div class="row">
            <div class="col-md-12">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="/myweb/GoodsPage/GoodsPage.jsp">返回主页</a></li>  <!--写主页链接-->
                    <li role="presentation"><a href="/myweb/getTro">购物车</a></li>    <!--写购物车界面的链接-->
                    <li role="presentation"><a href="/myweb/getBuy">我的全部订单</a></li>  <!--写personal_all页面的链接，但链接之前先发到后台获取全部订单数据-->
                    <li role="presentation"><a href="Personal_password.jsp">修改密码</a></li>      <!--直接链接到修改密码界面-->
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <table class="table table-bordered table-striped">
                    <!--使用EL表达式，默认在作用域中的变量名为customer-->
                    <tr><td>编号</td><td>${customer.cno}</td></tr>
                    <tr><td>姓名</td><td>${customer.cname}</td></tr>
                    <tr><td>消费额</td><td>${customer.cexpenditure}</td></tr>
                    <tr><td>电话</td><td>${customer.ctele}</td></tr>
                    <tr><td>信用积分</td><td>${customer.ccredit}</td></tr>
                    <tr><td>等级</td><td>${customer.cgrade}</td></tr>
                </table>
            </div>
        </div>
    </div>
</body>
</html>