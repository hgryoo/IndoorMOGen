/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STPolyhedralSurface;
import edu.pnu.common.geometry.model.STSolid;
import edu.pnu.common.geometry.model.STSurface;

/**
 * @author hgryoo
 *
 */
public class SolidImpl extends GeometryImpl implements STSolid {

	private STSurface exterior;
	private STSurface[] interior;
	
	public SolidImpl(STSurface exterior, STSurface[] interior, boolean is3d, boolean isMeasured) {
		super(is3d, isMeasured);
		this.exterior = exterior;
		this.interior = interior;
	}
	
	/* =============== */
	/* Solid methods */
	/* =============== */
	
	public STSurface exteriorShell() {
		return exterior;
	}

	public Integer numInteriorShell() {
		int length = 0;
		if(interior != null) {
			length = interior.length;
		}
		return length;
	}

	public STSurface interiorShellN(int idx) {
		return interior[idx];
	}
	
	/* ================ */
	/* Geometry methods */
	/* ================ */
	
	public int dimension() {
		return 3;
	}

	public String geometryType() {
		return "Solid";
	}

	public String asText() {
		// TODO Auto-generated method stub
		return null;
	}

}
