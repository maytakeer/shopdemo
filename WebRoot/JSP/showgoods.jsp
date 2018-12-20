<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="JS/public/jquery.1.9.1.js"></script>
<style type="text/css">
#main {
            width: 1200px;
            height: 680px;         
            margin: auto;
            text-align: center;
        }

        .showgoods {
            width: 398px;
            height: 338px;           
            float: left;
        }

        .showimg {
            width: 100%;
         	 
            height: 218px;
            cursor: pointer;
        }

        .showprice {
            width: 100%;         
            height: 58px;
        }

        .showbrand {
            width: 100%;            
            height: 58px;
        }

        #page {
            width: 270px;
            height: 40px;
            margin: auto;
        }  
     #nextpage,#prepage,#currentpage {
            width: 88px;
            height: 38px;
            float: left;
            text-align: center;
            margin-top: 20px;
        }     
        img{
            width:392px;
            height:216px;
            text-align: center;
            vertical-align: middle;
        }
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
       body{
       font-size: 18px;
       font-family: cursive;
       }
</style>
  </head>
  
  <body style="background: url(img/login.jpg) no-repeat top;background-size:100% 100%">
    <jsp:include page="top.jsp"></jsp:include>
	<div id="main">
		<div class="showgoods" id="showgoods0">
			<div class="showimg" id="showimg0"></div>
			<div class="showprice" id="showprice0"></div>
			<div class="showbrand" id="showbrand0"></div>
		</div>
		<div class="showgoods" id="showgoods1">
			<div class="showimg" id="showimg1"></div>
			<div class="showprice" id="showprice1"></div>
			<div class="showbrand" id="showbrand1"></div>
		</div>
		<div class="showgoods" id="showgoods2">
			<div class="showimg" id="showimg2"></div>
			<div class="showprice" id="showprice2"></div>
			<div class="showbrand" id="showbrand2"></div>
		</div>
		<div class="showgoods" id="showgoods3">
			<div class="showimg" id="showimg3"></div>
			<div class="showprice" id="showprice3"></div>
			<div class="showbrand" id="showbrand3"></div>
		</div>
		<div class="showgoods" id="showgoods4">
			<div class="showimg" id="showimg4"></div>
			<div class="showprice" id="showprice4"></div>
			<div class="showbrand" id="showbrand4"></div>
		</div>
		<div class="showgoods" id="showgoods5">
			<div class="showimg" id="showimg5"></div>
			<div class="showprice" id="showprice5"></div>
			<div class="showbrand" id="showbrand5"></div>
		</div>
	</div>
	<div id="page">
		<div id="prepage"></div>
		<div id="currentpage">1</div>
		<div id="nextpage"></div>
	</div>
	<script type="text/javascript" src="JS/private/showgoogsbypage.js"></script>
  </body>
</html>
