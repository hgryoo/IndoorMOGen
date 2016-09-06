package kr.co.realtimetech.kairos.geometry;

import edu.pnu.common.geometry.model.STGeometry;


public interface MGeometry extends STGeometry {
	
	public String geometryType();
	
	public String asText();
	public byte[] asBinary();

}
