//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.v_2_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml.bridge.v_2_0.AbstractBridgeType;
import net.opengis.citygml.building.v_2_0.AbstractBuildingType;
import net.opengis.citygml.tunnel.v_2_0.AbstractTunnelType;
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
 * Type describing the abstract superclass for buildings, facilities, etc. Future extensions of CityGML like
 * 				bridges and tunnels would be modelled as subclasses of _Site. As subclass of _CityObject, a _Site inherits all attributes
 * 				and relations, in particular an id, names, external references, and generalization relations. 
 * 
 * <p>Java class for AbstractSiteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractSiteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/2.0}_GenericApplicationPropertyOfSite" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractSiteType", propOrder = {
    "genericApplicationPropertyOfSite"
})
@XmlSeeAlso({
    AbstractBridgeType.class,
    AbstractBuildingType.class,
    AbstractTunnelType.class
})
public abstract class AbstractSiteType
    extends AbstractCityObjectType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "_GenericApplicationPropertyOfSite")
    protected List<Object> genericApplicationPropertyOfSite;

    /**
     * Gets the value of the genericApplicationPropertyOfSite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfSite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfSite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfSite() {
        if (genericApplicationPropertyOfSite == null) {
            genericApplicationPropertyOfSite = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfSite;
    }

    public boolean isSetGenericApplicationPropertyOfSite() {
        return ((this.genericApplicationPropertyOfSite!= null)&&(!this.genericApplicationPropertyOfSite.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfSite() {
        this.genericApplicationPropertyOfSite = null;
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
            List<Object> theGenericApplicationPropertyOfSite;
            theGenericApplicationPropertyOfSite = (this.isSetGenericApplicationPropertyOfSite()?this.getGenericApplicationPropertyOfSite():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfSite", buffer, theGenericApplicationPropertyOfSite);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AbstractSiteType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final AbstractSiteType that = ((AbstractSiteType) object);
        {
            List<Object> lhsGenericApplicationPropertyOfSite;
            lhsGenericApplicationPropertyOfSite = (this.isSetGenericApplicationPropertyOfSite()?this.getGenericApplicationPropertyOfSite():null);
            List<Object> rhsGenericApplicationPropertyOfSite;
            rhsGenericApplicationPropertyOfSite = (that.isSetGenericApplicationPropertyOfSite()?that.getGenericApplicationPropertyOfSite():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfSite", lhsGenericApplicationPropertyOfSite), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfSite", rhsGenericApplicationPropertyOfSite), lhsGenericApplicationPropertyOfSite, rhsGenericApplicationPropertyOfSite)) {
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
            List<Object> theGenericApplicationPropertyOfSite;
            theGenericApplicationPropertyOfSite = (this.isSetGenericApplicationPropertyOfSite()?this.getGenericApplicationPropertyOfSite():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfSite", theGenericApplicationPropertyOfSite), currentHashCode, theGenericApplicationPropertyOfSite);
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
        if (target instanceof AbstractSiteType) {
            final AbstractSiteType copy = ((AbstractSiteType) target);
            if (this.isSetGenericApplicationPropertyOfSite()) {
                List<Object> sourceGenericApplicationPropertyOfSite;
                sourceGenericApplicationPropertyOfSite = (this.isSetGenericApplicationPropertyOfSite()?this.getGenericApplicationPropertyOfSite():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfSite = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfSite", sourceGenericApplicationPropertyOfSite), sourceGenericApplicationPropertyOfSite));
                copy.unsetGenericApplicationPropertyOfSite();
                if (copyGenericApplicationPropertyOfSite!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfSitel = copy.getGenericApplicationPropertyOfSite();
                    uniqueGenericApplicationPropertyOfSitel.addAll(copyGenericApplicationPropertyOfSite);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfSite();
            }
        }
        return target;
    }

}
