/**
 * 
 */
package edu.pnu.importexport.store.traversal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.pnu.common.BindingNode;
import edu.pnu.common.XLinkSymbolMap;
import net.opengis.citygml.building.v_2_0.AbstractBuildingType;
import net.opengis.citygml.building.v_2_0.BuildingType;
import net.opengis.citygml.relief.v_2_0.ReliefFeatureType;
import net.opengis.gml.v_3_1_1.AbstractCurveType;
import net.opengis.gml.v_3_1_1.AbstractFeatureCollectionType;
import net.opengis.gml.v_3_1_1.AbstractFeatureType;
import net.opengis.gml.v_3_1_1.AbstractGMLType;
import net.opengis.gml.v_3_1_1.AbstractGeometricAggregateType;
import net.opengis.gml.v_3_1_1.AbstractGeometricPrimitiveType;
import net.opengis.gml.v_3_1_1.AbstractGeometryType;
import net.opengis.gml.v_3_1_1.AbstractRingPropertyType;
import net.opengis.gml.v_3_1_1.AbstractRingType;
import net.opengis.gml.v_3_1_1.AbstractSolidType;
import net.opengis.gml.v_3_1_1.AbstractSurfaceType;
import net.opengis.gml.v_3_1_1.BoundingShapeType;
import net.opengis.gml.v_3_1_1.CodeType;
import net.opengis.gml.v_3_1_1.CompositeCurveType;
import net.opengis.gml.v_3_1_1.CompositeSolidType;
import net.opengis.gml.v_3_1_1.CompositeSurfaceType;
import net.opengis.gml.v_3_1_1.CoordType;
import net.opengis.gml.v_3_1_1.CoordinatesType;
import net.opengis.gml.v_3_1_1.CurveArrayPropertyType;
import net.opengis.gml.v_3_1_1.CurvePropertyType;
import net.opengis.gml.v_3_1_1.DirectPositionListType;
import net.opengis.gml.v_3_1_1.DirectPositionType;
import net.opengis.gml.v_3_1_1.EnvelopeType;
import net.opengis.gml.v_3_1_1.FeaturePropertyType;
import net.opengis.gml.v_3_1_1.GeometryPropertyType;
import net.opengis.gml.v_3_1_1.LengthType;
import net.opengis.gml.v_3_1_1.LineStringSegmentArrayPropertyType;
import net.opengis.gml.v_3_1_1.LineStringType;
import net.opengis.gml.v_3_1_1.LinearRingType;
import net.opengis.gml.v_3_1_1.LocationPropertyType;
import net.opengis.gml.v_3_1_1.MultiCurvePropertyType;
import net.opengis.gml.v_3_1_1.MultiCurveType;
import net.opengis.gml.v_3_1_1.MultiPointPropertyType;
import net.opengis.gml.v_3_1_1.MultiPointType;
import net.opengis.gml.v_3_1_1.MultiSurfacePropertyType;
import net.opengis.gml.v_3_1_1.MultiSurfaceType;
import net.opengis.gml.v_3_1_1.ObjectFactory;
import net.opengis.gml.v_3_1_1.OrientableSurfaceType;
import net.opengis.gml.v_3_1_1.PointArrayPropertyType;
import net.opengis.gml.v_3_1_1.PointPropertyType;
import net.opengis.gml.v_3_1_1.PointType;
import net.opengis.gml.v_3_1_1.PolygonType;
import net.opengis.gml.v_3_1_1.RingType;
import net.opengis.gml.v_3_1_1.SignType;
import net.opengis.gml.v_3_1_1.SolidPropertyType;
import net.opengis.gml.v_3_1_1.SolidType;
import net.opengis.gml.v_3_1_1.StringOrRefType;
import net.opengis.gml.v_3_1_1.SurfaceArrayPropertyType;
import net.opengis.gml.v_3_1_1.SurfacePatchArrayPropertyType;
import net.opengis.gml.v_3_1_1.SurfacePropertyType;
import net.opengis.gml.v_3_1_1.SurfaceType;
import net.opengis.gml.v_3_1_1.TinType;

/**
 * @author hgryoo
 *
 */
public class JGMLTraversalUtil extends JAXBTraversalUtil{
	
	private static Logger LOGGER = LoggerFactory.getLogger(JGMLTraversalUtil.class);
	
	public static BindingNode traverseAbstractGMLType(AbstractGMLType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = GML Id, Name, Description ========== */
		node.addAttribute("GMLID", target.getId());
		//TODO: consider multiple name values.
		List<JAXBElement<CodeType>> name = target.getName();
		if(!name.isEmpty()) {
			JAXBElement<CodeType> je = name.get(0);
			if(je != null) {
				CodeType nameCodeType = je.getValue();
				if(nameCodeType != null) node.addAssociation("NAME", traverseCodeType(nameCodeType, new BindingNode(), symbolMap));
			}
		}
		StringOrRefType description = target.getDescription();
		if(description != null) {
			node.addAssociation("DESCRIPTION", traverseStringOrRefType(target.getDescription(), new BindingNode(), symbolMap));
		}
		return node;
	}
	
