package com.thosepeople.controller;

import java.util.HashMap;
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
import com.thosepeople.service.PageService;
import com.thosepeople.vo.InfoProfile;

@Controller
@RequestMapping("/page")
public class Page {

	@Autowired
	@Qualifier("pageService")
	private PageService pageService;

	@RequestMapping("/moreInfo")
	@ResponseBody
	public Map<String, Object> loadMoreJobInfo(
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "currentPage", required = false) Integer currentPage,
			@RequestParam("infoType") int infoType, HttpSession session)
			throws BusinessException {

		if (infoType < 0 || infoType > 4) {
			throw new BusinessException("The infoType is wrong!");
		}
		int nextPageNum;
		// currentPage==null 或者currentPage==1，说明第一次加载信息，这时要先计算一下总页数，并存储到session中
		if (currentPage == null || currentPage == 1) {
			nextPageNum = 1;
			int totalPageNum = pageService.getInfoCount(null, infoType);
			session.setAttribute("totalPageNum", totalPageNum);
		}

		nextPageNum = currentPage + 1;

		// 获取总页数信息
		Integer totalPageNum = (Integer) session.getAttribute("totalPageNum");
		if (totalPageNum == null) {
			totalPageNum = pageService.getInfoCount(null, infoType);
			session.setAttribute("totalPageNum", totalPageNum);
		}

		// 如果当前页码已经超过总页码，直接返回
		if (nextPageNum > totalPageNum) {
			Map<String, Object> modelMap = new HashMap<String, Object>(1);
			modelMap.put("success", "false");
			return modelMap;
		}

		List<InfoProfile> list = pageService.getMoreInfo(keyword, nextPageNum,
				infoType);
		// 获取信息失败，返回
		if (list == null || list.size() == 0) {
			Map<String, Object> modelMap = new HashMap<String, Object>(1);
			modelMap.put("success", "false");
			return modelMap;

		} else {
			Map<String, Object> modelMap = new HashMap<String, Object>(3);
			modelMap.put("currentPage", nextPageNum);
			modelMap.put("totalPageNum", totalPageNum);
			modelMap.put("data", list);
			modelMap.put("success", "true");
			return modelMap;
		}
	}
}
