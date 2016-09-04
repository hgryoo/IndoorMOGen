/**
 * 
 */
package net.opengis.citygml.v_2_0.vo.core;

/**
 * @author hgryoo
 *
 */

//TODO
public class Address {
	
	private Integer id;
	private String street;
	private String houseNumber;
	private String postBox;
	private String zipCode;
	private String city;
	private String state;
	private String country;
	private byte[] multiPoint;
	private String xalSource;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the houseNumber
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * @return the postBox
	 */
	public String getPostBox() {
		return postBox;
	}

	/**
	 * @param postBox the postBox to set
	 */
	public void setPostBox(String postBox) {
		this.postBox = postBox;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the multiPoint
	 */
	public byte[] getMultiPoint() {
		return multiPoint;
	}

	/**
	 * @param multiPoint the multiPoint to set
	 */
	public void setMultiPoint(byte[] multiPoint) {
		this.multiPoint = multiPoint;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	

	/**
	 * @return the xalSource
	 */
	public String getXalSource() {
		return xalSource;
	}

	/**
	 * @param xalSource the xalSource to set
	 */
	public void setXalSource(String xalSource) {
		this.xalSource = xalSource;
	}
	
	
	
}
