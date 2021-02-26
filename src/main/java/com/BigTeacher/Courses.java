package com.BigTeacher;

import java.util.Date;

/**
* The Courses class models courses data from the remote mysql database.
* @author  Taylor Clemons
* @version 0.1
* @since   2021-02-25
*/
public class Courses {
	private final int courseId;
	private final String name;
	private final Date startDate;
	private final Date endDate;
	
	/**
	* Parameterized constructor for immutable courses object includes fields from courses table columns
	* @param int courseId: course id
	* @param String name: course name
	* @param Date startDate: Start date of course
	* @param Date endDate: End date of course
	* @return  Nothing
	*/
	public Courses(int courseId, String name, Date startDate, Date endDate) {
	    this.courseId = courseId;
	    this.name = name;
	    this.startDate = startDate;
	    this.endDate = endDate;
	}
	
	public int getCourseId() {
	    return courseId;
	}
	
	public String getName() {
	    return name;
	}
	
	public Date getStartDate() {
	    return startDate;
	}
	
	public Date getEndDate() {
	    return endDate;
	}
}