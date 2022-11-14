package edu.study.vo;

public class Student3 {

	
	private String s3name;
	private double s3math;
	private double s3kor;
	private double s3english;
	
	
	public String getS3name() {
		return s3name;
	}
	public void setS3name(String s3name) {
		this.s3name = s3name;
	}
	public double getS3math() {
		return s3math;
	}
	public void setS3math(double s3math) {
		this.s3math = s3math;
	}
	public double getS3kor() {
		return s3kor;
	}
	public void setS3kor(double s3kor) {
		this.s3kor = s3kor;
	}
	public double getS3english() {
		return s3english;
	}
	public void setS3english(double s3english) {
		this.s3english = s3english;
	}

	
	@Override
	public String toString() {
		return "Student3 [s3name=" + s3name + ", s3math=" + s3math + ", s3english=" + s3english + ", s3kor=" + s3kor
				+ "]";
	}
}