	public static BindingNode traverseAbstractFeatureType(AbstractFeatureType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* =========== */
	    /* Super Class */
	    /* =========== */
		node = traverseAbstractGMLType(target, node, symbolMap);
		/* ============ */
	    /* Association  */
	    /* ============ */
		/* = Boundedby Envelope ========== */
		BoundingShapeType boundedBy = target.getBoundedBy();
		if(boundedBy != null) {
			node.addAssociation("BOUNDEDBY", traverseBoundingShapeType(boundedBy, new BindingNode(), symbolMap));
		}
		//TODO
		//location
		JAXBElement<? extends LocationPropertyType> je = target.getLocation();
		if(je != null) {
			LocationPropertyType lp = je.getValue();
			if(lp != null) {
				node.addAssociation("LOCATION", traverseLocationPropertyType(lp, new BindingNode(), symbolMap));
			}
		}
		return node;
	}
	
	public static BindingNode traverseAbstractFeatureCollectionType(AbstractFeatureCollectionType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* =========== */
	    /* Super Class */
	    /* =========== */
		node = traverseAbstractFeatureType(target, node, symbolMap);
		/* ============ */
	    /* Association  */
	    /* ============ */
		List<JAXBElement<FeaturePropertyType>> featureMembers = target.getFeatureMember();
		for(JAXBElement<FeaturePropertyType> jFM : featureMembers) {
			if(jFM != null) {
				FeaturePropertyType fp = jFM.getValue();
				BindingNode fpNode = new BindingNode();
				fpNode = traverseFeaturePropertyType(fp, fpNode, symbolMap);
				node.addCollection("FEATURES", fpNode);
			}
		}
		
		return node;
	}
	public static BindingNode traverseLocationPropertyType(LocationPropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = XLink attributes ========== */
		node.addAttribute("REMOTESCHEMA", target.getRemoteSchema());
		node.addAttribute("HREF", target.getHref());
		node.addAttribute("ROLE", target.getRole());
		node.addAttribute("ARCROLE", target.getArcrole());
		node.addAttribute("TITLE", target.getTitle());
		if(target.getType() != null) {
			node.addAttribute("TYPE", target.getType().value());
		}
		if(target.getShow() != null) {
			node.addAttribute("SHOW", target.getShow().value());
		}
		if(target.getActuate() != null) {
			node.addAttribute("ACTUATE", target.getActuate().value());
		}
		
		if(target.getHref() != null) {
			//TODO
		}
		
		// TODO
		
		return node;
	}

	public static BindingNode traverseFeaturePropertyType(FeaturePropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = XLink attributes ========== */
		node.addAttribute("REMOTESCHEMA", target.getRemoteSchema());
		node.addAttribute("HREF", target.getHref());
		node.addAttribute("ROLE", target.getRole());
		node.addAttribute("ARCROLE", target.getArcrole());
		node.addAttribute("TITLE", target.getTitle());
		if(target.getType() != null) {
			node.addAttribute("TYPE", target.getType().value());
		}
		if(target.getShow() != null) {
			node.addAttribute("SHOW", target.getShow().value());
		}
		if(target.getActuate() != null) {
			node.addAttribute("ACTUATE", target.getActuate().value());
		}
		
		Object feature = null;
		if(target.getHref() != null) {
			feature = symbolMap.getObjectById(target.getHref().replaceAll("#", ""));
		} else {
			feature = target.getFeature();
		}
		/* ============ */
	    /* Association  */
	    /* ============ */
		//deal with polymorphism
		if(feature != null) {
			if(feature instanceof JAXBElement) {
				feature = ((JAXBElement)feature).getValue();
			}
			
			BindingNode featureNode = new BindingNode();
			if(feature instanceof AbstractBuildingType) {
				node.addAttribute("FEATURETYPE", "Building");
				featureNode = JBuildingTraversalUtil.traverseAbstractBuildingType((BuildingType) feature, featureNode, symbolMap);
			} else if( feature instanceof ReliefFeatureType) {
				node.addAttribute("FEATURETYPE", "ReliefFeature");
			}
			
			
			
			node.addAssociation("FEATURE", featureNode);
		}		
		return node;
	}
	
	public static BindingNode traverseStringOrRefType(StringOrRefType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = XLink attributes ========== */
		node.addAttribute("REMOTESCHEMA", target.getRemoteSchema());
		node.addAttribute("HREF", target.getHref());
		node.addAttribute("ROLE", target.getRole());
		node.addAttribute("ARCROLE", target.getArcrole());
		node.addAttribute("TITLE", target.getTitle());
		if(target.getType() != null) {
			node.addAttribute("TYPE", target.getType().value());
		}
		if(target.getShow() != null) {
			node.addAttribute("SHOW", target.getShow().value());
		}
		if(target.getActuate() != null) {
			node.addAttribute("ACTUATE", target.getActuate().value());
		}
		
		//Value
		String value = null;
		if(target.getHref() != null) {
			value = (String) symbolMap.getObjectById(target.getHref().replaceAll("#", ""));
		} else {
			value = target.getValue();
		}
		node.addAttribute("VALUE", value);
		
		return node;
	}

	public static BindingNode traverseCodeType(CodeType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		node.addAttribute("VALUE", target.getValue());
		node.addAttribute("CODESPACE", target.getCodeSpace());
		return node;
	}
	
	/* ========================= */
	/* Geometry Property Types   */
	/* ========================= */
	public static BindingNode traverseAbstractGeometryType(AbstractGeometryType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* =========== */
	    /* Super Class */
	    /* =========== */
		node = traverseAbstractGMLType(target, node, symbolMap);
		/* ========== */
	    /* Attributes */
	    /* ========== */
		node.addAttribute("GID", target.getGid());
		node.addAttribute("SRSNAME", target.getSrsName());
		if(target.getSrsDimension() != null) {
			node.addAttribute("SRSDIMENSION", target.getSrsDimension().intValue());
		}
		//TODO : axisLabels, uomLabels
		return node;
	}
	
