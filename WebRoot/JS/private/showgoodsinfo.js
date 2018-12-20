function showGoodsInfo(){
	$.ajax({
		url:"showGoodsInfoServlet",
		type:"post",
		dataType:"json",
		data :{
			currentgoods : $("#currentgoods").text()
		},
		success : function(data){
		//	alert($("#currentgoods").val());
			var list = data.list[0];
			$("#showimg").html("<img src='"+list.gimg+"'>");
			$("#info").html("<span>详情介绍："+list.info+"</span>");
			$("#prive").html("<span>价格："+list.price+"</span>");
			$("#total").html("<span>库存数量："+list.total+"</span>");
			$("#gname").html("<span>商品名称："+list.gname+"</span>");
			//$("#number").html("<span>购买数量：</span><input type='text' onkeyup="+"'this.value=this.value.replace(/\D|^0/g,'')'"+" onafterpaste='"+"this.value=this.value.replace(/\D|^0/g,'')"+"'>");
		}
	});		
}
showGoodsInfo();
function addgoods(){
	$.ajax({
		url:"ShoppingCartServlet",
		type:"post",
		dataType:"json",
		data:{
			buynum : $("#buynumber").val(),
			gid : $("#currentgoods").text()
		},
		success:function(data){
//			alert(data.mes);
//			alert("1");
//			alert(data);
			$("#res").html(data.mes);
		}
	});
}