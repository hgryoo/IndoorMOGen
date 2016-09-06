//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.gml.v_3_1_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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


/**
 * A container for an array of surface patches.
 * 
 * <p>Java class for SurfacePatchArrayPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SurfacePatchArrayPropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}_SurfacePatch"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SurfacePatchArrayPropertyType", propOrder = {
    "surfacePatch"
})
@XmlSeeAlso({
    PolygonPatchArrayPropertyType.class,
    TrianglePatchArrayPropertyType.class
})
public class SurfacePatchArrayPropertyType implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElementRef(name = "_SurfacePatch", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends AbstractSurfacePatchType>> surfacePatch;

    /**
     * Gets the value of the surfacePatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surfacePatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSurfacePatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TriangleType }{@code >}
     * {@link JAXBElement }{@code <}{@link PolygonPatchType }{@code >}
     * {@link JAXBElement }{@code <}{@link SphereType }{@code >}
     * {@link JAXBElement }{@code <}{@link RectangleType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractParametricCurveSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link ConeType }{@code >}
     * {@link JAXBElement }{@code <}{@link CylinderType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractSurfacePatchType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGriddedSurfaceType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends AbstractSurfacePatchType>> getSurfacePatch() {
        if (surfacePatch == null) {
            surfacePatch = new ArrayList<JAXBElement<? extends AbstractSurfacePatchType>>();
        }
        return this.surfacePatch;
    }

    public boolean isSetSurfacePatch() {
        return ((this.surfacePatch!= null)&&(!this.surfacePatch.isEmpty()));
    }

    public void unsetSurfacePatch() {
        this.surfacePatch = null;
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
            List<JAXBElement<? extends AbstractSurfacePatchType>> theSurfacePatch;
            theSurfacePatch = (this.isSetSurfacePatch()?this.getSurfacePatch():null);
            strategy.appendField(locator, this, "surfacePatch", buffer, theSurfacePatch);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof SurfacePatchArrayPropertyType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final SurfacePatchArrayPropertyType that = ((SurfacePatchArrayPropertyType) object);
        {
            List<JAXBElement<? extends AbstractSurfacePatchType>> lhsSurfacePatch;
            lhsSurfacePatch = (this.isSetSurfacePatch()?this.getSurfacePatch():null);
            List<JAXBElement<? extends AbstractSurfacePatchType>> rhsSurfacePatch;
            rhsSurfacePatch = (that.isSetSurfacePatch()?that.getSurfacePatch():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "surfacePatch", lhsSurfacePatch), LocatorUtils.property(thatLocator, "surfacePatch", rhsSurfacePatch), lhsSurfacePatch, rhsSurfacePatch)) {
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
            List<JAXBElement<? extends AbstractSurfacePatchType>> theSurfacePatch;
            theSurfacePatch = (this.isSetSurfacePatch()?this.getSurfacePatch():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "surfacePatch", theSurfacePatch), currentHashCode, theSurfacePatch);
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
        if (draftCopy instanceof SurfacePatchArrayPropertyType) {
            final SurfacePatchArrayPropertyType copy = ((SurfacePatchArrayPropertyType) draftCopy);
            if (this.isSetSurfacePatch()) {
                List<JAXBElement<? extends AbstractSurfacePatchType>> sourceSurfacePatch;
                sourceSurfacePatch = (this.isSetSurfacePatch()?this.getSurfacePatch():null);
                @SuppressWarnings("unchecked")
                List<JAXBElement<? extends AbstractSurfacePatchType>> copySurfacePatch = ((List<JAXBElement<? extends AbstractSurfacePatchType>> ) strategy.copy(LocatorUtils.property(locator, "surfacePatch", sourceSurfacePatch), sourceSurfacePatch));
                copy.unsetSurfacePatch();
                if (copySurfacePatch!= null) {
                    List<JAXBElement<? extends AbstractSurfacePatchType>> uniqueSurfacePatchl = copy.getSurfacePatch();
                    uniqueSurfacePatchl.addAll(copySurfacePatch);
                }
            } else {
                copy.unsetSurfacePatch();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new SurfacePatchArrayPropertyType();
    }

}
