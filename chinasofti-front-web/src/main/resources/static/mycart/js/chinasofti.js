var TT = TAOTAO = {
	checkLogin : function(){
		var _ticket = $.cookie("CHINASOFTI_TICKET");
		if(!_ticket){
			return ;
		}
		$.ajax({
			url : "http://localhost:8185/user/" + _ticket,
			dataType : "json",
			type : "GET",
			success : function(data){
				if(data){
					var _data = data;
					var html =_data.username+"，欢迎来到卓商！<a href=\"http://localhost:8185/user/logout.html\" class=\"link-logout\">[退出]</a>";
					$("#loginbar").html(html);
				}
			}
		});
	}
}

$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	TT.checkLogin();
});
