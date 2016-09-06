/**
 * 
 */
package edu.pnu.common.geometry.model;

/**
 * @author hgryoo
 *
 */
public interface STPolygon extends STSurface {
	public STLineString exteriorRing();
	public Integer numInteriorRing();
	public STLineString interiorRingN(int idx);
}
