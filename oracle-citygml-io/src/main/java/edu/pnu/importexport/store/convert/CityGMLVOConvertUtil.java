/**
 * 
 */
package edu.pnu.importexport.store.convert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.common.BindingNode;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.utils.WKBGeometryBuilder;
import net.opengis.citygml.v_2_0.vo.building.Building;
import net.opengis.citygml.v_2_0.vo.core.Address;
import net.opengis.citygml.v_2_0.vo.core.CityModel;
import net.opengis.citygml.v_2_0.vo.core.CityObject;
import net.opengis.citygml.v_2_0.vo.core.ImplicitGeometry;
import net.opengis.citygml.v_2_0.vo.spatial.Envelope;

/**
 * @author hgryoo
 *
 */
public class CityGMLVOConvertUtil{
	
	private static WKBGeometryBuilder wkbBuilder = WKBGeometryBuilder.getBuilder();
	
	public static CityModel createCityModel(BindingNode node) {
		CityModel cityModel = new CityModel();
		
		/* attributes */
		cityModel.setGmlId( (String)node.getAttribute("GMLID") );
		cityModel.setName( (String) node.getAttribute("NAME/VALUE"));
		cityModel.setNameCodeSpace((String) node.getAttribute("NAME/CODESPACE"));
		cityModel.setDescription((String) node.getAttribute("DESCRIPTION/VALUE"));
		
		/* associations */
		BindingNode envelopeNode = node.getAssociation("BOUNDEDBY");
		if(envelopeNode != null) {
			
			Envelope envelope = new Envelope();
			
			envelope.setSrsName((String) envelopeNode.getAttribute("SRSNAME"));
			envelope.setSrsDimension((Integer) envelopeNode.getAttribute("SRSDIMENSION"));
			
			//Geometries
			Object lower = envelopeNode.getAttribute("LOWERCORNER/VALUE");
			if(lower != null) {
				List<Double> lowerCornerValue = (List<Double>) lower;
				STPoint lowerCornerGeometry = PostGISGeometryConvertUtil.createPointFromDoubleList(lowerCornerValue);
				envelope.setLowerCorner( wkbBuilder.asBinary(lowerCornerGeometry) );
				envelope.lowerCornerGeometry = lowerCornerGeometry;
			}
			Object upper = envelopeNode.getAttribute("UPPERCORNER/VALUE");
			if(upper != null) {
				List<Double> upperCornerValue = (List<Double>) upper;
				STPoint upperCornerGeometry = PostGISGeometryConvertUtil.createPointFromDoubleList(upperCornerValue);
				envelope.setUpperCorner( wkbBuilder.asBinary(upperCornerGeometry) );
				envelope.upperCornerGeometry = upperCornerGeometry;
			}
			
			cityModel.setEnvelope(envelope);
		}
		
		/* collections */
		ArrayList<CityObject> cityObjects = new ArrayList<CityObject>();
		List<BindingNode> featuresNode = node.getCollection("FEATURES");
		for(BindingNode fpNode : featuresNode) {
			String featureType = (String) fpNode.getAttribute("FEATURETYPE");
			BindingNode fNode = fpNode.getAssociation("FEATURE");
		
			/* TODO polymorphism problem */
			if("Building".equalsIgnoreCase(featureType)) {
				Building building = BuildingVOConvertUtil.createBuilding(fNode);
				building.setCityObjectType(featureType);
				cityObjects.add(building);
			}
			
		}
		cityModel.setCityObjects(cityObjects);
		return cityModel;
	}
	
	//abstract class
	public static CityObject setCityObject(CityObject co, BindingNode node) {
		
		/* attributes */
		co.setGmlId( (String)node.getAttribute("GMLID") );
		co.setName( (String) node.getAttribute("NAME/VALUE"));
		co.setNameCodeSpace((String) node.getAttribute("NAME/CODESPACE"));
		co.setDescription((String) node.getAttribute("DESCRIPTION/VALUE"));
		co.setCreationDate( (Date) node.getAttribute("CREATIONDATE"));
		co.setTerminationDate((Date) node.getAttribute("TERMINATIONDATE"));
		co.setRelativeToTerrain((String) node.getAttribute("RELATIVETOTERRAIN"));
		co.setRelativeToWater((String) node.getAttribute("RELATIVETOWATER"));
		
		return co;
	}
	
	//TODO
	public static Address createAddress(BindingNode node) {
		Address address = new Address();
		
		return address;
	}
	
	//TODO
	public static ImplicitGeometry createImplicitGeometry(BindingNode node) {
		ImplicitGeometry implicitGeometry = new ImplicitGeometry();
		
		return implicitGeometry;
	}
}
