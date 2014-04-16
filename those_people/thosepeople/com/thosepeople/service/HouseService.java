package com.thosepeople.service;

import java.util.List;

import com.thosepeople.vo.HouseInfo;
/**
 * @author shanchangyu
 * 
 */
public interface HouseService {
	int postHouseInfo(String title, String infoType, String houseType,String infoDescribe,
			String contactWay, int uid, String postTime);
	HouseInfo getDetailHouseInfo(int id);
	
	List<HouseInfo> getMoreInfo(String keyword,int pageNum,int pageSize);

}
