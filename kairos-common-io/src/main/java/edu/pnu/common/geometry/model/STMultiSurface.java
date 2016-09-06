/**
 * 
 */
package edu.pnu.common.geometry.model;

/**
 * @author hgryoo
 *
 */
public interface STMultiSurface extends STGeometryCollection {
	public Double area();
	public STPoint centroid();
	public STPoint pointOnSurface();
	
	public STSurface[] getSurfaces();
}
