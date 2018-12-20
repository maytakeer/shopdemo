function showUserInfo(){
	 $.ajax({
		  	url:"ShowUserInfoServlet",
			type:"post",
			dataType:"json",
			data:{
				
			},
			success :function(data){
				var list = data.list;
				$("#main").html("");
				if(list[0]==null){
					window.location.href="JSP/userinfo.jsp";
				}
				for(var i = 0;i < list.length;i++){
					var $info=$("<input id='eid"+i+"' type='radio' name='userinfo' value='"+list[i].eid+"'><span>邮箱："+list[i].mail+"</span>" +
							"<span>姓名："+list[i].realname+"</span><span>电话："+list[i].phone+"</span><span>详细地址："+list[i].address+"</span>"
							+"<input type='submit' value='删除' onclick='delUserInfo("+i+")' id='sub"+i+"'>"
					);
					$("#main").append($info);
				}
				var $foots=$("<input type='submit' value='确认' onclick='sendEmial()' id='sub'>");
				$("#foot").append($foots);
			}
	  });
}
showUserInfo();

function sendEmial(){
//	var da = $("input[name='userinfo']:checked").serialize();
//	alert(da);
	var da = $("input[name='userinfo']:checked").val();
	$.ajax({
		  url:"SendEmailServlet",
			type:"post",
			dataType:"json",
			data:{
				eid:da
			},
			success :function(data){
				window.location.href="JSP/showgoods.jsp";
			}
	  });
}
function delUserInfo(i){
$.ajax({
  	url:"DelUserInfoServlet",
	type:"post",
	dataType:"json",
	data:{
		eid : $("#eid"+i).val()
	},
	success :function(data){
		showUserInfo();
	}
});
}