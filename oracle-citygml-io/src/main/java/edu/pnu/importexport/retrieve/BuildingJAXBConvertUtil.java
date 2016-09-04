/**
 * 
 */
package edu.pnu.importexport.retrieve;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.model.STGeometryCollection;
import edu.pnu.common.geometry.model.STMultiSurface;
import edu.pnu.common.geometry.utils.WKBGeometryParser;
import net.opengis.citygml.building.v_2_0.AbstractBoundarySurfaceType;
import net.opengis.citygml.building.v_2_0.AbstractBuildingType;
import net.opengis.citygml.building.v_2_0.AbstractOpeningType;
import net.opengis.citygml.building.v_2_0.BoundarySurfacePropertyType;
import net.opengis.citygml.building.v_2_0.BuildingFurnitureType;
import net.opengis.citygml.building.v_2_0.BuildingInstallationPropertyType;
import net.opengis.citygml.building.v_2_0.BuildingInstallationType;
import net.opengis.citygml.building.v_2_0.BuildingPartType;
import net.opengis.citygml.building.v_2_0.BuildingType;
import net.opengis.citygml.building.v_2_0.CeilingSurfaceType;
import net.opengis.citygml.building.v_2_0.ClosureSurfaceType;
import net.opengis.citygml.building.v_2_0.DoorType;
import net.opengis.citygml.building.v_2_0.FloorSurfaceType;
import net.opengis.citygml.building.v_2_0.GroundSurfaceType;
import net.opengis.citygml.building.v_2_0.IntBuildingInstallationPropertyType;
import net.opengis.citygml.building.v_2_0.IntBuildingInstallationType;
import net.opengis.citygml.building.v_2_0.InteriorFurniturePropertyType;
import net.opengis.citygml.building.v_2_0.InteriorRoomPropertyType;
import net.opengis.citygml.building.v_2_0.InteriorWallSurfaceType;
import net.opengis.citygml.building.v_2_0.OpeningPropertyType;
import net.opengis.citygml.building.v_2_0.OuterCeilingSurfaceType;
import net.opengis.citygml.building.v_2_0.OuterFloorSurfaceType;
import net.opengis.citygml.building.v_2_0.RoofSurfaceType;
import net.opengis.citygml.building.v_2_0.RoomType;
import net.opengis.citygml.building.v_2_0.WallSurfaceType;
import net.opengis.citygml.building.v_2_0.WindowType;
import net.opengis.citygml.v_2_0.vo.building.Building;
import net.opengis.citygml.v_2_0.vo.building.BuildingBoundary;
import net.opengis.citygml.v_2_0.vo.building.BuildingInstallation;
import net.opengis.citygml.v_2_0.vo.building.BuildingOpening;
import net.opengis.citygml.v_2_0.vo.building.Room;
import net.opengis.citygml.v_2_0.vo.building.RoomInstallation;
import net.opengis.gml.v_3_1_1.CodeType;
import net.opengis.gml.v_3_1_1.GeometryPropertyType;
import net.opengis.gml.v_3_1_1.LengthType;
import net.opengis.gml.v_3_1_1.MeasureOrNullListType;
import net.opengis.gml.v_3_1_1.MultiSurfacePropertyType;

/**
 * @author hgryoo
 *
 */
