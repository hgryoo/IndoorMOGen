/**
 * 
 */
package edu.pnu.common.geometry.model;

/**
 * @author hgryoo
 *
 */
public interface STSolid extends STGeometry {
	public STSurface exteriorShell();
	public Integer numInteriorShell();
	public STSurface interiorShellN(int idx);
}
