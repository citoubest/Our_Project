/**
 * 
 */
package com.thosepeople.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chenzhuo
 *
 */
@Controller
@RequestMapping(value="/index")
public class HomePageInitializer {
	@RequestMapping(value="/initialize")
   public ModelAndView initialize(){
	   return new ModelAndView("love_info_detail");
   }
	
	@RequestMapping("/home")
	public ModelAndView homePage(@RequestParam("uid") Integer uid){
		System.out.println(uid);
		if(uid==null){
			return new ModelAndView("index");
		}else{
			return new ModelAndView("home");
		}
	}
}
