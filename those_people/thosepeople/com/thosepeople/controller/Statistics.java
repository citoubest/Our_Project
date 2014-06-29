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

import com.thosepeople.constant.OperateType;
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
	@RequestMapping("/doAdd")
	@ResponseBody
	public Map<String,Object> doAdd(@RequestParam("infoId") int info_id,@RequestParam("infoType") int infoType,@RequestParam("operateType") int operateType,HttpSession session)  throws BusinessException
	{
		UserInfo user = (UserInfo)session.getAttribute("userInfo");
		int uid = user.getUid();
		Boolean flag=false;
		
		//update database
		flag =statisticsService.add(uid, info_id,infoType,OperateType.getType(operateType));
		
		//if success, update session
		if(flag)
		{
			updateSession(infoType,operateType,user,info_id,0);
		}
		Map<String, Object> result = new HashMap<>(1);
		result.put("result", flag);
		return result;
	}

	/**
	 * 
	 * @param info_id 
	 * @param infoType :the type of info ,for example 1:love ,2:job……
	 * @param operateType : for example: 1:likes,2:collects
	 * @param session
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping("/doMinus")
	@ResponseBody
	public Map<String,Object> doMinus(@RequestParam("infoId") int info_id,@RequestParam("infoType") int infoType,@RequestParam("operateType") int operateType,HttpSession session)  throws BusinessException
	{
		UserInfo user = (UserInfo)session.getAttribute("userInfo");
		int uid = user.getUid();
		Boolean flag=false;

		//update database
		flag =statisticsService.minus(uid, info_id,infoType,OperateType.getType(operateType));

		// if success, update session
		if(flag)
		{
			updateSession(infoType,operateType,user,info_id,1);
		}
		Map<String, Object> result = new HashMap<String, Object>(1);
		result.put("result", flag);
		return result;
	}
	private void updateSession(int infoType,int operateType,UserInfo user,int infoId,int addOrminus) throws BusinessException
	{
		//get static info of this user in session
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
		
		switch(addOrminus)
		{
		case 0://add
			switch(OperateType.getType(operateType))
			{
			case LIKE:
				staticsInfo.setLikes(staticsInfo.getLikes()+","+infoId); 
				break;
			case COLLECT:
				staticsInfo.setCollects(staticsInfo.getCollects()+","+infoId); 
				break;
			}
			break;//end of add
		case 1://minus
			
			String cur_infoId = String.valueOf(infoId);
			List<String>old_list =null;
			List<String>temp =null;
			Iterator<String> it =null;
			String old_str="";
			//get the old value
			switch(OperateType.getType(operateType))
			{
			case LIKE:
				old_str =staticsInfo.getLikes();
				break;
			case COLLECT:
				old_str =staticsInfo.getCollects();
				break;
			}
			//remove the current infoId
			temp = Arrays.asList(old_str.split(","));
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
					switch(OperateType.getType(operateType))
					{
					case LIKE:
						staticsInfo.setLikes(new_Str);
						break;
					case COLLECT:
						staticsInfo.setCollects(new_Str);
						break;
					}
				}
			}
			else
			{
				throw new BusinessException("error when cancel like or collect: infoId "+infoId+"\tinfotype:"+infoType);
			}
			break;
		default:
				throw new BusinessException("no such command");
		}
	}
}
