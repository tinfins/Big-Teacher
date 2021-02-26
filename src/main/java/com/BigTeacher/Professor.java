package com.BigTeacher;

/**
* The Professor class models professor data from the remote mysql database.
* courseName is derived from SQL join query of professor, teacher_to_course, and course tables in remote database
	* @author  Taylor Clemons
    * @version 0.1
    * @since   2021-02-25
	*/
public class Professor {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final String email;
    private final String courseName;
    
    /**
	* Parameterized constructor for immutable professor object includes fields from professor table columns
	* @param int id - professor id
	* @param String lastName: Professor last name
	* @param String firstName: Professor first name
	* @param String email: Professor email
	* @param String courseName: Course name from courses table.
	* @return Nothing
	*/
    public Professor(int id, String lastName, String firstName, String email, String courseName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.courseName = courseName;
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
    
    public String getCourseName() {
        return courseName;
    }
    
    public String toString() {
        return "Id: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nEmail" + email + "\nCourse: " + courseName + "\n";
    }
}
    