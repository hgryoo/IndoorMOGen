/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STCurve;
import edu.pnu.common.geometry.model.STMultiCurve;

/**
 * @author hgryoo
 *
 */
public class MultiCurveImpl extends GeometryCollectionImpl implements STMultiCurve {

	public MultiCurveImpl(STCurve[] curves, boolean is3d, boolean isMeasured) {
		super(curves, is3d, isMeasured);
		// TODO Auto-generated constructor stub
	}

	public boolean isClosed() {
		return geometryN(0).equals(geometryN(numGeometries()));
	}

	public Double length() {
		double len = 0;
		for(int i = 0; i < numGeometries(); i++) {
			STCurve curve = (STCurve) geometryN(i);
			len += curve.length();
		}
		return len;
	}

	@Override
	public String geometryType() {
		// TODO Auto-generated method stub
		return "MultiCurve";
	}
}
