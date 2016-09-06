/**
 * 
 */
package edu.pnu.common.geometry.model;

/**
 * @author hgryoo
 *
 */
public interface STCurve extends STGeometry {
	public Double length();
	public STPoint startPoint();
	public STPoint endPoint();
	public boolean isClosed();
	public boolean isRing();
}
