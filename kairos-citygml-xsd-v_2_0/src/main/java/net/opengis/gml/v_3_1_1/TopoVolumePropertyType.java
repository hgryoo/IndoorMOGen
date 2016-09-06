//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.gml.v_3_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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
 * <p>Java class for TopoVolumePropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TopoVolumePropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}TopoVolume"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TopoVolumePropertyType", propOrder = {
    "topoVolume"
})
public class TopoVolumePropertyType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "TopoVolume", required = true)
    protected TopoVolumeType topoVolume;

    /**
     * Gets the value of the topoVolume property.
     * 
     * @return
     *     possible object is
     *     {@link TopoVolumeType }
     *     
     */
    public TopoVolumeType getTopoVolume() {
        return topoVolume;
    }

    /**
     * Sets the value of the topoVolume property.
     * 
     * @param value
     *     allowed object is
     *     {@link TopoVolumeType }
     *     
     */
    public void setTopoVolume(TopoVolumeType value) {
        this.topoVolume = value;
    }

    public boolean isSetTopoVolume() {
        return (this.topoVolume!= null);
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
            TopoVolumeType theTopoVolume;
            theTopoVolume = this.getTopoVolume();
            strategy.appendField(locator, this, "topoVolume", buffer, theTopoVolume);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TopoVolumePropertyType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final TopoVolumePropertyType that = ((TopoVolumePropertyType) object);
        {
            TopoVolumeType lhsTopoVolume;
            lhsTopoVolume = this.getTopoVolume();
            TopoVolumeType rhsTopoVolume;
            rhsTopoVolume = that.getTopoVolume();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "topoVolume", lhsTopoVolume), LocatorUtils.property(thatLocator, "topoVolume", rhsTopoVolume), lhsTopoVolume, rhsTopoVolume)) {
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
            TopoVolumeType theTopoVolume;
            theTopoVolume = this.getTopoVolume();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "topoVolume", theTopoVolume), currentHashCode, theTopoVolume);
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
        if (draftCopy instanceof TopoVolumePropertyType) {
            final TopoVolumePropertyType copy = ((TopoVolumePropertyType) draftCopy);
            if (this.isSetTopoVolume()) {
                TopoVolumeType sourceTopoVolume;
                sourceTopoVolume = this.getTopoVolume();
                TopoVolumeType copyTopoVolume = ((TopoVolumeType) strategy.copy(LocatorUtils.property(locator, "topoVolume", sourceTopoVolume), sourceTopoVolume));
                copy.setTopoVolume(copyTopoVolume);
            } else {
                copy.topoVolume = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new TopoVolumePropertyType();
    }

}
