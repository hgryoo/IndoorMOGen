/**
 * 
 */
package edu.pnu.importexport.store.convert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.pnu.common.BindingNode;
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

/**
 * @author hgryoo
 *
 */
public class PostGISGeometryConvertUtil extends NodeVOConvertUtil {
	
	//CityGML always use 3D Geometries
	private static CommonGeometryFactory gf = new CommonGeometryFactory(true, false);
	
/*	public static STGeometryCollection convertGeometryCollection(BindingNode node) {
		
	}
	*/
	public static STGeometry convertGeometry(BindingNode node) {
		STGeometry geom = null;
		String geometryType = (String) node.getAttribute("GEOMETRYTYPE");
		
		if("MultiSurfaceType".equalsIgnoreCase(geometryType)) {
			geom = convertMultiSurface(node); 
		}
		else if("PolygonType".equalsIgnoreCase(geometryType)) {
			geom = convertPolygon(node);
		}
		//TODO
		
		return geom;
	}
	
	public static STSolid convertSolid(BindingNode node) {
		
		//CompositeSolid
		List<BindingNode> solidMember = node.getCollection("SOLIDMEMBER");
		if(!solidMember.isEmpty()) {
			throw new UnsupportedOperationException();
		}
		
		//Solid
		BindingNode exteriorNode = node.getAssociation("EXTERIOR");
		STSurface exteriorSurface = null;
		if(exteriorNode != null) {
			exteriorSurface = createASurface(exteriorNode);
		}
		
		List<BindingNode> interiorNode = node.getCollection("INTERIOR");
		List<STSurface> interior = new ArrayList<STSurface>();
		for(BindingNode n : interiorNode ) {
			STSurface s = createASurface(n);
			if(s != null) interior.add(s);
		}
		STSurface[] interiorSurfaceArray =  interior.toArray(new STSurface[interior.size()]);
		
		STSolid solid = gf.createSolid(exteriorSurface, interiorSurfaceArray);
		return solid;
	}

	public static STMultiSurface convertMultiSurface(BindingNode node) {
		STMultiSurface multisurface = null;
		
		List<BindingNode> surfaceMemberNodes = node.getCollection("SURFACEMEMBER");
		List<STSurface> surfaceMember = new ArrayList<STSurface>();
		for(int i = 0; i < surfaceMemberNodes.size(); i++) {
			STSurface s = createASurface(surfaceMemberNodes.get(i));
			
			//MultiSurfaceType can not include polyhedralSurfaceType in PostGIS
			if(s instanceof STPolyhedralSurface) {
				STPolyhedralSurface ph = (STPolyhedralSurface) s;
				for(int j = 0; j < ph.numPatches(); j++) {
					STSurface p = ph.PatchN(j);
					surfaceMember.add(p);
				}
			} else {
				surfaceMember.add(s);
			}
		}
		
		STSurface[] surfaces = new STSurface[surfaceMember.size()];
		surfaceMember.toArray(surfaces);
		
		multisurface = gf.createMultiSurface(surfaces);
		return multisurface;
	}
	
	public static STSurface createASurface(BindingNode node) {
		STSurface surface = null;
		
		if(node.getAssociation("POLYGONTYPE") != null) {
			BindingNode polygonNode = node.getAssociation("POLYGONTYPE");
			STPolygon polygon = convertPolygon(polygonNode);
			surface = polygon;
			
		} else if(node.getAssociation("COMPOSITESURFACETYPE") != null) {
			BindingNode compositeSurfaceNode = node.getAssociation("COMPOSITESURFACETYPE");
			surface = convertCompositeSurface(compositeSurfaceNode);
			
		} else if(node.getAssociation("ORIENTABLESURFACETYPE") != null) {
			BindingNode orientableSurfaceNode = node.getAssociation("ORIENTABLESURFACETYPE");
			String orientation = (String) orientableSurfaceNode.getAttribute("ORIENTATION");
			
			BindingNode baseSurfaceNode = orientableSurfaceNode.getAssociation("BASESURFACE");
			if(baseSurfaceNode != null) {
				surface = createASurface(baseSurfaceNode);
				if("-".equalsIgnoreCase(orientation)) {
					reverseSurface(surface);
				}
			} else {
				throw new IllegalArgumentException("BaseSurface is empty");
			}
			
		} else if(node.getAssociation("SURFACETYPE") != null) {
			//TODO
			throw new UnsupportedOperationException();
		}
		
		return surface;
	}
	
	private static void reverseSurface(STSurface surface) {
		if(surface instanceof STPolygon) {
			STPolygon p = (STPolygon) surface;
			
			STLineString ext = p.exteriorRing();
			STLineString rext = ext.reverse();
			
			STLineString[] interiors = new STLineString[p.numInteriorRing()];
			for(int i = 0 ; i < p.numInteriorRing(); i++) {
				STLineString iRing = p.interiorRingN(i);
				STLineString rIRing = iRing.reverse();
				interiors[i] = rIRing;
			}
			surface = gf.createPolygon(rext, interiors);
		}
		else if(surface instanceof STPolyhedralSurface) {
			STPolyhedralSurface ph = (STPolyhedralSurface) surface;
			
			for(int i = 0 ; i < ph.numPatches(); i ++) {
				STPolygon p = ph.PatchN(i);
				reverseSurface(p);
			}
		}
		else {
			throw new UnsupportedOperationException();
		}
	}
	
