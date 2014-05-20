
//author xuyingjie

function praiseBox(info_id,info_type,operateType)
{
	
	var like_type = document.getElementById("like_type");
	var txt = like_type.innerHTML;

	var operate="";
	if(txt=="赞")
	{
		operate=1;

	}
	else if(txt=="取消赞")
	{
		operate=0;
	}
	
	$.ajax({ 
		type:'get', 
		dataType:'json', 
		url:'/those_people/statics/doLike.do?infoId='+info_id+"&infoType="+info_type+"&operate="+operate+"&operateType="+operateType,
		beforeSend:function(){}, 
		success:function(data){

			var like_count=document.getElementById("like_total");
			var oldTotal=parseInt(like_count.innerHTML);
			
			if(data.result)
			{
				if(txt=="赞")
				{
					like_count.innerHTML=oldTotal+1;
					like_type.innerHTML="取消赞";

				}
				else if(txt=="取消赞")
				{
					like_count.innerHTML=oldTotal-1;
					like_type.innerHTML="赞";
				}
			}
		},
		complete:function(){} 
	}); 
}