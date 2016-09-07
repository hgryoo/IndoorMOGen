//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.building.v_2_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml.v_2_0.AbstractCityObjectType;
import net.opengis.gml.v_3_1_1.CodeType;
import net.opengis.gml.v_3_1_1.MultiSurfacePropertyType;
import net.opengis.gml.v_3_1_1.SolidPropertyType;
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
 * A Room is a thematic object for modelling the closed parts inside a building. It has to be closed, if
 * 				necessary by using closure surfaces. The geometry may be either a solid, or a MultiSurface if the boundary is not
 * 				topologically clean. The room connectivity may be derived by detecting shared thematic openings or closure surfaces: two
 * 				rooms are connected if both use the same opening object or the same closure surface. The thematic surfaces bounding a room
 * 				are referenced by the boundedBy property. As subclass of _CityObject, a Room inherits all attributes and relations, in
 * 				particular an id, names, external references, and generalization relations. 
 * 
 * <p>Java class for RoomType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoomType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod4Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="boundedBy" type="{http://www.opengis.net/citygml/building/2.0}BoundarySurfacePropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="interiorFurniture" type="{http://www.opengis.net/citygml/building/2.0}InteriorFurniturePropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="roomInstallation" type="{http://www.opengis.net/citygml/building/2.0}IntBuildingInstallationPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/building/2.0}_GenericApplicationPropertyOfRoom" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomType", propOrder = {
    "clazz",
    "function",
    "usage",
    "lod4Solid",
    "lod4MultiSurface",
    "cityObjectBoundedBy",
    "interiorFurniture",
    "roomInstallation",
    "genericApplicationPropertyOfRoom"
})
public class RoomType
    extends AbstractCityObjectType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "class")
    protected CodeType clazz;
    protected List<CodeType> function;
    protected List<CodeType> usage;
    protected SolidPropertyType lod4Solid;
    protected MultiSurfacePropertyType lod4MultiSurface;
    @XmlElement(name = "boundedBy")
    protected List<BoundarySurfacePropertyType> cityObjectBoundedBy;
    protected List<InteriorFurniturePropertyType> interiorFurniture;
    protected List<IntBuildingInstallationPropertyType> roomInstallation;
    @XmlElement(name = "_GenericApplicationPropertyOfRoom")
    protected List<Object> genericApplicationPropertyOfRoom;

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setClazz(CodeType value) {
        this.clazz = value;
    }

    public boolean isSetClazz() {
        return (this.clazz!= null);
    }

    /**
     * Gets the value of the function property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the function property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getFunction() {
        if (function == null) {
            function = new ArrayList<CodeType>();
        }
        return this.function;
    }

    public boolean isSetFunction() {
        return ((this.function!= null)&&(!this.function.isEmpty()));
    }

    public void unsetFunction() {
        this.function = null;
    }

    /**
     * Gets the value of the usage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getUsage() {
        if (usage == null) {
            usage = new ArrayList<CodeType>();
        }
        return this.usage;
    }

    public boolean isSetUsage() {
        return ((this.usage!= null)&&(!this.usage.isEmpty()));
    }

    public void unsetUsage() {
        this.usage = null;
    }

    /**
     * Gets the value of the lod4Solid property.
     * 
     * @return
     *     possible object is
     *     {@link SolidPropertyType }
     *     
     */
    public SolidPropertyType getLod4Solid() {
        return lod4Solid;
    }

    /**
     * Sets the value of the lod4Solid property.
     * 
     * @param value
     *     allowed object is
     *     {@link SolidPropertyType }
     *     
     */
    public void setLod4Solid(SolidPropertyType value) {
        this.lod4Solid = value;
    }

    public boolean isSetLod4Solid() {
        return (this.lod4Solid!= null);
    }

    /**
     * Gets the value of the lod4MultiSurface property.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    /**
     * Sets the value of the lod4MultiSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod4MultiSurface(MultiSurfacePropertyType value) {
        this.lod4MultiSurface = value;
    }

    public boolean isSetLod4MultiSurface() {
        return (this.lod4MultiSurface!= null);
    }

    /**
     * Gets the value of the cityObjectBoundedBy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cityObjectBoundedBy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCityObjectBoundedBy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BoundarySurfacePropertyType }
     * 
     * 
     */
    public List<BoundarySurfacePropertyType> getCityObjectBoundedBy() {
        if (cityObjectBoundedBy == null) {
            cityObjectBoundedBy = new ArrayList<BoundarySurfacePropertyType>();
        }
        return this.cityObjectBoundedBy;
    }

    public boolean isSetCityObjectBoundedBy() {
        return ((this.cityObjectBoundedBy!= null)&&(!this.cityObjectBoundedBy.isEmpty()));
    }

    public void unsetCityObjectBoundedBy() {
        this.cityObjectBoundedBy = null;
    }

    /**
     * Gets the value of the interiorFurniture property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interiorFurniture property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteriorFurniture().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InteriorFurniturePropertyType }
     * 
     * 
     */
    public List<InteriorFurniturePropertyType> getInteriorFurniture() {
        if (interiorFurniture == null) {
            interiorFurniture = new ArrayList<InteriorFurniturePropertyType>();
        }
        return this.interiorFurniture;
    }

    public boolean isSetInteriorFurniture() {
        return ((this.interiorFurniture!= null)&&(!this.interiorFurniture.isEmpty()));
    }

    public void unsetInteriorFurniture() {
        this.interiorFurniture = null;
    }

    /**
     * Gets the value of the roomInstallation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomInstallation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomInstallation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntBuildingInstallationPropertyType }
     * 
     * 
     */
    public List<IntBuildingInstallationPropertyType> getRoomInstallation() {
        if (roomInstallation == null) {
            roomInstallation = new ArrayList<IntBuildingInstallationPropertyType>();
        }
        return this.roomInstallation;
    }

    public boolean isSetRoomInstallation() {
        return ((this.roomInstallation!= null)&&(!this.roomInstallation.isEmpty()));
    }

    public void unsetRoomInstallation() {
        this.roomInstallation = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfRoom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfRoom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfRoom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfRoom() {
        if (genericApplicationPropertyOfRoom == null) {
            genericApplicationPropertyOfRoom = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfRoom;
    }

    public boolean isSetGenericApplicationPropertyOfRoom() {
        return ((this.genericApplicationPropertyOfRoom!= null)&&(!this.genericApplicationPropertyOfRoom.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfRoom() {
        this.genericApplicationPropertyOfRoom = null;
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
        super.appendFields(locator, buffer, strategy);
        {
            CodeType theClazz;
            theClazz = this.getClazz();
            strategy.appendField(locator, this, "clazz", buffer, theClazz);
        }
        {
            List<CodeType> theFunction;
            theFunction = (this.isSetFunction()?this.getFunction():null);
            strategy.appendField(locator, this, "function", buffer, theFunction);
        }
        {
            List<CodeType> theUsage;
            theUsage = (this.isSetUsage()?this.getUsage():null);
            strategy.appendField(locator, this, "usage", buffer, theUsage);
        }
        {
            SolidPropertyType theLod4Solid;
            theLod4Solid = this.getLod4Solid();
            strategy.appendField(locator, this, "lod4Solid", buffer, theLod4Solid);
        }
        {
            MultiSurfacePropertyType theLod4MultiSurface;
            theLod4MultiSurface = this.getLod4MultiSurface();
            strategy.appendField(locator, this, "lod4MultiSurface", buffer, theLod4MultiSurface);
        }
        {
            List<BoundarySurfacePropertyType> theCityObjectBoundedBy;
            theCityObjectBoundedBy = (this.isSetCityObjectBoundedBy()?this.getCityObjectBoundedBy():null);
            strategy.appendField(locator, this, "cityObjectBoundedBy", buffer, theCityObjectBoundedBy);
        }
        {
            List<InteriorFurniturePropertyType> theInteriorFurniture;
            theInteriorFurniture = (this.isSetInteriorFurniture()?this.getInteriorFurniture():null);
            strategy.appendField(locator, this, "interiorFurniture", buffer, theInteriorFurniture);
        }
        {
            List<IntBuildingInstallationPropertyType> theRoomInstallation;
            theRoomInstallation = (this.isSetRoomInstallation()?this.getRoomInstallation():null);
            strategy.appendField(locator, this, "roomInstallation", buffer, theRoomInstallation);
        }
        {
            List<Object> theGenericApplicationPropertyOfRoom;
            theGenericApplicationPropertyOfRoom = (this.isSetGenericApplicationPropertyOfRoom()?this.getGenericApplicationPropertyOfRoom():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfRoom", buffer, theGenericApplicationPropertyOfRoom);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RoomType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final RoomType that = ((RoomType) object);
        {
            CodeType lhsClazz;
            lhsClazz = this.getClazz();
            CodeType rhsClazz;
            rhsClazz = that.getClazz();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "clazz", lhsClazz), LocatorUtils.property(thatLocator, "clazz", rhsClazz), lhsClazz, rhsClazz)) {
                return false;
            }
        }
        {
            List<CodeType> lhsFunction;
            lhsFunction = (this.isSetFunction()?this.getFunction():null);
            List<CodeType> rhsFunction;
            rhsFunction = (that.isSetFunction()?that.getFunction():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "function", lhsFunction), LocatorUtils.property(thatLocator, "function", rhsFunction), lhsFunction, rhsFunction)) {
                return false;
            }
        }
        {
            List<CodeType> lhsUsage;
            lhsUsage = (this.isSetUsage()?this.getUsage():null);
            List<CodeType> rhsUsage;
            rhsUsage = (that.isSetUsage()?that.getUsage():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "usage", lhsUsage), LocatorUtils.property(thatLocator, "usage", rhsUsage), lhsUsage, rhsUsage)) {
                return false;
            }
        }
        {
            SolidPropertyType lhsLod4Solid;
            lhsLod4Solid = this.getLod4Solid();
            SolidPropertyType rhsLod4Solid;
            rhsLod4Solid = that.getLod4Solid();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lod4Solid", lhsLod4Solid), LocatorUtils.property(thatLocator, "lod4Solid", rhsLod4Solid), lhsLod4Solid, rhsLod4Solid)) {
                return false;
            }
        }
        {
            MultiSurfacePropertyType lhsLod4MultiSurface;
            lhsLod4MultiSurface = this.getLod4MultiSurface();
            MultiSurfacePropertyType rhsLod4MultiSurface;
            rhsLod4MultiSurface = that.getLod4MultiSurface();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lod4MultiSurface", lhsLod4MultiSurface), LocatorUtils.property(thatLocator, "lod4MultiSurface", rhsLod4MultiSurface), lhsLod4MultiSurface, rhsLod4MultiSurface)) {
                return false;
            }
        }
        {
            List<BoundarySurfacePropertyType> lhsCityObjectBoundedBy;
            lhsCityObjectBoundedBy = (this.isSetCityObjectBoundedBy()?this.getCityObjectBoundedBy():null);
            List<BoundarySurfacePropertyType> rhsCityObjectBoundedBy;
            rhsCityObjectBoundedBy = (that.isSetCityObjectBoundedBy()?that.getCityObjectBoundedBy():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "cityObjectBoundedBy", lhsCityObjectBoundedBy), LocatorUtils.property(thatLocator, "cityObjectBoundedBy", rhsCityObjectBoundedBy), lhsCityObjectBoundedBy, rhsCityObjectBoundedBy)) {
                return false;
            }
        }
        {
            List<InteriorFurniturePropertyType> lhsInteriorFurniture;
            lhsInteriorFurniture = (this.isSetInteriorFurniture()?this.getInteriorFurniture():null);
            List<InteriorFurniturePropertyType> rhsInteriorFurniture;
            rhsInteriorFurniture = (that.isSetInteriorFurniture()?that.getInteriorFurniture():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "interiorFurniture", lhsInteriorFurniture), LocatorUtils.property(thatLocator, "interiorFurniture", rhsInteriorFurniture), lhsInteriorFurniture, rhsInteriorFurniture)) {
                return false;
            }
        }
        {
            List<IntBuildingInstallationPropertyType> lhsRoomInstallation;
            lhsRoomInstallation = (this.isSetRoomInstallation()?this.getRoomInstallation():null);
            List<IntBuildingInstallationPropertyType> rhsRoomInstallation;
            rhsRoomInstallation = (that.isSetRoomInstallation()?that.getRoomInstallation():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "roomInstallation", lhsRoomInstallation), LocatorUtils.property(thatLocator, "roomInstallation", rhsRoomInstallation), lhsRoomInstallation, rhsRoomInstallation)) {
                return false;
            }
        }
        {
            List<Object> lhsGenericApplicationPropertyOfRoom;
            lhsGenericApplicationPropertyOfRoom = (this.isSetGenericApplicationPropertyOfRoom()?this.getGenericApplicationPropertyOfRoom():null);
            List<Object> rhsGenericApplicationPropertyOfRoom;
            rhsGenericApplicationPropertyOfRoom = (that.isSetGenericApplicationPropertyOfRoom()?that.getGenericApplicationPropertyOfRoom():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfRoom", lhsGenericApplicationPropertyOfRoom), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfRoom", rhsGenericApplicationPropertyOfRoom), lhsGenericApplicationPropertyOfRoom, rhsGenericApplicationPropertyOfRoom)) {
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
        int currentHashCode = super.hashCode(locator, strategy);
        {
            CodeType theClazz;
            theClazz = this.getClazz();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "clazz", theClazz), currentHashCode, theClazz);
        }
        {
            List<CodeType> theFunction;
            theFunction = (this.isSetFunction()?this.getFunction():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "function", theFunction), currentHashCode, theFunction);
        }
        {
            List<CodeType> theUsage;
            theUsage = (this.isSetUsage()?this.getUsage():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "usage", theUsage), currentHashCode, theUsage);
        }
        {
            SolidPropertyType theLod4Solid;
            theLod4Solid = this.getLod4Solid();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lod4Solid", theLod4Solid), currentHashCode, theLod4Solid);
        }
        {
            MultiSurfacePropertyType theLod4MultiSurface;
            theLod4MultiSurface = this.getLod4MultiSurface();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lod4MultiSurface", theLod4MultiSurface), currentHashCode, theLod4MultiSurface);
        }
        {
            List<BoundarySurfacePropertyType> theCityObjectBoundedBy;
            theCityObjectBoundedBy = (this.isSetCityObjectBoundedBy()?this.getCityObjectBoundedBy():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "cityObjectBoundedBy", theCityObjectBoundedBy), currentHashCode, theCityObjectBoundedBy);
        }
        {
            List<InteriorFurniturePropertyType> theInteriorFurniture;
            theInteriorFurniture = (this.isSetInteriorFurniture()?this.getInteriorFurniture():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "interiorFurniture", theInteriorFurniture), currentHashCode, theInteriorFurniture);
        }
        {
            List<IntBuildingInstallationPropertyType> theRoomInstallation;
            theRoomInstallation = (this.isSetRoomInstallation()?this.getRoomInstallation():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "roomInstallation", theRoomInstallation), currentHashCode, theRoomInstallation);
        }
        {
            List<Object> theGenericApplicationPropertyOfRoom;
            theGenericApplicationPropertyOfRoom = (this.isSetGenericApplicationPropertyOfRoom()?this.getGenericApplicationPropertyOfRoom():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfRoom", theGenericApplicationPropertyOfRoom), currentHashCode, theGenericApplicationPropertyOfRoom);
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
        super.copyTo(locator, draftCopy, strategy);
        if (draftCopy instanceof RoomType) {
            final RoomType copy = ((RoomType) draftCopy);
            if (this.isSetClazz()) {
                CodeType sourceClazz;
                sourceClazz = this.getClazz();
                CodeType copyClazz = ((CodeType) strategy.copy(LocatorUtils.property(locator, "clazz", sourceClazz), sourceClazz));
                copy.setClazz(copyClazz);
            } else {
                copy.clazz = null;
            }
            if (this.isSetFunction()) {
                List<CodeType> sourceFunction;
                sourceFunction = (this.isSetFunction()?this.getFunction():null);
                @SuppressWarnings("unchecked")
                List<CodeType> copyFunction = ((List<CodeType> ) strategy.copy(LocatorUtils.property(locator, "function", sourceFunction), sourceFunction));
                copy.unsetFunction();
                if (copyFunction!= null) {
                    List<CodeType> uniqueFunctionl = copy.getFunction();
                    uniqueFunctionl.addAll(copyFunction);
                }
            } else {
                copy.unsetFunction();
            }
            if (this.isSetUsage()) {
                List<CodeType> sourceUsage;
                sourceUsage = (this.isSetUsage()?this.getUsage():null);
                @SuppressWarnings("unchecked")
                List<CodeType> copyUsage = ((List<CodeType> ) strategy.copy(LocatorUtils.property(locator, "usage", sourceUsage), sourceUsage));
                copy.unsetUsage();
                if (copyUsage!= null) {
                    List<CodeType> uniqueUsagel = copy.getUsage();
                    uniqueUsagel.addAll(copyUsage);
                }
            } else {
                copy.unsetUsage();
            }
            if (this.isSetLod4Solid()) {
                SolidPropertyType sourceLod4Solid;
                sourceLod4Solid = this.getLod4Solid();
                SolidPropertyType copyLod4Solid = ((SolidPropertyType) strategy.copy(LocatorUtils.property(locator, "lod4Solid", sourceLod4Solid), sourceLod4Solid));
                copy.setLod4Solid(copyLod4Solid);
            } else {
                copy.lod4Solid = null;
            }
            if (this.isSetLod4MultiSurface()) {
                MultiSurfacePropertyType sourceLod4MultiSurface;
                sourceLod4MultiSurface = this.getLod4MultiSurface();
                MultiSurfacePropertyType copyLod4MultiSurface = ((MultiSurfacePropertyType) strategy.copy(LocatorUtils.property(locator, "lod4MultiSurface", sourceLod4MultiSurface), sourceLod4MultiSurface));
                copy.setLod4MultiSurface(copyLod4MultiSurface);
            } else {
                copy.lod4MultiSurface = null;
            }
            if (this.isSetCityObjectBoundedBy()) {
                List<BoundarySurfacePropertyType> sourceCityObjectBoundedBy;
                sourceCityObjectBoundedBy = (this.isSetCityObjectBoundedBy()?this.getCityObjectBoundedBy():null);
                @SuppressWarnings("unchecked")
                List<BoundarySurfacePropertyType> copyCityObjectBoundedBy = ((List<BoundarySurfacePropertyType> ) strategy.copy(LocatorUtils.property(locator, "cityObjectBoundedBy", sourceCityObjectBoundedBy), sourceCityObjectBoundedBy));
                copy.unsetCityObjectBoundedBy();
                if (copyCityObjectBoundedBy!= null) {
                    List<BoundarySurfacePropertyType> uniqueCityObjectBoundedByl = copy.getCityObjectBoundedBy();
                    uniqueCityObjectBoundedByl.addAll(copyCityObjectBoundedBy);
                }
            } else {
                copy.unsetCityObjectBoundedBy();
            }
            if (this.isSetInteriorFurniture()) {
                List<InteriorFurniturePropertyType> sourceInteriorFurniture;
                sourceInteriorFurniture = (this.isSetInteriorFurniture()?this.getInteriorFurniture():null);
                @SuppressWarnings("unchecked")
                List<InteriorFurniturePropertyType> copyInteriorFurniture = ((List<InteriorFurniturePropertyType> ) strategy.copy(LocatorUtils.property(locator, "interiorFurniture", sourceInteriorFurniture), sourceInteriorFurniture));
                copy.unsetInteriorFurniture();
                if (copyInteriorFurniture!= null) {
                    List<InteriorFurniturePropertyType> uniqueInteriorFurniturel = copy.getInteriorFurniture();
                    uniqueInteriorFurniturel.addAll(copyInteriorFurniture);
                }
            } else {
                copy.unsetInteriorFurniture();
            }
            if (this.isSetRoomInstallation()) {
                List<IntBuildingInstallationPropertyType> sourceRoomInstallation;
                sourceRoomInstallation = (this.isSetRoomInstallation()?this.getRoomInstallation():null);
                @SuppressWarnings("unchecked")
                List<IntBuildingInstallationPropertyType> copyRoomInstallation = ((List<IntBuildingInstallationPropertyType> ) strategy.copy(LocatorUtils.property(locator, "roomInstallation", sourceRoomInstallation), sourceRoomInstallation));
                copy.unsetRoomInstallation();
                if (copyRoomInstallation!= null) {
                    List<IntBuildingInstallationPropertyType> uniqueRoomInstallationl = copy.getRoomInstallation();
                    uniqueRoomInstallationl.addAll(copyRoomInstallation);
                }
            } else {
                copy.unsetRoomInstallation();
            }
            if (this.isSetGenericApplicationPropertyOfRoom()) {
                List<Object> sourceGenericApplicationPropertyOfRoom;
                sourceGenericApplicationPropertyOfRoom = (this.isSetGenericApplicationPropertyOfRoom()?this.getGenericApplicationPropertyOfRoom():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfRoom = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfRoom", sourceGenericApplicationPropertyOfRoom), sourceGenericApplicationPropertyOfRoom));
                copy.unsetGenericApplicationPropertyOfRoom();
                if (copyGenericApplicationPropertyOfRoom!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfRooml = copy.getGenericApplicationPropertyOfRoom();
                    uniqueGenericApplicationPropertyOfRooml.addAll(copyGenericApplicationPropertyOfRoom);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfRoom();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new RoomType();
    }

}