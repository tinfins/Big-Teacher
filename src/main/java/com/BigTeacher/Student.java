package com.BigTeacher;

/**
* The Student class models student data from remote mysql database.
* @author  Taylor Clemons
* @version 0.1
* @since   2021-02-25
*/
public class Student {
	private final int id;
	private final String firstName;
	private final String lastName;
	
	/**
	* Parameterized constructor for immutable student object includes fields from students table columns
	* @param int id: student id
	* @param String firstName: student first name
	* @param String lastName: student last name
	* @return Nothing
	*/
	public Student(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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
}