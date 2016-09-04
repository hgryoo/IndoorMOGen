/**
 * 
 */
package edu.pnu.importexport.store.traversal;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import edu.pnu.common.BindingNode;
import edu.pnu.common.XLinkSymbolMap;
import net.opengis.citygml.v_2_0.AbstractCityObjectType;
import net.opengis.citygml.v_2_0.AddressPropertyType;
import net.opengis.citygml.v_2_0.AddressType;
import net.opengis.citygml.v_2_0.CityModelType;
import net.opengis.citygml.v_2_0.ExternalReferenceType;
import net.opengis.citygml.v_2_0.GeneralizationRelationType;
import net.opengis.citygml.v_2_0.ImplicitGeometryType;
import net.opengis.citygml.v_2_0.ImplicitRepresentationPropertyType;
import net.opengis.citygml.v_2_0.RelativeToTerrainType;
import net.opengis.citygml.v_2_0.RelativeToWaterType;
import net.opengis.citygml.v_2_0.XalAddressPropertyType;
import net.opengis.gml.v_3_1_1.CodeType;
import net.opengis.gml.v_3_1_1.GeometryPropertyType;
import net.opengis.gml.v_3_1_1.MultiPointPropertyType;
import net.opengis.gml.v_3_1_1.PointPropertyType;
import oasis.names.tc.ciq.xsdschema.xal.AddressDetails;

/**
 * @author hgryoo
 *
 */
public class JCoreTraversalUtil extends JAXBTraversalUtil{
	
	public static BindingNode convertCityModelType(CityModelType target, BindingNode node, XLinkSymbolMap symbolMap) {
		node = JGMLTraversalUtil.traverseAbstractFeatureCollectionType(target, node, symbolMap);
		return node;
	}
	
	public static BindingNode convertAbstractCityObjectType(AbstractCityObjectType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* =========== */
	    /* Super Class */
	    /* =========== */
		node = JGMLTraversalUtil.traverseAbstractFeatureType(target, node, symbolMap);
		/* ========== */
	    /* Attributes */
	    /* ========== */
		XMLGregorianCalendar creationDate = target.getCreationDate();
		if(creationDate != null) {
			Date cDate = creationDate.toGregorianCalendar().getTime();
			node.addAttribute("CREATIONDATE", cDate);
		}
		XMLGregorianCalendar terminationDate = target.getTerminationDate();
		if(terminationDate != null) {
			Date tDate = terminationDate.toGregorianCalendar().getTime();
			node.addAttribute("TERMINATIONDATE", tDate);
		}
		RelativeToTerrainType relativeToTerrain = target.getRelativeToTerrain();
		if(relativeToTerrain != null) {
			node.addAttribute("RELATIVETOTERRAIN", relativeToTerrain.value());
		}
		RelativeToWaterType relativeToWater = target.getRelativeToWater();
		if(relativeToWater != null) {
			node.addAttribute("RELATIVETOWATER", relativeToWater.value());
		}
		/* ============ */
	    /* Association  */
	    /* ============ */
		//TODO
		List<ExternalReferenceType> externalReferences = target.getExternalReference();
		//TODO
		List<GeneralizationRelationType> generalizesTo = target.getGeneralizesTo();
		return node;
	}
	
	public static BindingNode convertAddressPropertyType(AddressPropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
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
		/* ============= */
	    /* Address Type  */
	    /* ============= */
		AddressType address = target.getAddress();
		if(address != null) {
			/* =========== */
		    /* Super Class */
		    /* =========== */
			node = JGMLTraversalUtil.traverseAbstractFeatureType(address, node, symbolMap);
			/* ========== */
		    /* Attributes */
		    /* ========== */
			XalAddressPropertyType xalAddress = address.getXalAddress();
			if(xalAddress != null) {
				//TODO
				AddressDetails addressDetails = xalAddress.getAddressDetails();
			}
			/* ========== */
		    /* Geometries */
		    /* ========== */
			//TODO
		    MultiPointPropertyType multiPoint = address.getMultiPoint();
		    if(multiPoint != null) {
				BindingNode multiPointNode = JGMLTraversalUtil.traverseMultiPointPropertyType(multiPoint, new BindingNode(), symbolMap);
				node.addAssociation("MULTIPOINT", multiPointNode);
			}
		}
		return node;
	}

	//TODO
	public static BindingNode convertImplicitRepresentationPropertyType(ImplicitRepresentationPropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
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
	    /* ImplicitGeometry Type  */
	    /* ====================== */
		ImplicitGeometryType implicitGeometry = target.getImplicitGeometry();
		if(implicitGeometry != null) {
			/* =========== */
		    /* Super Class */
		    /* =========== */
			node = JGMLTraversalUtil.traverseAbstractGMLType(implicitGeometry, node, symbolMap);
			/* ========== */
		    /* Attributes */
		    /* ========== */
			CodeType mimeType = implicitGeometry.getMimeType();
			if(mimeType != null) {
				BindingNode mimeTypeNode = JGMLTraversalUtil.traverseCodeType(mimeType, new BindingNode(), symbolMap);
				node.addAssociation("MIMETYPE", mimeTypeNode);
			}
			//TransformationMatrix - List<Double>
			node.addAttribute("TRANSFORMATIONMATRIX", implicitGeometry.getTransformationMatrix());
			//LibraryObject - String
			node.addAttribute("LIBRARYOBJECT", implicitGeometry.getLibraryObject());
			/* ========== */
		    /* Geometries */
		    /* ========== */
		    GeometryPropertyType relativeGMLGeometry = implicitGeometry.getRelativeGMLGeometry();
		    if(relativeGMLGeometry != null) {
				BindingNode relativeGMLGeometryNode = JGMLTraversalUtil.traverseGeometryPropertyType(relativeGMLGeometry, new BindingNode(), symbolMap);
				node.addAssociation("RELATIVEGMLGEOMETRY", relativeGMLGeometryNode);
			}
		    PointPropertyType referencePoint = implicitGeometry.getReferencePoint();
		    if(referencePoint != null) {
				BindingNode referencePointNode = JGMLTraversalUtil.traversePointPropertyType(referencePoint, new BindingNode(), symbolMap);
				node.addAssociation("REFERENCEPOINT", referencePointNode);
			}
		}
		return node;
	}
}
