package com.thosepeople.vo;

/**
 * 
 * @author xuyingjie
 *
 *this class is used for job detail info
 */

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
	
	
	//contain the statistic info
	private int visits;
	private int likes;
	private int commonts;
	private int collects;
	
	//if the user has liked or collect this info, the flag is true
	private boolean isLiked;
	private boolean isCollected;
	
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
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getCommonts() {
		return commonts;
	}
	public void setCommonts(int commonts) {
		this.commonts = commonts;
	}
	public int getCollects() {
		return collects;
	}
	public void setCollects(int collects) {
		this.collects = collects;
	}
	public boolean isLiked() {
		return isLiked;
	}
	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}
	public boolean isCollected() {
		return isCollected;
	}
	public void setCollected(boolean isCollected) {
		this.isCollected = isCollected;
	}
	
	public boolean getIsCollected()
	{
		return this.isCollected;
	}
	
	public boolean getIsLiked()
	{
		return this.isLiked;
	}
}
