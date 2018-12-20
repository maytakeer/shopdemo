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

<title>商品详细信息</title>

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
	margin: auto;
	height: 600px;
	width: 900px;
}

#showimg {
	width: 500px;
	text-align: center;
	height: 598px;
	border: 1px solid #F5EFFB;
	float: left;
}
img{
	width: 100%;
	height: 100%;
}
.right {
	width: 398px;
	height: 88px;
	text-align: center;
}

#mainright {
	float: left;
	width: 398px;
	height: 600px;
}

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
body{
       font-size: 18px;
       font-family: cursive;
       }
       #addcart{
	background:  #696969;
border: none;
padding: 10px 25px 10px 25px;
color: #FFF;
box-shadow: 1px 1px 5px  #696969;
border-radius: 3px;
text-shadow: 1px 1px 1px  #696969;
cursor: pointer;
	}
</style>
</head>

<body style="background: url(img/show3.jpg) no-repeat top;background-size:100% 100%">
	<jsp:include page="top.jsp"></jsp:include>
	<div id="currentgoods" style="display: none">${param.a}</div>
	<div id="main">
		<div id="showimg"></div>
		
		<div id="mainright">
			<div class="right" id="info"></div>
			<div class="right" id="number">
				<span>购买数量：</span>
				<input type="number" id="buynumber" min="1" value="1" name="points" oninput="javascript:this.value=this.value.replace(/[^\d]/g,'')" />
			</div>
			<div class="right" id="total"></div>
			<div class="right" id="price"></div>
			<div class="right" id="gname"></div>
			<div class="right" id="cart">
				<input type="submit" value="添加购物车" id="addcart" onclick="addgoods()"
					style="margin-right: 10px"> <a href="JSP/test1.jsp"
					style="margin-left: 20px">购物车</a>
			</div>
			<div id ="res" style="color: red;font-size: 12px"></div>
		</div>
	</div>
	<script type="text/javascript" src="JS/private/showgoodsinfo.js"></script>
</body>
</html>
