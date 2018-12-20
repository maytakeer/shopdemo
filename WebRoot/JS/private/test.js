$('#dosubmit').click(function(){
//  var checkID = {};//定义一个空数组
// 
//  $("input[name='check']:checked").each(function(i){//把所有被选中的复选框的值存入数组
//   checkID[i] =$(this).val();
//  });
	var da = $("input[name='check']:checked").serialize();
	alert(da.length);
// alert(checkID.length);
//  //用Ajax传递参数
//  $.post('Ajax.php',{checkID:checkID},function(json){
// 
//  },'json')
  $.ajax({
	  url:"TestServlet?"+da,
		type:"post",
		dataType:"json",
		data:{
		//	arr : checkID
		},
		success :function(data){
			alert(checkID);
		}
  });
 });
$('#sg1').click(function(){
	var da = $("input[name='userinfo']:checked").val();
	alert(da);
});
//function doit(){
//	 $.ajax({
//		  url:"TestServlet",
//			type:"post",
//			dataType:"json",
//			data:{
//			//	arr : checkID
//				$("#sg").val()
//			},
//			success :function(data){
//				alert(checkID);
//			}
//	  });
//}