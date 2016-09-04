/**
 * 
 */
package net.opengis.citygml.v_2_0.vo.building;

import java.util.ArrayList;
import java.util.List;

import net.opengis.citygml.v_2_0.vo.core.CityObject;
import net.opengis.citygml.v_2_0.vo.core.ImplicitGeometry;

/**
 * @author hgryoo
 *
 */
public class RoomInstallation extends CityObject {
	
	private Integer id;
	private Room room;
	private String clazz;
	private String classCodeSpace;
	private String func;
	private String funcCodeSpace;
	private String usage;
	private String usageCodeSpace;
	private Boolean isMoveable;
	
	private List<BuildingBoundary> buildingBoundarys;
	
	private byte[] lod4Geometry;
	private ImplicitGeometry lod4ImplicitRepresentation;
	
	
	/**
	 * @return the lod4Geometry
	 */
	public byte[] getLod4Geometry() {
		return lod4Geometry;
	}
	/**
	 * @param lod4Geometry the lod4Geometry to set
	 */
	public void setLod4Geometry(byte[] lod4Geometry) {
		this.lod4Geometry = lod4Geometry;
	}
	/**
	 * @return the lod4ImplicitRepresentation
	 */
	public ImplicitGeometry getLod4ImplicitRepresentation() {
		return lod4ImplicitRepresentation;
	}
	/**
	 * @param lod4ImplicitRepresentation the lod4ImplicitRepresentation to set
	 */
	public void setLod4ImplicitRepresentation(ImplicitGeometry lod4ImplicitRepresentation) {
		this.lod4ImplicitRepresentation = lod4ImplicitRepresentation;
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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}
	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
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
	 * @return the isMoveable
	 */
	public Boolean getIsMoveable() {
		return isMoveable;
	}
	/**
	 * @param isMoveable the isMoveable to set
	 */
	public void setIsMoveable(Boolean isMoveable) {
		this.isMoveable = isMoveable;
	}
	
	
	
	
}
