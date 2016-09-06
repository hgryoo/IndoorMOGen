//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.gml.v_3_1_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AesheticCriteriaType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AesheticCriteriaType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MIN_CROSSINGS"/&gt;
 *     &lt;enumeration value="MIN_AREA"/&gt;
 *     &lt;enumeration value="MIN_BENDS"/&gt;
 *     &lt;enumeration value="MAX_BENDS"/&gt;
 *     &lt;enumeration value="UNIFORM_BENDS"/&gt;
 *     &lt;enumeration value="MIN_SLOPES"/&gt;
 *     &lt;enumeration value="MIN_EDGE_LENGTH"/&gt;
 *     &lt;enumeration value="MAX_EDGE_LENGTH"/&gt;
 *     &lt;enumeration value="UNIFORM_EDGE_LENGTH"/&gt;
 *     &lt;enumeration value="MAX_ANGULAR_RESOLUTION"/&gt;
 *     &lt;enumeration value="MIN_ASPECT_RATIO"/&gt;
 *     &lt;enumeration value="MAX_SYMMETRIES"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AesheticCriteriaType")
@XmlEnum
public enum AesheticCriteriaType {

    MIN_CROSSINGS,
    MIN_AREA,
    MIN_BENDS,
    MAX_BENDS,
    UNIFORM_BENDS,
    MIN_SLOPES,
    MIN_EDGE_LENGTH,
    MAX_EDGE_LENGTH,
    UNIFORM_EDGE_LENGTH,
    MAX_ANGULAR_RESOLUTION,
    MIN_ASPECT_RATIO,
    MAX_SYMMETRIES;

    public String value() {
        return name();
    }

    public static AesheticCriteriaType fromValue(String v) {
        return valueOf(v);
    }

}
