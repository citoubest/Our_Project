package com.thosepeople.model;

/**
 * 
 * @author xuyingjie
 *	
 *this class contain the statictics info for a user
 */

public class UserStaticsInfo {
	private int infotype;

	private String likes;
	private String collects;
	private String comments;

	public int getInfotype() {
		return infotype;
	}
	public void setInfotype(int infotype) {
		this.infotype = infotype;
	}
	
	public String getLikes() {
		
		if(likes==null)
		{
			likes="";
		}
		return this.likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public String getCollects() {
		if(collects==null)
		{
			collects="";
		}
		return this.collects;
	}
	public void setCollects(String collects) {
		this.collects = collects;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}


}
