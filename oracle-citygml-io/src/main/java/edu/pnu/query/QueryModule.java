/**
 * 
 */
package edu.pnu.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.vividsolutions.jts.geom.Coordinate;

import edu.pnu.common.geometry.CommonGeometryFactory;
import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.model.STSolid;
import edu.pnu.common.geometry.utils.WKBGeometryBuilder;
import net.opengis.citygml.v_2_0.vo.building.Building;
import net.opengis.citygml.v_2_0.vo.building.Room;
import net.opengis.citygml.v_2_0.vo.core.CityModel;
import net.opengis.citygml.v_2_0.vo.spatial.OrcaleGeometryConvert;
import oracle.spatial.geometry.J3D_Geometry;
import oracle.spatial.geometry.JGeometry;

/**
 * @author hgryoo
 *
 */
public class QueryModule {

	public CityModel intersectRoom(SqlSession session, final String modelName, final STGeometry geometry) throws Exception {

		HashMap<String, Object> param = new HashMap<String, Object>();
		byte[] geo = WKBGeometryBuilder.getBuilder().asBinary(geometry);
		param.put("id", modelName);
		param.put("geo", geo);
		
		//List<Room> resultRooms = session.selectList(MapperNamespace.ROOM_INTERSECT_QUERY, param);
		List<Room> resultRooms = new ArrayList<Room>();
		Connection conn = session.getConnection();
		J3D_Geometry querySolid = OrcaleGeometryConvert.ConvertSolid((STSolid) geometry);
		
		String sql = "SELECT "
				+ "R.ID, R.BUILDING_ID,"
				+ "R.CLAZZ, R.CLASS_CODESPACE, R.FUNC, R.FUNC_CODESPACE, R.USAGE, R.USAGE_CODESPACE,"
				+ "R.LOD4SOLID,R.LOD4MULTISURFACE"
				+ " FROM ROOM R "
				+ "INNER JOIN CityObject CO on R.ID = CO.ID "
				+ "INNER JOIN Building B on R.BUILDING_ID = B.ID "
				+ "INNER JOIN CityObjectMember COM on COM.CITYOBJECT_ID = B.ID "
				+ "INNER JOIN CityModel CM on COM.CITYMODEL_ID = CM.ID "
				+ " WHERE "
				+ "CM.SID = '" + modelName + "'";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);	
				int buildingid =rs.getInt(2);
				String clazz = rs.getString(3); 
				String classCodeSpace = rs.getString(4);
				String func = rs.getString(5);
				String funcCodeSpace = rs.getString(6);
				String usage = rs.getString(7);
				String usageCodeSpace = rs.getString(8);
				Struct lod4solid = (Struct) rs.getObject(9);
				Struct lod4multisurface = (Struct) rs.getObject(10);
				JGeometry lod4solidGeometry = J3D_Geometry.loadJS(lod4solid);
				J3D_Geometry targetSolid = new J3D_Geometry(lod4solidGeometry.getType(), lod4solidGeometry.getSRID(), lod4solidGeometry.getElemInfo(), lod4solidGeometry.getOrdinatesArray());
				//JGeometry lod4multisurfaceGeometry = J3D_Geometry.loadJS(lod4multisurface);
				
