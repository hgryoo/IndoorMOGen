//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.transportation.v_2_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.v_3_1_1.CodeType;
import net.opengis.gml.v_3_1_1.GeometricComplexPropertyType;
import net.opengis.gml.v_3_1_1.MultiSurfacePropertyType;
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
 * Type describing transportation complexes, which are aggregated features, e.g. roads, which consist of
 * 				parts (traffic areas, e.g. pedestrian path, and auxiliary traffic areas). As subclass of _CityObject, a
 * 				TransportationComplex inherits all attributes and relations, in particular an id, names, external references, and
 * 				generalization relations. 
 * 
 * <p>Java class for TransportationComplexType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransportationComplexType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/transportation/2.0}AbstractTransportationObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="trafficArea" type="{http://www.opengis.net/citygml/transportation/2.0}TrafficAreaPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="auxiliaryTrafficArea" type="{http://www.opengis.net/citygml/transportation/2.0}AuxiliaryTrafficAreaPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod0Network" type="{http://www.opengis.net/gml}GeometricComplexPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod1MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/transportation/2.0}_GenericApplicationPropertyOfTransportationComplex" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportationComplexType", propOrder = {
    "clazz",
    "function",
    "usage",
    "trafficArea",
    "auxiliaryTrafficArea",
    "lod0Network",
    "lod1MultiSurface",
    "lod2MultiSurface",
    "lod3MultiSurface",
    "lod4MultiSurface",
    "genericApplicationPropertyOfTransportationComplex"
})
@XmlSeeAlso({
    TrackType.class,
    RoadType.class,
    RailwayType.class,
    SquareType.class
})
public class TransportationComplexType
    extends AbstractTransportationObjectType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "class")
    protected CodeType clazz;
    protected List<CodeType> function;
    protected List<CodeType> usage;
    protected List<TrafficAreaPropertyType> trafficArea;
    protected List<AuxiliaryTrafficAreaPropertyType> auxiliaryTrafficArea;
    protected List<GeometricComplexPropertyType> lod0Network;
    protected MultiSurfacePropertyType lod1MultiSurface;
    protected MultiSurfacePropertyType lod2MultiSurface;
    protected MultiSurfacePropertyType lod3MultiSurface;
    protected MultiSurfacePropertyType lod4MultiSurface;
    @XmlElement(name = "_GenericApplicationPropertyOfTransportationComplex")
    protected List<Object> genericApplicationPropertyOfTransportationComplex;

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
     * Gets the value of the trafficArea property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trafficArea property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrafficArea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrafficAreaPropertyType }
     * 
     * 
     */
    public List<TrafficAreaPropertyType> getTrafficArea() {
        if (trafficArea == null) {
            trafficArea = new ArrayList<TrafficAreaPropertyType>();
        }
        return this.trafficArea;
    }

    public boolean isSetTrafficArea() {
        return ((this.trafficArea!= null)&&(!this.trafficArea.isEmpty()));
    }

    public void unsetTrafficArea() {
        this.trafficArea = null;
    }

    /**
     * Gets the value of the auxiliaryTrafficArea property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the auxiliaryTrafficArea property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuxiliaryTrafficArea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuxiliaryTrafficAreaPropertyType }
     * 
     * 
     */
    public List<AuxiliaryTrafficAreaPropertyType> getAuxiliaryTrafficArea() {
        if (auxiliaryTrafficArea == null) {
            auxiliaryTrafficArea = new ArrayList<AuxiliaryTrafficAreaPropertyType>();
        }
        return this.auxiliaryTrafficArea;
    }

    public boolean isSetAuxiliaryTrafficArea() {
        return ((this.auxiliaryTrafficArea!= null)&&(!this.auxiliaryTrafficArea.isEmpty()));
    }

    public void unsetAuxiliaryTrafficArea() {
        this.auxiliaryTrafficArea = null;
    }

    /**
     * Gets the value of the lod0Network property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lod0Network property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLod0Network().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeometricComplexPropertyType }
     * 
     * 
     */
    public List<GeometricComplexPropertyType> getLod0Network() {
        if (lod0Network == null) {
            lod0Network = new ArrayList<GeometricComplexPropertyType>();
        }
        return this.lod0Network;
    }

    public boolean isSetLod0Network() {
        return ((this.lod0Network!= null)&&(!this.lod0Network.isEmpty()));
    }

    public void unsetLod0Network() {
        this.lod0Network = null;
    }

    /**
     * Gets the value of the lod1MultiSurface property.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    /**
     * Sets the value of the lod1MultiSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod1MultiSurface(MultiSurfacePropertyType value) {
        this.lod1MultiSurface = value;
    }

    public boolean isSetLod1MultiSurface() {
        return (this.lod1MultiSurface!= null);
    }

    /**
     * Gets the value of the lod2MultiSurface property.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod2MultiSurface() {
        return lod2MultiSurface;
    }

    /**
     * Sets the value of the lod2MultiSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod2MultiSurface(MultiSurfacePropertyType value) {
        this.lod2MultiSurface = value;
    }

    public boolean isSetLod2MultiSurface() {
        return (this.lod2MultiSurface!= null);
    }

    /**
     * Gets the value of the lod3MultiSurface property.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod3MultiSurface() {
        return lod3MultiSurface;
    }

    /**
     * Sets the value of the lod3MultiSurface property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod3MultiSurface(MultiSurfacePropertyType value) {
        this.lod3MultiSurface = value;
    }

    public boolean isSetLod3MultiSurface() {
        return (this.lod3MultiSurface!= null);
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
     * Gets the value of the genericApplicationPropertyOfTransportationComplex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfTransportationComplex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfTransportationComplex().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfTransportationComplex() {
        if (genericApplicationPropertyOfTransportationComplex == null) {
            genericApplicationPropertyOfTransportationComplex = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfTransportationComplex;
    }

    public boolean isSetGenericApplicationPropertyOfTransportationComplex() {
        return ((this.genericApplicationPropertyOfTransportationComplex!= null)&&(!this.genericApplicationPropertyOfTransportationComplex.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfTransportationComplex() {
        this.genericApplicationPropertyOfTransportationComplex = null;
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
            List<TrafficAreaPropertyType> theTrafficArea;
            theTrafficArea = (this.isSetTrafficArea()?this.getTrafficArea():null);
            strategy.appendField(locator, this, "trafficArea", buffer, theTrafficArea);
        }
        {
            List<AuxiliaryTrafficAreaPropertyType> theAuxiliaryTrafficArea;
            theAuxiliaryTrafficArea = (this.isSetAuxiliaryTrafficArea()?this.getAuxiliaryTrafficArea():null);
            strategy.appendField(locator, this, "auxiliaryTrafficArea", buffer, theAuxiliaryTrafficArea);
        }
        {
            List<GeometricComplexPropertyType> theLod0Network;
            theLod0Network = (this.isSetLod0Network()?this.getLod0Network():null);
            strategy.appendField(locator, this, "lod0Network", buffer, theLod0Network);
        }
        {
            MultiSurfacePropertyType theLod1MultiSurface;
            theLod1MultiSurface = this.getLod1MultiSurface();
            strategy.appendField(locator, this, "lod1MultiSurface", buffer, theLod1MultiSurface);
        }
        {
            MultiSurfacePropertyType theLod2MultiSurface;
            theLod2MultiSurface = this.getLod2MultiSurface();
            strategy.appendField(locator, this, "lod2MultiSurface", buffer, theLod2MultiSurface);
        }
        {
            MultiSurfacePropertyType theLod3MultiSurface;
            theLod3MultiSurface = this.getLod3MultiSurface();
            strategy.appendField(locator, this, "lod3MultiSurface", buffer, theLod3MultiSurface);
        }
        {
            MultiSurfacePropertyType theLod4MultiSurface;
            theLod4MultiSurface = this.getLod4MultiSurface();
            strategy.appendField(locator, this, "lod4MultiSurface", buffer, theLod4MultiSurface);
        }
        {
            List<Object> theGenericApplicationPropertyOfTransportationComplex;
            theGenericApplicationPropertyOfTransportationComplex = (this.isSetGenericApplicationPropertyOfTransportationComplex()?this.getGenericApplicationPropertyOfTransportationComplex():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfTransportationComplex", buffer, theGenericApplicationPropertyOfTransportationComplex);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TransportationComplexType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final TransportationComplexType that = ((TransportationComplexType) object);
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
            List<TrafficAreaPropertyType> lhsTrafficArea;
            lhsTrafficArea = (this.isSetTrafficArea()?this.getTrafficArea():null);
            List<TrafficAreaPropertyType> rhsTrafficArea;
            rhsTrafficArea = (that.isSetTrafficArea()?that.getTrafficArea():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "trafficArea", lhsTrafficArea), LocatorUtils.property(thatLocator, "trafficArea", rhsTrafficArea), lhsTrafficArea, rhsTrafficArea)) {
                return false;
            }
        }
        {
            List<AuxiliaryTrafficAreaPropertyType> lhsAuxiliaryTrafficArea;
            lhsAuxiliaryTrafficArea = (this.isSetAuxiliaryTrafficArea()?this.getAuxiliaryTrafficArea():null);
            List<AuxiliaryTrafficAreaPropertyType> rhsAuxiliaryTrafficArea;
            rhsAuxiliaryTrafficArea = (that.isSetAuxiliaryTrafficArea()?that.getAuxiliaryTrafficArea():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "auxiliaryTrafficArea", lhsAuxiliaryTrafficArea), LocatorUtils.property(thatLocator, "auxiliaryTrafficArea", rhsAuxiliaryTrafficArea), lhsAuxiliaryTrafficArea, rhsAuxiliaryTrafficArea)) {
                return false;
            }
        }
        {
            List<GeometricComplexPropertyType> lhsLod0Network;
            lhsLod0Network = (this.isSetLod0Network()?this.getLod0Network():null);
            List<GeometricComplexPropertyType> rhsLod0Network;
            rhsLod0Network = (that.isSetLod0Network()?that.getLod0Network():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lod0Network", lhsLod0Network), LocatorUtils.property(thatLocator, "lod0Network", rhsLod0Network), lhsLod0Network, rhsLod0Network)) {
                return false;
            }
        }
        {
            MultiSurfacePropertyType lhsLod1MultiSurface;
            lhsLod1MultiSurface = this.getLod1MultiSurface();
            MultiSurfacePropertyType rhsLod1MultiSurface;
            rhsLod1MultiSurface = that.getLod1MultiSurface();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lod1MultiSurface", lhsLod1MultiSurface), LocatorUtils.property(thatLocator, "lod1MultiSurface", rhsLod1MultiSurface), lhsLod1MultiSurface, rhsLod1MultiSurface)) {
                return false;
            }
        }
        {
            MultiSurfacePropertyType lhsLod2MultiSurface;
            lhsLod2MultiSurface = this.getLod2MultiSurface();
            MultiSurfacePropertyType rhsLod2MultiSurface;
            rhsLod2MultiSurface = that.getLod2MultiSurface();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lod2MultiSurface", lhsLod2MultiSurface), LocatorUtils.property(thatLocator, "lod2MultiSurface", rhsLod2MultiSurface), lhsLod2MultiSurface, rhsLod2MultiSurface)) {
                return false;
            }
        }
        {
            MultiSurfacePropertyType lhsLod3MultiSurface;
            lhsLod3MultiSurface = this.getLod3MultiSurface();
            MultiSurfacePropertyType rhsLod3MultiSurface;
            rhsLod3MultiSurface = that.getLod3MultiSurface();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "lod3MultiSurface", lhsLod3MultiSurface), LocatorUtils.property(thatLocator, "lod3MultiSurface", rhsLod3MultiSurface), lhsLod3MultiSurface, rhsLod3MultiSurface)) {
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
            List<Object> lhsGenericApplicationPropertyOfTransportationComplex;
            lhsGenericApplicationPropertyOfTransportationComplex = (this.isSetGenericApplicationPropertyOfTransportationComplex()?this.getGenericApplicationPropertyOfTransportationComplex():null);
            List<Object> rhsGenericApplicationPropertyOfTransportationComplex;
            rhsGenericApplicationPropertyOfTransportationComplex = (that.isSetGenericApplicationPropertyOfTransportationComplex()?that.getGenericApplicationPropertyOfTransportationComplex():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfTransportationComplex", lhsGenericApplicationPropertyOfTransportationComplex), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfTransportationComplex", rhsGenericApplicationPropertyOfTransportationComplex), lhsGenericApplicationPropertyOfTransportationComplex, rhsGenericApplicationPropertyOfTransportationComplex)) {
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
            List<TrafficAreaPropertyType> theTrafficArea;
            theTrafficArea = (this.isSetTrafficArea()?this.getTrafficArea():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "trafficArea", theTrafficArea), currentHashCode, theTrafficArea);
        }
        {
            List<AuxiliaryTrafficAreaPropertyType> theAuxiliaryTrafficArea;
            theAuxiliaryTrafficArea = (this.isSetAuxiliaryTrafficArea()?this.getAuxiliaryTrafficArea():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "auxiliaryTrafficArea", theAuxiliaryTrafficArea), currentHashCode, theAuxiliaryTrafficArea);
        }
        {
            List<GeometricComplexPropertyType> theLod0Network;
            theLod0Network = (this.isSetLod0Network()?this.getLod0Network():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lod0Network", theLod0Network), currentHashCode, theLod0Network);
        }
        {
            MultiSurfacePropertyType theLod1MultiSurface;
            theLod1MultiSurface = this.getLod1MultiSurface();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lod1MultiSurface", theLod1MultiSurface), currentHashCode, theLod1MultiSurface);
        }
        {
            MultiSurfacePropertyType theLod2MultiSurface;
            theLod2MultiSurface = this.getLod2MultiSurface();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lod2MultiSurface", theLod2MultiSurface), currentHashCode, theLod2MultiSurface);
        }
        {
            MultiSurfacePropertyType theLod3MultiSurface;
            theLod3MultiSurface = this.getLod3MultiSurface();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lod3MultiSurface", theLod3MultiSurface), currentHashCode, theLod3MultiSurface);
        }
        {
            MultiSurfacePropertyType theLod4MultiSurface;
            theLod4MultiSurface = this.getLod4MultiSurface();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "lod4MultiSurface", theLod4MultiSurface), currentHashCode, theLod4MultiSurface);
        }
        {
            List<Object> theGenericApplicationPropertyOfTransportationComplex;
            theGenericApplicationPropertyOfTransportationComplex = (this.isSetGenericApplicationPropertyOfTransportationComplex()?this.getGenericApplicationPropertyOfTransportationComplex():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfTransportationComplex", theGenericApplicationPropertyOfTransportationComplex), currentHashCode, theGenericApplicationPropertyOfTransportationComplex);
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
        if (draftCopy instanceof TransportationComplexType) {
            final TransportationComplexType copy = ((TransportationComplexType) draftCopy);
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
            if (this.isSetTrafficArea()) {
                List<TrafficAreaPropertyType> sourceTrafficArea;
                sourceTrafficArea = (this.isSetTrafficArea()?this.getTrafficArea():null);
                @SuppressWarnings("unchecked")
                List<TrafficAreaPropertyType> copyTrafficArea = ((List<TrafficAreaPropertyType> ) strategy.copy(LocatorUtils.property(locator, "trafficArea", sourceTrafficArea), sourceTrafficArea));
                copy.unsetTrafficArea();
                if (copyTrafficArea!= null) {
                    List<TrafficAreaPropertyType> uniqueTrafficAreal = copy.getTrafficArea();
                    uniqueTrafficAreal.addAll(copyTrafficArea);
                }
            } else {
                copy.unsetTrafficArea();
            }
            if (this.isSetAuxiliaryTrafficArea()) {
                List<AuxiliaryTrafficAreaPropertyType> sourceAuxiliaryTrafficArea;
                sourceAuxiliaryTrafficArea = (this.isSetAuxiliaryTrafficArea()?this.getAuxiliaryTrafficArea():null);
                @SuppressWarnings("unchecked")
                List<AuxiliaryTrafficAreaPropertyType> copyAuxiliaryTrafficArea = ((List<AuxiliaryTrafficAreaPropertyType> ) strategy.copy(LocatorUtils.property(locator, "auxiliaryTrafficArea", sourceAuxiliaryTrafficArea), sourceAuxiliaryTrafficArea));
                copy.unsetAuxiliaryTrafficArea();
                if (copyAuxiliaryTrafficArea!= null) {
                    List<AuxiliaryTrafficAreaPropertyType> uniqueAuxiliaryTrafficAreal = copy.getAuxiliaryTrafficArea();
                    uniqueAuxiliaryTrafficAreal.addAll(copyAuxiliaryTrafficArea);
                }
            } else {
                copy.unsetAuxiliaryTrafficArea();
            }
            if (this.isSetLod0Network()) {
                List<GeometricComplexPropertyType> sourceLod0Network;
                sourceLod0Network = (this.isSetLod0Network()?this.getLod0Network():null);
                @SuppressWarnings("unchecked")
                List<GeometricComplexPropertyType> copyLod0Network = ((List<GeometricComplexPropertyType> ) strategy.copy(LocatorUtils.property(locator, "lod0Network", sourceLod0Network), sourceLod0Network));
                copy.unsetLod0Network();
                if (copyLod0Network!= null) {
                    List<GeometricComplexPropertyType> uniqueLod0Networkl = copy.getLod0Network();
                    uniqueLod0Networkl.addAll(copyLod0Network);
                }
            } else {
                copy.unsetLod0Network();
            }
            if (this.isSetLod1MultiSurface()) {
                MultiSurfacePropertyType sourceLod1MultiSurface;
                sourceLod1MultiSurface = this.getLod1MultiSurface();
                MultiSurfacePropertyType copyLod1MultiSurface = ((MultiSurfacePropertyType) strategy.copy(LocatorUtils.property(locator, "lod1MultiSurface", sourceLod1MultiSurface), sourceLod1MultiSurface));
                copy.setLod1MultiSurface(copyLod1MultiSurface);
            } else {
                copy.lod1MultiSurface = null;
            }
            if (this.isSetLod2MultiSurface()) {
                MultiSurfacePropertyType sourceLod2MultiSurface;
                sourceLod2MultiSurface = this.getLod2MultiSurface();
                MultiSurfacePropertyType copyLod2MultiSurface = ((MultiSurfacePropertyType) strategy.copy(LocatorUtils.property(locator, "lod2MultiSurface", sourceLod2MultiSurface), sourceLod2MultiSurface));
                copy.setLod2MultiSurface(copyLod2MultiSurface);
            } else {
                copy.lod2MultiSurface = null;
            }
            if (this.isSetLod3MultiSurface()) {
                MultiSurfacePropertyType sourceLod3MultiSurface;
                sourceLod3MultiSurface = this.getLod3MultiSurface();
                MultiSurfacePropertyType copyLod3MultiSurface = ((MultiSurfacePropertyType) strategy.copy(LocatorUtils.property(locator, "lod3MultiSurface", sourceLod3MultiSurface), sourceLod3MultiSurface));
                copy.setLod3MultiSurface(copyLod3MultiSurface);
            } else {
                copy.lod3MultiSurface = null;
            }
            if (this.isSetLod4MultiSurface()) {
                MultiSurfacePropertyType sourceLod4MultiSurface;
                sourceLod4MultiSurface = this.getLod4MultiSurface();
                MultiSurfacePropertyType copyLod4MultiSurface = ((MultiSurfacePropertyType) strategy.copy(LocatorUtils.property(locator, "lod4MultiSurface", sourceLod4MultiSurface), sourceLod4MultiSurface));
                copy.setLod4MultiSurface(copyLod4MultiSurface);
            } else {
                copy.lod4MultiSurface = null;
            }
            if (this.isSetGenericApplicationPropertyOfTransportationComplex()) {
                List<Object> sourceGenericApplicationPropertyOfTransportationComplex;
                sourceGenericApplicationPropertyOfTransportationComplex = (this.isSetGenericApplicationPropertyOfTransportationComplex()?this.getGenericApplicationPropertyOfTransportationComplex():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfTransportationComplex = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfTransportationComplex", sourceGenericApplicationPropertyOfTransportationComplex), sourceGenericApplicationPropertyOfTransportationComplex));
                copy.unsetGenericApplicationPropertyOfTransportationComplex();
                if (copyGenericApplicationPropertyOfTransportationComplex!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfTransportationComplexl = copy.getGenericApplicationPropertyOfTransportationComplex();
                    uniqueGenericApplicationPropertyOfTransportationComplexl.addAll(copyGenericApplicationPropertyOfTransportationComplex);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfTransportationComplex();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new TransportationComplexType();
    }

}