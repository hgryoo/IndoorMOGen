/**
 * 
 */
package net.opengis.citygml.v_2_0.vo.building;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.common.geometry.model.STMultiCurve;
import edu.pnu.common.geometry.model.STMultiSurface;
import edu.pnu.common.geometry.model.STSolid;
import net.opengis.citygml.v_2_0.vo.core.Address;
import net.opengis.citygml.v_2_0.vo.core.CityObject;

/**
 * @author hgryoo
 *
 */
public class Building extends CityObject {
	
	private Building parent;
	
	/* Attributes */
	private String clazz;
	private String classCodeSpace;
	private String func;
	private String funcCodeSpace;
	private String usage;
	private String usageCodeSpace;
	private Integer yearOfConstruction;
	private Integer yearOfDemolition;
	private String roofType;
	private String roofTypeCodeSpace;
	private Double measuredHeight;
	private String measuredHeightUnit;
	
	private Integer storeysAboveGround;
	private Integer storeysBelowGround;
	private String storeyHeightsAboveGround;
	private String storeyHeightsAboveUnit;
	private String storeyHeightsBelowGround;
	private String storeyHeightsBelowUnit;
	
	private List<Room> rooms;
	private List<BuildingInstallation> buildingInstallations;
	private List<BuildingBoundary> buildingBoundarys;
	private List<Building> buildingParts;
	
	private Address address;
	
	/* Geometries */
	private byte[] lod1Solid;
	private byte[] lod2Solid;
	private byte[] lod3Solid;
	private byte[] lod4Solid;
	
	private byte[] lod1MultiSurface;
	private byte[] lod2MultiSurface;
	private byte[] lod3MultiSurface;
	private byte[] lod4MultiSurface;
	
	private byte[] lod2MultiCurve;
	private byte[] lod3MultiCurve;
	private byte[] lod4MultiCurve;
	
	private byte[] lod1TerrainIntersection;
	private byte[] lod2TerrainIntersection;
	private byte[] lod3TerrainIntersection;
	private byte[] lod4TerrainIntersection;
	
	private byte[] lod0FootPrint;
	private byte[] lod0RoofEdge;
	
	public STSolid lod1SolidGeometry;
	public STSolid lod2SolidGeometry;
	public STSolid lod3SolidGeometry;
	public STSolid lod4SolidGeometry;
	
	public STMultiSurface lod1MultiSurfaceGeometry;
	public STMultiSurface lod2MultiSurfaceGeometry;
	public STMultiSurface lod3MultiSurfaceGeometry;
	public STMultiSurface lod4MultiSurfaceGeometry;
	
