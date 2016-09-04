/**
 * 
 */
package edu.pnu.importexport.store.convert;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.common.BindingNode;
import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.model.STGeometryCollection;
import edu.pnu.common.geometry.model.STMultiSurface;
import edu.pnu.common.geometry.model.STSolid;
import edu.pnu.common.geometry.utils.WKBGeometryBuilder;
import net.opengis.citygml.v_2_0.vo.building.Building;
import net.opengis.citygml.v_2_0.vo.building.BuildingBoundary;
import net.opengis.citygml.v_2_0.vo.building.BuildingInstallation;
import net.opengis.citygml.v_2_0.vo.building.BuildingOpening;
import net.opengis.citygml.v_2_0.vo.building.Room;
import net.opengis.citygml.v_2_0.vo.building.RoomInstallation;
import net.opengis.citygml.v_2_0.vo.core.Address;

/**
 * @author hgryoo
 *
 */
public class BuildingVOConvertUtil {
	
	private static WKBGeometryBuilder wkbBuilder = WKBGeometryBuilder.getBuilder();
	
	public static Building createBuilding(BindingNode node) {
		Building building = new Building();
		
		/* parent attributes */
		building = (Building) CityGMLVOConvertUtil.setCityObject(building, node);
		
		/* attributes */
		building.setClazz( (String) node.getAttribute("CLAZZ/VALUE"));
		building.setClassCodeSpace((String) node.getAttribute("CLAZZ/CODESPACE"));
		building.setFunc((String) node.getAttribute("FUNCTION/VALUE"));
		building.setFuncCodeSpace((String) node.getAttribute("FUNCTION/CODESPACE"));
		building.setUsage((String) node.getAttribute("USAGE/VALUE"));
		building.setUsageCodeSpace((String) node.getAttribute("USAGE/CODESPACE"));
		
		building.setYearOfConstruction( (Integer) node.getAttribute("YEAROFCONSTRUCTION"));
		building.setYearOfDemolition( (Integer) node.getAttribute("YEAROFDEMOLITION"));
		
		building.setRoofType((String) node.getAttribute("ROOFTYPE/VALUE"));
		building.setRoofTypeCodeSpace((String) node.getAttribute("ROOFTYPE/CODESPACE"));
		
		building.setMeasuredHeight( (Double) node.getAttribute("MEASUREDHEIGHT"));
		building.setMeasuredHeightUnit((String) node.getAttribute("MEASUREDHEIGHTUOM"));
		
		building.setStoreysAboveGround( (Integer) node.getAttribute("STOREYSABOVEGROUND"));
		building.setStoreysBelowGround( (Integer) node.getAttribute("STOREYSBELOWGROUND"));
		
		building.setStoreyHeightsAboveGround((String) node.getAttribute("STOREYHEIGHTSABOVEGROUND"));
		building.setStoreyHeightsAboveUnit((String) node.getAttribute("STOREYHEIGHTSABOVEUNIT"));
		building.setStoreyHeightsBelowGround((String) node.getAttribute("STOREYHEIGHTSBELOWGROUND"));
		building.setStoreyHeightsBelowUnit((String) node.getAttribute("STOREYHEIGHTSBELOWUNIT"));
		
		/* geometry attributes */

		//LOD0FootPrint
		BindingNode lod0FootPrintNode = node.getAssociation("LOD0FOOTPRINT");
		if(lod0FootPrintNode != null) {
			STMultiSurface lod0FootPrint = PostGISGeometryConvertUtil.convertMultiSurface(lod0FootPrintNode);
			building.lod0FootPrintGeometry = lod0FootPrint;
			building.setLod0FootPrint( wkbBuilder.asBinary(lod0FootPrint) );
		}
		//LOD0RoofEdge
		BindingNode lod0RoofEdgeNode = node.getAssociation("LOD0ROOFEDGE");
		if(lod0RoofEdgeNode != null) {
			STMultiSurface lod0RoofEdge = PostGISGeometryConvertUtil.convertMultiSurface(lod0RoofEdgeNode);
			building.lod0RoofEdgeGeometry = lod0RoofEdge;
			building.setLod0RoofEdge( wkbBuilder.asBinary(lod0RoofEdge) );
		}
		
		//lod1Solid
		BindingNode lod1SolidNode = node.getAssociation("LOD1SOLID");
		if(lod1SolidNode != null) {
			STSolid lod1Solid = PostGISGeometryConvertUtil.convertSolid(lod1SolidNode);
			building.lod1SolidGeometry = lod1Solid;
			building.setLod1Solid( wkbBuilder.asBinary(lod1Solid.exteriorShell()) );
		}
		//lod2Solid
		BindingNode lod2SolidNode = node.getAssociation("LOD2SOLID");
		if(lod2SolidNode != null) {
			STSolid lod2Solid = PostGISGeometryConvertUtil.convertSolid(lod2SolidNode);
			building.lod2SolidGeometry = lod2Solid;
			building.setLod2Solid( wkbBuilder.asBinary(lod2Solid.exteriorShell()) );
		}
		//lod3Solid
		BindingNode lod3SolidNode = node.getAssociation("LOD3SOLID");
		if(lod3SolidNode != null) {
			STSolid lod3Solid = PostGISGeometryConvertUtil.convertSolid(lod3SolidNode);
			building.lod3SolidGeometry = lod3Solid;
			building.setLod3Solid( wkbBuilder.asBinary(lod3Solid.exteriorShell()) );
		}
		//lod4Solid
		BindingNode lod4SolidNode = node.getAssociation("LOD4SOLID");
		if(lod4SolidNode != null) {
			STSolid lod4Solid = PostGISGeometryConvertUtil.convertSolid(lod4SolidNode);
			building.lod4SolidGeometry = lod4Solid;
			building.setLod4Solid( wkbBuilder.asBinary(lod4Solid.exteriorShell()) );
		}
		
		//lod1MultiSurface
		BindingNode lod1MultiSurfaceNode = node.getAssociation("LOD1MULTISURFACE");
		if(lod1MultiSurfaceNode != null) {
			STMultiSurface lod1MultiSurface = PostGISGeometryConvertUtil.convertMultiSurface(lod1MultiSurfaceNode);
			building.lod1MultiSurfaceGeometry = lod1MultiSurface;
			building.setLod1MultiSurface( wkbBuilder.asBinary(lod1MultiSurface) );
		}
		//lod1TerrainIntersection
		BindingNode lod1TerrainIntersectionNode = node.getAssociation("LOD1TERRAININTERSECTION");
		if(lod1TerrainIntersectionNode != null) {
			//MultiCurve lod1TerrainIntersection = GMLVOConvertUtil.createMultiCurve(lod1TerrainIntersectionNode);
			//building.setLod1TerrainIntersection(lod1TerrainIntersection);
		}

		
		//lod2MultiSurface
		BindingNode lod2MultiSurfaceNode = node.getAssociation("LOD2MULTISURFACE");
		if(lod2MultiSurfaceNode != null) {
			STMultiSurface lod2MultiSurface = PostGISGeometryConvertUtil.convertMultiSurface(lod2MultiSurfaceNode);
			building.lod2MultiSurfaceGeometry = lod2MultiSurface;
			building.setLod2MultiSurface( wkbBuilder.asBinary(lod2MultiSurface) );
		}
		//lod2MultiCurve
		BindingNode lod2MultiCurveNode = node.getAssociation("LOD2MULTICURVE");
		if(lod2MultiCurveNode != null) {
			//MultiCurve lod2MultiCurve = GMLVOConvertUtil.createMultiCurve(lod2MultiCurveNode);
			//building.setLod2MultiCurve(lod2MultiCurve);
		}		
		//lod2TerrainIntersection
		BindingNode lod2TerrainIntersectionNode = node.getAssociation("LOD2TERRAININTERSECTION");
		if(lod2TerrainIntersectionNode != null) {
			//MultiCurve lod2TerrainIntersection = GMLVOConvertUtil.createMultiCurve(lod2TerrainIntersectionNode);
			//building.setLod2TerrainIntersection(lod2TerrainIntersection);
		}
		
		//lod3MultiSurface
		BindingNode lod3MultiSurfaceNode = node.getAssociation("LOD3MULTISURFACE");
		if(lod3MultiSurfaceNode != null) {
			STMultiSurface lod3MultiSurface = PostGISGeometryConvertUtil.convertMultiSurface(lod3MultiSurfaceNode);
			building.lod3MultiSurfaceGeometry = lod3MultiSurface;
			building.setLod3MultiSurface( wkbBuilder.asBinary(lod3MultiSurface) );
		}		
		//lod3MultiCurve
		BindingNode lod3MultiCurveNode = node.getAssociation("LOD3MULTICURVE");
		if(lod3MultiCurveNode != null) {
			//MultiCurve lod3MultiCurve = GMLVOConvertUtil.createMultiCurve(lod3MultiCurveNode);
			//building.setLod3MultiCurve(lod3MultiCurve);
		}		
		//lod3TerrainIntersection
		BindingNode lod3TerrainIntersectionNode = node.getAssociation("LOD3TERRAININTERSECTION");
		if(lod3TerrainIntersectionNode != null) {
			//MultiCurve lod3TerrainIntersection = GMLVOConvertUtil.createMultiCurve(lod3TerrainIntersectionNode);
			//building.setLod3TerrainIntersection(lod3TerrainIntersection);
		}
		
		
		//lod4MultiSurface
		BindingNode lod4MultiSurfaceNode = node.getAssociation("LOD4MULTISURFACE");
		if(lod4MultiSurfaceNode != null) {
			STMultiSurface lod4MultiSurface = PostGISGeometryConvertUtil.convertMultiSurface(lod4MultiSurfaceNode);
			building.lod4MultiSurfaceGeometry = lod4MultiSurface;
			building.setLod4MultiSurface( wkbBuilder.asBinary(lod4MultiSurface) );
		}
		//lod4MultiCurve
		BindingNode lod4MultiCurveNode = node.getAssociation("LOD4MULTICURVE");
		if(lod4MultiCurveNode != null) {
			//MultiCurve lod4MultiCurve = GMLVOConvertUtil.createMultiCurve(lod4MultiCurveNode);
			//building.setLod4MultiCurve(lod4MultiCurve);
		}
		//lod4TerrainIntersection
		BindingNode lod4TerrainIntersectionNode = node.getAssociation("LOD4TERRAININTERSECTION");
		if(lod4TerrainIntersectionNode != null) {
			//MultiCurve lod4TerrainIntersection = GMLVOConvertUtil.createMultiCurve(lod4TerrainIntersectionNode);
			//building.setLod4TerrainIntersection(lod4TerrainIntersection);
		}
		
		/* collections */
		
		//BuildingInstallation
		List<BuildingInstallation> buildingInstallations = new ArrayList<BuildingInstallation>();
		
		List<BindingNode> outerBuildingInstallation = node.getCollection("BUILDINGINSTALLATION");
		for(BindingNode obiNode : outerBuildingInstallation) {
			BuildingInstallation bi = createBuildingInstallation(obiNode);
			bi.setBuilding(building);
			bi.setIsInterior(false);
			buildingInstallations.add(bi);
		}
		List<BindingNode> intBuildingInstallation = node.getCollection("INTBUILDINGINSTALLATION");
		for(BindingNode ibiNode : intBuildingInstallation) {
			BuildingInstallation bi = createBuildingInstallation(ibiNode);
			bi.setBuilding(building);
			bi.setIsInterior(true);
			buildingInstallations.add(bi);
		}
		building.setBuildingInstallations(buildingInstallations);
		
		
		//Room
		List<Room> rooms = new ArrayList<Room>();
		List<BindingNode> roomNodes = node.getCollection("ROOM");
		for(BindingNode rNode : roomNodes) {
			Room r = createRoom(rNode);
			r.setBuilding(building);
			rooms.add(r);
		}
		building.setRooms(rooms);
		
		//BuildingBoundarys
		List<BuildingBoundary> buildingBoundarys = new ArrayList<BuildingBoundary>();
		List<BindingNode> boundaryNodes = node.getCollection("BOUNDARYSURFACE");
		for(BindingNode bNode : boundaryNodes) {
			BuildingBoundary b = createBuildingBoundary(bNode);
			b.setBuilding(building);
			buildingBoundarys.add(b);
		}
		building.setBuildingBoundarys(buildingBoundarys);
		
		//BuildingPart
		List<Building> buildingParts = new ArrayList<Building>();
		List<BindingNode> bpNodes = node.getCollection("BUILDINGPART");
		for(BindingNode bPNode : bpNodes) {
			Building bP = createBuilding(bPNode);
			bP.setParent(building);
			buildingParts.add(bP);
		}
		building.setBuildingParts(buildingParts);
		
		//Address
		//TODO : consider all list values
		List<BindingNode> addressNodes = node.getCollection("ADDRESS");
		if(addressNodes != null && addressNodes.size() > 0) {
			BindingNode addrNode = addressNodes.get(0);
			Address addr = CityGMLVOConvertUtil.createAddress(addrNode);
			building.setAddress(addr);
		}
		return building;
	}
	


