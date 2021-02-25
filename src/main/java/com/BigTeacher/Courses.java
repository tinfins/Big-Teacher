package com.BigTeacher;

import java.util.Date;

public class Courses {
	private int courseId;
	private String name;
	private Date startDate;
	private Date endDate;
	
	public Courses() {}
	
	public Courses(int courseId, String name, Date startDate, Date endDate) {
	    this.courseId = courseId;
	    this.name = name;
	    this.startDate = startDate;
	    this.endDate = endDate;
	}
	
	public int getCourseId() {
	    return courseId;
	}
	
	public void setCourseId(int courseId) {
	    this.courseId = courseId;
	}
	
	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public Date getStartDate() {
	    return startDate;
	}
	
	public void setStartDate(Date startDate) {
	    this.startDate = startDate;
	}
	
	public Date getEndDate() {
	    return endDate;
	}
	
	public void setEndDate(Date endDate) {
	    this.endDate = endDate;
	}
}