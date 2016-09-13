package edu.pnu.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;

import com.vividsolutions.jts.geom.Coordinate;

import edu.pnu.common.geometry.CommonGeometryFactory;
import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.importexport.CityGMLOracleManager;

public class GenerateMO {
	static CommonGeometryFactory gf = new CommonGeometryFactory(true, false);
	static CityGMLOracleManager manager = CityGMLOracleManager.getManager();
	static Properties props = new Properties();
	static SqlSession session = null;
	static HashMap<Coordinate, Double> minimumDistance = null;
	private static void connectedDBMS(){
		props.put("driver", "oracle.jdbc.driver.OracleDriver");
		props.put("url", "jdbc:oracle:thin:@//localhost:1521/orcl");
		props.put("username", "system");
		props.put("password", "stem9987");
		
		try {
			session = manager.createSession(props);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void setMinErrorDistance(List<Coordinate> allTrajectoryPoints) throws Exception{
	    if(session == null)
	    	connectedDBMS();
	    QueryModule queryModule = new QueryModule();
		minimumDistance = queryModule.getMinimumDistanceMap(session, allTrajectoryPoints);
	}
	
	public static List<Coordinate> addNoiseToTrajectory(List<Coordinate> orginTrajectory){
		final int SIGMA = 2;
		final int CHOOSECOUNT = 5;
		
		if(session == null)
			connectedDBMS();
		
		for(int i = 1; i < orginTrajectory.size(); i++){
			Coordinate internalPoint = orginTrajectory.get(i);
			STPoint internalSTPoint = gf.createPoint(new double[] {internalPoint.x, internalPoint.y, internalPoint.z});
			//internalSTPoint = addNoise(session, gf, internalSTPoint, SIGMA, CHOOSECOUNT);
			try {
				internalSTPoint = addNoise(gf, internalPoint, SIGMA, CHOOSECOUNT);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			internalPoint.setCoordinate(new Coordinate(internalSTPoint.X(), internalSTPoint.Y(), internalSTPoint.Z()));
			orginTrajectory.set(i, internalPoint);
		}
		return orginTrajectory;
	}
	
	public static List<STPoint> createMovingObjects(List<STPoint> polyLineValue, int velocity){
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
			Double tempInternalLengthXYZ = Math.sqrt(Math.pow((preP.X() - nextP.X()), 2) + Math.pow((preP.Y() - nextP.Y()), 2)
				+ Math.pow((preP.Z() - nextP.Z()), 2));
			int internalPointCount = (int) (tempInternalLengthXYZ / velocity);
			if(internalPointCount != 0){
				Double tempInternalLengthXY = Math.sqrt(Math.pow((preP.X() - nextP.X()), 2) + Math.pow((preP.Y() - nextP.Y()), 2));
				double offsetZ = velocity * (nextP.Z() - preP.Z()) / tempInternalLengthXYZ;
				double offsetX_Y = velocity * (tempInternalLengthXY) / tempInternalLengthXYZ;
				double offsetX = offsetX_Y * (nextP.X() - preP.X()) / tempInternalLengthXY;
				double offsetY = offsetX_Y * (nextP.Y() - preP.Y()) / tempInternalLengthXY;
				
				for(int j = 0; j < internalPointCount; j++){
					STPoint internalP = gf.createPoint(new double[] {preP.X() + offsetX*j, preP.Y() + offsetY*j, preP.Z() + offsetZ*j});
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
	
	private static STPoint addNoise(CommonGeometryFactory gf, Coordinate orginP, final double sigma, final int chooseCount) throws Exception{
		if(minimumDistance == null)
			throw new Exception("you must called 'setMinErrorDistance' function");
		Random random = new Random();
		double errorDistance = 0;
		if(minimumDistance.containsKey(orginP)){
			errorDistance = minimumDistance.get(orginP);	
		}
		else{
			errorDistance = sigma;
		}
		
		
		if(errorDistance > sigma)
			errorDistance = sigma;
		
		double errorOffSetX = 0;
		double errorOffSetY = 0;
		for(int i = 0; i < chooseCount; i++){
			errorOffSetX += Math.cos(Math.toRadians(randomRange(0, 360)))*random.nextGaussian() * errorDistance;
			errorOffSetY += Math.sin(Math.toRadians(randomRange(0, 360)))*random.nextGaussian() * errorDistance;
		}
		
		errorOffSetX = errorOffSetX / chooseCount;
		errorOffSetY = errorOffSetY / chooseCount;
		
		STPoint newPoint = gf.createPoint(new double[] {orginP.x + errorOffSetX, orginP.y + errorOffSetY, orginP.z});
		return newPoint;
	}
	
	private static STPoint addNoise(SqlSession session, CommonGeometryFactory gf, STPoint orginP, final double sigma, final int chooseCount){
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
			int beforeCellId = queryModule.intersectRoomByPoint(session, orginP);
			int afterCellId =  queryModule.intersectRoomByPoint(session, newPoint);
			for(int i = 0; i < 3; i++){
				errorOffSetX = errorOffSetX / 2;
				errorOffSetY = errorOffSetY / 2;
				newPoint = gf.createPoint(new double[] {orginP.X() + errorOffSetX, orginP.Y() + errorOffSetY, orginP.Z()});
				afterCellId =  queryModule.intersectRoomByPoint(session, newPoint);
				if(beforeCellId == afterCellId)
					break;
			}
			if(beforeCellId != afterCellId)
				newPoint = orginP;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newPoint;
	}
}
