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
import net.opengis.citygml.v_2_0.vo.building.BuildingInstallation;
import net.opengis.citygml.v_2_0.vo.core.CityObject;
import net.opengis.citygml.v_2_0.vo.core.ImplicitGeometry;

/**
 * @author hgryoo
 * @see BuildingInstallationMapper.xml
 */

//CREATE TABLE BuildingInstallation(
//		ID		INTEGER NOT NULL,
//		BUILDING_ID	INTEGER,
//		CLAZZ		VARCHAR(256),
//		CLASS_CODESPACE	VARCHAR(1000),
//		FUNC		VARCHAR(256),
//		FUNC_CODESPACE	VARCHAR(1000),
//		USAGE			VARCHAR(256),
//		USAGE_CODESPACE		VARCHAR(1000),
//		IS_INTERIOR		INTEGER NOT NULL,
//		PRIMARY KEY (ID),
//		FOREIGN KEY (ID) REFERENCES CityObject(ID),
//		FOREIGN KEY (BUILDING_ID) REFERENCES Building(ID)
//);

public class BuildingInstallationDAO {

	public static final String INSERT_BUILDINGINSTALLATION_NS = DAO.CityGML_MAPPER_NAMESPACE + ".insertBuildingInstallation";
	
	public static final String SELECT_BUILDINGINSTALLATION_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectBuildingInstallation";
	
	public static final String SELECT_BUILDINGBOUNDARYS_FOR_BUILDINGINSTALLATION_NS = DAO.CityGML_MAPPER_NAMESPACE + ".selectBuildingBoundarysForBuildingInstallation";
	
	public static BuildingInstallation insertBuildingInstallation(SqlSession session, BuildingInstallation vo) throws Exception {
		
		ImplicitGeometry lod2ImplicitRepresentation = vo.getLod2ImplicitRepresentation();
		ImplicitGeometry lod3ImplicitRepresentation = vo.getLod2ImplicitRepresentation();
		ImplicitGeometry lod4ImplicitRepresentation = vo.getLod2ImplicitRepresentation();
		
		//Insert BuildingInstallation
		session.insert(INSERT_BUILDINGINSTALLATION_NS, vo);
		
		//Insert BuildingBoundary
		List<BuildingBoundary> bbs = vo.getBuildingBoundarys();
		for(BuildingBoundary bb : bbs) {
			bb = (BuildingBoundary) CityObjectDAO.insertCityObject(session, bb);
			bb = BuildingBoundaryDAO.insertBuildingBoundary(session, bb);
		}
		
		return vo;
	}
	
	public static BuildingInstallation selectBuildingInstallation(SqlSession session, BuildingInstallation vo) throws Exception {
		
		/*
		ImplicitGeometry lod2ImplicitRepresentation;
		ImplicitGeometry lod3ImplicitRepresentation;
		ImplicitGeometry lod4ImplicitRepresentation;
		*/

		//BuildingBoundary
		List<BuildingBoundary> selectedBuildingBoundary = session.selectList(SELECT_BUILDINGBOUNDARYS_FOR_BUILDINGINSTALLATION_NS, vo.getId());
		for(BuildingBoundary bb : selectedBuildingBoundary) {
			bb = BuildingBoundaryDAO.selectBuildingBoundary(session, bb);
			bb.setBuildingInstallation(vo);
		}	
		vo.setBuildingBoundarys(selectedBuildingBoundary);

		return vo;
	}
	
	public static BuildingInstallation selectBuildingInstallation(SqlSession session, Integer id) {
		BuildingInstallation vo = session.selectOne(SELECT_BUILDINGINSTALLATION_NS, id);
		return vo;
	}
	
}