package com.thosepeople.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thosepeople.constant.InfoType;
import com.thosepeople.service.StatisticsService;
import com.thosepeople.vo.UserInfo;

/**
 * 
 * @author xuyingjie
 *
 */
@Controller
public class Statistics {

	@Autowired
	@Qualifier("statisticsService")
	StatisticsService statisticsService;
	
	@RequestMapping("/like/doLike")
	@ResponseBody
	public Map<String,Object> doLike(@RequestParam int info_id,@RequestParam("infoType") int infoType,HttpSession session)
	{
		UserInfo user = (UserInfo)session.getAttribute("userInfo");
		int uid = user.getUid();
		
		Boolean flag =statisticsService.postLike(uid, info_id,InfoType.getInfoTypeByValue(infoType));

		Map<String, Object> result = new HashMap<>(1);
		result.put("result", flag);
		return result;
	}
}
