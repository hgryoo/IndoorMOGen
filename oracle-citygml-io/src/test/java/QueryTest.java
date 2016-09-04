
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.pnu.common.BindingNode;
import edu.pnu.common.geometry.CommonGeometryFactory;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.model.STSolid;
import edu.pnu.common.geometry.utils.WKBGeometryParser;
import edu.pnu.importexport.CityGMLOracleExporter;
import edu.pnu.importexport.CityGMLOracleImporter;
import edu.pnu.importexport.CityGMLOracleManager;
import edu.pnu.importexport.retrieve.VOJAXBConvertUtil;
import edu.pnu.importexport.store.convert.CityGMLVOConvertUtil;
import edu.pnu.importexport.store.traversal.JCoreTraversalUtil;
import edu.pnu.query.QueryModule;
import net.opengis.citygml.v_2_0.CityModelType;
import net.opengis.citygml.v_2_0.dao.MapperNamespace;
import net.opengis.citygml.v_2_0.dao.spatial.EnvelopeDAO;
import net.opengis.citygml.v_2_0.vo.building.Building;
import net.opengis.citygml.v_2_0.vo.building.Room;
import net.opengis.citygml.v_2_0.vo.core.CityModel;
import net.opengis.citygml.v_2_0.vo.spatial.Envelope;
import oracle.spatial.geometry.J3D_Geometry;
import oracle.spatial.geometry.JGeometry;

/**
 * @author thkim
 *
 */
public class QueryTest {

	@Test
	public void roomIntersectTest() throws Exception {
		QueryModule queryModule = new QueryModule();
		
		// [Sample from File]
		/*
		SolidType testPolygon = (SolidType) JAXBTestSupport.unmarshal("test/query_sample.gml");
		BindingNode node = new BindingNode();
		node = JGMLTraversalUtil.traverseSolidType(testPolygon, node, null);
		STSolid solid = (STSolid) KairosGeometryConvertUtil.convertSolid(node);
		*/
		
		
		CommonGeometryFactory gf = new CommonGeometryFactory(true, false);
		WKBGeometryParser parser = WKBGeometryParser.getParser();
		
		CityGMLOracleManager manager = CityGMLOracleManager.getManager();
		Properties props = TestSupport.getDefaultProperties();
		SqlSession session = manager.createSession(props);
		
		// import pyramid data
		/*
		CityGMLPostGISImporter importer = new CityGMLPostGISImporter();
		String resource = "example/pyramid.gml";
		File file = Resources.getResourceAsFile(resource);
		importer.importCityGML(props, "Test Pyramid Data", file.getAbsolutePath());
		*/
		
		/*
		String testCityModelName = "Test Data";
		CityModel targetCityModel = session.selectOne(MapperNamespace.SELECT_CITYMODEL_BY_SID_NS, testCityModelName);
		session.commit();
			
		Envelope targetEnvelope = getEnvelope(gf, session, targetCityModel);
		
		STPoint lower = targetEnvelope.lowerCornerGeometry;
		STPoint upper = targetEnvelope.upperCornerGeometry;
		
		for(int i = 0; i < 10000; i++) {
			
			STPoint lowerRand = getRandPoint(gf, lower, upper);
			STPoint upperRand = getRandPoint(gf, lowerRand, upper);
			STSolid solid = gf.createBox3D(lowerRand, upperRand);
			
			queryModule.intersectRoom(session, testCityModelName, solid);
		}
		session.close();
		*/
		
		/* unmarshal query params */
		CityModelType testCityModelType = (CityModelType) JAXBTestSupport.unmarshal("example/rand_query.gml");
		BindingNode node = new BindingNode();
		node = JCoreTraversalUtil.convertCityModelType(testCityModelType, node, null);
		CityModel testModel = CityGMLVOConvertUtil.createCityModel(node);
		Building testBuilding = (Building) testModel.getCityObjects().get(0);
 		List<Room> testrooms = testBuilding.getRooms();
 				
		List<STSolid> querySolid = new ArrayList<STSolid>();
		for(Room r : testrooms) {
			STSolid solid = (STSolid) parser.parseWKB(r.getLod4Solid());
			querySolid.add(solid);
		}
		
		/* Test */
		long startTime = System.nanoTime();
		for(STSolid s : querySolid) {
			CityModel citymodel = queryModule.intersectRoom(session, "Test Pyramid Data", s);
			//System.out.println(citymodel.toString());
			//CityModelType cityModelType = VOJAXBConvertUtil.createCityModelType(null, citymodel);
			//CityGMLKairosExporter.marshalCityModel("target/test/query_result" + i + ".gml", cityModelType);
		}
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		System.out.println("total elapsed time = " + elapsedTime);
		
		session.close();
	}

