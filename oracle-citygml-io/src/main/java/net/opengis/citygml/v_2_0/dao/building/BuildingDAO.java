/**
 * 
 */
package net.opengis.citygml.v_2_0.dao.building;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.opengis.citygml.v_2_0.dao.DAO;
import net.opengis.citygml.v_2_0.dao.core.CityObjectDAO;
import net.opengis.citygml.v_2_0.vo.building.Building;
import net.opengis.citygml.v_2_0.vo.building.BuildingBoundary;
import net.opengis.citygml.v_2_0.vo.building.BuildingInstallation;
import net.opengis.citygml.v_2_0.vo.building.Room;
import net.opengis.citygml.v_2_0.vo.spatial.OrcaleGeometryConvert;

import oracle.jdbc.driver.OracleDriver;
import oracle.spatial.geometry.J3D_Geometry;
import oracle.spatial.geometry.JGeometry;

/**
 * @author hgryoo
 * @see BuildingMapper.xml
 */

//CREATE TABLE Building(
//	ID		INTEGER NOT NULL,
//	PARENT_ID	INTEGER,
//	CLAZZ		VARCHAR(256),
//	CLASS_CODESPACE	VARCHAR(1000),
//	FUNC		VARCHAR(256),
//	FUNC_CODESPACE	VARCHAR(1000),
//	USAGE			VARCHAR(256),
//	USAGE_CODESPACE		VARCHAR(1000),
//	YEAR_OF_CONSTRUCTION	INTEGER,
//	YEAR_OF_DEMOLITION	INTEGER,
//	ROOF_TYPE		VARCHAR(256),
//	ROOF_TYPE_CODESPACE	VARCHAR(1000),
//	MEASURED_HEIGHT		DOUBLE,
//	MEASURED_HEIGHT_UNIT	VARCHAR(1000),
//	STOREYS_ABOVE_GROUND	INTEGER,
//	STOREYS_BELOW_GROUND	INTEGER,
//	STOREY_HEIGHTS_ABOVE_GROUND	VARCHAR(1000),
//	STOREY_HEIGHTS_ABOVE_UNIT	VARCHAR(1000),
//	STOREY_HEIGHTS_BELOW_GROUND	VARCHAR(1000),
//	STOREY_HEIGHTS_BELOW_UNIT	VARCHAR(1000),
//
//	PRIMARY KEY (ID),
//	FOREIGN KEY (ID) REFERENCES CityObject(ID),
//	FOREIGN KEY (PARENT_ID) REFERENCES Building(ID)
//);

//LOGGER.debug(
//		"[Building Select Report]\n"
//		+ "ID : " + vo.getId() + "\n"
//		+ "GMLId : " + vo.getGmlId() + "\n"
//		+ "Name : " + vo.getName() + "\n"
//		+ "NameCodeSpace : " + vo.getNameCodeSpace() + "\n"
//		+ "Description : " + vo.getDescription() + "\n"
//		+ "CreationDate : " + vo.getCreationDate() + "\n"
//		+ "TerminationDate : " + vo.getTerminationDate() + "\n"
//		+ "RelativeToTerrain : " + vo.getRelativeToTerrain() + "\n"
//		+ "RelativeToWater : " + vo.getRelativeToWater() + "\n"
//		
//		+ "Clazz : " + vo.getClazz() + "\n"
//		+ "ClassCodeSpace : " + vo.getClassCodeSpace() + "\n"
//		+ "Func : " + vo.getFunc() + "\n"
//		+ "FuncCodeSpace : " + vo.getFuncCodeSpace() + "\n"
//		+ "Usage" + vo.getUsage() + "\n"
//		+ "UsageCodeSpace" + vo.getUsageCodeSpace() + "\n"
//		+ "YearOfConstruction : " + vo.getYearOfConstruction() + "\n"
//		+ "YearOfDemolition : " + vo.getYearOfDemolition() + "\n"
//		+ "RoofType : " + vo.getRoofType() + "\n"
//		+ "RoofTypeCodeSpace : " + vo.getRoofTypeCodeSpace() + "\n"
//		+ "MeasuredHeight : " + vo.getMeasuredHeight() + "\n"
//		+ "MeasuredHeightUnit : " + vo.getMeasuredHeightUnit() + "\n"
//		
//		+ "StoreysAboveGround : " + vo.getMeasuredHeightUnit() + "\n"
//		+ "StoreysBelowGround : " + vo.getStoreysBelowGround() + "\n"
//		+ "StoreyHeightsAboveGround : " + vo.getStoreyHeightsAboveGround() + "\n"
//		+ "StoreyHeightsAboveUnit" + vo.getStoreyHeightsAboveUnit() + "\n"
//		+ "StoreyHeightsBelowGround : " + vo.getStoreyHeightsBelowGround() + "\n"
//		+ "StoreyHeightsBelowUnit : " + vo.getStoreyHeightsBelowUnit() + "\n"
//		
//		);
//

