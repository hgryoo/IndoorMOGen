/**
 * 
 */
package edu.pnu.common.geometry.utils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.common.geometry.CommonGeometryFactory;
import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.model.STGeometryCollection;
import edu.pnu.common.geometry.model.STLineString;
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
public class WKBGeometryParser {

	private static WKBGeometryParser parser = null;
	
	private WKBGeometryParser() {}
	
	public static WKBGeometryParser getParser() {
		if(parser == null) {
			parser = new WKBGeometryParser();
		}
		return parser;
	}
	
	private static CommonGeometryFactory gf = null;
	
	
	public WKBByteOrder getByteOrder(ByteBuffer wkb) {
		byte orderValue = wkb.get();
		return WKBByteOrder.fromValue(orderValue);
	}
	
	public WKBTypeCode getTypeCode(ByteBuffer wkb) {
		int typeCode = wkb.getInt();
		return WKBTypeCode.fromValue(typeCode);
	}
	
	public int getNumGeometry(ByteBuffer wkb) {
		int numGeom = wkb.getInt();
		return numGeom;
	}
	
	public STGeometry createGeometry(ByteBuffer wkb, WKBTypeCode geomType) {
		
		String geomName = geomType.name();
		
		boolean is3D = WKBTypeCode.is3D(geomType);
		boolean isMeasured = WKBTypeCode.isMeasured(geomType);
		
		if(geomName.startsWith("Point")) {
			STPoint point = createPoint(wkb, is3D, isMeasured);
			return point;
		}
		else if(geomName.startsWith("LineString")) {
			STLineString lineString = createLineString(wkb, is3D, isMeasured);
			return lineString;
		}
		else if(geomName.startsWith("Polygon")) {
			STPolygon polygon = createPolygon(wkb, is3D, isMeasured);
			return polygon;
		}
		else if(geomName.startsWith("GeometryCollection")) {
			STGeometryCollection geometryCollection = createGeometryCollection(wkb, is3D, isMeasured);
			return geometryCollection;
		}
		else if(geomName.startsWith("MultiPoint")) {
			STGeometryCollection geometryCollection = createGeometryCollection(wkb, is3D, isMeasured);
			return geometryCollection;
		}
		else if(geomName.startsWith("MultiLineString")) {
			STGeometryCollection geometryCollection = createGeometryCollection(wkb, is3D, isMeasured);
			return geometryCollection;
		}
		else if(geomName.startsWith("MultiPolygon")) {
			STGeometryCollection geometryCollection = createGeometryCollection(wkb, is3D, isMeasured);
			return geometryCollection;
		}
		else if(geomName.startsWith("MultiCurve")) {
			STGeometryCollection geometryCollection = createGeometryCollection(wkb, is3D, isMeasured);
			return geometryCollection;
		}
		else if(geomName.startsWith("MultiSurface")) {
			STMultiSurface multiSurface = createMultiSurface(wkb, is3D, isMeasured);
			return multiSurface;
		}
		else if(geomName.startsWith("PolyhedralSurface")) {
			STPolyhedralSurface polyhedralSurface = createPolyhedralSurface(wkb, is3D, isMeasured);
			return polyhedralSurface;
		}
		else if(geomName.startsWith("TIN")) {
			STTIN tin = createTIN(wkb, is3D, isMeasured);
			return tin;
		}
		else if(geomName.startsWith("Triangle")) {
			STTriangle triangle = createTriangle(wkb, is3D, isMeasured);
			return triangle;
		}
		else if(geomName.startsWith("Solid")) {
			STSolid solid = createSolid(wkb, is3D, isMeasured);
			return solid;
		}
		else if(geomName.startsWith("MultiSolid")) {
			throw new UnsupportedOperationException("MultiSolid isn't supported");		
		}
		else {
			String msg = "Unknown Geometry Type : " + geomName;
			throw new IllegalArgumentException(msg);
		}
	}
	
	public STPoint createPoint(ByteBuffer wkb, boolean is3D, boolean isMeasured) {
		STPoint point = null;
		if(gf == null) {
			gf = new CommonGeometryFactory(is3D, isMeasured);
		}
		
		int length = 2;
		if(is3D && isMeasured) {
			length = 4;
		}
		else if(is3D || isMeasured) {
			length = 3;
		}
		
		List<Double> coordinates = new ArrayList<Double>();
		for(int i = 0; i < length; i++) {
			coordinates.add( wkb.getDouble() );
		}
		
		point = gf.createPoint(coordinates);
		return point;
	}
	
	public STLineString createLineString(ByteBuffer wkb, boolean is3D, boolean isMeasured) {
		STLineString lineString = null;
		if(gf == null) {
			gf = new CommonGeometryFactory(is3D, isMeasured);
		}
		
		int numPoint = getNumGeometry(wkb);
		STPoint[] points = new STPoint[numPoint];
		for(int i = 0 ; i < numPoint; i++) {
			STPoint p = createPoint(wkb, is3D, isMeasured);
			points[i] = p;
		}
		
		lineString = gf.createLinearRing(points);
		return lineString;
	}
	
	public STTriangle createTriangle(ByteBuffer wkb, boolean is3D, boolean isMeasured) {
		STTriangle triangle = null;
		if(gf == null) {
			gf = new CommonGeometryFactory(is3D, isMeasured);
		}
		
		STPoint[] points = new STPoint[3];
		for(int i = 0; i < 3; i++) {
			STPoint p = createPoint(wkb, is3D, isMeasured);
			points[i] = p;
		}
		
		STLineString ring = gf.createLinearRing(points);
		triangle = gf.createTriangle(ring);
		return triangle;
	}
	
