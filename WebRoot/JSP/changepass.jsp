<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="JSP/css/register-login.css">
	<script type="text/javascript" src="JS/public/jquery.1.9.1.js"></script>
  </head>  
  <body>  
<div id="box"></div>
<div class="cent-box register-box">
	<div class="cent-box-header">
		<h1 class="main-title hide" style="color: black;font-size: 20px"></h1>
		<h2 class="sub-title">herschel</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">		
			<a href="JSP/login.jsp">登录</a>
			<a href="JSP/showgoods.jsp" class="active">主页</a>	
			</div>
		</div>

		<div class="login form">
			<div class="group">
				
				<div class="group-ipt user">
					<input type="text" name="user" id="username" class="ipt" placeholder="用户名" required>
				</div>
				<div class="group-ipt email">
					<input type="password" name="email" id="oldpass" class="ipt" placeholder="旧密码" required>
				</div>
				<div class="group-ipt password">
					<input type="password" name="password" id="newpass" class="ipt" placeholder="设置新密码" required>
				</div>
				<div class="group-ipt password1">
					<input type="password" name="password1" id="rpass" class="ipt" placeholder="重复密码" required>
				</div>				
			</div>
		</div>
	
		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button" onclick="alterpass()">修改密码</button>
		</div>		 
   <div id="result"style="font-size: 14px;color: red"></div>		 
	</div>
</div>

<div class="footer">
	<p>千寻 - Thousands Find</p>
	<p>Designed By ZengRong & <a href="zrong.me">zrong.me</a> 2016</p>
</div>

<script src='JSP/js/particles.js' type="text/javascript"></script>
<script src='JSP/js/background.js' type="text/javascript"></script>
<script src='JSP/js/layer/layer.js' type="text/javascript"></script>
<script src='JSP/js/index.js' type="text/javascript"></script>
 <script type="text/javascript" src="JS/private/changepass.js"></script>

<script>
	$("#remember-me").click(function(){
		var n = document.getElementById("remember-me").checked;
		if(n){
			$(".zt").show();
		}else{
			$(".zt").hide();
		}
	});
</script>       
  </body>
</html>
