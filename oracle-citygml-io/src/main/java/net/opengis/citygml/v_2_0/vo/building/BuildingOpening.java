/**
 * 
 */
package net.opengis.citygml.v_2_0.vo.building;

import edu.pnu.common.geometry.model.STMultiSurface;
import net.opengis.citygml.v_2_0.vo.core.Address;
import net.opengis.citygml.v_2_0.vo.core.CityObject;
import net.opengis.citygml.v_2_0.vo.core.ImplicitGeometry;

/**
 * @author hgryoo
 *
 */
public class BuildingOpening extends CityObject {
	
	private BuildingBoundary boundary;
	private Address address;
	private String openingType;
	
	private byte[] lod3MultiSurface;
	private byte[] lod4MultiSurface;
	
	private ImplicitGeometry lod3ImplicitRepresentation;
	private ImplicitGeometry lod4ImplicitRepresentation;
	
	public STMultiSurface lod3MultiSurfaceGeometry;
	public STMultiSurface lod4MultiSurfaceGeometry;
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
	 * @return the boundary
	 */
	public BuildingBoundary getBoundary() {
		return boundary;
	}
	/**
	 * @param boundary the boundary to set
	 */
	public void setBoundary(BuildingBoundary boundary) {
		this.boundary = boundary;
	}
	/**
	 * @return the addressId
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the openingType
	 */
	public String getOpeningType() {
		return openingType;
	}
	/**
	 * @param openingType the openingType to set
	 */
	public void setOpeningType(String openingType) {
		this.openingType = openingType;
	}
	
	
	
}
