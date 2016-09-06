/**
 * 
 */
package edu.pnu.common.geometry.model;

import edu.pnu.common.geometry.utils.WKBGeometryBuilder;

/**
 * @author hgryoo
 *
 */
public interface STGeometry {
	
	/**
	 * The inherent dimension of this geometric object, which must be less than or equal
	 * to the coordinate dimension. In non-homogeneous collections, this will return the largest topological
	 * dimension of the contained objects.
	 * @return dimension
	 */
	public int dimension();
	
	public int coordinateDimension();
	public int spatialDimension();
	
	/**
	 * Returns the name of the instantiable subtype of Geometry of which this 
	 * geometric object is an instantiable member. 
	 * The name of the subtype of Geometry is returned as a string.
	 * @return the name of the instantiable subtype of Geometry
	 */
	public String geometryType();
	public int SRID();
	/**
	 * 
	 * @return The minimum bounding box for this Geometry
	 */
	public STGeometry envelope();
	
	/**
	 * Exports this geometric object to a specific Well-known Text Representation of Geometry.
	 * @return well-known text representation of geometry
	 */
	public String asText();
	
	/**
	 * Exports this geometric object to a specific Well-known Binary Representation of Geometry.
	 * @return well-known binary representation of geometry
	 */
	public byte[] asBinary(WKBGeometryBuilder builder);
	
	public boolean isEmpty();
	public boolean isSimple();
	public boolean is3D();
	public boolean isMeasured();
	public STGeometry boundary();
	
	/* TODO define query part */
	
	/* TODO define analysis part */
}
