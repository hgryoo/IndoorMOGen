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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.opengis.citygml.v_2_0.dao.DAO;
import net.opengis.citygml.v_2_0.dao.core.CityObjectDAO;
import net.opengis.citygml.v_2_0.vo.building.BuildingBoundary;
import net.opengis.citygml.v_2_0.vo.building.BuildingOpening;
import net.opengis.citygml.v_2_0.vo.core.CityObject;
import net.opengis.citygml.v_2_0.vo.spatial.OrcaleGeometryConvert;
import oracle.spatial.geometry.J3D_Geometry;

/**
 * @author hgryoo
 * @see BuildingBoundaryMapper.xml
 */

//CREATE TABLE BuildingBoundary(
//		ID				INTEGER NOT NULL,
//		TYPE				VARCHAR(20),
//		BUILDING_ID			INTEGER,
//		ROOM_ID				INTEGER,
//		BUILDING_INSTALLATION_ID	INTEGER,
//		ROOM_INSTALLATION_ID		INTEGER,
//		PRIMARY KEY (ID),
//		FOREIGN KEY (ID) REFERENCES CityObject(ID),
//		FOREIGN KEY (BUILDING_ID) REFERENCES Building(ID),
//		FOREIGN KEY (ROOM_ID) REFERENCES Room(ID),
//		FOREIGN KEY (BUILDING_INSTALLATION_ID) REFERENCES BuildingInstallation(ID),
//		FOREIGN KEY (ROOM_INSTALLATION_ID) REFERENCES RoomInstallation(ID)
//);
public class BuildingBoundaryDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(BuildingBoundaryDAO.class);
	
	public static final String INSERT_BUILDINGBOUNDARY_NS = DAO.CityGML_MAPPER_NAMESPACE + ".insertBuildingBoundary";
	
	public static final String SELECT_BUILDINGOPENINGS_FOR_BUILDINGBOUNDARY_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectBuildingOpeningForBuildingBoundary";
	
	public static BuildingBoundary insertBuildingBoundary(SqlSession session, BuildingBoundary vo) throws Exception {
		//session.insert(INSERT_BUILDINGBOUNDARY_NS, vo);
		String sql = "INSERT INTO BuildingBoundary "
				+ "("
				+ "ID, BOUNDARY_TYPE, "
				+ "BUILDING_ID, ROOM_ID, BUILDING_INSTALLATION_ID, ROOM_INSTALLATION_ID,"
				+ "LOD2MULTISURFACE, LOD3MULTISURFACE, LOD4MULTISURFACE"
				+ ")"
				+ " VALUES ("
				+ "?,?,?,?,?,?,?,?,?"
				+ ")";
		
		Connection conn = session.getConnection();
		try {
			Struct lod2MultiSurfaceObject = null;
			Struct lod3MultiSurfaceObject = null;
			Struct lod4MultiSurfaceObject = null;
			
			if(vo.lod2MultiSurfaceGeometry != null){
				J3D_Geometry multisurface = OrcaleGeometryConvert.ConvertMultiSurface(vo.lod2MultiSurfaceGeometry);
				lod2MultiSurfaceObject = J3D_Geometry.storeJS(conn.unwrap(oracle.jdbc.OracleConnection.class), multisurface);
			}
			if(vo.lod3MultiSurfaceGeometry != null){
				J3D_Geometry multisurface = OrcaleGeometryConvert.ConvertMultiSurface(vo.lod3MultiSurfaceGeometry);
				lod3MultiSurfaceObject = J3D_Geometry.storeJS(conn.unwrap(oracle.jdbc.OracleConnection.class), multisurface);
			}
			if(vo.lod4MultiSurfaceGeometry != null){
				J3D_Geometry multisurface = OrcaleGeometryConvert.ConvertMultiSurface(vo.lod4MultiSurfaceGeometry);
				lod4MultiSurfaceObject = J3D_Geometry.storeJS(conn.unwrap(oracle.jdbc.OracleConnection.class), multisurface);
			}
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, vo.getId());
			pstm.setString(2, vo.getBoundaryType());
			pstm.setObject(3, (vo.getBuilding() != null)?vo.getBuilding().getId():null);
			pstm.setObject(4, (vo.getRoom() != null)?vo.getRoom().getId():null);
			pstm.setObject(5, (vo.getBuildingInstallation() != null)?vo.getBuildingInstallation().getId():null);
			pstm.setObject(6, (vo.getRoomInstallation() != null)?vo.getRoomInstallation().getId():null);
			if(lod2MultiSurfaceObject == null)
				pstm.setNull(7, Types.STRUCT, "MDSYS.SDO_GEOMETRY");
			else
				pstm.setObject(7, lod2MultiSurfaceObject);
			if(lod3MultiSurfaceObject == null)
				pstm.setNull(8, Types.STRUCT, "MDSYS.SDO_GEOMETRY");
			else
				pstm.setObject(8, lod3MultiSurfaceObject);
			if(lod4MultiSurfaceObject == null)
				pstm.setNull(9, Types.STRUCT, "MDSYS.SDO_GEOMETRY");
			else
				pstm.setObject(9, lod4MultiSurfaceObject);
			
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		List<BuildingOpening> openings = vo.getOpenings();
		for(BuildingOpening bo : openings) {
			bo = (BuildingOpening) CityObjectDAO.insertCityObject(session, bo);
			bo = BuildingOpeningDAO.insertBuildingOpening(session, bo);
		}
		return vo;
	}
	
	public static BuildingBoundary selectBuildingBoundary(SqlSession session, BuildingBoundary vo) throws Exception {

		List<BuildingOpening> openings = session.selectList(SELECT_BUILDINGOPENINGS_FOR_BUILDINGBOUNDARY_NS, vo.getId());
		//BuildingBoundary
		for(BuildingOpening bo : openings) {
			bo = BuildingOpeningDAO.selectBuildingOpening(session, bo);
			bo.setBoundary(vo);
		}
		vo.setOpenings(openings);
				
		return vo;
	}
	
}
