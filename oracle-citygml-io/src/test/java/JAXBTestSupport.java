import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;

import org.apache.ibatis.io.Resources;

/**
 * @author hgryoo
 *
 */
public class JAXBTestSupport {
	
	public static Object unmarshal(String path) throws JAXBException, IOException {
		
		JAXBContext context = JAXBContext.newInstance(
				   "net.opengis.citygml.v_2_0"
				+ ":net.opengis.citygml.bridge.v_2_0"
				+ ":net.opengis.citygml.building.v_2_0"
				+ ":net.opengis.citygml.cityfurniture.v_2_0"
				+ ":net.opengis.citygml.cityobjectgroup.v_2_0"
				+ ":net.opengis.citygml.generics.v_2_0"
				+ ":net.opengis.citygml.landUse.v_2_0"
				+ ":net.opengis.citygml.relief.v_2_0"
				+ ":net.opengis.citygml.texturedsurface.v_2_0"
				+ ":net.opengis.citygml.transportation.v_2_0"
				+ ":net.opengis.citygml.tunnel.v_2_0"
				+ ":net.opengis.citygml.vegetation.v_2_0"
				+ ":net.opengis.citygml.waterbody.v_2_0"
				+ ":oasis.names.tc.ciq.xsdschema.xal"
				+ ":net.opengis.gml.v_3_1_1"
				+ ":org.w3.smil.v_2_0"
				+ ":org.w3.smil.v_2_0.language"
				+ ":org.w3.xlink"
		);
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setEventHandler( new DefaultValidationEventHandler() );

		File input = Resources.getResourceAsFile(path);
		context.createJAXBIntrospector();
		//CityModelType testCityModel = (CityModelType) ((JAXBElement<?>) unmarshaller.unmarshal(new StreamSource(input))).getValue();
		Object object = (Object) JAXBIntrospector.getValue(unmarshaller.unmarshal(input));
		
		return object;
	}
	
	
	

}
