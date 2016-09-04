/**
 * 
 */
package net.opengis.citygml.v_2_0.dao.building;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import net.opengis.citygml.v_2_0.dao.DAO;
import net.opengis.citygml.v_2_0.dao.core.CityObjectDAO;
import net.opengis.citygml.v_2_0.vo.building.BuildingBoundary;
import net.opengis.citygml.v_2_0.vo.building.Room;
import net.opengis.citygml.v_2_0.vo.building.RoomInstallation;
import net.opengis.citygml.v_2_0.vo.core.CityObject;
import net.opengis.citygml.v_2_0.vo.spatial.OrcaleGeometryConvert;
import oracle.spatial.geometry.J3D_Geometry;
import oracle.spatial.geometry.JGeometry;

/**
 * @author hgryoo
 * @see RoomMapper.xml
 */
//CREATE TABLE ROOM(
//		ID		INTEGER NOT NULL,
//		BUILDING_ID	INTEGER,
//		CLAZZ		VARCHAR(256),
//		CLASS_CODESPACE	VARCHAR(1000),
//		FUNC		VARCHAR(256),
//		FUNC_CODESPACE	VARCHAR(1000),
//		USAGE			VARCHAR(256),
//		USAGE_CODESPACE		VARCHAR(1000),
//		PRIMARY KEY (ID),
//		FOREIGN KEY (ID) REFERENCES CityObject(ID),
//);

public class RoomDAO {
	
	public static final String INSERT_ROOM_NS = DAO.CityGML_MAPPER_NAMESPACE + ".insertRoom";
	public static final String SELECT_ROOM_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectRoom";
	
	public static final String SELECT_ROOMINSTALLATIONS_FOR_ROOM_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectRoomInstallationForRoom";
	public static final String SELECT_BUILDINGBOUNDARYS_FOR_ROOM_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectBuildingBoundarysForRoom";
			
	public static Room insertRoom(SqlSession session, Room vo) throws Exception {
		//Insert Room
		//session.insert(INSERT_ROOM_NS, vo);
		String sql = "INSERT INTO Room "
				+ "("
				+ "ID, BUILDING_ID, "
				+ "CLAZZ, CLASS_CODESPACE, FUNC, FUNC_CODESPACE, USAGE, USAGE_CODESPACE,"
				+ "LOD4SOLID,LOD4MULTISURFACE"
				+ ")"
				+ " VALUES ("
				+ "?,?,?,?,?,?,?,?,?,?"
				+ ")";
		
		Connection conn = session.getConnection();
		try {
			Struct lod4SolidObject = null;
			Struct lod4MultiSurfaceObject = null;
			if(vo.lod4SolidGeometry != null){
				J3D_Geometry solid = OrcaleGeometryConvert.ConvertSolid(vo.lod4SolidGeometry);
				lod4SolidObject = J3D_Geometry.storeJS(conn.unwrap(oracle.jdbc.OracleConnection.class), solid);
			}
			if(vo.lod4MultiSurfaceGeometry != null){
				J3D_Geometry multisurface = OrcaleGeometryConvert.ConvertMultiSurface(vo.lod4MultiSurfaceGeometry);
				lod4MultiSurfaceObject = J3D_Geometry.storeJS(conn.unwrap(oracle.jdbc.OracleConnection.class), multisurface);
			}
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, vo.getId());
			pstm.setObject(2, (vo.getBuilding() != null)?vo.getBuilding().getId():null);
			pstm.setString(3, vo.getClazz());
			pstm.setString(4, vo.getClassCodeSpace());
			pstm.setString(5, vo.getFunc());
			pstm.setString(6, vo.getFuncCodeSpace());
			pstm.setString(7, vo.getUsage());
			pstm.setString(8, vo.getUsageCodeSpace());
			if(lod4SolidObject == null)
				pstm.setNull(9, Types.STRUCT, "MDSYS.SDO_GEOMETRY");
			else
				pstm.setObject(9, lod4SolidObject);
			if(lod4MultiSurfaceObject == null)
				pstm.setNull(10, Types.STRUCT, "MDSYS.SDO_GEOMETRY");
			else
				pstm.setObject(10, lod4MultiSurfaceObject);
			
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Insert RoomInstallation
		/*
		List<RoomInstallation> ris = vo.getRoomInstallations();
		for(RoomInstallation ri : ris) {
			ri = (RoomInstallation) CityObjectDAO.insertCityObject(session, ri);
			ri = RoomInstallationDAO.insertRoomInstallation(session, ri);
		}
		*/
		List<BuildingBoundary> bbs = vo.getBuildingBoundarys();
		for(BuildingBoundary bb : bbs) {
			bb = (BuildingBoundary) CityObjectDAO.insertCityObject(session, bb);
			bb = BuildingBoundaryDAO.insertBuildingBoundary(session, bb);
		}
		
		return vo;
	}
	
	public static Room selectRoom(SqlSession session, Room vo) throws Exception {
		
		//RoomInstallation
		List<RoomInstallation> roomInstallations = session.selectList(SELECT_ROOMINSTALLATIONS_FOR_ROOM_NS, vo.getId());
		for(RoomInstallation ri : roomInstallations) {
			ri = RoomInstallationDAO.selectRoomInstallation(session, ri);
			ri.setRoom(vo);
		}
		vo.setRoomInstallations(roomInstallations);
		
		//BuildingBoundary
		List<BuildingBoundary> buildingBoundarys = session.selectList(SELECT_BUILDINGBOUNDARYS_FOR_ROOM_NS, vo.getId());
		for(BuildingBoundary bb : buildingBoundarys) {
			bb = BuildingBoundaryDAO.selectBuildingBoundary(session, bb);
			bb.setRoom(vo);
			
		}
		vo.setBuildingBoundarys(buildingBoundarys);
		
		return vo;
	}
	
	public static Room selectRoom(SqlSession session, Integer id) {
		Room vo = session.selectOne(SELECT_ROOM_NS, id);
		return vo;
	}
}
