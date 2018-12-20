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

<title>添加用户信息</title>

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
#main{
	height: 400px;
	width: 400px;
	margin: auto;
	margin-top: 100px;
}
input {
	display: block;
	margin: auto;
    height: 31px;
    margin-bottom: 10px;
    width: 200px;
}
#sub{
	margin-top: 20px;
}
#res{
	margin: auto;
	height: 10px;
    width: 150px;
    font-size: 16px;
    color: red;
    font-family: cursive;
}
</style>
</head>

<body style="background: url(img/show6.jpg) no-repeat top;background-size:100% 100%">
<jsp:include page="top.jsp"></jsp:include>
<div id="main">
	<input type="email" name="email" id="email" placeholder="邮箱" required>
	<input type="text" name="realname" class="ipt" id="realname"
		placeholder="联系人" required> <input type="text" name="address"
		class="ipt" id="address" placeholder="地址" required> <input
		type="text" name="phone" class="ipt" id="phone" placeholder="电话"
		required>
	<div id="res"></div>
	<input type="submit" value="保存" onclick="addUserInfo()" id="sub">
</div>
<script type="text/javascript" src="JS/private/userinfo.js"></script>
</body>
</html>
