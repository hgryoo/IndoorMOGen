//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.gml.v_3_1_1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SurfaceInterpolationType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SurfaceInterpolationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="none"/&gt;
 *     &lt;enumeration value="planar"/&gt;
 *     &lt;enumeration value="spherical"/&gt;
 *     &lt;enumeration value="elliptical"/&gt;
 *     &lt;enumeration value="conic"/&gt;
 *     &lt;enumeration value="tin"/&gt;
 *     &lt;enumeration value="parametricCurve"/&gt;
 *     &lt;enumeration value="polynomialSpline"/&gt;
 *     &lt;enumeration value="rationalSpline"/&gt;
 *     &lt;enumeration value="triangulatedSpline"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SurfaceInterpolationType")
@XmlEnum
public enum SurfaceInterpolationType {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("planar")
    PLANAR("planar"),
    @XmlEnumValue("spherical")
    SPHERICAL("spherical"),
    @XmlEnumValue("elliptical")
    ELLIPTICAL("elliptical"),
    @XmlEnumValue("conic")
    CONIC("conic"),
    @XmlEnumValue("tin")
    TIN("tin"),
    @XmlEnumValue("parametricCurve")
    PARAMETRIC_CURVE("parametricCurve"),
    @XmlEnumValue("polynomialSpline")
    POLYNOMIAL_SPLINE("polynomialSpline"),
    @XmlEnumValue("rationalSpline")
    RATIONAL_SPLINE("rationalSpline"),
    @XmlEnumValue("triangulatedSpline")
    TRIANGULATED_SPLINE("triangulatedSpline");
    private final String value;

    SurfaceInterpolationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SurfaceInterpolationType fromValue(String v) {
        for (SurfaceInterpolationType c: SurfaceInterpolationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
