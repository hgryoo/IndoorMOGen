package net.opengis.citygml.v_2_0.vo.spatial;

import java.sql.Blob;
import java.util.Arrays;

import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.utils.WKBGeometryBuilder;

public class Envelope {
	
	protected Integer id;
	protected Integer srsDimension;
	protected String srsName;
	protected byte[] lowerCorner;
	protected byte[] upperCorner;
	public STPoint lowerCornerGeometry;
	public STPoint upperCornerGeometry;
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
	public void setLowerCorner(byte[] lowerCorner) {
		this.lowerCorner = lowerCorner;
	}
	public void setUpperCorner(byte[] upperCorner) {
		this.upperCorner = upperCorner;
	}
	
	public byte[] getLowerCorner() {
		return lowerCorner;
	}
	public byte[] getUpperCorner() {
		return upperCorner;
	}
	public Integer getSrsDimension() {
		return srsDimension;
	}
	public void setSrsDimension(Integer srsDimension) {
		this.srsDimension = srsDimension;
	}
	public String getSrsName() {
		return srsName;
	}
	public void setSrsName(String srsName) {
		this.srsName = srsName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Envelope [id=" + id + ", srsDimension=" + srsDimension + ", srsName=" + srsName + ", lowerCorner="
				+ Arrays.toString(lowerCorner) + ", upperCorner=" + Arrays.toString(upperCorner) + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Envelope other = (Envelope) obj;
		
		if( id.equals(other.getId())
				&&
			srsName.equals(other.getSrsName())
				&&
			srsDimension.equals(other.getSrsDimension())
			
			//TODO add lowerCorner, upperCorner
		) {
			return true;
		}
		return false;
	}
}
