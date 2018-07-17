<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Bean.TrolleyBean" %>
<%ArrayList<TrolleyBean> trolley =(ArrayList<TrolleyBean>) session.getAttribute("trolley");%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8"> 
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
   <meta charset="utf-8">
   <title>购物车</title>
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
        <div class="row">
            <div class="col-md-6 col-md-offset-3"><h1>购物车</h1></div>
        </div>
        <div class="row">
          <form action="/myweb/GoodsToTro" method="post">   <!--网址点击购买的默认地址-->
            <div class="col-md-6 col-md-offset-3">
              <div class="row">
                    <table class="table table-striped table-bordered">
                        <tr class="success">
                            <td>选择</td>
                            <td>商品名称</td>
                            <td>商品单价</td>
                            <td>数量</td>
                            <td>修改数量</td>
                        </tr>
                        <%
                        double sumprice=0;
                            System.out.println(trolley.size());
                        for(int i=0;i<trolley.size();i++) {
                            TrolleyBean tr = trolley.get(i);
                            sumprice = sumprice + tr.getGprice() * tr.getTnumber();
                        %>
                        <tr>
                            <td><input type="checkbox" name="select" value="<%=i%>"></td>
                            <td><%=tr.getGname()%></td>
                            <td><%=tr.getGprice()%></td>
                            <td><%=tr.getTnumber()%></td>
                            <td><input type="text" class="form-control" name="<%=i%>"></td>
                        </tr>
                        <%}%>
                        <tr><td></td><td></td><td></td><td></td><td>商品总价：<%=sumprice%></td></tr>
                    </table>
              </div>
              <div class="row">
                  <%if(trolley.size()!=0){%>
                <div class="col-md-2">
                  <input type="submit" class="btn btn-primary" value="提交订单" id="sub">
                </div>
                <div class="col-md-2">
                  <input type="submit" class="btn btn-primary" value="提交修改" id="change">
                </div>
                  <%}%>
                <div class="col-md-2">
                  <a class="btn btn-primary" href="/myweb/personal/Personal.jsp">返回主页</a>   <!--返回主页-->
                </div>
              </div>
            </div>
          </form>
        </div>
    </div>
</body>
<script type="text/javascript">
  $(document).ready(function(){
    $("#change").click(function(){
      $("form").attr("action","/myweb/freshTro");  //点击修改一个界面的网址
    });
  });
</script>
</html>