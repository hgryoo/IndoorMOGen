/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STMultiSurface;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.model.STSurface;

/**
 * @author hgryoo
 *
 */
public class MultiSurfaceImpl extends GeometryCollectionImpl implements STMultiSurface {

	public MultiSurfaceImpl(STSurface[] geometries, boolean is3d, boolean isMeasured) {
		super(geometries, is3d, isMeasured);
		// TODO Auto-generated constructor stub
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

	public STSurface[] getSurfaces() {
		// TODO Auto-generated method stub
		return (STSurface[]) geometries;
	}

	@Override
	public String geometryType() {
		// TODO Auto-generated method stub
		return "MultiSurface";
	}
		
}
