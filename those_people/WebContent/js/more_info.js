/**
 * 
 * author xuyingjie
 */

function showMore( infoType) 
{ 
	var currentpage = document.getElementById("currentPage").value;
	ajaxRead(currentpage,infoType); 
} 

function ajaxRead(currentpage,infoType) 
{ 
	$.ajax({ 
		type:'get', 
		dataType:'json', 
		url: '/those_people/page/moreInfo.do?currentPage='+currentpage+'&infoType='+infoType,
		beforeSend:function(){}, 
		success:function(data){

			//最后一页，将“更多”隐藏
			if(data.totalPageNum<=data.currentPage)
			{
				var link = document.getElementById("linkMore");
				link.style.display="none";
			}
			if (data && data.success == "true") 
			{
				switch(infoType)
				{
				case 1:
					appendLoveInfo(data);
					break;
				case 2:
					appendJobInfo(data);
					break;
				case 3:
					appendHouseInfo(data);
					break;
				default:
					return;
				}
			}
		},
		complete:function(){} 
	}); 
}

function appendJobInfo( data)
{
	$('#currentPage').attr('value',data.currentPage);

	$.each(data.data, function(i, res)
			{  
		$('#infoBody').append(
				'<div class="row"><div class="col-md-2"><img src="'+
				res.headPicPath+'" class="img-rounded" id="head-pic-detail"> <label style="padding-left: 15px;">'+
				res.nickName +'</label></div><div class="col-md-10">	<div class="row" id="jobinfotitle">'+
				res.nickName +'发布了 <a href="javascript:void(0)" onclick="showJobDetail('+
				res.id+')">'+
				res.title+'</a> <span class="label label-info" style="font-size: 15px;">'+
				res.jobtype+'</span></div><div class="row" id="jobinfohead">公司：'+
				res.company+' 工作地点：'+
				res.workPlace+'</div>&nbsp<div class="row" id="jobinfocontent"><p>工作职责：'+
				res.content+'</p></div></div></div><div><span>赞(<c:out value="'+
				res.likes+'"/>)</span><span>访问(<c:out value="'+
				res.visits+'"/>)</span><span>收藏(<c:out value="'+
				res.comments+'"/>)</span></div><hr class="featurette-divider">'
		);    
			});  
}

function appendLoveInfo(data)
{
	$('#currentPage').attr('value',data.currentPage);

	$.each(data.data, function(i, res)
			{  
		$('#infoBody').append();  
			});  
}

function appendHouseInfo(data)
{
	$('#currentPage').attr('value',data.currentPage);

	$.each(data.data, function(i, res)
			{  
		$('#infoBody').append();  
			});  
}