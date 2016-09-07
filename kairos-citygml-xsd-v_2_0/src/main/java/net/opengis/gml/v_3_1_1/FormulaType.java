//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.gml.v_3_1_1;

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
 * Paremeters of a simple formula by which a value using this unit of measure can be converted to the corresponding value using the preferred unit of measure. The formula element contains elements a, b, c and d, whose values use the XML Schema type "double". These values are used in the formula y = (a + bx) / (c + dx), where x is a value using this unit, and y is the corresponding value using the preferred unit. The elements a and d are optional, and if values are not provided, those parameters are considered to be zero. If values are not provided for both a and d, the formula is equivalent to a fraction with numerator and denominator parameters.
 * 
 * <p>Java class for FormulaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FormulaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="c" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="d" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FormulaType", propOrder = {
    "a",
    "b",
    "c",
    "d"
})
public class FormulaType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected Double a;
    protected double b;
    protected double c;
    protected Double d;

    /**
     * Gets the value of the a property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getA() {
        return a;
    }

    /**
     * Sets the value of the a property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setA(Double value) {
        this.a = value;
    }

    public boolean isSetA() {
        return (this.a!= null);
    }

    /**
     * Gets the value of the b property.
     * 
     */
    public double getB() {
        return b;
    }

    /**
     * Sets the value of the b property.
     * 
     */
    public void setB(double value) {
        this.b = value;
    }

    public boolean isSetB() {
        return true;
    }

    /**
     * Gets the value of the c property.
     * 
     */
    public double getC() {
        return c;
    }

    /**
     * Sets the value of the c property.
     * 
     */
    public void setC(double value) {
        this.c = value;
    }

    public boolean isSetC() {
        return true;
    }

    /**
     * Gets the value of the d property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getD() {
        return d;
    }

    /**
     * Sets the value of the d property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setD(Double value) {
        this.d = value;
    }

    public boolean isSetD() {
        return (this.d!= null);
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
            Double theA;
            theA = this.getA();
            strategy.appendField(locator, this, "a", buffer, theA);
        }
        {
            double theB;
            theB = this.getB();
            strategy.appendField(locator, this, "b", buffer, theB);
        }
        {
            double theC;
            theC = this.getC();
            strategy.appendField(locator, this, "c", buffer, theC);
        }
        {
            Double theD;
            theD = this.getD();
            strategy.appendField(locator, this, "d", buffer, theD);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FormulaType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final FormulaType that = ((FormulaType) object);
        {
            Double lhsA;
            lhsA = this.getA();
            Double rhsA;
            rhsA = that.getA();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "a", lhsA), LocatorUtils.property(thatLocator, "a", rhsA), lhsA, rhsA)) {
                return false;
            }
        }
        {
            double lhsB;
            lhsB = this.getB();
            double rhsB;
            rhsB = that.getB();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "b", lhsB), LocatorUtils.property(thatLocator, "b", rhsB), lhsB, rhsB)) {
                return false;
            }
        }
        {
            double lhsC;
            lhsC = this.getC();
            double rhsC;
            rhsC = that.getC();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "c", lhsC), LocatorUtils.property(thatLocator, "c", rhsC), lhsC, rhsC)) {
                return false;
            }
        }
        {
            Double lhsD;
            lhsD = this.getD();
            Double rhsD;
            rhsD = that.getD();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "d", lhsD), LocatorUtils.property(thatLocator, "d", rhsD), lhsD, rhsD)) {
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
            Double theA;
            theA = this.getA();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "a", theA), currentHashCode, theA);
        }
        {
            double theB;
            theB = this.getB();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "b", theB), currentHashCode, theB);
        }
        {
            double theC;
            theC = this.getC();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "c", theC), currentHashCode, theC);
        }
        {
            Double theD;
            theD = this.getD();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "d", theD), currentHashCode, theD);
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
        if (draftCopy instanceof FormulaType) {
            final FormulaType copy = ((FormulaType) draftCopy);
            if (this.isSetA()) {
                Double sourceA;
                sourceA = this.getA();
                Double copyA = ((Double) strategy.copy(LocatorUtils.property(locator, "a", sourceA), sourceA));
                copy.setA(copyA);
            } else {
                copy.a = null;
            }
            {
                double sourceB;
                sourceB = this.getB();
                double copyB = strategy.copy(LocatorUtils.property(locator, "b", sourceB), sourceB);
                copy.setB(copyB);
            }
            {
                double sourceC;
                sourceC = this.getC();
                double copyC = strategy.copy(LocatorUtils.property(locator, "c", sourceC), sourceC);
                copy.setC(copyC);
            }
            if (this.isSetD()) {
                Double sourceD;
                sourceD = this.getD();
                Double copyD = ((Double) strategy.copy(LocatorUtils.property(locator, "d", sourceD), sourceD));
                copy.setD(copyD);
            } else {
                copy.d = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new FormulaType();
    }

}