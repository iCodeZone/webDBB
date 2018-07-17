<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改单价</title>
    
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../BootStrap/bootstrap.css">
    <link rel="stylesheet" href="../BootStrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../BootStrap/3.3.7/css/bootstrap.min.js">
    <link rel="stylesheet" href="css/AdminPage.css">
  </head>
  
  <body>

      <%String success=(String)session.getAttribute("success"); %>   <!--此处需覆盖-->
      <%if(success!=null && success.equals("1")){
        session.removeAttribute("success");
      %>
      <script>
          alert("输入的商品编号不存在！");
      </script>
      <%}%>

    <div class="row">
      <div class="title col-xs-12">
    
        <div class="p-1">
          <img src="4.jpg" class="img-circle" width="150px" height="100px">
        </div>
      
        <div class="p-2">
          <div class="p1">Saimot管理员操作平台</div>
        </div>
      
      </div>

      <div class="function col-xs-12">
        <ol class="breadcrumb">
          <li><a href="StoragePage.jsp">商品入库</a></li>
          <li><a href="InventoryPage.jsp">查询库存</a></li>
          <li><a href="/myweb/getGoods">查看商品</a></li>
          <li><a href="/myweb/getBuys">查看订单</a></li>
          <li><a href="PricePage.jsp">修改单价</a></li>
        </ol>
      </div>
    </div>  
  
    <div>
      <form action="/myweb/getGood" method="post">
      <div class="input-group" style="width:300px;">
        <input type="text" class="form-control" placeholder="请输入相应商品号" name="search">
        <span class="input-group-btn">
          <button class="btn btn-primary" type="submit">检索<span class="glyphicon glyphicon-search"></span></button>
        </span>
      </div>
      </form>
    </div>
  
  
  
  
  
  
  
  
  
  
  
        <script src="../BootStrap/jquery-3.3.1.js"></script>
        <script src="../BootStrap/bootstrap.js"></script>
        <script src="js/AdminPage.js"></script>
  </body>
</html>