public class BuildingJAXBConvertUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(BuildingJAXBConvertUtil.class);
	
	private static final net.opengis.citygml.building.v_2_0.ObjectFactory bldgOf = new net.opengis.citygml.building.v_2_0.ObjectFactory();
	
	private static WKBGeometryParser parser = WKBGeometryParser.getParser();
	
	public static JAXBElement<? extends AbstractBuildingType> createBuildingType(Building vo) {
		
		AbstractBuildingType target = null;
		if(vo.getParent() == null) {
			//BuildingType
			target = bldgOf.createBuildingType();
		} else {
			//BuildingPartType
			target = bldgOf.createBuildingPartType();	
		}
		
		//SET ATTRIBUTES 
		VOJAXBConvertUtil.setCityObjectAttributes(target, vo);
		
		String clazz = vo.getClazz();
		String classCodeSpace = vo.getClassCodeSpace();
		JAXBElement<CodeType> clazzType = VOJAXBConvertUtil.createCodeType(clazz, classCodeSpace);
		if(clazzType != null) target.setClazz(clazzType.getValue());
		
		
		//TODO : consider multiple functions
		List<CodeType> functions = target.getFunction();
		String func = vo.getFunc();
		String funcCodeSpace = vo.getFuncCodeSpace();
		JAXBElement<CodeType> funcType = VOJAXBConvertUtil.createCodeType(func, funcCodeSpace);
		if(funcType != null) functions.add(funcType.getValue());
		
		//TODO : consider multiple usages
		List<CodeType> usages = target.getUsage();
		String usage = vo.getUsage();
		String usageCodeSpace = vo.getUsageCodeSpace();
		JAXBElement<CodeType> usageType = VOJAXBConvertUtil.createCodeType(usage, usageCodeSpace);
		if(usageType != null) usages.add(usageType.getValue());
		
		
		Integer yearOfConstruction = vo.getYearOfConstruction();
		if(yearOfConstruction != null) {
			Calendar yc = Calendar.getInstance();
			yc.set(Calendar.YEAR, yearOfConstruction);
			XMLGregorianCalendar yearOfConstructionCalendar 
				= VOJAXBConvertUtil.createXMLGregorianCalendar(yc.getTime());
			target.setYearOfConstruction(yearOfConstructionCalendar);
		}
		
		Integer yearOfDemolition = vo.getYearOfDemolition();
		if(yearOfDemolition != null) {
			Calendar yd = Calendar.getInstance();
			yd.set(Calendar.YEAR, yearOfDemolition);
			XMLGregorianCalendar yearOfDemolitionCalendar 
				= VOJAXBConvertUtil.createXMLGregorianCalendar(yd.getTime());
			target.setYearOfConstruction(yearOfDemolitionCalendar);
		}
		
		String roofType = vo.getRoofType();
		String roofTypeCodeSpace = vo.getRoofTypeCodeSpace();
		JAXBElement<CodeType> jRoofType = VOJAXBConvertUtil.createCodeType(roofType, roofTypeCodeSpace);
		if(jRoofType != null) target.setRoofType(jRoofType.getValue());
		
		
		Double measuredHeight = vo.getMeasuredHeight();
		String measuredHeightUnit = vo.getMeasuredHeightUnit();
		LengthType mh = VOJAXBConvertUtil.createLengthType(measuredHeight, measuredHeightUnit);
		if(mh != null) target.setMeasuredHeight(mh);

		Integer storeysAboveGround = vo.getStoreysAboveGround();
		if(storeysAboveGround != null) target.setStoreysAboveGround( new BigInteger(String.valueOf(storeysAboveGround)));
		Integer storeysBelowGround = vo.getStoreysBelowGround();
		if(storeysBelowGround != null) target.setStoreysBelowGround( new BigInteger(String.valueOf(storeysBelowGround)));
		
		//storeyHeightsAbove
		//TODO : consider multiple values
		String storeyHeightsAboveGround = vo.getStoreyHeightsAboveGround();
		String storeyHeightsAboveUnit = vo.getStoreyHeightsAboveUnit();
		
		List<String> storeyHeightsAboveGroundValus = new ArrayList<String>();
		if(storeyHeightsAboveGround != null) {
			storeyHeightsAboveGroundValus.add(storeyHeightsAboveGround);
		}
		MeasureOrNullListType storeysHeightsAbove = VOJAXBConvertUtil.createMeasureOrNullListType(storeyHeightsAboveGroundValus, storeyHeightsAboveUnit);
		if(storeysHeightsAbove != null) target.setStoreyHeightsAboveGround(storeysHeightsAbove);
		
		//storeyHeightsBelow
		//TODO : consider multiple values
		String storeyHeightsBelowGround = vo.getStoreyHeightsBelowGround();
		String storeyHeightsBelowUnit = vo.getStoreyHeightsBelowUnit();
		List<String> storeyHeightsBelowGroundValus = new ArrayList<String>();
		if(storeyHeightsBelowGround != null) {
			storeyHeightsBelowGroundValus.add(storeyHeightsBelowGround);
		}
		MeasureOrNullListType storeysHeightsBelow = VOJAXBConvertUtil.createMeasureOrNullListType(storeyHeightsBelowGroundValus, storeyHeightsBelowUnit);
		if(storeysHeightsBelow != null) target.setStoreyHeightsBelowGround(storeysHeightsAbove);
		
		//SET GEOMETRY
		/*byte[] lod1Solid = vo.getLod1Solid();
		if(lod1Solid != null) {
			STSolid solid = (STSolid) parser.parseWKB(lod1Solid);
			SolidPropertyType solidProp = VOJAXBConvertUtil.createSolidPropertyType(solid);
			target.setLod1Solid(solidProp);
		}
		byte[] lod2Solid = vo.getLod2Solid();
		if(lod2Solid != null) {
			STSolid solid = (STSolid) parser.parseWKB(lod2Solid);
			SolidPropertyType solidProp = VOJAXBConvertUtil.createSolidPropertyType(solid);
			target.setLod2Solid(solidProp);
		}
		byte[] lod3Solid = vo.getLod3Solid();
		if(lod3Solid != null) {
			STSolid solid = (STSolid) parser.parseWKB(lod3Solid);
			SolidPropertyType solidProp = VOJAXBConvertUtil.createSolidPropertyType(solid);
			target.setLod3Solid(solidProp);
		}
		byte[] lod4Solid = vo.getLod4Solid();
		if(lod4Solid != null) {
			STSolid solid = (STSolid) parser.parseWKB(lod4Solid);
			SolidPropertyType solidProp = VOJAXBConvertUtil.createSolidPropertyType(solid);
			target.setLod4Solid(solidProp);
		}*/
		
		//SET ASSOCIATIONS 
		
		//BuildingBoundarys
		List<BoundarySurfacePropertyType> boundaryPropertyList = target.getCityObjectBoundedBy();
		List<BuildingBoundary> boundarys = vo.getBuildingBoundarys();
		for(BuildingBoundary bb : boundarys) {
			JAXBElement<? extends AbstractBoundarySurfaceType> jBoundary = createAbstractBoundarySurfaceType(bb);
			BoundarySurfacePropertyType bsProp = bldgOf.createBoundarySurfacePropertyType();
			bsProp.setBoundarySurface(jBoundary);
			boundaryPropertyList.add(bsProp);
		}
	
		//Rooms
		List<InteriorRoomPropertyType> interiorRoomProps = target.getInteriorRoom();
		List<Room> rooms = vo.getRooms();
		for(Room r : rooms) {
			InteriorRoomPropertyType interiorRoomProp = bldgOf.createInteriorRoomPropertyType();
			RoomType roomType = createRoomType(r);
			interiorRoomProp.setRoom(roomType);
			interiorRoomProps.add(interiorRoomProp);
		}
		
		//BuildingInstallations (BuildingInstallationType and InteriorInstallation)
		List<BuildingInstallationPropertyType> outerBIProps = target.getOuterBuildingInstallation();
		List<IntBuildingInstallationPropertyType> interiorBIProps = target.getInteriorBuildingInstallation();
		List<BuildingInstallation> buildingInstallations = vo.getBuildingInstallations();
		for(BuildingInstallation bi : buildingInstallations) {
			//IntBuildingInstallation
			if(bi.getIsInterior() == true) {
				IntBuildingInstallationPropertyType intBIProp = bldgOf.createIntBuildingInstallationPropertyType();
				IntBuildingInstallationType intBIType = createIntBuildingInstallationType(bi);
				intBIProp.setIntBuildingInstallation(intBIType);
				interiorBIProps.add(intBIProp);
			}
			//BuildingInstallation
			else {
				BuildingInstallationPropertyType BIProp = bldgOf.createBuildingInstallationPropertyType();
				BuildingInstallationType BIType = createBuildingInstallationType(bi);
				BIProp.setBuildingInstallation(BIType);
				outerBIProps.add(BIProp);
			}
		}
		
		//Geometrys 
		//LOD Multisurface
		byte[] lod1MultiSurfaceWKB = vo.getLod1MultiSurface();
		if(lod1MultiSurfaceWKB != null) {
			STMultiSurface lod1MultiSurface = (STMultiSurface) parser.parseWKB(lod1MultiSurfaceWKB);
			MultiSurfacePropertyType multiSurfaceProp = VOJAXBConvertUtil.createMultiSurfacePropertyType(lod1MultiSurface);
			target.setLod1MultiSurface(multiSurfaceProp);
			
		}
		byte[] lod2MultiSurfaceWKB = vo.getLod2MultiSurface();
		if(lod2MultiSurfaceWKB != null) {
			STMultiSurface lod2MultiSurface = (STMultiSurface) parser.parseWKB(lod2MultiSurfaceWKB);
			MultiSurfacePropertyType multiSurfaceProp = VOJAXBConvertUtil.createMultiSurfacePropertyType(lod2MultiSurface);
			target.setLod2MultiSurface(multiSurfaceProp);
			
		}
		byte[] lod3MultiSurfaceWKB = vo.getLod3MultiSurface();
		if(lod3MultiSurfaceWKB != null) {
			STMultiSurface lod3MultiSurface = (STMultiSurface) parser.parseWKB(lod3MultiSurfaceWKB);
			MultiSurfacePropertyType multiSurfaceProp = VOJAXBConvertUtil.createMultiSurfacePropertyType(lod3MultiSurface);
			target.setLod3MultiSurface(multiSurfaceProp);
			
		}
		byte[] lod4MultiSurfaceWKB = vo.getLod4MultiSurface();
		if(lod4MultiSurfaceWKB != null) {
			STMultiSurface lod4MultiSurface = (STMultiSurface) parser.parseWKB(lod4MultiSurfaceWKB);
			MultiSurfacePropertyType multiSurfaceProp = VOJAXBConvertUtil.createMultiSurfacePropertyType(lod4MultiSurface);
			target.setLod4MultiSurface(multiSurfaceProp);
			
		}	
		
		JAXBElement<? extends AbstractBuildingType> jBuilding = null;
		if(target instanceof BuildingType) {
			jBuilding = bldgOf.createBuilding((BuildingType) target);
		} else if(target instanceof BuildingPartType) {
			jBuilding = bldgOf.createBuildingPart((BuildingPartType) target);
		} else {
			throw new IllegalArgumentException("Invalid AbstractBuildingType : " + target.getClass().getName());
		}
		
		return jBuilding;
	}

	public static BuildingInstallationType createBuildingInstallationType(BuildingInstallation vo) {
		BuildingInstallationType target = bldgOf.createBuildingInstallationType();
		
		//set CityObjectAttributes
		VOJAXBConvertUtil.setCityObjectAttributes(target, vo);
		
		//Attributes
		String clazz = vo.getClazz();
		String classCodeSpace = vo.getClassCodeSpace();
		JAXBElement<CodeType> clazzType = VOJAXBConvertUtil.createCodeType(clazz, classCodeSpace);
		if(clazzType != null) target.setClazz(clazzType.getValue());
	
		//TODO : consider multiple functions
		List<CodeType> functions = target.getFunction();
		String func = vo.getFunc();
		String funcCodeSpace = vo.getFuncCodeSpace();
		JAXBElement<CodeType> funcType = VOJAXBConvertUtil.createCodeType(func, funcCodeSpace);
		if(funcType != null) functions.add(funcType.getValue());
		
		//TODO : consider multiple usages
		List<CodeType> usages = target.getUsage();
		String usage = vo.getUsage();
		String usageCodeSpace = vo.getUsageCodeSpace();
		JAXBElement<CodeType> usageType = VOJAXBConvertUtil.createCodeType(usage, usageCodeSpace);
		if(usageType != null) usages.add(usageType.getValue());
		
		//GEOMETRIES 
		byte[] lod2GeometryWKB = vo.getLod2Geometry();
		if(lod2GeometryWKB != null) {
			STGeometryCollection lod2GeometryCollection = (STGeometryCollection) parser.parseWKB(lod2GeometryWKB);
			STGeometry lod2Geometry = lod2GeometryCollection.geometryN(0);
			GeometryPropertyType geometryProp = VOJAXBConvertUtil.createGeometryProperty(lod2Geometry);
			target.setLod2Geometry(geometryProp);
		}
		byte[] lod3GeometryWKB = vo.getLod3Geometry();
		if(lod3GeometryWKB != null) {
			STGeometryCollection lod3GeometryCollection = (STGeometryCollection) parser.parseWKB(lod3GeometryWKB);
			STGeometry lod3Geometry = lod3GeometryCollection.geometryN(0);
			GeometryPropertyType geometryProp = VOJAXBConvertUtil.createGeometryProperty(lod3Geometry);
			target.setLod3Geometry(geometryProp);
		}
		byte[] lod4GeometryWKB = vo.getLod4Geometry();
		if(lod4GeometryWKB != null) {
			STGeometryCollection lod4GeometryCollection = (STGeometryCollection) parser.parseWKB(lod4GeometryWKB);
			STGeometry lod4Geometry = lod4GeometryCollection.geometryN(0);
			GeometryPropertyType geometryProp = VOJAXBConvertUtil.createGeometryProperty(lod4Geometry);
			target.setLod4Geometry(geometryProp);
		}
		
		//TODO
/*	    ImplicitRepresentationPropertyType lod2ImplicitRepresentation;
	    ImplicitRepresentationPropertyType lod3ImplicitRepresentation;
	    ImplicitRepresentationPropertyType lod4ImplicitRepresentation;*/
		
		//SET ASSOCIATIONS 
		
		//BuildingBoundarys
		List<BoundarySurfacePropertyType> boundaryPropertyList = target.getCityObjectBoundedBy();
		List<BuildingBoundary> boundarys = vo.getBuildingBoundarys();
		for(BuildingBoundary bb : boundarys) {
			JAXBElement<? extends AbstractBoundarySurfaceType> jBoundary = createAbstractBoundarySurfaceType(bb);
			BoundarySurfacePropertyType bsProp = bldgOf.createBoundarySurfacePropertyType();
			bsProp.setBoundarySurface(jBoundary);
			boundaryPropertyList.add(bsProp);
		}
		
		return target;
	}

	static IntBuildingInstallationType createIntBuildingInstallationType(RoomInstallation vo) {
		IntBuildingInstallationType target = bldgOf.createIntBuildingInstallationType();
		
		//set CityObjectAttributes
		VOJAXBConvertUtil.setCityObjectAttributes(target, vo);
		
		//Attributes 
		String clazz = vo.getClazz();
		String classCodeSpace = vo.getClassCodeSpace();
		JAXBElement<CodeType> clazzType = VOJAXBConvertUtil.createCodeType(clazz, classCodeSpace);
		if(clazzType != null) target.setClazz(clazzType.getValue());
	
		//TODO : consider multiple functions
		List<CodeType> functions = target.getFunction();
		String func = vo.getFunc();
		String funcCodeSpace = vo.getFuncCodeSpace();
		JAXBElement<CodeType> funcType = VOJAXBConvertUtil.createCodeType(func, funcCodeSpace);
		if(funcType != null) functions.add(funcType.getValue());
		
		//TODO : consider multiple usages
		List<CodeType> usages = target.getUsage();
		String usage = vo.getUsage();
		String usageCodeSpace = vo.getUsageCodeSpace();
		JAXBElement<CodeType> usageType = VOJAXBConvertUtil.createCodeType(usage, usageCodeSpace);
		if(usageType != null) usages.add(usageType.getValue());
		
		//Geometry
		byte[] lod4GeometryWKB = vo.getLod4Geometry();
		if(lod4GeometryWKB != null) {
			STGeometryCollection lod4GeometryCollection = (STGeometryCollection) parser.parseWKB(lod4GeometryWKB);
			STGeometry lod4Geometry = lod4GeometryCollection.geometryN(0);
			GeometryPropertyType geometryProp = VOJAXBConvertUtil.createGeometryProperty(lod4Geometry);
			target.setLod4Geometry(geometryProp);
		}
		
		//TODO
		//ImplicitRepresentationPropertyType lod4ImplicitRepresentation;
		
		//SET ASSOCIATIONS 
		//BuildingBoundarys
		List<BoundarySurfacePropertyType> boundaryPropertyList = target.getCityObjectBoundedBy();
		List<BuildingBoundary> boundarys = vo.getBuildingBoundarys();
		for(BuildingBoundary bb : boundarys) {
			JAXBElement<? extends AbstractBoundarySurfaceType> jBoundary = createAbstractBoundarySurfaceType(bb);
			BoundarySurfacePropertyType bsProp = bldgOf.createBoundarySurfacePropertyType();
			bsProp.setBoundarySurface(jBoundary);
			boundaryPropertyList.add(bsProp);
		}
		
		return target;
	}

	public static IntBuildingInstallationType createIntBuildingInstallationType(BuildingInstallation vo) {
		IntBuildingInstallationType target = bldgOf.createIntBuildingInstallationType();
		
		//set CityObjectAttributes
		VOJAXBConvertUtil.setCityObjectAttributes(target, vo);
		
		//Attributes 
		String clazz = vo.getClazz();
		String classCodeSpace = vo.getClassCodeSpace();
		JAXBElement<CodeType> clazzType = VOJAXBConvertUtil.createCodeType(clazz, classCodeSpace);
		if(clazzType != null) target.setClazz(clazzType.getValue());
	
		//TODO : consider multiple functions
		List<CodeType> functions = target.getFunction();
		String func = vo.getFunc();
		String funcCodeSpace = vo.getFuncCodeSpace();
		JAXBElement<CodeType> funcType = VOJAXBConvertUtil.createCodeType(func, funcCodeSpace);
		if(funcType != null) functions.add(funcType.getValue());
		
		//TODO : consider multiple usages
		List<CodeType> usages = target.getUsage();
		String usage = vo.getUsage();
		String usageCodeSpace = vo.getUsageCodeSpace();
		JAXBElement<CodeType> usageType = VOJAXBConvertUtil.createCodeType(usage, usageCodeSpace);
		if(usageType != null) usages.add(usageType.getValue());
		
		//GEOMETRIES 
		byte[] lod4GeometryWKB = vo.getLod4Geometry();
		if(lod4GeometryWKB != null) {
			STGeometryCollection lod4GeometryCollection = (STGeometryCollection) parser.parseWKB(lod4GeometryWKB);
			STGeometry lod4Geometry = lod4GeometryCollection.geometryN(0);
			GeometryPropertyType geometryProp = VOJAXBConvertUtil.createGeometryProperty(lod4Geometry);
			target.setLod4Geometry(geometryProp);
		}
		
		//TODO
		//ImplicitRepresentationPropertyType lod4ImplicitRepresentation;*/
		
		//SET ASSOCIATIONS 
		
		//BuildingBoundarys
		List<BoundarySurfacePropertyType> boundaryPropertyList = target.getCityObjectBoundedBy();
		List<BuildingBoundary> boundarys = vo.getBuildingBoundarys();
		for(BuildingBoundary bb : boundarys) {
			JAXBElement<? extends AbstractBoundarySurfaceType> jBoundary = createAbstractBoundarySurfaceType(bb);
			BoundarySurfacePropertyType bsProp = bldgOf.createBoundarySurfacePropertyType();
			bsProp.setBoundarySurface(jBoundary);
			boundaryPropertyList.add(bsProp);
		}
		
		return target;
	}

	public static BuildingFurnitureType createBuildingFurnitureType(RoomInstallation vo) {
		BuildingFurnitureType target = bldgOf.createBuildingFurnitureType();
		
		//set CityObjectAttributes
		VOJAXBConvertUtil.setCityObjectAttributes(target, vo);
		
		//Attributes 
		String clazz = vo.getClazz();
		String classCodeSpace = vo.getClassCodeSpace();
		JAXBElement<CodeType> clazzType = VOJAXBConvertUtil.createCodeType(clazz, classCodeSpace);
		if(clazzType != null) target.setClazz(clazzType.getValue());
	
		//TODO : consider multiple functions
		List<CodeType> functions = target.getFunction();
		String func = vo.getFunc();
		String funcCodeSpace = vo.getFuncCodeSpace();
		JAXBElement<CodeType> funcType = VOJAXBConvertUtil.createCodeType(func, funcCodeSpace);
		if(funcType != null) functions.add(funcType.getValue());
		
		//TODO : consider multiple usages
		List<CodeType> usages = target.getUsage();
		String usage = vo.getUsage();
		String usageCodeSpace = vo.getUsageCodeSpace();
		JAXBElement<CodeType> usageType = VOJAXBConvertUtil.createCodeType(usage, usageCodeSpace);
		if(usageType != null) usages.add(usageType.getValue());
		
		byte[] lod4GeometryWKB = vo.getLod4Geometry();
		if(lod4GeometryWKB != null) {
			STGeometryCollection lod4GeometryCollection = (STGeometryCollection) parser.parseWKB(lod4GeometryWKB);
			STGeometry lod4Geometry = lod4GeometryCollection.geometryN(0);
			GeometryPropertyType geometryProp = VOJAXBConvertUtil.createGeometryProperty(lod4Geometry);
			target.setLod4Geometry(geometryProp);
		}
		
		//TODO
	    //ImplicitRepresentationPropertyType lod4ImplicitRepresentation;
	    
		
		return target;
	}

	public static RoomType createRoomType(Room vo) {
		RoomType target = bldgOf.createRoomType();
		
		VOJAXBConvertUtil.setCityObjectAttributes(target, vo);
		
		List<IntBuildingInstallationPropertyType> intBIProps = target.getRoomInstallation();
		List<InteriorFurniturePropertyType> intFurnitureProps = target.getInteriorFurniture();
		List<RoomInstallation> roomInstallations = vo.getRoomInstallations();
		for(RoomInstallation ri : roomInstallations) {
			//BuildingFurniture
			if(ri.getIsMoveable() == true) {
				InteriorFurniturePropertyType furnitureProp = bldgOf.createInteriorFurniturePropertyType();
				BuildingFurnitureType furnitureType = createBuildingFurnitureType(ri);
				furnitureProp.setBuildingFurniture(furnitureType);
				intFurnitureProps.add(furnitureProp);
			}
			//RoomInstallation
			else {
				IntBuildingInstallationPropertyType intBIProp = bldgOf.createIntBuildingInstallationPropertyType();
				IntBuildingInstallationType intBIType = createIntBuildingInstallationType(ri);
				intBIProp.setIntBuildingInstallation(intBIType);
				intBIProps.add(intBIProp);
			}
		}
		
		//BuildingBoundary
		List<BoundarySurfacePropertyType> boundaryPropertyList = target.getCityObjectBoundedBy();
		List<BuildingBoundary> boundarys = vo.getBuildingBoundarys();
		for(BuildingBoundary bb : boundarys) {
			JAXBElement<? extends AbstractBoundarySurfaceType> jBoundary = createAbstractBoundarySurfaceType(bb);
			BoundarySurfacePropertyType bsProp = bldgOf.createBoundarySurfacePropertyType();
			bsProp.setBoundarySurface(jBoundary);
			boundaryPropertyList.add(bsProp);
		}
		
		//Geomtries 
		/*byte[] lod4Solid = vo.getLod4Solid();
		if(lod4Solid != null) {
			STSolid solid = (STSolid) parser.parseWKB(lod4Solid);
			SolidPropertyType solidProp = VOJAXBConvertUtil.createSolidPropertyType(solid);
			target.setLod4Solid(solidProp);
		}*/
		
		byte[] lod4MultiSurfaceWKB = vo.getLod4MultiSurface();
		if(lod4MultiSurfaceWKB != null) {
			STMultiSurface lod4MultiSurface = (STMultiSurface) parser.parseWKB(lod4MultiSurfaceWKB);
			MultiSurfacePropertyType multiSurfaceProp = VOJAXBConvertUtil.createMultiSurfacePropertyType(lod4MultiSurface);
			target.setLod4MultiSurface(multiSurfaceProp);
		}
		
		return target;
	}
	
	public static JAXBElement<? extends AbstractBoundarySurfaceType> createAbstractBoundarySurfaceType(BuildingBoundary vo) {
	
		AbstractBoundarySurfaceType target = null;
		
		String boundaryType = vo.getBoundaryType();
		if("RoofSurface".equals(boundaryType)) {
			target = bldgOf.createRoofSurfaceType();
		} else if("WallSurface".equals(boundaryType)) {
			target = bldgOf.createWallSurfaceType();
		} else if("GroundSurface".equals(boundaryType)) {
			target = bldgOf.createGroundSurfaceType();
		} else if("ClosureSurface".equals(boundaryType)) {
			target = bldgOf.createClosureSurfaceType();
		} else if("FloorSurface".equals(boundaryType)) {
			target = bldgOf.createFloorSurfaceType();
		} else if("OuterFloorSurface".equals(boundaryType)) {
			target = bldgOf.createOuterFloorSurfaceType();
		} else if("InteriorWallSurface".equals(boundaryType)) {
			target = bldgOf.createInteriorWallSurfaceType();
		} else if("CeilingSurface".equals(boundaryType)) {
			target = bldgOf.createCeilingSurfaceType();
		} else if("OuterCeilingSurface".equals(boundaryType)) {
			target = bldgOf.createOuterCeilingSurfaceType();
		} else {
			throw new UnsupportedOperationException("Unsupported BoundaryType :" + boundaryType);
		}
		
		//CityObject attributes
		VOJAXBConvertUtil.setCityObjectAttributes(target, vo);
		
		//Opening
		List<OpeningPropertyType> openingProps = target.getOpening();
		List<BuildingOpening> openings = vo.getOpenings();
		for(BuildingOpening bo : openings) {
			OpeningPropertyType buildingOpening = bldgOf.createOpeningPropertyType();
			JAXBElement<? extends AbstractOpeningType> openingType = createAbstractOpeningType(bo);
			buildingOpening.setOpening(openingType);
			openingProps.add(buildingOpening);
		}
		
		//GEOMETRIES
		byte[] lod2MultiSurfaceWKB = vo.getLod2MultiSurface();
		if(lod2MultiSurfaceWKB != null) {
			STMultiSurface lod2MultiSurface = (STMultiSurface) parser.parseWKB(lod2MultiSurfaceWKB);
			MultiSurfacePropertyType multiSurfaceProp = VOJAXBConvertUtil.createMultiSurfacePropertyType(lod2MultiSurface);
			target.setLod2MultiSurface(multiSurfaceProp);
			
		}
		byte[] lod3MultiSurfaceWKB = vo.getLod3MultiSurface();
		if(lod3MultiSurfaceWKB != null) {
			STMultiSurface lod3MultiSurface = (STMultiSurface) parser.parseWKB(lod3MultiSurfaceWKB);
			MultiSurfacePropertyType multiSurfaceProp = VOJAXBConvertUtil.createMultiSurfacePropertyType(lod3MultiSurface);
			target.setLod3MultiSurface(multiSurfaceProp);
			
		}
		byte[] lod4MultiSurfaceWKB = vo.getLod4MultiSurface();
		if(lod4MultiSurfaceWKB != null) {
			STMultiSurface lod4MultiSurface = (STMultiSurface) parser.parseWKB(lod4MultiSurfaceWKB);
			MultiSurfacePropertyType multiSurfaceProp = VOJAXBConvertUtil.createMultiSurfacePropertyType(lod4MultiSurface);
			target.setLod4MultiSurface(multiSurfaceProp);
			
		}
		
		//TODO
		JAXBElement<? extends AbstractBoundarySurfaceType> jBoundary = null;
		if(target instanceof RoofSurfaceType) {
			jBoundary = bldgOf.createRoofSurface((RoofSurfaceType) target);
		} else if(target instanceof WallSurfaceType) {
			jBoundary = bldgOf.createWallSurface((WallSurfaceType) target);
		} else if(target instanceof GroundSurfaceType) {
			jBoundary = bldgOf.createGroundSurface((GroundSurfaceType) target);
		} else if(target instanceof ClosureSurfaceType) {
			jBoundary = bldgOf.createClosureSurface((ClosureSurfaceType) target);
		} else if(target instanceof FloorSurfaceType) {
			jBoundary = bldgOf.createFloorSurface((FloorSurfaceType) target);
		} else if(target instanceof OuterFloorSurfaceType) {
			jBoundary = bldgOf.createOuterFloorSurface((OuterFloorSurfaceType) target);
		} else if(target instanceof InteriorWallSurfaceType) {
			jBoundary = bldgOf.createInteriorWallSurface((InteriorWallSurfaceType) target);
		} else if(target instanceof CeilingSurfaceType) {
			jBoundary = bldgOf.createCeilingSurface((CeilingSurfaceType) target);
		} else if(target instanceof OuterCeilingSurfaceType) {
			jBoundary = bldgOf.createOuterCeilingSurface((OuterCeilingSurfaceType) target);
		} else {
			throw new UnsupportedOperationException();
		}
		return jBoundary;
	}

	public static JAXBElement<? extends AbstractOpeningType> createAbstractOpeningType(BuildingOpening vo) {
		AbstractOpeningType target;
		
		String openingType = vo.getOpeningType();
		if("DOOR".equalsIgnoreCase(openingType)) {
			target = bldgOf.createDoorType();
		} else if("WINDOW".equalsIgnoreCase(openingType)) {
			target = bldgOf.createWindowType();
		} else {
			throw new UnsupportedOperationException();
		}
		
		//CityObject attributes
		VOJAXBConvertUtil.setCityObjectAttributes(target, vo);
		
		byte[] lod3MultiSurfaceWKB = vo.getLod3MultiSurface();
		if(lod3MultiSurfaceWKB != null) {
			STMultiSurface lod3MultiSurface = (STMultiSurface) parser.parseWKB(lod3MultiSurfaceWKB);
			MultiSurfacePropertyType multiSurfaceProp = VOJAXBConvertUtil.createMultiSurfacePropertyType(lod3MultiSurface);
			target.setLod3MultiSurface(multiSurfaceProp);
			
		}
		byte[] lod4MultiSurfaceWKB = vo.getLod4MultiSurface();
		if(lod4MultiSurfaceWKB != null) {
			STMultiSurface lod4MultiSurface = (STMultiSurface) parser.parseWKB(lod4MultiSurfaceWKB);
			MultiSurfacePropertyType multiSurfaceProp = VOJAXBConvertUtil.createMultiSurfacePropertyType(lod4MultiSurface);
			target.setLod4MultiSurface(multiSurfaceProp);
		}
		
		//TODO
		/*
		ImplicitRepresentationPropertyType lod3ImplicitRepresentation;
	    ImplicitRepresentationPropertyType lod4ImplicitRepresentation;
	    */
		
		//TODO : add AddressType
		if(target instanceof DoorType) {
			
		}
		
		JAXBElement<? extends AbstractOpeningType> jOpening = null;
		if(target instanceof DoorType) {
			jOpening = bldgOf.createDoor((DoorType) target);
		} else if(target instanceof WindowType) {
			jOpening = bldgOf.createWindow((WindowType) target);
		} else {
			throw new UnsupportedOperationException();
		}
		
		return jOpening;
	}
}
