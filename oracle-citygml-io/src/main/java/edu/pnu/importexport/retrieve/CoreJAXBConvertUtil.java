/**
 * 
 */
package edu.pnu.importexport.retrieve;

import edu.pnu.common.BindingNode;
import net.opengis.citygml.v_2_0.CityModelType;
import net.opengis.citygml.v_2_0.ObjectFactory;

/**
 * @author hgryoo
 *
 */
public class CoreJAXBConvertUtil {
	
	private static final ObjectFactory coreOf = new ObjectFactory();
	
	public static CityModelType createCityModel(CityModelType target, BindingNode node) {
		if(target == null) {
			target = coreOf.createCityModelType();
		}
		target = (CityModelType) GMLJAXBConvertUtil.setAbstractFeatureCollectionType(target, node);
		return target;
	}
}
