/**
 * 
 */
package edu.pnu.common.geometry.model;

/**
 * @author hgryoo
 *
 */
public interface STLineString extends STCurve{
	public Integer numPoints();
	public STPoint PointN(int idx);
	
	public STLineString reverse();
}
