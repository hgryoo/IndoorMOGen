package edu.pnu.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;

import edu.pnu.common.geometry.CommonGeometryFactory;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.importexport.CityGMLOracleManager;

public class GenerateMO {
	public List<STPoint> createMovingObjects(List<STPoint> polyLineValue, int velocity){
		final int SIGMA = 5;
		final int CHOOSECOUNT = 5;
		
		CommonGeometryFactory gf = new CommonGeometryFactory(true, false);
		CityGMLOracleManager manager = CityGMLOracleManager.getManager();
		Properties props = new Properties();
		props.put("driver", "oracle.jdbc.driver.OracleDriver");
		props.put("url", "jdbc:oracle:thin:@//localhost:1521/test");
		props.put("username", "system");
		props.put("password", "STEM9987");
		SqlSession session = null;
		try {
			session = manager.createSession(props);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < polyLineValue.size(); i++){
			STPoint internalPoint = polyLineValue.get(i);
			internalPoint = addNoise(session, gf, internalPoint, SIGMA, CHOOSECOUNT);
			polyLineValue.set(i, internalPoint);
		}
		
		List<STPoint> moList = new ArrayList<STPoint>();
		for(int i = 0; i < polyLineValue.size() -1; i++){
			STPoint preP = polyLineValue.get(i);
			STPoint nextP = polyLineValue.get(i + 1);
			Double tempInternalLength = Math.sqrt(Math.pow((preP.X() - nextP.X()), 2) + Math.pow((preP.Y() - nextP.Y()), 2));
			
			int internalPointCount = (int) (tempInternalLength / velocity);
			if(internalPointCount != 0){
				double offsetX = velocity * (nextP.X() - preP.X()) / tempInternalLength;
				double offsetY = velocity * (nextP.Y() - preP.Y()) / tempInternalLength;
				
				for(int j = 0; j < internalPointCount; j++){
					STPoint internalP = gf.createPoint(new double[] {preP.X() + offsetX*j, preP.Y() + offsetY*j, preP.Z()});
					moList.add(internalP);
				}	
			}
			else{
				moList.add(preP);
			}
		}
		
		return moList;
	}
	
	private static double randomRange(double n1, double n2) {
	    return (Math.random() * (n2 - n1 + 1)) + n1;
	}
	
	private STPoint addNoise(SqlSession session, CommonGeometryFactory gf, STPoint orginP, final double sigma, final int chooseCount){
		QueryModule queryModule = new QueryModule();
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
		
		try {
			int beforeCellId = queryModule.intersectRoomByPoint(session, "Test Data", orginP);
			int afterCellId =  queryModule.intersectRoomByPoint(session, "Test Data", newPoint);
			while(beforeCellId != afterCellId){
				errorOffSetX = errorOffSetX / 2;
				errorOffSetY = errorOffSetY / 2;
				newPoint = gf.createPoint(new double[] {orginP.X() + errorOffSetX, orginP.Y() + errorOffSetY, orginP.Z()});
				afterCellId =  queryModule.intersectRoomByPoint(session, "Test Data", newPoint);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newPoint;
	}
}
