function showCart(page){
	$.ajax({
		url:"ShowShoppingCartServlet",
		type:"post",
		dataType:"json",
		data :{
			page : page
		},
		success : function(data){
			var list = data.list;
			//总价
			var totalprice=0;
			if(list[0]==null){
				window.location.href="JSP/showgoods.jsp";
			}
			for(var j = 0;j < 6;j++){
				
				if(list[j] == null){
					$("#img"+j).html("");
					$("#price"+j).html("");
					$("#number"+j).html("");
					$("#totalprice"+j).html("");
					$("#goodsname"+j).html("");
					$("#del"+j).html("");
					$("#delete"+j).hide();
				}else{
				//	for(var i = 0;i < list.length;i++){
						$("#img"+j).html("<img src='"+list[j].gimg+"'>");
						$("#goodsname"+j).html(list[j].gname);
						$("#price"+j).html(list[j].price);
						$("#number"+j).html(list[j].cnum);
						$("#totalprice"+j).html(list[j].price*list[j].cnum);
						$("#del"+j).html(list[j].cid).hide();
					//}
						totalprice += list[j].price*list[j].cnum;
				}
			
			}
			$("#totalprice").html("<span>总计："+totalprice+"</span>")
		}
	});		
}
showCart(1);
function delect(i){
	$.ajax({
		url:"DelectCartGoodsServlet",
		type:"post",
		dataType:"json",
		data:{
			cid : $("#del"+i).text()
		},
		success : function(data){
			//window.location.href="JSP/shopcart.jsp";
			showCart(1);
		}
	});
}
function invoicing(){
	$.ajax({
		url:"InvoicingServlet",
		type:"post",
		dataType:"json",
		data:{
			
		},
		success :function(data){
			if(data.res=="success"){
				window.location.href="JSP/showuserinfo.jsp";
			}
			alert(data.res);
			alert(data.mes);
		}
	});
}