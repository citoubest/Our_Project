package com.thosepeople.vo;

/**
 * @author shanchangyu
 * 
 */
public class HouseInfo {
	private int id;
	private String title;
	private String infoType;
	private String houseType;
	private String infoDescribe;
	private String picturePath;
	private String contactWay;
	private int uid;
	private String postTime;
	private String nickName;
	private String headPicPath;
	private int visitCnt;
	public int getVisitCnt() {
		return visitCnt;
	}
	public void setVisitCnt(int visitCnt) {
		this.visitCnt = visitCnt;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadPicPath() {
		return headPicPath;
	}
	public void setHeadPicPath(String headPicPath) {
		this.headPicPath = headPicPath;
	}
	public String getHouseType() {
		switch(houseType)
		{
		case "1":
			return "不限";
		case "2":
			return "普通住房";
		case "3":
			return "商住两用";
		case "4":
			return "公寓";
		case "5":
			return "别墅";
		case "6":
			return "其他";
		default:
			return "";
		}
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfoType() {
		switch(infoType)
		{
		case "1":
			return "出租信息";
		case "2":
			return "求租信息";
		default:
			return "";
		}
	}
	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}
	public String getInfoDescribe() {
		return infoDescribe;
	}
	public void setInfoDescribe(String infoDescribe) {
		this.infoDescribe = infoDescribe;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getContactWay() {
		return contactWay;
	}
	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

}
