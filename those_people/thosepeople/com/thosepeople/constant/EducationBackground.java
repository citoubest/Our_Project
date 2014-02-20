/**
 * 
 */
package com.thosepeople.constant;

/**
 * @author chenzhuo
 * 
 */
public enum EducationBackground {
	JUNIOR(1, "��ѧ"), TECHNICAL(2, "��ר��У"), HIGHSCHOOL(3, "����"), COLLEGE(4, "����"), MASTER(
			5, "˶ʿ"), DOCTOR(6, "��ʿ"), OTHER(7, "����");
	private String degree;
	private int level;

	private EducationBackground(int level, String degree) {
		this.level = level;
		this.degree = degree;
	}

	public String getDegreeByLevel(int level) {
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
