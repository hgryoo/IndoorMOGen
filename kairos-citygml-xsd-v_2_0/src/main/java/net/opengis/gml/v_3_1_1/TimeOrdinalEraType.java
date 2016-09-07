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
 * Ordinal temporal reference systems are often hierarchically structured 
 *       such that an ordinal era at a given level of the hierarchy includes a 
 *       sequence of shorter, coterminous ordinal eras. This captured using the member/group properties.  
 *       
 *       Note that in this schema, TIme Ordinal Era is patterned on TimeEdge, which is a variation from ISO 19108.  
 *       This is in order to fulfill the requirements of ordinal reference systems based on eras delimited by 
 *       named points or nodes, which are common in geology, archeology, etc.  
 *       
 *       This change is subject of a change proposal to ISO
 * 
 * <p>Java class for TimeOrdinalEraType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeOrdinalEraType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}DefinitionType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="relatedTime" type="{http://www.opengis.net/gml}RelatedTimeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="start" type="{http://www.opengis.net/gml}TimeNodePropertyType"/&gt;
 *         &lt;element name="end" type="{http://www.opengis.net/gml}TimeNodePropertyType"/&gt;
 *         &lt;element name="extent" type="{http://www.opengis.net/gml}TimePeriodPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="member" type="{http://www.opengis.net/gml}TimeOrdinalEraPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="group" type="{http://www.opengis.net/gml}ReferenceType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeOrdinalEraType", propOrder = {
    "relatedTime",
    "start",
    "end",
    "extent",
    "member",
    "group"
})
public class TimeOrdinalEraType
    extends DefinitionType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    protected List<RelatedTimeType> relatedTime;
    @XmlElement(required = true)
    protected TimeNodePropertyType start;
    @XmlElement(required = true)
    protected TimeNodePropertyType end;
    protected TimePeriodPropertyType extent;
    protected List<TimeOrdinalEraPropertyType> member;
    protected ReferenceType group;

    /**
     * Gets the value of the relatedTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedTimeType }
     * 
     * 
     */
    public List<RelatedTimeType> getRelatedTime() {
        if (relatedTime == null) {
            relatedTime = new ArrayList<RelatedTimeType>();
        }
        return this.relatedTime;
    }

    public boolean isSetRelatedTime() {
        return ((this.relatedTime!= null)&&(!this.relatedTime.isEmpty()));
    }

    public void unsetRelatedTime() {
        this.relatedTime = null;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return
     *     possible object is
     *     {@link TimeNodePropertyType }
     *     
     */
    public TimeNodePropertyType getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeNodePropertyType }
     *     
     */
    public void setStart(TimeNodePropertyType value) {
        this.start = value;
    }

    public boolean isSetStart() {
        return (this.start!= null);
    }

    /**
     * Gets the value of the end property.
     * 
     * @return
     *     possible object is
     *     {@link TimeNodePropertyType }
     *     
     */
    public TimeNodePropertyType getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeNodePropertyType }
     *     
     */
    public void setEnd(TimeNodePropertyType value) {
        this.end = value;
    }

    public boolean isSetEnd() {
        return (this.end!= null);
    }

    /**
     * Gets the value of the extent property.
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodPropertyType }
     *     
     */
    public TimePeriodPropertyType getExtent() {
        return extent;
    }

    /**
     * Sets the value of the extent property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodPropertyType }
     *     
     */
    public void setExtent(TimePeriodPropertyType value) {
        this.extent = value;
    }

    public boolean isSetExtent() {
        return (this.extent!= null);
    }

    /**
     * Gets the value of the member property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the member property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TimeOrdinalEraPropertyType }
     * 
     * 
     */
    public List<TimeOrdinalEraPropertyType> getMember() {
        if (member == null) {
            member = new ArrayList<TimeOrdinalEraPropertyType>();
        }
        return this.member;
    }

    public boolean isSetMember() {
        return ((this.member!= null)&&(!this.member.isEmpty()));
    }

    public void unsetMember() {
        this.member = null;
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setGroup(ReferenceType value) {
        this.group = value;
    }

    public boolean isSetGroup() {
        return (this.group!= null);
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
            List<RelatedTimeType> theRelatedTime;
            theRelatedTime = (this.isSetRelatedTime()?this.getRelatedTime():null);
            strategy.appendField(locator, this, "relatedTime", buffer, theRelatedTime);
        }
        {
            TimeNodePropertyType theStart;
            theStart = this.getStart();
            strategy.appendField(locator, this, "start", buffer, theStart);
        }
        {
            TimeNodePropertyType theEnd;
            theEnd = this.getEnd();
            strategy.appendField(locator, this, "end", buffer, theEnd);
        }
        {
            TimePeriodPropertyType theExtent;
            theExtent = this.getExtent();
            strategy.appendField(locator, this, "extent", buffer, theExtent);
        }
        {
            List<TimeOrdinalEraPropertyType> theMember;
            theMember = (this.isSetMember()?this.getMember():null);
            strategy.appendField(locator, this, "member", buffer, theMember);
        }
        {
            ReferenceType theGroup;
            theGroup = this.getGroup();
            strategy.appendField(locator, this, "group", buffer, theGroup);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TimeOrdinalEraType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final TimeOrdinalEraType that = ((TimeOrdinalEraType) object);
        {
            List<RelatedTimeType> lhsRelatedTime;
            lhsRelatedTime = (this.isSetRelatedTime()?this.getRelatedTime():null);
            List<RelatedTimeType> rhsRelatedTime;
            rhsRelatedTime = (that.isSetRelatedTime()?that.getRelatedTime():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "relatedTime", lhsRelatedTime), LocatorUtils.property(thatLocator, "relatedTime", rhsRelatedTime), lhsRelatedTime, rhsRelatedTime)) {
                return false;
            }
        }
        {
            TimeNodePropertyType lhsStart;
            lhsStart = this.getStart();
            TimeNodePropertyType rhsStart;
            rhsStart = that.getStart();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "start", lhsStart), LocatorUtils.property(thatLocator, "start", rhsStart), lhsStart, rhsStart)) {
                return false;
            }
        }
        {
            TimeNodePropertyType lhsEnd;
            lhsEnd = this.getEnd();
            TimeNodePropertyType rhsEnd;
            rhsEnd = that.getEnd();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "end", lhsEnd), LocatorUtils.property(thatLocator, "end", rhsEnd), lhsEnd, rhsEnd)) {
                return false;
            }
        }
        {
            TimePeriodPropertyType lhsExtent;
            lhsExtent = this.getExtent();
            TimePeriodPropertyType rhsExtent;
            rhsExtent = that.getExtent();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "extent", lhsExtent), LocatorUtils.property(thatLocator, "extent", rhsExtent), lhsExtent, rhsExtent)) {
                return false;
            }
        }
        {
            List<TimeOrdinalEraPropertyType> lhsMember;
            lhsMember = (this.isSetMember()?this.getMember():null);
            List<TimeOrdinalEraPropertyType> rhsMember;
            rhsMember = (that.isSetMember()?that.getMember():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "member", lhsMember), LocatorUtils.property(thatLocator, "member", rhsMember), lhsMember, rhsMember)) {
                return false;
            }
        }
        {
            ReferenceType lhsGroup;
            lhsGroup = this.getGroup();
            ReferenceType rhsGroup;
            rhsGroup = that.getGroup();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "group", lhsGroup), LocatorUtils.property(thatLocator, "group", rhsGroup), lhsGroup, rhsGroup)) {
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
            List<RelatedTimeType> theRelatedTime;
            theRelatedTime = (this.isSetRelatedTime()?this.getRelatedTime():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "relatedTime", theRelatedTime), currentHashCode, theRelatedTime);
        }
        {
            TimeNodePropertyType theStart;
            theStart = this.getStart();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "start", theStart), currentHashCode, theStart);
        }
        {
            TimeNodePropertyType theEnd;
            theEnd = this.getEnd();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "end", theEnd), currentHashCode, theEnd);
        }
        {
            TimePeriodPropertyType theExtent;
            theExtent = this.getExtent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "extent", theExtent), currentHashCode, theExtent);
        }
        {
            List<TimeOrdinalEraPropertyType> theMember;
            theMember = (this.isSetMember()?this.getMember():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "member", theMember), currentHashCode, theMember);
        }
        {
            ReferenceType theGroup;
            theGroup = this.getGroup();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "group", theGroup), currentHashCode, theGroup);
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
        if (draftCopy instanceof TimeOrdinalEraType) {
            final TimeOrdinalEraType copy = ((TimeOrdinalEraType) draftCopy);
            if (this.isSetRelatedTime()) {
                List<RelatedTimeType> sourceRelatedTime;
                sourceRelatedTime = (this.isSetRelatedTime()?this.getRelatedTime():null);
                @SuppressWarnings("unchecked")
                List<RelatedTimeType> copyRelatedTime = ((List<RelatedTimeType> ) strategy.copy(LocatorUtils.property(locator, "relatedTime", sourceRelatedTime), sourceRelatedTime));
                copy.unsetRelatedTime();
                if (copyRelatedTime!= null) {
                    List<RelatedTimeType> uniqueRelatedTimel = copy.getRelatedTime();
                    uniqueRelatedTimel.addAll(copyRelatedTime);
                }
            } else {
                copy.unsetRelatedTime();
            }
            if (this.isSetStart()) {
                TimeNodePropertyType sourceStart;
                sourceStart = this.getStart();
                TimeNodePropertyType copyStart = ((TimeNodePropertyType) strategy.copy(LocatorUtils.property(locator, "start", sourceStart), sourceStart));
                copy.setStart(copyStart);
            } else {
                copy.start = null;
            }
            if (this.isSetEnd()) {
                TimeNodePropertyType sourceEnd;
                sourceEnd = this.getEnd();
                TimeNodePropertyType copyEnd = ((TimeNodePropertyType) strategy.copy(LocatorUtils.property(locator, "end", sourceEnd), sourceEnd));
                copy.setEnd(copyEnd);
            } else {
                copy.end = null;
            }
            if (this.isSetExtent()) {
                TimePeriodPropertyType sourceExtent;
                sourceExtent = this.getExtent();
                TimePeriodPropertyType copyExtent = ((TimePeriodPropertyType) strategy.copy(LocatorUtils.property(locator, "extent", sourceExtent), sourceExtent));
                copy.setExtent(copyExtent);
            } else {
                copy.extent = null;
            }
            if (this.isSetMember()) {
                List<TimeOrdinalEraPropertyType> sourceMember;
                sourceMember = (this.isSetMember()?this.getMember():null);
                @SuppressWarnings("unchecked")
                List<TimeOrdinalEraPropertyType> copyMember = ((List<TimeOrdinalEraPropertyType> ) strategy.copy(LocatorUtils.property(locator, "member", sourceMember), sourceMember));
                copy.unsetMember();
                if (copyMember!= null) {
                    List<TimeOrdinalEraPropertyType> uniqueMemberl = copy.getMember();
                    uniqueMemberl.addAll(copyMember);
                }
            } else {
                copy.unsetMember();
            }
            if (this.isSetGroup()) {
                ReferenceType sourceGroup;
                sourceGroup = this.getGroup();
                ReferenceType copyGroup = ((ReferenceType) strategy.copy(LocatorUtils.property(locator, "group", sourceGroup), sourceGroup));
                copy.setGroup(copyGroup);
            } else {
                copy.group = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new TimeOrdinalEraType();
    }

}