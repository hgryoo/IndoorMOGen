/**
 * 
 */
package edu.pnu.common.geometry;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import edu.pnu.common.geometry.model.STLineString;
import edu.pnu.common.geometry.model.STPolygon;

/**
 * @author hgryoo
 *
 */
public class PolygonImpl extends SurfaceImpl implements STPolygon {
	
	private STLineString exterior;
	private STLineString[] interior;
	
	public PolygonImpl(STLineString exterior, STLineString[] interior, boolean is3d, boolean isMeasured) {
		super(is3d, isMeasured);
		this.exterior = exterior;
		this.interior = interior;
	}

	/* =============== */
	/* Polygon methods */
	/* =============== */
	public STLineString exteriorRing() {
		return exterior;
	}

	public Integer numInteriorRing() {
		int length = 0;
		if(interior != null) {
			length = interior.length;
		}
		return length;
	}
	
	public STLineString interiorRingN(int idx) {
		return interior[idx];
	}

	/* ================ */
	/* Geometry methods */
	/* ================ */
	public String asText() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(exterior.asText());
		
		for( int i = 0; i < numInteriorRing(); i++) {
			buffer.append(",");
			buffer.append(interior[i].asText());
		}
		return buffer.toString();
	}

	public String geometryType() {
		// TODO Auto-generated method stub
		return "Polygon";
	}

}
