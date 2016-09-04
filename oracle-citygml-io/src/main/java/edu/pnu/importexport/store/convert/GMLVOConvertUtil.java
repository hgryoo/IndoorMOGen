/**
 * 
 */
package edu.pnu.importexport.store.convert;

/**
 * @author hgryoo
 *
 */
/*public class GMLVOConvertUtil {

	public static Envelope createEnvelope(BindingNode node) {
		Envelope envelope = new Envelope();
		
		envelope.setSrsName((String) node.getAttribute("SRSNAME"));
		envelope.setSrsDimension((Integer) node.getAttribute("SRSDIMENSION"));
		
		//Geometries
		Object lower = node.getAttribute("LOWERCORNER/VALUE");
		if(lower != null) {
			List<Double> lowerCornerValue = (List<Double>) lower;
			STPoint lowerCornerGeometry = GeometryConvertUtil.createPointFromDoubleList(lowerCornerValue);
			envelope.setLowerCorner( lowerCornerGeometry);
		}
		
		Object upper = node.getAttribute("UPPERCORNER/VALUE");
		if(upper != null) {
			List<Double> upperCornerValue = (List<Double>) upper;
			STPoint upperCornerGeometry = GeometryConvertUtil.createPointFromDoubleList(upperCornerValue);
			envelope.setUpperCorner(upperCornerGeometry);
		}
		
		return envelope;
	}

	public static Geometry createGeometry(BindingNode node) {
		Geometry geometry = null;
		
		String geometryType = (String) node.getAttribute("GEOMETRYTYPE");
		
		if("MultiSurfaceType".equalsIgnoreCase(geometryType)) {
			MultiSurface multiSurface = createMultiSurface(node);
			geometry =  multiSurface;
		}
		
		return geometry;
	}
	public static Point createPoint(BindingNode node) {
		Point point = new Point();
		
		
		
		return point;
	}
	public static Curve createCurve(BindingNode node) {
		Curve curve = new Curve();
		
		return curve;
	}
	
	public static Surface createSurface(BindingNode node) {
		
		Surface surface = new Surface();
		
		surface.setGmlId((String)node.getAttribute("GMLID"));
		surface.setSrsName((String)node.getAttribute("SRSNAME"));
		surface.setSrsDimension((Integer)node.getAttribute("SRSDIMENSION"));
		surface.setGeometryType(surface.getClass().getSimpleName());
		
		String XLinkValue = (String) node.getAttribute("HREF");
		if(XLinkValue != null) surface.setIsXLink(true);
		List<Surface> child = surface.getChild();
		
		if(node.getAssociation("POLYGONTYPE") != null) {
			BindingNode polygonNode = node.getAssociation("POLYGONTYPE");
			STPolygon polygon = GeometryConvertUtil.createPolygonFromPolygonType(polygonNode);
			if(polygon != null) {
				surface.setPolygonGeometry(polygon);
			}
		} else if(node.getAssociation("ORIENTABLESURFACETYPE") != null) {
			BindingNode orientableSurfaceNode = node.getAssociation("ORIENTABLESURFACETYPE");
			
			String orientation = (String) orientableSurfaceNode.getAttribute("ORIENTATION");
			if("-".equalsIgnoreCase(orientation)) {
				surface.setReverse(true);
			}

			BindingNode baseSurfaceNode = orientableSurfaceNode.getAssociation("BASESURFACE");
			if(baseSurfaceNode != null) {
				Surface baseSurface = createSurface(baseSurfaceNode);
				if(surface.getRoot() == null) {
					baseSurface.setRoot(surface);
				} else {
					baseSurface.setRoot(surface.getRoot());
				}
				baseSurface.setParent(surface);
				
				//GEOMETRY
				STMultiSurface geom = null;
				if(baseSurface.getPolygonGeometry() != null) {
					STPolygon[] polygons = new STPolygon[1];
					polygons[0] = (STPolygon) WKBGeometryParsingUtil.createPolygon(baseSurface.getPolygonGeometry());
					geom = GeometryConvertUtil.createMultiSurfaceFromPolygons( polygons );
					if(geom != null) {
						surface.setGeometry(geom);
					}
				}
				else if(baseSurface.getGeometry() != null) {
					surface.setGeometry(baseSurface.getGeometry());
				}
				child.add(baseSurface);
			} else {
				throw new IllegalArgumentException("Empty BaseSurface in OrientableSurfaceType");
			}
			
			//Geometry
			
		} else if(node.getAssociation("SURFACETYPE") != null) {
			
			//TODO Geometry
		} else if(node.getAssociation("COMPOSITESURFACETYPE") != null) {
			BindingNode compositeSurfaceNode = node.getAssociation("COMPOSITESURFACETYPE");
			
			List<BindingNode> surfaceMember = compositeSurfaceNode.getCollection("SURFACEMEMBER");
			for(BindingNode surfaceNode : surfaceMember) {
				Surface s = createSurface(surfaceNode);
				
				if(surface.getRoot() == null) {
					s.setRoot(surface);
				} else {
					s.setRoot(surface.getRoot());
				}
				s.setParent(surface);
				surface.setComposite(true);
				child.add(s);
			}
			
			//TODO Geometry
		}
		
		//TODO Geometry
		
		return surface;
	}
	
	public static Solid createSolid(BindingNode node) {
		Solid solid = new Solid();
		
		//Non Geometry Attributes
		solid.setGmlId((String)node.getAttribute("GMLID"));
		solid.setSrsName((String)node.getAttribute("SRSNAME"));
		solid.setSrsDimension((Integer)node.getAttribute("SRSDIMENSION"));
		solid.setGeometryType(solid.getClass().getSimpleName());
		
		BindingNode exteriorNode = node.getAssociation("EXTERIOR");
		if(exteriorNode != null) {
			Surface exterior = createSurface(exteriorNode);
			solid.setExterior(exterior);
		}
		
		List<Surface> interiorSurface = solid.getInterior();
		List<BindingNode> interiorNode = node.getCollection("INTERIOR");
		for(BindingNode intNode : interiorNode) {
			Surface interior = createSurface(intNode);
			interiorSurface.add(interior);
		}
		
		//Geometry Attributes
		
		return solid;
	}
	
	public static MultiPoint createMultiPoint(BindingNode node) {
		MultiPoint multiPoint = new MultiPoint();
		
		multiPoint.setGmlId((String)node.getAttribute("GMLID"));
		multiPoint.setSrsName((String)node.getAttribute("SRSNAME"));
		multiPoint.setSrsDimension((Integer)node.getAttribute("SRSDIMENSION"));
		multiPoint.setGeometryType(multiPoint.getClass().getSimpleName());
		
		String XLinkValue = (String) node.getAttribute("HREF");
		if(XLinkValue != null) multiPoint.setIsXLink(true);
		
		//Geometry Attributes
		List<Point> pointMember = multiPoint.getPoints();
		List<BindingNode> pointMemberNodes = node.getCollection("POINTMEMBER");
		for(BindingNode pointNode : pointMemberNodes) {
			Point point = createPoint(pointNode);
			pointMember.add(point);
		}
		
		//GEOMETRY
		
		return multiPoint;
	}
	
	public static MultiCurve createMultiCurve(BindingNode node) {
		MultiCurve multiCurve = new MultiCurve();
		
		multiCurve.setGmlId((String)node.getAttribute("GMLID"));
		multiCurve.setSrsName((String)node.getAttribute("SRSNAME"));
		multiCurve.setSrsDimension((Integer)node.getAttribute("SRSDIMENSION"));
		multiCurve.setGeometryType(multiCurve.getClass().getSimpleName());
		
		String XLinkValue = (String) node.getAttribute("HREF");
		if(XLinkValue != null) multiCurve.setIsXLink(true);
		
		//Geometry Attributes
		List<Curve> curveMember = multiCurve.getCurves();
		List<BindingNode> curveMemberNodes = node.getCollection("CURVEMEMBER");
		for(BindingNode curveNode : curveMemberNodes) {
			Curve curve = createCurve(curveNode);
			curveMember.add(curve);
		}
		
		//GEOMETRY
		return multiCurve;
	}
	
	public static MultiSurface createMultiSurface(BindingNode node) {
		MultiSurface multiSurface = new MultiSurface();
		//Non Geometry Attributes
		multiSurface.setGmlId((String)node.getAttribute("GMLID"));
		multiSurface.setSrsName((String)node.getAttribute("SRSNAME"));
		multiSurface.setSrsDimension((Integer)node.getAttribute("SRSDIMENSION"));
		multiSurface.setGeometryType(multiSurface.getClass().getSimpleName());
		
		String XLinkValue = (String) node.getAttribute("HREF");
		if(XLinkValue != null) multiSurface.setIsXLink(true);
		
		//Geometry Attributes
		List<Surface> surfaceMember = multiSurface.getSurfaces();
		List<BindingNode> surfaceMemberNodes = node.getCollection("SURFACEMEMBER");
		for(BindingNode surfaceNode : surfaceMemberNodes) {
			Surface surface = createSurface(surfaceNode);
			surfaceMember.add(surface);
		}
		
		
		
		
		
		//TODO (make surface)
		
		
		return multiSurface;
	}
	
	public static GeometryCollection createGeometryCollection(BindingNode node) {
		GeometryCollection geometryCollection = new GeometryCollection();
		
		return geometryCollection;
	}
	*/

//}
