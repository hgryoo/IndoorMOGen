//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.bridge.v_2_0;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for BridgePartType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BridgePartType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/bridge/2.0}AbstractBridgeType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/bridge/2.0}_GenericApplicationPropertyOfBridgePart" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BridgePartType", propOrder = {
    "genericApplicationPropertyOfBridgePart"
})
public class BridgePartType
    extends AbstractBridgeType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "_GenericApplicationPropertyOfBridgePart")
    protected List<Object> genericApplicationPropertyOfBridgePart;

    /**
     * Gets the value of the genericApplicationPropertyOfBridgePart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfBridgePart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfBridgePart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfBridgePart() {
        if (genericApplicationPropertyOfBridgePart == null) {
            genericApplicationPropertyOfBridgePart = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfBridgePart;
    }

    public boolean isSetGenericApplicationPropertyOfBridgePart() {
        return ((this.genericApplicationPropertyOfBridgePart!= null)&&(!this.genericApplicationPropertyOfBridgePart.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfBridgePart() {
        this.genericApplicationPropertyOfBridgePart = null;
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
            List<Object> theGenericApplicationPropertyOfBridgePart;
            theGenericApplicationPropertyOfBridgePart = (this.isSetGenericApplicationPropertyOfBridgePart()?this.getGenericApplicationPropertyOfBridgePart():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfBridgePart", buffer, theGenericApplicationPropertyOfBridgePart);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BridgePartType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final BridgePartType that = ((BridgePartType) object);
        {
            List<Object> lhsGenericApplicationPropertyOfBridgePart;
            lhsGenericApplicationPropertyOfBridgePart = (this.isSetGenericApplicationPropertyOfBridgePart()?this.getGenericApplicationPropertyOfBridgePart():null);
            List<Object> rhsGenericApplicationPropertyOfBridgePart;
            rhsGenericApplicationPropertyOfBridgePart = (that.isSetGenericApplicationPropertyOfBridgePart()?that.getGenericApplicationPropertyOfBridgePart():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfBridgePart", lhsGenericApplicationPropertyOfBridgePart), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfBridgePart", rhsGenericApplicationPropertyOfBridgePart), lhsGenericApplicationPropertyOfBridgePart, rhsGenericApplicationPropertyOfBridgePart)) {
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
            List<Object> theGenericApplicationPropertyOfBridgePart;
            theGenericApplicationPropertyOfBridgePart = (this.isSetGenericApplicationPropertyOfBridgePart()?this.getGenericApplicationPropertyOfBridgePart():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfBridgePart", theGenericApplicationPropertyOfBridgePart), currentHashCode, theGenericApplicationPropertyOfBridgePart);
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
        if (draftCopy instanceof BridgePartType) {
            final BridgePartType copy = ((BridgePartType) draftCopy);
            if (this.isSetGenericApplicationPropertyOfBridgePart()) {
                List<Object> sourceGenericApplicationPropertyOfBridgePart;
                sourceGenericApplicationPropertyOfBridgePart = (this.isSetGenericApplicationPropertyOfBridgePart()?this.getGenericApplicationPropertyOfBridgePart():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfBridgePart = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfBridgePart", sourceGenericApplicationPropertyOfBridgePart), sourceGenericApplicationPropertyOfBridgePart));
                copy.unsetGenericApplicationPropertyOfBridgePart();
                if (copyGenericApplicationPropertyOfBridgePart!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfBridgePartl = copy.getGenericApplicationPropertyOfBridgePart();
                    uniqueGenericApplicationPropertyOfBridgePartl.addAll(copyGenericApplicationPropertyOfBridgePart);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfBridgePart();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new BridgePartType();
    }

}