	public static Room createRoom(BindingNode node) {
		Room room = new Room();
		
		/* parent attributes */
		room = (Room) CityGMLVOConvertUtil.setCityObject(room, node);
		
		/* attributes */
		room.setClazz( (String) node.getAttribute("CLAZZ/VALUE"));
		room.setClassCodeSpace((String) node.getAttribute("CLAZZ/CODESPACE"));
		room.setFunc((String) node.getAttribute("FUNCTION/VALUE"));
		room.setFuncCodeSpace((String) node.getAttribute("FUNCTION/CODESPACE"));
		room.setUsage((String) node.getAttribute("USAGE/VALUE"));
		room.setUsageCodeSpace((String) node.getAttribute("USAGE/CODESPACE"));
		
		/* collections */
		
		//BuildingBoundarys
		List<BuildingBoundary> buildingBoundarys = new ArrayList<BuildingBoundary>();
		List<BindingNode> boundaryNodes = node.getCollection("BOUNDARYSURFACE");
		for(BindingNode bNode : boundaryNodes) {
			BuildingBoundary b = createBuildingBoundary(bNode);
			b.setRoom(room);
			buildingBoundarys.add(b);
		}
		room.setBuildingBoundarys(buildingBoundarys);
		
		//RoomInstallation
		List<RoomInstallation> roomInstallations = new ArrayList<RoomInstallation>();
		List<BindingNode> buildingFurniture = node.getCollection("INTERIORFURNITURE");
		for(BindingNode bfNode : buildingFurniture) {
			RoomInstallation ri = createRoomIntallation(bfNode);
			ri.setRoom(room);
			ri.setIsMoveable(true);
			roomInstallations.add(ri);
		}
		List<BindingNode> roomInstallation = node.getCollection("ROOMINSTALLATION");
		for(BindingNode riNode : roomInstallation) {
			RoomInstallation ri = createRoomIntallation(riNode);
			ri.setRoom(room);
			ri.setIsMoveable(false);
			roomInstallations.add(ri);
		}
		room.setRoomInstallations(roomInstallations);
		
		/* geometry associations */
		//LOD4SOLID
		BindingNode lod4SolidNode = node.getAssociation("LOD4SOLID");
		if(lod4SolidNode != null) {
			STSolid lod4Solid = PostGISGeometryConvertUtil.convertSolid(lod4SolidNode);
			room.lod4SolidGeometry = lod4Solid;
			room.setLod4Solid( wkbBuilder.asBinary(lod4Solid) );
		}
		//LOD4MULTISURFACE
		BindingNode lod4MultiSurfaceNode = node.getAssociation("LOD4MULTISURFACE");
		if(lod4MultiSurfaceNode != null) {
			STMultiSurface lod4MultiSurface = PostGISGeometryConvertUtil.convertMultiSurface(lod4MultiSurfaceNode);
			room.lod4MultiSurfaceGeometry = lod4MultiSurface;
			room.setLod4MultiSurface( wkbBuilder.asBinary(lod4MultiSurface) );
		}
		return room;
	}

