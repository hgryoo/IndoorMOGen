/**
 * 
 */
package edu.pnu.common.geometry.model;

/**
 * @author hgryoo
 *
 */
public interface STPoint extends STGeometry {
	public Double X();
	public Double Y();
	public Double Z();
	public Double M();
	
	public double[] getcoordinates();
}
