/**
 * 
 */
package edu.pnu.common.geometry.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.model.STGeometryCollection;
import edu.pnu.common.geometry.model.STLineString;
import edu.pnu.common.geometry.model.STMultiCurve;
import edu.pnu.common.geometry.model.STMultiLineString;
import edu.pnu.common.geometry.model.STMultiPoint;
import edu.pnu.common.geometry.model.STMultiPolygon;
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
public class WKBGeometryBuilder {
	
	private static WKBGeometryBuilder builder = null;
	
	private WKBGeometryBuilder() {}
	
	public static WKBGeometryBuilder getBuilder() {
		if(builder == null) {
			builder = new WKBGeometryBuilder();
		}
		return builder;
	}
	
	private ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
	
	private int getWKBType(STGeometry geom) {
		WKBTypeCode value;
		
		String gName = geom.geometryType();
		
		if(gName.equalsIgnoreCase("Point")) {
			if(geom.is3D()) 
				value = WKBTypeCode.PointZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.PointM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.PointZM;
			else
				value = WKBTypeCode.Point;
		}
		else if(gName.equalsIgnoreCase("LineString")) {
			if(geom.is3D()) 
				value = WKBTypeCode.LineStringZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.LineStringM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.LineStringZM;
			else
				value = WKBTypeCode.LineString;
		}
		else if(gName.equalsIgnoreCase("Polygon")) {
			if(geom.is3D()) 
				value = WKBTypeCode.PolygonZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.PolygonM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.PolygonZM;
			else
				value = WKBTypeCode.Polygon;
		}
		else if(gName.equalsIgnoreCase("GeometryCollection")) {
			if(geom.is3D()) 
				value = WKBTypeCode.GeometryCollectionZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.GeometryCollectionM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.GeometryCollectionZM;
			else
				value = WKBTypeCode.GeometryCollection;
		}
		else if(gName.equalsIgnoreCase("MultiPoint")) {
			if(geom.is3D()) 
				value = WKBTypeCode.MultiPointZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.MultiPointM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.MultiPointZM;
			else
				value = WKBTypeCode.MultiPoint;
		}
		else if(gName.equalsIgnoreCase("MultiLineString")) {
			if(geom.is3D()) 
				value = WKBTypeCode.MultiLineStringZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.MultiLineStringM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.MultiLineStringZM;
			else
				value = WKBTypeCode.MultiLineString;
		}
		else if(gName.equalsIgnoreCase("MultiPolygon")) {
			if(geom.is3D()) 
				value = WKBTypeCode.MultiPolygonZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.MultiPolygonM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.MultiPolygonZM;
			else
				value = WKBTypeCode.MultiPolygon;
		}
		/*		
		else if(geom instanceof STCircularString) {
			if(geom.is3D()) 
				value = WKBTypeCode.CircularStringZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.CircularStringM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.CircularStringZM;
			else
				value = WKBTypeCode.CircularString;
		}
		else if(geom instanceof STCompoundCurve) {
			if(geom.is3D()) 
				value = WKBTypeCode.CompoundCurveZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.CompoundCurveM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.CompoundCurveZM;
			else
				value = WKBTypeCode.CompoundCurve;
		}
		else if(geom instanceof STCurvePolygon) {
			if(geom.is3D()) 
				value = WKBTypeCode.CurvePolygonZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.CurvePolygonM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.CurvePolygonZM;
			else
				value = WKBTypeCode.CurvePolygon;
		}
		*/
		else if(gName.equalsIgnoreCase("MultiCurve")) {
			if(geom.is3D()) 
				value = WKBTypeCode.MultiCurveZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.MultiCurveM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.MultiCurveZM;
			else
				value = WKBTypeCode.MultiCurve;
		}
		else if(gName.equalsIgnoreCase("MultiSurface")) {
			if(geom.is3D()) 
				value = WKBTypeCode.MultiSurfaceZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.MultiSurfaceM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.MultiSurfaceZM;
			else
				value = WKBTypeCode.MultiSurface;
		}
		else if(gName.equalsIgnoreCase("PolyhedralSurface")) {
			if(geom.is3D()) 
				value = WKBTypeCode.PolyhedralSurfaceZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.PolyhedralSurfaceM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.PolyhedralSurfaceZM;
			else
				value = WKBTypeCode.PolyhedralSurface;
		}
		else if(gName.equalsIgnoreCase("TIN")) {
			if(geom.is3D()) 
				value = WKBTypeCode.TINZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.TINM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.TINZM;
			else
				value = WKBTypeCode.TIN;
		}
		else if(gName.equalsIgnoreCase("Triangle")) {
			if(geom.is3D()) 
				value = WKBTypeCode.TriangleZ;
			else if(geom.isMeasured()) 
				value = WKBTypeCode.TriangleM;
			else if(geom.is3D() && geom.isMeasured())
				value = WKBTypeCode.TriangleZM;
			else
				value = WKBTypeCode.Triangle;
		}
		else if(gName.equalsIgnoreCase("Solid")) {
			value = WKBTypeCode.Solid;
		}
		else if(gName.equalsIgnoreCase("MultiSolid")) {
			value = WKBTypeCode.MultiSolid;
		}
		else {
			String msg = "Unknown Geometry Type : " + gName;
			throw new IllegalArgumentException(msg);
		}
		return value.getType();
	}
	
