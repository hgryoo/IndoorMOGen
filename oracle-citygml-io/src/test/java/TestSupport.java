

import java.util.Properties;

public class TestSupport {
	
	public static Properties getDefaultProperties() {
		Properties props = new Properties();
		props.put("driver", "oracle.jdbc.driver.OracleDriver");
		props.put("url", "jdbc:oracle:thin:@//localhost:1521/test");
		props.put("username", "system");
		props.put("password", "STEM9987");
		return props;
	}
}
