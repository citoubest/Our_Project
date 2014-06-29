package com.thosepeople.controller;

import java.io.File;
import java.io.IOException;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.thosepeople.exception.BusinessException;


@Controller
@RequestMapping("/article")
public class PostArticle {

	
	 private static final String IMGURL_REG= "<img\\b[^>]*?\\bsrc[\\s]*=[\\s]*[\"\']?[\\s]*(?<imgUrl>[^\"\'>]*)[^>]*?/?[\\s]*>";
//	 private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";  
	@RequestMapping("/postArticle")
	@ResponseBody
	public String postArticle(
			@RequestParam(value = "title") String title,
			@RequestParam(value = "content") String content)throws BusinessException 
			{

		//1.将临时文件拷贝到对应目录下，按照时间创建目录 ： article/year/month
	    
		
		 Matcher matcher = Pattern.compile(IMGURL_REG).matcher(content);  
	        List<String> listImgUrl = new ArrayList<String>();  
	        while (matcher.find()) {  
	            listImgUrl.add(matcher.group());  
	        }  
		List<String> listImgSrc = new ArrayList<String>();
	        
	        for (String image : listImgUrl) {  
	          matcher = Pattern.compile(IMGURL_REG).matcher(image);  
	            while (matcher.find())
	            {  
	                listImgSrc.add(matcher.group().substring(0, matcher.group().length() - 1));  
	            }  

	        } 

	        for (String string : listImgSrc) {
				System.out.println(string);
			}
		
		//2.插入到数据库
		
		return "Success";
	}

	
	//上传到临时文件
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(HttpServletRequest request)
	{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		String pathDir = "/upload/article/temp/";
		/**得到图片保存目录的真实路径**/    
		String logoRealPathDir = request.getSession().getServletContext().getRealPath(pathDir);   
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
		return pathDir+name;
	}



}
