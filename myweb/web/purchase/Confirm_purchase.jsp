<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Bean.TrolleyBean" %>
<!--不管在前一个界面是直接点击物品还是购物车选择多个物品，应该把选择要购买的物品存在一个GoodsBean的ArrayList里，就暂且叫goodsbuy吧-->

<%ArrayList<TrolleyBean> trolley = (ArrayList<TrolleyBean>)session.getAttribute("goodsbuy");%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <meta charset="utf-8">
   <title>确认购买</title>
   <script src="../other/jquery-3.3.1.js"></script>
   <link rel="stylesheet" href="../other\bootstrap-3.3.7-dist\css\bootstrap.css">  
   <script src="../other\bootstrap-3.3.7-dist\js\bootstrap.js"></script>
   <style type="text/css">
   	.space{
   		height:10px;
   	}
   	hr{
   		height:2px;
   		background-color:blue;
   	}
   </style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<h1><font>请确认您的订单</font></h1>
			</div>
		</div>
		<form action="/myweb/setOrder" method="post">    <!--后台进行判断，数量小于等于经销点数量的话我们就报错，这个界面往后传的信息只写了数量和地址，其他必要信息应该都在session中，直接读取就好了，成功与否结果返回Check_purchase.jsp界面-->
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<table class="table table-bordered table-striped">
						<tr class="success"><td>商品名</td><td>商品单价</td><td>购买数量</td></tr>
						<%
						for(int i=0;i<trolley.size();i++){     //自动展示所有商品
							TrolleyBean tr = trolley.get(i);
						%>
						<tr><td><%=tr.getGname()%></td><td><%=tr.getGprice()%></td><td name="<%=tr.getGprice()%>"><input type="text" name="number" class="form-control text" value="<%=tr.getTnumber()%>"></td></tr>
						<%}%>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<span id="btn"><font color="red" size="5">点击这里生成总价</font></span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<h2><span>商品总价：</span><span id="sumprice">0</span></h2>   <!--这里使用jQuery自动生成总价-->
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-4"><hr/></div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-4"><h2>请选择邮寄地址:</h2></div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<select class="form-control" name="province">
				  		<option selected value="北京市">北京市</option>
				  		<option value="天津市">天津市</option>
				  		<option value="上海市">上海市</option>
				  		<option value="重庆市">重庆市</option>
				  		<option value="河北省">河北省</option>
				  		<option value="山西省">山西省</option>
				  		<option value="辽宁省">辽宁省</option>
				  		<option value="吉林省">吉林省</option>
				  		<option value="黑龙江省">黑龙江省</option>
				  		<option value="江苏省">江苏省</option>
				  		<option value="浙江省">浙江省</option>
				  		<option value="安徽省">安徽省</option>
				  		<option value="福建省">福建省</option>
				  		<option value="江西省">江西省</option>
				  		<option value="山东省">山东省</option>
				  		<option value="河南省">河南省</option>
				  		<option value="湖北省">湖北省</option>
				  		<option value="湖南省">湖南省</option>
				  		<option value="广东省">广东省</option>
				  		<option value="海南省">海南省</option>
				  		<option value="四川省">四川省</option>
				  		<option value="贵州省">贵州省</option>
				  		<option value="云南省">云南省</option>
				  		<option value="陕西省">陕西省</option>
				  		<option value="甘肃省">甘肃省</option>
				  		<option value="青海省">青海省</option>
				  		<option value="台湾省">台湾省</option>
				  		<option value="内蒙古自治区">内蒙古自治区</option>
				  		<option value="广西壮族自治区">广西壮族自治区</option>
				  		<option value="西藏自治区">西藏自治区</option>
				  		<option value="宁夏回族自治区">宁夏回族自治区</option>
				  		<option value="新疆维吾尔自治区">新疆维吾尔自治区</option>
				  		<option value="香港特别行政区">香港特别行政区</option>
				  		<option value="澳门特别行政区">澳门特别行政区</option>
					</select>
				</div>
			</div>
			<div class="row space"></div>
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<input class="form-control" name="address">
				</div>
			</div>
			<div class="row space"></div>
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<input type="submit" class="btn btn-primary" value="提交"/>
				</div>
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function(){
		$("#btn").click(function(){
			let sum = 0;
			$(".text").each(function(){
				sum = sum + $(this).parent().attr("name")*$(this).val();
			});
			//sum = sum + $(":text").parent().attr("name")*$(":text").val();
			//console.log($(":text").parent().attr("name"));
			//console.log($(":text").val());
			//console.log(sum);
			$("#sumprice").text(sum);
		});
	});
</script>

</html>