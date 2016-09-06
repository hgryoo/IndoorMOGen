/**
 * 
 */
package edu.pnu.common.geometry.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.common.geometry.GeometryFactory;
import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.model.STLineString;
import edu.pnu.common.geometry.model.STMultiSurface;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.model.STPolygon;
import edu.pnu.common.geometry.model.STSurface;

/**
 * @author hgryoo
 *
 */
public class WKBGeometryParsingUtil {
	//TODO Input : Little Endian(Kairos)
	private static Map<Integer, String> typeMap = new HashMap<Integer, String>();
	private static boolean is3D;
	private static boolean isMeasured;
	
	private static final int HEADER_BYTE_SIZE = 5;
	private static final int POINT_BYTE_SIZE = (Double.SIZE / 8) * 3;
	
	private static ByteOrder BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
	
	//TODO
	static {
		typeMap.put(1, "Point");
		typeMap.put(2, "LineString");
		typeMap.put(3, "Polygon");
		typeMap.put(4, "MultiPoint");
		typeMap.put(5, "MultiLineString");
		typeMap.put(6, "MultiPolygon");
		typeMap.put(7, "GeometryCollection");
		typeMap.put(8, "CircularString");
		typeMap.put(9, "CompoundCurve");
		typeMap.put(10, "CurvePolygon");
		typeMap.put(11, "MultiCurve");
		typeMap.put(12, "MultiSurface");
		typeMap.put(15, "PolyhedralSurface");
		typeMap.put(16, "TIN");
		typeMap.put(17, "Triangle");
	}
	
	public static int getWKBOrder(byte[] wkb) {
		byte order = wkb[0];
		if(order == WKBByteOrder.wkbXDR.getOrder()) {
			BYTE_ORDER = ByteOrder.BIG_ENDIAN;
		} else {
			BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
		}
		return order;
	}
	
	public static int getWKBType(byte[] wkb) {
		ByteBuffer buff = ByteBuffer.allocate(Integer.SIZE / 8);
		
		getWKBOrder(wkb);
		
		buff.order(BYTE_ORDER);
		buff.put(wkb, 1, Integer.SIZE / 8);
		buff.flip();
		
		int wkbType = buff.getInt();
		
		is3D = false;
		isMeasured = false;
		
		if(wkbType - 1000 > 0) {
			is3D = true;
			wkbType -= 1000;
		}
		if(wkbType - 2000 > 0) {
			isMeasured = true;
			wkbType -= 2000;
		}
		
		return wkbType;
	}
	
	public static int getNumGeometries(byte[] wkb) {
		ByteBuffer buff = ByteBuffer.allocate(Integer.SIZE / 8);
		buff.order(BYTE_ORDER);
		buff.put(wkb, 0, Integer.SIZE / 8);
		buff.flip();
		
		int numGeometries = buff.getInt();
		
		return numGeometries;		
	}
	
	public static byte[] getWKBGeomFromOffset(byte[] wkb, int offset){
		byte[] wkbGeom = new byte[wkb.length - offset];
		System.arraycopy(wkb, offset, wkbGeom, 0, wkb.length - offset);
		
		return wkbGeom;
	}
	
	public static byte[] getWKBGeom(byte[] wkb) {
		//without header 5 bytes
		
		return getWKBGeomFromOffset(wkb, 5);
	}
	
	
	
	public static STGeometry createGeometry(byte[] wkb) {
		STGeometry geometry = null;
		
		int wkbType = getWKBType(wkb);

		byte[] wkbGeom = getWKBGeom(wkb);
		
		if("Point".equalsIgnoreCase(typeMap.get(wkbType))) {
			geometry = (STGeometry) createPoint(wkbGeom, is3D, isMeasured, null);
		}else if("LineString".equalsIgnoreCase(typeMap.get(wkbType))) {
			geometry = (STGeometry) createLineString(wkbGeom, is3D, isMeasured, null);
		}else if("Polygon".equalsIgnoreCase(typeMap.get(wkbType))) {
			geometry = (STGeometry) createPolygon(wkbGeom, is3D, isMeasured, null);
		}else if("MultiSurface".equalsIgnoreCase(typeMap.get(wkbType))) {
			geometry = null;
		}
		
		return geometry;
	}
	
