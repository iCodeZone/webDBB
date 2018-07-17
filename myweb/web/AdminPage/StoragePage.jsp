<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品入库</title>
    
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
      alert("输入的商品编号存在重复问题！");
  </script>
  <%}%>
  <%if(success!=null&&success.equals("0")){
    session.removeAttribute("success");
  %>
  <script>
      alert("添加成功！");
  </script>
  <%} %>



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
      <form action="/myweb/AddGoods" method="post">
      <table class="table table-bordered">
        <tr>
          <td>商品编号</td>
          <td>商品名称</td>         
          <td>商品单价</td>
          <td>上架商品</td>
          <td>商品类型</td>
          <td>图片地址</td>       
        </tr>
        <tr>
          <td><input type="text" class="form-control" name="gno"></td>
          <td><input type="text" class="form-control" name="gname"></td>
          <td>
            <div class="input-group">
              <span class="input-group-addon" style="width:10px;">¥</span>
              <input type="text" class="form-control" style="width:80px" name="gprice">
            </div>
          </td>
          <td>
            <input type="radio" name="gput" value="0">是
            <input type="radio" name="gput" value="1">否
          </td>
          <td>
              <div>
				<select name="gtype">
				  <option value="1">服装</option>
				  <option value="2">鲜花</option>
		          <option value="3">瓷器</option>
		          <option value="4">笔具</option>
		          <option value="5">珠宝</option>
		          <option value="6">饰品</option>
				</select>
			  </div>
          </td>
          <td><input type="text" class="form-control" name="paddr"></td>
        </tr>
      </table>
      <button type="submit" class="btn btn-primary" style="width:200px;margin-left:10px;">提交数据</button>
      </form>
    </div>
  
  
  
  
  
  
  
  
  
  
  
  
        <script src="../BootStrap/jquery-3.3.1.js"></script>
        <script src="../BootStrap/bootstrap.js"></script>
        <script src="js/AdminPage.js"></script>
  </body>
</html>
