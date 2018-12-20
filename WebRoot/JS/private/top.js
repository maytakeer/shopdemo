function showTop(){
	$.ajax({
		url:"TopServlet",
		type:"post",
		dataType:"json",
		data:{
			
		},
		success: function(data){
			var list = data.list;
			//alert(list[0].balance);
			$("#balance").html("余额："+list[0].balance);
			$("#username").html("欢迎光临："+data.accountname);
		}
	});
}
showTop();
function logOut(){
	$.ajax({
		url:"LogOutServlet",
		type:"post",
		dataType:"json",
		data:{
			
		},
		success: function(data){
			//alert("1");
		}
	});
}