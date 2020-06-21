package com.bluedot.pig.pojo.domain;

import java.sql.Date;

/**
 * @author  xxbb
 */
public class VaccinationRecord  {
	/**
 	* id
 	*/
	private Integer id;
	/**
 	* pigNo
 	*/
	private Integer pigNo;
	/**
 	* inoculationTime
 	*/
	private Date inoculationTime;
	/**
 	* vaccineSpecies
 	*/
	private String vaccineSpecies;
	/**
 	* inoculationReason
 	*/
	private String inoculationReason;

  	public Integer getId() {
    	return id;
  	}

  	public void setId(Integer id) {
    	this.id = id;
  	}


  	public Integer getPigNo() {
    	return pigNo;
  	}

  	public void setPigNo(Integer pigNo) {
    	this.pigNo = pigNo;
  	}


  	public Date getInoculationTime() {
    	return inoculationTime;
  	}

  	public void setInoculationTime(Date inoculationTime) {
    	this.inoculationTime = inoculationTime;
  	}


  	public String getVaccineSpecies() {
    	return vaccineSpecies;
  	}

  	public void setVaccineSpecies(String vaccineSpecies) {
    	this.vaccineSpecies = vaccineSpecies;
  	}


  	public String getInoculationReason() {
    	return inoculationReason;
  	}

  	public void setInoculationReason(String inoculationReason) {
    	this.inoculationReason = inoculationReason;
  	}


}
