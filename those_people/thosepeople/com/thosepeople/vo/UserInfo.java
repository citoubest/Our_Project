/**
 * 
 */
package com.thosepeople.vo;

import java.util.Map;

import com.thosepeople.model.StaticsInfo;

/**
 * @author chenzhuo
 * 
 */
public class UserInfo {
	private int uid;
	private String nickName;
	private String realName;
	private String school;
	private String major;
	private String city;
	private String enrollmentDate;
	private String signature;
	private boolean gender;
	private boolean showType;
	private String headPicPath;
	private String company;

	//save the statics info. added by xuyingjie
	private Map<Integer,StaticsInfo> statics_info;
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getHeadPicPath() {
		return headPicPath;
	}

	public void setHeadPicPath(String headPicPath) {
		this.headPicPath = headPicPath;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public boolean isShowType() {
		return showType;
	}

	public void setShowType(boolean showType) {
		this.showType = showType;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(String enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Map<Integer, StaticsInfo> getStatics_info() {
		return statics_info;
	}

	public void setStatics_info(Map<Integer, StaticsInfo> statics_info) {
		this.statics_info = statics_info;
	}

}
