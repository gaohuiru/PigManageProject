package com.bluedot.pig.pojo.domain;

import java.util.Date;

/**
 * @author  xxbb
 */
public class TurningHogcoteRecord  {
	/**
 	* id
 	*/
	private Integer id;
	/**
 	* pigNo
 	*/
	private Integer pigNo;
	/**
 	* time
 	*/
	private Date time;
	/**
 	* targetPigstytNo
 	*/
	private Integer targetPigstytNo;
	/**
 	* targetHogcoteNo
 	*/
	private Integer targetHogcoteNo;
	/**
 	* reason
 	*/
	private String reason;

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


  	public Date getTime() {
    	return time;
  	}

  	public void setTime(Date time) {
    	this.time = time;
  	}


  	public Integer getTargetPigstytNo() {
    	return targetPigstytNo;
  	}

  	public void setTargetPigstytNo(Integer targetPigstytNo) {
    	this.targetPigstytNo = targetPigstytNo;
  	}


  	public Integer getTargetHogcoteNo() {
    	return targetHogcoteNo;
  	}

  	public void setTargetHogcoteNo(Integer targetHogcoteNo) {
    	this.targetHogcoteNo = targetHogcoteNo;
  	}


  	public String getReason() {
    	return reason;
  	}

  	public void setReason(String reason) {
    	this.reason = reason;
  	}


}
