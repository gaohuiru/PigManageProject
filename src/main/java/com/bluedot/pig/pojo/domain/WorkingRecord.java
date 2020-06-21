package com.bluedot.pig.pojo.domain;

import java.sql.Date;

/**
 * @author  xxbb
 */
public class WorkingRecord  {
	/**
 	* goodsNo
 	*/
	private String goodsNo;
	/**
 	* upperLimit
 	*/
	private Double upperLimit;
	/**
 	* lowerLimit
 	*/
	private Double lowerLimit;
	/**
 	* value
 	*/
	private Double value;
	/**
 	* time
 	*/
	private Date time;

  	public String getGoodsNo() {
    	return goodsNo;
  	}

  	public void setGoodsNo(String goodsNo) {
    	this.goodsNo = goodsNo;
  	}


  	public Double getUpperLimit() {
    	return upperLimit;
  	}

  	public void setUpperLimit(Double upperLimit) {
    	this.upperLimit = upperLimit;
  	}


  	public Double getLowerLimit() {
    	return lowerLimit;
  	}

  	public void setLowerLimit(Double lowerLimit) {
    	this.lowerLimit = lowerLimit;
  	}


  	public Double getValue() {
    	return value;
  	}

  	public void setValue(Double value) {
    	this.value = value;
  	}


  	public Date getTime() {
    	return time;
  	}

  	public void setTime(Date time) {
    	this.time = time;
  	}


}
