/**
 * 
 */
package net.opengis.citygml.v_2_0.dao.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import net.opengis.citygml.v_2_0.dao.DAO;
import net.opengis.citygml.v_2_0.dao.building.BuildingBoundaryDAO;
import net.opengis.citygml.v_2_0.dao.building.BuildingDAO; 
import net.opengis.citygml.v_2_0.dao.building.BuildingInstallationDAO;
import net.opengis.citygml.v_2_0.dao.building.BuildingOpeningDAO;
import net.opengis.citygml.v_2_0.dao.building.RoomDAO;
import net.opengis.citygml.v_2_0.dao.building.RoomInstallationDAO;
import net.opengis.citygml.v_2_0.vo.building.Building;
import net.opengis.citygml.v_2_0.vo.building.BuildingBoundary;
import net.opengis.citygml.v_2_0.vo.building.BuildingInstallation;
import net.opengis.citygml.v_2_0.vo.building.BuildingOpening;
import net.opengis.citygml.v_2_0.vo.building.Room;
import net.opengis.citygml.v_2_0.vo.building.RoomInstallation;
import net.opengis.citygml.v_2_0.vo.core.CityObject;

/**
 * @author hgryoo
 *
 */

//CREATE SEQUENCE CityObjectSEQ;
//
//CREATE TABLE CityObject(
//	ID	INTEGER NOT NULL AUTO_INCREMENT, 
//	GMLID 	VARCHAR(256), 
//	NAME 	VARCHAR(1000),
//	NAME_CODESPACE 	VARCHAR(2000), 
//	DESCRIPTION 	VARCHAR(2000), 
//	CREATION_DATE	DATE,
//	TERMINATION_DATE	DATE,
//	RELATIVE_TO_TERRAIN	VARCHAR(256),
//	RELATIVE_TO_WATER	VARCHAR(256),
//	PRIMARY KEY (ID)
//);
public abstract class CityObjectDAO {
	
	public static final String INSERT_CITYOBJECT_NS = DAO.CityGML_MAPPER_NAMESPACE + ".insertCityObject";
	
	public static final String SELECT_CITYOBJECT_TYPE_FROM_CITYMODEL_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectCityObjectTypeFromCityModel";
	public static final String SELECT_CITYOBJECT_FROM_CITYMODEL_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectCityObjectFromCityModel";
	
	public static CityObject insertCityObject(SqlSession session, CityObject vo) throws Exception {
		
		vo.setCityObjectType(vo.getClass().getSimpleName());
		//session.insert(INSERT_CITYOBJECT_NS, vo);
		String sql = "INSERT INTO CityObject (GMLID, CITYOBJECT_TYPE, NAME, NAME_CODESPACE, DESCRIPTION, "
				+ "CREATION_DATE, TERMINATION_DATE, RELATIVE_TO_TERRAIN, RELATIVE_TO_WATER)"
				+ " VALUES (?,?,?,?,?,?,?,?,?)";
				
		Connection conn = session.getConnection();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, vo.getGmlId());
			pstm.setString(2, vo.getCityObjectType());
			pstm.setString(3, vo.getName());
			pstm.setString(4, vo.getNameCodeSpace());
			pstm.setString(5, vo.getDescription());
			pstm.setDate(6, null);	// 날짜인데...일단 중요치 않은거 같아 생략
			pstm.setDate(7, null);	// 날짜인데...일단 중요치 않은거 같아 생략
			pstm.setString(8, vo.getRelativeToTerrain());
			pstm.setString(9, vo.getRelativeToWater());
			
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String selectKey = "SELECT MAX(ID) FROM CityObject";
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
	
	public static CityObject insertCityObjectInstance(SqlSession session, CityObject co) throws Exception {
		
		//Building Module Objects
		if(co instanceof Building) {
			co = BuildingDAO.insertBuilding(session, (Building) co);
		} else if(co instanceof Room) {
			co = RoomDAO.insertRoom(session, (Room) co);
		} else if(co instanceof BuildingBoundary) {
			co = BuildingBoundaryDAO.insertBuildingBoundary(session, (BuildingBoundary) co);
		} else if(co instanceof BuildingOpening) {
			co = BuildingOpeningDAO.insertBuildingOpening(session, (BuildingOpening) co);
		}
		/*
		else if(co instanceof BuildingInstallation) {
			co = BuildingInstallationDAO.insertBuildingInstallation(session, (BuildingInstallation) co);
		} else if(co instanceof RoomInstallation) {
			co = RoomInstallationDAO.insertRoomInstallation(session, (RoomInstallation) co);
		} 
		*/
		return co;
	}
	
	public static CityObject selectCityObject(SqlSession session, CityObject vo) throws Exception {
		
		String cityObjectType = vo.getCityObjectType();
		if("Building".equalsIgnoreCase(cityObjectType)) {
			vo = BuildingDAO.selectBuilding(session, vo.getId());
		} else {
			new UnsupportedOperationException();
		}
		
		
		return vo;
	}
	
	public static List<CityObject> selectCityObjectFromCityModel(SqlSession session, int cityModelId) throws Exception {

		List <Map<String, Object>> cityObjectTypes = session.selectList(SELECT_CITYOBJECT_TYPE_FROM_CITYMODEL_NS, cityModelId);
		List<CityObject> cityObjects = new ArrayList<CityObject>();
		
		for(Map<String, Object> typeMap : cityObjectTypes) {
			Integer id = (Integer) typeMap.get("id");
			String type = (String) typeMap.get("type");
			
			System.out.println("ID : " + id + " TYPE :" + type);
		}
		
		return cityObjects;
	}
	
}
