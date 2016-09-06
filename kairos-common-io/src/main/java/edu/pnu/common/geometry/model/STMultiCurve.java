/**
 * 
 */
package edu.pnu.common.geometry.model;

/**
 * @author hgryoo
 *
 */
public interface STMultiCurve extends STGeometryCollection {
	public boolean isClosed();
	
	/*public Distance length() */
	public Double length();
}
