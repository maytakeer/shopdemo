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
	width: 780px;
	height: 650px;
	margin: auto;
}

.cart {
	width: 780px;
	height: 100px;
}

.cart div {
	float: left;
	width: 110px;
	height: 98px;
}

#img0,#img1,#img2,#img3,#img4,#img5 {
	width: 198px;
}

img {
	text-align: center;
	width: 180px;
	height: 98px;
}

#main {
	line-height: 98px;
	font-size: 16px;
	text-align: center;
}

#total,#page {
	width: 360px;
	margin: auto;
	height: 30px;
}

.jiezhang,.page {
	width: 118px;
	height: 28px;
	float: left;
	line-height: 28px;
	font-size: 16px;
	text-align: center;
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

.delete {
	cursor: pointer;
}

#jiezhang {
	cursor: pointer;
}

#main_top {
	margin: auto;
	width: 714px;
	height: 30px;
}

#main_top div {
	float: left;
	width: 112px;
	text-align: center;
	height: 30px;
}
</style>
</head>

<body style="background: url(img/show5.jpg) no-repeat top;background-size:100% 100%">
	<div id="top">
		<div id="username">用户名</div>
		<div id="balance">余额</div>
		<div>
			<a href="JSP/changePass.jsp">修改密码</a>
		</div>
		<div>
			<a href="JSP/order.jsp">交易记录</a>
		</div>
	</div>
	<div id="main_top">
		<div id="first" style="width: 200px">图片</div>
		<div>商品名称</div>
		<div>价格</div>
		<div>购买数量</div>
		<div>总价</div>
	</div>
	<div id="main">
		<div id="cart0" class="cart">
		<div id="check0"></div>
			<div id="img0"></div>
			<div id="goodsname0"></div>
			<div id="price0"></div>
			<div id="number0"></div>
			<div id="totalprice0"></div>
			<div class="delete" id="delete0" onclick="delect(0)">删除</div>
			<div id="del0" style="width: 0px;"></div>
		</div>
		<div id="cart1" class="cart">
		<div id="check1"></div>
			<div id="img1"></div>
			<div id="goodsname1"></div>
			<div id="price1"></div>
			<div id="number1"></div>
			<div id="totalprice1"></div>
			<div class="delete" id="delete1" onclick="delect(1)">删除</div>
			<div id="del1" style="width: 0px;"></div>
		</div>
		<div id="cart2" class="cart">
		<div id="check2"></div>
			<div id="img2"></div>
			<div id="goodsname2"></div>
			<div id="price2"></div>
			<div id="number2"></div>
			<div id="totalprice2"></div>
			<div class="delete" id="delete2" onclick="delect(2)">删除</div>
			<div id="del2" style="width: 0px;"></div>
		</div>
		<div id="cart3" class="cart">
		<div id="check3"></div>
			<div id="img3"></div>
			<div id="goodsname3"></div>
			<div id="price3"></div>
			<div id="number3"></div>
			<div id="totalprice3"></div>
			<div class="delete" id="delete3" onclick="delect(3)">删除</div>
			<div id="del3" style="width: 0px;"></div>
		</div>
		<div id="cart4" class="cart">
		<div id="check4"></div>
			<div id="img4"></div>
			<div id="goodsname4"></div>
			<div id="price4"></div>
			<div id="number4"></div>
			<div id="totalprice4"></div>
			<div class="delete" id="delete4" onclick="delect(4)">删除</div>
			<div id="del4" style="width: 0px;"></div>
		</div>
		<div id="cart5" class="cart">
		<div id="check5"></div>
			<div id="img5"></div>
			<div id="goodsname5"></div>
			<div id="price5"></div>
			<div id="number5"></div>
			<div id="totalprice5"></div>
			<div class="delete" id="delete5" onclick="delect(5)">删除</div>
			<div id="del5" style="width: 0px;"></div>
		</div>
	</div>
	<div id="total">
		<div class="jiezhang" id="totalprice"></div>
		<div class="jiezhang" id="jiezhang" onclick="invoicing()">结账</div>
	</div>
	<div id="page">
		<div id="prepage" class="page"></div>
		<div id="currentpage" class="page">1</div>
		<div id="nextpage" class="page"></div>
	</div>
	<script type="text/javascript" src="JS/private/shopcart.js"></script>
</body>
</html>