	public static RoomInstallation createRoomIntallation(BindingNode node) {
		RoomInstallation ri = new RoomInstallation();
		
		/* parent attributes */
		ri = (RoomInstallation) CityGMLVOConvertUtil.setCityObject(ri, node);
		
		/* attributes */
		ri.setClazz( (String) node.getAttribute("CLAZZ/VALUE"));
		ri.setClassCodeSpace((String) node.getAttribute("CLAZZ/CODESPACE"));
		ri.setFunc((String) node.getAttribute("FUNCTION/VALUE"));
		ri.setFuncCodeSpace((String) node.getAttribute("FUNCTION/CODESPACE"));
		ri.setUsage((String) node.getAttribute("USAGE/VALUE"));
		ri.setUsageCodeSpace((String) node.getAttribute("USAGE/CODESPACE"));
		
		/* collections */
		//BuildingBoundarys
		List<BuildingBoundary> buildingBoundarys = new ArrayList<BuildingBoundary>();
		List<BindingNode> boundaryNodes = node.getCollection("BOUNDARYSURFACE");
		for(BindingNode bNode : boundaryNodes) {
			BuildingBoundary b = createBuildingBoundary(bNode);
			b.setRoomInstallation(ri);
			buildingBoundarys.add(b);
		}
		ri.setBuildingBoundarys(buildingBoundarys);
		
		/* geometry attributes */
		//lod4Geometry
		BindingNode lod4GeometryNode = node.getAssociation("LOD4GEOMETRY");
		if(lod4GeometryNode != null) {
			STGeometry lod4Geometry = PostGISGeometryConvertUtil.convertGeometry(lod4GeometryNode);
			STGeometry[] geoms = new STGeometry[] {lod4Geometry};
			STGeometryCollection gc = PostGISGeometryConvertUtil.wrapGeometries(geoms);
			ri.setLod4Geometry( wkbBuilder.asBinary(gc));
		}
		
		//lod4ImplicitRepresentation
		//TODO
		
		return ri; 
	}
	
