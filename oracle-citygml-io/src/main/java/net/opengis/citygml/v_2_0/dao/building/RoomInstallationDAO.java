/**
 * 
 */
package net.opengis.citygml.v_2_0.dao.building;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import net.opengis.citygml.v_2_0.dao.DAO;
import net.opengis.citygml.v_2_0.dao.core.CityObjectDAO;
import net.opengis.citygml.v_2_0.vo.building.BuildingBoundary;
import net.opengis.citygml.v_2_0.vo.building.RoomInstallation;
import net.opengis.citygml.v_2_0.vo.core.CityObject;
import net.opengis.citygml.v_2_0.vo.core.ImplicitGeometry;

/**
 * @author hgryoo
 * @see RoomInstallationMapper.xml
 */

//CREATE TABLE RoomInstallation(
//		ID		INTEGER NOT NULL,
//		ROOM_ID		INTEGER,
//		CLAZZ		VARCHAR(256),
//		CLASS_CODESPACE	VARCHAR(1000),
//		FUNC		VARCHAR(256),
//		FUNC_CODESPACE	VARCHAR(1000),
//		USAGE			VARCHAR(256),
//		USAGE_CODESPACE		VARCHAR(1000),
//		IS_MOVEABLE		INTEGER,
//		PRIMARY KEY (ID),
//		FOREIGN KEY (ID) REFERENCES CityObject(ID),
//		FOREIGN KEY (ROOM_ID) REFERENCES Room(ID)
//);
public class RoomInstallationDAO {

	public static final String INSERT_ROOMINSTALLATION_NS = DAO.CityGML_MAPPER_NAMESPACE + ".insertRoomInstallation";
	public static final String SELECT_ROOMINSTALLATION_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectRoomInstallation";
	
	public static final String SELECT_BUILDINGBOUNDARYS_FOR_ROOMINSTALLATION_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectBuildingBoundarysForRoomInstallation";
	
	public static RoomInstallation insertRoomInstallation(SqlSession session, RoomInstallation vo) throws Exception {
		
		/* Geometries */
		//TODO
		ImplicitGeometry lod4ImplicitRepresentation = vo.getLod4ImplicitRepresentation();
		
		//Insert RoomInstallation
		session.insert(INSERT_ROOMINSTALLATION_NS, vo);
		
		//Insert BuildingBoundary
		List<BuildingBoundary> bbs = vo.getBuildingBoundarys();
		for(BuildingBoundary bb : bbs) {
			bb = (BuildingBoundary) CityObjectDAO.insertCityObject(session, bb);
			bb = BuildingBoundaryDAO.insertBuildingBoundary(session, bb);
		}
		return vo;
	}
	
	public static RoomInstallation selectRoomInstallation(SqlSession session, Integer id) throws Exception {
		RoomInstallation vo = session.selectOne(SELECT_ROOMINSTALLATION_NS, id);
		return vo;
	}

	public static RoomInstallation selectRoomInstallation(SqlSession session, RoomInstallation vo) throws Exception {
		
		/* Geometries */
		//TODO
		/*ImplicitGeometry lod4ImplicitRepresentation;*/
		
		//BuildingBoundary
		List<BuildingBoundary> buildingBoundarys = session.selectList(SELECT_BUILDINGBOUNDARYS_FOR_ROOMINSTALLATION_NS, vo.getId());
		for(BuildingBoundary bb : buildingBoundarys) {
			bb = BuildingBoundaryDAO.selectBuildingBoundary(session, bb);
			bb.setRoomInstallation(vo);
			
		}
		vo.setBuildingBoundarys(buildingBoundarys);
		
		return vo;
	}
	
}
