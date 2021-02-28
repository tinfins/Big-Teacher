package com.BigTeacher;

import java.util.Date;

/**
* The Courses class models courses data from the remote mysql database.
*
* @author  Taylor Clemons
* @version 0.1
* @since   2021-02-25
*/
public class Courses {
	private final int courseId;
	private final String name;
	private final Date startDate;
	private final Date endDate;
	private final int studentTakesId;
	private final int studentId;
	private final int professorId;
	
	/**
	* Parameterized constructor for immutable courses object includes fields from courses table columns
	*
	* @param int courseId: from courses table
	* @param String name: from courses table
	* @param Date startDate: from courses table
	* @param Date endDate: from courses table
	* @param int studentTakesId: from student_to_course table
	* @param int studentId: from student_to_course table
	* @param int professorId: from teacher_to_course table
	* @return  Nothing
	*/
	public Courses(int courseId, String name, Date startDate, Date endDate, int studentTakesId, int studentId, int professorId) {
	    this.courseId = courseId;
	    this.name = name;
	    this.startDate = startDate;
	    this.endDate = endDate;
	    this.studentTakesId = studentTakesId;
	    this.studentId = studentId;
	    this.professorId = professorId;
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
	
	public int getStudentTakesId() {
	    return this.studentTakesId;
	}
	
	public int getStudentId() {
	    return this.studentId;
	}
	
	public int getProfessorId() {
	    return this.professorId;
	}
	
	public String toString() {
	    return String.format("Course Id: %s\nCourse Name: %s\nStart Date: %s\nEnd Date: %s\nStudentTakesId: %s\nStudentId: %s\nProfessor Id: %s\n", courseId, name, startDate, endDate, studentTakesId, studentId, professorId);
	}
}