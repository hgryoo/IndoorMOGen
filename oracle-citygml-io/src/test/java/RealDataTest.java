/**
 * 
 */


import java.io.File;
import java.util.Locale;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import edu.pnu.importexport.CityGMLOracleExporter;
import edu.pnu.importexport.CityGMLOracleImporter;
import edu.pnu.importexport.CityGMLOracleManager;

/**
 * @author hgryoo
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RealDataTest {
	
	@Before
	public void setUp() throws Exception {
		Locale.setDefault(Locale.ENGLISH);
	}
	
	@Test
	public void insertLotteTest() {
		CityGMLOracleImporter importer = new CityGMLOracleImporter();
		Properties props = new Properties();	
		props.put("driver", "oracle.jdbc.driver.OracleDriver");
		props.put("url", "jdbc:oracle:thin:@//localhost:1521/orcl");
		props.put("username", "system");
		props.put("password", "stem9987");
		
		try {
			CityGMLOracleManager manager = CityGMLOracleManager.getManager();
			//manager.deleteSchema(props);
			//manager.createSchema(props);
			
			String resource = "example/Lotte_final_0519.gml";
			File file = Resources.getResourceAsFile(resource);
			importer.importCityGML(props, "Real Data", file.getAbsolutePath());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void selectLotteTest() {
		CityGMLOracleExporter exporter = new CityGMLOracleExporter();
		Properties props = new Properties();
		
		props.put("driver", "org.postgresql.Driver");
		props.put("url", "jdbc:postgresql://localhost:5432/KairosTest");
		props.put("username", "postgres");
		props.put("password", "stem9987");
		
		try {
			exporter.exportCityGML(props, "Test Data", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}