	private byte[] getWKBHeader(STGeometry geom) {
		ByteBuffer bb = ByteBuffer.allocate(5);
		//Big Endian
		if(byteOrder == ByteOrder.LITTLE_ENDIAN) {
			bb.order(byteOrder).put(WKBByteOrder.wkbNDR.getOrder());
		}
		else {
			bb.order(byteOrder).put(WKBByteOrder.wkbXDR.getOrder());
		}
		int type = getWKBType(geom);
		bb.order(byteOrder).putInt(type);
		return bb.array();
	}
	
	public byte[] asBinary(STGeometry g) {
		byte[] header = getWKBHeader(g);
		byte[] wkbGeom = createWKB(g);
		byte[] result = new byte[header.length + wkbGeom.length];
		
		//Copy header
		System.arraycopy(header, 0, result, 0, header.length);
		//Copy geometry
		System.arraycopy(wkbGeom, 0, result, header.length, wkbGeom.length);
		
		return result;
	}
	
	public byte[] createWKB(STGeometry g) {
		
		byte[] wkb = null;
		
		if(g.geometryType().equalsIgnoreCase("Point")) {
			wkb = createPointWKB((STPoint) g);
		}
		else if(g.geometryType().equalsIgnoreCase("LineString")) {
			wkb = createLineStringWKB((STLineString) g);
		}
		else if(g.geometryType().equalsIgnoreCase("Polygon")) {
			wkb = createPolygonWKB((STPolygon) g);
		}
		else if(g.geometryType().equalsIgnoreCase("GeometryCollection")) {
			wkb = createGeometryCollectionWKB((STGeometryCollection) g);
		}
		else if(g.geometryType().equalsIgnoreCase("MultiPoint")) {
			wkb = createGeometryCollectionWKB((STMultiPoint) g);
		}
		else if(g.geometryType().equalsIgnoreCase("MultiLineString")) {
			wkb = createGeometryCollectionWKB((STMultiLineString) g);
		}
		else if(g.geometryType().equalsIgnoreCase("MultiPolygon")) {
			wkb = createGeometryCollectionWKB((STMultiPolygon) g);
		}
		else if(g.geometryType().equalsIgnoreCase("MultiCurve")) {
			wkb = createGeometryCollectionWKB((STMultiCurve) g);
		}
		else if(g.geometryType().equalsIgnoreCase("MultiSurface")) {
			wkb = createGeometryCollectionWKB((STMultiSurface) g);
		}
		/*		
		else if(g.geometryType().equalsIgnoreCase("CircularString")) {
			
		}
		else if(g.geometryType().equalsIgnoreCase("CompoundCurve")) {
			
		}
		else if(g.geometryType().equalsIgnoreCase("CurvePolygon")) {
			
		}
		*/
		else if(g.geometryType().equalsIgnoreCase("PolyhedralSurface")) {
			wkb = createPolyhedralSurfaceWKB((STPolyhedralSurface) g);
		}
		else if(g.geometryType().equalsIgnoreCase("TIN")) {
			wkb = createTINWKB((STTIN) g);
		}
		else if(g.geometryType().equalsIgnoreCase("Triangle")) {
			wkb = createTriangleWKB((STTriangle) g);
		}
		else if(g.geometryType().equalsIgnoreCase("Solid")) {
			wkb = createSolidWKB((STSolid) g);
		}
		/*		
		else if(g.geometryType().equalsIgnoreCase("MultiSolid")) {
			
		}*/
		else {
			String msg = "Unknown Geometry Type : " + g.geometryType();
			throw new IllegalArgumentException(msg);
		}
		
		return wkb;
	}
	
