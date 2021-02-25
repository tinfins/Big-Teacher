package com.BigTeacher;

import java.util.Properties;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class SettingsHandler {
	private String host;
	private String port;
	private String database;
	
	public SettingsHandler() {
	}
	
	public Properties getProperties(String configFileName) {
		File configFile = new File(configFileName);
		Properties props = new Properties();
        try {
            FileReader reader = new FileReader(configFile);
            props.load(reader);
 
            String host = props.getProperty("host");
            System.out.print("Host name is: " + host);
            reader.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
            // Convert to logger
            ex.printStackTrace();
        } catch (IOException ex) {
            // I/O error
            // Convert to logger
            ex.printStackTrace();
        }
        return props;
	}
	
	public void setProperties(String configFileName, String host, String port, String database) {
	    this.host = host;
	    this.port = port;
	    this.database = database;
	    File configFile = new File(configFileName);
        try {
            Properties props = new Properties();
            props.setProperty("host", host);
            props.setProperty("port", port);
            props.setProperty("database", database);
            FileWriter writer = new FileWriter(configFile);
            props.store(writer, "sql settings");
            writer.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
            // Convert to logger
            ex.printStackTrace();
        } catch (IOException ex) {
            // I/O error
            // Convert to logger
            ex.printStackTrace();
        }
	}
}