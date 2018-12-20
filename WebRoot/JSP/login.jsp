<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="JSP/css/base.css">
    <link rel="stylesheet" href="JSP/css/style.css">
<script type="text/javascript" src="JS/public/jquery.1.9.1.js"></script>
  <script type="text/javascript" src="JS/private/login.js"></script>
</head>

<body>
	        <div class="bg"></div>
    <div class="container">
        <div class="line bouncein">
            <div class="xs6 xm4 xs3-move xm4-move">
                <div style="height:150px;"></div>
                <div class="media media-y margin-big-bottom">
                </div>
                <form action="index.html" method="post">
                    <div class="panel loginbox">
                    <div id="registered"
		style="color: blue; position: absolute; left:20px; top:200px; cursor: pointer;" onclick="jumpRegistered()">注册</div>
		
                        <div class="text-center margin-big padding-big-top">
                            <h1>herschel</h1>
                        </div>
                        <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                            <div class="form-group">
                                <div class="field field-icon-right">
                                    <input type="text" class="input input-big" name="name" id="username" placeholder="登录账号" />
                                    <span class="icon icon-user margin-small"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="field field-icon-right">
                                    <input type="password" class="input input-big"  id="password"  placeholder="登录密码" />
                                    <span class="icon icon-key margin-small"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="field">
                                    <input type="text" class="input input-big" name="code" id="code" placeholder="填写下面的验证码" />
                                    <img id="code1" src="" onclick="showCode()" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" >
                            		<div id="result" style="color:red; padding: 0;"></div>
                                </div>
                            </div>
                        </div>
                        <div style="padding:15px;">
                            <input type="button" id="button" class="button button-block bg-main text-big input-big" value="登录" onclick="login();showCode()" id="confirm">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript">
		function showCode() {
			document.getElementById("code1").src = "PictureCheckCodeServlet?a="
					+ Math.random();
		}
		showCode();
	</script>
	<script type="text/javascript" src="JS/private/login.js"></script>
</body>
</html>
