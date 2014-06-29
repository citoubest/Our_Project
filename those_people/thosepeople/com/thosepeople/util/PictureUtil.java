/**
 * 
 */
package com.thosepeople.util;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.fileupload.FileItem;

/**
 * @author chenzhuo
 * 
 */
public class PictureUtil {
	private final static String IMAGE_FORMAT_OF_JPG = "jpg";
	private final static String IMAGE_FORMAT_OF_PNG = "png";
	private final static String IMAGE_FORMAT_OF_GIF="gif";
	public static String saveTmpImg(FileItem fileItem, String suffix,
			String uid, String serverPath) {
		String name = String.valueOf(System.currentTimeMillis() + "_" + uid);
		StringBuffer sourcePath = new StringBuffer();
		sourcePath.append(serverPath);
		sourcePath.append(File.separator);
		sourcePath.append("uploadtmp");
		sourcePath.append(File.separator);
		sourcePath.append(name);
		sourcePath.append(suffix);
		File imageFile = new File(sourcePath.toString());
		if (!imageFile.getParentFile().exists()) {
			imageFile.getParentFile().mkdirs();
		}
		try {
			fileItem.write(imageFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourcePath.toString();
	}

	public static void cutImage(String sourcePath, String targetPath,String suffix, int x,
			int y, int width, int height) throws IOException {
		FileInputStream is = null;
		ImageInputStream iis = null;
		try {
			is = new FileInputStream(sourcePath);
			Iterator<ImageReader> it = getImageReadersByFormatName(suffix);
			ImageReader reader = it.next();
			iis = ImageIO.createImageInputStream(is);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rect = new Rectangle(x, y, width, height);
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			ImageIO.write(bi, suffix,new File(targetPath));
		} finally {
			if (is != null)
				is.close();
			if (iis != null)
				iis.close();
		}
	}
	public static String getSuffix(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}

	
	public static List<String> getImgStr(String htmlStr){     
	     String img="";     
	     Pattern p_image;     
	     Matcher m_image;     
	     List<String> pics = new ArrayList<String>();  
	  
	     String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址     
	     p_image = Pattern.compile   
	             (regEx_img,Pattern.CASE_INSENSITIVE);     
	    m_image = p_image.matcher(htmlStr);   
	    while(m_image.find()){     
	         img = img + "," + m_image.group();     
	         Matcher m  = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //匹配src  
	         while(m.find()){  
	            pics.add(m.group(1));  
	         }  
	     }     
	        return pics;     
	 }    
	public static String getTargetPath(String suffix, String fileName,
			String serverPath, String savePath) {
		StringBuffer targetPath = new StringBuffer();
		targetPath.append(serverPath);
		targetPath.append(File.separator);
		targetPath.append(savePath);
		targetPath.append(File.separator);
		targetPath.append(fileName);
		targetPath.append(suffix);
		return targetPath.toString();
	}
	private static Iterator<ImageReader> getImageReadersByFormatName(
			String suffix) {
		switch (suffix) {
		case IMAGE_FORMAT_OF_JPG:
			return ImageIO.getImageReadersByFormatName(IMAGE_FORMAT_OF_JPG);
		case IMAGE_FORMAT_OF_PNG:
			return ImageIO.getImageReadersByFormatName(IMAGE_FORMAT_OF_PNG);
		case IMAGE_FORMAT_OF_GIF:
			return ImageIO.getImageReadersByFormatName(IMAGE_FORMAT_OF_GIF);
		default:
			return ImageIO.getImageReadersByFormatName(IMAGE_FORMAT_OF_JPG);
		}
	}
}
