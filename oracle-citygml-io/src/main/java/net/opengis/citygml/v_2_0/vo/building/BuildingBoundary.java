/**
 * 
 */
package net.opengis.citygml.v_2_0.vo.building;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.common.geometry.model.STMultiSurface;
import net.opengis.citygml.v_2_0.vo.core.CityObject;

/**
 * @author hgryoo
 *
 */
public class BuildingBoundary extends CityObject {
	
	private String boundaryType;
	private Building building;
	private Room room;
	private BuildingInstallation buildingInstallation;
	private RoomInstallation roomInstallation;
	
	private List<BuildingOpening> openings;
	
	private byte[] lod2MultiSurface;
	private byte[] lod3MultiSurface;
	private byte[] lod4MultiSurface;
	
	public STMultiSurface lod2MultiSurfaceGeometry;
	public STMultiSurface lod3MultiSurfaceGeometry;
	public STMultiSurface lod4MultiSurfaceGeometry;
		
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
	 * @return the openings
	 */
	public List<BuildingOpening> getOpenings() {
		if(openings == null) {
			openings = new ArrayList<BuildingOpening>();
		}
		return openings;
	}
	/**
	 * @param openings the openings to set
	 */
	public void setOpenings(List<BuildingOpening> openings) {
		this.openings = openings;
	}
	/**
	 * @return the type
	 */
	public String getBoundaryType() {
		return boundaryType;
	}
	/**
	 * @param type the type to set
	 */
	public void setBoundaryType(String boundaryType) {
		this.boundaryType = boundaryType;
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
	 * @return the buildingInstallation
	 */
	public BuildingInstallation getBuildingInstallation() {
		return buildingInstallation;
	}
	/**
	 * @param buildingInstallation the buildingInstallation to set
	 */
	public void setBuildingInstallation(BuildingInstallation buildingInstallation) {
		this.buildingInstallation = buildingInstallation;
	}
	/**
	 * @return the roomInstallation
	 */
	public RoomInstallation getRoomInstallation() {
		return roomInstallation;
	}
	/**
	 * @param roomInstallation the roomInstallation to set
	 */
	public void setRoomInstallation(RoomInstallation roomInstallation) {
		this.roomInstallation = roomInstallation;
	}
	
}
