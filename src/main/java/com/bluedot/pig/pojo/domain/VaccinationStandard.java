package com.bluedot.pig.pojo.domain;

import java.util.Date;

/**
 * @author  xxbb
 */
public class VaccinationStandard  {
	/**
 	* id
 	*/
	private Integer id;
	/**
 	* vaccineSpecies
 	*/
	private Integer vaccineSpecies;
	/**
 	* inoculationTime
 	*/
	private Date inoculationTime;
	/**
 	* totalAmount
 	*/
	private Double totalAmount;
	/**
 	* inoculationExplain
 	*/
	private String inoculationExplain;
	/**
 	* hogcoteNo
 	*/
	private Integer hogcoteNo;
	/**
 	* setTime
 	*/
	private Date setTime;

  	public Integer getId() {
    	return id;
  	}

  	public void setId(Integer id) {
    	this.id = id;
  	}


  	public Integer getVaccineSpecies() {
    	return vaccineSpecies;
  	}

  	public void setVaccineSpecies(Integer vaccineSpecies) {
    	this.vaccineSpecies = vaccineSpecies;
  	}


  	public Date getInoculationTime() {
    	return inoculationTime;
  	}

  	public void setInoculationTime(Date inoculationTime) {
    	this.inoculationTime = inoculationTime;
  	}


  	public Double getTotalAmount() {
    	return totalAmount;
  	}

  	public void setTotalAmount(Double totalAmount) {
    	this.totalAmount = totalAmount;
  	}


  	public String getInoculationExplain() {
    	return inoculationExplain;
  	}

  	public void setInoculationExplain(String inoculationExplain) {
    	this.inoculationExplain = inoculationExplain;
  	}


  	public Integer getHogcoteNo() {
    	return hogcoteNo;
  	}

  	public void setHogcoteNo(Integer hogcoteNo) {
    	this.hogcoteNo = hogcoteNo;
  	}


  	public Date getSetTime() {
    	return setTime;
  	}

  	public void setSetTime(Date setTime) {
    	this.setTime = setTime;
  	}


}
