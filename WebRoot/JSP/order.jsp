<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <style>
        #top{
            width: 100%;
            height: 30px;
            font-size: 14px;
        }
        #top div{
            float: left;
            margin-left: 20px;
            margin-right: 30px;
        }
        a{
            text-decoration: none;
        }
        #main{
            width: 760px;
            margin: auto;
        }
        #biaotou{
            width: 760px;
            height: 50px;
            margin: auto;
        }
        .show{
            width: 138px;
            border: 1px solid #F5EFFB;
            height: 50px;
            font-size: 16px;
            text-align: center;
            float: left;
            line-height: 50px;
            color: white;
        }
        body{
       font-size: 18px;
       font-family: cursive;
       }
    </style>
<script type="text/javascript" src="JS/public/jquery.1.9.1.js"></script>
  </head>
  
  <body style="background: url(img/show4.jpg) no-repeat top;background-size:100% 100%">
    <jsp:include page="top.jsp"></jsp:include>
<div id="biaotou">
    <div class="show">名称</div>
    <div class="show">数量</div>
    <div class="show">价格</div>
    <div class="show">总价</div>
    <div class="show" style="width: 190px">时间</div>
</div>
  <div id="main">
  <%
  for(int i = 0;i<50;i++){
   %>
  <div class="show" id="goodsname<%=i %>"></div>
  <div class="show" id="number<%=i %>"></div>
  <div class="show" id="price<%=i %>"></div>
  <div class="show" id="totalprice<%=i %>"></div>
  <div class="show" style="width: 190px" id="time<%=i %>"></div>
  <%
  }
   %>
  </div>
  <script type="text/javascript" src="JS/private/order.js"></script>
  </body>
</html>
