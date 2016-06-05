$(document).ready(function(){
	if($("div.successFlag").html()=="0" || $("div.successFlag").html()=="1") {
		if($("div.successFlag").html()=="0") {
			$("#outputWords").html("预约失败")
		} else {
			$("#outputWords").html("预约成功")
		}
		$(function () { $('#myModal').modal({
	      keyboard: true
	   	})});
	}
})