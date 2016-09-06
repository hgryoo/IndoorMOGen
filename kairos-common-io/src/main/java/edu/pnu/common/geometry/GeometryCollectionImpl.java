/**
 * 
 */
package edu.pnu.common.geometry;

import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.model.STGeometryCollection;

/**
 * @author hgryoo
 *
 */
public class GeometryCollectionImpl extends GeometryImpl implements STGeometryCollection {
	
	public STGeometry[] geometries;
	
	public GeometryCollectionImpl(STGeometry[] geometries, boolean is3d, boolean isMeasured) {
		super(is3d, isMeasured);
		this.geometries = geometries;
	}

	/* ========================== */
	/* GeometryCollection methods */
	/* ========================== */
	public int numGeometries() {
		return geometries.length;
	}
	
	public STGeometry geometryN(int n) {
		return geometries[n];
	}
	
	/* ================ */
	/* Geometry methods */
	/* ================ */
	public int dimension() {
		int max = 0;
		for(int i = 0; i<numGeometries(); i++) {
			int dim = geometryN(i).dimension();
			if( dim > max ) 
				max = dim;
		}
		return max;
	}
	
	public String asText() {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("(");
		
		if(numGeometries() != 0) buffer.append(geometryN(0).asText());
		
		for( int i = 1; i < numGeometries(); i++) {
			buffer.append(",");
			buffer.append(geometryN(i).asText());
		}
		return buffer.toString();
	}

	public String geometryType() {
		// TODO Auto-generated method stub
		return "GeometryCollection";
	}


}
