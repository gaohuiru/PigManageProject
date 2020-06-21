package com.bluedot.pig.pojo.domain;

import java.sql.Date;

/**
 * @author  xxbb
 */
public class IllnessRecord  {
	/**
 	* id
 	*/
	private Integer id;
	/**
 	* pigNo
 	*/
	private Integer pigNo;
	/**
 	* drugSpecies
 	*/
	private String drugSpecies;
	/**
 	* time
 	*/
	private Date time;
	/**
 	* totalAmount
 	*/
	private Integer totalAmount;
	/**
 	* illDate
 	*/
	private Date illDate;
	/**
 	* illType
 	*/
	private Integer illType;
	/**
 	* description
 	*/
	private String description;

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


  	public String getDrugSpecies() {
    	return drugSpecies;
  	}

  	public void setDrugSpecies(String drugSpecies) {
    	this.drugSpecies = drugSpecies;
  	}


  	public Date getTime() {
    	return time;
  	}

  	public void setTime(Date time) {
    	this.time = time;
  	}


  	public Integer getTotalAmount() {
    	return totalAmount;
  	}

  	public void setTotalAmount(Integer totalAmount) {
    	this.totalAmount = totalAmount;
  	}


  	public Date getIllDate() {
    	return illDate;
  	}

  	public void setIllDate(Date illDate) {
    	this.illDate = illDate;
  	}


  	public Integer getIllType() {
    	return illType;
  	}

  	public void setIllType(Integer illType) {
    	this.illType = illType;
  	}


  	public String getDescription() {
    	return description;
  	}

  	public void setDescription(String description) {
    	this.description = description;
  	}


}
