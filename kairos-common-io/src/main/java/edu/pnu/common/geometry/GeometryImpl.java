/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.utils.WKBGeometryBuilder;

/**
 * @author ryoo
 *
 */
public abstract class GeometryImpl implements STGeometry {
	
	protected boolean is3D;
	protected boolean isMeasured;
	
	public GeometryImpl(boolean is3D, boolean isMeasured) {
		this.is3D = is3D;
		this.isMeasured = isMeasured;
	}
	
	/* ================ */
	/* Geometry methods */
	/* ================ */

	public boolean is3D() {
		// TODO Auto-generated method stub
		return is3D;
	}

	public boolean isMeasured() {
		// TODO Auto-generated method stub
		return isMeasured;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}

	/* =================== */
	/* Unsupported methods */
	/* =================== */

	public int coordinateDimension() {
		if(is3D()) {
			return 3;
		}
		else {
			return 2;
		}
	}

	public int spatialDimension() {
		throw new UnsupportedOperationException();
	}

	public int SRID() {
		throw new UnsupportedOperationException();
	}

	public STGeometry envelope() {
		throw new UnsupportedOperationException();
	}

	public boolean isSimple() {
		throw new UnsupportedOperationException();
	}
	
	public STGeometry boundary() {
		throw new UnsupportedOperationException();
	}

	public byte[] asBinary(WKBGeometryBuilder builder) {
		return builder.asBinary(this);
	}
	
	
	
}
