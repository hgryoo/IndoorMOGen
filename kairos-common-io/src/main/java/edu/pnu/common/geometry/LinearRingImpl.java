/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STPoint;

/**
 * @author hgryoo
 *
 */
public class LinearRingImpl extends LineStringImpl {
	
	public LinearRingImpl(STPoint[] points, boolean is3d, boolean isMeasured) {
		super(points, is3d, isMeasured);
	}
	
	/* ================== */
	/* LinearRing methods */
	/* ================== */
	@Override
	public boolean isRing() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
