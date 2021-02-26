package com.BigTeacher;

import java.util.Properties;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
* The SettingsHandler gets settings properties from a properties file.It also writes settings to a properties file for use with Jdbc.
*
* @author  Taylor Clemons
* @version 0.1
* @since   2021-02-25
*/
public class SettingsHandler {
	private String host;
	private String port;
	private String database;

	public SettingsHandler() {
	}

	/**
	* The getProperties takes a String filename and attempts to read the Properties from file
	* @param String configFileName: name/path to config.properties file
	* @return props: Property object of sql settings
	*/
	public Properties getProperties(String configFileName) {
		File configFile = new File(configFileName);
		Properties props = new Properties();
		try {
			FileReader reader = new FileReader(configFile);
			props.load(reader);
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

	/**
	* Sets Properties settings to local variables and writes to file
	* @param String configFileName: name/path to config.properties file
	* @param String host: host name for Jdbc
	* @param String port: port num gor Jdbc
	* @param String database: name of database for Jdbc
	* @return Nothing
	*/
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

	public String getHost() {
		return this.host;
	}

	public String getPort() {
		return this.port;
	}

	public String getDatabase() {
		return this.database;
	}
}