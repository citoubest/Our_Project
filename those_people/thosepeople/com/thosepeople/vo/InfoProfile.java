package com.thosepeople.vo;

public class InfoProfile {

	
	private int id;
	private String nickName;
	private String headPicPath;
	private String title;
	private String postdate;  //发布日期
	private int visit_count;   //访问次数
	private String content;   //主区域显示的内容
	
	//for job info
	private String workPlace;
	private String jobtype;
	private String company;	
	
	//for love
	
	//for statics
	private int likes;  //赞的数量
	private int comments; //评论数量
	private int visits;
	
	//for house
	
	//for activity

	
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

	public String getPostDate() {

		//return yyyy-mm-dd hh:MM
		return postdate.substring(0,16);
	}

	public void setPostDate(String postDate) {
		this.postdate = postDate;
	}

	public int getVisit_count() {
		return visit_count;
	}

	public void setVisit_count(int visit_count) {
		this.visit_count = visit_count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPostdate() {
		return postdate;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
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

}
