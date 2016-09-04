/**
 * 
 */
package edu.pnu.importexport;

import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author hgryoo
 *
 */
public class CityGMLOracleManager {
	
	private static CityGMLOracleManager manager = null;
	
	public static CityGMLOracleManager getManager() {
		if(manager == null) {
			manager = new CityGMLOracleManager();
		}
		return manager;
	}
	
	private CityGMLOracleManager() {}
	
	public void executeSQL(Properties props, String sqlPath) throws Exception {
		InputStream stream = Resources.getResourceAsStream(sqlPath);
		java.util.Scanner scanner = new java.util.Scanner(stream, "UTF-8");
		scanner.useDelimiter(";");
		
		String resource = "conf/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);

		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader, props);
		SqlSession session = ssf.openSession();
		
		Connection conn = session.getConnection();
		conn.setAutoCommit(false);
		while(scanner.hasNext()) {
			Statement s = conn.createStatement();
			String sql = scanner.next();
			try {
				s.executeUpdate(sql + ";");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			s.close();
		}
		conn.commit();
		scanner.close();
		conn.close();
		session.close();
	}
	
	public void deleteSchema(Properties props) throws Exception {
		executeSQL(props, "sql/drop_table.sql");
	}
	
	public void createSchema(Properties props) throws Exception {
		executeSQL(props, "sql/create_schema.sql");
	}
	
	public SqlSession createSession(Properties props, String confPath) throws Exception {
		String resource = confPath;
		Reader reader = Resources.getResourceAsReader(resource);

		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader, props);
		SqlSession session = ssf.openSession();
		
		return session;
	}
	
	public SqlSession createSession(Properties props) throws Exception {
		String resource = "conf/configuration.xml";
		return createSession(props, resource);
	}
}
