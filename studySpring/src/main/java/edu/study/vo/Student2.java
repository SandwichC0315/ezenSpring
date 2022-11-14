package edu.study.vo;

public class Student2 {

	private String s2name;
	private double s2math;
	private double s2kor;
	private double s2english;
	
	
	public String getS2name() {
		return s2name;
	}
	public void setS2name(String s2name) {
		this.s2name = s2name;
	}
	public double getS2math() {
		return s2math;
	}
	public void setS2math(double s2math) {
		this.s2math = s2math;
	}
	public double getS2kor() {
		return s2kor;
	}
	public void setS2kor(double s2kor) {
		this.s2kor = s2kor;
	}
	public double getS2english() {
		return s2english;
	}
	public void setS2english(double s2english) {
		this.s2english = s2english;
	}
	
	@Override
	public String toString() {
		return "Student2 [s2name=" + s2name + ", s2math=" + s2math + ", s2english=" + s2english + ", s2kor=" + s2kor
				+ "]";
	}

}
