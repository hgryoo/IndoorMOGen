/**
 * 
 */
package edu.pnu.common.geometry.utils;

/**
 * @author hgryoo
 *
 */
public class WKBHeader {
	
	private WKBByteOrder order;
	private WKBTypeCode  type;
	
	public WKBHeader(byte order, int type) {
		
		if(order == 0) {
			this.order = WKBByteOrder.wkbXDR;
		} else {
			this.order = WKBByteOrder.wkbNDR;
		}
		
	}
	
	
}
