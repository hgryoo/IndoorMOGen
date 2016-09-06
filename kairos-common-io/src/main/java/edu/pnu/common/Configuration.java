/**
 * 
 */
package edu.pnu.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hgryoo
 *
 */
public abstract class Configuration {
	
	private Map<Class, Class> bindings;
	
	public Configuration() {
		bindings = new HashMap<Class, Class>();
		registerBindings(bindings);
	}
	
	public void registerBindings(Map<Class, Class> bindings) {
		
	}
	
	
}
