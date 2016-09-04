/**
 * 
 */
package net.opengis.citygml.v_2_0.dao.spatial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.ibatis.session.SqlSession;

import net.opengis.citygml.v_2_0.dao.DAO;
import net.opengis.citygml.v_2_0.vo.spatial.Envelope;


/**
 * @author hgryoo
 *
 */

//CREATE TABLE Envelope (
//		ID	INTEGER NOT NULL AUTO_INCREMENT,
//		LOWER_CORNER	ST_POINTZ,
//		UPPER_CORNER	ST_POINTZ,
//		SRS_DIMENSION	INTEGER,
//		SRS_NAME	VARCHAR(100),
//		PRIMARY	KEY (ID) 
//);
public class EnvelopeDAO {
	
	public static final String INSERT_ENVELOPE_NS = DAO.CityGML_MAPPER_NAMESPACE + ".insertEnvelope";
	public static final String SELECT_ENVELOPE_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectEnvelope";

	public static Envelope insertEnvelope(SqlSession session, Envelope vo) throws Exception {
		//session.insert(INSERT_ENVELOPE_NS, vo);
		String sql = "INSERT INTO Envelope (SRS_NAME, SRS_DIMENSION, LOWER_CORNER, UPPER_CORNER)"
				+ " VALUES ("
				+ "'" + vo.getSrsName() + "'" + ","
				+ vo.getSrsDimension() + ","
				+ "SDO_GEOMETRY( 3001, NULL, SDO_POINT_TYPE(" 
				+ vo.lowerCornerGeometry.X() + "," 
				+ vo.lowerCornerGeometry.Y() + ","
				+ vo.lowerCornerGeometry.Z() 			
				+ "), NULL, NULL)" + ","
				+ "SDO_GEOMETRY( 3001, NULL, SDO_POINT_TYPE(" 
				+ vo.upperCornerGeometry.X() + "," 
				+ vo.upperCornerGeometry.Y() + ","
				+ vo.upperCornerGeometry.Z() 			
				+ "), NULL, NULL)"
				+")";
				
		Connection conn = session.getConnection();
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String selectKey = "SELECT MAX(ID) FROM Envelope";
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(selectKey);
			while(rs.next()) {
				int id = rs.getInt(1);
				vo.setId(id);
			}
			statement.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return vo;
	}
	
	public static Envelope selectEnvelopeForCityModel(SqlSession session, int id) throws Exception {
		Envelope vo = session.selectOne(SELECT_ENVELOPE_NS, id);
		return vo;
	}
}
