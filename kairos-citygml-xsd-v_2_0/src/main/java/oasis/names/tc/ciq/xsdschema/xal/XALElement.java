//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package oasis.names.tc.ciq.xsdschema.xal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressDetails" maxOccurs="unbounded"/&gt;
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;anyAttribute namespace='##other'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "addressDetails",
    "any"
})
@XmlRootElement(name = "xAL")
public class XALElement
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "AddressDetails", required = true)
    protected List<AddressDetails> addressDetails;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "Version")
    @XmlSchemaType(name = "anySimpleType")
    protected String version;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the addressDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressDetails }
     * 
     * 
     */
    public List<AddressDetails> getAddressDetails() {
        if (addressDetails == null) {
            addressDetails = new ArrayList<AddressDetails>();
        }
        return this.addressDetails;
    }

    public boolean isSetAddressDetails() {
        return ((this.addressDetails!= null)&&(!this.addressDetails.isEmpty()));
    }

    public void unsetAddressDetails() {
        this.addressDetails = null;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    public boolean isSetAny() {
        return ((this.any!= null)&&(!this.any.isEmpty()));
    }

    public void unsetAny() {
        this.any = null;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version!= null);
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
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
            List<AddressDetails> theAddressDetails;
            theAddressDetails = (this.isSetAddressDetails()?this.getAddressDetails():null);
            strategy.appendField(locator, this, "addressDetails", buffer, theAddressDetails);
        }
        {
            List<Object> theAny;
            theAny = (this.isSetAny()?this.getAny():null);
            strategy.appendField(locator, this, "any", buffer, theAny);
        }
        {
            String theVersion;
            theVersion = this.getVersion();
            strategy.appendField(locator, this, "version", buffer, theVersion);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof XALElement)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final XALElement that = ((XALElement) object);
        {
            List<AddressDetails> lhsAddressDetails;
            lhsAddressDetails = (this.isSetAddressDetails()?this.getAddressDetails():null);
            List<AddressDetails> rhsAddressDetails;
            rhsAddressDetails = (that.isSetAddressDetails()?that.getAddressDetails():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "addressDetails", lhsAddressDetails), LocatorUtils.property(thatLocator, "addressDetails", rhsAddressDetails), lhsAddressDetails, rhsAddressDetails)) {
                return false;
            }
        }
        {
            List<Object> lhsAny;
            lhsAny = (this.isSetAny()?this.getAny():null);
            List<Object> rhsAny;
            rhsAny = (that.isSetAny()?that.getAny():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "any", lhsAny), LocatorUtils.property(thatLocator, "any", rhsAny), lhsAny, rhsAny)) {
                return false;
            }
        }
        {
            String lhsVersion;
            lhsVersion = this.getVersion();
            String rhsVersion;
            rhsVersion = that.getVersion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "version", lhsVersion), LocatorUtils.property(thatLocator, "version", rhsVersion), lhsVersion, rhsVersion)) {
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
            List<AddressDetails> theAddressDetails;
            theAddressDetails = (this.isSetAddressDetails()?this.getAddressDetails():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "addressDetails", theAddressDetails), currentHashCode, theAddressDetails);
        }
        {
            List<Object> theAny;
            theAny = (this.isSetAny()?this.getAny():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "any", theAny), currentHashCode, theAny);
        }
        {
            String theVersion;
            theVersion = this.getVersion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "version", theVersion), currentHashCode, theVersion);
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
        if (draftCopy instanceof XALElement) {
            final XALElement copy = ((XALElement) draftCopy);
            if (this.isSetAddressDetails()) {
                List<AddressDetails> sourceAddressDetails;
                sourceAddressDetails = (this.isSetAddressDetails()?this.getAddressDetails():null);
                @SuppressWarnings("unchecked")
                List<AddressDetails> copyAddressDetails = ((List<AddressDetails> ) strategy.copy(LocatorUtils.property(locator, "addressDetails", sourceAddressDetails), sourceAddressDetails));
                copy.unsetAddressDetails();
                if (copyAddressDetails!= null) {
                    List<AddressDetails> uniqueAddressDetailsl = copy.getAddressDetails();
                    uniqueAddressDetailsl.addAll(copyAddressDetails);
                }
            } else {
                copy.unsetAddressDetails();
            }
            if (this.isSetAny()) {
                List<Object> sourceAny;
                sourceAny = (this.isSetAny()?this.getAny():null);
                @SuppressWarnings("unchecked")
                List<Object> copyAny = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "any", sourceAny), sourceAny));
                copy.unsetAny();
                if (copyAny!= null) {
                    List<Object> uniqueAnyl = copy.getAny();
                    uniqueAnyl.addAll(copyAny);
                }
            } else {
                copy.unsetAny();
            }
            if (this.isSetVersion()) {
                String sourceVersion;
                sourceVersion = this.getVersion();
                String copyVersion = ((String) strategy.copy(LocatorUtils.property(locator, "version", sourceVersion), sourceVersion));
                copy.setVersion(copyVersion);
            } else {
                copy.version = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new XALElement();
    }

}