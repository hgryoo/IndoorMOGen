/**
 * 
 */
package edu.pnu.common.geometry.utils;

/**
 * @author hgryoo
 *
 */
public enum WKBTypeCode {
	
	Point(1),
	LineString(2),
	Polygon(3),
	MultiPoint(4),
	MultiLineString(5),
	MultiPolygon(6),
	GeometryCollection(7),
	CircularString(8),
	CompoundCurve(9),
	CurvePolygon(10),
	MultiCurve(11),
	MultiSurface(12),
	PolyhedralSurface(15),
	TIN(16),
	Triangle(17),
	
	PointZ(1001),
	LineStringZ(1002),
	PolygonZ(1003),
	MultiPointZ(1004),
	MultiLineStringZ(1005),
	MultiPolygonZ(1006),
	GeometryCollectionZ(1007),
	CircularStringZ(1008),
	CompoundCurveZ(1009),
	CurvePolygonZ(1010),
	MultiCurveZ(1011),
	MultiSurfaceZ(1012),
	PolyhedralSurfaceZ(1015),
	TINZ(1016),
	TriangleZ(1017),
	
	PointM(2001),
	LineStringM(2002),
	PolygonM(2003),
	MultiPointM(2004),
	MultiLineStringM(2005),
	MultiPolygonM(2006),
	GeometryCollectionM(2007),
	CircularStringM(2008),
	CompoundCurveM(2009),
	CurvePolygonM(2010),
	MultiCurveM(2011),
	MultiSurfaceM(2012),
	PolyhedralSurfaceM(2015),
	TINM(2016),
	TriangleM(2017),
	
	Solid(2020),
	MultiSolid(2021),
	
	PointZM(3001),
	LineStringZM(3002),
	PolygonZM(3003),
	MultiPointZM(3004),
	MultiLineStringZM(3005),
	MultiPolygonZM(3006),
	GeometryCollectionZM(3007),
	CircularStringZM(3008),
	CompoundCurveZM(3009),
	CurvePolygonZM(3010),
	MultiCurveZM(3011),
	MultiSurfaceZM(3012),
	PolyhedralSurfaceZM(3015),
	TINZM(3016),
	TriangleZM(3017);
	
	private final int type;
	
	private WKBTypeCode(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
    public static WKBTypeCode fromValue(int type) {
        for (WKBTypeCode code: WKBTypeCode.values()) {
            if (code.getType() == type) {
                return code;
            }
        }
        throw new IllegalArgumentException(Integer.toString(type));
    }
    
    public static boolean is3D(WKBTypeCode typeCode) {
    	int type = typeCode.getType();
    	
    	if(type >= 1001 && type <= 1017) {
    		return true;
    	} else if(type == 2020 || type == 2021) {
    		return true;
    	} else if(type >= 3001 && type <= 3017) {
    		return true;
    	}
    	return false;
    }
    
    public static boolean isMeasured(WKBTypeCode typeCode) {
    	int type = typeCode.getType();
    	
    	if(type >= 2001 && type <= 2017) {
    		return true;
    	} else if(type >= 3001 && type <= 3017) {
    		return true;
    	}
    	return false;
    }
}
