/**
 * 
 */
package net.opengis.citygml.v_2_0.dao.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.opengis.citygml.v_2_0.dao.DAO;
import net.opengis.citygml.v_2_0.dao.spatial.EnvelopeDAO;
import net.opengis.citygml.v_2_0.vo.core.CityModel;
import net.opengis.citygml.v_2_0.vo.core.CityObject;
import net.opengis.citygml.v_2_0.vo.spatial.Envelope;
import net.opengis.citygml.v_2_0.vo.spatial.OrcaleGeometryConvert;
import oracle.spatial.geometry.J3D_Geometry;

/**
 * @author hgryoo
 * @see CityModelMapper.xml
 */
//CREATE TABLE CityModel (
//		ID	INTEGER NOT NULL AUTO_INCREMENT, 
//		GMLID 	VARCHAR(256), 
//		NAME 	VARCHAR(1000),
//		NAME_CODESPACE 	VARCHAR(2000), 
//		DESCRIPTION 	VARCHAR(2000), 
//		ENVELOPE_ID 	INTEGER,
//		PRIMARY KEY (ID),
//		FOREIGN KEY (ENVELOPE_ID) REFERENCES Envelope(ID)
//);
public class CityModelDAO {
	
	private static Logger LOGGER = LoggerFactory.getLogger(CityModelDAO.class);
	
	public static final String INSERT_CITYMODEL_NS = DAO.CityGML_MAPPER_NAMESPACE + ".insertCityModel";
	public static final String INSERT_CITYOBJECTMEMBER_NS = DAO.CityGML_MAPPER_NAMESPACE + ".insertCityObjectMember";
	
	public static final String SELECT_CITYMODEL_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectCityModel";
	public static final String SELECT_CITYMODEL_BY_SID_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectCityModelBySID";
	
	public static CityModel insertCityModel(SqlSession session, CityModel vo) throws Exception {
		//Insert Envelope
		Envelope envelope = vo.getEnvelope();
		if(envelope != null) {
			envelope = EnvelopeDAO.insertEnvelope(session, envelope);
		}
		
		//Insert CityModel
		//session.insert(INSERT_CITYMODEL_NS, vo);
		String sql = "INSERT INTO CityModel (GMLID, SID, NAME, NAME_CODESPACE, DESCRIPTION)"
				+ " VALUES (?,?,?,?,?)";
		
		Connection conn = session.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, vo.getGmlId());
			pstm.setString(2, vo.getsId());
			pstm.setString(3, vo.getName());
			pstm.setString(4, vo.getNameCodeSpace());
			pstm.setString(5, vo.getDescription());
			//pstm.setInt(6, envelope.getId());
			
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String selectKey = "SELECT MAX(ID) FROM CityModel";
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
		
		//Insert CityObject
		List<? extends CityObject> cityObjects = vo.getCityObjects();
		for(CityObject co : cityObjects) {
			co = CityObjectDAO.insertCityObject(session, co);
			co = CityObjectDAO.insertCityObjectInstance(session, co);
			insertCityObjectMember(session, vo, co);
		}
		session.commit();
		
		return vo;
	}

	public static Map<String, Object> insertCityObjectMember(SqlSession session, CityModel cityModel, CityObject cityObject) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cityModel", cityModel);
		map.put("cityObject", cityObject);
		//session.insert(INSERT_CITYOBJECTMEMBER_NS, map);
		
		String sql = "INSERT INTO CityObjectMember (CITYMODEL_ID, CITYOBJECT_ID)"
				+ " VALUES (?,?)";
		
		Connection conn = session.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, cityModel.getId());
			pstm.setInt(2, cityModel.getId());
			
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return map;
	}

	public static CityModel selectCityModel(SqlSession session, String id) throws Exception {
		CityModel vo = session.selectOne(SELECT_CITYMODEL_BY_SID_NS, id);
		
		Envelope env = EnvelopeDAO.selectEnvelopeForCityModel(session, vo.getId());
		vo.setEnvelope(env);
		
		List<CityObject> cos = vo.getCityObjects();
		
		List<CityObject> cityObjects = session.selectList(DAO.CityGML_MAPPER_NAMESPACE + ".selectCityObjectForCityModel", vo.getId());
		for(CityObject o : cityObjects) {
			CityObject object = CityObjectDAO.selectCityObject(session, o);
			cos.add(object);
		}
		
		return vo;
		
	}
	
	public static CityModel selectCityModel(SqlSession session, int id) throws Exception {
		//Select Envelope
		CityModel vo = session.selectOne(SELECT_CITYMODEL_NS, id);
		
		Envelope env = EnvelopeDAO.selectEnvelopeForCityModel(session, vo.getId());
		vo.setEnvelope(env);
		
		List<CityObject> cos = vo.getCityObjects();
		
		List<CityObject> cityObjects = session.selectList(DAO.CityGML_MAPPER_NAMESPACE + ".selectCityObjectForCityModel", vo.getId());
		for(CityObject o : cityObjects) {
			CityObject object = CityObjectDAO.selectCityObject(session, o);
			cos.add(object);
		}
		
		return vo;
	}
	
}
