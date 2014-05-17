package com.thosepeople.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author xuyingjie
 *
 */
@Controller
public class Statistics {

	

	@RequestMapping("/like/doLike")
	@ResponseBody
	public Map<String,Object> doLike(@RequestParam int uid,@RequestParam int info_id)
	{
		Boolean flag =  true;
		Map<String, Object> result = new HashMap<>(1);
		result.put("result", flag);
		result.put("like", 1);
		return result;
	}
	
	@RequestMapping("/like")
	public Map<String,Boolean> cancelLike(@RequestParam int uid,@RequestParam int info_id)
	{
		Boolean flag =  true;
		Map<String, Boolean> result = new HashMap<>(1);
		result.put("result", flag);
		return result;
	}
	
	
	
}
