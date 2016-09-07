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
 * <p>Java class for BridgeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BridgeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/bridge/2.0}AbstractBridgeType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/bridge/2.0}_GenericApplicationPropertyOfBridge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BridgeType", propOrder = {
    "genericApplicationPropertyOfBridge"
})
public class BridgeType
    extends AbstractBridgeType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "_GenericApplicationPropertyOfBridge")
    protected List<Object> genericApplicationPropertyOfBridge;

    /**
     * Gets the value of the genericApplicationPropertyOfBridge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfBridge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfBridge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfBridge() {
        if (genericApplicationPropertyOfBridge == null) {
            genericApplicationPropertyOfBridge = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfBridge;
    }

    public boolean isSetGenericApplicationPropertyOfBridge() {
        return ((this.genericApplicationPropertyOfBridge!= null)&&(!this.genericApplicationPropertyOfBridge.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfBridge() {
        this.genericApplicationPropertyOfBridge = null;
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
            List<Object> theGenericApplicationPropertyOfBridge;
            theGenericApplicationPropertyOfBridge = (this.isSetGenericApplicationPropertyOfBridge()?this.getGenericApplicationPropertyOfBridge():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfBridge", buffer, theGenericApplicationPropertyOfBridge);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof BridgeType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final BridgeType that = ((BridgeType) object);
        {
            List<Object> lhsGenericApplicationPropertyOfBridge;
            lhsGenericApplicationPropertyOfBridge = (this.isSetGenericApplicationPropertyOfBridge()?this.getGenericApplicationPropertyOfBridge():null);
            List<Object> rhsGenericApplicationPropertyOfBridge;
            rhsGenericApplicationPropertyOfBridge = (that.isSetGenericApplicationPropertyOfBridge()?that.getGenericApplicationPropertyOfBridge():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfBridge", lhsGenericApplicationPropertyOfBridge), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfBridge", rhsGenericApplicationPropertyOfBridge), lhsGenericApplicationPropertyOfBridge, rhsGenericApplicationPropertyOfBridge)) {
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
            List<Object> theGenericApplicationPropertyOfBridge;
            theGenericApplicationPropertyOfBridge = (this.isSetGenericApplicationPropertyOfBridge()?this.getGenericApplicationPropertyOfBridge():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfBridge", theGenericApplicationPropertyOfBridge), currentHashCode, theGenericApplicationPropertyOfBridge);
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
        if (draftCopy instanceof BridgeType) {
            final BridgeType copy = ((BridgeType) draftCopy);
            if (this.isSetGenericApplicationPropertyOfBridge()) {
                List<Object> sourceGenericApplicationPropertyOfBridge;
                sourceGenericApplicationPropertyOfBridge = (this.isSetGenericApplicationPropertyOfBridge()?this.getGenericApplicationPropertyOfBridge():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfBridge = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfBridge", sourceGenericApplicationPropertyOfBridge), sourceGenericApplicationPropertyOfBridge));
                copy.unsetGenericApplicationPropertyOfBridge();
                if (copyGenericApplicationPropertyOfBridge!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfBridgel = copy.getGenericApplicationPropertyOfBridge();
                    uniqueGenericApplicationPropertyOfBridgel.addAll(copyGenericApplicationPropertyOfBridge);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfBridge();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new BridgeType();
    }

}