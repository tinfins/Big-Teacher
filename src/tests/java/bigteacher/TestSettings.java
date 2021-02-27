package bigteacher;

import org.junit.jupiter.api.Assertions;
import com.BigTeacher.Settings;

public class TestSettings {
	String host;
	String port;
	String database;
	
	protected void setUp() {
	    host = "aws";
	    port = "3306";
	    database = "test";
	}
	
	@Test
	public void testGetHost() {
	    Settings settings = new Settings(host, port, database);
	    Assertions.assertEquals(settings.getHost(), host);
	}
}