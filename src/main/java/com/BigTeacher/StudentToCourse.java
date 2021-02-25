package com.BigTeacher;

public class StudentToCourse {
	private int studentTakesId;
	private int studentId;
	private int courseId;
	
	public StudentToCourse() {}
	
	public StudentToCourse(int studentTakesId, int studentId, int courseId) {
	    this.studentTakesId = studentTakesId;
	    this.studentId = studentId;
	    this.courseId = courseId;
	}
	
	public int getStudentTakesId() {
	    return studentTakesId;
	}
	
	public void setStudentTakesId(int studentTakesId) {
	    this.studentTakesId = studentTakesId;
	}
	
	public int getStudentId() {
	    return studentId;
	}
	
	public void setStudentId(int studentId) {
	    this.studentId = studentId;
	}
	
	public int getCourseId() {
	    return courseId;
	}
	
	public void setCourseId(int courseId) {
	    this.courseId = courseId;
	}
}