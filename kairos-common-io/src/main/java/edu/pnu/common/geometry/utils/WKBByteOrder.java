/**
 * 
 */
package edu.pnu.common.geometry.utils;

import java.io.Serializable;
import java.nio.ByteOrder;

/**
 * @author hgryoo
 *
 */
public enum WKBByteOrder implements Serializable {

	wkbXDR((byte) 0),
	wkbNDR((byte) 1);
	
	private final byte order;
	
	private WKBByteOrder(byte order) {
		this.order = order;
	}

	public byte getOrder() {
		return order;
	}
	
    public static WKBByteOrder fromValue(byte value) {
        for (WKBByteOrder order: WKBByteOrder.values()) {
            if (order.getOrder() == value) {
                return order;
            }
        }
        throw new IllegalArgumentException(Integer.toString(value));
    }
    
    public ByteOrder getByteOrder() {
    	if(this.order == WKBByteOrder.wkbXDR.getOrder()) {
    		return ByteOrder.BIG_ENDIAN;
    	} else {
    		return ByteOrder.LITTLE_ENDIAN;
    	}
    }
}