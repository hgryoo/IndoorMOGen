/**
 * 
 */
package edu.pnu.importexport;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.pnu.importexport.retrieve.VOJAXBConvertUtil;
import net.opengis.citygml.v_2_0.CityModelType;
import net.opengis.citygml.v_2_0.ObjectFactory;
import net.opengis.citygml.v_2_0.dao.core.CityModelDAO;
import net.opengis.citygml.v_2_0.vo.core.CityModel;

/**
 * @author hgryoo
 *
 */
public class CityGMLOracleExporter {
	
	public static void exportCityGML(Properties props, String id, String filePath) throws Exception {
		String resource = "conf/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);

		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader, props);
		SqlSession session = ssf.openSession();
		
		CityModel selectedCityModel;
		try {
			selectedCityModel = CityModelDAO.selectCityModel(session, id);
			session.close();
		} catch (Exception e) {
			session.close();
			throw e;
		}
		
		CityModelType cityModelType = VOJAXBConvertUtil.createCityModelType(null, selectedCityModel);
		
		marshalCityModel(filePath, cityModelType);
	}
	
	public static void marshalCityModel(String path, CityModelType cityModel) throws JAXBException, IOException {
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
		
		File output = null;
		
		if(path == null) {
			JFileChooser save = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Export CityGML Document", "gml");
			save.setFileFilter(filter);
			int result = save.showSaveDialog(null);
			if( result == JFileChooser.CANCEL_OPTION ) {
				System.exit(1);
			}
			output = save.getSelectedFile();
		} else {
			output = new File(path);
		}
		
		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<CityModelType> jCityModel = objectFactory.createCityModel(cityModel);
		
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, 
				"http://www.opengis.net/citygml/profiles/base/2.0 http://schemas.opengis.net/citygml/profiles/base/2.0/CityGML.xsd");
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
		
		marshaller.marshal( jCityModel, output );
	}
}
