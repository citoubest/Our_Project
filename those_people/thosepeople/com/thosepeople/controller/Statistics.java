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
import com.thosepeople.exception.BusinessException;
import com.thosepeople.service.StatisticsService;
import com.thosepeople.vo.UserInfo;

/**
 * 
 * @author xuyingjie
 *
 */
@Controller
@RequestMapping("/statics")
public class Statistics {

	@Autowired
	@Qualifier("statisticsService")
	StatisticsService statisticsService;
	
	@RequestMapping("/doLike")
	@ResponseBody
	public Map<String,Object> doLike(@RequestParam("infoId") int info_id,@RequestParam("infoType") int infoType,@RequestParam("operate") int operate,HttpSession session)  throws BusinessException
	{
		UserInfo user = (UserInfo)session.getAttribute("userInfo");
		int uid = user.getUid();
		
		Boolean flag=false;
		if(operate==1)
		{
			flag =statisticsService.postLike(uid, info_id,InfoType.getInfoTypeByValue(infoType));
		}
		else
		{
			flag =statisticsService.postUnLike(uid, info_id,InfoType.getInfoTypeByValue(infoType));
		}
		Map<String, Object> result = new HashMap<>(1);
		result.put("result", flag);
		return result;
	}
}
