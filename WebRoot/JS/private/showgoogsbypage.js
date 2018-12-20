function showByPage(rpage){
	$.ajax({
		url:"ShowGoodsByPageServlet",
		type : "post",
		dataType : "json",
		data:{
			page:rpage
		},
		success: function(data){
			//当前页数
			var currentpage = data.currentpage;
			//总页数
			var totalpage = data.totalpage;
			var list = data.list;
			//alert(list.length);
			//alert(totalpage);
			for(var j = 0;j < 6;j++){
				$("#showimg"+j).html("");
				$("#showbrand"+j).html("");
				$("#showprice"+j).html("");
			}
			for (var i = 0; i < list.length; i++) {
				$("#showimg"+i).html("<a href='JSP/showgoodsinfo.jsp?a="+list[i].id+"'><img style='border: 1px solid #F5EFFB;' src='"+list[i].gimg+"'> </a>");
				$("#showbrand"+i).html("<span>物品名称："+list[i].gname+"</span>");
				$("#showprice"+i).html("<span>￥："+list[i].price+"</span>");				
			}
			$("#currentpage").html(currentpage);
			if(currentpage>1){
				var page = parseInt(currentpage) - 1;
				$("#prepage").html("<a href='JavaScript:showByPage("+page+")'>上一页</a>");
			}
			if(currentpage<totalpage){
				var page = parseInt(currentpage) + 1;
				$("#nextpage").html("<a href='JavaScript:showByPage("+page+")'>下一页</a>");
			}
		}
	});
}
showByPage(1);