	public static BindingNode traverseAbstractGeometricPrimitiveType(AbstractGeometricPrimitiveType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* =========== */
	    /* Super Class */
	    /* =========== */
		node = traverseAbstractGeometryType(target, node, symbolMap);
		return node;
	}
	
	public static BindingNode traverseAbstractGeometricAggregateType(AbstractGeometricAggregateType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* =========== */
	    /* Super Class */
	    /* =========== */
		node = traverseAbstractGeometryType(target, node, symbolMap);
		return node;
	}
	
	
	//GeometryProperty (Polymorphism)
	public static BindingNode traverseGeometryPropertyType(GeometryPropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = XLink attributes ========== */
		node.addAttribute("REMOTESCHEMA", target.getRemoteSchema());
		node.addAttribute("HREF", target.getHref());
		node.addAttribute("ROLE", target.getRole());
		node.addAttribute("ARCROLE", target.getArcrole());
		node.addAttribute("TITLE", target.getTitle());
		if(target.getType() != null) {
			node.addAttribute("TYPE", target.getType().value());
		}
		if(target.getShow() != null) {
			node.addAttribute("SHOW", target.getShow().value());
		}
		if(target.getActuate() != null) {
			node.addAttribute("ACTUATE", target.getActuate().value());
		}
		
		
		JAXBElement<? extends AbstractGeometryType> jGeometry = null;
		if(target.getHref() != null) {
			String href = target.getHref().replaceAll("#", "");
			Object refObject = symbolMap.getObjectById(href);
			if(refObject instanceof JAXBElement) {
				jGeometry = (JAXBElement<? extends AbstractGeometryType>) symbolMap.getObjectById(href);
			} else if(refObject instanceof AbstractSurfaceType) {
				jGeometry = new ObjectFactory().createGeometry((AbstractGeometryType) refObject);
			}
		} else {
			jGeometry = target.getGeometry();
		}
		if(jGeometry != null) {
			AbstractGeometryType aGeom = jGeometry.getValue();
			node.addAttribute("GEOMETRYTYPE", aGeom.getClass().getSimpleName());
			
			if(aGeom instanceof MultiSurfaceType) {
				node = traverseMultiSurfaceType((MultiSurfaceType) aGeom, node, symbolMap);
			}
			else if(aGeom instanceof PolygonType) {
				node = traversePolygonType((PolygonType) aGeom, node, symbolMap);
			}
			
		}
		return node;
	}
	
	public static BindingNode traverseDirectPositionType(DirectPositionType target, BindingNode node, XLinkSymbolMap symbolMap) {
	    //VALUE
		List<Double> value = target.getValue();
		node.addAttribute("VALUE", value);
		//SRSNAME
	    String srsName = target.getSrsName();
	    node.addAttribute("SRSNAME", srsName);
	    //SRSDIMENSION
	    BigInteger srsDimension = target.getSrsDimension();
	    if(srsDimension != null) {
			node.addAttribute("SRSDIMENSION", srsDimension.intValue());
		}
	    //TODO
	    List<String> axisLabels;
	    List<String> uomLabels;
		return node;
	}
	
	public static BindingNode traverseDirectPositionListType(DirectPositionListType target, BindingNode node, XLinkSymbolMap symbolMap) {
		//VALUE
		List<Double> value = target.getValue();
		node.addAttribute("VALUE", value);
		//Count
		BigInteger count = target.getCount();
		if(count != null) {
			node.addAttribute("COUNT", count.intValue());
		}
		//SRSNAME
	    String srsName = target.getSrsName();
	    node.addAttribute("SRSNAME", srsName);
	    //SRSDIMENSION
	    BigInteger srsDimension = target.getSrsDimension();
	    if(srsDimension != null) {
			node.addAttribute("SRSDIMENSION", srsDimension.intValue());
		}
	    //TODO
	    List<String> axisLabels;
	    List<String> uomLabels;
		return node;
	}
	
	public static BindingNode traverseCoordType(CoordType target, BindingNode node, XLinkSymbolMap symbolMap) {
		BigDecimal x = target.getX();
		BigDecimal y = target.getY();
		BigDecimal z = target.getZ();
		
		if(x != null) node.addAttribute("COORDX", x.doubleValue());
		if(y != null) node.addAttribute("COORDY", y.doubleValue());
		if(z != null) node.addAttribute("COORDZ", z.doubleValue());
		
		return node;
	}
	
	public static BindingNode traverseCoordinatesType(CoordinatesType target, BindingNode node, XLinkSymbolMap symbolMap) {
		node.addAttribute("COORDINATESVALUE", target.getValue());
		node.addAttribute("DECIMAL", target.getDecimal());
		node.addAttribute("CS", target.getCs());
		node.addAttribute("TS", target.getTs());
		return node;
	}
	
	
	public static BindingNode traversePointType(PointType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* =========== */
		/* Super Class */
		/* =========== */
		node = traverseAbstractGeometricPrimitiveType(target, node, symbolMap);
		/* ========== */
	    /* Geometries */
	    /* ========== */
		DirectPositionType pos = target.getPos();
		if(pos != null) {
			BindingNode posNode = new BindingNode();
			posNode = traverseDirectPositionType(pos, posNode, symbolMap);
			node.addAssociation("POS", posNode);		
		}
		
		
		CoordinatesType coordinates = target.getCoordinates();
		if(coordinates != null) {
			BindingNode coordinatesNode = new BindingNode();
			coordinatesNode = traverseCoordinatesType(coordinates, coordinatesNode, symbolMap);
			node.addAssociation("COORDNATES", coordinatesNode);
		}
		
		CoordType coord = target.getCoord();
		if(coord != null) {
			BindingNode coordNode = new BindingNode();
			coordNode = traverseCoordType(coord, coordNode, symbolMap);
			node.addAssociation("COORD", coordNode);
		}
		return node;
	}
	
