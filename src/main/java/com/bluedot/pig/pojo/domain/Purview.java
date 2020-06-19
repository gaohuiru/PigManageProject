package com.bluedot.pig.pojo.domain;


/**
 * @author  xxbb
 */
public class Purview  {
	/**
 	* employeeId
 	*/
	private Integer employeeId;
	/**
 	* userRights
 	*/
	private Integer userRights;
	/**
 	* pigRights
 	*/
	private Integer pigRights;
	/**
 	* storeRights
 	*/
	private Integer storeRights;
	/**
 	* equipmentRights
 	*/
	private Integer equipmentRights;
	/**
 	* systemRights
 	*/
	private Integer systemRights;

  	public Integer getEmployeeId() {
    	return employeeId;
  	}

  	public void setEmployeeId(Integer employeeId) {
    	this.employeeId = employeeId;
  	}


  	public Integer getUserRights() {
    	return userRights;
  	}

  	public void setUserRights(Integer userRights) {
    	this.userRights = userRights;
  	}


  	public Integer getPigRights() {
    	return pigRights;
  	}

  	public void setPigRights(Integer pigRights) {
    	this.pigRights = pigRights;
  	}


  	public Integer getStoreRights() {
    	return storeRights;
  	}

  	public void setStoreRights(Integer storeRights) {
    	this.storeRights = storeRights;
  	}


  	public Integer getEquipmentRights() {
    	return equipmentRights;
  	}

  	public void setEquipmentRights(Integer equipmentRights) {
    	this.equipmentRights = equipmentRights;
  	}


  	public Integer getSystemRights() {
    	return systemRights;
  	}

  	public void setSystemRights(Integer systemRights) {
    	this.systemRights = systemRights;
  	}

	@Override
	public String toString() {
		return "Purview{" +
				"employeeId=" + employeeId +
				", userRights=" + userRights +
				", pigRights=" + pigRights +
				", storeRights=" + storeRights +
				", equipmentRights=" + equipmentRights +
				", systemRights=" + systemRights +
				'}';
	}
}
