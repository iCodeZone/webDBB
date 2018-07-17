<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Bean.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>查看订单</title>
    
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../BootStrap/bootstrap.css">
    <link rel="stylesheet" href="../BootStrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../BootStrap/3.3.7/css/bootstrap.min.js">
    <link rel="stylesheet" href="css/AdminPage.css">
  </head>
  
  <body>
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
  
    <%ArrayList<BuyBean> array = (ArrayList<BuyBean>)session.getAttribute("Buys"); %>
    <div>
      <table class="table table-striped">
        <tr>
          <td>订单编号</td>
          <td>商品编号</td>
          <td>商品名称</td>
          <td>商品类型</td>
          <td>单价</td>
          <td>交易状态</td>
          <td>用户编号</td>
          <td>购买数量</td>
          <td>发货地</td>
          <td>目的地址</td>
        </tr>
        <%for(int i=0;i<array.size();i++){ %>  <!-- 此处需获取商品的总数量 -->
        <%BuyBean buy = array.get(i);%>
        <tr>
          <td><%=buy.getBno() %></td>
          <td><%=buy.getGno() %></td>
          <td><%=buy.getGname() %></td>
          <td><%=buy.getGtype() %></td>
          <td><%=buy.getGprice() %></td>
          <td><%=buy.getBstate() %></td>
          <td><%=buy.getCno() %></td>
          <td><%=buy.getBnumber() %></td>
          <td><%=buy.getDaddr() %></td>
          <td><%=buy.getBaddr() %></td>

        </tr>
        <%} %>
      </table>
    </div>
  
  
  
  
  
  
  
  
  
        <script src="../BootStrap/jquery-3.3.1.js"></script>
        <script src="../BootStrap/bootstrap.js"></script>
        <script src="js/AdminPage.js"></script>
  </body>
</html>
