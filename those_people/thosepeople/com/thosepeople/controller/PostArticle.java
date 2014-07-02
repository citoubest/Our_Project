package com.thosepeople.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
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
		
		Date date = new Date();
		String curPath="/"+date.getYear()+"/"+date.getMonth();
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
	@SuppressWarnings("deprecation")
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartHttpServletRequest request)
	{
		
		
		Iterator<String> itr =  request.getFileNames();
		 
	     MultipartFile mpf = request.getFile(itr.next());
	     System.out.println(mpf.getOriginalFilename() +" uploaded!");
	   
	     try {
	                //just temporary save file info into ufile
	       System.out.println( mpf.getBytes().length);
	      System.out.println( mpf.getBytes());
	      System.out.println(   mpf.getContentType());
	      System.out.println( mpf.getOriginalFilename());
	 
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	 
	     //2. send it back to the client as <img> that calls get method
	     //we are using getTimeInMillis to avoid server cached image 
	 
	     return "http://www.baidu.com/img/baidu_sylogo1.gif";
		
		
		
	}
//		DiskFileUpload disFileUpload = new DiskFileUpload();
//	
//		 try
//		 {
//		List<FileItem> list = disFileUpload.parseRequest(request);
//		 File file1=null;
//	
//			for(FileItem fileItem:list)
//			{
//				if(fileItem.isFormField())
//				{
//					
//				}else{
//					if("fileAddPic".equals(fileItem.getFieldName())){
//						File remoteFile = new File(new String(fileItem.getName().getBytes(),"UTF-8"));
//						System.out.println("开始遍历.....");
//
//						System.out.println(fileItem.getContentType()+"----"+remoteFile.getName()+fileItem.getName());
//
//						String logoRealPathDir = request.getSession().getServletContext().getRealPath(tempPathDir);   
//						file1 = new File(logoRealPathDir,remoteFile.getName());
//						file1.getParentFile().mkdirs();
//						file1.createNewFile();
//						
//						InputStream ins = fileItem.getInputStream();
//						
//						OutputStream ous = new FileOutputStream(file1);
//						try{
//							byte[] buffer = new byte[1024];
//							int len=0;
//							while((len=ins.read(buffer))>-1){
//								ous.write(buffer, 0, len);
//							}
//							return "url";
//						}finally{
//							ous.close();
//							ins.close();
//						}
//					}
//				}
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			return "fileuploaderror";
//		}
//		return "last";
//	}
		
//		System.out.println();
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//
//		/**得到图片保存目录的真实路径**/    
//		
//		/**根据真实路径创建目录**/    
//		File logoSaveFile = new File(logoRealPathDir);     
//		if(!logoSaveFile.exists())     
//			logoSaveFile.mkdirs();           
//		/**页面控件的文件流**/    
//		MultipartFile multipartFile = multipartRequest.getFile("fileupload"); 
//		/**获取文件的后缀**/    
//		System.out.println(multipartFile.getOriginalFilename());
//		String suffix = multipartFile.getOriginalFilename().substring  
//				(multipartFile.getOriginalFilename().lastIndexOf(".")); 
//
//		/**拼成完整的文件保存路径加文件**/    
//		String name = +  System.currentTimeMillis()+suffix;
//		String fileName = logoRealPathDir + File.separator+name;    
//		File file = new File(fileName); 
//
//		try {
//			multipartFile.transferTo(file);
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
//		return tempPathDir+name;
//	}



}
