package com.thosepeople.controller;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thosepeople.service.HouseService;
import com.thosepeople.service.PageService;
import com.thosepeople.vo.HouseInfo;
import com.thosepeople.vo.UserInfo;

/**
 * @author shanchangyu
 * 
 */

@Controller
@RequestMapping("/house")
public class PostHouseInfo {
	@Autowired
	@Qualifier("houseService")
	HouseService houseService;
	@Autowired
	@Qualifier("pageService")
	private PageService pageService;
	private  final int pageSize = 10;
	public HouseService getHouseService() {
		return houseService;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
	@RequestMapping(value = "/houseInfo" , method = RequestMethod.POST)
	@SuppressWarnings("unchecked")
	public ModelAndView postHouseInfo(@RequestParam("title") String title,
			@RequestParam("infoType") String infoType,
			@RequestParam("houseType") String houseType,
			@RequestParam("infoDescribe") String infoDescribe,
			//@RequestParam("picturePath") String picturePath,
			@RequestParam("contactWay") String contactWay,
			HttpSession session) {
		UserInfo ui=(UserInfo) session.getAttribute("userInfo");
		if(ui!=null)
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
			String date=dateFormat.format(new java.util.Date());
			int houseInfo=houseService.postHouseInfo(title, infoType, houseType, infoDescribe,contactWay,ui.getUid(), date);
			if(houseInfo>0)
			{
				session.setAttribute("houseInfo", houseInfo);
				List<HouseInfo> list=(List<HouseInfo>)pageService.getMoreInfo(null, 1,pageSize,"house");
				ModelMap	modelMap = new ModelMap();
				modelMap.put("HouseInfo", list);
				modelMap.put("currentPage", 1);
				return new ModelAndView("house_info",modelMap); 
			}
			return new ModelAndView("404");
		}
		return new ModelAndView("404");
	}
	

	@RequestMapping("/showHouseDetail")
	public ModelAndView showHouseDetail(@RequestParam("uid")int uid,@RequestParam("id")int id,
			HttpSession session)
	{
		HouseInfo detail=houseService.getDetailHouseInfo(id);
		if(detail!=null)
		{
			ModelMap modelMap=new ModelMap();
			modelMap.put("houseInfo", detail);
			return new ModelAndView("house_info_detail",modelMap);
		}

		return new ModelAndView("404");

	}
	
	@RequestMapping("/showMoreHouseInfo")
	@SuppressWarnings("unchecked")
	@ResponseBody
	public Map<String, Object> showMoreHouseInfo(@RequestParam("currentPage") Integer currentPage)
	{
		int pageNum;
		if(currentPage==null){
			pageNum=1;
		}
		else
		{
			pageNum = currentPage+1;
		}

		List<HouseInfo> list=(List<HouseInfo>)pageService.getMoreInfo(null, pageNum,pageSize,"house");

		if(list==null ||list.size()==0)
		{
			
			Map<String, Object> modelMap = new HashMap<String, Object>(1);  
			modelMap.put("success", "false");  	
			return modelMap;
			
		}
		else
		{
			Map<String, Object> modelMap = new HashMap<String, Object>(3);  
			modelMap.put("currentPage", pageNum);
			modelMap.put("data", list);  
			modelMap.put("success", "true");  		 
			return modelMap; 
		}
	}
}
