//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package org.w3.smil.v_2_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
import org.w3.smil.v_2_0.language.AnimateMotionType;


/**
 * <p>Java class for animateMotionPrototype complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="animateMotionPrototype"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attGroup ref="{http://www.w3.org/2001/SMIL20/}animValuesAttrs"/&gt;
 *       &lt;attGroup ref="{http://www.w3.org/2001/SMIL20/}animAddAccumAttrs"/&gt;
 *       &lt;attribute name="origin" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "animateMotionPrototype")
@XmlSeeAlso({
    AnimateMotionType.class
})
public class AnimateMotionPrototype
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlAttribute(name = "origin")
    protected String origin;
    @XmlAttribute(name = "from")
    protected String from;
    @XmlAttribute(name = "by")
    protected String by;
    @XmlAttribute(name = "values")
    protected String values;
    @XmlAttribute(name = "to")
    protected String to;
    @XmlAttribute(name = "additive")
    protected String additive;
    @XmlAttribute(name = "accumulate")
    protected String accumulate;

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    public boolean isSetOrigin() {
        return (this.origin!= null);
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrom(String value) {
        this.from = value;
    }

    public boolean isSetFrom() {
        return (this.from!= null);
    }

    /**
     * Gets the value of the by property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBy() {
        return by;
    }

    /**
     * Sets the value of the by property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBy(String value) {
        this.by = value;
    }

    public boolean isSetBy() {
        return (this.by!= null);
    }

    /**
     * Gets the value of the values property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValues(String value) {
        this.values = value;
    }

    public boolean isSetValues() {
        return (this.values!= null);
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTo(String value) {
        this.to = value;
    }

    public boolean isSetTo() {
        return (this.to!= null);
    }

    /**
     * Gets the value of the additive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditive() {
        if (additive == null) {
            return "replace";
        } else {
            return additive;
        }
    }

    /**
     * Sets the value of the additive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditive(String value) {
        this.additive = value;
    }

    public boolean isSetAdditive() {
        return (this.additive!= null);
    }

    /**
     * Gets the value of the accumulate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccumulate() {
        if (accumulate == null) {
            return "none";
        } else {
            return accumulate;
        }
    }

    /**
     * Sets the value of the accumulate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccumulate(String value) {
        this.accumulate = value;
    }

    public boolean isSetAccumulate() {
        return (this.accumulate!= null);
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
            String theOrigin;
            theOrigin = this.getOrigin();
            strategy.appendField(locator, this, "origin", buffer, theOrigin);
        }
        {
            String theFrom;
            theFrom = this.getFrom();
            strategy.appendField(locator, this, "from", buffer, theFrom);
        }
        {
            String theBy;
            theBy = this.getBy();
            strategy.appendField(locator, this, "by", buffer, theBy);
        }
        {
            String theValues;
            theValues = this.getValues();
            strategy.appendField(locator, this, "values", buffer, theValues);
        }
        {
            String theTo;
            theTo = this.getTo();
            strategy.appendField(locator, this, "to", buffer, theTo);
        }
        {
            String theAdditive;
            theAdditive = this.getAdditive();
            strategy.appendField(locator, this, "additive", buffer, theAdditive);
        }
        {
            String theAccumulate;
            theAccumulate = this.getAccumulate();
            strategy.appendField(locator, this, "accumulate", buffer, theAccumulate);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AnimateMotionPrototype)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AnimateMotionPrototype that = ((AnimateMotionPrototype) object);
        {
            String lhsOrigin;
            lhsOrigin = this.getOrigin();
            String rhsOrigin;
            rhsOrigin = that.getOrigin();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "origin", lhsOrigin), LocatorUtils.property(thatLocator, "origin", rhsOrigin), lhsOrigin, rhsOrigin)) {
                return false;
            }
        }
        {
            String lhsFrom;
            lhsFrom = this.getFrom();
            String rhsFrom;
            rhsFrom = that.getFrom();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "from", lhsFrom), LocatorUtils.property(thatLocator, "from", rhsFrom), lhsFrom, rhsFrom)) {
                return false;
            }
        }
        {
            String lhsBy;
            lhsBy = this.getBy();
            String rhsBy;
            rhsBy = that.getBy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "by", lhsBy), LocatorUtils.property(thatLocator, "by", rhsBy), lhsBy, rhsBy)) {
                return false;
            }
        }
        {
            String lhsValues;
            lhsValues = this.getValues();
            String rhsValues;
            rhsValues = that.getValues();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "values", lhsValues), LocatorUtils.property(thatLocator, "values", rhsValues), lhsValues, rhsValues)) {
                return false;
            }
        }
        {
            String lhsTo;
            lhsTo = this.getTo();
            String rhsTo;
            rhsTo = that.getTo();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "to", lhsTo), LocatorUtils.property(thatLocator, "to", rhsTo), lhsTo, rhsTo)) {
                return false;
            }
        }
        {
            String lhsAdditive;
            lhsAdditive = this.getAdditive();
            String rhsAdditive;
            rhsAdditive = that.getAdditive();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "additive", lhsAdditive), LocatorUtils.property(thatLocator, "additive", rhsAdditive), lhsAdditive, rhsAdditive)) {
                return false;
            }
        }
        {
            String lhsAccumulate;
            lhsAccumulate = this.getAccumulate();
            String rhsAccumulate;
            rhsAccumulate = that.getAccumulate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accumulate", lhsAccumulate), LocatorUtils.property(thatLocator, "accumulate", rhsAccumulate), lhsAccumulate, rhsAccumulate)) {
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
            String theOrigin;
            theOrigin = this.getOrigin();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "origin", theOrigin), currentHashCode, theOrigin);
        }
        {
            String theFrom;
            theFrom = this.getFrom();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "from", theFrom), currentHashCode, theFrom);
        }
        {
            String theBy;
            theBy = this.getBy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "by", theBy), currentHashCode, theBy);
        }
        {
            String theValues;
            theValues = this.getValues();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "values", theValues), currentHashCode, theValues);
        }
        {
            String theTo;
            theTo = this.getTo();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "to", theTo), currentHashCode, theTo);
        }
        {
            String theAdditive;
            theAdditive = this.getAdditive();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "additive", theAdditive), currentHashCode, theAdditive);
        }
        {
            String theAccumulate;
            theAccumulate = this.getAccumulate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accumulate", theAccumulate), currentHashCode, theAccumulate);
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
        if (draftCopy instanceof AnimateMotionPrototype) {
            final AnimateMotionPrototype copy = ((AnimateMotionPrototype) draftCopy);
            if (this.isSetOrigin()) {
                String sourceOrigin;
                sourceOrigin = this.getOrigin();
                String copyOrigin = ((String) strategy.copy(LocatorUtils.property(locator, "origin", sourceOrigin), sourceOrigin));
                copy.setOrigin(copyOrigin);
            } else {
                copy.origin = null;
            }
            if (this.isSetFrom()) {
                String sourceFrom;
                sourceFrom = this.getFrom();
                String copyFrom = ((String) strategy.copy(LocatorUtils.property(locator, "from", sourceFrom), sourceFrom));
                copy.setFrom(copyFrom);
            } else {
                copy.from = null;
            }
            if (this.isSetBy()) {
                String sourceBy;
                sourceBy = this.getBy();
                String copyBy = ((String) strategy.copy(LocatorUtils.property(locator, "by", sourceBy), sourceBy));
                copy.setBy(copyBy);
            } else {
                copy.by = null;
            }
            if (this.isSetValues()) {
                String sourceValues;
                sourceValues = this.getValues();
                String copyValues = ((String) strategy.copy(LocatorUtils.property(locator, "values", sourceValues), sourceValues));
                copy.setValues(copyValues);
            } else {
                copy.values = null;
            }
            if (this.isSetTo()) {
                String sourceTo;
                sourceTo = this.getTo();
                String copyTo = ((String) strategy.copy(LocatorUtils.property(locator, "to", sourceTo), sourceTo));
                copy.setTo(copyTo);
            } else {
                copy.to = null;
            }
            if (this.isSetAdditive()) {
                String sourceAdditive;
                sourceAdditive = this.getAdditive();
                String copyAdditive = ((String) strategy.copy(LocatorUtils.property(locator, "additive", sourceAdditive), sourceAdditive));
                copy.setAdditive(copyAdditive);
            } else {
                copy.additive = null;
            }
            if (this.isSetAccumulate()) {
                String sourceAccumulate;
                sourceAccumulate = this.getAccumulate();
                String copyAccumulate = ((String) strategy.copy(LocatorUtils.property(locator, "accumulate", sourceAccumulate), sourceAccumulate));
                copy.setAccumulate(copyAccumulate);
            } else {
                copy.accumulate = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new AnimateMotionPrototype();
    }

}