	public STPolygon createPolygon(ByteBuffer wkb, boolean is3D, boolean isMeasured) {
		STPolygon polygon = null;
		if(gf == null) {
			gf = new CommonGeometryFactory(is3D, isMeasured);
		}
		
		int numLineString = getNumGeometry(wkb);
		
		STLineString exterior = null;
		STLineString[] interiors = null;
		exterior = createLineString(wkb, is3D, isMeasured);
		
		if(numLineString > 1) {
			interiors = new STLineString[numLineString - 1];
			for(int i = 0; i < numLineString - 1; i++) {
				STLineString l = createLineString(wkb, is3D, isMeasured);
				interiors[i] = l;
			}
		}
		
		polygon = gf.createPolygon(exterior, interiors);
		return polygon;
	}
	
	public STGeometryCollection createGeometryCollection(ByteBuffer wkb, boolean is3D, boolean isMeasured) {
		STGeometryCollection geometryCollection = null;
		if(gf == null) {
			gf = new CommonGeometryFactory(is3D, isMeasured);
		}
		
		int numGeom = getNumGeometry(wkb);
		STGeometry[] geometries = new STGeometry[numGeom];
		for(int i = 0; i < numGeom; i++) {
			STGeometry geometry = parseWKB(wkb);
			geometries[i] = geometry;
		}
		geometryCollection = gf.createGeometryCollection(geometries);
		return geometryCollection;
	}
	
	public STMultiSurface createMultiSurface(ByteBuffer wkb, boolean is3D, boolean isMeasured) {
		STMultiSurface multiSurface = null;
		if(gf == null) {
			gf = new CommonGeometryFactory(is3D, isMeasured);
		}
		
		int numGeom = getNumGeometry(wkb);
		STSurface[] surfaces = new STSurface[numGeom];
		for(int i = 0; i < numGeom; i++) {
			STSurface surface = (STSurface) parseWKB(wkb);
			surfaces[i] = surface;
		}
		multiSurface = gf.createMultiSurface(surfaces);
		return multiSurface;
	}

	public STPolyhedralSurface createPolyhedralSurface(ByteBuffer wkb, boolean is3D, boolean isMeasured) {
		STPolyhedralSurface pSurface = null;
		if(gf == null) {
			gf = new CommonGeometryFactory(is3D, isMeasured);
		}
		
		int numPolygon = getNumGeometry(wkb);
		STPolygon[] polygons = new STPolygon[numPolygon];
		for(int i = 0; i < numPolygon; i++) {
			STPolygon p = (STPolygon) parseWKB(wkb);
			polygons[i] = p;
		}
		
		pSurface = gf.createPolyhedralSurface(polygons);
		return pSurface;
	}
	
	public STTIN createTIN(ByteBuffer wkb, boolean is3D, boolean isMeasured) {
		STTIN tin = null;
		if(gf == null) {
			gf = new CommonGeometryFactory(is3D, isMeasured);
		}
		
		int numTriangle = getNumGeometry(wkb);
		STTriangle[] triangles = new STTriangle[numTriangle];
		for(int i = 0; i < numTriangle; i++) {
			STTriangle t = createTriangle(wkb, is3D, isMeasured);
			triangles[i] = t;
		}
	
		tin = gf.createTIN(triangles);
		return tin;
	}
	
	public STSolid createSolid(ByteBuffer wkb, boolean is3D, boolean isMeasured) {
		STSolid solid = null;
		if(gf == null) {
			gf = new CommonGeometryFactory(is3D, isMeasured);
		}
		
		int numShell = getNumGeometry(wkb);
		STPolyhedralSurface exterior = null;
		STPolyhedralSurface[] interiors = null;
		
		exterior = createSolidShell(wkb, is3D, isMeasured);
		
		if(numShell > 1) {
			interiors = new STPolyhedralSurface[numShell - 1];
			for(int i = 0; i < numShell - 1; i++) {
				STPolyhedralSurface ps = createSolidShell(wkb, is3D, isMeasured);
				interiors[i] = ps;
			}
		}
		
		solid = gf.createSolid(exterior, interiors);
		return solid;
	}
	
	public STPolyhedralSurface createSolidShell(ByteBuffer wkb, boolean is3D, boolean isMeasured) {
		STPolyhedralSurface shell = null;
		if(gf == null) {
			gf = new CommonGeometryFactory(is3D, isMeasured);
		}
		
		int numSurface = getNumGeometry(wkb);
		STPolygon[] polygons = new STPolygon[numSurface];
		for(int i = 0; i < numSurface; i++) {
			STPolygon p = createSolidSurface(wkb, is3D, isMeasured);
			polygons[i] = p;
		}
		
		shell = gf.createPolyhedralSurface(polygons);
		return shell;
	}
	
	public STPolygon createSolidSurface(ByteBuffer wkb, boolean is3D, boolean isMeasured) {
		STPolygon surface = null;
		if(gf == null) {
			gf = new CommonGeometryFactory(is3D, isMeasured);
		}
		
		int numPoints = getNumGeometry(wkb);
		STPoint[] points = new STPoint[numPoints];
		for(int i = 0; i < numPoints; i++) {
			STPoint p = createPoint(wkb, is3D, isMeasured);
			points[i] = p;
		}
		
		STLineString exterior = gf.createLinearRing(points);
		
		surface = gf.createPolygon(exterior, null);
		return surface;
	}
	
	public STGeometry parseWKB(ByteBuffer bais) {
		WKBByteOrder byteOrder = getByteOrder(bais);
		bais.order( byteOrder.getByteOrder() );
		
		WKBTypeCode geomType = getTypeCode(bais);
		
		STGeometry geom = createGeometry(bais, geomType);
		
		return geom;
	}
	
	public STGeometry parseWKB(byte[] bais) {
		return parseWKB(ByteBuffer.wrap(bais));
	}
}
