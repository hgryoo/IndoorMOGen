/**
 * 
 */
package edu.pnu.importexport.store.traversal;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import edu.pnu.common.BindingNode;
import edu.pnu.common.XLinkSymbolMap;
import net.opengis.citygml.building.v_2_0.AbstractBoundarySurfaceType;
import net.opengis.citygml.building.v_2_0.AbstractBuildingType;
import net.opengis.citygml.building.v_2_0.AbstractOpeningType;
import net.opengis.citygml.building.v_2_0.BoundarySurfacePropertyType;
import net.opengis.citygml.building.v_2_0.BuildingFurnitureType;
import net.opengis.citygml.building.v_2_0.BuildingInstallationPropertyType;
import net.opengis.citygml.building.v_2_0.BuildingInstallationType;
import net.opengis.citygml.building.v_2_0.BuildingPartPropertyType;
import net.opengis.citygml.building.v_2_0.DoorType;
import net.opengis.citygml.building.v_2_0.IntBuildingInstallationPropertyType;
import net.opengis.citygml.building.v_2_0.IntBuildingInstallationType;
import net.opengis.citygml.building.v_2_0.InteriorFurniturePropertyType;
import net.opengis.citygml.building.v_2_0.InteriorRoomPropertyType;
import net.opengis.citygml.building.v_2_0.OpeningPropertyType;
import net.opengis.citygml.building.v_2_0.RoomType;
import net.opengis.citygml.v_2_0.AddressPropertyType;
import net.opengis.citygml.v_2_0.ImplicitRepresentationPropertyType;
import net.opengis.gml.v_3_1_1.CodeType;
import net.opengis.gml.v_3_1_1.GeometryPropertyType;
import net.opengis.gml.v_3_1_1.LengthType;
import net.opengis.gml.v_3_1_1.MeasureOrNullListType;
import net.opengis.gml.v_3_1_1.MultiCurvePropertyType;
import net.opengis.gml.v_3_1_1.MultiSurfacePropertyType;
import net.opengis.gml.v_3_1_1.SolidPropertyType;

/**
 * @author hgryoo
 *
 */
public class JBuildingTraversalUtil extends JAXBTraversalUtil {
	
