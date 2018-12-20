function addUserInfo(){
	$.ajax({
		url:"AddUserInfoServlet",
		type:"post",
		dataType:"json",
		data:{
			realname : $("#realname").val(),
			phone : $("#phone").val(),
			email : $("#email").val(),
			address : $("#address").val(),
		},
		success: function(data){
			//alert(data.mes);
			$("#res").html("<span>"+data.mes+"</span>");
			if(data.res=="success"){
				window.location.href="JSP/showgoods.jsp";
			}
			
			
		}
	});
}