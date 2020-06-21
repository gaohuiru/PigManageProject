package com.bluedot.pig.pojo.domain;

import java.sql.Date;

/**
 * @author  xxbb
 */
public class PigFeed  {
	/**
 	* id
 	*/
	private Integer id;
	/**
 	* pigNo
 	*/
	private Integer pigNo;
	/**
 	* feedTake
 	*/
	private Double feedTake;
	/**
 	* pigRecentWeight
 	*/
	private Double pigRecentWeight;
	/**
 	* recordTime
 	*/
	private Date recordTime;
	/**
 	* avgWeight
 	*/
	private Double avgWeight;

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


  	public Double getFeedTake() {
    	return feedTake;
  	}

  	public void setFeedTake(Double feedTake) {
    	this.feedTake = feedTake;
  	}


  	public Double getPigRecentWeight() {
    	return pigRecentWeight;
  	}

  	public void setPigRecentWeight(Double pigRecentWeight) {
    	this.pigRecentWeight = pigRecentWeight;
  	}


  	public Date getRecordTime() {
    	return recordTime;
  	}

  	public void setRecordTime(Date recordTime) {
    	this.recordTime = recordTime;
  	}


  	public Double getAvgWeight() {
    	return avgWeight;
  	}

  	public void setAvgWeight(Double avgWeight) {
    	this.avgWeight = avgWeight;
  	}


}
