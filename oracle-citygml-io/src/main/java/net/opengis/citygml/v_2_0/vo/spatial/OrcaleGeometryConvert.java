package net.opengis.citygml.v_2_0.vo.spatial;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import edu.pnu.common.geometry.model.STGeometry;
import edu.pnu.common.geometry.model.STLineString;
import edu.pnu.common.geometry.model.STMultiSurface;
import edu.pnu.common.geometry.model.STPoint;
import edu.pnu.common.geometry.model.STPolygon;
import edu.pnu.common.geometry.model.STPolyhedralSurface;
import edu.pnu.common.geometry.model.STSolid;
import edu.pnu.common.geometry.model.STSurface;
import oracle.spatial.geometry.J3D_Geometry;

public class OrcaleGeometryConvert {
	private static final int MULTISURFACE_GTYPE = 3007;
	private static final int SOLID_GTYPE = 3008;
	
	private static final int SRID = 5783;
	
	public static J3D_Geometry ConvertSolid(STSolid solidGeometry){
		int gtype 	= SOLID_GTYPE;
		int srid 	= SRID;//solidGeometry.SRID();
		int[] elemInfo;
		double[] ordinates;
		ArrayList<Integer> elemInfoArray = new ArrayList<Integer>();
		ArrayList<Double> ordinatesArray = new ArrayList<Double>();
		
		elemInfoArray.add(1);		// Offset of a Simple solid element
		elemInfoArray.add(1007);	// Etype for a Simple solid
		elemInfoArray.add(1);		// Indicate all surfaces are specified explicitly
		
		STSurface exteior = solidGeometry.exteriorShell();
		
		if(exteior.geometryType().equalsIgnoreCase("PolyhedralSurface")) {
			STPolyhedralSurface polyhedralSurface = (STPolyhedralSurface) exteior;
			
			elemInfoArray.add(1);		// Offset of composite element
			elemInfoArray.add(1006);	// Etype for composite surface element
			elemInfoArray.add(polyhedralSurface.numPatches()); // Number of composing elements
			
			int startIndex = 1;
			
			for(int i = 0; i< polyhedralSurface.numPatches(); i++) {
				elemInfoArray.add(startIndex);
				elemInfoArray.add(1003);	// Etype for polygon element
				elemInfoArray.add(1);		// Interpretation style : Polygon boundary connected by straight lines
				
				STPolygon patch = polyhedralSurface.PatchN(i);
				STLineString lineString = patch.exteriorRing();
				for(int j = 0; j < lineString.numPoints(); j++){
					STPoint point = lineString.PointN(j);
					ordinatesArray.add(point.X());
					ordinatesArray.add(point.Y());
					ordinatesArray.add(point.Z());
					startIndex += 3;
				}
			}
		} else {
			throw new UnsupportedOperationException();
		}
		
		elemInfo = ArrayUtils.toPrimitive(elemInfoArray.toArray(new Integer[elemInfoArray.size()]));
		ordinates = ArrayUtils.toPrimitive(ordinatesArray.toArray(new Double[ordinatesArray.size()]));
		
		J3D_Geometry oracle3DGeometry = new J3D_Geometry(gtype, srid, elemInfo, ordinates);
		
		return oracle3DGeometry;
	}
	
	public static J3D_Geometry ConvertMultiSurface(STMultiSurface multiSurfaceGeometry){
		int gtype 	= MULTISURFACE_GTYPE;
		int srid 	= SRID;
		int[] elemInfo;
		double[] ordinates;
		ArrayList<Integer> elemInfoArray = new ArrayList<Integer>();
		ArrayList<Double> ordinatesArray = new ArrayList<Double>();
		
		int startIndex = 1;
		STSurface[] surfaceElement = multiSurfaceGeometry.getSurfaces();
		for(int i = 0; i < surfaceElement.length; i++){
			if(surfaceElement[i].geometryType().equalsIgnoreCase("Polygon")){
				STPolygon polygon = (STPolygon) surfaceElement[i];
				
				elemInfoArray.add(startIndex);
				elemInfoArray.add(1003);	
				elemInfoArray.add(1);
				
				STLineString lineString = polygon.exteriorRing();
				for(int j = 0; j < lineString.numPoints(); j++){
					STPoint point = lineString.PointN(j);
					ordinatesArray.add(point.X());
					ordinatesArray.add(point.Y());
					ordinatesArray.add(point.Z());
					startIndex += 3;
				}
			} else {
				throw new UnsupportedOperationException();	
			}
		}
		
		elemInfo = ArrayUtils.toPrimitive(elemInfoArray.toArray(new Integer[elemInfoArray.size()]));
		ordinates = ArrayUtils.toPrimitive(ordinatesArray.toArray(new Double[ordinatesArray.size()]));
		
		J3D_Geometry oracle3DGeometry = new J3D_Geometry(gtype, srid, elemInfo, ordinates);
		
		return oracle3DGeometry;
	}
}
