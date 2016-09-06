//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.tunnel.v_2_0;

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
 * Mostly horizontal construction that bounds a HollowSpace from below. 
 * 
 * <p>Java class for FloorSurfaceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FloorSurfaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/tunnel/2.0}AbstractBoundarySurfaceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/tunnel/2.0}_GenericApplicationPropertyOfFloorSurface" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FloorSurfaceType", propOrder = {
    "genericApplicationPropertyOfFloorSurface"
})
public class FloorSurfaceType
    extends AbstractBoundarySurfaceType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "_GenericApplicationPropertyOfFloorSurface")
    protected List<Object> genericApplicationPropertyOfFloorSurface;

    /**
     * Gets the value of the genericApplicationPropertyOfFloorSurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfFloorSurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfFloorSurface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfFloorSurface() {
        if (genericApplicationPropertyOfFloorSurface == null) {
            genericApplicationPropertyOfFloorSurface = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfFloorSurface;
    }

    public boolean isSetGenericApplicationPropertyOfFloorSurface() {
        return ((this.genericApplicationPropertyOfFloorSurface!= null)&&(!this.genericApplicationPropertyOfFloorSurface.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfFloorSurface() {
        this.genericApplicationPropertyOfFloorSurface = null;
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
            List<Object> theGenericApplicationPropertyOfFloorSurface;
            theGenericApplicationPropertyOfFloorSurface = (this.isSetGenericApplicationPropertyOfFloorSurface()?this.getGenericApplicationPropertyOfFloorSurface():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfFloorSurface", buffer, theGenericApplicationPropertyOfFloorSurface);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FloorSurfaceType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final FloorSurfaceType that = ((FloorSurfaceType) object);
        {
            List<Object> lhsGenericApplicationPropertyOfFloorSurface;
            lhsGenericApplicationPropertyOfFloorSurface = (this.isSetGenericApplicationPropertyOfFloorSurface()?this.getGenericApplicationPropertyOfFloorSurface():null);
            List<Object> rhsGenericApplicationPropertyOfFloorSurface;
            rhsGenericApplicationPropertyOfFloorSurface = (that.isSetGenericApplicationPropertyOfFloorSurface()?that.getGenericApplicationPropertyOfFloorSurface():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfFloorSurface", lhsGenericApplicationPropertyOfFloorSurface), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfFloorSurface", rhsGenericApplicationPropertyOfFloorSurface), lhsGenericApplicationPropertyOfFloorSurface, rhsGenericApplicationPropertyOfFloorSurface)) {
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
            List<Object> theGenericApplicationPropertyOfFloorSurface;
            theGenericApplicationPropertyOfFloorSurface = (this.isSetGenericApplicationPropertyOfFloorSurface()?this.getGenericApplicationPropertyOfFloorSurface():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfFloorSurface", theGenericApplicationPropertyOfFloorSurface), currentHashCode, theGenericApplicationPropertyOfFloorSurface);
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
        if (draftCopy instanceof FloorSurfaceType) {
            final FloorSurfaceType copy = ((FloorSurfaceType) draftCopy);
            if (this.isSetGenericApplicationPropertyOfFloorSurface()) {
                List<Object> sourceGenericApplicationPropertyOfFloorSurface;
                sourceGenericApplicationPropertyOfFloorSurface = (this.isSetGenericApplicationPropertyOfFloorSurface()?this.getGenericApplicationPropertyOfFloorSurface():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfFloorSurface = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfFloorSurface", sourceGenericApplicationPropertyOfFloorSurface), sourceGenericApplicationPropertyOfFloorSurface));
                copy.unsetGenericApplicationPropertyOfFloorSurface();
                if (copyGenericApplicationPropertyOfFloorSurface!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfFloorSurfacel = copy.getGenericApplicationPropertyOfFloorSurface();
                    uniqueGenericApplicationPropertyOfFloorSurfacel.addAll(copyGenericApplicationPropertyOfFloorSurface);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfFloorSurface();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new FloorSurfaceType();
    }

}
