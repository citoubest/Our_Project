function likeThisInfo() {

};

function showWarnMessage(message) {
	$("#errorInfo").html("<h4>" + message + "<h4/>");
	$("#errorInfo").show();
};

function hideWarnMessage() {
	$("#errorInfo").hide();
};

function checkTelFormat(contactWay)
{
	var format = /(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(13\d{d}$)|(15[0135-9]\d{8}$)|(18[267]\d{8}$)/;
	if(format.test(contactWay))
	{
		return true;
	}
	return false;
}

function checkPostHouseInfo() {
	var title = document.getElementById("title").value;
	var infoType = document.getElementById("infoType").value;
	var houseType = document.getElementById("houseType").value;
	var infoDescribe =document.getElementById("infoDescribe").value;
	var contactWay = document.getElementById("contactWay").value;
	if (title.length == 0 || infoType.length==0
			|| houseType.length == 0
			|| infoDescribe.length == 0
			|| contactWay.length == 0) {
		showWarnMessage("请您把房屋必要信息填写完整！");
		return false;
	}
	if(contactWay.length!=0 && !checkTelFormat(contactWay) )
	{
		showWarnMessage("联系电话格式错误，请您输入正确的号码!");
	
		return false;
	}
	return true;
}

function showHouseDetail(id)
{
	var uid = document.getElementById("uid").value;
	
	if(uid.length==0)
	{
		
		alert("请登录后查看！");
		var url = "/those_people/index/home.do?uid=";
		 window.location.href = url;
		 return;
	}
	
	var uri = "/those_people/house/showHouseDetail.do?uid="+uid+"&id="+id;
	window.location.href=uri;
}

function showMore() 
{ 
	var currentpage = document.getElementById("currentPage").value;
	ajaxRead(currentpage); 
} 

function ajaxRead(currentpage) 
{ 
	$.ajax({ 
		type:'get', 
		dataType:'json', 
		url: '/those_people/house/showMoreHouseInfo.do?currentPage='+currentpage,
		beforeSend:function(){}, 

		success:function(data){ 
			if (data && data.success == "true") 
			{
				$('#currentPage').attr('value',data.currentPage);
				
				$.each(data.data, function(i, houseInfo) {  
					$('#infoBody').append(  
							'<div class="row"><div class="col-md-2">'+
							'<img src='+houseInfo.headPicPath+'class="img-rounded" id="head-pic-detail"> <label style="padding-left: 15px;">'+
							houseInfo.nickName+'</label></div><div class="col-md-10">	<div class="row" id="houseInfo">'+
							'<a href="javascript:void(0)" onclick="showHouseDetail('+houseInfo.id+')">'+houseInfo.title+
							'</a>&nbsp<span class="label label-info" style="font-size: 15px;">'+ houseInfo.infoType+
							'</span></p></div>	<div class="row" id="postTime">	<p>发布日期:'+houseInfo.postTime+
							'</p></div>	<div class="row" id="houseinfohead"> 房屋类型：'+ houseInfo.houseType+
							'</div></div></div><hr class="featurette-divider">'
					);  
				});  
			}
			else
			{
				alert("已加载全部信息");
			}

		}, 
		complete:function(){} 
	}); 
}