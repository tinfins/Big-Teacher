package com.BigTeacher;

/**
* The Student class models student data from remote mysql database.
*
* @author  Taylor Clemons
* @version 0.1
* @since   2021-02-25
*/
public class Student {
	private final int id;
	private final String lastName;
	private final String firstName;
	private final int studentTakesId;
	private final int courseId;
	
	/**
	* Parameterized constructor for immutable student object includes fields from students table columns
	*
	* @param int id: from students table
	* @param String lastName: from students table
	* @param String firstName: from students table
	* @param int studentTakesId: from student_to_course table
	* @param int courseId: from student_to_course table
	* @return Nothing
	*/
	public Student(int id, String lastName, String firstName, int studentTakesId, int courseId) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.studentTakesId = studentTakesId;
		this.courseId = courseId;
	}
	
	public int getId() {
	    return this.id;
	}
	
	public String getLastName() {
	    return this.lastName;
	}
	
	public String getFirstName() {
	    return this.firstName;
	}
	
	public int getStudentTakesId() {
	    return this.studentTakesId;
	}
	
	public int getCourseId() {
	    return this.courseId;
	}
	
	public String toString() {
        return "Id: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nStudent Takes Id" + studentTakesId + "\nCourseId: " + String.valueOf(courseId) + "\n";
    }
}