function registered(){
	$.ajax({
		url:"RegisteredServlet",
		type:"post",
		dataType:"json",
		data:{
			name : $("#user").val(),
			pass : $("#password").val(),
			pass1 : $("#password1").val(),
			code : $("#verify").val()
		},
		success : function(data){
			if(data.state == "success"){
				window.location.href="JSP/login.jsp";
			}
			$("#result").text(data.mes);
			$("input").val();
			
		}
	});
}