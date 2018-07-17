<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Bean.GoodsBean" %>
<%ArrayList<GoodsBean> goods =(ArrayList<GoodsBean>) session.getAttribute("goods");    //获取所有的货物信息
  String gno = request.getParameter("gno");                      //获取跳转过来的货物号
  GoodsBean good = null;
  boolean flag=false;
  for(int i=0;i<goods.size()&&!flag;i++){
      String temp=goods.get(i).getGno();
      for(int j=0;j<temp.length();j++){
          if(temp.charAt(j)==' '){
              good=goods.get(i);
              flag=true;
              break;
		  }
          if(temp.charAt(j)!=gno.charAt(j)){
              break;
		  }
	  }
  }
%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <meta charset="utf-8">
   <title>商品浏览</title>
   <script src="../other/jquery-3.3.1.js"></script>
   <link rel="stylesheet" href="../other\bootstrap-3.3.7-dist\css\bootstrap.css">  
   <script src="../other\bootstrap-3.3.7-dist\js\bootstrap.js"></script>
   <style type="text/css">
   	.space{
   		height:20px;
   	}
   	.full{
   		width:100%;
   	}
   	.bigspace{
   		height:50px;
   	}
   </style>
</head>
<body>
	<div class="container-fluid">
		<div class="row space"></div>
		<div class="row">
			<div class="col-md-4 col-md-offset-1">
				<img src="<%=good.getGaddr()%>" width="300px" height="300px">
			</div>
			<div class="col-md-4 col-md-offset-1">
				<div class="row"><h1><%=good.getGno()%></h1></div>
				<div class="row"><h1><%=good.getGname()%></h1></div>
				<div class="row"><h1><%=good.getGprice()%></h1></div>
			</div>
		</div>
		<div class="row bigspace"></div>
		<div class="row">
			<div class="col-md-2 col-md-offset-3"><a class="btn btn-primary full" id="order" name="<%=gno%>">订制</a></div>  <!--跳转到定制界面,在参数中加入gno-->
			<div class="col-md-2"><a name="<%=gno%>" class="btn btn-success full" id="troo">加入购物车</a></div>  <!--转入后台加入购物车之后跳到购物车界面-->
			<div class="col-md-2"><a name="<%=gno%>" class="btn btn-info full" id="buy">购买</a></div>  <!--后台封装之后跳到Confirm_purchase.jsp界面-->
		</div>
		<div class="row space"></div>
		<div class="row">
			<div class="col-md-6 col-md-offset-3"><a href="/myweb/GoodsPage/GoodsPage.jsp" class="btn btn-primary full">返回主页</a></div> <!--返回主页-->
		</div>
	</div>
</body>
<script type="text/javascript">
  $(document).ready(function(){

    $("#order").click(function(){
      var gno = $(this).attr("name");
      location.href = "/myweb/purchase/Order.jsp?gno="+gno;  //点击订制
    });

    $("#troo").click(function(){
      var gno = $(this).attr("name");
      location.href = "/myweb/addTro?gno="+gno;  //点击加入购物车
    });

    $("#buy").click(function(){
      var gno = $(this).attr("name");
      location.href = "/myweb/GoodsToTro?gno="+gno;  //点击购买
    });
  });
</script>
</html>