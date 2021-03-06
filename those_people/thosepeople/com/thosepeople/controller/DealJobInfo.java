package com.thosepeople.controller;

import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import com.thosepeople.constant.InfoType;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.exception.SystemException;
import com.thosepeople.model.UserStaticsInfo;
import com.thosepeople.po.JobInfo;
import com.thosepeople.service.JobService;
import com.thosepeople.service.PageService;
import com.thosepeople.vo.InfoProfile;
import com.thosepeople.vo.JobDetailInfo;
import com.thosepeople.vo.UserInfo;


/**
 * @author xuyingjie
 *
 */

@Controller
@RequestMapping("/job")
public class DealJobInfo {
	@Autowired
	@Qualifier("jobService")
	private JobService jobService;

	@Autowired
	@Qualifier("pageService")
	private PageService pageService;

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	@RequestMapping(value="/postJobInfo", method = RequestMethod.POST)
	public ModelAndView postJobInfo (
			@RequestParam("jobInfoTitle")String title,
			@RequestParam("jobCompany")String company,
			@RequestParam("workplace")String workPlace,
			@RequestParam("jobContent")String jobContent,
			@RequestParam("jobRequire")String jobRequire,
			@RequestParam("jobType")int jobType,
			@RequestParam("contactEmail")String email,
			@RequestParam("contactTel")String tel,
			@RequestParam("uid")int uid,
			HttpSession session
			)throws BusinessException
			{

		if( title==null ||title=="" 
				||company==null||company=="" 
				||workPlace==null||workPlace==""
				||jobContent==null||jobContent==""
				||jobRequire==null||jobRequire==""
				||jobType==0
				||email==null||email==""
				)
		{
			return new ModelAndView("404");
		}


		int login_id =  ((UserInfo)session.getAttribute("userInfo")).getUid();
		if(uid!=login_id)
		{
			throw new SystemException("post jobInfo fail,uid is illegal!");
		}

		JobInfo job = new JobInfo(uid,title,workPlace,jobType,new Date(),company,jobContent,jobRequire,email,tel);

		boolean flag = jobService.postJobInfo(job);

		if(flag)
		{
			return loadJobInfo();	
		}
		return new ModelAndView("404");
			}


	@RequestMapping("/showJobDetail")
	public ModelAndView showJobDetail(
			@RequestParam("j_id")int jid,HttpSession session)
	{
		JobDetailInfo detail=jobService.loadJobDetail(jid);
		 
		if(detail!=null)
		{
			//根据当前用户信息设置信息是否被点赞	
			 Map<Integer, UserStaticsInfo> map=  ((UserInfo)session.getAttribute("userInfo")).getStatics_info();
			 if(map==null)
			 {
				 map = new HashMap<Integer, UserStaticsInfo>(4);
			 }
			 UserStaticsInfo sInfo= map.get(InfoType.JOB_INFO.getValue());
			
			 if(sInfo!=null && sInfo.getLikes()!=null &&sInfo.getLikes().contains(String.valueOf(jid)))
			 {
				 detail.setLiked(true);
			 }
			 else
			 {
				 detail.setLiked(false);
			 }
			 
			 if(sInfo!=null && sInfo.getCollects()!=null && sInfo.getCollects().contains(String.valueOf(jid)))
			 {
				 detail.setCollected(true);
			 }
			 else
			 {
				 detail.setCollected(false);
			 }
			
			ModelMap modelMap=new ModelMap();
			modelMap.put("jobDetailInfo", detail);
			return new ModelAndView("job_info_detail",modelMap);
		}

		return new ModelAndView("404");

	}

	@RequestMapping("/jobInfo")
	public ModelAndView loadJobInfo()throws BusinessException
	{
		List<InfoProfile> list = pageService.getMoreInfo(null, 1, 2);
		int totalPageNum = pageService.getInfoCount(null, 2);
		ModelMap	modelMap = new ModelMap();
		modelMap.put("jobInfo", list);
		modelMap.put("currentPage", 1);
		modelMap.put("totalPageNum",totalPageNum);
		return new ModelAndView("job_info",modelMap); 
	}
}