	//PointProperty
	public static BindingNode traversePointPropertyType(PointPropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = XLink attributes ========== */
		node.addAttribute("REMOTESCHEMA", target.getRemoteSchema());
		node.addAttribute("HREF", target.getHref());
		node.addAttribute("ROLE", target.getRole());
		node.addAttribute("ARCROLE", target.getArcrole());
		node.addAttribute("TITLE", target.getTitle());
		if(target.getType() != null) {
			node.addAttribute("TYPE", target.getType().value());
		}
		if(target.getShow() != null) {
			node.addAttribute("SHOW", target.getShow().value());
		}
		if(target.getActuate() != null) {
			node.addAttribute("ACTUATE", target.getActuate().value());
		}
		
		//PointType Property
		PointType pointType = null;
		if(target.getHref() != null) {
			pointType = (PointType) symbolMap.getObjectById(target.getHref().replaceAll("#", ""));
		} else {
			pointType = target.getPoint();
		}
		
		if(pointType != null) {
			node = traversePointType(pointType, node, symbolMap);
		}
		return node;
	}
	
	//MultiPointProperty
	public static BindingNode traverseMultiPointPropertyType(MultiPointPropertyType target,
			BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = XLink attributes ========== */
		node.addAttribute("REMOTESCHEMA", target.getRemoteSchema());
		node.addAttribute("HREF", target.getHref());
		node.addAttribute("ROLE", target.getRole());
		node.addAttribute("ARCROLE", target.getArcrole());
		node.addAttribute("TITLE", target.getTitle());
		if(target.getType() != null) {
			node.addAttribute("TYPE", target.getType().value());
		}
		if(target.getShow() != null) {
			node.addAttribute("SHOW", target.getShow().value());
		}
		if(target.getActuate() != null) {
			node.addAttribute("ACTUATE", target.getActuate().value());
		}
		
		//MultiPointType Property
		MultiPointType multiPointType = null;
		if(target.getHref() != null) {
			multiPointType = (MultiPointType) symbolMap.getObjectById(target.getHref().replaceAll("#", ""));
			//System.out.println("Catched Xlink : " + target.getHref());
		} else {
			multiPointType = target.getMultiPoint();
		}
		
		if(multiPointType != null) {
			/* =========== */
			/* Super Class */
			/* =========== */
			node = traverseAbstractGeometricAggregateType(multiPointType, node, symbolMap);
			/* ========== */
		    /* Geometries */
		    /* ========== */
			//PointMember
			List<PointPropertyType> pointMember = multiPointType.getPointMember();
			if(pointMember != null) {
				for(PointPropertyType p : pointMember) {
					BindingNode ppNode = new BindingNode();
					ppNode = traversePointPropertyType(p, ppNode, symbolMap);
					node.addCollection("POINTMEMBER", ppNode);
				}
			}
			
			//TODO
		    PointArrayPropertyType pointMembers = multiPointType.getPointMembers();
		    if(pointMembers != null) {
				throw new UnsupportedOperationException("PointArrayPropertyType is not supported");
			}
		}
		return node;
	}
	
