package com.BigTeacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.text.WordUtils;

/**
* The SqlHandler utilizes the java.sql module and Jdbc to connect to remote mysql database and perform various sql commands.
*
* @author  Taylor Clemons
* @version 0.1
* @since   2021-02-25
*/
public class SqlHandler {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static String DB_URL;
    private String USER;
    private String PASS;
    
    /**
	* Parameterized constructor for SqlHandler class to create Jdbc connection.
	*
	* @see {@link com.BigTeacher.SettingsHandler}
	* @param Properties props: Properties object containing values from properties file
	* @param String username: username input
	* @param String password: password input
	* @return Nothing
	*/
    public SqlHandler(Properties props, String username, String password) {
        this.USER = username;
        this.PASS = password;
        String db_url = String.format("jdbc:mysql://%s/%s", props.getProperty("host"), props.getProperty("database"));
        DB_URL = db_url;
        System.out.println(DB_URL);
    }
    
    /**
	* Login method to create Jdbc connection and test valid credentials for login to remote database.
	*
	* @param static DB_URL: String for Jdbc connection
	* @param this.USER: username variable set by constructor
	" @param tbis.PASS: lassword variable set by constructor
	* @return Connection conn: Jdbc connection
	*/
    public Connection Login() {
        Connection conn = null;
        System.out.println("Connecting to database...");
        try {
            System.out.println(DB_URL);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Login successful!");
        } catch (SQLException e) {
            // Convert to logger
            e.printStackTrace();
        }
        // Convert to logger
        return conn;
    }
    
    /**
	* getName method to create substring of professor last name based on username.
	*
	* @param String username: username 
	* @return String lastName: Sentence-case last name
	*/
    public String getLastName(String username) {
        username = username.substring(1);
        return WordUtils.capitalize(username);
    }
    
    /**
	* professorQuery method to execute SQL join query on professor, and teacher_to_course
	*
	* @param Connection conn: Jdbc connection
	* @param String profLastName: from getLastName
	* @return ArrayList<Professor> profList: ArrayList of Professor objects
	*/
    public List<Professor> professorQuery(Connection conn, String profLastName) {
        List<Professor> profList = new ArrayList<>();
        String sql = null;
        sql = "SELECT p.professor_id, p.last_name, p.first_name, p.email, ttc.course_id \n FROM professors p \n JOIN teacher_to_course ttc \n ON \n ttc.professor_id = p.professor_id WHERE p.last_name = ?;";
        try {
            PreparedStatement prepStmt;
            prepStmt = conn.prepareStatement(sql);
		    prepStmt.setString(1, profLastName);
            ResultSet rs = prepStmt.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                Professor prof = new Professor(rs.getInt("professor_id"), rs.getString("last_name"), rs.getString("first_name"), rs.getString("email"), rs.getInt("course_id"));
                profList.add(prof);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        //return profList;
		return profList;
    }
    
    /**
	* studentQuery method to execute SQL join query on student, and student_to_course
	*
	* @param Connection conn: Jdbc connection
	* @param int courseId: from Professor object
	* @return List<Professor> studentList: List of Student objects
	*/
    public List<Student> studentQuery(Connection conn, int courseId) {
        List<Student> studentList = new ArrayList<>();
        String stringCourseId = String.valueOf(courseId);
        String sql;
        sql = "SELECT s.student_id, s.last_name, s.first_name, stc.student_takes_id, stc.course_id \n FROM students s \n JOIN student_to_course stc \n ON \n stc.student_id = s.student_id WHERE stc.course_id = ?";
         try {
            PreparedStatement prepStmt;
            prepStmt = conn.prepareStatement(sql);
		    prepStmt.setString(1, stringCourseId);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getInt("student_id"), rs.getString("last_name"), rs.getString("first_name"), rs.getInt("student_takes_id"), rs.getInt("course_id"));
                studentList.add(student);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }
    
     /**
	* courseQuery method to execute SQL join query on course, teacher_to_course, and student_to_course
	*
	* @param Connection conn: Jdbc connection
	* @param int professorId: from Professor object
	* @return List<Courses> courseList: List of Courses objects
	*/
    public List<Courses> coursesQuery(Connection conn, int professorId) {
        List<Courses> coursesList = new ArrayList<>();
        String stringProfessorId = String.valueOf(professorId);
        String sql;
        sql = "SELECT c.course_id, c.name AS course_name, c.start_date, c.end_date, stc.student_takes_id, stc.student_id, ttc.professor_id \n FROM courses c \n JOIN student_to_course stc \n ON \n stc.course_id = c.course_id \n JOIN teacher_to_course ttc \n ON \n ttc.course_id = c.course_id WHERE ttc.professor_id = ?";
         try {
            PreparedStatement prepStmt;
            prepStmt = conn.prepareStatement(sql);
		    prepStmt.setString(1, stringProfessorId);
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Courses course = new Courses(rs.getInt("course_id"), rs.getString("course_name"), rs.getDate("start_date"), rs.getDate("end_date"), rs.getInt("student_takes_id"), rs.getInt("student_id"), rs.getInt("professor_id"));
                coursesList.add(course);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return coursesList;
    }
    
    
    /**
	* Logout method to logout of app and destroy instantiated objects
	*
	* @param Connection conn: Jdbc connection
	* @return Boolean false: if connection destroyed, return false
	*/
    public Boolean Logout(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}