public class BuildingDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BuildingDAO.class);
	
	public static final String INSERT_BUILDING_NS = DAO.CityGML_MAPPER_NAMESPACE + ".insertBuilding";
	public static final String SELECT_BUILDING_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectBuilding";
	
	public static final String SELECT_BUILDINGINSTALLATIONS_FOR_BUILDING_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectBuildingInstallationsForBuilding";
	public static final String SELECT_ROOMS_FOR_BUILDING_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectRoomsForBuilding";
	public static final String SELECT_BUILDINGBOUNDARYS_FOR_BUILDING_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectBuildingBoundarysForBuilding";
	
	public static Building insertBuilding(SqlSession session, Building vo) throws Exception {
		
		//Insert Building
		//session.insert(INSERT_BUILDING_NS, vo);
		
		String sql = "INSERT INTO Building ("
				+ "ID, PARENT_ID,"
				+ "CLAZZ, CLASS_CODESPACE, FUNC, FUNC_CODESPACE, USAGE, USAGE_CODESPACE,"
				+ "YEAR_OF_CONSTRUCTION, YEAR_OF_DEMOLITION,"
				+ "ROOF_TYPE, ROOF_TYPE_CODESPACE, MEASURED_HEIGHT, MEASURED_HEIGHT_UNIT,"
				+ "STOREYS_ABOVE_GROUND, STOREYS_BELOW_GROUND,"
				+ "STOREY_HEIGHTS_ABOVE_GROUND, STOREY_HEIGHTS_ABOVE_UNIT, "
				+ "STOREY_HEIGHTS_BELOW_GROUND, STOREY_HEIGHTS_BELOW_UNIT,"
				+ "ADDRESS_ID,"
				+ "LOD1SOLID, LOD2SOLID, LOD3SOLID, LOD4SOLID"
				/*
				+ "LOD1MULTISURFACE, LOD2MULTISURFACE, LOD3MULTISURFACE, LOD4MULTISURFACE,"
				+ "LOD0FOOTPRINT, LOD0ROOFEDGE"
				*/
    			+ ")"
				+ " VALUES ("
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?"
				/*
				+ "?,?,?,?,?,?,?,?,?,?,"
				+ "?"
				*/
				+ ")";
		
				
		Connection conn = session.getConnection();
		try {
			Struct lod1SolidObject = null;
			Struct lod2SolidObject = null;
			Struct lod3SolidObject = null;
			Struct lod4SolidObject = null;
			
			if(vo.lod1SolidGeometry != null){
				J3D_Geometry solid = OrcaleGeometryConvert.ConvertSolid(vo.lod1SolidGeometry);
				lod1SolidObject = JGeometry.storeJS(conn.unwrap(oracle.jdbc.OracleConnection.class), solid);
			}
			if(vo.lod2SolidGeometry != null){
				J3D_Geometry solid = OrcaleGeometryConvert.ConvertSolid(vo.lod2SolidGeometry);
				lod2SolidObject = JGeometry.storeJS(conn.unwrap(oracle.jdbc.OracleConnection.class), solid);
			}
			if(vo.lod3SolidGeometry != null){
				J3D_Geometry solid = OrcaleGeometryConvert.ConvertSolid(vo.lod3SolidGeometry);
				lod3SolidObject = JGeometry.storeJS(conn.unwrap(oracle.jdbc.OracleConnection.class), solid);
			}
			if(vo.lod4SolidGeometry != null){
				J3D_Geometry solid = OrcaleGeometryConvert.ConvertSolid(vo.lod4SolidGeometry);
				lod4SolidObject = J3D_Geometry.storeJS(conn.unwrap(oracle.jdbc.OracleConnection.class), solid);
			}
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, vo.getId());
			pstm.setObject(2, (vo.getParent() != null)?vo.getParent().getId():null);
			pstm.setString(3, vo.getClazz());
			pstm.setString(4, vo.getClassCodeSpace());
			pstm.setString(5, vo.getFunc());
			pstm.setString(6, vo.getFuncCodeSpace());
			pstm.setString(7, vo.getUsage());
			pstm.setString(8, vo.getUsageCodeSpace());
			pstm.setObject(9, vo.getYearOfConstruction());
			pstm.setObject(10, vo.getYearOfDemolition());
			pstm.setString(11, vo.getRoofType());
			pstm.setString(12, vo.getRoofTypeCodeSpace());
			pstm.setObject(13, vo.getMeasuredHeight());
			pstm.setString(14, vo.getMeasuredHeightUnit());
			pstm.setObject(15, vo.getStoreysAboveGround());
			pstm.setObject(16, vo.getStoreysBelowGround());
			pstm.setString(17, vo.getStoreyHeightsAboveGround());
			pstm.setString(18, vo.getStoreyHeightsAboveUnit());
			pstm.setString(19, vo.getStoreyHeightsBelowGround());
			pstm.setString(20, vo.getStoreyHeightsBelowUnit());
			pstm.setObject(21, (vo.getAddress() != null)?vo.getAddress().getId():null);
			if(lod1SolidObject == null)
				pstm.setNull(22, Types.STRUCT, "MDSYS.SDO_GEOMETRY");
			else
				pstm.setObject(22, lod1SolidObject);
			if(lod2SolidObject == null)
				pstm.setNull(23, Types.STRUCT, "MDSYS.SDO_GEOMETRY");
			else
				pstm.setObject(23, lod2SolidObject);
			if(lod3SolidObject == null)
				pstm.setNull(24, Types.STRUCT, "MDSYS.SDO_GEOMETRY");
			else
				pstm.setObject(24, lod3SolidObject);
			if(lod4SolidObject == null)
				pstm.setNull(25, Types.STRUCT, "MDSYS.SDO_GEOMETRY");
			else
				pstm.setObject(25, lod4SolidObject);
			
			/*
			pstm.setObject(26, null);
			pstm.setObject(27, null);
			pstm.setObject(28, null);
			pstm.setObject(29, null);
			pstm.setObject(30, null);
			pstm.setObject(31, null);
			*/
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Insert Rooms
		List<Room> rooms = vo.getRooms();
		for(Room r : rooms) {
			r = (Room) CityObjectDAO.insertCityObject(session, r);
			r = RoomDAO.insertRoom(session, r);
		}
		
		/*
		//Insert BuildingInstallations
		List<BuildingInstallation> bis = vo.getBuildingInstallations();
		for(BuildingInstallation bi : bis) {
			bi = (BuildingInstallation) CityObjectDAO.insertCityObject(session, bi);
			bi = BuildingInstallationDAO.insertBuildingInstallation(session, bi);
		}
		
		//Insert BuildingBoundarys
		List<BuildingBoundary> bbs = vo.getBuildingBoundarys();
		for(BuildingBoundary bb : bbs) {
			bb = (BuildingBoundary) CityObjectDAO.insertCityObject(session, bb);
			bb = BuildingBoundaryDAO.insertBuildingBoundary(session, bb);
		}
		*/
		return vo;
	}

	public static Building selectBuilding(SqlSession session, Integer objectId) throws Exception {
		Building vo = session.selectOne(SELECT_BUILDING_NS, objectId);
		
		//BuildingInstallation
		List<BuildingInstallation> buildingInstallations = session.selectList(SELECT_BUILDINGINSTALLATIONS_FOR_BUILDING_NS, vo.getId());
		for(BuildingInstallation bi : buildingInstallations) {
			bi = BuildingInstallationDAO.selectBuildingInstallation(session, bi);
			bi.setBuilding(vo);
		}
		vo.setBuildingInstallations(buildingInstallations);
		
		//Room
		List<Room> selectedRoom = session.selectList(SELECT_ROOMS_FOR_BUILDING_NS, vo.getId());
		for(Room r : selectedRoom) {
			r = RoomDAO.selectRoom(session, r);
			r.setBuilding(vo);
		}
		vo.setRooms(selectedRoom);
		
		//BuildingBoundary
		List<BuildingBoundary> selectedBuildingBoundary = session.selectList(SELECT_BUILDINGBOUNDARYS_FOR_BUILDING_NS, vo.getId());
		for(BuildingBoundary bb : selectedBuildingBoundary) {
			bb = BuildingBoundaryDAO.selectBuildingBoundary(session, bb);
			bb.setBuilding(vo);
		}	
		vo.setBuildingBoundarys(selectedBuildingBoundary);
		
		/*		
		Address address;
		*/
		return vo;
	}
	
}
