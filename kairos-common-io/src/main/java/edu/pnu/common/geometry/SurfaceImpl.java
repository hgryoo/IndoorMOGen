/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.model.STSurface;

/**
 * @author hgryoo
 *
 */
public abstract class SurfaceImpl extends GeometryImpl implements STSurface {

	public SurfaceImpl(boolean is3d, boolean isMeasured) {
		super(is3d, isMeasured);
	}
	
	public int dimension() {
		return 2;
	}

	public Double area() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public STPoint centroid() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public STPoint pointOnSurface() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	
}
