/**
 * 
 */
package net.opengis.citygml.v_2_0.dao;

/**
 * @author hgryoo
 *
 */
public class DAO {
	public static final String CityGML_MAPPER_NAMESPACE = "net.opengis.citygml.v_2_0";
	
	
	// byte[] to hex
	public static String byteArrayToHex(final byte[] ba) {
	    if (ba == null || ba.length == 0) {
	        return null;
	    }
	 
	    StringBuffer sb = new StringBuffer(ba.length * 2);
	    String hexNumber;
	    for (int x = 0; x < ba.length; x++) {
	        hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
	 
	        sb.append(hexNumber.substring(hexNumber.length() - 2));
	    }
	    return "0x" + sb.toString();
	} 
	
}
