//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.gml.v_3_1_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
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
 * Aggregate value built from other Values using the Composite pattern. It contains zero or an arbitrary number of valueComponent elements, and zero or one valueComponents elements.  It may be used for strongly coupled aggregates (vectors, tensors) or for arbitrary collections of values.
 * 
 * <p>Java class for CompositeValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompositeValueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGMLType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}valueComponent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}valueComponents" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompositeValueType", propOrder = {
    "valueComponent",
    "valueComponents"
})
@XmlSeeAlso({
    ValueArrayType.class
})
public class CompositeValueType
    extends AbstractGMLType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected List<ValuePropertyType> valueComponent;
    protected ValueArrayPropertyType valueComponents;

    /**
     * Gets the value of the valueComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValuePropertyType }
     * 
     * 
     */
    public List<ValuePropertyType> getValueComponent() {
        if (valueComponent == null) {
            valueComponent = new ArrayList<ValuePropertyType>();
        }
        return this.valueComponent;
    }

    public boolean isSetValueComponent() {
        return ((this.valueComponent!= null)&&(!this.valueComponent.isEmpty()));
    }

    public void unsetValueComponent() {
        this.valueComponent = null;
    }

    /**
     * Gets the value of the valueComponents property.
     * 
     * @return
     *     possible object is
     *     {@link ValueArrayPropertyType }
     *     
     */
    public ValueArrayPropertyType getValueComponents() {
        return valueComponents;
    }

    /**
     * Sets the value of the valueComponents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueArrayPropertyType }
     *     
     */
    public void setValueComponents(ValueArrayPropertyType value) {
        this.valueComponents = value;
    }

    public boolean isSetValueComponents() {
        return (this.valueComponents!= null);
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
            List<ValuePropertyType> theValueComponent;
            theValueComponent = (this.isSetValueComponent()?this.getValueComponent():null);
            strategy.appendField(locator, this, "valueComponent", buffer, theValueComponent);
        }
        {
            ValueArrayPropertyType theValueComponents;
            theValueComponents = this.getValueComponents();
            strategy.appendField(locator, this, "valueComponents", buffer, theValueComponents);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CompositeValueType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final CompositeValueType that = ((CompositeValueType) object);
        {
            List<ValuePropertyType> lhsValueComponent;
            lhsValueComponent = (this.isSetValueComponent()?this.getValueComponent():null);
            List<ValuePropertyType> rhsValueComponent;
            rhsValueComponent = (that.isSetValueComponent()?that.getValueComponent():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "valueComponent", lhsValueComponent), LocatorUtils.property(thatLocator, "valueComponent", rhsValueComponent), lhsValueComponent, rhsValueComponent)) {
                return false;
            }
        }
        {
            ValueArrayPropertyType lhsValueComponents;
            lhsValueComponents = this.getValueComponents();
            ValueArrayPropertyType rhsValueComponents;
            rhsValueComponents = that.getValueComponents();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "valueComponents", lhsValueComponents), LocatorUtils.property(thatLocator, "valueComponents", rhsValueComponents), lhsValueComponents, rhsValueComponents)) {
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
            List<ValuePropertyType> theValueComponent;
            theValueComponent = (this.isSetValueComponent()?this.getValueComponent():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valueComponent", theValueComponent), currentHashCode, theValueComponent);
        }
        {
            ValueArrayPropertyType theValueComponents;
            theValueComponents = this.getValueComponents();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valueComponents", theValueComponents), currentHashCode, theValueComponents);
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
        if (draftCopy instanceof CompositeValueType) {
            final CompositeValueType copy = ((CompositeValueType) draftCopy);
            if (this.isSetValueComponent()) {
                List<ValuePropertyType> sourceValueComponent;
                sourceValueComponent = (this.isSetValueComponent()?this.getValueComponent():null);
                @SuppressWarnings("unchecked")
                List<ValuePropertyType> copyValueComponent = ((List<ValuePropertyType> ) strategy.copy(LocatorUtils.property(locator, "valueComponent", sourceValueComponent), sourceValueComponent));
                copy.unsetValueComponent();
                if (copyValueComponent!= null) {
                    List<ValuePropertyType> uniqueValueComponentl = copy.getValueComponent();
                    uniqueValueComponentl.addAll(copyValueComponent);
                }
            } else {
                copy.unsetValueComponent();
            }
            if (this.isSetValueComponents()) {
                ValueArrayPropertyType sourceValueComponents;
                sourceValueComponents = this.getValueComponents();
                ValueArrayPropertyType copyValueComponents = ((ValueArrayPropertyType) strategy.copy(LocatorUtils.property(locator, "valueComponents", sourceValueComponents), sourceValueComponents));
                copy.setValueComponents(copyValueComponents);
            } else {
                copy.valueComponents = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new CompositeValueType();
    }

}