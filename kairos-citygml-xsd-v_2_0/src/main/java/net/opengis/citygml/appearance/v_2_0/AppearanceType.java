//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.appearance.v_2_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.v_3_1_1.AbstractFeatureType;
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
 *  Named container for all surface data (texture/material). All appearances of the same name ("theme")
 * 				within a CityGML file are considered a group. 
 * 
 * <p>Java class for AppearanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppearanceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="theme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="surfaceDataMember" type="{http://www.opengis.net/citygml/appearance/2.0}SurfaceDataPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/appearance/2.0}_GenericApplicationPropertyOfAppearance" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppearanceType", propOrder = {
    "theme",
    "surfaceDataMember",
    "genericApplicationPropertyOfAppearance"
})
public class AppearanceType
    extends AbstractFeatureType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected String theme;
    protected List<SurfaceDataPropertyType> surfaceDataMember;
    @XmlElement(name = "_GenericApplicationPropertyOfAppearance")
    protected List<Object> genericApplicationPropertyOfAppearance;

    /**
     * Gets the value of the theme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets the value of the theme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheme(String value) {
        this.theme = value;
    }

    public boolean isSetTheme() {
        return (this.theme!= null);
    }

    /**
     * Gets the value of the surfaceDataMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surfaceDataMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSurfaceDataMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SurfaceDataPropertyType }
     * 
     * 
     */
    public List<SurfaceDataPropertyType> getSurfaceDataMember() {
        if (surfaceDataMember == null) {
            surfaceDataMember = new ArrayList<SurfaceDataPropertyType>();
        }
        return this.surfaceDataMember;
    }

    public boolean isSetSurfaceDataMember() {
        return ((this.surfaceDataMember!= null)&&(!this.surfaceDataMember.isEmpty()));
    }

    public void unsetSurfaceDataMember() {
        this.surfaceDataMember = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfAppearance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfAppearance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericApplicationPropertyOfAppearance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGenericApplicationPropertyOfAppearance() {
        if (genericApplicationPropertyOfAppearance == null) {
            genericApplicationPropertyOfAppearance = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfAppearance;
    }

    public boolean isSetGenericApplicationPropertyOfAppearance() {
        return ((this.genericApplicationPropertyOfAppearance!= null)&&(!this.genericApplicationPropertyOfAppearance.isEmpty()));
    }

    public void unsetGenericApplicationPropertyOfAppearance() {
        this.genericApplicationPropertyOfAppearance = null;
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
            String theTheme;
            theTheme = this.getTheme();
            strategy.appendField(locator, this, "theme", buffer, theTheme);
        }
        {
            List<SurfaceDataPropertyType> theSurfaceDataMember;
            theSurfaceDataMember = (this.isSetSurfaceDataMember()?this.getSurfaceDataMember():null);
            strategy.appendField(locator, this, "surfaceDataMember", buffer, theSurfaceDataMember);
        }
        {
            List<Object> theGenericApplicationPropertyOfAppearance;
            theGenericApplicationPropertyOfAppearance = (this.isSetGenericApplicationPropertyOfAppearance()?this.getGenericApplicationPropertyOfAppearance():null);
            strategy.appendField(locator, this, "genericApplicationPropertyOfAppearance", buffer, theGenericApplicationPropertyOfAppearance);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AppearanceType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final AppearanceType that = ((AppearanceType) object);
        {
            String lhsTheme;
            lhsTheme = this.getTheme();
            String rhsTheme;
            rhsTheme = that.getTheme();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "theme", lhsTheme), LocatorUtils.property(thatLocator, "theme", rhsTheme), lhsTheme, rhsTheme)) {
                return false;
            }
        }
        {
            List<SurfaceDataPropertyType> lhsSurfaceDataMember;
            lhsSurfaceDataMember = (this.isSetSurfaceDataMember()?this.getSurfaceDataMember():null);
            List<SurfaceDataPropertyType> rhsSurfaceDataMember;
            rhsSurfaceDataMember = (that.isSetSurfaceDataMember()?that.getSurfaceDataMember():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "surfaceDataMember", lhsSurfaceDataMember), LocatorUtils.property(thatLocator, "surfaceDataMember", rhsSurfaceDataMember), lhsSurfaceDataMember, rhsSurfaceDataMember)) {
                return false;
            }
        }
        {
            List<Object> lhsGenericApplicationPropertyOfAppearance;
            lhsGenericApplicationPropertyOfAppearance = (this.isSetGenericApplicationPropertyOfAppearance()?this.getGenericApplicationPropertyOfAppearance():null);
            List<Object> rhsGenericApplicationPropertyOfAppearance;
            rhsGenericApplicationPropertyOfAppearance = (that.isSetGenericApplicationPropertyOfAppearance()?that.getGenericApplicationPropertyOfAppearance():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "genericApplicationPropertyOfAppearance", lhsGenericApplicationPropertyOfAppearance), LocatorUtils.property(thatLocator, "genericApplicationPropertyOfAppearance", rhsGenericApplicationPropertyOfAppearance), lhsGenericApplicationPropertyOfAppearance, rhsGenericApplicationPropertyOfAppearance)) {
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
            String theTheme;
            theTheme = this.getTheme();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "theme", theTheme), currentHashCode, theTheme);
        }
        {
            List<SurfaceDataPropertyType> theSurfaceDataMember;
            theSurfaceDataMember = (this.isSetSurfaceDataMember()?this.getSurfaceDataMember():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "surfaceDataMember", theSurfaceDataMember), currentHashCode, theSurfaceDataMember);
        }
        {
            List<Object> theGenericApplicationPropertyOfAppearance;
            theGenericApplicationPropertyOfAppearance = (this.isSetGenericApplicationPropertyOfAppearance()?this.getGenericApplicationPropertyOfAppearance():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "genericApplicationPropertyOfAppearance", theGenericApplicationPropertyOfAppearance), currentHashCode, theGenericApplicationPropertyOfAppearance);
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
        if (draftCopy instanceof AppearanceType) {
            final AppearanceType copy = ((AppearanceType) draftCopy);
            if (this.isSetTheme()) {
                String sourceTheme;
                sourceTheme = this.getTheme();
                String copyTheme = ((String) strategy.copy(LocatorUtils.property(locator, "theme", sourceTheme), sourceTheme));
                copy.setTheme(copyTheme);
            } else {
                copy.theme = null;
            }
            if (this.isSetSurfaceDataMember()) {
                List<SurfaceDataPropertyType> sourceSurfaceDataMember;
                sourceSurfaceDataMember = (this.isSetSurfaceDataMember()?this.getSurfaceDataMember():null);
                @SuppressWarnings("unchecked")
                List<SurfaceDataPropertyType> copySurfaceDataMember = ((List<SurfaceDataPropertyType> ) strategy.copy(LocatorUtils.property(locator, "surfaceDataMember", sourceSurfaceDataMember), sourceSurfaceDataMember));
                copy.unsetSurfaceDataMember();
                if (copySurfaceDataMember!= null) {
                    List<SurfaceDataPropertyType> uniqueSurfaceDataMemberl = copy.getSurfaceDataMember();
                    uniqueSurfaceDataMemberl.addAll(copySurfaceDataMember);
                }
            } else {
                copy.unsetSurfaceDataMember();
            }
            if (this.isSetGenericApplicationPropertyOfAppearance()) {
                List<Object> sourceGenericApplicationPropertyOfAppearance;
                sourceGenericApplicationPropertyOfAppearance = (this.isSetGenericApplicationPropertyOfAppearance()?this.getGenericApplicationPropertyOfAppearance():null);
                @SuppressWarnings("unchecked")
                List<Object> copyGenericApplicationPropertyOfAppearance = ((List<Object> ) strategy.copy(LocatorUtils.property(locator, "genericApplicationPropertyOfAppearance", sourceGenericApplicationPropertyOfAppearance), sourceGenericApplicationPropertyOfAppearance));
                copy.unsetGenericApplicationPropertyOfAppearance();
                if (copyGenericApplicationPropertyOfAppearance!= null) {
                    List<Object> uniqueGenericApplicationPropertyOfAppearancel = copy.getGenericApplicationPropertyOfAppearance();
                    uniqueGenericApplicationPropertyOfAppearancel.addAll(copyGenericApplicationPropertyOfAppearance);
                }
            } else {
                copy.unsetGenericApplicationPropertyOfAppearance();
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new AppearanceType();
    }

}
