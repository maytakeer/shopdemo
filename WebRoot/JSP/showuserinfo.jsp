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

<title>选择用户信息</title>

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
#all {
	height: 400px;
	width: 700px;
	margin: auto;
	margin-top: 100px;
}

#main {
	height: 400px;
	width: 300px;
	margin: auto;
}

span {
	display: block;
	margin: auto;
	font-size: 18px;
	font-family: fantasy;
}

#sub {
	background: #696969;
	border: none;
	padding: 10px 25px 10px 25px;
	color: #FFF;
	box-shadow: 1px 1px 5px #696969;
	border-radius: 3px;
	text-shadow: 1px 1px 1px #696969;
	cursor: pointer;
	margin-left: 260px;
}

body {
	font-size: 18px;
	font-family: cursive;
}

element.style {
	display: block;
}
</style>
</head>

<body
	style="background: url(img/show2.jpg) no-repeat top;background-size:100% 100%">
	<jsp:include page="top.jsp"></jsp:include>
	<div id="all">
		<div id="main"></div>
		<div id="foot"></div>
	</div>
	<script type="text/javascript" src="JS/private/showuserinfo.js"></script>
</body>
</html>
