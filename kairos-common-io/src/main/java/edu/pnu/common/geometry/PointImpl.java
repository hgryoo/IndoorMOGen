/**
 * 
 */
package edu.pnu.common.geometry;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import edu.pnu.common.geometry.model.STPoint;

/**
 * @author hgryoo
 *
 */
public class PointImpl extends GeometryImpl implements STPoint {
	
	protected double[] coordinates;
	
	public PointImpl(double[] coordinates, boolean is3D, boolean isMeasured) {
		super(is3D, isMeasured);
		this.coordinates = coordinates;
	}
	
	/* ============= */
	/* Point methods */
	/* ============= */
	public Double X() {
		return coordinates[0];
	}

	public Double Y() {
		return coordinates[1];
	}

	public Double Z() {
		if(is3D()) {
			return coordinates[2];
		}
		return null;
	}

	public Double M() {
		if(isMeasured()) {
			if(is3D()) {
				return coordinates[3];
			} else {
				return coordinates[2];
			}
		}
		return null;
	}
	
	/* ================ */
	/* Geometry methods */
	/* ================ */
	public int dimension() {
		return 0;
	}
	
	public String geometryType() {
		return "Point";
	}
	
	public String asText() {
		StringBuffer buffer = new StringBuffer();
		for( int i = 0; i < coordinates.length; i++) {
			buffer.append(String.valueOf(coordinates[i]));
			if(i != coordinates.length - 1) buffer.append(" ");
		}
		return buffer.toString();
	}

	public double[] getcoordinates() {
		return coordinates;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coordinates);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointImpl other = (PointImpl) obj;
		if (!Arrays.equals(coordinates, other.coordinates))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PointImpl [coordinates=" + Arrays.toString(coordinates) + "]";
	}
	
	
	
}
