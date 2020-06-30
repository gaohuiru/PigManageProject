package com.bluedot.pig.pojo.domain;


import java.util.Date;

/**
 * @author  xxbb
 */
public class LoginLog  {
	/**
 	* id
 	*/
	private Integer id;
	/**
 	* employeeId
 	*/
	private Integer employeeId;
	/**
 	* ip
 	*/
	private String ip;
	/**
 	* userAgent
 	*/
	private String userAgent;
	/**
 	* ifSucceed
 	*/
	private Integer ifSucceed;
	/**
 	* time
 	*/
	private java.util.Date time;
	/**
 	* msg
 	*/
	private String msg;

	public LoginLog() {
	}

	public LoginLog(Integer employeeId, String ip, String userAgent, Integer ifSucceed, Date time, String msg) {
		this.employeeId = employeeId;
		this.ip = ip;
		this.userAgent = userAgent;
		this.ifSucceed = ifSucceed;
		this.time = time;
		this.msg = msg;
	}

	public Integer getId() {
    	return id;
  	}

  	public void setId(Integer id) {
    	this.id = id;
  	}


  	public Integer getEmployeeId() {
    	return employeeId;
  	}

  	public void setEmployeeId(Integer employeeId) {
    	this.employeeId = employeeId;
  	}


  	public String getIp() {
    	return ip;
  	}

  	public void setIp(String ip) {
    	this.ip = ip;
  	}


  	public String getUserAgent() {
    	return userAgent;
  	}

  	public void setUserAgent(String userAgent) {
    	this.userAgent = userAgent;
  	}


  	public Integer getIfSucceed() {
    	return ifSucceed;
  	}

  	public void setIfSucceed(Integer ifSucceed) {
    	this.ifSucceed = ifSucceed;
  	}


  	public java.util.Date getTime() {
    	return time;
  	}

  	public void setTime(java.util.Date time) {
    	this.time = time;
  	}


  	public String getMsg() {
    	return msg;
  	}

  	public void setMsg(String msg) {
    	this.msg = msg;
  	}


}
