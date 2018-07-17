<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <meta charset="utf-8">
   <title>修改密码</title>
   <script src="../other/jquery-3.3.1.js"></script>
   <link rel="stylesheet" href="../other\bootstrap-3.3.7-dist\css\bootstrap.css">  
   <script src="../other\bootstrap-3.3.7-dist\js\bootstrap.js"></script>
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
    .full{
        width:100%;
    }
   </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row box">
            <div class="col-md-2">
                <a href="Personal.jsp"><img src="../picture/Smile.png" width="150px" height="150px"></a>
            </div>
            <div class="col-md-3"><span><font size="50">${customer.cname}</font></span></div>
        </div>
        <div class="row space"></div>
        <div class="row navigation">
            <div class="col-md-12">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="/myweb/GoodsPage/GoodsPage.jsp">返回主页</a></li>  <!--主页链接-->
                    <li role="presentation"><a href="/myweb/getTro">购物车</a></li>    <!--购物车链接-->
                    <li role="presentation"><a href="/myweb/getBuy">我的全部订单</a></li>  <!--去到我的全部订单界面之前应该先从后台获取数据-->
                    <li role="presentation" class="active"><a href="#">修改密码</a></li>  <!--本页-->
                </ul>
            </div>
        </div>
        <div class="row space"></div>
        <div class="row">
            <div class="col-md-4">
                <form action="/myweb/ChangePassword" method="post">    <!--后台处理的servlet地址，处理完之后转到PSuccess.jsp展示修改成功与否的信息-->
                    <div class="form-group">
                        <label>请输入原密码</label>
                        <input type="password" class="form-control" name="oldpassword">
                    </div>
                    <div class="form-group">
                        <label>请输入新密码</label>
                        <input type="password" class="form-control" name="password">
                    </div>
                    <input type="submit" class="btn btn-primary full"/>
                </form>

            </div>
        </div>
    </div>
</body>
</html>