/**
 * 
 */
package edu.pnu.common.geometry;

import java.sql.Timestamp;
import java.util.List;

import edu.pnu.common.geometry.model.STLineString;
import edu.pnu.common.geometry.model.STMultiSurface;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.model.STPolygon;
import edu.pnu.common.geometry.model.STSurface;
import kr.co.realtimetech.kairos.geometry.MPoint;

/**
 * @author hgryoo
 *
 */
public class GeometryFactory {

	// TODO Reference System으로 3D, Measured를 표현해야됨
	private boolean is3D;
	private boolean isMeasured;
	
	public GeometryFactory(boolean is3D, boolean isMeasured) {
		this.is3D = is3D;
		this.isMeasured = isMeasured;
	}
	
	protected int getCoordinatesDimension() {
		int size = 2;
		if(is3D) {
			if(isMeasured) {
				size = 4;
			} else {
				size = 3;
			}
		} else {
			if(isMeasured) {
				size = 3;
			} else {
				size = 2;
			}
		}
		return size;
	}
	
	/**
	 * Creates a new Point with the given coordinate array
	 * @param coordinates
	 * @return the Point object
	 */
	public STPoint createPoint(double[] coordinates) {
		int size = getCoordinatesDimension();
		
		STPoint point;
		if(coordinates == null) {
			String msg = "given coordinates are null";
			throw new NullPointerException(msg);
		}
		else if(coordinates.length != size) {
			String msg = "dimension of given coordinates mismatch";
			throw new IllegalArgumentException(msg);
		} else {
			point = new PointImpl(coordinates, is3D, isMeasured);
		}
		return point;
	}
	
	/**
	 * Creates a new Point with the given coordinate List
	 * @param coordinates
	 * @return the Point object
	 */
	public STPoint createPoint(List<Double> coordinates) {
		int coordSize = getCoordinatesDimension();
		STPoint point = null;
		if(coordinates == null) {
			String msg = "given coordinates are null";
			throw new NullPointerException(msg);
		}
		else if(coordinates.size() != coordSize) {
			String msg = "dimension of given coordinates mismatch";
			throw new IllegalArgumentException(msg);
		} else {
			Double[] dwarr = new Double[coordSize];
			coordinates.toArray(dwarr);
			double[] darr = toDoublePrimitive(dwarr);
			point = createPoint(darr);
		}
		return point;
	}
	
	/**
	 * Creates a new LineString with the given point array
	 * @param points
	 * @return the LineString object
	 */
	public STLineString createLineString(STPoint[] points) {
		STLineString lineString = null;
		if(points != null) {
			lineString = new LineStringImpl(points, is3D, isMeasured);
		}
		return lineString;
	}
	
	/**
	 * Creates a new LineString with the given point List
	 * @param points
	 * @return the LineString object
	 */
	public STLineString createLineString(List<STPoint> points) {
		STLineString lineString = null;
		if(points != null) {
			STPoint[] PointArr = new STPoint[points.size()];
			points.toArray(PointArr);
			lineString = createLineString(PointArr);
		}
		return lineString;
	}
	
	
	public STPolygon createPolygon(STLineString exterior, STLineString[] interior) {
		STPolygon polygon = null;
		if(exterior != null) {
			polygon = new PolygonImpl(exterior, interior, is3D, isMeasured);
		}
		return polygon;
	}
	
	public STMultiSurface createMultiSurface(STSurface[] surfaces) {
		STMultiSurface multiSurface = null;
		if(surfaces != null && surfaces.length > 0) {
			multiSurface = new MultiSurfaceImpl(surfaces, is3D, isMeasured);
		}
		return multiSurface;
	}

	/**
	 * Creates a new LinearRing with the given point array
	 * @param points
	 * @return the LinearRing object
	 */
	public STLineString createLinearRing(STPoint[] points) {
		STLineString linearRing = null;
		if(points != null) {
			linearRing = new LinearRingImpl(points, is3D, isMeasured);
		}
		return linearRing;
	}
	
	/**
	 * Creates a new LinearRing with the given point List
	 * @param points
	 * @return the LinearRing object
	 */
	public STLineString createLinearRing(List<STPoint> points) {
		STLineString linearRing = null;
		if(points != null) {
			STPoint[] PointArr = new STPoint[points.size()];
			points.toArray(PointArr);
			linearRing = createLinearRing(PointArr);
		}
		return linearRing;
	}
	
	private static double[] toDoublePrimitive(Double[] array) {
		if (array == null) {
			return null;
		} else if (array.length == 0) {
		    return new double[0];
		}
		final double[] result = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			result[i] = array[i].doubleValue();
		}
		return result;
	}
	

	// for Moving Object
	public MPoint createMPoint(Timestamp[] instants, STPoint[] points) {
		MPoint mPoint = null;
		if(instants != null && points != null && instants.length == points.length) {
			mPoint = new MPointImpl(instants, points);
		}
		
		return mPoint;
	}
	
	public MPoint createMPoint(List<Timestamp> instants, List<STPoint> points) {
		MPoint mPoint = null;
		
		if(instants != null && points != null) {
			Timestamp[] InstantArr = new Timestamp[instants.size()];
			instants.toArray(InstantArr);
			STPoint[] PointArr = new STPoint[points.size()];
			points.toArray(PointArr);
			mPoint = createMPoint(InstantArr, PointArr);
		}
		
		return mPoint;
	}
	
}