	private byte[] createPointWKB(STPoint g) {
		double[] coordinates = g.getcoordinates();
		ByteBuffer bb = ByteBuffer.allocate(coordinates.length * (Double.SIZE/Byte.SIZE));
		for( int i = 0; i < coordinates.length; i++) {
			bb.order(byteOrder).putDouble(coordinates[i]);
		}
		return bb.array();
	}
	
	private byte[] createLineStringWKB(STLineString g) {
		ByteBuffer buffer = ByteBuffer.allocate((Integer.SIZE/Byte.SIZE) + g.numPoints() * g.coordinateDimension() * (Double.SIZE/Byte.SIZE));
		buffer.order(byteOrder).putInt(g.numPoints());
		for(int i = 0; i < g.numPoints(); i++) {
			byte[] pointArr = createPointWKB(g.PointN(i));
			buffer.order(byteOrder).put(pointArr);
		}
		return buffer.array();
	}
	
	private byte[] createPolygonWKB(STPolygon g) {
		List<Byte> list = new ArrayList<Byte>();
		
		byte[] numRing = ByteBuffer.allocate(Integer.SIZE/Byte.SIZE).order(byteOrder).putInt(g.numInteriorRing() + 1).array();
		list.addAll(Arrays.asList(ArrayUtils.toObject(numRing)));
		
		byte[] exteriorBinary = createLineStringWKB(g.exteriorRing());
		list.addAll(Arrays.asList(ArrayUtils.toObject(exteriorBinary)));
		
		for(int i = 0; i < g.numInteriorRing(); i++) {
			byte[] interiorBinary = createLineStringWKB(g.interiorRingN(i));
			list.addAll(Arrays.asList(ArrayUtils.toObject(interiorBinary)));
		}
		return ArrayUtils.toPrimitive( list.toArray(new Byte[list.size()]));
	}
	
	private byte[] createPolyhedralSurfaceWKB(STPolyhedralSurface g) {
		List<Byte> list = new ArrayList<Byte>();
		
		int numPatches = g.numPatches();
		byte[] numPachesWKB = ByteBuffer.allocate(Integer.SIZE/Byte.SIZE).order(byteOrder).putInt(numPatches).array(); 
		list.addAll(Arrays.asList(ArrayUtils.toObject(numPachesWKB)));
		
		for(int i = 0; i< g.numPatches(); i++) {
			byte[] patch = asBinary(g.PatchN(i));
			list.addAll(Arrays.asList(ArrayUtils.toObject(patch)));
		}
		return ArrayUtils.toPrimitive( list.toArray(new Byte[list.size()]));
	}
	
	private byte[] createTriangleWKB(STTriangle g) {
		List<Byte> list = new ArrayList<Byte>();
		
		STLineString exterior = g.exteriorRing();
		for(int i = 0; i < exterior.numPoints(); i++) {
			byte[] pointArr = createPointWKB(exterior.PointN(i));
			list.addAll(Arrays.asList(ArrayUtils.toObject(pointArr)));
		}
		return ArrayUtils.toPrimitive( list.toArray(new Byte[list.size()]));
	}
	