	public STMultiSurface lod0FootPrintGeometry;
	public STMultiSurface lod0RoofEdgeGeometry;
	/**
	 * @return the lod1Solid
	 */
	public byte[] getLod1Solid() {
		return lod1Solid;
	}
	/**
	 * @param lod1Solid the lod1Solid to set
	 */
	public void setLod1Solid(byte[] lod1Solid) {
		this.lod1Solid = lod1Solid;
	}
	/**
	 * @return the lod2Solid
	 */
	public byte[] getLod2Solid() {
		return lod2Solid;
	}
	/**
	 * @param lod2Solid the lod2Solid to set
	 */
	public void setLod2Solid(byte[] lod2Solid) {
		this.lod2Solid = lod2Solid;
	}
	/**
	 * @return the lod3Solid
	 */
	public byte[] getLod3Solid() {
		return lod3Solid;
	}
	/**
	 * @param lod3Solid the lod3Solid to set
	 */
	public void setLod3Solid(byte[] lod3Solid) {
		this.lod3Solid = lod3Solid;
	}
	/**
	 * @return the lod4Solid
	 */
	public byte[] getLod4Solid() {
		return lod4Solid;
	}
	/**
	 * @param lod4Solid the lod4Solid to set
	 */
	public void setLod4Solid(byte[] lod4Solid) {
		this.lod4Solid = lod4Solid;
	}
	/**
	 * @return the lod1MultiSurface
	 */
	public byte[] getLod1MultiSurface() {
		return lod1MultiSurface;
	}
	/**
	 * @param lod1MultiSurface the lod1MultiSurface to set
	 */
	public void setLod1MultiSurface(byte[] lod1MultiSurface) {
		this.lod1MultiSurface = lod1MultiSurface;
	}
	/**
	 * @return the lod2MultiSurface
	 */
	public byte[] getLod2MultiSurface() {
		return lod2MultiSurface;
	}
	/**
	 * @param lod2MultiSurface the lod2MultiSurface to set
	 */
	public void setLod2MultiSurface(byte[] lod2MultiSurface) {
		this.lod2MultiSurface = lod2MultiSurface;
	}
	/**
	 * @return the lod3MultiSurface
	 */
	public byte[] getLod3MultiSurface() {
		return lod3MultiSurface;
	}
	/**
	 * @param lod3MultiSurface the lod3MultiSurface to set
	 */
	public void setLod3MultiSurface(byte[] lod3MultiSurface) {
		this.lod3MultiSurface = lod3MultiSurface;
	}
	/**
	 * @return the lod4MultiSurface
	 */
	public byte[] getLod4MultiSurface() {
		return lod4MultiSurface;
	}
	/**
	 * @param lod4MultiSurface the lod4MultiSurface to set
	 */
	public void setLod4MultiSurface(byte[] lod4MultiSurface) {
		this.lod4MultiSurface = lod4MultiSurface;
	}
	/**
	 * @return the lod2MultiCurve
	 */
	public byte[] getLod2MultiCurve() {
		return lod2MultiCurve;
	}
	/**
	 * @param lod2MultiCurve the lod2MultiCurve to set
	 */
	public void setLod2MultiCurve(byte[] lod2MultiCurve) {
		this.lod2MultiCurve = lod2MultiCurve;
	}
	/**
	 * @return the lod3MultiCurve
	 */
	public byte[] getLod3MultiCurve() {
		return lod3MultiCurve;
	}
	/**
	 * @param lod3MultiCurve the lod3MultiCurve to set
	 */
	public void setLod3MultiCurve(byte[] lod3MultiCurve) {
		this.lod3MultiCurve = lod3MultiCurve;
	}
	/**
	 * @return the lod4MultiCurve
	 */
	public byte[] getLod4MultiCurve() {
		return lod4MultiCurve;
	}
	/**
	 * @param lod4MultiCurve the lod4MultiCurve to set
	 */
	public void setLod4MultiCurve(byte[] lod4MultiCurve) {
		this.lod4MultiCurve = lod4MultiCurve;
	}
	/**
	 * @return the lod1TerrainIntersection
	 */
	public byte[] getLod1TerrainIntersection() {
		return lod1TerrainIntersection;
	}
	/**
	 * @param lod1TerrainIntersection the lod1TerrainIntersection to set
	 */
	public void setLod1TerrainIntersection(byte[] lod1TerrainIntersection) {
		this.lod1TerrainIntersection = lod1TerrainIntersection;
	}
	/**
	 * @return the lod2TerrainIntersection
	 */
	public byte[] getLod2TerrainIntersection() {
		return lod2TerrainIntersection;
	}
	/**
	 * @param lod2TerrainIntersection the lod2TerrainIntersection to set
	 */
	public void setLod2TerrainIntersection(byte[] lod2TerrainIntersection) {
		this.lod2TerrainIntersection = lod2TerrainIntersection;
	}
	/**
	 * @return the lod3TerrainIntersection
	 */
	public byte[] getLod3TerrainIntersection() {
		return lod3TerrainIntersection;
	}
	/**
	 * @param lod3TerrainIntersection the lod3TerrainIntersection to set
	 */
	public void setLod3TerrainIntersection(byte[] lod3TerrainIntersection) {
		this.lod3TerrainIntersection = lod3TerrainIntersection;
	}
	/**
	 * @return the lod4TerrainIntersection
	 */
	public byte[] getLod4TerrainIntersection() {
		return lod4TerrainIntersection;
	}
	/**
	 * @param lod4TerrainIntersection the lod4TerrainIntersection to set
	 */
	public void setLod4TerrainIntersection(byte[] lod4TerrainIntersection) {
		this.lod4TerrainIntersection = lod4TerrainIntersection;
	}
	/**
	 * @return the lod0FootPrint
	 */
	public byte[] getLod0FootPrint() {
		return lod0FootPrint;
	}
	/**
	 * @param lod0FootPrint the lod0FootPrint to set
	 */
	public void setLod0FootPrint(byte[] lod0FootPrint) {
		this.lod0FootPrint = lod0FootPrint;
	}
	/**
	 * @return the lod0RoofEdge
	 */
	public byte[] getLod0RoofEdge() {
		return lod0RoofEdge;
	}
	/**
	 * @param lod0RoofEdge the lod0RoofEdge to set
	 */
	public void setLod0RoofEdge(byte[] lod0RoofEdge) {
		this.lod0RoofEdge = lod0RoofEdge;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * @return the buildingParts
	 */
	public List<Building> getBuildingParts() {
		if(buildingParts == null) {
			buildingParts = new ArrayList<Building>();
		}
		return buildingParts;
	}
	/**
	 * @param buildingParts the buildingParts to set
	 */
	public void setBuildingParts(List<Building> buildingParts) {
		this.buildingParts = buildingParts;
	}
	/**
	 * @return the buildingBoundarys
	 */
	public List<BuildingBoundary> getBuildingBoundarys() {
		if(buildingBoundarys == null) {
			buildingBoundarys = new ArrayList<BuildingBoundary>();
		}
		return buildingBoundarys;
	}
	/**
	 * @param buildingBoundarys the buildingBoundarys to set
	 */
	public void setBuildingBoundarys(List<BuildingBoundary> buildingBoundarys) {
		this.buildingBoundarys = buildingBoundarys;
	}
	
	/**
	 * @return the buildingInstallations
	 */
	public List<BuildingInstallation> getBuildingInstallations() {
		if(buildingInstallations == null) {
			buildingInstallations = new ArrayList<BuildingInstallation>();
		}
		return buildingInstallations;
	}
	/**
	 * @param buildingInstallations the buildingInstallations to set
	 */
	public void setBuildingInstallations(List<BuildingInstallation> buildingInstallations) {
		this.buildingInstallations = buildingInstallations;
	}
	
	/**
	 * @return the rooms
	 */
	public List<Room> getRooms() {
		if(rooms == null) {
			rooms = new ArrayList<Room>();
		}
		return rooms;
	}
	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	/**
	 * @return the parent
	 */
	public Building getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(Building parent) {
		this.parent = parent;
	}
	/**
	 * @return the clazz
	 */
	public String getClazz() {
		return clazz;
	}
	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	/**
	 * @return the classCodeSpace
	 */
	public String getClassCodeSpace() {
		return classCodeSpace;
	}
	/**
	 * @param classCodeSpace the classCodeSpace to set
	 */
	public void setClassCodeSpace(String classCodeSpace) {
		this.classCodeSpace = classCodeSpace;
	}
	/**
	 * @return the func
	 */
	public String getFunc() {
		return func;
	}
	/**
	 * @param func the func to set
	 */
	public void setFunc(String func) {
		this.func = func;
	}
	/**
	 * @return the funcCodeSpace
	 */
	public String getFuncCodeSpace() {
		return funcCodeSpace;
	}
	/**
	 * @param funcCodeSpace the funcCodeSpace to set
	 */
	public void setFuncCodeSpace(String funcCodeSpace) {
		this.funcCodeSpace = funcCodeSpace;
	}
	/**
	 * @return the usage
	 */
	public String getUsage() {
		return usage;
	}
	/**
	 * @param usage the usage to set
	 */
	public void setUsage(String usage) {
		this.usage = usage;
	}
	/**
	 * @return the usageCodeSpace
	 */
	public String getUsageCodeSpace() {
		return usageCodeSpace;
	}
	/**
	 * @param usageCodeSpace the usageCodeSpace to set
	 */
	public void setUsageCodeSpace(String usageCodeSpace) {
		this.usageCodeSpace = usageCodeSpace;
	}
	/**
	 * @return the yearOfConstruction
	 */
	public Integer getYearOfConstruction() {
		return yearOfConstruction;
	}
	/**
	 * @param yearOfConstruction the yearOfConstruction to set
	 */
	public void setYearOfConstruction(Integer yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
	}
	/**
	 * @return the yearOfDemolition
	 */
	public Integer getYearOfDemolition() {
		return yearOfDemolition;
	}
	/**
	 * @param yearOfDemolition the yearOfDemolition to set
	 */
	public void setYearOfDemolition(Integer yearOfDemolition) {
		this.yearOfDemolition = yearOfDemolition;
	}
	/**
	 * @return the roofType
	 */
	public String getRoofType() {
		return roofType;
	}
	/**
	 * @param roofType the roofType to set
	 */
	public void setRoofType(String roofType) {
		this.roofType = roofType;
	}
	/**
	 * @return the roofTypeCodeSpace
	 */
	public String getRoofTypeCodeSpace() {
		return roofTypeCodeSpace;
	}
	/**
	 * @param roofTypeCodeSpace the roofTypeCodeSpace to set
	 */
	public void setRoofTypeCodeSpace(String roofTypeCodeSpace) {
		this.roofTypeCodeSpace = roofTypeCodeSpace;
	}
	/**
	 * @return the measuredHeight
	 */
	public Double getMeasuredHeight() {
		return measuredHeight;
	}
	/**
	 * @param measuredHeight the measuredHeight to set
	 */
	public void setMeasuredHeight(Double measuredHeight) {
		this.measuredHeight = measuredHeight;
	}
	/**
	 * @return the measuredHeightUnit
	 */
	public String getMeasuredHeightUnit() {
		return measuredHeightUnit;
	}
	/**
	 * @param measuredHeightUnit the measuredHeightUnit to set
	 */
	public void setMeasuredHeightUnit(String measuredHeightUnit) {
		this.measuredHeightUnit = measuredHeightUnit;
	}
	/**
	 * @return the storeysAboveGround
	 */
	public Integer getStoreysAboveGround() {
		return storeysAboveGround;
	}
	/**
	 * @param storeysAboveGround the storeysAboveGround to set
	 */
	public void setStoreysAboveGround(Integer storeysAboveGround) {
		this.storeysAboveGround = storeysAboveGround;
	}
	/**
	 * @return the storeysBelowGround
	 */
	public Integer getStoreysBelowGround() {
		return storeysBelowGround;
	}
	/**
	 * @param storeysBelowGround the storeysBelowGround to set
	 */
	public void setStoreysBelowGround(Integer storeysBelowGround) {
		this.storeysBelowGround = storeysBelowGround;
	}
	/**
	 * @return the storeyHeightsAboveGround
	 */
	public String getStoreyHeightsAboveGround() {
		return storeyHeightsAboveGround;
	}
	/**
	 * @param storeyHeightsAboveGround the storeyHeightsAboveGround to set
	 */
	public void setStoreyHeightsAboveGround(String storeyHeightsAboveGround) {
		this.storeyHeightsAboveGround = storeyHeightsAboveGround;
	}
	/**
	 * @return the storeyHeightsAboveUnit
	 */
	public String getStoreyHeightsAboveUnit() {
		return storeyHeightsAboveUnit;
	}
	/**
	 * @param storeyHeightsAboveUnit the storeyHeightsAboveUnit to set
	 */
	public void setStoreyHeightsAboveUnit(String storeyHeightsAboveUnit) {
		this.storeyHeightsAboveUnit = storeyHeightsAboveUnit;
	}
	/**
	 * @return the storeyHeightsBelowGround
	 */
	public String getStoreyHeightsBelowGround() {
		return storeyHeightsBelowGround;
	}
	/**
	 * @param storeyHeightsBelowGround the storeyHeightsBelowGround to set
	 */
	public void setStoreyHeightsBelowGround(String storeyHeightsBelowGround) {
		this.storeyHeightsBelowGround = storeyHeightsBelowGround;
	}
	/**
	 * @return the storeyHeightsBelowUnit
	 */
	public String getStoreyHeightsBelowUnit() {
		return storeyHeightsBelowUnit;
	}
	/**
	 * @param storeyHeightsBelowUnit the storeyHeightsBelowUnit to set
	 */
	public void setStoreyHeightsBelowUnit(String storeyHeightsBelowUnit) {
		this.storeyHeightsBelowUnit = storeyHeightsBelowUnit;
	}
	
	
	
}
