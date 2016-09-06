/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STCurve;

/**
 * @author hgryoo
 *
 */
public abstract class CurveImpl extends GeometryImpl implements STCurve {

	public CurveImpl(boolean is3d, boolean isMeasured) {
		super(is3d, isMeasured);
	}

	/* ================ */
	/* Geometry methods */
	/* ================ */
	public int dimension() {
		return 1;
	}
	
	/* =================== */
	/* Unsupported methods */
	/* =================== */

	public Double length() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
