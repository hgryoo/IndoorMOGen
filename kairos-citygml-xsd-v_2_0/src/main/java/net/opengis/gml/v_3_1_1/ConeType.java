//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.gml.v_3_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 * A cone is a gridded surface given as a
 *    family of conic sections whose control points vary linearly.
 *    NOTE! A 5-point ellipse with all defining positions identical
 *    is a point. Thus, a truncated elliptical cone can be given as a
 *    2x5 set of control points
 *    ((P1, P1, P1, P1, P1), (P2, P3, P4, P5, P6)). P1 is the apex 
 *    of the cone. P2, P3,P4, P5 and P6 are any five distinct points
 *    around the base ellipse of the cone. If the horizontal curves
 *    are circles as opposed to ellipses, the a circular cone can
 *    be constructed using ((P1, P1, P1),(P2, P3, P4)). The apex most     
 *    not coinside with the other plane.
 * 
 * <p>Java class for ConeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGriddedSurfaceType"&gt;
 *       &lt;attribute name="horizontalCurveType" type="{http://www.opengis.net/gml}CurveInterpolationType" fixed="circularArc3Points" /&gt;
 *       &lt;attribute name="verticalCurveType" type="{http://www.opengis.net/gml}CurveInterpolationType" fixed="linear" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConeType")
public class ConeType
    extends AbstractGriddedSurfaceType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlAttribute(name = "horizontalCurveType")
    protected CurveInterpolationType horizontalCurveType;
    @XmlAttribute(name = "verticalCurveType")
    protected CurveInterpolationType verticalCurveType;

    /**
     * Gets the value of the horizontalCurveType property.
     * 
     * @return
     *     possible object is
     *     {@link CurveInterpolationType }
     *     
     */
    public CurveInterpolationType getHorizontalCurveType() {
        if (horizontalCurveType == null) {
            return CurveInterpolationType.CIRCULAR_ARC_3_POINTS;
        } else {
            return horizontalCurveType;
        }
    }

    /**
     * Sets the value of the horizontalCurveType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurveInterpolationType }
     *     
     */
    public void setHorizontalCurveType(CurveInterpolationType value) {
        this.horizontalCurveType = value;
    }

    public boolean isSetHorizontalCurveType() {
        return (this.horizontalCurveType!= null);
    }

    /**
     * Gets the value of the verticalCurveType property.
     * 
     * @return
     *     possible object is
     *     {@link CurveInterpolationType }
     *     
     */
    public CurveInterpolationType getVerticalCurveType() {
        if (verticalCurveType == null) {
            return CurveInterpolationType.LINEAR;
        } else {
            return verticalCurveType;
        }
    }

    /**
     * Sets the value of the verticalCurveType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurveInterpolationType }
     *     
     */
    public void setVerticalCurveType(CurveInterpolationType value) {
        this.verticalCurveType = value;
    }

    public boolean isSetVerticalCurveType() {
        return (this.verticalCurveType!= null);
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
            CurveInterpolationType theHorizontalCurveType;
            theHorizontalCurveType = this.getHorizontalCurveType();
            strategy.appendField(locator, this, "horizontalCurveType", buffer, theHorizontalCurveType);
        }
        {
            CurveInterpolationType theVerticalCurveType;
            theVerticalCurveType = this.getVerticalCurveType();
            strategy.appendField(locator, this, "verticalCurveType", buffer, theVerticalCurveType);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ConeType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ConeType that = ((ConeType) object);
        {
            CurveInterpolationType lhsHorizontalCurveType;
            lhsHorizontalCurveType = this.getHorizontalCurveType();
            CurveInterpolationType rhsHorizontalCurveType;
            rhsHorizontalCurveType = that.getHorizontalCurveType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "horizontalCurveType", lhsHorizontalCurveType), LocatorUtils.property(thatLocator, "horizontalCurveType", rhsHorizontalCurveType), lhsHorizontalCurveType, rhsHorizontalCurveType)) {
                return false;
            }
        }
        {
            CurveInterpolationType lhsVerticalCurveType;
            lhsVerticalCurveType = this.getVerticalCurveType();
            CurveInterpolationType rhsVerticalCurveType;
            rhsVerticalCurveType = that.getVerticalCurveType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "verticalCurveType", lhsVerticalCurveType), LocatorUtils.property(thatLocator, "verticalCurveType", rhsVerticalCurveType), lhsVerticalCurveType, rhsVerticalCurveType)) {
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
            CurveInterpolationType theHorizontalCurveType;
            theHorizontalCurveType = this.getHorizontalCurveType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "horizontalCurveType", theHorizontalCurveType), currentHashCode, theHorizontalCurveType);
        }
        {
            CurveInterpolationType theVerticalCurveType;
            theVerticalCurveType = this.getVerticalCurveType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "verticalCurveType", theVerticalCurveType), currentHashCode, theVerticalCurveType);
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
        if (draftCopy instanceof ConeType) {
            final ConeType copy = ((ConeType) draftCopy);
            if (this.isSetHorizontalCurveType()) {
                CurveInterpolationType sourceHorizontalCurveType;
                sourceHorizontalCurveType = this.getHorizontalCurveType();
                CurveInterpolationType copyHorizontalCurveType = ((CurveInterpolationType) strategy.copy(LocatorUtils.property(locator, "horizontalCurveType", sourceHorizontalCurveType), sourceHorizontalCurveType));
                copy.setHorizontalCurveType(copyHorizontalCurveType);
            } else {
                copy.horizontalCurveType = null;
            }
            if (this.isSetVerticalCurveType()) {
                CurveInterpolationType sourceVerticalCurveType;
                sourceVerticalCurveType = this.getVerticalCurveType();
                CurveInterpolationType copyVerticalCurveType = ((CurveInterpolationType) strategy.copy(LocatorUtils.property(locator, "verticalCurveType", sourceVerticalCurveType), sourceVerticalCurveType));
                copy.setVerticalCurveType(copyVerticalCurveType);
            } else {
                copy.verticalCurveType = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new ConeType();
    }

}