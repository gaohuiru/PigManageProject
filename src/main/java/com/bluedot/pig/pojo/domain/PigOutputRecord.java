package com.bluedot.pig.pojo.domain;

import java.util.Date;

/**
 * @author  xxbb
 */
public class PigOutputRecord  {
	/**
 	* id
 	*/
	private Integer id;
	/**
 	* pigNo
 	*/
	private Integer pigNo;
	/**
 	* outTime
 	*/
	private Date outTime;
	/**
 	* pigPrice
 	*/
	private Double pigPrice;
	/**
 	* sellPlace
 	*/
	private String sellPlace;

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


  	public Date getOutTime() {
    	return outTime;
  	}

  	public void setOutTime(Date outTime) {
    	this.outTime = outTime;
  	}


  	public Double getPigPrice() {
    	return pigPrice;
  	}

  	public void setPigPrice(Double pigPrice) {
    	this.pigPrice = pigPrice;
  	}


  	public String getSellPlace() {
    	return sellPlace;
  	}

  	public void setSellPlace(String sellPlace) {
    	this.sellPlace = sellPlace;
  	}


}
