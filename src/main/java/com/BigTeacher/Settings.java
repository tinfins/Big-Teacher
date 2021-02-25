package com.BigTeacher;

public class Settings {
	private String host;
	private String port;
	private String db;
	
	public Settings() {
	}
	
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