/**
 * 
 */
package com.thosepeople.constant;

/**
 * @author chenzhuo
 * 
 */
public enum EducationBackground {
	JUNIOR(1, "中学"), TECHNICAL(2, "中专技校"), HIGHSCHOOL(3, "高中"), COLLEGE(4, "本科"), MASTER(
			5, "硕士"), DOCTOR(6, "博士"), OTHER(7, "其他");
	private String degree;
	private int level;

	private EducationBackground(int level, String degree) {
		this.level = level;
		this.degree = degree;
	}

	public static String getDegreeByLevel(int level) {
		for (EducationBackground eb : EducationBackground.values()) {
			if (level == eb.getLevel()) {
				return eb.getDegree();
			}
		}
		return null;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}

}
