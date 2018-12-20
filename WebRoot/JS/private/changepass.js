function alterpass() {
	$.ajax({
		url : "ChangePassServlet",
		type : "post",
		dataType : "json",
		data : {
			username : $("#username").val(),
			pass : $("#oldpass").val(),
			pass1 : $("#newpass").val(),
			pass2 : $("#rpass").val()
		},
		success : function(data) {
			//alert(pass2);
			if (data.res == "success") {
				window.location.href="JSP/login.jsp";
				}
			$("#result").html(data.mes);
			$("input").val();

		}

	});
}