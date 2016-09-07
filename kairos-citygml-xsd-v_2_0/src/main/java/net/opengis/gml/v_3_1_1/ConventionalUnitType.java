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
 * Definition of a unit of measure which is related to a preferred unit for this quantity type through a conversion formula.  A method for deriving this unit by algebraic combination of more primitive units, may also be provided.
 * 
 * <p>Java class for ConventionalUnitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConventionalUnitType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}UnitDefinitionType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.opengis.net/gml}conversionToPreferredUnit"/&gt;
 *           &lt;element ref="{http://www.opengis.net/gml}roughConversionToPreferredUnit"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}derivationUnitTerm" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConventionalUnitType", propOrder = {
    "conversionToPreferredUnit",
    "roughConversionToPreferredUnit",
    "derivationUnitTerm"
})
public class ConventionalUnitType
    extends UnitDefinitionType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected ConversionToPreferredUnitType conversionToPreferredUnit;
    protected ConversionToPreferredUnitType roughConversionToPreferredUnit;
    protected List<DerivationUnitTermType> derivationUnitTerm;

    /**
     * Gets the value of the conversionToPreferredUnit property.
     * 
     * @return
     *     possible object is
     *     {@link ConversionToPreferredUnitType }
     *     
     */
    public ConversionToPreferredUnitType getConversionToPreferredUnit() {
        return conversionToPreferredUnit;
    }

    /**
     * Sets the value of the conversionToPreferredUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversionToPreferredUnitType }
     *     
     */
    public void setConversionToPreferredUnit(ConversionToPreferredUnitType value) {
        this.conversionToPreferredUnit = value;
    }

    public boolean isSetConversionToPreferredUnit() {
        return (this.conversionToPreferredUnit!= null);
    }

    /**
     * Gets the value of the roughConversionToPreferredUnit property.
     * 
     * @return
     *     possible object is
     *     {@link ConversionToPreferredUnitType }
     *     
     */
    public ConversionToPreferredUnitType getRoughConversionToPreferredUnit() {
        return roughConversionToPreferredUnit;
    }

    /**
     * Sets the value of the roughConversionToPreferredUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConversionToPreferredUnitType }
     *     
     */
    public void setRoughConversionToPreferredUnit(ConversionToPreferredUnitType value) {
        this.roughConversionToPreferredUnit = value;
    }

    public boolean isSetRoughConversionToPreferredUnit() {
        return (this.roughConversionToPreferredUnit!= null);
    }

    /**
     * Gets the value of the derivationUnitTerm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the derivationUnitTerm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDerivationUnitTerm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DerivationUnitTermType }
     * 
     * 
     */
    public List<DerivationUnitTermType> getDerivationUnitTerm() {
        if (derivationUnitTerm == null) {
            derivationUnitTerm = new ArrayList<DerivationUnitTermType>();
        }
        return this.derivationUnitTerm;
    }

    public boolean isSetDerivationUnitTerm() {
        return ((this.derivationUnitTerm!= null)&&(!this.derivationUnitTerm.isEmpty()));
    }

    public void unsetDerivationUnitTerm() {
        this.derivationUnitTerm = null;
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
            ConversionToPreferredUnitType theConversionToPreferredUnit;
            theConversionToPreferredUnit = this.getConversionToPreferredUnit();
            strategy.appendField(locator, this, "conversionToPreferredUnit", buffer, theConversionToPreferredUnit);
        }
        {
            ConversionToPreferredUnitType theRoughConversionToPreferredUnit;
            theRoughConversionToPreferredUnit = this.getRoughConversionToPreferredUnit();
            strategy.appendField(locator, this, "roughConversionToPreferredUnit", buffer, theRoughConversionToPreferredUnit);
        }
        {
            List<DerivationUnitTermType> theDerivationUnitTerm;
            theDerivationUnitTerm = (this.isSetDerivationUnitTerm()?this.getDerivationUnitTerm():null);
            strategy.appendField(locator, this, "derivationUnitTerm", buffer, theDerivationUnitTerm);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ConventionalUnitType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ConventionalUnitType that = ((ConventionalUnitType) object);
        {
            ConversionToPreferredUnitType lhsConversionToPreferredUnit;
            lhsConversionToPreferredUnit = this.getConversionToPreferredUnit();
            ConversionToPreferredUnitType rhsConversionToPreferredUnit;
            rhsConversionToPreferredUnit = that.getConversionToPreferredUnit();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "conversionToPreferredUnit", lhsConversionToPreferredUnit), LocatorUtils.property(thatLocator, "conversionToPreferredUnit", rhsConversionToPreferredUnit), lhsConversionToPreferredUnit, rhsConversionToPreferredUnit)) {
                return false;
            }
        }
        {
            ConversionToPreferredUnitType lhsRoughConversionToPreferredUnit;
            lhsRoughConversionToPreferredUnit = this.getRoughConversionToPreferredUnit();
            ConversionToPreferredUnitType rhsRoughConversionToPreferredUnit;
            rhsRoughConversionToPreferredUnit = that.getRoughConversionToPreferredUnit();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "roughConversionToPreferredUnit", lhsRoughConversionToPreferredUnit), LocatorUtils.property(thatLocator, "roughConversionToPreferredUnit", rhsRoughConversionToPreferredUnit), lhsRoughConversionToPreferredUnit, rhsRoughConversionToPreferredUnit)) {
                return false;
            }
        }
        {
            List<DerivationUnitTermType> lhsDerivationUnitTerm;
            lhsDerivationUnitTerm = (this.isSetDerivationUnitTerm()?this.getDerivationUnitTerm():null);
            List<DerivationUnitTermType> rhsDerivationUnitTerm;
            rhsDerivationUnitTerm = (that.isSetDerivationUnitTerm()?that.getDerivationUnitTerm():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "derivationUnitTerm", lhsDerivationUnitTerm), LocatorUtils.property(thatLocator, "derivationUnitTerm", rhsDerivationUnitTerm), lhsDerivationUnitTerm, rhsDerivationUnitTerm)) {
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
            ConversionToPreferredUnitType theConversionToPreferredUnit;
            theConversionToPreferredUnit = this.getConversionToPreferredUnit();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "conversionToPreferredUnit", theConversionToPreferredUnit), currentHashCode, theConversionToPreferredUnit);
        }
        {
            ConversionToPreferredUnitType theRoughConversionToPreferredUnit;
            theRoughConversionToPreferredUnit = this.getRoughConversionToPreferredUnit();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "roughConversionToPreferredUnit", theRoughConversionToPreferredUnit), currentHashCode, theRoughConversionToPreferredUnit);
        }
        {
            List<DerivationUnitTermType> theDerivationUnitTerm;
            theDerivationUnitTerm = (this.isSetDerivationUnitTerm()?this.getDerivationUnitTerm():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "derivationUnitTerm", theDerivationUnitTerm), currentHashCode, theDerivationUnitTerm);
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
        if (draftCopy instanceof ConventionalUnitType) {
            final ConventionalUnitType copy = ((ConventionalUnitType) draftCopy);
            if (this.isSetConversionToPreferredUnit()) {
                ConversionToPreferredUnitType sourceConversionToPreferredUnit;
                sourceConversionToPreferredUnit = this.getConversionToPreferredUnit();
                ConversionToPreferredUnitType copyConversionToPreferredUnit = ((ConversionToPreferredUnitType) strategy.copy(LocatorUtils.property(locator, "conversionToPreferredUnit", sourceConversionToPreferredUnit), sourceConversionToPreferredUnit));
                copy.setConversionToPreferredUnit(copyConversionToPreferredUnit);
            } else {
                copy.conversionToPreferredUnit = null;
            }
            if (this.isSetRoughConversionToPreferredUnit()) {
                ConversionToPreferredUnitType sourceRoughConversionToPreferredUnit;
                sourceRoughConversionToPreferredUnit = this.getRoughConversionToPreferredUnit();
                ConversionToPreferredUnitType copyRoughConversionToPreferredUnit = ((ConversionToPreferredUnitType) strategy.copy(LocatorUtils.property(locator, "roughConversionToPreferredUnit", sourceRoughConversionToPreferredUnit), sourceRoughConversionToPreferredUnit));
                copy.setRoughConversionToPreferredUnit(copyRoughConversionToPreferredUnit);
            } else {
                copy.roughConversionToPreferredUnit = null;
            }
            if (this.isSetDerivationUnitTerm()) {
                List<DerivationUnitTermType> sourceDerivationUnitTerm;
                sourceDerivationUnitTerm = (this.isSetDerivationUnitTerm()?this.getDerivationUnitTerm():null);
                @SuppressWarnings("unchecked")
                List<DerivationUnitTermType> copyDerivationUnitTerm = ((List<DerivationUnitTermType> ) strategy.copy(LocatorUtils.property(locator, "derivationUnitTerm", sourceDerivationUnitTerm), sourceDerivationUnitTerm));
                copy.unsetDerivationUnitTerm();
                if (copyDerivationUnitTerm!= null) {
                    List<DerivationUnitTermType> uniqueDerivationUnitTerml = copy.getDerivationUnitTerm();
                    uniqueDerivationUnitTerml.addAll(copyDerivationUnitTerm);
                }
            } else {
                copy.unsetDerivationUnitTerm();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new ConventionalUnitType();
    }

}