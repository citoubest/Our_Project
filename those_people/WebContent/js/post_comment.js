function postCommnet(infoType, commentType, commentUserId) {
	var content = $("#commentContent").val();
	if ($.trim(content).length == 0) {
		return;
	}
	$("#commentContent").val("");
	var infoId = $("#infoId").val();

	$
			.post(
					"/those_people/post_comment/post.do",
					{
						"infoType" : infoType,
						"commentType" : commentType,
						"commentContent" : content,
						"commentUserId" : commentUserId,
						"infoId" : infoId
					},
					function(data) {
						if (data.result == "success") {
							$('#commentContend')
									.prepend(
											'<div class="row"><div class="col-md-2"><img src='
													+ data.replyUserHeadPic
													+ ' class="img-rounded" id="head-pic-comment"> <label id="commentUser">'
													+ data.replyUserNickName
													+ ":"
													+ '</label></div><div class="col-md-10"> <div class="row">'
													+ data.commentContent
													+ '&nbsp;&nbsp;&nbsp;&nbsp;('
													+ data.replyTime
													+ ')'
													+ '</div><br><div class="row"><a href="" id="replyButton">回复</a></div></div></div>'
													+ '<hr class="featurette-divider">');
						}
					});
}