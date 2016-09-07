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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 * <p>Java class for RangeSetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RangeSetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}ValueArray" maxOccurs="unbounded"/&gt;
 *         &lt;group ref="{http://www.opengis.net/gml}ScalarValueList" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}DataBlock"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}File"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RangeSetType", propOrder = {
    "valueArray",
    "scalarValueList",
    "dataBlock",
    "file"
})
public class RangeSetType
    implements Cloneable, CopyTo, Equals, HashCode, ToString
{

    @XmlElement(name = "ValueArray")
    protected List<ValueArrayType> valueArray;
    @XmlElementRefs({
        @XmlElementRef(name = "CountList", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CategoryList", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BooleanList", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "QuantityList", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> scalarValueList;
    @XmlElement(name = "DataBlock")
    protected DataBlockType dataBlock;
    @XmlElement(name = "File")
    protected FileType file;

    /**
     * each member _Value holds a tuple or "row" from the equivalent table Gets the value of the valueArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueArrayType }
     * 
     * 
     */
    public List<ValueArrayType> getValueArray() {
        if (valueArray == null) {
            valueArray = new ArrayList<ValueArrayType>();
        }
        return this.valueArray;
    }

    public boolean isSetValueArray() {
        return ((this.valueArray!= null)&&(!this.valueArray.isEmpty()));
    }

    public void unsetValueArray() {
        this.valueArray = null;
    }

    /**
     * each list holds the complete set of one scalar component from the values - i.e. a "column" from the equivalent table Gets the value of the scalarValueList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scalarValueList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScalarValueList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link CodeOrNullListType }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link MeasureOrNullListType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getScalarValueList() {
        if (scalarValueList == null) {
            scalarValueList = new ArrayList<JAXBElement<?>>();
        }
        return this.scalarValueList;
    }

    public boolean isSetScalarValueList() {
        return ((this.scalarValueList!= null)&&(!this.scalarValueList.isEmpty()));
    }

    public void unsetScalarValueList() {
        this.scalarValueList = null;
    }

    /**
     * Its tuple list holds the values as space-separated tuples each of which contains comma-separated components, and the tuple structure is specified using the rangeParameters property.
     * 
     * @return
     *     possible object is
     *     {@link DataBlockType }
     *     
     */
    public DataBlockType getDataBlock() {
        return dataBlock;
    }

    /**
     * Sets the value of the dataBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataBlockType }
     *     
     */
    public void setDataBlock(DataBlockType value) {
        this.dataBlock = value;
    }

    public boolean isSetDataBlock() {
        return (this.dataBlock!= null);
    }

    /**
     * a reference to an external source for the data, together with a description of how that external source is structured
     * 
     * @return
     *     possible object is
     *     {@link FileType }
     *     
     */
    public FileType getFile() {
        return file;
    }

    /**
     * Sets the value of the file property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileType }
     *     
     */
    public void setFile(FileType value) {
        this.file = value;
    }

    public boolean isSetFile() {
        return (this.file!= null);
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
            List<ValueArrayType> theValueArray;
            theValueArray = (this.isSetValueArray()?this.getValueArray():null);
            strategy.appendField(locator, this, "valueArray", buffer, theValueArray);
        }
        {
            List<JAXBElement<?>> theScalarValueList;
            theScalarValueList = (this.isSetScalarValueList()?this.getScalarValueList():null);
            strategy.appendField(locator, this, "scalarValueList", buffer, theScalarValueList);
        }
        {
            DataBlockType theDataBlock;
            theDataBlock = this.getDataBlock();
            strategy.appendField(locator, this, "dataBlock", buffer, theDataBlock);
        }
        {
            FileType theFile;
            theFile = this.getFile();
            strategy.appendField(locator, this, "file", buffer, theFile);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof RangeSetType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final RangeSetType that = ((RangeSetType) object);
        {
            List<ValueArrayType> lhsValueArray;
            lhsValueArray = (this.isSetValueArray()?this.getValueArray():null);
            List<ValueArrayType> rhsValueArray;
            rhsValueArray = (that.isSetValueArray()?that.getValueArray():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "valueArray", lhsValueArray), LocatorUtils.property(thatLocator, "valueArray", rhsValueArray), lhsValueArray, rhsValueArray)) {
                return false;
            }
        }
        {
            List<JAXBElement<?>> lhsScalarValueList;
            lhsScalarValueList = (this.isSetScalarValueList()?this.getScalarValueList():null);
            List<JAXBElement<?>> rhsScalarValueList;
            rhsScalarValueList = (that.isSetScalarValueList()?that.getScalarValueList():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "scalarValueList", lhsScalarValueList), LocatorUtils.property(thatLocator, "scalarValueList", rhsScalarValueList), lhsScalarValueList, rhsScalarValueList)) {
                return false;
            }
        }
        {
            DataBlockType lhsDataBlock;
            lhsDataBlock = this.getDataBlock();
            DataBlockType rhsDataBlock;
            rhsDataBlock = that.getDataBlock();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "dataBlock", lhsDataBlock), LocatorUtils.property(thatLocator, "dataBlock", rhsDataBlock), lhsDataBlock, rhsDataBlock)) {
                return false;
            }
        }
        {
            FileType lhsFile;
            lhsFile = this.getFile();
            FileType rhsFile;
            rhsFile = that.getFile();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "file", lhsFile), LocatorUtils.property(thatLocator, "file", rhsFile), lhsFile, rhsFile)) {
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
            List<ValueArrayType> theValueArray;
            theValueArray = (this.isSetValueArray()?this.getValueArray():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "valueArray", theValueArray), currentHashCode, theValueArray);
        }
        {
            List<JAXBElement<?>> theScalarValueList;
            theScalarValueList = (this.isSetScalarValueList()?this.getScalarValueList():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "scalarValueList", theScalarValueList), currentHashCode, theScalarValueList);
        }
        {
            DataBlockType theDataBlock;
            theDataBlock = this.getDataBlock();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "dataBlock", theDataBlock), currentHashCode, theDataBlock);
        }
        {
            FileType theFile;
            theFile = this.getFile();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "file", theFile), currentHashCode, theFile);
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
        if (draftCopy instanceof RangeSetType) {
            final RangeSetType copy = ((RangeSetType) draftCopy);
            if (this.isSetValueArray()) {
                List<ValueArrayType> sourceValueArray;
                sourceValueArray = (this.isSetValueArray()?this.getValueArray():null);
                @SuppressWarnings("unchecked")
                List<ValueArrayType> copyValueArray = ((List<ValueArrayType> ) strategy.copy(LocatorUtils.property(locator, "valueArray", sourceValueArray), sourceValueArray));
                copy.unsetValueArray();
                if (copyValueArray!= null) {
                    List<ValueArrayType> uniqueValueArrayl = copy.getValueArray();
                    uniqueValueArrayl.addAll(copyValueArray);
                }
            } else {
                copy.unsetValueArray();
            }
            if (this.isSetScalarValueList()) {
                List<JAXBElement<?>> sourceScalarValueList;
                sourceScalarValueList = (this.isSetScalarValueList()?this.getScalarValueList():null);
                @SuppressWarnings("unchecked")
                List<JAXBElement<?>> copyScalarValueList = ((List<JAXBElement<?>> ) strategy.copy(LocatorUtils.property(locator, "scalarValueList", sourceScalarValueList), sourceScalarValueList));
                copy.unsetScalarValueList();
                if (copyScalarValueList!= null) {
                    List<JAXBElement<?>> uniqueScalarValueListl = copy.getScalarValueList();
                    uniqueScalarValueListl.addAll(copyScalarValueList);
                }
            } else {
                copy.unsetScalarValueList();
            }
            if (this.isSetDataBlock()) {
                DataBlockType sourceDataBlock;
                sourceDataBlock = this.getDataBlock();
                DataBlockType copyDataBlock = ((DataBlockType) strategy.copy(LocatorUtils.property(locator, "dataBlock", sourceDataBlock), sourceDataBlock));
                copy.setDataBlock(copyDataBlock);
            } else {
                copy.dataBlock = null;
            }
            if (this.isSetFile()) {
                FileType sourceFile;
                sourceFile = this.getFile();
                FileType copyFile = ((FileType) strategy.copy(LocatorUtils.property(locator, "file", sourceFile), sourceFile));
                copy.setFile(copyFile);
            } else {
                copy.file = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new RangeSetType();
    }

}