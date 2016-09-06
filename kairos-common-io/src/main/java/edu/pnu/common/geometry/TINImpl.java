/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STPolygon;
import edu.pnu.common.geometry.model.STTIN;
import edu.pnu.common.geometry.model.STTriangle;

/**
 * @author hgryoo
 *
 */
public class TINImpl extends PolyhedralSurfaceImpl implements STTIN {

	public TINImpl(STTriangle[] triangles, boolean is3d, boolean isMeasured) {
		super(triangles, is3d, isMeasured);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String geometryType() {
		// TODO Auto-generated method stub
		return "TIN";
	}

	/* ========================= */
	/* TIN methods */
	/* ========================= */
	public STTriangle PatchN(int idx) {
		return (STTriangle) super.PatchN(idx);
	}
	
	
}
