/**
 * 
 */
package edu.pnu.common.geometry;

import java.nio.ByteBuffer;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import edu.pnu.common.geometry.model.STLineString;
import edu.pnu.common.geometry.model.STPoint;

/**
 * @author hgryoo
 *
 */
public class LineStringImpl extends CurveImpl implements STLineString {
	
	private STPoint[] points;
	
	public LineStringImpl(STPoint[] points, boolean is3d, boolean isMeasured) {
		super(is3d, isMeasured);
		this.points = points;
	}

	/* ================== */
	/* LineString methods */
	/* ================== */
	public Integer numPoints() {
		return points.length;
	}

	public STPoint PointN(int idx) {
		return points[idx];
	}
	
	public STPoint startPoint() {
		return points[0];
	}

	public STPoint endPoint() {
		return points[numPoints()-1];
	}

	public boolean isClosed() {
		return startPoint().equals(endPoint());
	}
	
	public boolean isRing() {
		return isClosed() && isSimple();
	}
	
	/* ================ */
	/* Geometry methods */
	/* ================ */
	public String geometryType() {
		// TODO Auto-generated method stub
		return "LineString";
	}

	public String asText() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("(");
		buffer.append(startPoint().asText());
		for( int i = 1; i < numPoints(); i++) {
			buffer.append(",");
			buffer.append(PointN(i).asText());
		}
		buffer.append(")");
		return buffer.toString();
	}

	public STLineString reverse() {
		STPoint[] reversedPoint = points.clone();
		ArrayUtils.reverse(reversedPoint);
		
		LineStringImpl reversedLineString = new LineStringImpl(reversedPoint, this.is3D(), this.isMeasured());
		return reversedLineString;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LineStringImpl [points=" + Arrays.toString(points) + "]";
	}
	
	

}
