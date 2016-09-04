/**
 * 
 */
package edu.pnu.importexport.retrieve;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import edu.pnu.common.BindingNode;
import net.opengis.gml.v_3_1_1.AbstractFeatureCollectionType;
import net.opengis.gml.v_3_1_1.AbstractFeatureType;
import net.opengis.gml.v_3_1_1.AbstractGMLType;
import net.opengis.gml.v_3_1_1.CodeType;
import net.opengis.gml.v_3_1_1.ObjectFactory;
import net.opengis.gml.v_3_1_1.StringOrRefType;

/**
 * @author hgryoo
 *
 */
public class GMLJAXBConvertUtil {
	
	private static final ObjectFactory gmlOf = new ObjectFactory();
	
	public static AbstractGMLType setAbstractGMLType(AbstractGMLType target, BindingNode node) {
		//GML ID
		target.setId((String)node.getAttribute("GMLID"));
		
		//NAME
		List<JAXBElement<CodeType>> names = target.getName();
		/* TODO : consider multiple name */
		BindingNode nameNode = node.getAssociation("NAME");
		CodeType name = createCodeType(null, nameNode);
		JAXBElement<CodeType> jName = gmlOf.createName(name);
		names.add(jName);
		
		//DESCRIPTION
		StringOrRefType description = createStringOrRefType(null, node);
		target.setDescription(description);
		
		return target;
	}
	
	public static AbstractFeatureType setAbstractFeatureType(AbstractFeatureType target, BindingNode node) {
		/* set parent attributes */
		target = (AbstractFeatureType) setAbstractGMLType(target, node);
		
		BindingNode boundedByNode = node.getAssociation("BOUNDEDBY");
		
		
		
		return target;
	}
	
	public static AbstractFeatureCollectionType setAbstractFeatureCollectionType(AbstractFeatureCollectionType target, BindingNode node) {
		/* set parent attributes */
		target = (AbstractFeatureCollectionType) setAbstractFeatureType(target, node);
		
		
		
		return target;
	}
	
	public static CodeType createCodeType(CodeType target, BindingNode node) {
		if(target == null) {
			target = gmlOf.createCodeType();
		}
		target.setValue( (String) node.getAttribute("VALUE"));
		target.setCodeSpace( (String) node.getAttribute("CODESPACE"));
		return target;
	}
	
	public static StringOrRefType createStringOrRefType(StringOrRefType target, BindingNode node) {
		if(target == null) {
			target = gmlOf.createStringOrRefType();
		}
		target.setHref( (String) node.getAttribute("HREF"));
		target.setValue( (String) node.getAttribute("VALUE"));
		return target;
	}
}
