/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STLineString;
import edu.pnu.common.geometry.model.STTriangle;

/**
 * @author hgryoo
 *
 */
public class TriangleImpl extends PolygonImpl implements STTriangle {

	public TriangleImpl(STLineString exterior, boolean is3d, boolean isMeasured) {
		super(exterior, null, is3d, isMeasured);
	}

	@Override
	public String geometryType() {
		// TODO Auto-generated method stub
		return "Triangle";
	}
	
	
}
