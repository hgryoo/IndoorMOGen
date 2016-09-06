/**
 * 
 */
package edu.pnu.common.geometry.model;

/**
 * @author hgryoo
 *
 */
public interface STSurface extends STGeometry {
	public Double area();
	public STPoint centroid();
	public STPoint pointOnSurface();
	//public MultiCurve boundary();
}