	public static BindingNode traverseCurvePropertyType(CurvePropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = XLink attributes ========== */
		node.addAttribute("REMOTESCHEMA", target.getRemoteSchema());
		node.addAttribute("HREF", target.getHref());
		node.addAttribute("ROLE", target.getRole());
		node.addAttribute("ARCROLE", target.getArcrole());
		node.addAttribute("TITLE", target.getTitle());
		if(target.getType() != null) {
			node.addAttribute("TYPE", target.getType().value());
		}
		if(target.getShow() != null) {
			node.addAttribute("SHOW", target.getShow().value());
		}
		if(target.getActuate() != null) {
			node.addAttribute("ACTUATE", target.getActuate().value());
		}
		
		//JAXBElement<? extends AbstractCurveType>
		JAXBElement<? extends AbstractCurveType> jCurve = null;
		if(target.getHref() != null) {
			jCurve = (JAXBElement<? extends AbstractCurveType>) symbolMap.getObjectById(target.getHref().replaceAll("#", ""));
			//System.out.println("Catched Xlink : " + target.getHref());
		} else {
			jCurve = target.getCurve();
		}
		
		//TODO
		if(jCurve != null) {
			AbstractCurveType aCurve = jCurve.getValue();
			if(aCurve != null) {
				/* =========== */
				/* Super Class */
				/* =========== */
				node = traverseAbstractGeometricPrimitiveType(aCurve, node, symbolMap);
				/* ========== */
			    /* Geometries */
			    /* ========== */
				if(aCurve instanceof LineStringType) {
					LineStringType lineStringType = (LineStringType) aCurve; 
					
				    List<JAXBElement<?>> posOrPointPropertyOrPointRep = lineStringType.getPosOrPointPropertyOrPointRep();
				    for(JAXBElement<?> jObj : posOrPointPropertyOrPointRep) {
				    	
				    	Object o = jObj.getValue();
				    	
				    	if(o instanceof DirectPositionType) {
				    		DirectPositionType directPosition = (DirectPositionType) o;
				    		BindingNode directPositionNode = new BindingNode();
				    		directPositionNode = traverseDirectPositionType(directPosition, directPositionNode, symbolMap);
				    		node.addCollection("DIRECTPOSITION", directPositionNode);
				    	} else if(o instanceof PointPropertyType) {
				    		PointPropertyType pointProperty = (PointPropertyType) o;
				    		BindingNode pointPropertyNode = new BindingNode();
				    		pointPropertyNode = traversePointPropertyType(pointProperty, pointPropertyNode, symbolMap);
				    		node.addCollection("POINTPROPERTYTYPE", pointPropertyNode);
				    	} else if(o instanceof CoordType) {
				    		CoordType coordType = (CoordType) o;
				    		BindingNode coordNode = new BindingNode();
							coordNode = traverseCoordType(coordType, coordNode, symbolMap);
							node.addAssociation("COORDTYPE", coordNode);
				    	}
				    	
				    }
				    
				    DirectPositionListType posList = lineStringType.getPosList();
				    if(posList != null) {
				    	BindingNode posListNode = new BindingNode();
				    	posListNode = traverseDirectPositionListType(posList, posListNode, symbolMap);
				    	node.addAssociation("DIRECTPOSITIONLIST", posListNode);
				    }
				    
				    CoordinatesType coordinates = lineStringType.getCoordinates();
				    if(coordinates != null) {
				    	BindingNode coordinatesNode = new BindingNode();
						coordinatesNode = traverseCoordinatesType(coordinates, coordinatesNode, symbolMap);
						node.addAssociation("COORDNATES", coordinatesNode);
					}
				}
				else if(aCurve instanceof CompositeCurveType) {
					CompositeCurveType compositeCurveType = (CompositeCurveType) aCurve;
					List<CurvePropertyType> curveMember = compositeCurveType.getCurveMember();
					if(curveMember != null) {
						for(CurvePropertyType c : curveMember) {
							BindingNode cpNode = new BindingNode();
							cpNode = traverseCurvePropertyType(c, cpNode, symbolMap);
							node.addCollection("CURVEMEMBER", cpNode);
						}
					}
					
				}
				//NOTE : CityGML have only LineStringType and CompositeCurveType.
				/*
				else if(aCurve instanceof CurveType) {
					
				} else if(aCurve instanceof OrientableCurveType) {
				
				}
				*/
			}
		}
		
		return node;
	}
	
	//MultiCurveProperty
	public static BindingNode traverseMultiCurvePropertyType(MultiCurvePropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = XLink attributes ========== */
		node.addAttribute("REMOTESCHEMA", target.getRemoteSchema());
		node.addAttribute("HREF", target.getHref());
		node.addAttribute("ROLE", target.getRole());
		node.addAttribute("ARCROLE", target.getArcrole());
		node.addAttribute("TITLE", target.getTitle());
		if(target.getType() != null) {
			node.addAttribute("TYPE", target.getType().value());
		}
		if(target.getShow() != null) {
			node.addAttribute("SHOW", target.getShow().value());
		}
		if(target.getActuate() != null) {
			node.addAttribute("ACTUATE", target.getActuate().value());
		}
	
		//MultiCurveType
		MultiCurveType multiCurveType = null;
		if(target.getHref() != null) {
			multiCurveType = (MultiCurveType) symbolMap.getObjectById(target.getHref().replaceAll("#", ""));
			//System.out.println("Catched Xlink : " + target.getHref());
		} else {
			multiCurveType = target.getMultiCurve();
		}
		
		if(multiCurveType != null) {
			/* =========== */
			/* Super Class */
			/* =========== */
			node = traverseAbstractGeometricAggregateType(multiCurveType, node, symbolMap);
			/* ========== */
		    /* Geometries */
		    /* ========== */
			//CurveMember
			List<CurvePropertyType> curveMember = multiCurveType.getCurveMember();
			if(curveMember != null) {
				for(CurvePropertyType c : curveMember) {
					BindingNode cpNode = new BindingNode();
					cpNode = traverseCurvePropertyType(c, cpNode, symbolMap);
					node.addCollection("CURVEMEMBER", cpNode);
				}
			}
			
			//TODO
			CurveArrayPropertyType curveMembers = multiCurveType.getCurveMembers();
			if(curveMembers != null) {
				throw new UnsupportedOperationException("CurveArrayPropertyType is not supported");
			}
		}
		return node;
	}
	
