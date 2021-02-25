package com.BigTeacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.text.WordUtils;

public class SqlHandler {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static String DB_URL;
	private ArrayList<Professor> profList = new ArrayList<>();
    private String USER;
    private String PASS;

    public SqlHandler(Properties props, String username, String password) {
        this.USER = username;
        this.PASS = password;
        String db_url = String.format("jdbc:mysql://%s/%s", props.getProperty("host"), props.getProperty("database"));
        DB_URL = db_url;
        System.out.println(DB_URL);
    }
    
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
    
    public String getName(String username) {
        username = username.substring(1);
        return WordUtils.capitalize(username);
    }
    
    public ArrayList professorQuery(Connection conn) {
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
    
    public Boolean Logout(ResultSet rs, Connection conn) {
        try {
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}