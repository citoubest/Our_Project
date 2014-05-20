package com.thosepeople.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.model.StaticsInfo;
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
	public Map<String,Object> doLike(@RequestParam("infoId") int info_id,@RequestParam("infoType") int infoType,@RequestParam("operateType") String operateType,@RequestParam("operate") int operate,HttpSession session)  throws BusinessException
	{
		UserInfo user = (UserInfo)session.getAttribute("userInfo");
		int uid = user.getUid();
		
		
		//更新session信息
		Map<Integer, StaticsInfo> map=user.getStatics_info();
		if(map==null)
		{
			map = new HashMap<Integer, StaticsInfo>(3);
			user.setStatics_info(map);
		}
		StaticsInfo staticsInfo=map.get(infoType);
		
		Boolean flag=false;
		if(operate==1)
		{
			switch(operateType)
			{
				case "likes":
					staticsInfo.setLikes(staticsInfo.getLikes()+","+info_id); 
					break;
				case "collects":
					staticsInfo.setCollects(staticsInfo.getCollects()+","+info_id); 
					break;
			}
			flag =statisticsService.add(uid, info_id,infoType,operateType);
		}
		else
		{
			String cur_infoId = String.valueOf(info_id);
			List<String>old_list =null;
			Iterator<String> it =null;
			switch(operateType)
			{
				case "likes":
					old_list =staticsInfo.getLikes();
					it = old_list.iterator();
					for (String string : old_list) {
						if(cur_infoId.equals(string))
						{
							it.remove();
						}
					}
					break;
				case "collects":
					old_list =staticsInfo.getCollects();
					it= old_list.iterator();
					for (String string : old_list) {
						if(cur_infoId.equals(string))
						{
							it.remove();
						}
					}
					staticsInfo.setCollects(staticsInfo.getCollects()+","+info_id); 
					break;
			}
			
			flag =statisticsService.minus(uid, info_id,infoType,operateType);
		}
		Map<String, Object> result = new HashMap<>(1);
		result.put("result", flag);
		return result;
	}
}
