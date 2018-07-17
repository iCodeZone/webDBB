<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="Bean.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
  <head>
  
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../BootStrap/bootstrap.css">
    <link rel="stylesheet" href="../BootStrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="../BootStrap/3.3.7/css/bootstrap.min.js">
    <link rel="stylesheet" href="css/HomePage.css">
    <title>Saimot主页</title>

  </head>
  <body>

        <%CustomerBean customer=(CustomerBean)session.getAttribute("customer"); %>
        <div class="row">
     
       <div class="col-md-6" id="title-1">
            <div class="p1">Saimot</div>
            <div class="p2">Saimot.com</div>
       </div>
       
       <div class="col-md-2" id="title-2">
       <div class="input-group" id="p3">
          <input type="text" class="form-control" placeholder="搜索Saimot">
          <span class="input-group-btn">
            <button class="btn btn-default" type="button" style="height:34px;"><span class="glyphicon glyphicon-search"></span></button>
          </span>
       </div>
       </div>

       <div class="col-md-2" id="title-3">
        <div class="dropdown" id="p4">

          <div class="st-people">
          <button class="btn btn-default" type="button" id="btn-1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
            <font style="color:rgb(255,102,0)">Saimot公司高层人员</font><span class="caret"></span>
          </button>
          </div>
          
            <ul class="dropdown-menu" id="people" aria-labelledby="dropdownMenu1">
              <li><a>郭盛</a></li>
              <li><a>蓝翔</a></li>
              <li><a>李鑫祎</a></li>
              <li><a>竺羽翔</a></li>
            </ul>
          

         </div>
        </div>
        
        <div class="col-md-2" id="title-4">
        <div class="dropdown" id="p5">

          <div class="name" style="width:50px;">
            <button class="btn btn-default" type="button" id="btn-1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
              <font class="name-1"><%=customer.getCname() %></font><span class="caret"></span>
            </button>
          </div>

          <div class="p6">
            <ul class="nav">
              <li>
                    <div class="menu">

                      <div class="menu-1">
                        <a href="/myweb/CustomerLoginOut" style="text-decoration: none;">退出</a>
                      </div>

                      <div class="menu-2">
                        <img src="9.jpg" width="50px" height="50px" class="img-circle">
                      </div>

                      <div class="menu-3">
                        <font><%=customer.getCname() %></font><br>
                        <font><%=customer.getCgrade() %></font>
                        <img src="2.png" class="img-circle" width="15px" height="15px">
                      </div>

                      <br/><br/>
                      <div class="menu-4">
                        <a href="/myweb/personal/Personal.jsp">个人信息</a>
                      </div>
                      
                    </div>
               </li>
             </ul>
           </div>
         </div>
       </div>
      </div>








      <div class="row" style="background:rgb(255,102,0);" id="nav">

       <div class="col-md-4" style="text-align:center;">
         <div id="button-1">             
           <a href="/myweb/GoodsPage/GoodsPage.jsp" id="butt-1" class="btn btn-default dropdown-toggle" style="text-decoration: none;line-height:55px;width:180px;">
              商品展示
           </a>            
         </div>
        </div>



        <div class="col-md-4" style="text-align:center;">
         <div class="button-2">         
           <button type="button" id="butt-2" class="btn btn-default dropdown-toggle" data-toggle="modal" data-target="#myModal" style="width:180px;">
              关于我们
           </button>
  
            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel1">公司简介</h4>
                  </div>
                  <div class="modal-body">
                    公司文化博大精深！
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    
                  </div>
                </div>
              </div>
            </div>      
         </div>   
        </div>
         
         





       <div class="col-md-4" style="text-align:center;"> 
         <div class="button-3">
           <!-- Button trigger modal -->
          <button type="button" id="butt-3" class="btn btn-default" data-toggle="modal" data-target="#myModal-1" style="width:180px;border:none;">
              联系我们
          </button>
          <div class="modal fade" id="myModal-1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="myModalLabel">联系方式</h4>
                </div>
                <div class="modal-body">
                  159xxxx1602
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
              </div>
            </div>
          </div>

         </div>
       </div>
      </div>
          
      <div class="bas">
       <div class="bas-1">
         <img src="12.jpg" style="width: 100%;height: 100%;">
       </div>
    </div>





           

    <script src="../BootStrap/jquery-3.3.1.js"></script>
    <script src="../BootStrap/bootstrap.js"></script>
    <script type="text/javascript" src="js/HomePage.js"></script>

  </body>
  </html>