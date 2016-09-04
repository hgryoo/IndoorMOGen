package net.opengis.citygml.v_2_0.vo.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.opengis.citygml.v_2_0.vo.spatial.Envelope;

public class CityModel {
	
	private Integer id;
	private String gmlId;
	private String name;
	private String nameCodeSpace;
	private String description;
	private Envelope envelope;
	private ArrayList<CityObject> cityObjects;
	
	/* user-defined Id */
	private String sId;
	/**
	 * @return the sId
	 */
	public String getsId() {
		return sId;
	}
	/**
	 * @param sId the sId to set
	 */
	public void setsId(String sId) {
		this.sId = sId;
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
	 * @return the nameCodespace
	 */
	public String getNameCodeSpace() {
		return nameCodeSpace;
	}
	/**
	 * @param nameCodespace the nameCodespace to set
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
	 * @return the envelopeId
	 */
	public Envelope getEnvelope() {
		return envelope;
	}
	/**
	 * @param envelopeId the envelopeId to set
	 */
	public void setEnvelope(Envelope envelope) {
		this.envelope = envelope;
	}

	/**
	 * @return the cityObjects
	 */
	public ArrayList<CityObject> getCityObjects() {
		if(cityObjects == null) {
			cityObjects = new ArrayList<CityObject>();
		}
		return cityObjects;
	}
	/**
	 * @param cityObjects the cityObjects to set
	 */
	public void setCityObjects(ArrayList<CityObject> cityObjects) {
		this.cityObjects = cityObjects;
	}
}