	private Envelope getEnvelope(CommonGeometryFactory gf, SqlSession session, CityModel targetCityModel) {
		Envelope targetEnvelope = new Envelope();
		String selectEnvelope = "SELECT "
				+ " ID, SRS_NAME,SRS_DIMENSION,LOWER_CORNER, UPPER_CORNER "
				+ " FROM "
				+ " Envelope "
				+ " WHERE ID = " + targetCityModel.getId();
		
		Connection conn = session.getConnection();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(selectEnvelope);
			while(rs.next()) {
				int id = rs.getInt(1);	
				String srsname = rs.getString(2); 
				int srsDimension = rs.getInt(3);
				Struct lowerCornerObject = (Struct) rs.getObject(4);
				Struct upperCornerObject = (Struct) rs.getObject(5);
				JGeometry loweCornerGeometry = J3D_Geometry.loadJS(lowerCornerObject);
				JGeometry upperCornerGeometry = J3D_Geometry.loadJS(upperCornerObject);
				
				targetEnvelope.setId(id);
				targetEnvelope.setSrsName(srsname);
				targetEnvelope.setSrsDimension(srsDimension);
				 
				List<Double> coordinates = new ArrayList<Double>();
				coordinates.add(loweCornerGeometry.getLabelPointXYZ()[0]);
				coordinates.add(loweCornerGeometry.getLabelPointXYZ()[1]);
				coordinates.add(loweCornerGeometry.getLabelPointXYZ()[2]);
				targetEnvelope.lowerCornerGeometry = gf.createPoint(coordinates);
				coordinates.clear();
				coordinates.add(upperCornerGeometry.getLabelPointXYZ()[0]);
				coordinates.add(upperCornerGeometry.getLabelPointXYZ()[1]);
				coordinates.add(upperCornerGeometry.getLabelPointXYZ()[2]);
				targetEnvelope.upperCornerGeometry = gf.createPoint(coordinates);
			}
			statement.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return targetEnvelope;
	}
	
	private STPoint getRandPoint(CommonGeometryFactory gf, STPoint lower, STPoint upper) {
		
		double xrand = randomRange(lower.X(), upper.X());
		double yrand = randomRange(lower.Y(), upper.Y());
		double zrand = randomRange(lower.Z(), upper.Z());
		
		return gf.createPoint(new double[] { xrand, yrand, zrand } );
	}
	
	private static double randomRange(double n1, double n2) {
	    return (Math.random() * (n2 - n1 + 1)) + n1;
	}
	
	private STPoint addNoise(CommonGeometryFactory gf, STPoint orginP, final double sigma, final int chooseCount){
		Random random = new Random();
		
		double errorOffSetX = 0;
		double errorOffSetY = 0;
		for(int i = 0; i < chooseCount; i++){
			errorOffSetX += Math.cos(Math.toRadians(randomRange(0, 360)))*random.nextGaussian() * sigma;
			errorOffSetY += Math.sin(Math.toRadians(randomRange(0, 360)))*random.nextGaussian() * sigma;
		}
		
		errorOffSetX = errorOffSetX / chooseCount;
		errorOffSetY = errorOffSetY / chooseCount;
		
		STPoint newPoint = gf.createPoint(new double[] {orginP.X() + errorOffSetX, orginP.Y() + errorOffSetY, orginP.Z()});
		return newPoint;
	}

}
