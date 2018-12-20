function showRecord() {
	$.ajax({
		url : "ShowOrderServlet",
		type : "post",
		dataType : "json",
		data : {

		},
		success : function(data) {
			var list = data.list;
			for (var i = 0; i < 50; i++) {
				if (list[i] == null) {
					$("#goodsname" + i).hide();
					$("#price" + i).hide();
					$("#number" + i).hide();
					$("#totalprice" + i).hide();
					$("#time" + i).hide();
				} else {
					$("#goodsname" + i).html(list[i].gname);
					$("#price" + i).html(list[i].price);
					$("#number" + i).html(list[i].onum);
					$("#totalprice" + i).html(list[i].price*list[i].onum);
					$("#time" + i).html(list[i].time);
				}
			}
			//$("#username").html("欢迎光临:"+data.username);
		}
	});
}
showRecord();