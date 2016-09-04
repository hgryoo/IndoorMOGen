/**
 * 
 */
package net.opengis.citygml.v_2_0.vo.building;

import java.util.Collections;
import java.util.List;

import net.opengis.citygml.v_2_0.vo.core.CityObject;
import net.opengis.citygml.v_2_0.vo.core.ImplicitGeometry;

/**
 * @author hgryoo
 *
 */
public class BuildingInstallation extends CityObject {
	
	private Building building;
	
	private String clazz;
	private String classCodeSpace;
	private String func;
	private String funcCodeSpace;
	private String usage;
	private String usageCodeSpace;
	private Boolean isInterior;
	private List<BuildingBoundary> buildingBoundarys;
	
	private byte[] lod2Geometry;
	private byte[] lod3Geometry;
	private byte[] lod4Geometry;
	
	private ImplicitGeometry lod2ImplicitRepresentation;
	private ImplicitGeometry lod3ImplicitRepresentation;
	private ImplicitGeometry lod4ImplicitRepresentation;
	
	/**
	 * @return the lod2Geometry
	 */
	public byte[] getLod2Geometry() {
		return lod2Geometry;
	}
	/**
	 * @param lod2Geometry the lod2Geometry to set
	 */
	public void setLod2Geometry(byte[] lod2Geometry) {
		this.lod2Geometry = lod2Geometry;
	}
	/**
	 * @return the lod3Geometry
	 */
	public byte[] getLod3Geometry() {
		return lod3Geometry;
	}
	/**
	 * @param lod3Geometry the lod3Geometry to set
	 */
	public void setLod3Geometry(byte[] lod3Geometry) {
		this.lod3Geometry = lod3Geometry;
	}
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
	 * @return the lod2ImplicitRepresentation
	 */
	public ImplicitGeometry getLod2ImplicitRepresentation() {
		return lod2ImplicitRepresentation;
	}
	/**
	 * @param lod2ImplicitRepresentation the lod2ImplicitRepresentation to set
	 */
	public void setLod2ImplicitRepresentation(ImplicitGeometry lod2ImplicitRepresentation) {
		this.lod2ImplicitRepresentation = lod2ImplicitRepresentation;
	}
	/**
	 * @return the lod3ImplicitRepresentation
	 */
	public ImplicitGeometry getLod3ImplicitRepresentation() {
		return lod3ImplicitRepresentation;
	}
	/**
	 * @param lod3ImplicitRepresentation the lod3ImplicitRepresentation to set
	 */
	public void setLod3ImplicitRepresentation(ImplicitGeometry lod3ImplicitRepresentation) {
		this.lod3ImplicitRepresentation = lod3ImplicitRepresentation;
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
			return Collections.emptyList();
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
	/**
	 * @return the isInterior
	 */
	public Boolean getIsInterior() {
		return isInterior;
	}
	/**
	 * @param isInterior the isInterior to set
	 */
	public void setIsInterior(Boolean isInterior) {
		this.isInterior = isInterior;
	}
	
	
	
	
}
