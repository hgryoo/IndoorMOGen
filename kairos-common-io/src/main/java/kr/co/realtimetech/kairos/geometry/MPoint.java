package kr.co.realtimetech.kairos.geometry;

import java.sql.Timestamp;

import edu.pnu.common.geometry.model.STPoint;

public interface MPoint extends MGeometry {

	public int numInstants();
	public Timestamp InstantN(int idx);
	
	public int numPoints();
	public STPoint PointN(int idx);
}
