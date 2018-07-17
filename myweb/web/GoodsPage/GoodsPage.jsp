<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Bean.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
    <title>商品展示</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../BootStrap/bootstrap.css">
    <link rel="stylesheet" href="../BootStrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../BootStrap/3.3.7/css/bootstrap.min.js">
    <link rel="stylesheet" href="css/GoodsPage.css">
</head>
<body>
<%ArrayList<GoodsBean> array=(ArrayList<GoodsBean>)session.getAttribute("goods"); %>
<%CustomerBean customer=(CustomerBean)session.getAttribute("customer"); %>

<div class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/myweb/personal/Personal.jsp" style="font-size:10px"><%=customer.getCname() %></span></a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">消息</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="/myweb/HomePage/HomePage.jsp">Saimot主页</a></li>
                <li><a href="/myweb/purchase/Shopping_car.jsp">购物车</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        商品分类<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" id="qqq">
                        <li><a href="#cloth">服装</a></li>
                        <li><a href="#flower">鲜花</a></li>
                        <li><a href="#china">瓷器</a></li>
                        <li><a href="#pen">笔具</a></li>
                        <li><a href="#jewel">珠宝</a></li>
                        <li><a href="#Accessories">饰品</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="titlehead panel panel-default">
    <div class="p">
        <div class="p1">Saimot</div>
        <div class="p2">Saimot.com</div>
    </div>
</div>


<div id="cloth" class="panel panel-default">
    <div>
        <h1>服装</h1>
        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 16%">
                <span class="sr-only">16% Complete</span>
            </div>
        </div>
    </div>
    <div class="box">
        <%for(int i=0;i<array.size();i++){ %>
        <%GoodsBean good=array.get(i); %>
        <%if(good.getGtype().charAt(0)=='1'){ %>
        <div>
            <img src=<%=good.getGaddr() %> width="200px" height="280px" class="pict" name=<%=good.getGno() %>>
            <div class="price"><font style="color: rgb(255, 80, 0);font-size:20px;">¥ <%=good.getGprice() %></font></div>
            <div class="price"><font style="font-family:方正舒体：FZShuTi;"><%=good.getGname() %></font></div>
        </div>
        <%} %>
        <%} %>
    </div>
</div>


<div id="flower" class="panel panel-default">
    <div>
        <h1>鲜花</h1>
        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 32%">
                <span class="sr-only">32% Complete</span>
            </div>
        </div>
    </div>
    <div class="box">
        <%for(int i=0;i<array.size();i++){ %>
        <%GoodsBean good=array.get(i); %>
        <%if(good.getGtype().charAt(0)=='2'){ %>
        <div>
            <img src=<%=good.getGaddr() %> width="200px" height="280px" class="pict" name=<%=good.getGno() %>>
            <div class="price"><font style="color: rgb(255, 80, 0);font-size:20px;">¥ <%=good.getGprice() %></font></div>
            <div class="price"><font style="font-family:方正舒体：FZShuTi;"><%=good.getGname() %></font></div>
        </div>
        <%} %>
        <%} %>
    </div>
</div>

<div id="china" class="panel panel-default">
    <div>
        <h1>瓷器</h1>
        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 48%">
                <span class="sr-only">48% Complete</span>
            </div>
        </div>
    </div>
    <div class="box">
        <%for(int i=0;i<array.size();i++){ %>
        <%GoodsBean good=array.get(i); %>
        <%if(good.getGtype().charAt(0)=='3'){ %>
        <div>
            <img src=<%=good.getGaddr() %> width="200px" height="280px" class="pict" name=<%=good.getGno() %>>
            <div class="price"><font style="color: rgb(255, 80, 0);font-size:20px;">¥ <%=good.getGprice() %></font></div>
            <div class="price"><font style="font-family:方正舒体：FZShuTi;"><%=good.getGname() %></font></div>
        </div>
        <%} %>
        <%} %>
    </div>
</div>

<div id="pen" class="panel panel-default">
    <div>
        <h1>笔具</h1>
        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 64%">
                <span class="sr-only">64% Complete</span>
            </div>
        </div>
    </div>
    <div class="box">
        <%for(int i=0;i<array.size();i++){ %>
        <%GoodsBean good=array.get(i); %>
        <%if(good.getGtype().charAt(0)=='4'){ %>
        <div>
            <img src=<%=good.getGaddr() %> width="200px" height="280px" class="pict" name=<%=good.getGno() %>>
            <div class="price"><font style="color: rgb(255, 80, 0);font-size:20px;">¥ <%=good.getGprice() %></font></div>
            <div class="price"><font style="font-family:方正舒体：FZShuTi;"><%=good.getGname() %></font></div>
        </div>
        <%} %>
        <%} %>
    </div>
</div>

<div id="jewel" class="panel panel-default">
    <div>
        <h1>珠宝</h1>
        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                <span class="sr-only">80% Complete</span>
            </div>
        </div>
    </div>
    <div class="box">
        <%for(int i=0;i<array.size();i++){ %>
        <%GoodsBean good=array.get(i); %>
        <%if(good.getGtype().charAt(0)=='5'){ %>
        <div>
            <img src=<%=good.getGaddr() %> width="200px" height="280px" class="pict" name=<%=good.getGno() %>>
            <div class="price"><font style="color: rgb(255, 80, 0);font-size:20px;">¥ <%=good.getGprice() %></font></div>
            <div class="price"><font style="font-family:方正舒体：FZShuTi;"><%=good.getGname() %></font></div>
        </div>
        <%} %>
        <%} %>
    </div>
</div>

<div id="Accessories" class="panel panel-default">
    <div>
        <h1>饰品</h1>
        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                <span class="sr-only">100% Complete</span>
            </div>
        </div>
    </div>
    <div class="box">
        <%for(int i=0;i<array.size();i++){ %>
        <%GoodsBean good=array.get(i); %>
        <%if(good.getGtype().charAt(0)=='6'){ %>

        <div>
            <img src=<%=good.getGaddr() %> width="200px" height="280px" class="pict" name=<%=good.getGno() %>>
            <div class="price"><font style="color: rgb(255, 80, 0);font-size:20px;">¥ <%=good.getGprice() %></font></div>
            <div class="price"><font style="font-family:方正舒体：FZShuTi;"><%=good.getGname() %></font></div>
        </div>
        <%} %>
        <%} %>
    </div>
</div>



<script src="../BootStrap/jquery-3.3.1.js"></script>
<script src="../BootStrap/bootstrap.js"></script>
<script src="js/GoodsPage.js"></script>

</body>
</html>