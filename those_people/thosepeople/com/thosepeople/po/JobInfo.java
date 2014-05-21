package com.thosepeople.po;


import java.util.Date;

/**
 * 
 * @author xuyingjie
 *
 *this class is used for user publish or post a new job info
 */

public class JobInfo {

	private int id;
	private int uid;
	private String title;
	private String workplace;
	private int jobtype;
	private Date postdate;
	private String company;
	private String content;
	private String require;
	private String email;
	private String tel;
	


	public JobInfo(int uid, String title, String workplace, int jobtype,Date postdate,
			 String company, String content, String require,
			String email, String tel) {
		super();
		this.uid = uid;
		this.title = title;
		this.workplace = workplace;
		this.jobtype = jobtype;
		this.postdate = postdate;
		this.company = company;
		this.content = content;
		this.require = require;
		this.email = email;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public int getJobtype() {
		return jobtype;
	}
	public void setJobtype(int jobtype) {
		this.jobtype = jobtype;
	}
	
	public Date getPostdate() {

		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
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

	public String getRequire() {
		return require;
	}

	public void setRequire(String require) {
		this.require = require;
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

	public void setId(int id) {
		this.id = id;
	}

	public Object[] toStrArray()
	{
		return new Object[]{uid,title,workplace,jobtype,postdate,company,content,require,email,tel};
	}
}
