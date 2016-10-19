/**
 * 
 */
package edu.pnu.model;

/**
 * @author hgryoo
 *
 */
public interface MovingObjectType {
	
	MovingObjectType getSuper();
	
	String getId();
	String getName();
	String getDescription();
	
}
