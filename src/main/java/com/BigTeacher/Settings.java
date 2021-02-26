package com.BigTeacher;

/**
* The Settings class models settings data from the properties file
* @author  Taylor Clemons
* @version 0.1
* @since   2021-02-25
*/
public class Settings {
	private String host;
	private String port;
	private String db;
	
	public Settings() {
	}
	
	/**
	* Parameterized constructor for settings class includes values from properties file or values intended to be written to properties file.
	* @param String host: host name for Jdbc
	* @param String port: port num for Jdbc
	* @param String db: database name for Jdbc
	* @return Nothing
	*/
	public Settings(String host, String port, String db) {
		this.host = host;
		this.port = port;
		this.db = db;
	}
	
	public String getHost() {
	    return host;
	}
	
	public void setHost(String host) {
	    this.host = host;
	}
	
	public String getPort() {
	    return host;
	}
	
	public void setPort(String port) {
	    this.port = port;
	}
	
	public String getDb() {
	    return db;
	}
	
	public void setDb(String db) {
	    this.db = db;
	}
	
	public String toString() {
	    return String.format("Host: %s\nPort: %s\nDatabase: %s\n", host, port, db);
	}
}