<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="JS/public/jquery.1.9.1.js"></script>
  </head>
  
  <body>
    <div>
 <input id='sg' type='radio' name='userinfo' value='1'>
  <input id='sg' type='radio' name='userinfo' value='2'>
   <input id='sg' type='radio' name='userinfo' value='3'>
 <input type="button" id="sg1" value="提交">
</div>
<script type="text/javascript" src="JS/private/test.js"></script>
  </body>
</html>