	public static BuildingInstallation createBuildingInstallation(BindingNode node) {
		BuildingInstallation bi = new BuildingInstallation();

		/* parent attributes */
		bi = (BuildingInstallation) CityGMLVOConvertUtil.setCityObject(bi, node);
		
		/* attributes */
		bi.setClazz( (String) node.getAttribute("CLAZZ/VALUE"));
		bi.setClassCodeSpace((String) node.getAttribute("CLAZZ/CODESPACE"));
		bi.setFunc((String) node.getAttribute("FUNCTION/VALUE"));
		bi.setFuncCodeSpace((String) node.getAttribute("FUNCTION/CODESPACE"));
		bi.setUsage((String) node.getAttribute("USAGE/VALUE"));
		bi.setUsageCodeSpace((String) node.getAttribute("USAGE/CODESPACE"));
		
		/* collections */
		//BuildingBoundarys
		List<BuildingBoundary> buildingBoundarys = new ArrayList<BuildingBoundary>();
		List<BindingNode> boundaryNodes = node.getCollection("BOUNDARYSURFACE");
		for(BindingNode bNode : boundaryNodes) {
			BuildingBoundary b = createBuildingBoundary(bNode);
			b.setBuildingInstallation(bi);
			buildingBoundarys.add(b);
		}
		bi.setBuildingBoundarys(buildingBoundarys);
		
		/* geometry attributes */
		
		//TODO
		
		//lod2Geometry
		BindingNode lod2GeometryNode = node.getAssociation("LOD2GEOMETRY");
		if(lod2GeometryNode != null) {
			STGeometry lod2Geometry = PostGISGeometryConvertUtil.convertGeometry(lod2GeometryNode);
			STGeometry[] geoms = new STGeometry[] {lod2Geometry};
			STGeometryCollection gc = PostGISGeometryConvertUtil.wrapGeometries(geoms);
			bi.setLod2Geometry( wkbBuilder.asBinary(gc));
		}
		//lod3Geometry
		BindingNode lod3GeometryNode = node.getAssociation("LOD3GEOMETRY");
		if(lod3GeometryNode != null) {
			STGeometry lod3Geometry = PostGISGeometryConvertUtil.convertGeometry(lod3GeometryNode);
			STGeometry[] geoms = new STGeometry[] {lod3Geometry};
			STGeometryCollection gc = PostGISGeometryConvertUtil.wrapGeometries(geoms);
			bi.setLod3Geometry( wkbBuilder.asBinary(gc));
		}
		//lod4Geometry
		BindingNode lod4GeometryNode = node.getAssociation("LOD4GEOMETRY");
		if(lod4GeometryNode != null) {
			STGeometry lod4Geometry = PostGISGeometryConvertUtil.convertGeometry(lod4GeometryNode);
			STGeometry[] geoms = new STGeometry[] {lod4Geometry};
			STGeometryCollection gc = PostGISGeometryConvertUtil.wrapGeometries(geoms);
			bi.setLod4Geometry( wkbBuilder.asBinary(gc));
		}
		
		//TODO
		//lod2ImplicitRepresentation
		
		//lod3ImplicitRepresentation
		
		//lod4ImplicitRepresentation
		
		return bi;
	}
	
