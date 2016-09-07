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
 * [complexType of] The style descriptor for topologies of a feature. Describes individual topology elements styles.
 * 
 * <p>Java class for TopologyStyleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TopologyStyleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}BaseStyleDescriptorType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.opengis.net/gml}symbol"/&gt;
 *           &lt;element name="style" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}labelStyle" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="topologyProperty" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="topologyType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TopologyStyleType", propOrder = {
    "symbol",
    "style",
    "labelStyle"
})
public class TopologyStyleType
    extends BaseStyleDescriptorType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected SymbolType symbol;
    protected String style;
    protected LabelStylePropertyType labelStyle;
    @XmlAttribute(name = "topologyProperty")
    protected String topologyProperty;
    @XmlAttribute(name = "topologyType")
    protected String topologyType;

    /**
     * Gets the value of the symbol property.
     * 
     * @return
     *     possible object is
     *     {@link SymbolType }
     *     
     */
    public SymbolType getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolType }
     *     
     */
    public void setSymbol(SymbolType value) {
        this.symbol = value;
    }

    public boolean isSetSymbol() {
        return (this.symbol!= null);
    }

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }

    public boolean isSetStyle() {
        return (this.style!= null);
    }

    /**
     * Gets the value of the labelStyle property.
     * 
     * @return
     *     possible object is
     *     {@link LabelStylePropertyType }
     *     
     */
    public LabelStylePropertyType getLabelStyle() {
        return labelStyle;
    }

    /**
     * Sets the value of the labelStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link LabelStylePropertyType }
     *     
     */
    public void setLabelStyle(LabelStylePropertyType value) {
        this.labelStyle = value;
    }

    public boolean isSetLabelStyle() {
        return (this.labelStyle!= null);
    }

    /**
     * Gets the value of the topologyProperty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopologyProperty() {
        return topologyProperty;
    }

    /**
     * Sets the value of the topologyProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTopologyProperty(String value) {
        this.topologyProperty = value;
    }

    public boolean isSetTopologyProperty() {
        return (this.topologyProperty!= null);
    }

    /**
     * Gets the value of the topologyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopologyType() {
        return topologyType;
    }

    /**
     * Sets the value of the topologyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTopologyType(String value) {
        this.topologyType = value;
    }

    public boolean isSetTopologyType() {
        return (this.topologyType!= null);
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
            SymbolType theSymbol;
            theSymbol = this.getSymbol();
            strategy.appendField(locator, this, "symbol", buffer, theSymbol);
        }
        {
            String theStyle;
            theStyle = this.getStyle();
            strategy.appendField(locator, this, "style", buffer, theStyle);
        }
        {
            LabelStylePropertyType theLabelStyle;
            theLabelStyle = this.getLabelStyle();
            strategy.appendField(locator, this, "labelStyle", buffer, theLabelStyle);
        }
        {
            String theTopologyProperty;
            theTopologyProperty = this.getTopologyProperty();
            strategy.appendField(locator, this, "topologyProperty", buffer, theTopologyProperty);
        }
        {
            String theTopologyType;
            theTopologyType = this.getTopologyType();
            strategy.appendField(locator, this, "topologyType", buffer, theTopologyType);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TopologyStyleType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final TopologyStyleType that = ((TopologyStyleType) object);
        {
            SymbolType lhsSymbol;
            lhsSymbol = this.getSymbol();
            SymbolType rhsSymbol;
            rhsSymbol = that.getSymbol();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "symbol", lhsSymbol), LocatorUtils.property(thatLocator, "symbol", rhsSymbol), lhsSymbol, rhsSymbol)) {
                return false;
            }
        }
        {
            String lhsStyle;
            lhsStyle = this.getStyle();
            String rhsStyle;
            rhsStyle = that.getStyle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "style", lhsStyle), LocatorUtils.property(thatLocator, "style", rhsStyle), lhsStyle, rhsStyle)) {
                return false;
            }
        }
        {
            LabelStylePropertyType lhsLabelStyle;
            lhsLabelStyle = this.getLabelStyle();
            LabelStylePropertyType rhsLabelStyle;
            rhsLabelStyle = that.getLabelStyle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "labelStyle", lhsLabelStyle), LocatorUtils.property(thatLocator, "labelStyle", rhsLabelStyle), lhsLabelStyle, rhsLabelStyle)) {
                return false;
            }
        }
        {
            String lhsTopologyProperty;
            lhsTopologyProperty = this.getTopologyProperty();
            String rhsTopologyProperty;
            rhsTopologyProperty = that.getTopologyProperty();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "topologyProperty", lhsTopologyProperty), LocatorUtils.property(thatLocator, "topologyProperty", rhsTopologyProperty), lhsTopologyProperty, rhsTopologyProperty)) {
                return false;
            }
        }
        {
            String lhsTopologyType;
            lhsTopologyType = this.getTopologyType();
            String rhsTopologyType;
            rhsTopologyType = that.getTopologyType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "topologyType", lhsTopologyType), LocatorUtils.property(thatLocator, "topologyType", rhsTopologyType), lhsTopologyType, rhsTopologyType)) {
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
            SymbolType theSymbol;
            theSymbol = this.getSymbol();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "symbol", theSymbol), currentHashCode, theSymbol);
        }
        {
            String theStyle;
            theStyle = this.getStyle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "style", theStyle), currentHashCode, theStyle);
        }
        {
            LabelStylePropertyType theLabelStyle;
            theLabelStyle = this.getLabelStyle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "labelStyle", theLabelStyle), currentHashCode, theLabelStyle);
        }
        {
            String theTopologyProperty;
            theTopologyProperty = this.getTopologyProperty();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "topologyProperty", theTopologyProperty), currentHashCode, theTopologyProperty);
        }
        {
            String theTopologyType;
            theTopologyType = this.getTopologyType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "topologyType", theTopologyType), currentHashCode, theTopologyType);
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
        if (draftCopy instanceof TopologyStyleType) {
            final TopologyStyleType copy = ((TopologyStyleType) draftCopy);
            if (this.isSetSymbol()) {
                SymbolType sourceSymbol;
                sourceSymbol = this.getSymbol();
                SymbolType copySymbol = ((SymbolType) strategy.copy(LocatorUtils.property(locator, "symbol", sourceSymbol), sourceSymbol));
                copy.setSymbol(copySymbol);
            } else {
                copy.symbol = null;
            }
            if (this.isSetStyle()) {
                String sourceStyle;
                sourceStyle = this.getStyle();
                String copyStyle = ((String) strategy.copy(LocatorUtils.property(locator, "style", sourceStyle), sourceStyle));
                copy.setStyle(copyStyle);
            } else {
                copy.style = null;
            }
            if (this.isSetLabelStyle()) {
                LabelStylePropertyType sourceLabelStyle;
                sourceLabelStyle = this.getLabelStyle();
                LabelStylePropertyType copyLabelStyle = ((LabelStylePropertyType) strategy.copy(LocatorUtils.property(locator, "labelStyle", sourceLabelStyle), sourceLabelStyle));
                copy.setLabelStyle(copyLabelStyle);
            } else {
                copy.labelStyle = null;
            }
            if (this.isSetTopologyProperty()) {
                String sourceTopologyProperty;
                sourceTopologyProperty = this.getTopologyProperty();
                String copyTopologyProperty = ((String) strategy.copy(LocatorUtils.property(locator, "topologyProperty", sourceTopologyProperty), sourceTopologyProperty));
                copy.setTopologyProperty(copyTopologyProperty);
            } else {
                copy.topologyProperty = null;
            }
            if (this.isSetTopologyType()) {
                String sourceTopologyType;
                sourceTopologyType = this.getTopologyType();
                String copyTopologyType = ((String) strategy.copy(LocatorUtils.property(locator, "topologyType", sourceTopologyType), sourceTopologyType));
                copy.setTopologyType(copyTopologyType);
            } else {
                copy.topologyType = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new TopologyStyleType();
    }

}