	//AbstractRingProperty
	public static BindingNode traverseAbstractRingPropertyType(AbstractRingPropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
		
		JAXBElement<? extends AbstractRingType> jRing = target.getRing();
		if(jRing != null) {
			AbstractRingType aRing = jRing.getValue();
			node = traverseAbstractGeometryType(aRing, node, symbolMap);
			
			if(aRing instanceof RingType) {
				RingType ringType = (RingType) aRing;
				List<CurvePropertyType> curveMember = ringType.getCurveMember();
				if(curveMember != null) {
					for(CurvePropertyType c : curveMember) {
						BindingNode cpNode = new BindingNode();
						cpNode = traverseCurvePropertyType(c, cpNode, symbolMap);
						node.addCollection("CURVEMEMBER", cpNode);
					}
				}
			} else if(aRing instanceof LinearRingType) {
				LinearRingType linearRingType = (LinearRingType) jRing.getValue();
				List<JAXBElement<?>> posOrPointPropertyOrPointRep = linearRingType.getPosOrPointPropertyOrPointRep();
			    for(JAXBElement<?> jObj : posOrPointPropertyOrPointRep) {
			    	
			    	Object o = jObj.getValue();
			    	
			    	if(o instanceof DirectPositionType) {
			    		DirectPositionType directPosition = (DirectPositionType) o;
			    		BindingNode directPositionNode = new BindingNode();
			    		directPositionNode = traverseDirectPositionType(directPosition, directPositionNode, symbolMap);
			    		node.addCollection("DIRECTPOSITION", directPositionNode);
			    	} else if(o instanceof PointPropertyType) {
			    		PointPropertyType pointProperty = (PointPropertyType) o;
			    		BindingNode pointPropertyNode = new BindingNode();
			    		pointPropertyNode = traversePointPropertyType(pointProperty, pointPropertyNode, symbolMap);
			    		node.addCollection("POINTPROPERTY", pointPropertyNode);
			    	} else if(o instanceof CoordType) {
			    		CoordType coordType = (CoordType) o;
			    		BindingNode coordNode = new BindingNode();
						coordNode = traverseCoordType(coordType, coordNode, symbolMap);
						node.addCollection("COORD", coordNode);
			    	}
			    	
			    }
			    
			    DirectPositionListType posList = linearRingType.getPosList();
			    if(posList != null) {
			    	BindingNode posListNode = new BindingNode();
			    	posListNode = traverseDirectPositionListType(posList, posListNode, symbolMap);
			    	node.addAssociation("DIRECTPOSITIONLIST", posListNode);
			    }
			    
			    CoordinatesType coordinates = linearRingType.getCoordinates();
			    if(coordinates != null) {
			    	BindingNode coordinatesNode = new BindingNode();
					coordinatesNode = traverseCoordinatesType(coordinates, coordinatesNode, symbolMap);
					node.addAssociation("COORDNATES", coordinatesNode);
				}
			    
			    List<CoordType> coordList = linearRingType.getCoord();
			    for(CoordType coord: coordList) {
			    	BindingNode coordNode = new BindingNode();
					coordNode = traverseCoordType(coord, coordNode, symbolMap);
					node.addCollection("COORD", coordNode);
			    }
			}
		}
		
		return node;
	}
	
	//SurfaceProperty
	public static BindingNode traverseSurfacePropertyType(SurfacePropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = XLink attributes ========== */
		node.addAttribute("REMOTESCHEMA", target.getRemoteSchema());
		node.addAttribute("HREF", target.getHref());
		node.addAttribute("ROLE", target.getRole());
		node.addAttribute("ARCROLE", target.getArcrole());
		node.addAttribute("TITLE", target.getTitle());
		if(target.getType() != null) {
			node.addAttribute("TYPE", target.getType().value());
		}
		if(target.getShow() != null) {
			node.addAttribute("SHOW", target.getShow().value());
		}
		if(target.getActuate() != null) {
			node.addAttribute("ACTUATE", target.getActuate().value());
		}
		/* ========================= */
	    /* AbstractSurfaceType Type  */
	    /* ========================= */
		
		//JAXBElement<? extends AbstractSurfaceType>
		JAXBElement<? extends AbstractSurfaceType> jSurface = null;
		if(target.getHref() != null) {
			String href = target.getHref().replaceAll("#", "");
			Object refObject = symbolMap.getObjectById(href);
			if(refObject instanceof JAXBElement) {
				jSurface = (JAXBElement<? extends AbstractSurfaceType>) symbolMap.getObjectById(href);
			} else if(refObject instanceof AbstractSurfaceType) {
				jSurface = new ObjectFactory().createASurfaceElement((AbstractSurfaceType) refObject);
			}
			//System.out.println("Catched Xlink : " + target.getHref());
		} else {
			jSurface = target.getSurface();
		}
		
		if(jSurface != null) {
			AbstractSurfaceType aSurface = jSurface.getValue();
			if(aSurface != null) {
				node = traverseAbstractSurfaceType(aSurface, node, symbolMap);
			}
		}
		return node;
	}
	
