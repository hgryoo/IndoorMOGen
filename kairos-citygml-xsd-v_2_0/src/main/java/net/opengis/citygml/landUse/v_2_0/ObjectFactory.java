//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.landUse.v_2_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml.landUse.v_2_0 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LandUse_QNAME = new QName("http://www.opengis.net/citygml/landuse/2.0", "LandUse");
    private final static QName _GenericApplicationPropertyOfLandUse_QNAME = new QName("http://www.opengis.net/citygml/landuse/2.0", "_GenericApplicationPropertyOfLandUse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml.landUse.v_2_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LandUseType }
     * 
     */
    public LandUseType createLandUseType() {
        return new LandUseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LandUseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/landuse/2.0", name = "LandUse", substitutionHeadNamespace = "http://www.opengis.net/citygml/2.0", substitutionHeadName = "_CityObject")
    public JAXBElement<LandUseType> createLandUse(LandUseType value) {
        return new JAXBElement<LandUseType>(_LandUse_QNAME, LandUseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/landuse/2.0", name = "_GenericApplicationPropertyOfLandUse")
    public JAXBElement<Object> createGenericApplicationPropertyOfLandUse(Object value) {
        return new JAXBElement<Object>(_GenericApplicationPropertyOfLandUse_QNAME, Object.class, null, value);
    }

}
