
//author xuyingjie

// info_id: the unique id for info
//infotype:	1->LOVE_INFO, 2->JOB_INFO, 3->HOUSE_INFO, 4->ACTIVITY_INFO;
//operateType: likes,collects
function praiseBox(info_id,info_type,operateType)
{
	
	var like_type = document.getElementById("like_type");
	var txt = like_type.innerHTML;

	var operate="";
	if(txt=="赞")
	{
		operate="doLike";

	}
	else if(txt=="取消赞")
	{
		operate="doUnLike";
	}
	
	$.ajax({ 
		type:'get', 
		dataType:'json', 
		url:'/those_people/statics/'+operate+'.do?infoId='+info_id+"&infoType="+info_type+"&operateType="+operateType,
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