package com.thosepeople.vo;

public class JobDetailInfo {

	private int id;
	private String nickName;
	private String headPicPath;
	private String title;
	private String workPlace;
	private String jobtype;
	private String postdate;  //发布日期
	private String company;
	private String content;
	private String requires;
	private String email;
	private String tel;
	
	private int visitCnt;
	private int i_like;
	private int commontCnt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getJobtype() {

		switch(jobtype)
		{
		case "1":
			return "实习生";
		case "2":
			return "校园招聘";
		case "3":
			return "社会招聘";
		default:
			return "";

		}
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public String getPostDate() {

		//return yyyy-mm-dd hh:MM
		return postdate.substring(0,16);
	}
	public void setPostDate(String postDate) {
		this.postdate = postDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRequires() {
		return requires;
	}
	public void setRequires(String requires) {
		this.requires = requires;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getVisitCnt() {
		return visitCnt;
	}
	public void setVisitCnt(int visitCnt) {
		this.visitCnt = visitCnt;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	public int getI_like() {
		return i_like;
	}
	public void setI_like(int i_like) {
		this.i_like = i_like;
	}
	public int getCommontCnt() {
		return commontCnt;
	}
	public void setCommontCnt(int commontCnt) {
		this.commontCnt = commontCnt;
	}

}
