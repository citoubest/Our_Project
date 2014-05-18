
//author xuyingjie

function praiseBox(info_id)
{
	//向后台提交数据

	$.ajax({ 
		type:'get', 
		dataType:'json', 
		url: '/those_people/like/doLike.do?info_id='+info_id,
		beforeSend:function(){}, 
		success:function(data)
		{
			if(data.result)
			{
				var like_type = document.getElementById("like_type");
				var txt = like_type.innerHTML;

				var like_count=document.getElementById("like_total");
				var oldTotal=parseInt(like_count.innerHTML);

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
		}
	});


}