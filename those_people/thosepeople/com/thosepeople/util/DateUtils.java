/**
 * 
 */
package com.thosepeople.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenzhuo
 * 
 */
public class DateUtils {
	private static final String Y_FORMAT = "yyyy";
    private static final String YMD_FORMAT="yyyy-MM-dd HH:mm:ss";
	public static Date getDateOfYMDFormat(String time) {
		SimpleDateFormat format = new SimpleDateFormat(Y_FORMAT);
		try {
			return format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getNowDateString(Date date){
		SimpleDateFormat format=new SimpleDateFormat(YMD_FORMAT);
		return format.format(date);
	}
}