	public static STPoint createPoint(byte[] wkb, boolean is3D, boolean isMeasured, GeometryFactory gf) {
		STPoint point = null;
		if(gf == null) {
			gf = new GeometryFactory(is3D, isMeasured);
		}
		
		List<Double> coordinates = new ArrayList<Double>();
		for(int i = 0; i < wkb.length / (Double.SIZE / Byte.SIZE); i++) {
			ByteBuffer buff = ByteBuffer.allocate(Double.SIZE / Byte.SIZE);
			buff.order(BYTE_ORDER);
			buff.put(wkb, i * (Double.SIZE / Byte.SIZE), Double.SIZE / Byte.SIZE);
			buff.flip();
			double value = buff.getDouble();
			coordinates.add(Double.valueOf(value));
		}
		System.out.println("selected Coodinates = " + coordinates);
		
		point = gf.createPoint(coordinates);
		return point;
	}

	public static STPoint createPoint(byte[] wkb) {
		getWKBType(wkb);
		
		byte[] wkbGeom = getWKBGeom(wkb);
		
		return createPoint(wkbGeom, is3D, isMeasured, null);
	}
	
	public static STLineString createLineString(byte[] wkb, boolean is3D, boolean isMeasured, GeometryFactory gf) {
		STLineString lineString = null;
		if(gf == null) {
			gf = new GeometryFactory(is3D, isMeasured);
		}
		
		int numPoints = getNumGeometries(wkb);	
		wkb = getWKBGeomFromOffset(wkb, Integer.SIZE / 8);
		List<STPoint> points = new ArrayList<STPoint>();
		for(int i = 0; i < numPoints; i++) {
			byte[] wkbGeom = new byte[POINT_BYTE_SIZE];
			System.arraycopy(wkb, i * POINT_BYTE_SIZE, wkbGeom, 0, POINT_BYTE_SIZE);
			
			STPoint point = createPoint(wkbGeom, is3D, isMeasured, gf);
			points.add(point);
		}
		
		lineString = gf.createLineString(points);
		
		return lineString;
	}
	
	public static STLineString createLineString(byte[] wkb) {
		getWKBType(wkb);
		
		byte[] wkbGeom = getWKBGeom(wkb);
		
		return createLineString(wkbGeom, is3D, isMeasured, null);
	}
	
	public static STLineString createLinearRing(byte[] wkb, boolean is3D, boolean isMeasured, GeometryFactory gf) {
		STLineString linearRing = null;
		
		if(gf == null) {
			gf = new GeometryFactory(is3D, isMeasured);
		}
		
		int numPoints = getNumGeometries(wkb);
		wkb = getWKBGeomFromOffset(wkb, Integer.SIZE / 8);
		List<STPoint> points = new ArrayList<STPoint>();
		for(int i = 0; i < numPoints; i++) {
			byte[] wkbGeom = new byte[POINT_BYTE_SIZE];
			System.arraycopy(wkb, i * POINT_BYTE_SIZE, wkbGeom, 0, POINT_BYTE_SIZE);
			
			STPoint point = createPoint(wkbGeom, is3D, isMeasured, gf);
			points.add(point);
		}
		
		linearRing = gf.createLinearRing(points);
		
		return linearRing;
	}
	
	public static STPolygon createPolygon(byte[] wkb, boolean is3D, boolean isMeasured, GeometryFactory gf) {
		STPolygon polygon = null;
		if(gf == null) {
			gf = new GeometryFactory(is3D, isMeasured);
		}
		
		int numRings = getNumGeometries(wkb);
		wkb = getWKBGeomFromOffset(wkb, Integer.SIZE / Byte.SIZE);
		
		STLineString exterior = createLinearRing(wkb, is3D, isMeasured, gf);
		//wkb = getWKBGeomFromOffset(wkb, exterior.asBinary().length);
		
		STLineString[] interior = null;
		if(numRings > 1) {
			interior = new STLineString[numRings - 1];
			for(int i = 0; i < numRings - 1; i++) {
				interior[i] = createLinearRing(wkb, is3D, isMeasured, gf);
				//wkb = getWKBGeomFromOffset(wkb, interior[i].asBinary().length);
			}
		}
		
		polygon = gf.createPolygon(exterior, interior);
		
		return polygon;
	}
	
