//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.gml.v_3_1_1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 * The function or rule which defines the map from members of the domainSet to the range.  
 *       More functions will be added to this list
 * 
 * <p>Java class for CoverageFunctionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CoverageFunctionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}MappingRule"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}GridFunction"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoverageFunctionType", propOrder = {
    "mappingRule",
    "gridFunction"
})
public class CoverageFunctionType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "MappingRule")
    protected StringOrRefType mappingRule;
    @XmlElementRef(name = "GridFunction", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends GridFunctionType> gridFunction;

    /**
     * Gets the value of the mappingRule property.
     * 
     * @return
     *     possible object is
     *     {@link StringOrRefType }
     *     
     */
    public StringOrRefType getMappingRule() {
        return mappingRule;
    }

    /**
     * Sets the value of the mappingRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringOrRefType }
     *     
     */
    public void setMappingRule(StringOrRefType value) {
        this.mappingRule = value;
    }

    public boolean isSetMappingRule() {
        return (this.mappingRule!= null);
    }

    /**
     * Gets the value of the gridFunction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GridFunctionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IndexMapType }{@code >}
     *     
     */
    public JAXBElement<? extends GridFunctionType> getGridFunction() {
        return gridFunction;
    }

    /**
     * Sets the value of the gridFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GridFunctionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IndexMapType }{@code >}
     *     
     */
    public void setGridFunction(JAXBElement<? extends GridFunctionType> value) {
        this.gridFunction = value;
    }

    public boolean isSetGridFunction() {
        return (this.gridFunction!= null);
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
            StringOrRefType theMappingRule;
            theMappingRule = this.getMappingRule();
            strategy.appendField(locator, this, "mappingRule", buffer, theMappingRule);
        }
        {
            JAXBElement<? extends GridFunctionType> theGridFunction;
            theGridFunction = this.getGridFunction();
            strategy.appendField(locator, this, "gridFunction", buffer, theGridFunction);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CoverageFunctionType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CoverageFunctionType that = ((CoverageFunctionType) object);
        {
            StringOrRefType lhsMappingRule;
            lhsMappingRule = this.getMappingRule();
            StringOrRefType rhsMappingRule;
            rhsMappingRule = that.getMappingRule();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "mappingRule", lhsMappingRule), LocatorUtils.property(thatLocator, "mappingRule", rhsMappingRule), lhsMappingRule, rhsMappingRule)) {
                return false;
            }
        }
        {
            JAXBElement<? extends GridFunctionType> lhsGridFunction;
            lhsGridFunction = this.getGridFunction();
            JAXBElement<? extends GridFunctionType> rhsGridFunction;
            rhsGridFunction = that.getGridFunction();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "gridFunction", lhsGridFunction), LocatorUtils.property(thatLocator, "gridFunction", rhsGridFunction), lhsGridFunction, rhsGridFunction)) {
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
            StringOrRefType theMappingRule;
            theMappingRule = this.getMappingRule();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "mappingRule", theMappingRule), currentHashCode, theMappingRule);
        }
        {
            JAXBElement<? extends GridFunctionType> theGridFunction;
            theGridFunction = this.getGridFunction();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "gridFunction", theGridFunction), currentHashCode, theGridFunction);
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
        if (draftCopy instanceof CoverageFunctionType) {
            final CoverageFunctionType copy = ((CoverageFunctionType) draftCopy);
            if (this.isSetMappingRule()) {
                StringOrRefType sourceMappingRule;
                sourceMappingRule = this.getMappingRule();
                StringOrRefType copyMappingRule = ((StringOrRefType) strategy.copy(LocatorUtils.property(locator, "mappingRule", sourceMappingRule), sourceMappingRule));
                copy.setMappingRule(copyMappingRule);
            } else {
                copy.mappingRule = null;
            }
            if (this.isSetGridFunction()) {
                JAXBElement<? extends GridFunctionType> sourceGridFunction;
                sourceGridFunction = this.getGridFunction();
                @SuppressWarnings("unchecked")
                JAXBElement<? extends GridFunctionType> copyGridFunction = ((JAXBElement<? extends GridFunctionType> ) strategy.copy(LocatorUtils.property(locator, "gridFunction", sourceGridFunction), sourceGridFunction));
                copy.setGridFunction(copyGridFunction);
            } else {
                copy.gridFunction = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new CoverageFunctionType();
    }

}
