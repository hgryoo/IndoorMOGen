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
 * A geometry collection must include one or more geometries, referenced through geometryMember elements.
 * 
 * <p>Java class for MultiGeometryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MultiGeometryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGeometricAggregateType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}geometryMember" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}geometryMembers" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiGeometryType", propOrder = {
    "geometryMember",
    "geometryMembers"
})
public class MultiGeometryType
    extends AbstractGeometricAggregateType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected List<GeometryPropertyType> geometryMember;
    protected GeometryArrayPropertyType geometryMembers;

    /**
     * Gets the value of the geometryMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geometryMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeometryMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeometryPropertyType }
     * 
     * 
     */
    public List<GeometryPropertyType> getGeometryMember() {
        if (geometryMember == null) {
            geometryMember = new ArrayList<GeometryPropertyType>();
        }
        return this.geometryMember;
    }

    public boolean isSetGeometryMember() {
        return ((this.geometryMember!= null)&&(!this.geometryMember.isEmpty()));
    }

    public void unsetGeometryMember() {
        this.geometryMember = null;
    }

    /**
     * Gets the value of the geometryMembers property.
     * 
     * @return
     *     possible object is
     *     {@link GeometryArrayPropertyType }
     *     
     */
    public GeometryArrayPropertyType getGeometryMembers() {
        return geometryMembers;
    }

    /**
     * Sets the value of the geometryMembers property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryArrayPropertyType }
     *     
     */
    public void setGeometryMembers(GeometryArrayPropertyType value) {
        this.geometryMembers = value;
    }

    public boolean isSetGeometryMembers() {
        return (this.geometryMembers!= null);
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
            List<GeometryPropertyType> theGeometryMember;
            theGeometryMember = (this.isSetGeometryMember()?this.getGeometryMember():null);
            strategy.appendField(locator, this, "geometryMember", buffer, theGeometryMember);
        }
        {
            GeometryArrayPropertyType theGeometryMembers;
            theGeometryMembers = this.getGeometryMembers();
            strategy.appendField(locator, this, "geometryMembers", buffer, theGeometryMembers);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof MultiGeometryType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final MultiGeometryType that = ((MultiGeometryType) object);
        {
            List<GeometryPropertyType> lhsGeometryMember;
            lhsGeometryMember = (this.isSetGeometryMember()?this.getGeometryMember():null);
            List<GeometryPropertyType> rhsGeometryMember;
            rhsGeometryMember = (that.isSetGeometryMember()?that.getGeometryMember():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "geometryMember", lhsGeometryMember), LocatorUtils.property(thatLocator, "geometryMember", rhsGeometryMember), lhsGeometryMember, rhsGeometryMember)) {
                return false;
            }
        }
        {
            GeometryArrayPropertyType lhsGeometryMembers;
            lhsGeometryMembers = this.getGeometryMembers();
            GeometryArrayPropertyType rhsGeometryMembers;
            rhsGeometryMembers = that.getGeometryMembers();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "geometryMembers", lhsGeometryMembers), LocatorUtils.property(thatLocator, "geometryMembers", rhsGeometryMembers), lhsGeometryMembers, rhsGeometryMembers)) {
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
            List<GeometryPropertyType> theGeometryMember;
            theGeometryMember = (this.isSetGeometryMember()?this.getGeometryMember():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "geometryMember", theGeometryMember), currentHashCode, theGeometryMember);
        }
        {
            GeometryArrayPropertyType theGeometryMembers;
            theGeometryMembers = this.getGeometryMembers();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "geometryMembers", theGeometryMembers), currentHashCode, theGeometryMembers);
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
        if (draftCopy instanceof MultiGeometryType) {
            final MultiGeometryType copy = ((MultiGeometryType) draftCopy);
            if (this.isSetGeometryMember()) {
                List<GeometryPropertyType> sourceGeometryMember;
                sourceGeometryMember = (this.isSetGeometryMember()?this.getGeometryMember():null);
                @SuppressWarnings("unchecked")
                List<GeometryPropertyType> copyGeometryMember = ((List<GeometryPropertyType> ) strategy.copy(LocatorUtils.property(locator, "geometryMember", sourceGeometryMember), sourceGeometryMember));
                copy.unsetGeometryMember();
                if (copyGeometryMember!= null) {
                    List<GeometryPropertyType> uniqueGeometryMemberl = copy.getGeometryMember();
                    uniqueGeometryMemberl.addAll(copyGeometryMember);
                }
            } else {
                copy.unsetGeometryMember();
            }
            if (this.isSetGeometryMembers()) {
                GeometryArrayPropertyType sourceGeometryMembers;
                sourceGeometryMembers = this.getGeometryMembers();
                GeometryArrayPropertyType copyGeometryMembers = ((GeometryArrayPropertyType) strategy.copy(LocatorUtils.property(locator, "geometryMembers", sourceGeometryMembers), sourceGeometryMembers));
                copy.setGeometryMembers(copyGeometryMembers);
            } else {
                copy.geometryMembers = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new MultiGeometryType();
    }

}
