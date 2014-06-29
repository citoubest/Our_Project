package com.thosepeople.po;

import java.util.Date;

public class ArticleInfo {

	
	private int id;
	private int uid;
	private String content;
	private Date postdate;
	
	
	
	public ArticleInfo(int uid, String content) {
		super();
		this.uid = uid;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	
	
}
