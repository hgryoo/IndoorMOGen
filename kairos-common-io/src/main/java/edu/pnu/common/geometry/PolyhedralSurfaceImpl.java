/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STMultiPolygon;
import edu.pnu.common.geometry.model.STPolygon;
import edu.pnu.common.geometry.model.STPolyhedralSurface;

/**
 * @author hgryoo
 *
 */
public class PolyhedralSurfaceImpl extends SurfaceImpl implements STPolyhedralSurface {

	private STPolygon[] patches;
	
	public PolyhedralSurfaceImpl(STPolygon[] patches, boolean is3d, boolean isMeasured) {
		super(is3d, isMeasured);
		this.patches = patches;
	}

	/* ========================= */
	/* PolyhedralSurface methods */
	/* ========================= */
	public Integer numPatches() {
		return patches.length;
	}

	public STPolygon PatchN(int idx) {
		return patches[idx];
	}

	public STMultiPolygon boundingPolygons(STPolygon p) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public boolean isClosed() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	/* ================ */
	/* Geometry methods */
	/* ================ */
	public String asText() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	public String geometryType() {
		// TODO Auto-generated method stub
		return "PolyhedralSurface";
	}

}