	private byte[] createTINWKB(STTIN g) {
		List<Byte> list = new ArrayList<Byte>();
		
		byte[] numPatches = ByteBuffer.allocate(Integer.SIZE/Byte.SIZE).order(byteOrder).putInt(g.numPatches()).array(); 
		list.addAll(Arrays.asList(ArrayUtils.toObject(numPatches)));
		
		for(int i = 0; i< g.numPatches(); i++) {
			byte[] patch = createTriangleWKB(g.PatchN(i));
			list.addAll(Arrays.asList(ArrayUtils.toObject(patch)));
		}
		return ArrayUtils.toPrimitive( list.toArray(new Byte[list.size()]));
	}
	
	private byte[] createGeometryCollectionWKB(STGeometryCollection g) {
 		List<Byte> list = new ArrayList<Byte>();
		
		int numGeom = g.numGeometries();
		byte[] numS = ByteBuffer.allocate(Integer.SIZE/Byte.SIZE).order(byteOrder).putInt(numGeom).array();
		list.addAll(Arrays.asList(ArrayUtils.toObject(numS)));
		
		for(int i = 0; i < g.numGeometries(); i++) {
			STGeometry AGeometry = g.geometryN(i);
			byte[] geom = asBinary(AGeometry);
			list.addAll(Arrays.asList(ArrayUtils.toObject(geom)));
		}
		return ArrayUtils.toPrimitive( list.toArray(new Byte[list.size()]));
	}
	
	private byte[] createSolidWKB(STSolid g) {
		List<Byte> list = new ArrayList<Byte>();
		
		byte[] numShell = ByteBuffer.allocate(Integer.SIZE/Byte.SIZE).order(byteOrder).putInt(g.numInteriorShell() + 1).array();
		list.addAll(Arrays.asList(ArrayUtils.toObject(numShell)));
		
		STSurface exterior = g.exteriorShell();
		byte[] exteriorWKB = createSolidSurfaceWKB(exterior);
		list.addAll(Arrays.asList(ArrayUtils.toObject(exteriorWKB)));
		
		for(int i = 0; i < g.numInteriorShell(); i++) {
			STSurface interior = g.interiorShellN(i);
			byte[] interiorWKB = createSolidSurfaceWKB( interior);
			list.addAll(Arrays.asList(ArrayUtils.toObject(interiorWKB)));
		}
		return ArrayUtils.toPrimitive( list.toArray(new Byte[list.size()]));
	}
	
	private byte[] createSolidSurfaceWKB(STSurface g) {
		List<Byte> list = new ArrayList<Byte>();
		
		byte[] wkb = null;
		
		if(g.geometryType().equalsIgnoreCase("Polygon")) {
			STPolygon s = (STPolygon) g;

			STLineString lineString = s.exteriorRing();
			ByteBuffer buffer = ByteBuffer.allocate((Integer.SIZE/Byte.SIZE) + lineString.numPoints() * lineString.coordinateDimension() * (Double.SIZE/Byte.SIZE));
			buffer.order(byteOrder).putInt(lineString.numPoints());
			for(int i = 0; i < lineString.numPoints(); i++) {
				byte[] pointArr = createPointWKB(lineString.PointN(i));
				buffer.order(byteOrder).put(pointArr);
			}
			
			wkb = buffer.array();
			
		} else if(g.geometryType().equalsIgnoreCase("PolyhedralSurface")) {
			STPolyhedralSurface s = (STPolyhedralSurface) g;
			
			byte[] numPatches = ByteBuffer.allocate(Integer.SIZE/Byte.SIZE).order(byteOrder).putInt(s.numPatches()).array(); 
			list.addAll(Arrays.asList(ArrayUtils.toObject(numPatches)));
			
			for(int i = 0; i< s.numPatches(); i++) {
				byte[] patch = createSolidSurfaceWKB(s.PatchN(i));
				list.addAll(Arrays.asList(ArrayUtils.toObject(patch)));
			}
			wkb = ArrayUtils.toPrimitive( list.toArray(new Byte[list.size()]));
		} else {
			throw new UnsupportedOperationException();
		}
		
		return wkb;
	}
}