function showGart(){
	$.ajax({
		url:"ShowShoppingCartServlet",
		type:"post",
		dataType:"json",
		data :{
			//page : page
		},
		success : function(data){
			var list = data.list;
			$(".goods").html("");
			var price = 0;
			//$(".goods").html("");
			//$(".goods").html("");
			if(list[0]==null){
				window.location.href="JSP/showgoods.jsp";
			}
			for(var index=0;index<list.length;index++){
				var $goods = $("<div class='goods'style='width:714px'>" +
						"<input type='checkbox' name='check' value='"+list[index].cid+"'/>"+
						"<div class='goodsid'style='width:116px;height:200px;border:1px #daffff solid'>商品id："+list[index].gid+"</div>" +
						"<div class='goodsimg'><a href='JSP/showgoodsinfo.jsp?a="+list[index].gid+"'><img onclick='' src='"+list[index].gimg+"'style='width:200px;height:200px;'/></a></div>" +
						"<div class='goodsname'style='width:120px;height:200px;border:1px #daffff solid'>"+list[index].gname+"</div>" +
						"<div class='goodsprice'style='width:120px;height:200px;border:1px #daffff solid'>"+list[index].price+"RMB</div>" +
						"<div class='goodscount'style='width:120px;height:200px;border:1px #daffff solid'>counts:"+list[index].cnum+"</div>" )
						;
					$(".out").append($goods);		
					price += list[index].price*list[index].cnum;					
					//price = parseInt(price);
			}
			$("#totalprice").html("<span>总价"+price+"</span>");
		}
	});		
}
showGart();
$('#dosubmit').click(function(){
//  var checkID = {};//定义一个空数组
// 
//  $("input[name='check']:checked").each(function(i){//把所有被选中的复选框的值存入数组
//   checkID[i] =$(this).val();
//  });
	var da = $("input[name='check']:checked").serialize();
//	alert(da.length);
// alert(checkID.length);
//  //用Ajax传递参数
//  $.post('Ajax.php',{checkID:checkID},function(json){
// 
//  },'json')
  $.ajax({
	  url:"DelCartGoodsServlet?"+da,
		type:"post",
		dataType:"json",
		data:{
		//	arr : checkID
		},
		success :function(data){
			//alert(checkID);
			if(data.res=="success"){
				alert(data.mes);
			}
			showGart();
		}
  });
 });
//function invoicing(){
//	$.ajax({
//		url:"InvoicingServlet",
//		type:"post",
//		dataType:"json",
//		data:{
//			
//		},
//		success :function(data){
//			alert("1");
//			alert(data.mes);
//			showGart();
//		}
//	});
//}
// 
function invoicing(){
	$.ajax({
		url:"InvoicingServlet",
		type:"post",
		dataType:"json",
		data:{
			
		},
		success: function(data){
			//alert("1");
			if(data.res=="success"){
				window.location.href="JSP/showuserinfo.jsp";
			}else{
				alert(data.mes);
			}			
			//showGart();
		}
	});
}
