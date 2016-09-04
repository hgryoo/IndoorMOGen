/**
 * 
 */
package edu.pnu.importexport.store.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.pnu.common.BindingNode;
import edu.pnu.common.geometry.CommonGeometryFactory;
import edu.pnu.common.geometry.model.STLineString;
import edu.pnu.common.geometry.model.STMultiSurface;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.model.STPolygon;
import edu.pnu.common.geometry.model.STSurface;
import net.opengis.gml.v_3_1_1.DirectPositionType;

/**
 * @author hgryoo
 *
 */
public class GeometryConvertUtil {
	
	//CityGML always use 3D Geometries
	private static CommonGeometryFactory gf = new CommonGeometryFactory(true, false);
	
	public static STPoint createPointFromDoubleList(List<Double> dList) {
		STPoint point = gf.createPoint(dList);
		return point;
	}
	
	public static STPoint createPointFromDirectPostion(BindingNode node) {
		
		List<Double> value = (List<Double>) node.getAttribute("VALUE");
		
		//remove nulls from list
		value.removeAll(Collections.singleton(null));
		
		
		STPoint point = createPointFromDoubleList(value);
		
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
	
	public static STLineString createRingFromAbstractRingPropertyType(BindingNode node) {
		STLineString lineString = null;

		//TODO : consider another node types
		BindingNode directPositionList = node.getAssociation("DIRECTPOSITIONLIST");
		if(directPositionList != null) {
			STPoint[] points = createPointsFromDirectPositionList(directPositionList);
			if(points != null) {
				lineString = gf.createLineString(points);
				//System.out.println("inserted Coodinates = " + lineString.asText());
			}
		}
		
		List<BindingNode> directPositionNode = node.getCollection("DIRECTPOSITION");
		if(directPositionNode != null && directPositionNode.size() > 0) {
			STPoint[] points = new STPoint[directPositionNode.size()];
			for(int i = 0; i < directPositionNode.size(); i++) {
				points[i] = createPointFromDirectPostion(directPositionNode.get(i));
			}
			lineString = gf.createLineString(points);
		}
		
		return lineString;
	}
	
	public static STPolygon createPolygonFromPolygonType(BindingNode node) {
		STPolygon polygon = null;
		
		BindingNode exteriorNode = node.getAssociation("EXTERIOR");
		if(exteriorNode != null) {
			STLineString exterior = createRingFromAbstractRingPropertyType(exteriorNode);
			
			STLineString[] interior = null;
			List<BindingNode> interiorNode = node.getCollection("INTERIOR");
			if(interiorNode != null && interiorNode.size() > 0) {
				interior = new STLineString[interiorNode.size()];
				for(int i = 0; i < interiorNode.size(); i++) {
					interior[i] = createRingFromAbstractRingPropertyType(interiorNode.get(i));
				}
			}
			
			if(exterior != null) {
				polygon = gf.createPolygon(exterior, interior);
				//System.out.println(polygon.asText());
			}
		}
		
		return polygon;
	}
	
	public static STMultiSurface createMultiSurfaceFromPolygons(STPolygon[] polygons) {
		STMultiSurface multisurface = null;
		
		if(polygons != null) {
			multisurface = gf.createMultiSurface(polygons);
		}
		
		return multisurface;
	}
	
	public static STMultiSurface createMultiSurfaceFromSurfaces(STMultiSurface[] multiSurfaces, STPolygon[] polygons) {
		
		STMultiSurface multisurface = null;
		
		List<STSurface> surfaces = new ArrayList<STSurface>();
		if(polygons != null) {
			surfaces.addAll(Arrays.asList(polygons));
		}
		if(multiSurfaces != null) {
			for(int i=0; i<multiSurfaces.length; i++) {
				STMultiSurface m = multiSurfaces[i];
				STSurface[] s = m.getSurfaces();
				surfaces.addAll(Arrays.asList(s));
			}
			
		}
		if(surfaces != null && surfaces.size() > 0) {
			multisurface = gf.createMultiSurface(surfaces.toArray( new STSurface[surfaces.size()]));
		}
		return multisurface;
	}
	
	public static STPoint convertDirectPositionTypetoPoint(DirectPositionType dpt) {
		List<Double> values = dpt.getValue();
		
		Double[] dwarr = new Double[values.size()];
		values.toArray(dwarr);
		
		double[] darr = toDoublePrimitive(dwarr);
		
		STPoint point = gf.createPoint(darr);
		
		return point;
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
