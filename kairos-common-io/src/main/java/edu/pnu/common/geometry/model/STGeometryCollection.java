/**
 * 
 */
package edu.pnu.common.geometry.model;

/**
 * @author hgryoo
 *
 */
public interface STGeometryCollection extends STGeometry {
	public int numGeometries();
	public STGeometry geometryN(int n);
}
