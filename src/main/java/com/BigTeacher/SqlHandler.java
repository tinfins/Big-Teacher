package com.BigTeacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.commons.text.WordUtils;

/**
* The SqlHandler utilizes the java.sql module and Jdbc to connect to remote mysql database and perform various sql commands.
* @author  Taylor Clemons
* @version 0.1
* @since   2021-02-25
*/
public class SqlHandler {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static String DB_URL;
	private ArrayList<Professor> profList = new ArrayList<>();
    private String USER;
    private String PASS;
    
    /**
	* Parameterized constructor for SqlHandler class to create Jdbc connection.
	* @param Properties props: Properties object containing values from properties file
	* @see {@link com.BigTeacher.SettingsHandler}
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
	* @param String username: username 
	* @return String lastName: Sentence-case last name
	*/
    public String getName(String username) {
        username = username.substring(1);
        return WordUtils.capitalize(username);
    }
    
    /**
	* professorQuery method to execute SQL join query on professor, teacher_to_course, and course tables
	* @param Connection conn: Jdbc connection
	* @return ArrayList<Professor> profList: ArrayList of Professor objects
	*/
    public ArrayList<Professor> professorQuery(Connection conn) {
        String sql;
        sql = "SELECT p.professor_id, p.last_name, p.first_name, p.email, c.name AS course_name \n FROM professors p \n JOIN teacher_to_course ttc \n ON \n ttc.professor_id = p.professor_id \n JOIN courses c \n ON \n ttc.course_id = c.course_id";
        try (
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                Professor prof = new Professor(rs.getInt("professor_id"), rs.getString("last_name"), rs.getString("first_name"), rs.getString("email"), rs.getString("course_name"));
                profList.add(prof);
                
                System.out.println("Professor: " + prof.getFirstName() + " " + prof.getLastName() + "\n");
                System.out.println("Course: " + prof.getCourseName() + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profList;
    }
    
    /**
	* Logout method to logout of app and destroy instantiated objects
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