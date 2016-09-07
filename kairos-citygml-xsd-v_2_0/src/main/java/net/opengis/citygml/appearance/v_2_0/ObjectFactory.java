//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 10:41:43 AM KST 
//


package net.opengis.citygml.appearance.v_2_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.opengis.gml.v_3_1_1.FeaturePropertyType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml.appearance.v_2_0 package. 
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

    private final static QName _Appearance_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "Appearance");
    private final static QName _GenericApplicationPropertyOfAppearance_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfAppearance");
    private final static QName _AppearanceMember_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "appearanceMember");
    private final static QName _AAppearance_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "appearance");
    private final static QName _SurfaceData_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_SurfaceData");
    private final static QName _GenericApplicationPropertyOfSurfaceData_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfSurfaceData");
    private final static QName _Texture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_Texture");
    private final static QName _GenericApplicationPropertyOfTexture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfTexture");
    private final static QName _ParameterizedTexture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "ParameterizedTexture");
    private final static QName _GenericApplicationPropertyOfParameterizedTexture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfParameterizedTexture");
    private final static QName _GeoreferencedTexture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "GeoreferencedTexture");
    private final static QName _GenericApplicationPropertyOfGeoreferencedTexture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfGeoreferencedTexture");
    private final static QName _TextureParameterization_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_TextureParameterization");
    private final static QName _GenericApplicationPropertyOfTextureParameterization_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfTextureParameterization");
    private final static QName _TexCoordList_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "TexCoordList");
    private final static QName _GenericApplicationPropertyOfTexCoordList_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfTexCoordList");
    private final static QName _TexCoordGen_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "TexCoordGen");
    private final static QName _GenericApplicationPropertyOfTexCoordGen_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfTexCoordGen");
    private final static QName _X3DMaterial_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "X3DMaterial");
    private final static QName _GenericApplicationPropertyOfX3DMaterial_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfX3DMaterial");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml.appearance.v_2_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TexCoordGenType }
     * 
     */
    public TexCoordGenType createTexCoordGenType() {
        return new TexCoordGenType();
    }

    /**
     * Create an instance of {@link TexCoordListType }
     * 
     */
    public TexCoordListType createTexCoordListType() {
        return new TexCoordListType();
    }

    /**
     * Create an instance of {@link AppearanceType }
     * 
     */
    public AppearanceType createAppearanceType() {
        return new AppearanceType();
    }

    /**
     * Create an instance of {@link AppearancePropertyType }
     * 
     */
    public AppearancePropertyType createAppearancePropertyType() {
        return new AppearancePropertyType();
    }

    /**
     * Create an instance of {@link ParameterizedTextureType }
     * 
     */
    public ParameterizedTextureType createParameterizedTextureType() {
        return new ParameterizedTextureType();
    }

    /**
     * Create an instance of {@link GeoreferencedTextureType }
     * 
     */
    public GeoreferencedTextureType createGeoreferencedTextureType() {
        return new GeoreferencedTextureType();
    }

    /**
     * Create an instance of {@link X3DMaterialType }
     * 
     */
    public X3DMaterialType createX3DMaterialType() {
        return new X3DMaterialType();
    }

    /**
     * Create an instance of {@link SurfaceDataPropertyType }
     * 
     */
    public SurfaceDataPropertyType createSurfaceDataPropertyType() {
        return new SurfaceDataPropertyType();
    }

    /**
     * Create an instance of {@link TextureAssociationType }
     * 
     */
    public TextureAssociationType createTextureAssociationType() {
        return new TextureAssociationType();
    }

    /**
     * Create an instance of {@link TexCoordGenType.WorldToTexture }
     * 
     */
    public TexCoordGenType.WorldToTexture createTexCoordGenTypeWorldToTexture() {
        return new TexCoordGenType.WorldToTexture();
    }

    /**
     * Create an instance of {@link TexCoordListType.TextureCoordinates }
     * 
     */
    public TexCoordListType.TextureCoordinates createTexCoordListTypeTextureCoordinates() {
        return new TexCoordListType.TextureCoordinates();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppearanceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "Appearance", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Feature")
    public JAXBElement<AppearanceType> createAppearance(AppearanceType value) {
        return new JAXBElement<AppearanceType>(_Appearance_QNAME, AppearanceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfAppearance")
    public JAXBElement<Object> createGenericApplicationPropertyOfAppearance(Object value) {
        return new JAXBElement<Object>(_GenericApplicationPropertyOfAppearance_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "appearanceMember", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "featureMember")
    public JAXBElement<FeaturePropertyType> createAppearanceMember(FeaturePropertyType value) {
        return new JAXBElement<FeaturePropertyType>(_AppearanceMember_QNAME, FeaturePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppearancePropertyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "appearance", substitutionHeadNamespace = "http://www.opengis.net/citygml/2.0", substitutionHeadName = "_GenericApplicationPropertyOfCityObject")
    public JAXBElement<AppearancePropertyType> createAAppearance(AppearancePropertyType value) {
        return new JAXBElement<AppearancePropertyType>(_AAppearance_QNAME, AppearancePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractSurfaceDataType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_SurfaceData", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Feature")
    public JAXBElement<AbstractSurfaceDataType> createSurfaceData(AbstractSurfaceDataType value) {
        return new JAXBElement<AbstractSurfaceDataType>(_SurfaceData_QNAME, AbstractSurfaceDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfSurfaceData")
    public JAXBElement<Object> createGenericApplicationPropertyOfSurfaceData(Object value) {
        return new JAXBElement<Object>(_GenericApplicationPropertyOfSurfaceData_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTextureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_Texture", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_SurfaceData")
    public JAXBElement<AbstractTextureType> createTexture(AbstractTextureType value) {
        return new JAXBElement<AbstractTextureType>(_Texture_QNAME, AbstractTextureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfTexture")
    public JAXBElement<Object> createGenericApplicationPropertyOfTexture(Object value) {
        return new JAXBElement<Object>(_GenericApplicationPropertyOfTexture_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterizedTextureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "ParameterizedTexture", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_Texture")
    public JAXBElement<ParameterizedTextureType> createParameterizedTexture(ParameterizedTextureType value) {
        return new JAXBElement<ParameterizedTextureType>(_ParameterizedTexture_QNAME, ParameterizedTextureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfParameterizedTexture")
    public JAXBElement<Object> createGenericApplicationPropertyOfParameterizedTexture(Object value) {
        return new JAXBElement<Object>(_GenericApplicationPropertyOfParameterizedTexture_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoreferencedTextureType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "GeoreferencedTexture", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_Texture")
    public JAXBElement<GeoreferencedTextureType> createGeoreferencedTexture(GeoreferencedTextureType value) {
        return new JAXBElement<GeoreferencedTextureType>(_GeoreferencedTexture_QNAME, GeoreferencedTextureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfGeoreferencedTexture")
    public JAXBElement<Object> createGenericApplicationPropertyOfGeoreferencedTexture(Object value) {
        return new JAXBElement<Object>(_GenericApplicationPropertyOfGeoreferencedTexture_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTextureParameterizationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_TextureParameterization", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<AbstractTextureParameterizationType> createTextureParameterization(AbstractTextureParameterizationType value) {
        return new JAXBElement<AbstractTextureParameterizationType>(_TextureParameterization_QNAME, AbstractTextureParameterizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfTextureParameterization")
    public JAXBElement<Object> createGenericApplicationPropertyOfTextureParameterization(Object value) {
        return new JAXBElement<Object>(_GenericApplicationPropertyOfTextureParameterization_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TexCoordListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "TexCoordList", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_TextureParameterization")
    public JAXBElement<TexCoordListType> createTexCoordList(TexCoordListType value) {
        return new JAXBElement<TexCoordListType>(_TexCoordList_QNAME, TexCoordListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfTexCoordList")
    public JAXBElement<Object> createGenericApplicationPropertyOfTexCoordList(Object value) {
        return new JAXBElement<Object>(_GenericApplicationPropertyOfTexCoordList_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TexCoordGenType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "TexCoordGen", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_TextureParameterization")
    public JAXBElement<TexCoordGenType> createTexCoordGen(TexCoordGenType value) {
        return new JAXBElement<TexCoordGenType>(_TexCoordGen_QNAME, TexCoordGenType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfTexCoordGen")
    public JAXBElement<Object> createGenericApplicationPropertyOfTexCoordGen(Object value) {
        return new JAXBElement<Object>(_GenericApplicationPropertyOfTexCoordGen_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link X3DMaterialType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "X3DMaterial", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_SurfaceData")
    public JAXBElement<X3DMaterialType> createX3DMaterial(X3DMaterialType value) {
        return new JAXBElement<X3DMaterialType>(_X3DMaterial_QNAME, X3DMaterialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfX3DMaterial")
    public JAXBElement<Object> createGenericApplicationPropertyOfX3DMaterial(Object value) {
        return new JAXBElement<Object>(_GenericApplicationPropertyOfX3DMaterial_QNAME, Object.class, null, value);
    }

}