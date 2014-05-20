package com.thosepeople.model;

import java.util.Arrays;
import java.util.List;

public class StaticsInfo {

	private int infotype;
	private String visits;
	private String likes;
	private String collects;
	private String comments;

	public int getInfotype() {
		return infotype;
	}
	public void setInfotype(int infotype) {
		this.infotype = infotype;
	}
	public String getVisits() {
		return visits;
	}
	public void setVisits(String visits) {
		this.visits = visits;
	}
	public List<String> getLikes() {
		String old[] =likes.split(",");
		List<String>list = Arrays.asList(old);
		return list;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public List<String> getCollects() {
		String old[] =collects.split(",");
		List<String>list = Arrays.asList(old);
		return list;
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