	public static BindingNode traverseAbstractSurfaceType(AbstractSurfaceType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* =========== */
		/* Super Class */
		/* =========== */
		node = traverseAbstractGeometricPrimitiveType(target, node, symbolMap);
		if(target instanceof PolygonType) {
			PolygonType polygon = (PolygonType) target;
			node.addAttribute("GEOMETRYTYPE", polygon.getClass().getSimpleName());
			BindingNode polygonNode = new BindingNode();
			polygonNode = traversePolygonType(polygon, polygonNode, symbolMap);
			node.addAssociation("POLYGONTYPE", polygonNode);
		} else if(target instanceof OrientableSurfaceType) {
			OrientableSurfaceType orientableSurface = (OrientableSurfaceType) target;
			node.addAttribute("GEOMETRYTYPE", orientableSurface.getClass().getSimpleName());
			BindingNode orientableSurfaceNode = new BindingNode();
			orientableSurfaceNode = traverseOrientableSurfaceType(orientableSurface, orientableSurfaceNode, symbolMap);
			node.addAssociation("ORIENTABLESURFACETYPE", orientableSurfaceNode);
		} else if(target instanceof SurfaceType) {
			SurfaceType surface = (SurfaceType) target;
			node.addAttribute("GEOMETRYTYPE", surface.getClass().getSimpleName());
			BindingNode surfaceNode = new BindingNode();
			//TODO
			surfaceNode = traverseSurfaceType(surface, surfaceNode, symbolMap);
			node.addAssociation("SURFACETYPE", surfaceNode);
			throw new UnsupportedOperationException();
		} else if(target instanceof CompositeSurfaceType) {
			CompositeSurfaceType compositeSurface = (CompositeSurfaceType) target;
			node.addAttribute("GEOMETRYTYPE", compositeSurface.getClass().getSimpleName());
			BindingNode compositeSurfaceNode = new BindingNode();
			compositeSurfaceNode = traverseCompositeSurfaceType(compositeSurface, compositeSurfaceNode, symbolMap);
			node.addAssociation("COMPOSITESURFACETYPE", compositeSurfaceNode);
		}
		return node;
	}
	
	//SurfaceType
	//TODO
	public static BindingNode traverseSurfaceType(SurfaceType target, BindingNode node, XLinkSymbolMap symbolMap) {
		
		JAXBElement<? extends SurfacePatchArrayPropertyType> patches = target.getPatches();
		
		if(target instanceof TinType) {
			
		}
		
		return node;
	}
	
	//PolygonType
	public static BindingNode traversePolygonType(PolygonType target, BindingNode node, XLinkSymbolMap symbolMap) {
	    JAXBElement<AbstractRingPropertyType> jExterior = target.getExterior();
	    if(jExterior != null) {
	    	AbstractRingPropertyType exterior = jExterior.getValue();
	    	BindingNode extNode = new BindingNode();
	    	extNode = traverseAbstractRingPropertyType(exterior, extNode, symbolMap);
	    	node.addAssociation("EXTERIOR", extNode);
	    }
	    List<JAXBElement<AbstractRingPropertyType>> jInterior = target.getInterior();
	    for(JAXBElement<AbstractRingPropertyType> jInt : jInterior) {
	    	AbstractRingPropertyType interior = jInt.getValue();
	    	BindingNode intNode = new BindingNode();
	    	intNode = traverseAbstractRingPropertyType(interior, intNode, symbolMap);
	    	node.addCollection("INTERIOR", intNode);
	    }
	    return node;
	}
	
	//OrientableSurfaceType
	public static BindingNode traverseOrientableSurfaceType(OrientableSurfaceType target, BindingNode node, XLinkSymbolMap symbolMap) {
		SurfacePropertyType baseSurface = target.getBaseSurface();
		if(baseSurface != null) {
	    	BindingNode baseSurfaceNode = new BindingNode();
	    	baseSurfaceNode = traverseSurfacePropertyType(baseSurface, baseSurfaceNode, symbolMap);
	    	node.addAssociation("BASESURFACE", baseSurfaceNode);
		}
		
		SignType orientation = target.getOrientation();
		if(orientation != null) {
			node.addAttribute("ORIENTATION", orientation.value());
		} else {
			node.addAttribute("ORIENTATION", SignType.VALUE_2);
		}
		return node;
	}
	
	//CompositeSurfaceType
	public static BindingNode traverseCompositeSurfaceType(CompositeSurfaceType target, BindingNode node, XLinkSymbolMap symbolMap) {
		List<SurfacePropertyType> surfaceMember = target.getSurfaceMember();
		for(SurfacePropertyType surface : surfaceMember) {
			BindingNode surfaceNode = new BindingNode();
			surfaceNode = traverseSurfacePropertyType(surface, surfaceNode, symbolMap);
			node.addCollection("SURFACEMEMBER", surfaceNode);
		}
		return node;
	}
	
	public static BindingNode traverseMultiSurfaceType(MultiSurfaceType target, BindingNode node,  XLinkSymbolMap symbolMap) {
		/* =========== */
		/* Super Class */
		/* =========== */
		node = traverseAbstractGeometricAggregateType(target, node, symbolMap);
		
		//SurfaceMember
		List<SurfacePropertyType> surfaceMember = target.getSurfaceMember();
		if(surfaceMember != null) {
			for(SurfacePropertyType s : surfaceMember) {
				BindingNode spNode = new BindingNode();
				spNode = traverseSurfacePropertyType(s, spNode, symbolMap);
				node.addCollection("SURFACEMEMBER", spNode);
			}
		}
		
		//SurfaceArrayPropertyType
		SurfaceArrayPropertyType sufaceArrayProperty = target.getSurfaceMembers();
		if(sufaceArrayProperty != null) {
			List<JAXBElement<? extends AbstractSurfaceType>> surfaces = sufaceArrayProperty.getSurface();
			for(JAXBElement<? extends AbstractSurfaceType> jSurface : surfaces) {
				AbstractSurfaceType aSurface = jSurface.getValue();
				BindingNode sNode = new BindingNode();
				sNode = traverseAbstractSurfaceType(aSurface, sNode, symbolMap);
				node.addCollection("SURFACEMEMBER", sNode);
			}
		}
		
		return node;
	}
	
