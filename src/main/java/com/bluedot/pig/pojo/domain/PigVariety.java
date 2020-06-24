package com.bluedot.pig.pojo.domain;


/**
 * @author  xxbb
 */
public class PigVariety  {
	/**
 	* pigVarietyId
 	*/
	private Integer pigVarietyId;
	/**
 	* pigVariety
 	*/
	private String pigVariety;

	public PigVariety() {
	}

	public PigVariety(Integer pigVarietyId, String pigVariety) {
		this.pigVarietyId = pigVarietyId;
		this.pigVariety = pigVariety;
	}

	public PigVariety(String pigVariety) {
		this.pigVariety = pigVariety;
	}

	public Integer getPigVarietyId() {
    	return pigVarietyId;
  	}

  	public void setPigVarietyId(Integer pigVarietyId) {
    	this.pigVarietyId = pigVarietyId;
  	}


  	public String getPigVariety() {
    	return pigVariety;
  	}

  	public void setPigVariety(String pigVariety) {
    	this.pigVariety = pigVariety;
  	}


}
