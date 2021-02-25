package com.BigTeacher;

public class Professor {
    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private String courseName;
    
    public Professor() {}
    
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
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public String toString() {
        return "Id: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nEmail" + email + "\nCourse: " + courseName + "\n";
    }
}
    