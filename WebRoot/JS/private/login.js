function login(){
	$.ajax({
		url : "LoginServlet",
		type : "post",
		dataType : "json",
		data : {
			username : $("#username").val(),
			pass : $("#password").val(),
			code : $("#code").val()
		},
		success : function(data){
			if(data.mes == "success"){
				window.location.href="JSP/showgoods.jsp";
			}else{
				$("#result").html(data.mes);
				//$("input").val("");
			}
			
		}
	});
}
function jumpRegistered(){
	window.location.href="JSP/registered.jsp";
}