	public static BuildingBoundary createBuildingBoundary(BindingNode node) {
		
		BuildingBoundary buildingBoundary = new BuildingBoundary();
		
		/* parent attributes */
		buildingBoundary = (BuildingBoundary) CityGMLVOConvertUtil.setCityObject(buildingBoundary, node);
		
		/* attributes */
		buildingBoundary.setBoundaryType( (String) node.getAttribute("BOUNDARYTYPE"));
		
		/* collections */
		//opening
		List<BuildingOpening> openings = new ArrayList<BuildingOpening>();
		List<BindingNode> openingNodes = node.getCollection("OPENING");
		for(BindingNode oNode : openingNodes) {
			BuildingOpening o = createBuildingOpening(oNode);
			o.setBoundary(buildingBoundary);
			openings.add(o);
		}
		buildingBoundary.setOpenings(openings);
		
		
		/* geometry associations */
		//lod2MultiSurface
		BindingNode lod2MultiSurfaceNode = node.getAssociation("LOD2MULTISURFACE");
		if(lod2MultiSurfaceNode != null) {
			STMultiSurface lod2MultiSurface = PostGISGeometryConvertUtil.convertMultiSurface(lod2MultiSurfaceNode);
			buildingBoundary.lod2MultiSurfaceGeometry = lod2MultiSurface;
			buildingBoundary.setLod2MultiSurface( wkbBuilder.asBinary(lod2MultiSurface) );
		}
		//lod3MultiSurface
		BindingNode lod3MultiSurfaceNode = node.getAssociation("LOD3MULTISURFACE");
		if(lod3MultiSurfaceNode != null) {
			STMultiSurface lod3MultiSurface = PostGISGeometryConvertUtil.convertMultiSurface(lod3MultiSurfaceNode);
			buildingBoundary.lod3MultiSurfaceGeometry = lod3MultiSurface;
			buildingBoundary.setLod3MultiSurface( wkbBuilder.asBinary(lod3MultiSurface) );
		}
		//lod4MultiSurface
		BindingNode lod4MultiSurfaceNode = node.getAssociation("LOD4MULTISURFACE");
		if(lod4MultiSurfaceNode != null) {
			STMultiSurface lod4MultiSurface = PostGISGeometryConvertUtil.convertMultiSurface(lod4MultiSurfaceNode);
			buildingBoundary.lod4MultiSurfaceGeometry = lod4MultiSurface;
			buildingBoundary.setLod4MultiSurface( wkbBuilder.asBinary(lod4MultiSurface) );
		}
		return buildingBoundary;
	}
	
