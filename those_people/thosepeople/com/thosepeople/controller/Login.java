/**
 * 
 */
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
import org.springframework.web.servlet.ModelAndView;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.model.UserStaticsInfo;
import com.thosepeople.service.LoginService;
import com.thosepeople.service.StatisticsService;
import com.thosepeople.vo.UserInfo;

/**
 * @author chenzhuo
 * 
 */
@Controller
@RequestMapping("/login")
public class Login {
	@Autowired
	@Qualifier("loginService")
	LoginService loginService;
	
	@Autowired
	@Qualifier("statisticsService")
	StatisticsService statisticsService;
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@ResponseBody
	@RequestMapping("/verifyPassword")
	public Map<String, Boolean> verifyThePassWord(
			@RequestParam("loginEmail") String email,
			@RequestParam("loginPassword") String passWord) {
		Map<String, Boolean> result = new HashMap<>(1);
		boolean verifyResult = loginService.verrifyTheUserPassWord(email,
				passWord);
		result.put("result", verifyResult);
		return result;
	}

	@RequestMapping("/loginAccount")
	public ModelAndView login(@RequestParam("loginEmail") String email,
			HttpSession session) throws BusinessException {
		UserInfo userInfo = loginService.getUserDetail(email);
		
		//get user staticsinfo;
		Map<Integer,UserStaticsInfo>map=statisticsService.getStaticsInfoByUid(userInfo.getUid());
		userInfo.setStatics_info(map);

		session.setAttribute("userInfo", userInfo);
		return new ModelAndView("home").addObject("userInfo", userInfo);
		
	}
}
