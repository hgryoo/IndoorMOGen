/**
 * 
 */
package edu.pnu.common.geometry.model;

/**
 * @author hgryoo
 *
 */
public interface STPolyhedralSurface extends STSurface {
	public Integer numPatches();
	public STPolygon PatchN(int idx);
	public STMultiPolygon boundingPolygons(STPolygon p);
	public boolean isClosed();
}