	public static STPolygon createPolygon(byte[] wkb) {
		getWKBType(wkb);
		byte[] wkbGeom = getWKBGeom(wkb);
		return createPolygon(wkbGeom, is3D, isMeasured, null);
	}
	
	public static STMultiSurface createMultiSurface(byte[] wkb, boolean is3D, boolean isMeasured, GeometryFactory gf) {
		STMultiSurface multiSurface = null;
		
		if(gf == null) {
			gf = new GeometryFactory(is3D, isMeasured);
		}
		
		int numGeometries = getNumGeometries(wkb);
		wkb = getWKBGeomFromOffset(wkb, Integer.SIZE / 8);
		
		STSurface[] surfaces = new STSurface[numGeometries];
		for(int i = 0; i < numGeometries; i++) {
			surfaces[i] = createPolygon(wkb);
			//wkb = getWKBGeomFromOffset(wkb, surfaces[i].asBinary().length + HEADER_BYTE_SIZE);
		}
		
		multiSurface = gf.createMultiSurface(surfaces);
		
		return multiSurface;
	}
	
	public static STMultiSurface createMultiSurface(byte[] wkb) {
		getWKBType(wkb);
		byte[] wkbGeom = getWKBGeom(wkb);
		return createMultiSurface(wkbGeom, is3D, isMeasured, null);
	}
	
	/*
	public static MPoint createMPoint(byte[] wkb, boolean is3D, boolean isMeasured, GeometryFactory gf) {
		MPoint mPoint = null;
		
		if(gf == null) {
			gf = new GeometryFactory(is3D, isMeasured);
		}
		
		int numInstants = getNumGeometries(wkb);
		wkb = getWKBGeomFromOffset(wkb, Integer.SIZE / Byte.SIZE);
		Timestamp instants[] = new Timestamp[numInstants];
		STPoint points[] = new STPoint[numInstants];
		for(int i = 0; i < numInstants; i++) {
			ByteBuffer buff = ByteBuffer.allocate(Double.SIZE / Byte.SIZE);
			buff.order(BYTE_ORDER);
			buff.put(wkb, i * (Double.SIZE / 8 + POINT_BYTE_SIZE), Double.SIZE / Byte.SIZE);
			buff.flip();
			double value = buff.getDouble();
			
			Timestamp instant = new Timestamp((long) value);
			instants[i] = instant;
			
			byte[] wkbGeom = new byte[POINT_BYTE_SIZE];
			System.arraycopy(wkb, i * (Double.SIZE / 8 + POINT_BYTE_SIZE) + Double.SIZE / 8, wkbGeom, 0, POINT_BYTE_SIZE);
			
			STPoint point = createPoint(wkbGeom, is3D, isMeasured, gf);
			points[i] = point;
		}
		
		mPoint = gf.createMPoint(instants, points);
		
		return mPoint;
	}
*/
	/*
	public static MPoint createMPoint(byte[] wkb) {
		getWKBType(wkb);
		
		byte[] wkbGeom = getWKBGeom(wkb);
		
		//wkbGeom = getWKBGeomFromOffset(wkbGeom, 4);
		//MPoint는 WKB에서 header 5byte 이후에
		//빈 공간으로 4 byte가 더 들어감.
		//이후에 numInstants를 가져올 때 4바이트만 가져오기 위해 여기서 4바이트를 더 자른다.
		
		//5.5 버전과 wkb type의 순서가 다르다.
		//WKBMPoint {
		//byte byteorder;
		//uint32 wkbType;
		//uint32 ???
		//uint32 numInstants;
		//double instnat(timestamp)
		//double x
		//double y
		//numInstants만큼 timestamp, x, y 반복
		//}
		return createMPoint(wkbGeom, is3D, isMeasured, null);
	}
	*/
}