	public static BindingNode traverseAbstractBuildingType(AbstractBuildingType target, BindingNode node, XLinkSymbolMap symbolMap) {
		/* =========== */
	    /* Super Class */
	    /* =========== */
		node = JCoreTraversalUtil.convertAbstractCityObjectType(target, node, symbolMap);
		/* ========== */
	    /* Attributes */
	    /* ========== */
		/* = class, function, usage ========== */
		CodeType clazz = target.getClazz();
		if(clazz != null) {
			BindingNode clazzNode = JGMLTraversalUtil.traverseCodeType(clazz, new BindingNode(), symbolMap);
			node.addAssociation("CLAZZ", clazzNode);
		}
		List<CodeType> function = target.getFunction();
		if(function != null && function.size() > 0) {
			BindingNode functionNode = JGMLTraversalUtil.traverseCodeType(function.get(0), new BindingNode(), symbolMap);
			node.addAssociation("FUNCTION", functionNode);
		}
		List<CodeType> usage = target.getUsage();
		if(usage != null && usage.size() > 0) {
			BindingNode usageNode = JGMLTraversalUtil.traverseCodeType(usage.get(0), new BindingNode(), symbolMap);
			node.addAssociation("USAGE", usageNode);
		}
		/* ========== */
		XMLGregorianCalendar yearOfConstruction = target.getYearOfConstruction();
		if(yearOfConstruction != null) {
			Integer year = yearOfConstruction.toGregorianCalendar().get(Calendar.YEAR);
			node.addAttribute("YEAROFCONSTRUCTION", year);
		}
		XMLGregorianCalendar yearOfDemolition = target.getYearOfDemolition();
		if(yearOfDemolition != null) {
			Integer year = yearOfDemolition.toGregorianCalendar().get(Calendar.YEAR);
			node.addAttribute("YEAROFDEMOLITION", year);
		}
		CodeType roofType = target.getRoofType();
		if(roofType != null) {
			node.addAssociation("ROOFTYPE", JGMLTraversalUtil.traverseCodeType(roofType, new BindingNode(), symbolMap));
		}
		/* ========== */
		//TODO: Traversal association
		LengthType measuredHeight = target.getMeasuredHeight();
		if(measuredHeight != null) {
			node.addAttribute("MEASUREDHEIGHT", measuredHeight.getValue());
			node.addAttribute("MEASUREDHEIGHTUOM", measuredHeight.getUom());
		}
		BigInteger storeysAboveGround = target.getStoreysAboveGround();
		if(storeysAboveGround != null) {
			node.addAttribute("STOREYSABOVEGROUND", storeysAboveGround.intValue());
		}
		BigInteger storeysBelowGround = target.getStoreysBelowGround();
		if(storeysBelowGround != null) {
			node.addAttribute("STOREYSBELOWGROUND", storeysBelowGround.intValue());
		}
		MeasureOrNullListType storeyHeightsAboveGround = target.getStoreyHeightsAboveGround();
		if(storeyHeightsAboveGround != null) {
			//TODO : consider all list values
			List<String> v = storeyHeightsAboveGround.getValue();
			if(v != null && v.size() > 0) {
				node.addAttribute("STOREYHEIGHTSABOVEGROUND", v.get(0));
				node.addAttribute("STOREYHEIGHTSABOVEUNIT", storeyHeightsAboveGround.getUom());
			}
		}
		MeasureOrNullListType storeyHeightsBelowGround = target.getStoreyHeightsBelowGround();
		if(storeyHeightsBelowGround != null) {
			//TODO : consider all list values
			List<String> v = storeyHeightsBelowGround.getValue();
			if(v != null && v.size() > 0) {
				node.addAttribute("STOREYHEIGHTSBELOWGROUND", v.get(0));
				node.addAttribute("STOREYHEIGHTSBELOWUNIT", storeyHeightsAboveGround.getUom());
			}
		}
		/* ============ */
	    /* Associations */
	    /* ============ */
	    List<AddressPropertyType> address = target.getAddress();
	    for(AddressPropertyType a : address) {
	    	BindingNode an = JCoreTraversalUtil.convertAddressPropertyType(a, new BindingNode(), symbolMap);
	    	node.addCollection("ADDRESS", an);
	    }
	    List<BuildingInstallationPropertyType> outerBuildingInstallation = target.getOuterBuildingInstallation();
	    for(BuildingInstallationPropertyType bip : outerBuildingInstallation) {
	    	BindingNode obi = traverseBuildingInstallationPropertyType(bip, new BindingNode(), symbolMap);
	    	node.addCollection("BUILDINGINSTALLATION", obi);
	    }
	    List<IntBuildingInstallationPropertyType> interiorBuildingInstallation = target.getInteriorBuildingInstallation();
	    for(IntBuildingInstallationPropertyType ibip : interiorBuildingInstallation) {
	    	BindingNode ibi = traverseIntBuildingInstallationPropertyType(ibip, new BindingNode(), symbolMap);
	    	node.addCollection("INTBUILDINGINSTALLATION", ibi);
	    }
	    List<BoundarySurfacePropertyType> boundedBySurface = target.getCityObjectBoundedBy();
	    for(BoundarySurfacePropertyType bs : boundedBySurface) {
	    	BindingNode bsn = traverseBuildingBoundarySurfacePropertyType(bs, new BindingNode(), symbolMap);
	    	node.addCollection("BOUNDARYSURFACE", bsn);
	    }
	    List<InteriorRoomPropertyType> interiorRoom = target.getInteriorRoom();
	    for(InteriorRoomPropertyType r : interiorRoom) {
	    	BindingNode room = traverseRoomPropertyType(r, new BindingNode(), symbolMap);
	    	node.addCollection("ROOM", room);
	    }
	    List<BuildingPartPropertyType> consistsOfBuildingPart = target.getConsistsOfBuildingPart();
	    for(BuildingPartPropertyType bp : consistsOfBuildingPart) {
	    	BindingNode buildingPart = traverseAbstractBuildingType(bp.getBuildingPart(), new BindingNode(), symbolMap);
	    	node.addCollection("BUILDINGPART", buildingPart);
	    }
	    /* ========== */
	    /* Geometries */
	    /* ========== */
	    MultiSurfacePropertyType lod0FootPrint = target.getLod0FootPrint();
	    if(lod0FootPrint != null) {
	    	BindingNode lod0FootPrintNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod0FootPrint, new BindingNode(), symbolMap);
			node.addAssociation("LOD0FOOTPRINT", lod0FootPrintNode);
	    }
	    MultiSurfacePropertyType lod0RoofEdge = target.getLod0RoofEdge();
	    if(lod0RoofEdge != null) {
	    	BindingNode lod0RoofEdgeNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod0RoofEdge, new BindingNode(), symbolMap);
			node.addAssociation("LOD0ROOFEDGE", lod0RoofEdgeNode);
	    }
	    /* ========== */
	    SolidPropertyType lod1Solid = target.getLod1Solid();
	    if(lod1Solid != null) {
	    	BindingNode lod1SolidNode = JGMLTraversalUtil.traverseSolidPropertyType(lod1Solid, new BindingNode(), symbolMap);
			node.addAssociation("LOD1SOLID", lod1SolidNode);
	    }
	    MultiSurfacePropertyType lod1MultiSurface = target.getLod1MultiSurface();
	    if(lod1MultiSurface != null) {
	    	BindingNode lod1MultiSurfaceNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod1MultiSurface, new BindingNode(), symbolMap);
			node.addAssociation("LOD1MULTISURFACE", lod1MultiSurfaceNode);
	    }
	    MultiCurvePropertyType lod1TerrainIntersection = target.getLod1TerrainIntersection();
	    if(lod1TerrainIntersection != null) {
	    	BindingNode lod1TerrainIntersectionNode = JGMLTraversalUtil.traverseMultiCurvePropertyType(lod1TerrainIntersection, new BindingNode(), symbolMap);
			node.addAssociation("LOD1TERRAININTERSECTION", lod1TerrainIntersectionNode);
	    }
	    /* ========== */
	    SolidPropertyType lod2Solid = target.getLod2Solid();
	    if(lod2Solid != null) {
	    	BindingNode lod2SolidNode = JGMLTraversalUtil.traverseSolidPropertyType(lod2Solid, new BindingNode(), symbolMap);
			node.addAssociation("LOD2SOLID", lod2SolidNode);
	    }
	    MultiSurfacePropertyType lod2MultiSurface = target.getLod2MultiSurface();
	    if(lod2MultiSurface != null) {
	    	BindingNode lod2MultiSurfaceNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod2MultiSurface, new BindingNode(), symbolMap);
			node.addAssociation("LOD2MULTISURFACE", lod2MultiSurfaceNode);
	    }
	    MultiCurvePropertyType lod2MultiCurve = target.getLod2MultiCurve();
	    if(lod2MultiCurve != null) {
	    	BindingNode lod2MultiCurveNode = JGMLTraversalUtil.traverseMultiCurvePropertyType(lod2MultiCurve, new BindingNode(), symbolMap);
			node.addAssociation("LOD2MULTICURVE", lod2MultiCurveNode);
	    }
	    MultiCurvePropertyType lod2TerrainIntersection = target.getLod2TerrainIntersection();
	    if(lod2TerrainIntersection != null) {
	    	BindingNode lod2TerrainIntersectionNode = JGMLTraversalUtil.traverseMultiCurvePropertyType(lod2TerrainIntersection, new BindingNode(), symbolMap);
			node.addAssociation("LOD2TERRAININTERSECTION", lod2TerrainIntersectionNode);
	    }    
	    /* ========== */
	    SolidPropertyType lod3Solid = target.getLod3Solid();
	    if(lod3Solid != null) {
	    	BindingNode lod3SolidNode = JGMLTraversalUtil.traverseSolidPropertyType(lod3Solid, new BindingNode(), symbolMap);
			node.addAssociation("LOD3SOLID", lod3SolidNode);
	    }
	    MultiSurfacePropertyType lod3MultiSurface = target.getLod3MultiSurface();
	    if(lod3MultiSurface != null) {
	    	BindingNode lod3MultiSurfaceNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod3MultiSurface, new BindingNode(), symbolMap);
			node.addAssociation("LOD3MULTISURFACE", lod3MultiSurfaceNode);
	    }
	    MultiCurvePropertyType lod3MultiCurve = target.getLod3MultiCurve();
	    if(lod3MultiCurve != null) {
	    	BindingNode lod3MultiCurveNode = JGMLTraversalUtil.traverseMultiCurvePropertyType(lod3MultiCurve, new BindingNode(), symbolMap);
			node.addAssociation("LOD3MULTICURVE", lod3MultiCurveNode);
	    }
	    MultiCurvePropertyType lod3TerrainIntersection = target.getLod3TerrainIntersection();
	    if(lod3TerrainIntersection != null) {
	    	BindingNode lod3TerrainIntersectionNode = JGMLTraversalUtil.traverseMultiCurvePropertyType(lod3TerrainIntersection, new BindingNode(), symbolMap);
			node.addAssociation("LOD3TERRAININTERSECTION", lod3TerrainIntersectionNode);
	    }
	    /* ========== */
	    SolidPropertyType lod4Solid = target.getLod4Solid();
	    if(lod4Solid != null) {
	    	BindingNode lod4SolidNode = JGMLTraversalUtil.traverseSolidPropertyType(lod4Solid, new BindingNode(), symbolMap);
			node.addAssociation("LOD4SOLID", lod4SolidNode);
	    }
	    MultiSurfacePropertyType lod4MultiSurface = target.getLod4MultiSurface();
	    if(lod4MultiSurface != null) {
	    	BindingNode lod4MultiSurfaceNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod4MultiSurface, new BindingNode(), symbolMap);
			node.addAssociation("LOD4MULTISURFACE", lod4MultiSurfaceNode);
	    }
	    MultiCurvePropertyType lod4MultiCurve = target.getLod4MultiCurve(); 
	    if(lod4MultiCurve != null) {
	    	BindingNode lod4MultiCurveNode = JGMLTraversalUtil.traverseMultiCurvePropertyType(lod4MultiCurve, new BindingNode(), symbolMap);
			node.addAssociation("LOD4MULTICURVE", lod4MultiCurveNode);
	    }
	    MultiCurvePropertyType lod4TerrainIntersection = target.getLod4TerrainIntersection();
	    if(lod4TerrainIntersection != null) {
	    	BindingNode lod4TerrainIntersectionNode = JGMLTraversalUtil.traverseMultiCurvePropertyType(lod4TerrainIntersection, new BindingNode(), symbolMap);
			node.addAssociation("LOD4TERRAININTERSECTION", lod4TerrainIntersectionNode);
	    }
		return node;
	}

	public static BindingNode traverseRoomPropertyType(InteriorRoomPropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
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
		/* ========== */
	    /* Room Type  */
	    /* ========== */
		RoomType room = target.getRoom();
		if(room != null) {
			/* =========== */
		    /* Super Class */
		    /* =========== */
			node = JCoreTraversalUtil.convertAbstractCityObjectType(room, node, symbolMap);
			/* ========== */
		    /* Attributes */
		    /* ========== */
			/* = class, function, usage ========== */
			CodeType clazz = room.getClazz();
			if(clazz != null) {
				BindingNode clazzNode = JGMLTraversalUtil.traverseCodeType(clazz, new BindingNode(), symbolMap);
				node.addAssociation("CLAZZ", clazzNode);
			}
			List<CodeType> function = room.getFunction();
			if(function != null && function.size() > 0) {
				BindingNode functionNode = JGMLTraversalUtil.traverseCodeType(function.get(0), new BindingNode(), symbolMap);
				node.addAssociation("FUNCTION", functionNode);
			}
			List<CodeType> usage = room.getUsage();
			if(usage != null && usage.size() > 0) {
				BindingNode usageNode = JGMLTraversalUtil.traverseCodeType(usage.get(0), new BindingNode(), symbolMap);
				node.addAssociation("USAGE", usageNode);
			}
			/* ============= */
		    /* Associations  */
		    /* ============= */
			List<BoundarySurfacePropertyType> boundedBySurface = room.getCityObjectBoundedBy();
		    for(BoundarySurfacePropertyType bs : boundedBySurface) {
		    	BindingNode bsn = traverseBuildingBoundarySurfacePropertyType(bs, new BindingNode(), symbolMap);
		    	node.addCollection("BOUNDARYSURFACE", bsn);
		    }
			List<InteriorFurniturePropertyType> interiorFurniture = room.getInteriorFurniture();
		    for(InteriorFurniturePropertyType ifp : interiorFurniture) {
		    	BindingNode furnitureNode = traverseInteriorFurniturePropertyType(ifp, new BindingNode(), symbolMap);
		    	node.addCollection("INTERIORFURNITURE", furnitureNode);
		    }
		    List<IntBuildingInstallationPropertyType> roomInstallation = room.getRoomInstallation();
		    for(IntBuildingInstallationPropertyType ibip : roomInstallation) {
		    	BindingNode ibi = traverseIntBuildingInstallationPropertyType(ibip, new BindingNode(), symbolMap);
		    	node.addCollection("ROOMINSTALLATION", ibi);
		    }
		    /* ========== */
		    /* Geometries */
		    /* ========== */
		    SolidPropertyType lod4Solid = room.getLod4Solid();
		    if(lod4Solid != null) {
		    	BindingNode lod4SolidNode = JGMLTraversalUtil.traverseSolidPropertyType(lod4Solid, new BindingNode(), symbolMap);
				node.addAssociation("LOD4SOLID", lod4SolidNode);
		    }
		    MultiSurfacePropertyType lod4MultiSurface = room.getLod4MultiSurface();
		    if(lod4MultiSurface != null) {
		    	BindingNode lod4MultiSurfaceNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod4MultiSurface, new BindingNode(), symbolMap);
				node.addAssociation("LOD4MULTISURFACE", lod4MultiSurfaceNode);
		    }
		}
		return node;
	}

	public static BindingNode traverseBuildingBoundarySurfacePropertyType(BoundarySurfacePropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
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
		/* ===================== */
	    /* BoundarySurface Type  */
	    /* ===================== */
		JAXBElement<? extends AbstractBoundarySurfaceType> jabs = target.getBoundarySurface();
		if(jabs != null) {
			AbstractBoundarySurfaceType abs = target.getBoundarySurface().getValue();
			if(abs != null) {
				/* =========== */
			    /* Super Class */
			    /* =========== */
				node = JCoreTraversalUtil.convertAbstractCityObjectType(abs, node, symbolMap);
				node.addAttribute("BOUNDARYTYPE", abs.getClass().getSimpleName().replace("Type", ""));
				/* ============ */
			    /* Association  */
			    /* ============ */
				/* = Opening ========== */
				List<OpeningPropertyType> opening = abs.getOpening();
				for(OpeningPropertyType op : opening) {
			    	BindingNode opNode = traverseBuildingOpeningPropertyType(op, new BindingNode(), symbolMap);
			    	node.addCollection("OPENING", opNode);
			    }
				/* ========== */
			    /* Geometries */
			    /* ========== */
				MultiSurfacePropertyType lod2MultiSurface = abs.getLod2MultiSurface();
				if(lod2MultiSurface != null) {
			    	BindingNode lod2MultiSurfaceNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod2MultiSurface, new BindingNode(), symbolMap);
					node.addAssociation("LOD2MULTISURFACE", lod2MultiSurfaceNode);
			    }
				MultiSurfacePropertyType lod3MultiSurface = abs.getLod3MultiSurface();
				if(lod3MultiSurface != null) {
			    	BindingNode lod3MultiSurfaceNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod3MultiSurface, new BindingNode(), symbolMap);
					node.addAssociation("LOD3MULTISURFACE", lod3MultiSurfaceNode);
			    }
				
				MultiSurfacePropertyType lod4MultiSurface = abs.getLod4MultiSurface();
				if(lod4MultiSurface != null) {
			    	BindingNode lod4MultiSurfaceNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod4MultiSurface, new BindingNode(), symbolMap);
					node.addAssociation("LOD4MULTISURFACE", lod4MultiSurfaceNode);
			    }
			}
		}
		return node;
	}

	public static BindingNode traverseInteriorFurniturePropertyType(InteriorFurniturePropertyType target,
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
		/* ======================= */
	    /* BuildingFurniture Type  */
	    /* ======================= */
		BuildingFurnitureType buildingFurniture = target.getBuildingFurniture();
		if(buildingFurniture != null) {
			/* =========== */
		    /* Super Class */
		    /* =========== */
			node = JCoreTraversalUtil.convertAbstractCityObjectType(buildingFurniture, node, symbolMap);
			/* ========== */
		    /* Attributes */
		    /* ========== */
			/* = class, function, usage ========== */
			CodeType clazz = buildingFurniture.getClazz();
			if(clazz != null) {
				BindingNode clazzNode = JGMLTraversalUtil.traverseCodeType(clazz, new BindingNode(), symbolMap);
				node.addAssociation("CLAZZ", clazzNode);
			}
			List<CodeType> function = buildingFurniture.getFunction();
			if(function != null && function.size() > 0) {
				BindingNode functionNode = JGMLTraversalUtil.traverseCodeType(function.get(0), new BindingNode(), symbolMap);
				node.addAssociation("FUNCTION", functionNode);
			}
			List<CodeType> usage = buildingFurniture.getUsage();
			if(usage != null && usage.size() > 0) {
				BindingNode usageNode = JGMLTraversalUtil.traverseCodeType(usage.get(0), new BindingNode(), symbolMap);
				node.addAssociation("USAGE", usageNode);
			}
			/* ========== */
		    /* Geometries */
		    /* ========== */
			//lod4Geometry
			GeometryPropertyType lod4Geometry = buildingFurniture.getLod4Geometry();
			if(lod4Geometry != null) {
				BindingNode lod4GeometryNode = JGMLTraversalUtil.traverseGeometryPropertyType(lod4Geometry, new BindingNode(), symbolMap);
				node.addAssociation("LOD4GEOMETRY", lod4GeometryNode);
			}
			//lod4ImplicitRepresentation
			ImplicitRepresentationPropertyType lod4ImplicitRepresentation = buildingFurniture.getLod4ImplicitRepresentation();
			if(lod4ImplicitRepresentation != null) {
				BindingNode lod4ImplicitRepresentationNode = JCoreTraversalUtil.convertImplicitRepresentationPropertyType(lod4ImplicitRepresentation, new BindingNode(), symbolMap);
				node.addAssociation("LOD4IMPLICITREPRESENTATION", lod4ImplicitRepresentationNode);
			}
		}
		return node;
	}
	
	public static BindingNode traverseIntBuildingInstallationPropertyType(IntBuildingInstallationPropertyType target,
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
		/* ============================= */
	    /* IntBuildingInstallation Type  */
	    /* ============================= */
		IntBuildingInstallationType intBuildingInstallation = target.getIntBuildingInstallation();
		if(intBuildingInstallation != null) {
			/* =========== */
		    /* Super Class */
		    /* =========== */
			node = JCoreTraversalUtil.convertAbstractCityObjectType(intBuildingInstallation, node, symbolMap);
			/* ========== */
		    /* Attributes */
		    /* ========== */
			/* = class, function, usage ========== */
			CodeType clazz = intBuildingInstallation.getClazz();
			if(clazz != null) {
				BindingNode clazzNode = JGMLTraversalUtil.traverseCodeType(clazz, new BindingNode(), symbolMap);
				node.addAssociation("CLAZZ", clazzNode);
			}
			List<CodeType> function = intBuildingInstallation.getFunction();
			if(function != null && function.size() > 0) {
				BindingNode functionNode = JGMLTraversalUtil.traverseCodeType(function.get(0), new BindingNode(), symbolMap);
				node.addAssociation("FUNCTION", functionNode);
			}
			List<CodeType> usage = intBuildingInstallation.getUsage();
			if(usage != null && usage.size() > 0) {
				BindingNode usageNode = JGMLTraversalUtil.traverseCodeType(usage.get(0), new BindingNode(), symbolMap);
				node.addAssociation("USAGE", usageNode);
			}
			/* ============ */
		    /* Association  */
		    /* ============ */
			List<BoundarySurfacePropertyType> boundedBySurface = intBuildingInstallation.getCityObjectBoundedBy();
			for(BoundarySurfacePropertyType bs : boundedBySurface) {
		    	BindingNode bsNode = traverseBuildingBoundarySurfacePropertyType(bs, new BindingNode(), symbolMap);
		    	node.addCollection("BOUNDARYSURFACE", bsNode);
		    }	
			/* ========== */
		    /* Geometries */
		    /* ========== */
			//lod4Geometry
			GeometryPropertyType lod4Geometry = intBuildingInstallation.getLod4Geometry();
			if(lod4Geometry != null) {
				BindingNode lod4GeometryNode = JGMLTraversalUtil.traverseGeometryPropertyType(lod4Geometry, new BindingNode(), symbolMap);
				node.addAssociation("LOD4GEOMETRY", lod4GeometryNode);
			}
			//lod4ImplicitRepresentation
			ImplicitRepresentationPropertyType lod4ImplicitRepresentation = intBuildingInstallation.getLod4ImplicitRepresentation();
			if(lod4ImplicitRepresentation != null) {
				BindingNode lod4SolidNode = JCoreTraversalUtil.convertImplicitRepresentationPropertyType(lod4ImplicitRepresentation, new BindingNode(), symbolMap);
				node.addAssociation("LOD4IMPLICITREPRESENTATION", lod4SolidNode);
			}
		}	
		return node;
	}

	public static BindingNode traverseBuildingInstallationPropertyType(BuildingInstallationPropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
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
		/* ========================== */
	    /* BuildingInstallation Type  */
	    /* ========================== */
		BuildingInstallationType buildingInstallation = target.getBuildingInstallation();
		if(buildingInstallation != null) {
			/* =========== */
		    /* Super Class */
		    /* =========== */
			node = JCoreTraversalUtil.convertAbstractCityObjectType(buildingInstallation, node, symbolMap);
			/* ========== */
		    /* Attributes */
		    /* ========== */
			/* = class, function, usage ========== */
			CodeType clazz = buildingInstallation.getClazz();
			if(clazz != null) {
				BindingNode clazzNode = JGMLTraversalUtil.traverseCodeType(clazz, new BindingNode(), symbolMap);
				node.addAssociation("CLAZZ", clazzNode);
			}
			List<CodeType> function = buildingInstallation.getFunction();
			if(function != null && function.size() > 0) {
				BindingNode functionNode = JGMLTraversalUtil.traverseCodeType(function.get(0), new BindingNode(), symbolMap);
				node.addAssociation("FUNCTION", functionNode);
			}
			List<CodeType> usage = buildingInstallation.getUsage();
			if(usage != null && usage.size() > 0) {
				BindingNode usageNode = JGMLTraversalUtil.traverseCodeType(usage.get(0), new BindingNode(), symbolMap);
				node.addAssociation("USAGE", usageNode);
			}
			/* ============ */
		    /* Association  */
		    /* ============ */
			//boundedBySurface
			List<BoundarySurfacePropertyType> boundedBySurface = buildingInstallation.getCityObjectBoundedBy();
			for(BoundarySurfacePropertyType bs : boundedBySurface) {
		    	BindingNode bsNode = traverseBuildingBoundarySurfacePropertyType(bs, new BindingNode(), symbolMap);
		    	node.addCollection("BOUNDARYSURFACE", bsNode);
		    }
			/* ========== */
		    /* Geometries */
		    /* ========== */
			//Geometry
			GeometryPropertyType lod2Geometry = buildingInstallation.getLod2Geometry();
			if(lod2Geometry != null) {
				BindingNode lod2GeometryNode = JGMLTraversalUtil.traverseGeometryPropertyType(lod2Geometry, new BindingNode(), symbolMap);
				node.addAssociation("LOD2GEOMETRY", lod2GeometryNode);
			}
		    GeometryPropertyType lod3Geometry = buildingInstallation.getLod3Geometry();
			if(lod3Geometry != null) {
				BindingNode lod3GeometryNode = JGMLTraversalUtil.traverseGeometryPropertyType(lod3Geometry, new BindingNode(), symbolMap);
				node.addAssociation("LOD3GEOMETRY", lod3GeometryNode);
			}
			GeometryPropertyType lod4Geometry = buildingInstallation.getLod4Geometry();
			if(lod4Geometry != null) {
				BindingNode lod4GeometryNode = JGMLTraversalUtil.traverseGeometryPropertyType(lod4Geometry, new BindingNode(), symbolMap);
				node.addAssociation("LOD4GEOMETRY", lod4GeometryNode);
			}
			//ImplicitRepresentation
			ImplicitRepresentationPropertyType lod2ImplicitRepresentation = buildingInstallation.getLod2ImplicitRepresentation();
			if(lod2ImplicitRepresentation != null) {
				BindingNode lod2ImplicitRepresentationNode = JCoreTraversalUtil.convertImplicitRepresentationPropertyType(lod2ImplicitRepresentation, new BindingNode(), symbolMap);
				node.addAssociation("LOD2IMPLICITREPRESENTATION", lod2ImplicitRepresentationNode);
			}
			ImplicitRepresentationPropertyType lod3ImplicitRepresentation = buildingInstallation.getLod3ImplicitRepresentation();
			if(lod3ImplicitRepresentation != null) {
				BindingNode lod3ImplicitRepresentationNode = JCoreTraversalUtil.convertImplicitRepresentationPropertyType(lod3ImplicitRepresentation, new BindingNode(), symbolMap);
				node.addAssociation("LOD3IMPLICITREPRESENTATION", lod3ImplicitRepresentationNode);
			}
			ImplicitRepresentationPropertyType lod4ImplicitRepresentation = buildingInstallation.getLod4ImplicitRepresentation();
			if(lod4ImplicitRepresentation != null) {
				BindingNode lod4ImplicitRepresentationNode = JCoreTraversalUtil.convertImplicitRepresentationPropertyType(lod4ImplicitRepresentation, new BindingNode(), symbolMap);
				node.addAssociation("LOD4IMPLICITREPRESENTATION", lod4ImplicitRepresentationNode);
			}
		}	
		return node;
	}
	
	public static BindingNode traverseBuildingOpeningPropertyType(OpeningPropertyType target, BindingNode node, XLinkSymbolMap symbolMap) {
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
		/* ===================== */
	    /* BuildingOpening Type  */
	    /* ===================== */
		JAXBElement<? extends AbstractOpeningType> jOpening = target.getOpening();
		if(jOpening != null) {
			AbstractOpeningType opening = jOpening.getValue();
			if(opening != null) {
				/* =========== */
			    /* Super Class */
			    /* =========== */
				node = JCoreTraversalUtil.convertAbstractCityObjectType(opening, node, symbolMap);
				
				/* ========== */
			    /* Geometries */
			    /* ========== */
				//MultiSurface
				MultiSurfacePropertyType lod3MultiSurface = opening.getLod3MultiSurface();
				if(lod3MultiSurface != null) {
			    	BindingNode lod3MultiSurfaceNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod3MultiSurface, new BindingNode(), symbolMap);
					node.addAssociation("LOD3MULTISURFACE", lod3MultiSurfaceNode);
			    }
			    MultiSurfacePropertyType lod4MultiSurface = opening.getLod4MultiSurface();
			    if(lod4MultiSurface != null) {
			    	BindingNode lod4MultiSurfaceNode = JGMLTraversalUtil.traverseMultiSurfacePropertyType(lod4MultiSurface, new BindingNode(), symbolMap);
					node.addAssociation("LOD4MULTISURFACE", lod4MultiSurfaceNode);
			    }
			    //ImplicitRepresentation
			    ImplicitRepresentationPropertyType lod3ImplicitRepresentation = opening.getLod3ImplicitRepresentation();
			    if(lod3ImplicitRepresentation != null) {
					BindingNode lod3mplicitRepresentationNode = JCoreTraversalUtil.convertImplicitRepresentationPropertyType(lod3ImplicitRepresentation, new BindingNode(), symbolMap);
					node.addAssociation("LOD3IMPLICITREPRESENTATION", lod3mplicitRepresentationNode);
				}
			    ImplicitRepresentationPropertyType lod4ImplicitRepresentation = opening.getLod4ImplicitRepresentation();
			    if(lod4ImplicitRepresentation != null) {
					BindingNode lod4mplicitRepresentationNode = JCoreTraversalUtil.convertImplicitRepresentationPropertyType(lod4ImplicitRepresentation, new BindingNode(), symbolMap);
					node.addAssociation("LOD4IMPLICITREPRESENTATION", lod4mplicitRepresentationNode);
				}
			    /* ========= */
			    /* Sub Class */
			    /* ========= */
				if(opening instanceof DoorType) {
					List<AddressPropertyType> address = ((DoorType) opening).getAddress();
					if(address != null && address.size() > 0) {
						BindingNode addressNode = JCoreTraversalUtil.convertAddressPropertyType(address.get(0), new BindingNode(), symbolMap);
						node.addAssociation("ADDRESS", addressNode);
					}
					node.addAttribute("OPENINGTYPE", "DOOR");
				} else {
					node.addAttribute("OPENINGTYPE", "WINDOW");
				}
			}
		}
		return node;
	}
}
