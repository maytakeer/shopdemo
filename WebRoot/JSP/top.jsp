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

<title>My JSP 'top.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#top {
	width: 100%;
	height: 30px;
	font-size: 14px;
}

#top div {
	float: left;
	margin-left: 20px;
	margin-right: 30px;
}

a {
	text-decoration: none;
}
</style>
</head>

<body>
	<div id="top">
		<div id="username">用户名</div>
		<div id="balance">余额</div>
		<div>
			<a href="JSP/changepass.jsp">修改密码</a>
		</div>
		<div>
			<a href="JSP/order.jsp">交易记录</a>
		</div>
		<div>
			<a href="JSP/userinfo.jsp">添加收货地址管理</a>
		</div>
		<div>
			<a href="JSP/showuserinfo.jsp">删除收货地址</a>
		</div>
		<div>
			<a href="JSP/showgoods.jsp">主页</a>
		</div>
		<div id="logout" onclick="logOut()">
			<a href="JSP/login.jsp">注销</a>
		</div>
	</div>
	<script type="text/javascript" src="JS/private/top.js"></script>
</body>
</html>
