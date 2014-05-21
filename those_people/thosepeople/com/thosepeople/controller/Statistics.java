package com.thosepeople.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.thosepeople.model.UserStaticsInfo;
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

	/**
	 * 
	 * @param info_id 
	 * @param infoType :the type of info ,for example 1:love ,2:job……
	 * @param operateType : for example: likes,collects
	 * @param session
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping("/doLike")
	@ResponseBody
	public Map<String,Object> doLike(@RequestParam("infoId") int info_id,@RequestParam("infoType") int infoType,@RequestParam("operateType") String operateType,HttpSession session)  throws BusinessException
	{
		UserInfo user = (UserInfo)session.getAttribute("userInfo");
		int uid = user.getUid();
		//1.get static info of this user in session
		Map<Integer, UserStaticsInfo> map=user.getStatics_info();
		if(map==null)
		{
			map = new HashMap<Integer, UserStaticsInfo>(3);
			user.setStatics_info(map);
		}
		UserStaticsInfo staticsInfo=map.get(infoType);

		if(staticsInfo == null)
		{
			staticsInfo = new UserStaticsInfo();
			staticsInfo.setInfotype(infoType);
		}
		map.put(infoType,staticsInfo);
		Boolean flag=false;

		//update database
		flag =statisticsService.add(uid, info_id,infoType,operateType);
		//if success, update session
		if(flag)
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
		}


		Map<String, Object> result = new HashMap<>(1);
		result.put("result", flag);
		return result;
	}

	/**
	 * 
	 * @param info_id 
	 * @param infoType :the type of info ,for example 1:love ,2:job……
	 * @param operateType : for example: likes,collects
	 * @param session
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping("/doUnLike")
	@ResponseBody
	public Map<String,Object> doUnLike(@RequestParam("infoId") int info_id,@RequestParam("infoType") int infoType,@RequestParam("operateType") String operateType,HttpSession session)  throws BusinessException
	{
		UserInfo user = (UserInfo)session.getAttribute("userInfo");
		int uid = user.getUid();
		//1.get static info of this user in session
		Map<Integer, UserStaticsInfo> map=user.getStatics_info();
		if(map==null)
		{
			map = new HashMap<Integer, UserStaticsInfo>(3);
			user.setStatics_info(map);
		}
		UserStaticsInfo staticsInfo=map.get(infoType);

		if(staticsInfo == null)
		{
			staticsInfo = new UserStaticsInfo();
			staticsInfo.setInfotype(infoType);
		}
		map.put(infoType,map.get(infoType));
		Boolean flag=false;

		flag =statisticsService.minus(uid, info_id,infoType,operateType);

		if(flag)
		{
			String cur_infoId = String.valueOf(info_id);
			List<String>old_list =null;
			List<String>temp =null;
			Iterator<String> it =null;
			switch(operateType)
			{
			case "likes":
				String likes =staticsInfo.getLikes();
				temp = Arrays.asList(likes.split(","));
				old_list =new ArrayList<String>(temp);
				if(old_list!=null &&old_list.size()!=0 )
				{
					it = old_list.iterator();
					String removed = "";
					while(it.hasNext())
					{
						String cur = it.next();
						if(cur_infoId.equals(cur))
						{
							removed = cur;
							break;
						}
					}
					if(removed!="")
					{
						old_list.remove(removed);
						StringBuilder  builder = new StringBuilder();
						String new_Str ="";

						if(old_list.size()!=0)
						{
							for (String string : old_list) {
								builder.append(string).append(",");
							}
							builder.deleteCharAt(builder.lastIndexOf(","));
							new_Str = builder.toString();
						}

						staticsInfo.setLikes(new_Str);
					}
				}
				else
				{
					throw new BusinessException("取消赞时出错，");
				}
				break;
			case "collects":
				break;
			}

		}
		Map<String, Object> result = new HashMap<>(1);
		result.put("result", flag);
		return result;
	}
}
