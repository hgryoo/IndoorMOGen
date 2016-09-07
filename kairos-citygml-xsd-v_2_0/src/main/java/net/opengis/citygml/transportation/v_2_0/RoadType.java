//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.transportation.v_2_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 * Type describing the class for roads. As subclass of _CityObject, a Road inherits all attributes and
 * 				relations, in particular an id, names, external references, and generalization relations. 
 * 
 * <p>Java class for RoadType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoadType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/transportation/2.0}TransportationComplexType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/transportation/2.0}_GenericApplicationPropertyOfRoad" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoadType", propOrder = {
    "genericApplicationPropertyOfRoad"
})
public class RoadType
    extends TransportationComplexType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "_GenericApplicationPropertyOfRoad")
    protected List<Object> genericApplicationPropertyOfRoad;

    /**
     * Gets the value of the genericApplicationPropertyOfRoad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfRoad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfRoad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfRoad() {
        if (genericApplicationPropertyOfRoad == null) {
            genericApplicationPropertyOfRoad = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfRoad;
    }

    public boolean isSetGenericApplicationPropertyOfRoad() {
        return ((this.genericApplicationPropertyOfRoad!= null)&&(!this.genericApplicationPropertyOfRoad.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfRoad() {
        this.genericApplicationPropertyOfRoad = null;
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
            List<Object> theGenericApplicationPropertyOfRoad;
            theGenericApplicationPropertyOfRoad = (this.isSetGenericApplicationPropertyOfRoad()?this.getGenericApplicationPropertyOfRoad():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfRoad", buffer, theGenericApplicationPropertyOfRoad);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RoadType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final RoadType that = ((RoadType) object);
        {
            List<Object> lhsGenericApplicationPropertyOfRoad;
            lhsGenericApplicationPropertyOfRoad = (this.isSetGenericApplicationPropertyOfRoad()?this.getGenericApplicationPropertyOfRoad():null);
            List<Object> rhsGenericApplicationPropertyOfRoad;
            rhsGenericApplicationPropertyOfRoad = (that.isSetGenericApplicationPropertyOfRoad()?that.getGenericApplicationPropertyOfRoad():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfRoad", lhsGenericApplicationPropertyOfRoad), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfRoad", rhsGenericApplicationPropertyOfRoad), lhsGenericApplicationPropertyOfRoad, rhsGenericApplicationPropertyOfRoad)) {
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
            List<Object> theGenericApplicationPropertyOfRoad;
            theGenericApplicationPropertyOfRoad = (this.isSetGenericApplicationPropertyOfRoad()?this.getGenericApplicationPropertyOfRoad():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfRoad", theGenericApplicationPropertyOfRoad), currentHashCode, theGenericApplicationPropertyOfRoad);
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
        if (draftCopy instanceof RoadType) {
            final RoadType copy = ((RoadType) draftCopy);
            if (this.isSetGenericApplicationPropertyOfRoad()) {
                List<Object> sourceGenericApplicationPropertyOfRoad;
                sourceGenericApplicationPropertyOfRoad = (this.isSetGenericApplicationPropertyOfRoad()?this.getGenericApplicationPropertyOfRoad():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfRoad = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfRoad", sourceGenericApplicationPropertyOfRoad), sourceGenericApplicationPropertyOfRoad));
                copy.unsetGenericApplicationPropertyOfRoad();
                if (copyGenericApplicationPropertyOfRoad!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfRoadl = copy.getGenericApplicationPropertyOfRoad();
                    uniqueGenericApplicationPropertyOfRoadl.addAll(copyGenericApplicationPropertyOfRoad);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfRoad();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new RoadType();
    }

}