	//MultiSurfaceProperty
	public static BindingNode traverseMultiSurfacePropertyType(MultiSurfacePropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = XLink attributes ========== */
		node.addAttribute("REMOTESCHEMA", target.getRemoteSchema());
		node.addAttribute("HREF", target.getHref());
		node.addAttribute("ROLE", target.getRole());
		node.addAttribute("ARCROLE", target.getArcrole());
		node.addAttribute("TITLE", target.getTitle());
		if(target.getType() != null) {
			node.addAttribute("TYPE", target.getType().value());
		}
		if(target.getShow() != null) {
			node.addAttribute("SHOW", target.getShow().value());
		}
		if(target.getActuate() != null) {
			node.addAttribute("ACTUATE", target.getActuate().value());
		}
		/* ====================== */
	    /* MultiSurfaceType Type  */
	    /* ====================== */
		MultiSurfaceType multiSurfaceType = target.getMultiSurface();
		if(multiSurfaceType != null) {
			node.addAttribute("GEOMETRYTYPE", multiSurfaceType.getClass().getSimpleName());
			node = traverseMultiSurfaceType(multiSurfaceType, node, symbolMap);
		}
		return node;
	}
	
	//SolidProperty
	public static BindingNode traverseSolidPropertyType(SolidPropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = XLink attributes ========== */
		node.addAttribute("REMOTESCHEMA", target.getRemoteSchema());
		node.addAttribute("HREF", target.getHref());
		node.addAttribute("ROLE", target.getRole());
		node.addAttribute("ARCROLE", target.getArcrole());
		node.addAttribute("TITLE", target.getTitle());
		if(target.getType() != null) {
			node.addAttribute("TYPE", target.getType().value());
		}
		if(target.getShow() != null) {
			node.addAttribute("SHOW", target.getShow().value());
		}
		if(target.getActuate() != null) {
			node.addAttribute("ACTUATE", target.getActuate().value());
		}
		/* ======================= */
	    /* AbstractSolidType Type  */
	    /* ======================= */
		JAXBElement<? extends AbstractSolidType> jSolid = target.getSolid();
		if(jSolid != null) {
			AbstractSolidType aSolid = jSolid.getValue();
			/* ====================== */
		    /* AbstractSolidType Type  */
		    /* ====================== */
			node.addAttribute("GEOMETRYTYPE", target.getClass().getSimpleName());
			if(aSolid != null) {
				/* =============== */
			    /* SolidType Type  */
			    /* =============== */
				if(aSolid instanceof SolidType) {
					SolidType solid = (SolidType) aSolid;
					node =  traverseSolidType(solid, node, symbolMap);
				/* ======================== */
				/* CompositeSolidType Type  */
				/* ======================== */
				} else if(aSolid instanceof CompositeSolidType) {
					CompositeSolidType compositeSolid = (CompositeSolidType) aSolid;
					node = traverseCompositeSolidType(compositeSolid, node, symbolMap);
				}
			}
		}
		return node;
	}
	
	public static BindingNode traverseSolidType(SolidType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* =========== */
		/* Super Class */
		/* =========== */
		node = traverseAbstractGeometricPrimitiveType(target, node, symbolMap);
		
		SurfacePropertyType exterior = target.getExterior();
		if(exterior != null) {
			node.addAssociation("EXTERIOR", traverseSurfacePropertyType(exterior, new BindingNode(), symbolMap));
		}
		
		List<SurfacePropertyType> interior = target.getInterior();
		for(SurfacePropertyType sp : interior) {
	    	BindingNode spNode = traverseSurfacePropertyType(sp, new BindingNode(), symbolMap);
	    	node.addCollection("INTERIOR", spNode);
	    }
		
		return node;
	}
	
	public static BindingNode traverseCompositeSolidType(CompositeSolidType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* =========== */
		/* Super Class */
		/* =========== */
		node = traverseAbstractGeometricPrimitiveType(target, node, symbolMap);
		
		List<SolidPropertyType> solidMember = target.getSolidMember();
		for(SolidPropertyType sp : solidMember) {
	    	BindingNode spNode = traverseSolidPropertyType(sp, new BindingNode(), symbolMap);
	    	node.addCollection("SOLIDMEMBER", spNode);
	    }
		return node;
	}
	
	//BoundingShapeType, EnvelopeType
	public static BindingNode traverseBoundingShapeType(BoundingShapeType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* ================== */
	    /* EnvelopeType Type  */
	    /* ================== */
		JAXBElement<? extends EnvelopeType> jEnvelope = target.getEnvelope();
		if( jEnvelope != null) {
			EnvelopeType env = jEnvelope.getValue();
			if(env != null) {
				/* ========== */
			    /* Attributes */
			    /* ========== */
				String srsName = env.getSrsName();
				node.addAttribute("SRSNAME", srsName);
				if(env.getSrsDimension() != null) {
					node.addAttribute("SRSDIMENSION", env.getSrsDimension().intValue());
				}
				/* ========== */
			    /* Geometries */
			    /* ========== */
				DirectPositionType lowerCorner = env.getLowerCorner();
				if(lowerCorner != null) {
					BindingNode posNode = new BindingNode();
					posNode = traverseDirectPositionType(lowerCorner, posNode, symbolMap);
					node.addAssociation("LOWERCORNER", posNode);		
				}
				DirectPositionType upperCorner = env.getUpperCorner();
				if(upperCorner != null) {
					BindingNode posNode = new BindingNode();
					posNode = traverseDirectPositionType(upperCorner, posNode, symbolMap);
					node.addAssociation("UPPERCORNER", posNode);		
				}
			}
		}
		return node;
	}
	
}
