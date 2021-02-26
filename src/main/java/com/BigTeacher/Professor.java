package com.BigTeacher;

/**
* The Professor class models professor data from the remote mysql database.
* courseName is derived from SQL join query of professor, and teacher_to_course tables in remote database
*
* @author  Taylor Clemons
* @version 0.1
* @since   2021-02-25
*/
public class Professor {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final String email;
    private final int courseId;
    
    /**
	* Parameterized constructor for immutable professor object includes fields from professor table columns
	*
	* @param int id: from professors table
	* @param String lastName: from professors tavle
	* @param String firstName: from professors table
	* @param String email: from professors tae
	* @param String courseId: from teacher_to_course table
	* @return Nothing
	*/
    public Professor(int id, String lastName, String firstName, String email, int courseId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.courseId = courseId;
    }
    
    public int getId() {
        return id;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public int getCourseId() {
        return courseId;
    }
    
    public String toString() {
        return "Id: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nEmail" + email + "\nCourseId: " + String.valueOf(courseId) + "\n";
    }
}
    