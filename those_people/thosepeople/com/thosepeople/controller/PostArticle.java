package com.thosepeople.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.service.ArticleService;
import com.thosepeople.util.PictureUtil;

@Controller
@RequestMapping("/article")
public class PostArticle {

	private static String tempPathDir = "/upload/article/temp/";
	private static String imgDir = "/upload/article/";
	@Autowired
	ArticleService articleService;
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}


	private static final String IMGURL_REG= "<img\\b[^>]*?\\bsrc[\\s]*=[\\s]*[\"\']?[\\s]*(?<imgUrl>[^\"\'>]*)[^>]*?/?[\\s]*>";
	//	 private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";  
	@RequestMapping("/postArticle")
	@ResponseBody
	public String postArticle(
			@RequestParam(value = "title") String title,
			@RequestParam(value = "content") String content,
			HttpSession session,HttpServletRequest request)throws BusinessException			
			{

	//	int uid =  ((UserInfo)session.getAttribute("userInfo")).getUid();

		String parentDir = request.getSession().getServletContext().getRealPath(imgDir);  
		
		//1.查找content中的img
		List<String> tempFile = PictureUtil.getImgStr(content);

		//2.拷贝文件,替换content中的图片路径
		
		Date date = new Date();
		String curPath="/"+date.getYear()+"/"+date.getMonth()+"/";
		File fnewpath = new File(parentDir+curPath);

		if(!fnewpath.exists())
		{
			fnewpath.mkdirs();
		}	

		for (String oldFname : tempFile) {
			File fold = new File(oldFname);
			String newFname = fnewpath+fold.getName();
			File fnew = new File(newFname);
			content.replaceFirst(oldFname,newFname );
			fold.renameTo(fnew);
		}
		//3.插入到数据库
//		boolean flag =  articleService.postArticle(new ArticleInfo(1,content));
//
//		if(flag == true)
//		{
//			return "Success";
//		}else
//		{
//			return "error";
//		}
		return "Success";
	}


	//上传到临时文件
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(HttpServletRequest request)
	{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		/**得到图片保存目录的真实路径**/    
		String logoRealPathDir = request.getSession().getServletContext().getRealPath(tempPathDir);   
		/**根据真实路径创建目录**/    
		File logoSaveFile = new File(logoRealPathDir);     
		if(!logoSaveFile.exists())     
			logoSaveFile.mkdirs();           
		/**页面控件的文件流**/    
		MultipartFile multipartFile = multipartRequest.getFile("fileupload"); 
		/**获取文件的后缀**/    
		System.out.println(multipartFile.getOriginalFilename());
		String suffix = multipartFile.getOriginalFilename().substring  
				(multipartFile.getOriginalFilename().lastIndexOf(".")); 

		/**拼成完整的文件保存路径加文件**/    
		String name = +  System.currentTimeMillis()+suffix;
		String fileName = logoRealPathDir + File.separator+name;    
		File file = new File(fileName); 

		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return tempPathDir+name;
	}



}
