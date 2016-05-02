function activies_addcheck(){
	var atv_date=$("#atv_date").val();
	var atv_place=$("#atv_place").val();
	var atv_title=$("#atv_title").val();
	
	if(atv_date==""){
		$("#atv_datespan").css("color","red");
		$("#atv_datespan").html("时间不能为空");
		return false;
	}else if(atv_date!=""){
		$("#atv_datespan").css("color","green");
		$("#atv_datespan").html("(●'◡'●)");
		}
	if(atv_place==""){
		$("#atv_placespan").css("color","red");
		$("#atv_placespan").html("地点不能为空");
		return false;
	}else if(atv_place!=""){
		$("#atv_placespan").css("color","green");
		$("#atv_placespan").html("(●'◡'●)");
		}
	if(atv_title==""){
		$("#atv_titlespan").css("color","red");
		$("#atv_titlespan").html("概要不能为空");
		return false;
	}else if(atv_title!=""){
		$("#atv_titlespan").css("color","green");
		$("#atv_titlespan").html("(●'◡'●)");
		}	
	if(atv_date!=""&&atv_place!=""&&atv_title!=""){
		$("#addatvform").submit();		
	}else{
		alert("必要信息不能为空");
	}
}