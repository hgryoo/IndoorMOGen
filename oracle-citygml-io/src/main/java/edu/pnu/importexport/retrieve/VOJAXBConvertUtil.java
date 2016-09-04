/**
 * 
 */
package edu.pnu.importexport.retrieve;

import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.model.STLineString;
import edu.pnu.common.geometry.model.STMultiSurface;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.model.STPolygon;
import edu.pnu.common.geometry.model.STPolyhedralSurface;
import edu.pnu.common.geometry.model.STSolid;
import edu.pnu.common.geometry.model.STSurface;
import edu.pnu.common.geometry.utils.WKBGeometryParser;
import net.opengis.citygml.building.v_2_0.AbstractBuildingType;
import net.opengis.citygml.v_2_0.AbstractCityObjectType;
import net.opengis.citygml.v_2_0.CityModelType;
import net.opengis.citygml.v_2_0.RelativeToTerrainType;
import net.opengis.citygml.v_2_0.RelativeToWaterType;
import net.opengis.citygml.v_2_0.vo.building.Building;
import net.opengis.citygml.v_2_0.vo.core.CityModel;
import net.opengis.citygml.v_2_0.vo.core.CityObject;
import net.opengis.citygml.v_2_0.vo.spatial.Envelope;
import net.opengis.gml.v_3_1_1.AbstractGeometryType;
import net.opengis.gml.v_3_1_1.AbstractRingPropertyType;
import net.opengis.gml.v_3_1_1.AbstractRingType;
import net.opengis.gml.v_3_1_1.AbstractSolidType;
import net.opengis.gml.v_3_1_1.AbstractSurfaceType;
import net.opengis.gml.v_3_1_1.BoundingShapeType;
import net.opengis.gml.v_3_1_1.CodeType;
import net.opengis.gml.v_3_1_1.CompositeSurfaceType;
import net.opengis.gml.v_3_1_1.DirectPositionListType;
import net.opengis.gml.v_3_1_1.DirectPositionType;
import net.opengis.gml.v_3_1_1.EnvelopeType;
import net.opengis.gml.v_3_1_1.FeaturePropertyType;
import net.opengis.gml.v_3_1_1.GeometryPropertyType;
import net.opengis.gml.v_3_1_1.LengthType;
import net.opengis.gml.v_3_1_1.LinearRingType;
import net.opengis.gml.v_3_1_1.MeasureOrNullListType;
import net.opengis.gml.v_3_1_1.MultiSurfacePropertyType;
import net.opengis.gml.v_3_1_1.MultiSurfaceType;
import net.opengis.gml.v_3_1_1.PolygonType;
import net.opengis.gml.v_3_1_1.SolidPropertyType;
import net.opengis.gml.v_3_1_1.SolidType;
import net.opengis.gml.v_3_1_1.StringOrRefType;
import net.opengis.gml.v_3_1_1.SurfacePropertyType;

/**
 * @author hgryoo
 *
 */
