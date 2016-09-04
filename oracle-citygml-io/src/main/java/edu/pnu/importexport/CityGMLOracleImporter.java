package edu.pnu.importexport;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.helpers.DefaultValidationEventHandler;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.pnu.common.BindingNode;
import edu.pnu.common.SymbolListener;
import edu.pnu.common.XLinkSymbolMap;
import edu.pnu.importexport.store.convert.CityGMLVOConvertUtil;
import edu.pnu.importexport.store.traversal.JCoreTraversalUtil;
import net.opengis.citygml.v_2_0.CityModelType;
import net.opengis.citygml.v_2_0.dao.core.CityModelDAO;
import net.opengis.citygml.v_2_0.vo.core.CityModel;
import net.opengis.gml.v_3_1_1.AbstractGMLType;

/**
 * 
 */

/**
 * @author hgryoo
 *
 */

public class CityGMLOracleImporter {
	private XLinkSymbolMap mXLinkSymbolMap;
	
	public void importCityGML(Properties props, String id, String filePath) throws Exception {
		
		if(id == null || id == "") {
			throw new IllegalArgumentException(id);
		}
		
		String resource = "conf/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);

		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader, props);
		SqlSession session = ssf.openSession();
		
		CityModelType testCityModelType = unmarshalCityModel(filePath);
		XLinkSymbolMap symbolMap = mXLinkSymbolMap;

		BindingNode node = new BindingNode();
		node = JCoreTraversalUtil.convertCityModelType(testCityModelType, node, symbolMap);

		CityModel inputCityModel = CityGMLVOConvertUtil.createCityModel(node);
		inputCityModel.setsId(id);
		
		try {
			CityModelDAO.insertCityModel(session, inputCityModel);
			session.commit();
			session.close();
		} catch (Exception e) {
			session.rollback();
			session.close();
			throw e;
		}
	}
	
	public CityModelType unmarshalCityModel(String path) throws JAXBException, IOException {
		
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
		SymbolListener listener = new SymbolListener(AbstractGMLType.class);
		unmarshaller.setListener(listener);
		unmarshaller.setEventHandler( new DefaultValidationEventHandler() );

		File input = new File(path);
		context.createJAXBIntrospector();
		//CityModelType testCityModel = (CityModelType) ((JAXBElement<?>) unmarshaller.unmarshal(new StreamSource(input))).getValue();
		CityModelType cityModel = (CityModelType) JAXBIntrospector.getValue(unmarshaller.unmarshal(input));
		this.mXLinkSymbolMap = listener.getSymbolMap();
		
		return cityModel;
	}
}