	public static STPolyhedralSurface convertCompositeSurface(BindingNode node) {
		List<BindingNode> surfaceMemberNodes = node.getCollection("SURFACEMEMBER");
		List<STPolygon> surfaceMember = new ArrayList<STPolygon>();
		for(int i = 0; i<surfaceMemberNodes.size(); i++) {
			STSurface sm = createASurface(surfaceMemberNodes.get(i));
			
			if(sm.geometryType().equalsIgnoreCase("Polygon")) {
				STPolygon p = (STPolygon) sm;
				surfaceMember.add(p);
			} 
			else if(sm.geometryType().equalsIgnoreCase("Triangle")) {
				STPolygon p = (STPolygon) sm;
				surfaceMember.add(p);
			}
			else if(sm.geometryType().equalsIgnoreCase("PolyhedralSurface")) {
				STPolyhedralSurface p = (STPolyhedralSurface) sm;
				for(int j = 0; j < p.numPatches(); j++) {
					surfaceMember.add(p.PatchN(j));
				}
			}
			else if(sm.geometryType().equalsIgnoreCase("TIN")) {
				STTIN p = (STTIN) sm;
				for(int j = 0; j < p.numPatches(); j++) {
					surfaceMember.add(p.PatchN(j));
				}
			}
		}
		
		STPolygon[] patches = new STPolygon[surfaceMember.size()];
		surfaceMember.toArray(patches);
		
		STPolyhedralSurface polyhedralSurface = gf.createPolyhedralSurface(patches);
		return polyhedralSurface;
	}
	
	//TODO : surfacePatch or TIN
	public static STPolyhedralSurface convertSurface(BindingNode node) {
		throw new UnsupportedOperationException();
	}
	
	public static STPolygon convertPolygon(BindingNode node) {
		STPolygon polygon = null;
		BindingNode exteriorNode = node.getAssociation("EXTERIOR");
		if(exteriorNode != null) {
			STLineString exterior = convertRing(exteriorNode);
			
			STLineString[] interior = null;
			List<BindingNode> interiorNode = node.getCollection("INTERIOR");
			if(interiorNode != null && interiorNode.size() > 0) {
				interior = new STLineString[interiorNode.size()];
				for(int i = 0; i < interiorNode.size(); i++) {
					interior[i] = convertRing(interiorNode.get(i));
				}
			}
			
			if(exterior != null) {
				polygon = gf.createPolygon(exterior, interior);
				//System.out.println(polygon.asText());
			}
		}
		return polygon;
	}
	
	public static STLineString convertRing(BindingNode node) {
		STLineString lineString = null;

		//TODO : consider another node types
		BindingNode directPositionList = node.getAssociation("DIRECTPOSITIONLIST");
		if(directPositionList != null) {
			STPoint[] points = createPointsFromDirectPositionList(directPositionList);
			
			if(points != null) {
				lineString = gf.createLineString(points);
				//System.out.println("inserted Coodinates = " + lineString.asText());
			}
			
			/*if(!lineString.startPoint().equals(lineString.endPoint())) {
				System.out.println("ÀÌ³ðºÁ¶ó Ã£¾Ò´Ù");
				System.out.println(lineString.toString());
			}*/

		}
		
		List<BindingNode> directPositionNode = node.getCollection("DIRECTPOSITION");
		if(directPositionNode != null && directPositionNode.size() > 0) {
			STPoint[] points = new STPoint[directPositionNode.size()];
			for(int i = 0; i < directPositionNode.size(); i++) {
				points[i] = createPointFromDirectPostion(directPositionNode.get(i));
			}
			lineString = gf.createLineString(points);
			
			/*if(!lineString.startPoint().equals(lineString.endPoint())) {
				System.out.println("ÀÌ³ðºÁ¶ó Ã£¾Ò´Ù");
				System.out.println(lineString.toString());
			}*/
		}
		
		return lineString;
	}
	
	public static STPoint convertPoint(BindingNode node) {
		STPoint point = null;
		
		BindingNode posNode = node.getAssociation("POS");
		if(posNode != null) {
			point = createPointFromDirectPostion(posNode);
		}
		
		//TODO
		//Coordinates Type
		
		//TODO
		//Coord Type
		
		return point;
	}
	
	
	public static STPoint[] createPointsFromDirectPositionList(BindingNode node) {
		STPoint[] points = null;
		
		List<STPoint> pointList;
		
		Object o = node.getAttribute("VALUE");
		if(o != null) {

			pointList = new ArrayList<STPoint>();
			
			List<Double> doubleList = (List<Double>) o;
			List<Double> dList = new ArrayList<Double>();
			for(int i = 0; i < doubleList.size(); i = i + 3) {
				Double x = doubleList.get(i);
				Double y = doubleList.get(i + 1);
				Double z = doubleList.get(i + 2);
				
				dList.add(x);
				dList.add(y);
				dList.add(z);
				
				STPoint p = createPointFromDoubleList(dList);
				pointList.add(p);
				dList.clear();
			}
			points = pointList.toArray(new STPoint[pointList.size()]);
		}
		
		return points;
	}
	
	public static STPoint createPointFromDirectPostion(BindingNode node) {
		
		List<Double> value = (List<Double>) node.getAttribute("VALUE");
		
		//remove nulls from list
		value.removeAll(Collections.singleton(null));
		
		STPoint point = createPointFromDoubleList(value);
		
		return point;
	}
	
	public static STPoint createPointFromDoubleList(List<Double> dList) {
		STPoint point = gf.createPoint(dList);
		return point;
	}

	public static STGeometryCollection wrapGeometries(STGeometry[] geoms) {
		STGeometryCollection geomCollection = gf.createGeometryCollection(geoms);
		return geomCollection;
	}
}
