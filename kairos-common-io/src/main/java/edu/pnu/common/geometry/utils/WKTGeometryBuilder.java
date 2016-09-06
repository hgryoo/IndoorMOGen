/**
 * 
 */
package edu.pnu.common.geometry.utils;

import edu.pnu.common.geometry.model.STPoint;

/**
 * @author hgryoo
 *
 */
public class WKTGeometryBuilder {
	
	public static String createPoint(STPoint point) {
		String WKT = point.geometryType();
		if(point.is3D()) {
			WKT += "Z";
		}
		if(point.isMeasured()) {
			WKT += "M";
		}
		WKT += "(" + point.asText() + ")";
		return WKT;
	}
	
	
}