public class VOJAXBConvertUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VOJAXBConvertUtil.class);
	
	private static final net.opengis.citygml.building.v_2_0.ObjectFactory bldgOf = new net.opengis.citygml.building.v_2_0.ObjectFactory();
	private static final net.opengis.citygml.v_2_0.ObjectFactory coreOf = new net.opengis.citygml.v_2_0.ObjectFactory();
	private static final net.opengis.gml.v_3_1_1.ObjectFactory gmlOf = new net.opengis.gml.v_3_1_1.ObjectFactory();

	private static WKBGeometryParser parser = WKBGeometryParser.getParser();
	
	public static CityModelType createCityModelType(CityModelType target, CityModel vo) {
		if(target == null) {
			target = coreOf.createCityModelType();
		}
		
		//GML ID
		String gmlId = vo.getGmlId();
		target.setId(gmlId);
		
		//Name
		String name = vo.getName();
		String nameCodeSpace = vo.getNameCodeSpace();
		
		List<JAXBElement<CodeType>> names = target.getName();
		//TODO : consider multiple name 
		JAXBElement<CodeType> jName = createCodeType(name, nameCodeSpace);
		names.add(jName);
		
		//Description
		String description = vo.getDescription();
		if(description != null) {
			StringOrRefType descriptionType = gmlOf.createStringOrRefType();
			descriptionType.setValue(description);
			target.setDescription(descriptionType);
		}
		
		
		//Envelope
		Envelope envelope = vo.getEnvelope();
		if(envelope != null) {
			
			BoundingShapeType boundingShapeType = gmlOf.createBoundingShapeType();
			EnvelopeType envelopeType = gmlOf.createEnvelopeType();
			
			String srsName = envelope.getSrsName();
			if(srsName != null) {
				envelopeType.setSrsName(srsName);
			}
			Integer srsDimension = envelope.getSrsDimension();
			if(srsDimension != null) {
				envelopeType.setSrsDimension( new BigInteger(String.valueOf(srsDimension)));
			}
			
			//Geometry
			byte[] lowerCorner = envelope.getLowerCorner();
			STPoint lower = (STPoint) parser.parseWKB(lowerCorner);
			DirectPositionType lowerDirectPosition = createDirectPositionType(lower);
			envelopeType.setLowerCorner(lowerDirectPosition);
			
			byte[] upperCorner = envelope.getUpperCorner();
			STPoint upper = (STPoint) parser.parseWKB(upperCorner);
			DirectPositionType upperDirectPosition = createDirectPositionType(upper);
			envelopeType.setUpperCorner(upperDirectPosition);
			
			//JAXBElement
			JAXBElement<EnvelopeType> jEnvelope = gmlOf.createEnvelope(envelopeType);
			boundingShapeType.setEnvelope(jEnvelope);
			target.setBoundedBy(boundingShapeType);	
		}

		//CityObjects
		List<? extends CityObject> cityObjects = vo.getCityObjects();
		if(cityObjects != null && cityObjects.size() > 0) {
			List<JAXBElement<FeaturePropertyType>> jFeatureMember = target.getFeatureMember();
			
			for(CityObject co : cityObjects) {
				FeaturePropertyType fp = gmlOf.createFeaturePropertyType();
				
				if(co instanceof Building) {
					Building b = (Building) co;
					JAXBElement<? extends AbstractBuildingType> f = BuildingJAXBConvertUtil.createBuildingType(b);
					fp.setFeature(f);
				}
				
				JAXBElement<FeaturePropertyType> cityObjectMember = coreOf.createCityObjectMember(fp);
				jFeatureMember.add(cityObjectMember);
			}
		}
		
		return target;
	}
	

	public static GeometryPropertyType createGeometryProperty(STGeometry vo) {
		GeometryPropertyType target = gmlOf.createGeometryPropertyType();
		
		JAXBElement<? extends AbstractGeometryType> geometry = createAbstractGeometryType(vo);
		if(geometry != null) {
			target.setGeometry(geometry);
		}
		return target;
	}
	
	private static JAXBElement<? extends AbstractGeometryType> createAbstractGeometryType(STGeometry vo) {
		
		AbstractGeometryType target = null;
		JAXBElement<? extends AbstractGeometryType> jGeometry = null;
		
		//TODO
		if(vo instanceof STMultiSurface) {
			target = createMultiSurfaceType((STMultiSurface) vo);
			jGeometry = gmlOf.createMultiSurface((MultiSurfaceType) target);
		}
		else {
			throw new UnsupportedOperationException("createAbstractGeometryType : unknown geometry" + vo.getClass().getName());
		}
		
		return jGeometry;
	}


	public static DirectPositionType createDirectPositionType(STPoint vo) {
		DirectPositionType target = gmlOf.createDirectPositionType();
		
		List<Double> dList = target.getValue();
		dList.add(vo.X());
		dList.add(vo.Y());
		dList.add(vo.Z());
		
		return target;
	}
	
	public static SolidPropertyType createSolidPropertyType(STSolid g) {
		
		SolidPropertyType target = gmlOf.createSolidPropertyType();
		/*if(vo.getIsXLink() == true) {
			target.setHref("#" + vo.getGmlId());
		} else {
			JAXBElement<? extends AbstractSolidType> solid = createAbstractSolidType(vo);
			if(solid != null) {
				target.setSolid(solid);
			}
		}*/
		JAXBElement<? extends AbstractSolidType> solid = createAbstractSolidType(g);
		if(solid != null) {
			target.setSolid(solid);
		}
		
		
		return target;
	}
	
	public static JAXBElement<? extends AbstractSolidType> createAbstractSolidType(STSolid g) {
		AbstractSolidType target = null;
		//TODO : always SolidType in this time.
		target = gmlOf.createSolidType();
		
		SolidType solid = (SolidType) target;
		
		//Exterior, Interior
		STSurface exterior = g.exteriorShell();
		if(exterior != null) {
			SurfacePropertyType surfaceProperty = createSurfacePropertyType(exterior);
			if(surfaceProperty != null) {
				solid.setExterior(surfaceProperty);
			}
		}
		
		/*//GML ID
		String gmlId = vo.getGmlId();
		target.setId(gmlId);
		
		//Description //TODO
		String description = vo.getDescription();
		if(description != null) {
			StringOrRefType descriptionType = gmlOf.createStringOrRefType();
			descriptionType.setValue(description);
			target.setDescription(descriptionType);
		}
		
		String srsName = vo.getSrsName();
		if(srsName != null) {
			target.setSrsName(srsName);
		}
		Integer srsDimension = vo.getSrsDimension();
		if(srsDimension != null) {
			target.setSrsDimension( new BigInteger(String.valueOf(srsDimension)));
		}
		
		//Exterior, Interior
		Surface exterior = vo.getExterior();
		if(exterior != null) {
			SurfacePropertyType surfaceProperty = createSurfacePropertyType(exterior);
			if(surfaceProperty != null) {
				solid.setExterior(surfaceProperty);
			}
		}
		
		//TODO
		List<Surface> interior = vo.getInterior();*/
		
		
		JAXBElement<? extends AbstractSolidType> jSolid = null;
		if(target instanceof SolidType) {
			jSolid = gmlOf.createSolid((SolidType) target);
		} else {
			throw new UnsupportedOperationException();
		}
		
		return jSolid;
	}
	
	public static MultiSurfacePropertyType createMultiSurfacePropertyType(STMultiSurface vo) {
		MultiSurfacePropertyType target = gmlOf.createMultiSurfacePropertyType();
		
		MultiSurfaceType multiSurface = createMultiSurfaceType(vo);
		if(multiSurface != null) {
			target.setMultiSurface(multiSurface);
		}
		
		/*if(vo.getIsXLink() == true) {
			target.setHref("#" + vo.getGmlId());
		} else {
			MultiSurfaceType multiSurface = createMultiSurfaceType(vo);
			if(multiSurface != null) {
				target.setMultiSurface(multiSurface);
			}
		}*/
		return target;
	}


	private static MultiSurfaceType createMultiSurfaceType(STMultiSurface vo) {
		MultiSurfaceType target = gmlOf.createMultiSurfaceType();
		
		List<SurfacePropertyType> surfaceMember = target.getSurfaceMember();
		STSurface[] surfaces = vo.getSurfaces();
		for(STSurface s : surfaces) {
			SurfacePropertyType surfaceProp = createSurfacePropertyType(s);
			if(surfaceProp != null) surfaceMember.add(surfaceProp);
		}
		
		return target;
	}


	public static SurfacePropertyType createSurfacePropertyType(STSurface g) {
		SurfacePropertyType target = gmlOf.createSurfacePropertyType();
		/*if(vo.getIsXLink() == true) {
			target.setHref("#" + vo.getGmlId());
		} else {
			JAXBElement<? extends AbstractSurfaceType> surface = createAbstractSurfaceType(vo);
			if(surface != null) {
				target.setSurface(surface);
			}
		}*/
		
		JAXBElement<? extends AbstractSurfaceType> surface = createAbstractSurfaceType(g);
		if(surface != null) {
			target.setSurface(surface);
		}
		
		return target;
	}
	
	public static JAXBElement<? extends AbstractSurfaceType> createAbstractSurfaceType(STSurface g) {
		AbstractSurfaceType target = null;
		
		if(g instanceof STPolyhedralSurface) {
			STPolyhedralSurface g2 = (STPolyhedralSurface) g;
			
			target = gmlOf.createCompositeSurfaceType();
			CompositeSurfaceType s = (CompositeSurfaceType) target;
			
			List<SurfacePropertyType> surfaceMember = s.getSurfaceMember();
			
			for(int i = 0; i < g2.numPatches(); i++) {
				STPolygon polygon = g2.PatchN(i);
				SurfacePropertyType surfaceProp = createSurfacePropertyType(polygon);
				surfaceMember.add(surfaceProp);
			}
		} else if(g instanceof STPolygon) {
			STPolygon g2 = (STPolygon) g;
			
			target = gmlOf.createPolygonType();
			PolygonType s = (PolygonType) target;
			
			
			//Exterior
			STLineString exterior = g2.exteriorRing();
			if(exterior != null) {
				AbstractRingPropertyType value = createAbstractRingPropertyType(exterior);
				JAXBElement<AbstractRingPropertyType> exteriorProp = gmlOf.createExterior(value);
				s.setExterior(exteriorProp);
			}
			
			//Interior
			List<JAXBElement<AbstractRingPropertyType>> interiorProps = s.getInterior();
			for(int i = 0; i < g2.numInteriorRing(); i++) {
				STLineString interior = g2.interiorRingN(i);
				AbstractRingPropertyType value = createAbstractRingPropertyType(interior);
				JAXBElement<AbstractRingPropertyType> interiorProp = gmlOf.createInterior(value);
				interiorProps.add(interiorProp);
			}
		}
		
		
		JAXBElement<? extends AbstractSurfaceType> jSurface = null;
		if(target instanceof CompositeSurfaceType) {
			jSurface = gmlOf.createCompositeSurface((CompositeSurfaceType) target);
		} else if(target instanceof PolygonType) {
			jSurface = gmlOf.createPolygon((PolygonType) target);
		}
		else {
			throw new UnsupportedOperationException();
		}
		
		//TODO : 
		/*if(vo.isComposite()) {
			target = gmlOf.createCompositeSurfaceType();
		} else if(vo.isReverse()) {
			target = gmlOf.createOrientableSurfaceType();
		} else {
			target = gmlOf.createPolygonType();
		}*/
		
		/*//Common Attributes 
			//GML ID
			String gmlId = vo.getGmlId();
			target.setId(gmlId);
			
			//Description //TODO
			String description = vo.getDescription();
			if(description != null) {
				StringOrRefType descriptionType = gmlOf.createStringOrRefType();
				descriptionType.setValue(description);
				target.setDescription(descriptionType);
			}
			
			String srsName = vo.getSrsName();
			if(srsName != null) {
				target.setSrsName(srsName);
			}
			Integer srsDimension = vo.getSrsDimension();
			if(srsDimension != null) {
				target.setSrsDimension( new BigInteger(String.valueOf(srsDimension)));
			}
		
		if(target instanceof CompositeSurfaceType) {
			CompositeSurfaceType s = (CompositeSurfaceType) target;
			
			List<SurfacePropertyType> surfaceMember = s.getSurfaceMember();
			List<Surface> child = vo.getChild();
			for(Surface surface : child) {
				SurfacePropertyType surfaceProp = createSurfacePropertyType(surface);
				surfaceMember.add(surfaceProp);
			}
		} else if(target instanceof OrientableSurfaceType) {
			OrientableSurfaceType s = (OrientableSurfaceType) target;
			
			//TODO
			SurfacePropertyType surfaceProp = createSurfacePropertyType(vo.getChild().get(0));
			s.setBaseSurface(surfaceProp);
			s.setOrientation(SignType.VALUE_1);
			
			
		} else if(target instanceof PolygonType) {
			PolygonType s = (PolygonType) target;
			
			byte[] polygonGeometry = vo.getPolygonGeometry();
			if(polygonGeometry != null) {
				//System.out.println(DAO.byteArrayToHex(polygonGeometry));
				
				STPolygon polygon = WKBGeometryParsingUtil.createPolygon(polygonGeometry);
				//System.out.println(polygon.asText());
				//Exterior
				STLineString exterior = polygon.exteriorRing();
				if(exterior != null) {
					AbstractRingPropertyType value = createAbstractRingPropertyType(exterior);
					JAXBElement<AbstractRingPropertyType> exteriorProp = gmlOf.createExterior(value);
					s.setExterior(exteriorProp);
				}
				
				//Interior
				List<JAXBElement<AbstractRingPropertyType>> interiorProps = s.getInterior();
				for(int i = 0; i < polygon.numInteriorRing(); i++) {
					STLineString interior = polygon.interiorRingN(i);
					AbstractRingPropertyType value = createAbstractRingPropertyType(interior);
					JAXBElement<AbstractRingPropertyType> interiorProp = gmlOf.createInterior(value);
					interiorProps.add(interiorProp);
				}
			}
			
		}*/

		
		return jSurface;
	}

	public static AbstractRingPropertyType createAbstractRingPropertyType(STLineString ring) {
		AbstractRingPropertyType target = gmlOf.createAbstractRingPropertyType();
		
		JAXBElement<? extends AbstractRingType> aRing = createRingType(ring);
		
		target.setRing(aRing);
		
		return target;
	}

	public static JAXBElement<? extends AbstractRingType> createRingType(STLineString ring) {
		
		AbstractRingType target = null;
		//TODO : citygml only use linearRing
		target = gmlOf.createLinearRingType();
		LinearRingType lRing = (LinearRingType) target;
		
		DirectPositionListType directPosition = gmlOf.createDirectPositionListType();
		List<Double> dList = directPosition.getValue();
		
		for(int i=0; i<ring.numPoints(); i++) {
			STPoint point = ring.PointN(i);
			dList.add(point.X());
			dList.add(point.Y());
			dList.add(point.Z());
		}
		lRing.setPosList(directPosition);
		
		JAXBElement<? extends AbstractRingType> jRing = null;
		if(target instanceof LinearRingType) {
			jRing = gmlOf.createLinearRing((LinearRingType) target);
		}
		
		return jRing;
	}

	public static void setCityObjectAttributes(AbstractCityObjectType target, CityObject vo) {
		//GML ID
		String gmlId = vo.getGmlId();
		target.setId(gmlId);
		
		//Name
		String name = vo.getName();
		String nameCodeSpace = vo.getNameCodeSpace();
		List<JAXBElement<CodeType>> names = target.getName();
		//TODO : consider multiple name 
		JAXBElement<CodeType> jName = createCodeType(name, nameCodeSpace);
		names.add(jName);
		
		//TODO : consider StringOrRefType
		String description = vo.getDescription();
		if(description != null) {
			StringOrRefType descriptionType = gmlOf.createStringOrRefType();
			descriptionType.setValue(description);
			target.setDescription(descriptionType);
		}
		
		Date creationDate = vo.getCreationDate();
		if(creationDate != null) {
			XMLGregorianCalendar jCreationDate = createXMLGregorianCalendar(creationDate);
			target.setCreationDate(jCreationDate);
		}
		
		Date terminationDate = vo.getTerminationDate();
		if(terminationDate != null) {
			XMLGregorianCalendar jTerminationDate = createXMLGregorianCalendar(terminationDate);
			target.setCreationDate(jTerminationDate);
		}
		
		String relativeToTerrain = vo.getRelativeToTerrain();
		if(relativeToTerrain != null) {
			target.setRelativeToTerrain
				( RelativeToTerrainType.fromValue(relativeToTerrain));
		}
		
		String relativeToWater = vo.getRelativeToWater();
		if(relativeToWater != null) {
			target.setRelativeToWater
				( RelativeToWaterType.fromValue(relativeToWater));
		}
	}
	
	public static MeasureOrNullListType createMeasureOrNullListType(List<String> v, String uom) {
		if(v == null || v.size() < 1) return null;
		
		MeasureOrNullListType storeysHeightsAbove = gmlOf.createMeasureOrNullListType();
		
		List<String> values = storeysHeightsAbove.getValue();
		if(v != null) values.addAll(v);
		
		storeysHeightsAbove.setUom(uom);
		
		return storeysHeightsAbove;
	}
	
	public static JAXBElement<CodeType> createCodeType(String value, String codeSpace) {
		if(value == null && codeSpace == null) {
			return null;
		}
		
		CodeType codeType = gmlOf.createCodeType();
		codeType.setValue(value);
		codeType.setCodeSpace(codeSpace);
		
		JAXBElement<CodeType> jCodeType = gmlOf.createName(codeType);
		return jCodeType;
	}
	
	public static LengthType createLengthType(Double value, String uom) {
		if(value == null && uom == null) {
			return null;
		}
		
		LengthType mh = gmlOf.createLengthType();
		mh.setValue(value);
		mh.setUom(uom);
		
		return mh;
	}
	
	public static XMLGregorianCalendar createXMLGregorianCalendar(Date date) {
		
		GregorianCalendar gregory = new GregorianCalendar();
		gregory.setTime(date);

		XMLGregorianCalendar calendar;
		try {
			calendar = DatatypeFactory.newInstance()
			        .newXMLGregorianCalendar(
			            gregory);
			calendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
			calendar.setTime(DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
			calendar.setDay(DatatypeConstants.FIELD_UNDEFINED);
			calendar.setMonth(DatatypeConstants.FIELD_UNDEFINED);
			return calendar;
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
