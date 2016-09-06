package edu.pnu.common.geometry;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.Timestamp;

import edu.pnu.common.geometry.model.STPoint;
import kr.co.realtimetech.kairos.geometry.MPoint;

public class MPointImpl extends MGeometryImpl implements MPoint{

	protected Timestamp[] instants;
	private STPoint[] points;
	
	public MPointImpl(Timestamp[] instants, STPoint[] points) {
		this.instants = instants;
		this.points = points;		
	}
	
	public int numInstants() {
		return instants.length;
	}
	
	public Timestamp InstantN(int idx) {
		return instants[idx];
	}
	
	public int numPoints() {
		return points.length;
	}
	
	public STPoint PointN(int idx) {
		return points[idx];
	}

	@Override
	public String geometryType() {
		return "MPoint";
	}

	public String pointAsText(int idx) {
		StringBuffer buffer = new StringBuffer();
		
		double instant = (double) instants[idx].getTime();
		buffer.append(String.valueOf(instant));
		buffer.append(", ");
		buffer.append(String.valueOf(points[idx].X()));
		buffer.append(", ");
		buffer.append(String.valueOf(points[idx].Y()));
		
		return buffer.toString();
	}
	
	@Override
	public String asText() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("(");
		buffer.append(pointAsText(0));
		for( int i = 1; i < numPoints(); i++) {
			buffer.append(",");
			buffer.append(pointAsText(i));
		}
		buffer.append(")");
		return buffer.toString();
	}

	@Override
	public byte[] asBinary() {
		ByteBuffer bb = ByteBuffer.allocate(2 * Integer.SIZE/Byte.SIZE + numInstants() * 3 * (Double.SIZE/Byte.SIZE));
		bb.order(ByteOrder.LITTLE_ENDIAN).putInt(0);
		bb.order(ByteOrder.LITTLE_ENDIAN).putInt(numInstants());
		for(int i = 0; i < numInstants(); i++) {
			bb.order(ByteOrder.LITTLE_ENDIAN).putDouble((double) instants[i].getTime());
			bb.order(ByteOrder.LITTLE_ENDIAN).putDouble(points[i].X());
			bb.order(ByteOrder.LITTLE_ENDIAN).putDouble(points[i].Y());
		}
		return bb.array();

	}

	
}