				boolean intersectResult = querySolid.anyInteract(targetSolid, 0.01);
				if(intersectResult){
					//System.out.println(intersectResult);
					Room room =  new Room();
					room.setId(id);
					room.setClazz(clazz);
					room.setClassCodeSpace(classCodeSpace);
					room.setFunc(func);
					room.setFuncCodeSpace(funcCodeSpace);
					room.setUsage(usage);
					room.setUsageCodeSpace(usageCodeSpace);
					// 湲고븯遺�遺� �엯�젰 �븘�슂...�븘�삤 �뀑�뀑
					resultRooms.add(room);
				}
			}
			pstm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Room�뿉 ���빐 (RoomInstallation怨�) BuildingBoundary瑜� 媛��졇�삤�뒗 �옉�뾽
		for(Room r : resultRooms){
			
		}
		
		Building b = new Building();
		b.getRooms().addAll(resultRooms);
		
		CityModel citymodel = new CityModel();
		citymodel.getCityObjects().add(b);
		
		return citymodel;
	}
	
	private static List<Room> roomList = new ArrayList<Room>();
	private static void getRoom(SqlSession session){
		Connection conn = session.getConnection();
		String sql = "SELECT "
				+ "R.ID, R.LOD4SOLID"
				+ " FROM ROOM R";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt(1);
				Struct lod4solid = (Struct) rs.getObject(2);
				JGeometry lod4solidGeometry = J3D_Geometry.loadJS(lod4solid);
				J3D_Geometry targetSolid = new J3D_Geometry(lod4solidGeometry.getType(), lod4solidGeometry.getSRID(), lod4solidGeometry.getElemInfo(), lod4solidGeometry.getOrdinatesArray());
				Room room =  new Room();
				room.setId(id);
				room.oracleSolidGeometry = targetSolid;
				roomList.add(room);
			}
			pstm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public Integer intersectRoomByPoint(SqlSession session, final STGeometry geometry) throws Exception {
		if(roomList.size() == 0){
			getRoom(session);
		}
		List<Room> resultRooms = new ArrayList<Room>();
		J3D_Geometry queryGeometry = null;
		
		if(geometry instanceof STPoint){
			STPoint p = (STPoint) geometry;
			queryGeometry = new J3D_Geometry(3001, 5783, p.X(), p.Y(), p.Z());
		}
		else if(geometry instanceof STSolid)
			queryGeometry = OrcaleGeometryConvert.ConvertSolid((STSolid) geometry);
		
		for (Room room : roomList) {
			J3D_Geometry targetSolid = room.oracleSolidGeometry;
			boolean intersectResult = queryGeometry.anyInteract(targetSolid, 0.01);
			if(intersectResult){
				resultRooms.add(room);
			}
		}
		
		if(resultRooms.size() == 0){
			if(geometry instanceof STPoint){
				STPoint p = (STPoint) geometry;
				double buffersize = 1;
				CommonGeometryFactory gf = new CommonGeometryFactory(true, false);
				STSolid bufferedPoint = gf.createBox3D(gf.createPoint(new double[] {p.X() - buffersize, p.Y() - buffersize, p.Z()}), 
						gf.createPoint(new double[] {p.X() + buffersize, p.Y() + buffersize, p.Z()+ buffersize}));
				intersectRoomByPoint(session, bufferedPoint);
			}
			else{
				throw new Exception("Query failed");
			}
		}	
		
		return resultRooms.get(0).getId();
	}
	
	public HashMap<Coordinate, Double> getMinimumDistanceMap(SqlSession session, final List<Coordinate> geometries) throws Exception {
		if(roomList.size() == 0){
			getRoom(session);
		}
		HashMap<Coordinate, Double> minimumDistance = new HashMap();
		CommonGeometryFactory gf = new CommonGeometryFactory(true, false);
		for (Coordinate p : geometries) {
			J3D_Geometry queryGeometry = new J3D_Geometry(3001, 5783, p.x, p.y, p.z);
			
			for (Room room : roomList) {
				J3D_Geometry targetSolid = room.oracleSolidGeometry;
				boolean intersectResult = queryGeometry.anyInteract(targetSolid, 0.01);
				if(intersectResult){
					Double tempMinDis = queryGeometry.distance(targetSolid, 0);
					minimumDistance.put(p, tempMinDis);
					break;
				}
			}
			
			if(!minimumDistance.containsKey(p)){
				double buffersize = 5;
				STSolid bufferedPoint = gf.createBox3D(gf.createPoint(new double[] {p.x - buffersize, p.y - buffersize, p.z}), 
						gf.createPoint(new double[] {p.x + buffersize, p.x + buffersize, p.z+ buffersize}));
				queryGeometry = OrcaleGeometryConvert.ConvertSolid(bufferedPoint);
				
				for (Room room : roomList) {
					J3D_Geometry targetSolid = room.oracleSolidGeometry;
					boolean intersectResult = queryGeometry.anyInteract(targetSolid, 0.01);
					if(intersectResult){
						Double tempMinDis = queryGeometry.distance(targetSolid, 0);
						if(minimumDistance.containsKey(p)){
							Double prvDis = minimumDistance.get(p);
							if(prvDis > tempMinDis)
								minimumDistance.put(p, tempMinDis);
						}
						else
							minimumDistance.put(p, tempMinDis);	
					}
				}
				
				if(!minimumDistance.containsKey(p)){
					throw new Exception("There doesn't exist rooms that intersection by this point = " + p);
				}
			}
		}
		
		return minimumDistance;
	}
}