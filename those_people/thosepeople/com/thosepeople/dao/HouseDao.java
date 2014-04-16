package com.thosepeople.dao;

import java.util.List;

import com.thosepeople.vo.HouseInfo;



/**
 * @author shanchangyu
 * 
 */
public interface HouseDao {
	public int postHouseInfo(String title, String infoType, String houseType,String infoDescribe,
			String contactWay, int uid, String postTime);
	public HouseInfo getDetailHouseInfo(int infoId);
	List<HouseInfo> getMoreInfo(String keyword, int pageNum,int pageSize);

}
