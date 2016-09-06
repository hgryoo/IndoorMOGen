//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.waterbody.v_2_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml.v_2_0.AbstractCityObjectType;
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
 * Type describing the abstract superclass for water objects. As subclass of _CityObject, a _WaterObject
 * 				inherits all attributes and relations, in particular an id, names, external references, and generalization relations.
 * 			
 * 
 * <p>Java class for AbstractWaterObjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractWaterObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/waterbody/2.0}_GenericApplicationPropertyOfWaterObject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractWaterObjectType", propOrder = {
    "genericApplicationPropertyOfWaterObject"
})
@XmlSeeAlso({
    WaterBodyType.class
})
public abstract class AbstractWaterObjectType
    extends AbstractCityObjectType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "_GenericApplicationPropertyOfWaterObject")
    protected List<Object> genericApplicationPropertyOfWaterObject;

    /**
     * Gets the value of the genericApplicationPropertyOfWaterObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfWaterObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfWaterObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfWaterObject() {
        if (genericApplicationPropertyOfWaterObject == null) {
            genericApplicationPropertyOfWaterObject = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfWaterObject;
    }

    public boolean isSetGenericApplicationPropertyOfWaterObject() {
        return ((this.genericApplicationPropertyOfWaterObject!= null)&&(!this.genericApplicationPropertyOfWaterObject.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfWaterObject() {
        this.genericApplicationPropertyOfWaterObject = null;
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
            List<Object> theGenericApplicationPropertyOfWaterObject;
            theGenericApplicationPropertyOfWaterObject = (this.isSetGenericApplicationPropertyOfWaterObject()?this.getGenericApplicationPropertyOfWaterObject():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfWaterObject", buffer, theGenericApplicationPropertyOfWaterObject);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AbstractWaterObjectType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final AbstractWaterObjectType that = ((AbstractWaterObjectType) object);
        {
            List<Object> lhsGenericApplicationPropertyOfWaterObject;
            lhsGenericApplicationPropertyOfWaterObject = (this.isSetGenericApplicationPropertyOfWaterObject()?this.getGenericApplicationPropertyOfWaterObject():null);
            List<Object> rhsGenericApplicationPropertyOfWaterObject;
            rhsGenericApplicationPropertyOfWaterObject = (that.isSetGenericApplicationPropertyOfWaterObject()?that.getGenericApplicationPropertyOfWaterObject():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfWaterObject", lhsGenericApplicationPropertyOfWaterObject), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfWaterObject", rhsGenericApplicationPropertyOfWaterObject), lhsGenericApplicationPropertyOfWaterObject, rhsGenericApplicationPropertyOfWaterObject)) {
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
            List<Object> theGenericApplicationPropertyOfWaterObject;
            theGenericApplicationPropertyOfWaterObject = (this.isSetGenericApplicationPropertyOfWaterObject()?this.getGenericApplicationPropertyOfWaterObject():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfWaterObject", theGenericApplicationPropertyOfWaterObject), currentHashCode, theGenericApplicationPropertyOfWaterObject);
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
        if (target instanceof AbstractWaterObjectType) {
            final AbstractWaterObjectType copy = ((AbstractWaterObjectType) target);
            if (this.isSetGenericApplicationPropertyOfWaterObject()) {
                List<Object> sourceGenericApplicationPropertyOfWaterObject;
                sourceGenericApplicationPropertyOfWaterObject = (this.isSetGenericApplicationPropertyOfWaterObject()?this.getGenericApplicationPropertyOfWaterObject():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfWaterObject = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfWaterObject", sourceGenericApplicationPropertyOfWaterObject), sourceGenericApplicationPropertyOfWaterObject));
                copy.unsetGenericApplicationPropertyOfWaterObject();
                if (copyGenericApplicationPropertyOfWaterObject!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfWaterObjectl = copy.getGenericApplicationPropertyOfWaterObject();
                    uniqueGenericApplicationPropertyOfWaterObjectl.addAll(copyGenericApplicationPropertyOfWaterObject);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfWaterObject();
            }
        }
        return target;
    }

}
