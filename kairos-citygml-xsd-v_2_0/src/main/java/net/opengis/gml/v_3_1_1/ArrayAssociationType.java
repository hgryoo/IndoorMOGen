//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.gml.v_3_1_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml.appearance.v_2_0.AbstractSurfaceDataType;
import net.opengis.citygml.appearance.v_2_0.AbstractTextureParameterizationType;
import net.opengis.citygml.appearance.v_2_0.AbstractTextureType;
import net.opengis.citygml.appearance.v_2_0.AppearanceType;
import net.opengis.citygml.appearance.v_2_0.GeoreferencedTextureType;
import net.opengis.citygml.appearance.v_2_0.ParameterizedTextureType;
import net.opengis.citygml.appearance.v_2_0.TexCoordGenType;
import net.opengis.citygml.appearance.v_2_0.TexCoordListType;
import net.opengis.citygml.appearance.v_2_0.X3DMaterialType;
import net.opengis.citygml.bridge.v_2_0.AbstractBridgeType;
import net.opengis.citygml.bridge.v_2_0.BridgeConstructionElementType;
import net.opengis.citygml.bridge.v_2_0.BridgeFurnitureType;
import net.opengis.citygml.bridge.v_2_0.BridgeInstallationType;
import net.opengis.citygml.bridge.v_2_0.BridgePartType;
import net.opengis.citygml.bridge.v_2_0.BridgeRoomType;
import net.opengis.citygml.bridge.v_2_0.BridgeType;
import net.opengis.citygml.bridge.v_2_0.IntBridgeInstallationType;
import net.opengis.citygml.building.v_2_0.AbstractBuildingType;
import net.opengis.citygml.building.v_2_0.BuildingFurnitureType;
import net.opengis.citygml.building.v_2_0.BuildingInstallationType;
import net.opengis.citygml.building.v_2_0.BuildingPartType;
import net.opengis.citygml.building.v_2_0.BuildingType;
import net.opengis.citygml.building.v_2_0.IntBuildingInstallationType;
import net.opengis.citygml.building.v_2_0.RoomType;
import net.opengis.citygml.cityfurniture.v_2_0.CityFurnitureType;
import net.opengis.citygml.cityobjectgroup.v_2_0.CityObjectGroupType;
import net.opengis.citygml.generics.v_2_0.GenericCityObjectType;
import net.opengis.citygml.landUse.v_2_0.LandUseType;
import net.opengis.citygml.relief.v_2_0.AbstractReliefComponentType;
import net.opengis.citygml.relief.v_2_0.BreaklineReliefType;
import net.opengis.citygml.relief.v_2_0.MassPointReliefType;
import net.opengis.citygml.relief.v_2_0.RasterReliefType;
import net.opengis.citygml.relief.v_2_0.ReliefFeatureType;
import net.opengis.citygml.relief.v_2_0.TINReliefType;
import net.opengis.citygml.texturedsurface.v_2_0.AbstractAppearanceType;
import net.opengis.citygml.texturedsurface.v_2_0.MaterialType;
import net.opengis.citygml.texturedsurface.v_2_0.SimpleTextureType;
import net.opengis.citygml.texturedsurface.v_2_0.TexturedSurfaceType;
import net.opengis.citygml.transportation.v_2_0.AbstractTransportationObjectType;
import net.opengis.citygml.transportation.v_2_0.AuxiliaryTrafficAreaType;
import net.opengis.citygml.transportation.v_2_0.RailwayType;
import net.opengis.citygml.transportation.v_2_0.RoadType;
import net.opengis.citygml.transportation.v_2_0.SquareType;
import net.opengis.citygml.transportation.v_2_0.TrackType;
import net.opengis.citygml.transportation.v_2_0.TrafficAreaType;
import net.opengis.citygml.transportation.v_2_0.TransportationComplexType;
import net.opengis.citygml.tunnel.v_2_0.AbstractTunnelType;
import net.opengis.citygml.tunnel.v_2_0.HollowSpaceType;
import net.opengis.citygml.tunnel.v_2_0.IntTunnelInstallationType;
import net.opengis.citygml.tunnel.v_2_0.TunnelFurnitureType;
import net.opengis.citygml.tunnel.v_2_0.TunnelInstallationType;
import net.opengis.citygml.tunnel.v_2_0.TunnelPartType;
import net.opengis.citygml.tunnel.v_2_0.TunnelType;
import net.opengis.citygml.v_2_0.AbstractCityObjectType;
import net.opengis.citygml.v_2_0.AbstractSiteType;
import net.opengis.citygml.v_2_0.AddressType;
import net.opengis.citygml.v_2_0.CityModelType;
import net.opengis.citygml.v_2_0.ImplicitGeometryType;
import net.opengis.citygml.vegetation.v_2_0.AbstractVegetationObjectType;
import net.opengis.citygml.vegetation.v_2_0.PlantCoverType;
import net.opengis.citygml.vegetation.v_2_0.SolitaryVegetationObjectType;
import net.opengis.citygml.waterbody.v_2_0.AbstractWaterBoundarySurfaceType;
import net.opengis.citygml.waterbody.v_2_0.AbstractWaterObjectType;
import net.opengis.citygml.waterbody.v_2_0.WaterBodyType;
import net.opengis.citygml.waterbody.v_2_0.WaterClosureSurfaceType;
import net.opengis.citygml.waterbody.v_2_0.WaterGroundSurfaceType;
import net.opengis.citygml.waterbody.v_2_0.WaterSurfaceType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * A base for derived types used to specify complex types containing an array of objects, by unspecified UML association - either composition or aggregation.  An instance of this type contains elements representing Objects.
 * 
 * Ideally this type would be derived by extension of AssociationType.  
 * However, this leads to a non-deterministic content model, since both the base and the extension have minOccurs="0", and is thus prohibited in XML Schema.
 * 
 * <p>Java class for ArrayAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}_Object" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayAssociationType", propOrder = {
    "object"
})
public class ArrayAssociationType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElementRef(name = "_Object", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> object;

    /**
     * Gets the value of the object property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the object property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link MultiPolygonType }{@code >}
     * {@link JAXBElement }{@code <}{@link RasterReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.InteriorWallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiCurveCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGMLType }{@code >}
     * {@link JAXBElement }{@code <}{@link AuxiliaryTrafficAreaType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.WallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractMetaDataType }{@code >}
     * {@link JAXBElement }{@code <}{@link OperationMethodType }{@code >}
     * {@link JAXBElement }{@code <}{@link ReliefFeatureType }{@code >}
     * {@link JAXBElement }{@code <}{@link TinType }{@code >}
     * {@link JAXBElement }{@code <}{@link WaterBodyType }{@code >}
     * {@link JAXBElement }{@code <}{@link CityObjectGroupType }{@code >}
     * {@link JAXBElement }{@code <}{@link GenericMetaDataType }{@code >}
     * {@link JAXBElement }{@code <}{@link SquareType }{@code >}
     * {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     * {@link JAXBElement }{@code <}{@link MaterialType }{@code >}
     * {@link JAXBElement }{@code <}{@link DerivedCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link TexturedSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeoreferencedTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link PolyhedralSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeTopologyComplexType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link ArrayType }{@code >}
     * {@link JAXBElement }{@code <}{@link CityFurnitureType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link ImageDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimePeriodType }{@code >}
     * {@link JAXBElement }{@code <}{@link TransformationType }{@code >}
     * {@link JAXBElement }{@code <}{@link FeatureCollectionType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.AbstractOpeningType }{@code >}
     * {@link JAXBElement }{@code <}{@link MovingObjectStatusType }{@code >}
     * {@link JAXBElement }{@code <}{@link TopoComplexType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiLineStringType }{@code >}
     * {@link JAXBElement }{@code <}{@link UserDefinedCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link EdgeType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.FloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link PlantCoverType }{@code >}
     * {@link JAXBElement }{@code <}{@link TunnelFurnitureType }{@code >}
     * {@link JAXBElement }{@code <}{@link TemporalCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link ConcatenatedOperationType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeneralConversionType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.AbstractOpeningType }{@code >}
     * {@link JAXBElement }{@code <}{@link TunnelPartType }{@code >}
     * {@link JAXBElement }{@code <}{@link VerticalCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     * {@link JAXBElement }{@code <}{@link RailwayType }{@code >}
     * {@link JAXBElement }{@code <}{@link RectifiedGridCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link PassThroughOperationType }{@code >}
     * {@link JAXBElement }{@code <}{@link DefinitionProxyType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.AbstractBoundarySurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link SphericalCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeComplexType }{@code >}
     * {@link JAXBElement }{@code <}{@link VerticalCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link RectifiedGridType }{@code >}
     * {@link JAXBElement }{@code <}{@link BuildingType }{@code >}
     * {@link JAXBElement }{@code <}{@link PolygonType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCurveType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.CeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link CurveType }{@code >}
     * {@link JAXBElement }{@code <}{@link CityModelType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTextureParameterizationType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeSolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.OuterFloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractSolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link BuildingPartType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiSolidCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link IntBridgeInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeReferenceSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractRingType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link CylindricalCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link GenericCityObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link OrientableSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link MassPointReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link LandUseType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTopologyType }{@code >}
     * {@link JAXBElement }{@code <}{@link VerticalDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link ConventionalUnitType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTopoPrimitiveType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.OuterCeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link EngineeringCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeographicCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.WindowType }{@code >}
     * {@link JAXBElement }{@code <}{@link PointType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgeInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgePartType }{@code >}
     * {@link JAXBElement }{@code <}{@link TrafficAreaType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeCoordinateSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgeType }{@code >}
     * {@link JAXBElement }{@code <}{@link OperationParameterType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link EllipsoidalCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link FaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.GroundSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractFeatureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.RoofSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link UnitDefinitionType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.WallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.AbstractBoundarySurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgeRoomType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.WindowType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeometricComplexType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractBridgeType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractWaterObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.DoorType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompoundCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeClockType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.DoorType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeInstantType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.RoofSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeSliceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TopoSolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeneralTransformationType }{@code >}
     * {@link JAXBElement }{@code <}{@link EllipsoidType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeCalendarType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.OuterFloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link RingType }{@code >}
     * {@link JAXBElement }{@code <}{@link RoadType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.OuterCeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimePrimitiveType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.OuterCeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.ClosureSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link X3DMaterialType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterType }{@code >}
     * {@link JAXBElement }{@code <}{@link NodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link WaterSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeOrdinalReferenceSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.WallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link SurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TunnelInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link WaterClosureSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AppearanceType }{@code >}
     * {@link JAXBElement }{@code <}{@link CartesianCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link HollowSpaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TemporalCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link TexCoordGenType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.WindowType }{@code >}
     * {@link JAXBElement }{@code <}{@link OrientableCurveType }{@code >}
     * {@link JAXBElement }{@code <}{@link TriangulatedSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiSurfaceCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeometryStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link OperationParameterGroupType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractBuildingType }{@code >}
     * {@link JAXBElement }{@code <}{@link ObservationType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgeFurnitureType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTransportationObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link TINReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.GroundSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link BuildingFurnitureType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     * {@link JAXBElement }{@code <}{@link ConversionType }{@code >}
     * {@link JAXBElement }{@code <}{@link EngineeringDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCoordinateSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractContinuousCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTunnelType }{@code >}
     * {@link JAXBElement }{@code <}{@link SolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link PolarCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractWaterBoundarySurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.AbstractBoundarySurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.CeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeocentricCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link TunnelType }{@code >}
     * {@link JAXBElement }{@code <}{@link RoomType }{@code >}
     * {@link JAXBElement }{@code <}{@link LengthType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeGeometricPrimitiveType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractSurfaceDataType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractAppearanceType }{@code >}
     * {@link JAXBElement }{@code <}{@link GridCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractVegetationObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link DerivedUnitType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgeConstructionElementType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.CeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiSolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCityObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractReliefComponentType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeCalendarEraType }{@code >}
     * {@link JAXBElement }{@code <}{@link StyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link DirectedObservationType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.InteriorWallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiPointType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.AbstractOpeningType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeCurveType }{@code >}
     * {@link JAXBElement }{@code <}{@link DirectedObservationAtDistanceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TemporalDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link GraphStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link BreaklineReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeometricAggregateType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.ClosureSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TexCoordListType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeodeticDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.RoofSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiCurveType }{@code >}
     * {@link JAXBElement }{@code <}{@link TransportationComplexType }{@code >}
     * {@link JAXBElement }{@code <}{@link SimpleTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.GroundSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeNodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link WaterGroundSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link ImplicitGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link BagType }{@code >}
     * {@link JAXBElement }{@code <}{@link ParameterizedTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiPointCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link IntTunnelInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link ProjectedCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link CoordinateSystemAxisType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.FloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.OuterFloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.DoorType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge.v_2_0.ClosureSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TrackType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link ImageCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link SolitaryVegetationObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link LabelStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link LinearCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link FeatureStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeTopologyPrimitiveType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeneralDerivedCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link TopologyStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractSiteType }{@code >}
     * {@link JAXBElement }{@code <}{@link PrimeMeridianType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building.v_2_0.FloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeometricPrimitiveType }{@code >}
     * {@link JAXBElement }{@code <}{@link LinearRingType }{@code >}
     * {@link JAXBElement }{@code <}{@link BaseUnitType }{@code >}
     * {@link JAXBElement }{@code <}{@link DefinitionType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractDiscreteCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractFeatureCollectionType }{@code >}
     * {@link JAXBElement }{@code <}{@link GridType }{@code >}
     * {@link JAXBElement }{@code <}{@link IntBuildingInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeEdgeType }{@code >}
     * {@link JAXBElement }{@code <}{@link LineStringType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel.v_2_0.InteriorWallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link ObliqueCartesianCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link BuildingInstallationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getObject() {
        if (object == null) {
            object = new ArrayList<JAXBElement<?>>();
        }
        return this.object;
    }

    public boolean isSetObject() {
        return ((this.object!= null)&&(!this.object.isEmpty()));
    }

    public void unsetObject() {
        this.object = null;
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            List<JAXBElement<?>> theObject;
            theObject = (this.isSetObject()?this.getObject():null);
            strategy.appendField(locator, this, "object", buffer, theObject);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ArrayAssociationType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ArrayAssociationType that = ((ArrayAssociationType) object);
        {
            List<JAXBElement<?>> lhsObject;
            lhsObject = (this.isSetObject()?this.getObject():null);
            List<JAXBElement<?>> rhsObject;
            rhsObject = (that.isSetObject()?that.getObject():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "object", lhsObject), LocatorUtils.property(thatLocator, "object", rhsObject), lhsObject, rhsObject)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            List<JAXBElement<?>> theObject;
            theObject = (this.isSetObject()?this.getObject():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "object", theObject), currentHashCode, theObject);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        if (draftCopy instanceof ArrayAssociationType) {
            final ArrayAssociationType copy = ((ArrayAssociationType) draftCopy);
            if (this.isSetObject()) {
                List<JAXBElement<?>> sourceObject;
                sourceObject = (this.isSetObject()?this.getObject():null);
                @SuppressWarnings("unchecked")
                List<JAXBElement<?>> copyObject = ((List<JAXBElement<?>> ) strategy.copy(LocatorUtils.property(locator, "object", sourceObject), sourceObject));
                copy.unsetObject();
                if (copyObject!= null) {
                    List<JAXBElement<?>> uniqueObjectl = copy.getObject();
                    uniqueObjectl.addAll(copyObject);
                }
            } else {
                copy.unsetObject();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new ArrayAssociationType();
    }

}