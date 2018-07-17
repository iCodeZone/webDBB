<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  <!--应该要继续import一些包-->
<%@ page import="Bean.BuyBean" %>
<%ArrayList<BuyBean> buys = (ArrayList<BuyBean>)session.getAttribute("buys");  //从session中获取存储的数组
%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <meta charset="utf-8">
   <title>全部订单</title>
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
   </style>
</head>
<body>
    <div class="container-fluid">
        <div class="row box">
            <div class="col-md-2">
                <a href="Personal.jsp"><img src="/myweb/picture/Smile.png" width="150px" height="150px"></a>
            </div>
            <div class="col-md-3"><span><font size="50">${customer.cname}</font></span></div> <!--客户的bean应该放在session里，所以使用EL表达式应该可以一直读取的-->
        </div>
        <div class="row space"></div>
        <div class="row navigation">
            <div class="col-md-12">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="/myweb/GoodsPage/GoodsPage.jsp">返回主页</a></li>   <!--主页地址-->
                    <li role="presentation"><a href="/myweb/getTro">购物车</a></li>     <!--购物车地址-->
                    <li role="presentation" class="active"><a href="#">我的全部订单</a></li>  <!--本页面-->
                    <li role="presentation"><a href="Personal_password.jsp">修改密码</a></li> <!--修改密码页面-->
                </ul>
            </div>
        </div>
        <div class="row space"></div>
        <%if(buys.size()==0){%>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <h1>您从未购买过任何商品！</h1>
            </div>
        </div>
        <%}else{%>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-bordered table-hover">
                    <tr class="success"><td>商品类型</td><td>商品名</td><td>单价</td><td>数量</td><td>送货地址</td><td>日期</td><td>状态</td><td>操作</td></tr>
                    <%for(int i=0;i<buys.size();i++){
                    	BuyBean buy = buys.get(i);
                    	String piclocation = null;
                    	if(buy.getGput().trim().equals("0")){
                    		piclocation = "/myweb/picture/black_star.png";  //上架用黑星
                    	}
                    	else{
                    		piclocation = "/myweb/picture/red_star.png";  //不上架表示订制产品用红星
                    	}
                    %>
                    <tr>
                        <td><img src="<%=piclocation%>" width="20px" height="20px"></td>
                        <td name="<%=buy.getGno()%>" class="browser"><%=buy.getGname()%></td>
                        <td><%=buy.getGprice()%></td><td><%=buy.getBnumber()%></td>
                        <td><%=buy.getBaddr()%></td>
                        <td><%=buy.getBdate()%></td>
                        <td><%=buy.getBstate()%></td>
                    	<td>
                    		<%
                    		if(buy.getBstate().charAt(0)=='待'){
                    		%>
                    		<button type="button" class="btn btn-success check" name="<%=buy.getBno()%>">确认付款</button>  <!--getBno()指的是获取的订单号-->
                    		<%} else if(buy.getBstate().charAt(0)=='已'){%>
                    		<button type="button" class="btn btn-success refun" name="<%=buy.getBno()%>">退款</button>  <!--getBno()指的是获取的订单号-->
                    		<%}%>
                    	</td></tr>
                    <%}%>
                </table>
            </div>
        </div>
        <%}%>
    </div>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		$(".check").click(function(){
			var bno = $(this).attr("name");
  	    	location.href = "/myweb/setPay?bno="+bno; //这里获取点击事件，然后我用get方式把bno作为参数发送给后台servlet，location要改为后台处理确认付款事件的servlet，然后servlet用getParameter来获取订单号的参数进行状态修改就好了，然后记得修改存在session里的数组的那个订单的状态，修改完状态之后去到Allstatus.jsp界面展示成功与否
		});
		$(".refun").click(function(){
			var bno = $(this).attr("name");
  	    	location.href = "/myweb/setRefund?bno="+bno;  //需要加退货servlet的地址
		});
        $(".browser").click(function(){
            var gno = $(this).attr("name");
            location.href = "/myweb/purchase/One_good.jsp?gno="+gno;  //点击浏览某个商品
        });
	});
</script>

</html>