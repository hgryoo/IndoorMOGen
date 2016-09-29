/**
 * 
 */
package edu.pnu.model;

import com.vividsolutions.jts.geom.Coordinate;

/**
 * @author hgryoo
 *
 */
public interface IndexedSpace {
	CellSpace queryCell(Coordinate c);
}
