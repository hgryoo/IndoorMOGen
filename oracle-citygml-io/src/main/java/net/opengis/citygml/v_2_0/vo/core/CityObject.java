package net.opengis.citygml.v_2_0.vo.core;

import java.util.Date;

public class CityObject {
	private Integer id;
	private String cityObjectType;
	private String gmlId;
	private String name;
	private String nameCodeSpace;
	private String description;
	private Date creationDate;
	private Date terminationDate;
	private String relativeToTerrain;
	private String relativeToWater;
	
	/**
	 * @return the cityObjectType
	 */
	public String getCityObjectType() {
		return cityObjectType;
	}
	/**
	 * @param cityObjectType the cityObjectType to set
	 */
	public void setCityObjectType(String cityObjectType) {
		this.cityObjectType = cityObjectType;
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
	 * @return the gmlId
	 */
	public String getGmlId() {
		return gmlId;
	}
	/**
	 * @param gmlId the gmlId to set
	 */
	public void setGmlId(String gmlId) {
		this.gmlId = gmlId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the nameCodeSpace
	 */
	public String getNameCodeSpace() {
		return nameCodeSpace;
	}
	/**
	 * @param nameCodeSpace the nameCodeSpace to set
	 */
	public void setNameCodeSpace(String nameCodeSpace) {
		this.nameCodeSpace = nameCodeSpace;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the terminationDate
	 */
	public Date getTerminationDate() {
		return terminationDate;
	}
	/**
	 * @param terminationDate the terminationDate to set
	 */
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	/**
	 * @return the relativeToTerrain
	 */
	public String getRelativeToTerrain() {
		return relativeToTerrain;
	}
	/**
	 * @param relativeToTerrain the relativeToTerrain to set
	 */
	public void setRelativeToTerrain(String relativeToTerrain) {
		this.relativeToTerrain = relativeToTerrain;
	}
	/**
	 * @return the relativeToWater
	 */
	public String getRelativeToWater() {
		return relativeToWater;
	}
	/**
	 * @param relativeToWater the relativeToWater to set
	 */
	public void setRelativeToWater(String relativeToWater) {
		this.relativeToWater = relativeToWater;
	}
	
}
