package com.thosepeople.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.service.PostCommentService;
import com.thosepeople.util.DateUtils;
import com.thosepeople.vo.UserInfo;


@Controller
@RequestMapping("/post_comment")
public class InfoComment {

	@Autowired
	@Qualifier("postCommentService")
	private PostCommentService postCommentService;

	public void setPostCommentService(PostCommentService postCommentService) {
		this.postCommentService = postCommentService;
	}

	@RequestMapping("/post")
	@ResponseBody
	public Map<String, String> postComment(
			@RequestParam("infoId") int infoId,
			@RequestParam("commentUserId") int commentUserId,
			@RequestParam("commentContent") String commentContent,
			@RequestParam(value = "beRepliedUserId", required = false) Integer beRepliedUserId,
			@RequestParam("infoType") int infoType,
			@RequestParam("commentType") int commentType, HttpSession session)
			throws BusinessException {
		if(beRepliedUserId==null)
		{
			beRepliedUserId=-1;
		}
		
		boolean result = postCommentService.postComment(infoId, commentUserId,
				beRepliedUserId, commentContent, infoType);
		if (result) {
			Map<String, String> response = new HashMap<String, String>(4);
			response.put("result", "success");
			if (commentType == 1) 
			{// 0 comment the info ,1 reply other's
									// comment
				String beRepliedUserName = postCommentService
						.getTheNickNameWhoBeReplied(beRepliedUserId);
				response.put("beRepliedUserName", beRepliedUserName);
				response.put("beRepliedUserId", String.valueOf(beRepliedUserId));
			}
			UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
			String replyUserHeadPic=userInfo.getHeadPicPath();
			String replyUserNickName=userInfo.getNickName();
			String replyTime=DateUtils.getNowDateString(new Date());
			response.put("replyUserHeadPic", replyUserHeadPic);
			response.put("replyUserNickName", replyUserNickName);
			response.put("replyTime",replyTime);
			response.put("commentContent", commentContent);
			return response;
		} else {
			Map<String, String> response = new HashMap<String, String>(1);
			response.put("result", "fail");
			return response;
		}
	}
}
