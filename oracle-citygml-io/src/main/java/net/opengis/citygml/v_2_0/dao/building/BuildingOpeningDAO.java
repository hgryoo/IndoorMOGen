/**
 * 
 */
package net.opengis.citygml.v_2_0.dao.building;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;

import org.apache.ibatis.session.SqlSession;

import net.opengis.citygml.v_2_0.dao.DAO;
import net.opengis.citygml.v_2_0.vo.building.BuildingOpening;
import net.opengis.citygml.v_2_0.vo.spatial.OrcaleGeometryConvert;
import oracle.spatial.geometry.J3D_Geometry;

/**
 * @author hgryoo
 * @see BuildingOpeningMapper.xml
 */
public class BuildingOpeningDAO {
	
	public static final String INSERT_BUILDINGOPENING_NS = DAO.CityGML_MAPPER_NAMESPACE + ".insertBuildingOpening";
	
	public static BuildingOpening insertBuildingOpening(SqlSession session, BuildingOpening vo) throws Exception {
		//session.insert(INSERT_BUILDINGOPENING_NS, vo);
		String sql = "INSERT INTO BuildingOpening "
				+ "("
				+ "ID, OPENING_TYPE,"
				+ "BUILDINGBOUNDARY_ID, ADDRESS_ID,"
				+ "LOD3IMPLICITREPRESENTATION, LOD4IMPLICITREPRESENTATION,"
				+ "LOD3MULTISURFACE, LOD4MULTISURFACE"
				+ ")"
				+ " VALUES ("
				+ "?,?,?,?,?,?,?,?"
				+ ")"; 
		
		Connection conn = session.getConnection();
		try {
			Struct lod3MultiSurfaceObject = null;
			Struct lod4MultiSurfaceObject = null;
			
			if(vo.lod3MultiSurfaceGeometry != null){
				J3D_Geometry multisurface = OrcaleGeometryConvert.ConvertMultiSurface(vo.lod3MultiSurfaceGeometry);
				lod3MultiSurfaceObject = J3D_Geometry.storeJS(conn.unwrap(oracle.jdbc.OracleConnection.class), multisurface);
			}
			if(vo.lod4MultiSurfaceGeometry != null){
				J3D_Geometry multisurface = OrcaleGeometryConvert.ConvertMultiSurface(vo.lod4MultiSurfaceGeometry);
				lod4MultiSurfaceObject = J3D_Geometry.storeJS(conn.unwrap(oracle.jdbc.OracleConnection.class), multisurface);
			}
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, vo.getId());
			pstm.setString(2, vo.getOpeningType());
			pstm.setObject(3, (vo.getBoundary() != null)?vo.getBoundary().getId():null);
			pstm.setObject(4, (vo.getAddress() != null)?vo.getAddress().getId():null);
			pstm.setObject(5, (vo.getLod3ImplicitRepresentation() != null)?vo.getLod3ImplicitRepresentation().getId():null);
			pstm.setObject(6, (vo.getLod4ImplicitRepresentation() != null)?vo.getLod4ImplicitRepresentation().getId():null);
			if(lod3MultiSurfaceObject == null)
				pstm.setNull(7, Types.STRUCT, "MDSYS.SDO_GEOMETRY");
			else
				pstm.setObject(7, lod3MultiSurfaceObject);
			if(lod4MultiSurfaceObject == null)
				pstm.setNull(8, Types.STRUCT, "MDSYS.SDO_GEOMETRY");
			else
				pstm.setObject(8, lod4MultiSurfaceObject);
			
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return vo;
	}
	
	public static BuildingOpening selectBuildingOpening(SqlSession session, BuildingOpening vo) throws Exception {
		
		//TODO
		/*ImplicitGeometry lod3ImplicitRepresentation;
		ImplicitGeometry lod4ImplicitRepresentation;*/
		
		
		return vo;
		
	}

}