	public static BuildingOpening createBuildingOpening(BindingNode node) {
		BuildingOpening opening = new BuildingOpening();
		
		/* parent attributes */
		opening = (BuildingOpening) CityGMLVOConvertUtil.setCityObject(opening, node);
		
		/* attributes */
		opening.setOpeningType( (String) node.getAttribute("OPENINGTYPE"));
		
		/* associations */
		//ADDRESS
		BindingNode addressNode = node.getAssociation("ADDRESS");
		if(addressNode != null) {
			Address address = CityGMLVOConvertUtil.createAddress(addressNode);
			opening.setAddress(address);
		}
		
		/* geometry associations */
		//lod3MultiSurface
		BindingNode lod3MultiSurfaceNode = node.getAssociation("LOD3MULTISURFACE");
		if(lod3MultiSurfaceNode != null) {
			STMultiSurface lod3MultiSurface = PostGISGeometryConvertUtil.convertMultiSurface(lod3MultiSurfaceNode);
			opening.lod3MultiSurfaceGeometry = lod3MultiSurface;
			opening.setLod3MultiSurface( wkbBuilder.asBinary(lod3MultiSurface) );
		}
		//lod4MultiSurface
		BindingNode lod4MultiSurfaceNode = node.getAssociation("LOD4MULTISURFACE");
		if(lod4MultiSurfaceNode != null) {
			STMultiSurface lod4MultiSurface = PostGISGeometryConvertUtil.convertMultiSurface(lod4MultiSurfaceNode);
			opening.lod4MultiSurfaceGeometry = lod4MultiSurface;
			opening.setLod4MultiSurface( wkbBuilder.asBinary(lod4MultiSurface) );
		}
		
		//TODO
		//lod3ImplicitRepresentation
		
		//lod4ImplicitRepresentation
		return opening;
	}
}
