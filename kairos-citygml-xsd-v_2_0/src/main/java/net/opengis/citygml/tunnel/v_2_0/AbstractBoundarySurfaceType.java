//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.tunnel.v_2_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml.v_2_0.AbstractCityObjectType;
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
 * Abstract super class of the features RoofSurface, WallSurface, GroundSurface, ClosureSurface,
 * 				FloorSurface, OuterFloorSurface, CeilingSurface and OuterCeilingSurface
 * 
 * <p>Java class for AbstractBoundarySurfaceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractBoundarySurfaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lod2MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="opening" type="{http://www.opengis.net/citygml/tunnel/2.0}OpeningPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/tunnel/2.0}_GenericApplicationPropertyOfBoundarySurface" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractBoundarySurfaceType", propOrder = {
    "lod2MultiSurface",
    "lod3MultiSurface",
    "lod4MultiSurface",
    "opening",
    "genericApplicationPropertyOfBoundarySurface"
})
@XmlSeeAlso({
    RoofSurfaceType.class,
    WallSurfaceType.class,
    GroundSurfaceType.class,
    ClosureSurfaceType.class,
    FloorSurfaceType.class,
    OuterFloorSurfaceType.class,
    InteriorWallSurfaceType.class,
    CeilingSurfaceType.class,
    OuterCeilingSurfaceType.class
})
public abstract class AbstractBoundarySurfaceType
    extends AbstractCityObjectType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected MultiSurfacePropertyType lod2MultiSurface;
    protected MultiSurfacePropertyType lod3MultiSurface;
    protected MultiSurfacePropertyType lod4MultiSurface;
    protected List<OpeningPropertyType> opening;
    @XmlElement(name = "_GenericApplicationPropertyOfBoundarySurface")
    protected List<Object> genericApplicationPropertyOfBoundarySurface;

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
     * Gets the value of the opening property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opening property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpening().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpeningPropertyType }
     * 
     * 
     */
    public List<OpeningPropertyType> getOpening() {
        if (opening == null) {
            opening = new ArrayList<OpeningPropertyType>();
        }
        return this.opening;
    }

    public boolean isSetOpening() {
        return ((this.opening!= null)&&(!this.opening.isEmpty()));
    }

    public void unsetOpening() {
        this.opening = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfBoundarySurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfBoundarySurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfBoundarySurface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfBoundarySurface() {
        if (genericApplicationPropertyOfBoundarySurface == null) {
            genericApplicationPropertyOfBoundarySurface = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfBoundarySurface;
    }

    public boolean isSetGenericApplicationPropertyOfBoundarySurface() {
        return ((this.genericApplicationPropertyOfBoundarySurface!= null)&&(!this.genericApplicationPropertyOfBoundarySurface.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfBoundarySurface() {
        this.genericApplicationPropertyOfBoundarySurface = null;
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
            List<OpeningPropertyType> theOpening;
            theOpening = (this.isSetOpening()?this.getOpening():null);
            strategy.appendField(locator, this, "opening", buffer, theOpening);
        }
        {
            List<Object> theGenericApplicationPropertyOfBoundarySurface;
            theGenericApplicationPropertyOfBoundarySurface = (this.isSetGenericApplicationPropertyOfBoundarySurface()?this.getGenericApplicationPropertyOfBoundarySurface():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfBoundarySurface", buffer, theGenericApplicationPropertyOfBoundarySurface);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AbstractBoundarySurfaceType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final AbstractBoundarySurfaceType that = ((AbstractBoundarySurfaceType) object);
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
            List<OpeningPropertyType> lhsOpening;
            lhsOpening = (this.isSetOpening()?this.getOpening():null);
            List<OpeningPropertyType> rhsOpening;
            rhsOpening = (that.isSetOpening()?that.getOpening():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "opening", lhsOpening), LocatorUtils.property(thatLocator, "opening", rhsOpening), lhsOpening, rhsOpening)) {
                return false;
            }
        }
        {
            List<Object> lhsGenericApplicationPropertyOfBoundarySurface;
            lhsGenericApplicationPropertyOfBoundarySurface = (this.isSetGenericApplicationPropertyOfBoundarySurface()?this.getGenericApplicationPropertyOfBoundarySurface():null);
            List<Object> rhsGenericApplicationPropertyOfBoundarySurface;
            rhsGenericApplicationPropertyOfBoundarySurface = (that.isSetGenericApplicationPropertyOfBoundarySurface()?that.getGenericApplicationPropertyOfBoundarySurface():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfBoundarySurface", lhsGenericApplicationPropertyOfBoundarySurface), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfBoundarySurface", rhsGenericApplicationPropertyOfBoundarySurface), lhsGenericApplicationPropertyOfBoundarySurface, rhsGenericApplicationPropertyOfBoundarySurface)) {
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
            List<OpeningPropertyType> theOpening;
            theOpening = (this.isSetOpening()?this.getOpening():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "opening", theOpening), currentHashCode, theOpening);
        }
        {
            List<Object> theGenericApplicationPropertyOfBoundarySurface;
            theGenericApplicationPropertyOfBoundarySurface = (this.isSetGenericApplicationPropertyOfBoundarySurface()?this.getGenericApplicationPropertyOfBoundarySurface():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfBoundarySurface", theGenericApplicationPropertyOfBoundarySurface), currentHashCode, theGenericApplicationPropertyOfBoundarySurface);
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
        if (null == target) {
            throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");
        }
        super.copyTo(locator, target, strategy);
        if (target instanceof AbstractBoundarySurfaceType) {
            final AbstractBoundarySurfaceType copy = ((AbstractBoundarySurfaceType) target);
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
            if (this.isSetOpening()) {
                List<OpeningPropertyType> sourceOpening;
                sourceOpening = (this.isSetOpening()?this.getOpening():null);
                @SuppressWarnings("unchecked")
                List<OpeningPropertyType> copyOpening = ((List<OpeningPropertyType> ) strategy.copy(LocatorUtils.property(locator, "opening", sourceOpening), sourceOpening));
                copy.unsetOpening();
                if (copyOpening!= null) {
                    List<OpeningPropertyType> uniqueOpeningl = copy.getOpening();
                    uniqueOpeningl.addAll(copyOpening);
                }
            } else {
                copy.unsetOpening();
            }
            if (this.isSetGenericApplicationPropertyOfBoundarySurface()) {
                List<Object> sourceGenericApplicationPropertyOfBoundarySurface;
                sourceGenericApplicationPropertyOfBoundarySurface = (this.isSetGenericApplicationPropertyOfBoundarySurface()?this.getGenericApplicationPropertyOfBoundarySurface():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfBoundarySurface = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfBoundarySurface", sourceGenericApplicationPropertyOfBoundarySurface), sourceGenericApplicationPropertyOfBoundarySurface));
                copy.unsetGenericApplicationPropertyOfBoundarySurface();
                if (copyGenericApplicationPropertyOfBoundarySurface!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfBoundarySurfacel = copy.getGenericApplicationPropertyOfBoundarySurface();
                    uniqueGenericApplicationPropertyOfBoundarySurfacel.addAll(copyGenericApplicationPropertyOfBoundarySurface);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfBoundarySurface();
            }
        }
        return target;
    }

}
