/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STMultiPoint;
import edu.pnu.common.geometry.model.STPoint;

/**
 * @author hgryoo
 *
 */
public class MultiPointImpl extends GeometryCollectionImpl implements STMultiPoint {

	public MultiPointImpl(STPoint[] geometries, boolean is3d, boolean isMeasured) {
		super(geometries, is3d, isMeasured);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String geometryType() {
		// TODO Auto-generated method stub
		return "MultiPoint";
	}

	
	
}
