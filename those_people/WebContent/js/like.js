
//author xuyingjie

function doLike(info_id,user_id)
{
	$.ajax({ 
		type:'get', 
		dataType:'json', 
		url: '/those_people/like/doLike.do?info_id='+info_id+'&uid='+user_id,
		beforeSend:function(){}, 
		success:function(data)
		{
			
			alert(data.result +"  "+data.like);
			if(data.result)
			{
				
				 $("#divid").html(data);
				
			}
		}
	});
}

function cancelLike(info_id,user_id)
{
	$.ajax({ 
		type:'get', 
		url: '/those_people/like/cancelLike.do?info_id='+info_id+'&uid='+user_id,
		beforeSend:function(){}, 
		success:function(data){
			
			if(data=="true")
			{
				alert("取消点赞");
			}
		}
	});
}