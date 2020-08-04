package com.bluedot.pig.pojo.domain;


/**
 * @author  xxbb
 */
public class EnvironmentRecord  {
	/**
 	* id
 	*/
	private Integer id;
	/**
 	* pigstyNo
 	*/
	private Integer pigstyNo;
	/**
 	* temperature
 	*/
	private Double temperature;
	/**
 	* humidity
 	*/
	private Double humidity;
	/**
 	* nh3
 	*/
	private Double nh3;
	/**
 	* h2s
 	*/
	private Double h2s;
	/**
 	* co2
 	*/
	private Double co2;
	/**
 	* time
 	*/
	private java.util.Date time;

  	public Integer getId() {
    	return id;
  	}

  	public void setId(Integer id) {
    	this.id = id;
  	}


  	public Integer getPigstyNo() {
    	return pigstyNo;
  	}

  	public void setPigstyNo(Integer pigstyNo) {
    	this.pigstyNo = pigstyNo;
  	}


  	public Double getTemperature() {
    	return temperature;
  	}

  	public void setTemperature(Double temperature) {
    	this.temperature = temperature;
  	}


  	public Double getHumidity() {
    	return humidity;
  	}

  	public void setHumidity(Double humidity) {
    	this.humidity = humidity;
  	}


  	public Double getNh3() {
    	return nh3;
  	}

  	public void setNh3(Double nh3) {
    	this.nh3 = nh3;
  	}


  	public Double getH2s() {
    	return h2s;
  	}

  	public void setH2s(Double h2s) {
    	this.h2s = h2s;
  	}


  	public Double getCo2() {
    	return co2;
  	}

  	public void setCo2(Double co2) {
    	this.co2 = co2;
  	}


  	public java.util.Date getTime() {
    	return time;
  	}

  	public void setTime(java.util.Date time) {
    	this.time = time;
  	}


}
