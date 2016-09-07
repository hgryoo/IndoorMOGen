//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.vegetation.v_2_0;

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
 * Type describing the abstract superclass for vegetation objects. A subclass is either a
 * 				SolitaryVegetationObject or a PlantCover. 
 * 
 * <p>Java class for AbstractVegetationObjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractVegetationObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/vegetation/2.0}_GenericApplicationPropertyOfVegetationObject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractVegetationObjectType", propOrder = {
    "genericApplicationPropertyOfVegetationObject"
})
@XmlSeeAlso({
    PlantCoverType.class,
    SolitaryVegetationObjectType.class
})
public abstract class AbstractVegetationObjectType
    extends AbstractCityObjectType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "_GenericApplicationPropertyOfVegetationObject")
    protected List<Object> genericApplicationPropertyOfVegetationObject;

    /**
     * Gets the value of the genericApplicationPropertyOfVegetationObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfVegetationObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfVegetationObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfVegetationObject() {
        if (genericApplicationPropertyOfVegetationObject == null) {
            genericApplicationPropertyOfVegetationObject = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfVegetationObject;
    }

    public boolean isSetGenericApplicationPropertyOfVegetationObject() {
        return ((this.genericApplicationPropertyOfVegetationObject!= null)&&(!this.genericApplicationPropertyOfVegetationObject.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfVegetationObject() {
        this.genericApplicationPropertyOfVegetationObject = null;
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
            List<Object> theGenericApplicationPropertyOfVegetationObject;
            theGenericApplicationPropertyOfVegetationObject = (this.isSetGenericApplicationPropertyOfVegetationObject()?this.getGenericApplicationPropertyOfVegetationObject():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfVegetationObject", buffer, theGenericApplicationPropertyOfVegetationObject);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AbstractVegetationObjectType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final AbstractVegetationObjectType that = ((AbstractVegetationObjectType) object);
        {
            List<Object> lhsGenericApplicationPropertyOfVegetationObject;
            lhsGenericApplicationPropertyOfVegetationObject = (this.isSetGenericApplicationPropertyOfVegetationObject()?this.getGenericApplicationPropertyOfVegetationObject():null);
            List<Object> rhsGenericApplicationPropertyOfVegetationObject;
            rhsGenericApplicationPropertyOfVegetationObject = (that.isSetGenericApplicationPropertyOfVegetationObject()?that.getGenericApplicationPropertyOfVegetationObject():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfVegetationObject", lhsGenericApplicationPropertyOfVegetationObject), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfVegetationObject", rhsGenericApplicationPropertyOfVegetationObject), lhsGenericApplicationPropertyOfVegetationObject, rhsGenericApplicationPropertyOfVegetationObject)) {
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
            List<Object> theGenericApplicationPropertyOfVegetationObject;
            theGenericApplicationPropertyOfVegetationObject = (this.isSetGenericApplicationPropertyOfVegetationObject()?this.getGenericApplicationPropertyOfVegetationObject():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfVegetationObject", theGenericApplicationPropertyOfVegetationObject), currentHashCode, theGenericApplicationPropertyOfVegetationObject);
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
        if (target instanceof AbstractVegetationObjectType) {
            final AbstractVegetationObjectType copy = ((AbstractVegetationObjectType) target);
            if (this.isSetGenericApplicationPropertyOfVegetationObject()) {
                List<Object> sourceGenericApplicationPropertyOfVegetationObject;
                sourceGenericApplicationPropertyOfVegetationObject = (this.isSetGenericApplicationPropertyOfVegetationObject()?this.getGenericApplicationPropertyOfVegetationObject():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfVegetationObject = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfVegetationObject", sourceGenericApplicationPropertyOfVegetationObject), sourceGenericApplicationPropertyOfVegetationObject));
                copy.unsetGenericApplicationPropertyOfVegetationObject();
                if (copyGenericApplicationPropertyOfVegetationObject!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfVegetationObjectl = copy.getGenericApplicationPropertyOfVegetationObject();
                    uniqueGenericApplicationPropertyOfVegetationObjectl.addAll(copyGenericApplicationPropertyOfVegetationObject);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfVegetationObject();
            }
        }
        return target;
    }

}