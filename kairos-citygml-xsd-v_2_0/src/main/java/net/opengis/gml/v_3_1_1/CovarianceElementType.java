//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.gml.v_3_1_1;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 * An element of a covariance matrix.
 * 
 * <p>Java class for CovarianceElementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CovarianceElementType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}rowIndex"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}columnIndex"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}covariance"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CovarianceElementType", propOrder = {
    "rowIndex",
    "columnIndex",
    "covariance"
})
public class CovarianceElementType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger rowIndex;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger columnIndex;
    protected double covariance;

    /**
     * Gets the value of the rowIndex property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRowIndex() {
        return rowIndex;
    }

    /**
     * Sets the value of the rowIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRowIndex(BigInteger value) {
        this.rowIndex = value;
    }

    public boolean isSetRowIndex() {
        return (this.rowIndex!= null);
    }

    /**
     * Gets the value of the columnIndex property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getColumnIndex() {
        return columnIndex;
    }

    /**
     * Sets the value of the columnIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setColumnIndex(BigInteger value) {
        this.columnIndex = value;
    }

    public boolean isSetColumnIndex() {
        return (this.columnIndex!= null);
    }

    /**
     * Gets the value of the covariance property.
     * 
     */
    public double getCovariance() {
        return covariance;
    }

    /**
     * Sets the value of the covariance property.
     * 
     */
    public void setCovariance(double value) {
        this.covariance = value;
    }

    public boolean isSetCovariance() {
        return true;
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
            BigInteger theRowIndex;
            theRowIndex = this.getRowIndex();
            strategy.appendField(locator, this, "rowIndex", buffer, theRowIndex);
        }
        {
            BigInteger theColumnIndex;
            theColumnIndex = this.getColumnIndex();
            strategy.appendField(locator, this, "columnIndex", buffer, theColumnIndex);
        }
        {
            double theCovariance;
            theCovariance = this.getCovariance();
            strategy.appendField(locator, this, "covariance", buffer, theCovariance);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof CovarianceElementType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final CovarianceElementType that = ((CovarianceElementType) object);
        {
            BigInteger lhsRowIndex;
            lhsRowIndex = this.getRowIndex();
            BigInteger rhsRowIndex;
            rhsRowIndex = that.getRowIndex();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "rowIndex", lhsRowIndex), LocatorUtils.property(thatLocator, "rowIndex", rhsRowIndex), lhsRowIndex, rhsRowIndex)) {
                return false;
            }
        }
        {
            BigInteger lhsColumnIndex;
            lhsColumnIndex = this.getColumnIndex();
            BigInteger rhsColumnIndex;
            rhsColumnIndex = that.getColumnIndex();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "columnIndex", lhsColumnIndex), LocatorUtils.property(thatLocator, "columnIndex", rhsColumnIndex), lhsColumnIndex, rhsColumnIndex)) {
                return false;
            }
        }
        {
            double lhsCovariance;
            lhsCovariance = this.getCovariance();
            double rhsCovariance;
            rhsCovariance = that.getCovariance();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "covariance", lhsCovariance), LocatorUtils.property(thatLocator, "covariance", rhsCovariance), lhsCovariance, rhsCovariance)) {
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
            BigInteger theRowIndex;
            theRowIndex = this.getRowIndex();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "rowIndex", theRowIndex), currentHashCode, theRowIndex);
        }
        {
            BigInteger theColumnIndex;
            theColumnIndex = this.getColumnIndex();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "columnIndex", theColumnIndex), currentHashCode, theColumnIndex);
        }
        {
            double theCovariance;
            theCovariance = this.getCovariance();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "covariance", theCovariance), currentHashCode, theCovariance);
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
        if (draftCopy instanceof CovarianceElementType) {
            final CovarianceElementType copy = ((CovarianceElementType) draftCopy);
            if (this.isSetRowIndex()) {
                BigInteger sourceRowIndex;
                sourceRowIndex = this.getRowIndex();
                BigInteger copyRowIndex = ((BigInteger) strategy.copy(LocatorUtils.property(locator, "rowIndex", sourceRowIndex), sourceRowIndex));
                copy.setRowIndex(copyRowIndex);
            } else {
                copy.rowIndex = null;
            }
            if (this.isSetColumnIndex()) {
                BigInteger sourceColumnIndex;
                sourceColumnIndex = this.getColumnIndex();
                BigInteger copyColumnIndex = ((BigInteger) strategy.copy(LocatorUtils.property(locator, "columnIndex", sourceColumnIndex), sourceColumnIndex));
                copy.setColumnIndex(copyColumnIndex);
            } else {
                copy.columnIndex = null;
            }
            {
                double sourceCovariance;
                sourceCovariance = this.getCovariance();
                double copyCovariance = strategy.copy(LocatorUtils.property(locator, "covariance", sourceCovariance), sourceCovariance);
                copy.setCovariance(copyCovariance);
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new CovarianceElementType();
    }

}