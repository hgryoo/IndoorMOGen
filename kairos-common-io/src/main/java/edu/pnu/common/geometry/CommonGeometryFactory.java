/**
 * 
 */
package edu.pnu.common.geometry;

import java.util.List;

import edu.pnu.common.geometry.model.STCurve;
import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.model.STGeometryCollection;
import edu.pnu.common.geometry.model.STLineString;
import edu.pnu.common.geometry.model.STMultiCurve;
import edu.pnu.common.geometry.model.STMultiPoint;
import edu.pnu.common.geometry.model.STMultiSurface;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.model.STPolygon;
import edu.pnu.common.geometry.model.STPolyhedralSurface;
import edu.pnu.common.geometry.model.STSolid;
import edu.pnu.common.geometry.model.STSurface;
import edu.pnu.common.geometry.model.STTIN;
import edu.pnu.common.geometry.model.STTriangle;

/**
 * @author hgryoo
 *
 */
public class CommonGeometryFactory extends AbstractGeometryFactory {

	// TODO Reference System으로 3D, Measured를 표현해야됨
	private boolean is3D;
	private boolean isMeasured;
	
	public CommonGeometryFactory(boolean is3D, boolean isMeasured) {
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
	
	/**
	 * Creates a new Polygon with the given exterior and interior Rings
	 * @param exterior, interiors
	 * @return the Polygon object
	 */
	public STPolygon createPolygon(STLineString exterior, STLineString[] interior) {
		STPolygon polygon = null;
		if(exterior != null) {
			polygon = new PolygonImpl(exterior, interior, is3D, isMeasured);
		}
		return polygon;
	}
	
	/**
	 * Creates a new Triangle with the given exterior
	 * @param exterior
	 * @return the Triangle object
	 */
	public STTriangle createTriangle(STLineString exterior) {
		STTriangle triangle = null;
		if(exterior != null) {
			triangle = new TriangleImpl(exterior, is3D, isMeasured);
		}
		return triangle;
	}
	
	/**
	 * Creates a new PolyhedralSurface with the given patches
	 * @param patches
	 * @return the PolyhedralSurface object
	 */
	public STPolyhedralSurface createPolyhedralSurface(STPolygon[] patches) {
		STPolyhedralSurface polyhedralSurface = null;
		if(patches != null && patches.length > 0) {
			polyhedralSurface = new PolyhedralSurfaceImpl(patches, is3D, isMeasured);
		}
		else {
			throw new IllegalArgumentException();
		}
		return polyhedralSurface;
	}

	/**
	 * Creates a new TIN with the given triangles
	 * @param triangles
	 * @return the TIN object
	 */
	public STTIN createTIN(STTriangle[] triangles) {
		STTIN tin = null;
		if(triangles != null && triangles.length > 0) {
			tin = new TINImpl(triangles, is3D, isMeasured);
		}
		else {
			throw new IllegalArgumentException();
		}
		return tin;
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
	
	/**
	 * Creates a new MultiPoint with the given points
	 * @param points
	 * @return the MultiPoint object
	 */
	public STMultiPoint createMultiPoint(STPoint[] points) {
		STMultiPoint multiPoint = null;
		if(points != null) {
			multiPoint = new MultiPointImpl(points, is3D, isMeasured);
		}
		return multiPoint;
	}
	
	/**
	 * Creates a new MultiCurve with the given curves
	 * @param curves
	 * @return the MultiCurve object
	 */
	public STMultiCurve createMultiCurve(STCurve[] curves) {
		STMultiCurve multiCurve = null;
		if(curves != null) {
			multiCurve = new MultiCurveImpl(curves, is3D, isMeasured);
		}
		return multiCurve;
	}
	
	/**
	 * Creates a new MultiSurface with the given surfaces
	 * @param surfaces
	 * @return the MultiSurface object
	 */
	public STMultiSurface createMultiSurface(STSurface[] surfaces) {
		STMultiSurface multiSurface = null;
		if(surfaces != null) {
			multiSurface = new MultiSurfaceImpl(surfaces, is3D, isMeasured);
		}
		return multiSurface;
	}
	
	/**
	 * Creates a new Solid with the given exterior surface and interior 
	 * @param exterior, interior
	 * @return the Solid object
	 */
	public STSolid createSolid(STSurface exterior, STSurface[] interior) {
		STSolid solid = null;
		if(exterior != null) {
			solid = new SolidImpl(exterior, interior, is3D, isMeasured);
		}
		return solid;
	}
	
	/**
	 * Creates a new GeometryCollection with the given geometry List
	 * @param geometries
	 * @return the GeometryCollection object
	 */
	public STGeometryCollection createGeometryCollection(STGeometry[] geometries) {
		STGeometryCollection geometryCollection = null;
		if(geometries != null) {
			geometryCollection = new GeometryCollectionImpl(geometries, is3D, isMeasured);
		}
		return geometryCollection;
	}
	
	public STSolid createBox3D(STPoint lower, STPoint upper) {
		STSolid solid = null;
		
		Double xl = lower.X(); Double yl = lower.Y(); Double zl = lower.Z();
		Double xh = upper.X(); Double yh = upper.Y(); Double zh = upper.Z();
		
		STPoint[] p = new STPoint[8];
		p[0] = createPoint(new double[] { xl, yl, zl } );
		p[1] = createPoint(new double[] { xh, yl, zl } );
		p[2] = createPoint(new double[] { xh, yh, zl } );
		p[3] = createPoint(new double[] { xl, yh, zl } );

		p[4] = createPoint(new double[] { xl, yl, zh } );
		p[5] = createPoint(new double[] { xh, yl, zh } );
		p[6] = createPoint(new double[] { xh, yh, zh } );
		p[7] = createPoint(new double[] { xl, yh, zh } );
		
		STLineString[] lr = new STLineString[6];
		lr[0] = createLineString(new STPoint[] { p[0], p[3], p[2], p[1], p[0] }) ;
		lr[1] = createLineString(new STPoint[] { p[0], p[1], p[5], p[4], p[0] }) ;
		lr[2] = createLineString(new STPoint[] { p[1], p[2], p[6], p[5], p[1] }) ;
		lr[3] = createLineString(new STPoint[] { p[2], p[3], p[7], p[6], p[2] }) ;
		lr[4] = createLineString(new STPoint[] { p[3], p[0], p[4], p[7], p[3] }) ;
		lr[5] = createLineString(new STPoint[] { p[4], p[5], p[6], p[7], p[4] }) ;
		
		STPolygon[] polygons = new STPolygon[6];
		for(int i = 0; i < 6; i++)  polygons[i] = createPolygon(lr[i], null);
		
		STPolyhedralSurface shell = createPolyhedralSurface(polygons);
		solid = createSolid(shell, null);
		return solid;
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

	
	
	
	
}
