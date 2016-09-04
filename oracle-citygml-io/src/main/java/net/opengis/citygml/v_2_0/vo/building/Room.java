/**
 * 
 */
package net.opengis.citygml.v_2_0.vo.building;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.common.geometry.model.STMultiSurface;
import edu.pnu.common.geometry.model.STSolid;
import net.opengis.citygml.v_2_0.vo.core.CityObject;

/**
 * @author hgryoo
 *
 */
public class Room extends CityObject {
	
	private Building building;
	private String clazz;
	private String classCodeSpace;
	private String func;
	private String funcCodeSpace;
	private String usage;
	private String usageCodeSpace;

	private List<RoomInstallation> roomInstallations;
	private List<BuildingBoundary> buildingBoundarys;
	
	private byte[] lod4Solid;
	private byte[] lod4MultiSurface;
	
	public STSolid lod4SolidGeometry;
	public STMultiSurface lod4MultiSurfaceGeometry;
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
	 * @return the roomsInstallations
	 */
	public List<RoomInstallation> getRoomInstallations() {
		if(roomInstallations == null) {
			roomInstallations = new ArrayList<RoomInstallation>();
		}
		return roomInstallations;
	}
	/**
	 * @param roomsInstallations the roomsInstallations to set
	 */
	public void setRoomInstallations(List<RoomInstallation> roomsInstallations) {
		this.roomInstallations = roomsInstallations;
	}
	/**
	 * @return the building
	 */
	public Building getBuilding() {
		return building;
	}
	/**
	 * @param building the building to set
	 */
	public void setBuilding(Building building) {
		this.building = building;
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
	
	
	
	
	
	
}
