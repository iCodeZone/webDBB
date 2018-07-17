<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
                <img src="../picture/close.png" width="50px" height="50px">  <!--使用变量填充图片地址-->
                <!--<img src="../picture/close.png">-->
            </div>
            <div class="col-md-2">
                <span><h1>订制失败!</h1></span>    <!--使用变量填充文本-->
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-md-offset-5">
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">查看失败原因
                </button>
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">信誉分过低以致于不能购买</h4>
                      </div>
                      <div class="modal-body">
                        <p>提高信誉分的方法：购物并且及时付款，若购物后七天之内不付款将会被扣除信誉分哦。</p>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                      </div>
                    </div>
                  </div>
                </div>
            </div>
        </div>
        <div class="row space"></div>
        <div class="row">
            <div class="col-md-3 col-md-offset-5">
                <a class="btn btn-primary full" href="/myweb/GoodsPage/GoodsPage.jsp">点击返回主页</a>  <!--返回哪个界面还需要斟酌，我觉得要不然返回主页好了，这里需要补充一下-->
            </div>
        </div>
    </div>
</body>
</html>