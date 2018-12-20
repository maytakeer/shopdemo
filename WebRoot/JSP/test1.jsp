
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>购物车</title>

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
	width: 700px;
	margin: auto;
}

.out div {
	float: left;
	text-align: center;
	line-height: 200px;
}

#jiezhang {
	cursor: pointer;
	width: 118px;
	height: 28px;
	float: left;
	line-height: 28px;
	font-size: 16px;
	text-align: center;
}
body{
       font-size: 18px;
       font-family: cursive;
       }
              #dosubmit{
	background:  #696969;
border: none;
padding: 10px 25px 10px 25px;
color: #FFF;
box-shadow: 1px 1px 5px  #696969;
border-radius: 3px;
text-shadow: 1px 1px 1px  #696969;
cursor: pointer;
	}
	input[type="checkbox"] {
    
    float: left;
    margin-top: 96px;
}
</style>
</head>

<body style="background: url(img/show6.jpg) no-repeat top;background-size:100% 100%">
	<jsp:include page="top.jsp"></jsp:include>
	<div id="main">
		<div class="out" style="margin-bottom: 30px"></div>
		<input type="button" id="dosubmit" value="删除"
			style="display: block;width: 100px;float: left;margin-left: 50px">
		<div id="total">
			<div class="jiezhang" id="totalprice"
				style="float: left;width: 100px;margin-left: 150px;color: white;">总价</div>
			<div class="jiezhang" id="jiezhang" onclick="invoicing()"
				style="float: left;width: 100px;margin-left: 150px;color: white;">结账</div>
		</div>
	</div>
	<script type="text/javascript" src="JS/private/test1.js"></script>
</body>
</html>
