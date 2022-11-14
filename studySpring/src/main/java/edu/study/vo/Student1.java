package edu.study.vo;

public class Student1 {

	private String s1name;
	private double s1math;
	private double s1kor;
	private double s1english;
	
	
	public String getS1name() {
		return s1name;
	}
	public void setS1name(String s1name) {
		this.s1name = s1name;
	}
	public double getS1math() {
		return s1math;
	}
	public void setS1math(double s1math) {
		this.s1math = s1math;
	}
	public double getS1kor() {
		return s1kor;
	}
	public void setS1kor(double s1kor) {
		this.s1kor = s1kor;
	}
	public double getS1english() {
		return s1english;
	}
	public void setS1english(double s1english) {
		this.s1english = s1english;
	}
	
	
	@Override
	public String toString()
	{
		return "Student1 [s1name=" + s1name + ", s1math=" + s1math + ", s1english=" + s1english + ", s1kor=" + s1kor
				+ "]";
	}
	
}
