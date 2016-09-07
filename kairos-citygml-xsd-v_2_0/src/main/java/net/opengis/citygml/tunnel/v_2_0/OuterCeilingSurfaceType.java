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
 * Mainly horizontal construction that separates the interior part of the Tunnel from the ambient medium
 * 				(rock, earth, ..) from above.
 * 
 * <p>Java class for OuterCeilingSurfaceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OuterCeilingSurfaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/tunnel/2.0}AbstractBoundarySurfaceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/tunnel/2.0}_GenericApplicationPropertyOfOuterCeilingSurface" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OuterCeilingSurfaceType", propOrder = {
    "genericApplicationPropertyOfOuterCeilingSurface"
})
public class OuterCeilingSurfaceType
    extends AbstractBoundarySurfaceType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "_GenericApplicationPropertyOfOuterCeilingSurface")
    protected List<Object> genericApplicationPropertyOfOuterCeilingSurface;

    /**
     * Gets the value of the genericApplicationPropertyOfOuterCeilingSurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfOuterCeilingSurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfOuterCeilingSurface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfOuterCeilingSurface() {
        if (genericApplicationPropertyOfOuterCeilingSurface == null) {
            genericApplicationPropertyOfOuterCeilingSurface = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfOuterCeilingSurface;
    }

    public boolean isSetGenericApplicationPropertyOfOuterCeilingSurface() {
        return ((this.genericApplicationPropertyOfOuterCeilingSurface!= null)&&(!this.genericApplicationPropertyOfOuterCeilingSurface.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfOuterCeilingSurface() {
        this.genericApplicationPropertyOfOuterCeilingSurface = null;
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
            List<Object> theGenericApplicationPropertyOfOuterCeilingSurface;
            theGenericApplicationPropertyOfOuterCeilingSurface = (this.isSetGenericApplicationPropertyOfOuterCeilingSurface()?this.getGenericApplicationPropertyOfOuterCeilingSurface():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfOuterCeilingSurface", buffer, theGenericApplicationPropertyOfOuterCeilingSurface);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof OuterCeilingSurfaceType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final OuterCeilingSurfaceType that = ((OuterCeilingSurfaceType) object);
        {
            List<Object> lhsGenericApplicationPropertyOfOuterCeilingSurface;
            lhsGenericApplicationPropertyOfOuterCeilingSurface = (this.isSetGenericApplicationPropertyOfOuterCeilingSurface()?this.getGenericApplicationPropertyOfOuterCeilingSurface():null);
            List<Object> rhsGenericApplicationPropertyOfOuterCeilingSurface;
            rhsGenericApplicationPropertyOfOuterCeilingSurface = (that.isSetGenericApplicationPropertyOfOuterCeilingSurface()?that.getGenericApplicationPropertyOfOuterCeilingSurface():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfOuterCeilingSurface", lhsGenericApplicationPropertyOfOuterCeilingSurface), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfOuterCeilingSurface", rhsGenericApplicationPropertyOfOuterCeilingSurface), lhsGenericApplicationPropertyOfOuterCeilingSurface, rhsGenericApplicationPropertyOfOuterCeilingSurface)) {
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
            List<Object> theGenericApplicationPropertyOfOuterCeilingSurface;
            theGenericApplicationPropertyOfOuterCeilingSurface = (this.isSetGenericApplicationPropertyOfOuterCeilingSurface()?this.getGenericApplicationPropertyOfOuterCeilingSurface():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfOuterCeilingSurface", theGenericApplicationPropertyOfOuterCeilingSurface), currentHashCode, theGenericApplicationPropertyOfOuterCeilingSurface);
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
        if (draftCopy instanceof OuterCeilingSurfaceType) {
            final OuterCeilingSurfaceType copy = ((OuterCeilingSurfaceType) draftCopy);
            if (this.isSetGenericApplicationPropertyOfOuterCeilingSurface()) {
                List<Object> sourceGenericApplicationPropertyOfOuterCeilingSurface;
                sourceGenericApplicationPropertyOfOuterCeilingSurface = (this.isSetGenericApplicationPropertyOfOuterCeilingSurface()?this.getGenericApplicationPropertyOfOuterCeilingSurface():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfOuterCeilingSurface = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfOuterCeilingSurface", sourceGenericApplicationPropertyOfOuterCeilingSurface), sourceGenericApplicationPropertyOfOuterCeilingSurface));
                copy.unsetGenericApplicationPropertyOfOuterCeilingSurface();
                if (copyGenericApplicationPropertyOfOuterCeilingSurface!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfOuterCeilingSurfacel = copy.getGenericApplicationPropertyOfOuterCeilingSurface();
                    uniqueGenericApplicationPropertyOfOuterCeilingSurfacel.addAll(copyGenericApplicationPropertyOfOuterCeilingSurface);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfOuterCeilingSurface();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new OuterCeilingSurfaceType();
    }

}