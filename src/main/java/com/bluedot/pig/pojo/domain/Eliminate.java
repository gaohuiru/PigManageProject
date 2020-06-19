package com.bluedot.pig.pojo.domain;

import java.util.Date;

/**
 * @author  xxbb
 */
public class Eliminate  {
	/**
 	* id
 	*/
	private Integer id;
	/**
 	* pigNo
 	*/
	private Integer pigNo;
	/**
 	* eliminateType
 	*/
	private String eliminateType;
	/**
 	* eliminateReason
 	*/
	private String eliminateReason;
	/**
 	* eliminateDate
 	*/
	private Date eliminateDate;
	/**
 	* ifEliminate
 	*/
	private Integer ifEliminate;

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


  	public String getEliminateType() {
    	return eliminateType;
  	}

  	public void setEliminateType(String eliminateType) {
    	this.eliminateType = eliminateType;
  	}


  	public String getEliminateReason() {
    	return eliminateReason;
  	}

  	public void setEliminateReason(String eliminateReason) {
    	this.eliminateReason = eliminateReason;
  	}


  	public Date getEliminateDate() {
    	return eliminateDate;
  	}

  	public void setEliminateDate(Date eliminateDate) {
    	this.eliminateDate = eliminateDate;
  	}


  	public Integer getIfEliminate() {
    	return ifEliminate;
  	}

  	public void setIfEliminate(Integer ifEliminate) {
    	this.ifEliminate = ifEliminate;
  	}


}
