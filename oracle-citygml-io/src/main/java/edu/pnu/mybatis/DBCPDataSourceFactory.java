/**
 * 
 */
package edu.pnu.mybatis;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @author hgryoo
 *
 */
public class DBCPDataSourceFactory extends UnpooledDataSourceFactory {
	
	public DBCPDataSourceFactory() {
		this.dataSource = new BasicDataSource();
	}
}
