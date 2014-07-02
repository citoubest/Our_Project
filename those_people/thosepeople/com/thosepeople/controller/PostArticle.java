package com.thosepeople.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

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
import com.thosepeople.po.ArticleInfo;
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

	@RequestMapping("/postArticle")
	@ResponseBody
	public String postArticle(
			@RequestParam(value = "title") String title,
			@RequestParam(value = "content") String content,
			HttpSession session,HttpServletRequest request)throws BusinessException			
			{

//		int uid =  ((UserInfo)session.getAttribute("userInfo")).getUid();

		String destDir = request.getSession().getServletContext().getRealPath(imgDir);  
		String tempDir = request.getSession().getServletContext().getRealPath(tempPathDir);  
		
		//1.查找content中的img
		List<String> tempFile = PictureUtil.getImgStr(content);

		//2.拷贝文件,替换content中的图片路径
		String curPath="/"+Calendar.YEAR+"/"+Calendar.MONTH;
		File fnewpath = new File(destDir+curPath);

		if(!fnewpath.exists())
		{
			fnewpath.mkdirs();
		}	

		for (String oldFname : tempFile)
		{
			System.out.println(oldFname);
			File fold = new File(tempDir+"\\"+oldFname.subSequence(oldFname.lastIndexOf("/"), oldFname.length()));
			String newFname = fnewpath+"\\"+fold.getName();
			File fnew = new File(newFname);
			content.replaceFirst(oldFname,newFname );
			boolean flag = fold.renameTo(fnew);
			System.out.println(flag);
		}
		//3.插入到数据库
		boolean flag =  articleService.postArticle(new ArticleInfo(1,content));

		if(flag == true)
		{
			return "Success";
		}else
		{
			return "error";
		}
	}

	//上传到临时文件
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartHttpServletRequest request)
	{
		Iterator<String> itr =  request.getFileNames();
	     MultipartFile mpf = request.getFile(itr.next());
	
	     String tempDir = request.getSession().getServletContext().getRealPath(tempPathDir);  
	     try {
	    	InputStream stream =mpf.getInputStream();
	      
	    	String suffix = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf(".")); 
	
			/**拼成完整的文件保存路径加文件**/    
			String name =System.currentTimeMillis()+suffix;
			String fileName = tempDir + File.separator+name;  
	    	FileOutputStream fs=new FileOutputStream(fileName);
	        byte[] buffer =new byte[1024*1024];
	        int byteread = 0; 
	        while ((byteread=stream.read(buffer))!=-1)
	        {
	           fs.write(buffer,0,byteread);
	           fs.flush();
	        } 
	        fs.close();
	        stream.close();
		     return tempPathDir+name;
	    } catch (IOException e){
	        e.printStackTrace();
	        return "uploadError";
	    }
	}
}
