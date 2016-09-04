/**
 * 
 */
package net.opengis.citygml.v_2_0.dao;

/**
 * @author hgryoo
 *
 */
public class MapperNamespace {
	
	public static final String CITYGML_MAPPER_NAMESPACE = "net.opengis.citygml.v_2_0";
	
	
	/* Core Module */
	
		/* Insert */
		public static final String INSERT_CITYMODEL_NS = CITYGML_MAPPER_NAMESPACE + ".insertCityModel";
		public static final String INSERT_CITYOBJECTMEMBER_NS = CITYGML_MAPPER_NAMESPACE + ".insertCityObjectMember";
	
		/* Select */
		public static final String SELECT_CITYMODEL_NS = CITYGML_MAPPER_NAMESPACE + ".selectCityModel";
		public static final String SELECT_CITYMODEL_BY_SID_NS = CITYGML_MAPPER_NAMESPACE + ".selectCityModelBySID";
		public static final String SELECT_CITYOBJECT_FOR_CITYMODEL = CITYGML_MAPPER_NAMESPACE + ".selectCityObjectForCityModel";
		
	/* Bridge Module */
		
		/* Insert */
		public static final String INSERT_BRIDGE_NS = CITYGML_MAPPER_NAMESPACE + ".insertBridge";
		public static final String INSERT_BRIDGEROOM_NS = CITYGML_MAPPER_NAMESPACE + ".insertBridgeRoom";
		public static final String INSERT_BRIDGEBOUNDARY_NS = CITYGML_MAPPER_NAMESPACE + ".insertBridgeBoundary";
		public static final String INSERT_BRIDGEOPENING_NS = CITYGML_MAPPER_NAMESPACE + ".insertBridgeOpening";
		public static final String INSERT_BRIDGECONSTRUCTIONELEMENT_NS = CITYGML_MAPPER_NAMESPACE + ".insertBridgeConstructionElement";
		public static final String INSERT_BRIDGEINSTALLATION_NS = CITYGML_MAPPER_NAMESPACE + ".insertBridgeInstallation";
		public static final String INSERT_BRIDGEROOMINSTALLATION_NS = MapperNamespace.CITYGML_MAPPER_NAMESPACE + ".insertBridgeRoomInstallation";
		
		/* Select */
		public static final String SELECT_BRIDGE_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridge";
		public static final String SELECT_BRIDGEINSTALLATIONS_FOR_BRIDGE_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridgeInstallationsForBridge";
		public static final String SELECT_BRIDGEROOMS_FOR_BRIDGE_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridgeRoomsForBridge";
		public static final String SELECT_BRIDGEBOUNDARYS_FOR_BRIDGE_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridgeBoundarysForBridge";
		
		public static final String SELECT_BRIDGEROOM_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridgeRoom";
		public static final String SELECT_BRIDGEROOMINSTALLATIONS_FOR_BRIDGEROOM_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridgeRoomInstallationForBridgeRoom";
		public static final String SELECT_BRIDGEBOUNDARYS_FOR_BRIDGEROOM_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridgeBoundarysForBridgeRoom";
				
		public static final String SELECT_BRIDGEOPENINGS_FOR_BRIDGEBOUNDARY_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridgeOpeningForBridgeBoundary";
		
		public static final String SELECT_BRIDGEBOUNDARYS_FOR_BRIDGECONSTRUCTIONELEMENT_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridgeBoundarysForConstructionElement";
		public static final String SELECT_BRIDGECONSTRUCTIONELEMENT_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridgeConstructionElement";
		
		public static final String SELECT_BRIDGEINSTALLATION_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridgeInstallation";
		public static final String SELECT_BRIDGEBOUNDARYS_FOR_BRIDGEINSTALLATION_NS = CITYGML_MAPPER_NAMESPACE + ".selectBridgeBoundarysForBridgeInstallation";
		
		public static final String SELECT_BRIDGEROOMINSTALLATION_NS = MapperNamespace.CITYGML_MAPPER_NAMESPACE + ".selectBridgeRoomInstallation";
		public static final String SELECT_BRIDGEBOUNDARYS_FOR_BRIDGEROOMINSTALLATION_NS = MapperNamespace.CITYGML_MAPPER_NAMESPACE + ".selectBridgeBoundarysForBridgeRoomInstallation";
		
	/* Building Module */
	
		/* Insert */
		public static final String INSERT_BUILDING_NS = CITYGML_MAPPER_NAMESPACE + ".insertBuilding";
		public static final String INSERT_BUILDINGBOUNDARY_NS = CITYGML_MAPPER_NAMESPACE + ".insertBuildingBoundary";
		public static final String INSERT_BUILDINGINSTALLATION_NS = CITYGML_MAPPER_NAMESPACE + ".insertBuildingInstallation";
		public static final String INSERT_BUILDINGOPENING_NS = CITYGML_MAPPER_NAMESPACE + ".insertBuildingOpening";
		
		/* Select */
		public static final String SELECT_BUILDING_NS = CITYGML_MAPPER_NAMESPACE + ".selectBuilding";
		public static final String SELECT_ROOMS_FOR_BUILDING_NS = CITYGML_MAPPER_NAMESPACE + ".selectRoomsForBuilding";
		public static final String SELECT_BUILDINGINSTALLATIONS_FOR_BUILDING_NS = CITYGML_MAPPER_NAMESPACE + ".selectBuildingInstallationsForBuilding";
		public static final String SELECT_BUILDINGBOUNDARYS_FOR_BUILDING_NS = CITYGML_MAPPER_NAMESPACE + ".selectBuildingBoundarysForBuilding";
		
		public static final String SELECT_BUILDINGOPENINGS_FOR_BUILDINGBOUNDARY_NS = CITYGML_MAPPER_NAMESPACE + ".selectBuildingOpeningForBuildingBoundary";
		
		public static final String SELECT_BUILDINGINSTALLATION_NS = CITYGML_MAPPER_NAMESPACE + ".selectBuildingInstallation";
		public static final String SELECT_BUILDINGBOUNDARYS_FOR_BUILDINGINSTALLATION_NS = CITYGML_MAPPER_NAMESPACE + ".selectBuildingBoundarysForBuildingInstallation";
		/* Query  */
		public static final String ROOM_INTERSECT_QUERY = CITYGML_MAPPER_NAMESPACE + ".queryRoomIntersect";


		


		
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	// byte[] to hex
	public static String byteArrayToHex(final byte[] ba) {
	    if (ba == null || ba.length == 0) {
	        return null;
	    }
	 
	    StringBuffer sb = new StringBuffer(ba.length * 2);
	    String hexNumber;
	    for (int x = 0; x < ba.length; x++) {
	        hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
	 
	        sb.append(hexNumber.substring(hexNumber.length() - 2));
	    }
	    return "0x" + sb.toString();
	} 
	
}
