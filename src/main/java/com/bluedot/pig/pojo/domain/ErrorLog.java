package com.bluedot.pig.pojo.domain;


import java.sql.Timestamp;
import java.util.Date;

/**
 * @author  xxbb
 */
public class ErrorLog  {
	/**
 	* id
 	*/
	private Integer id;
	/**
 	* employeeId
 	*/
	private Integer employeeId;
	/**
 	* service
 	*/
	private String service;
	/**
 	* parameter
 	*/
	private String parameter;
	/**
 	* errorMsg
 	*/
	private String errorMsg;
	/**
 	* time
 	*/
	private Timestamp time;

	public ErrorLog() {
	}

	public ErrorLog(Integer employeeId, String service, String parameter, String errorMsg, Timestamp time) {
		this.employeeId = employeeId;
		this.service = service;
		this.parameter = parameter;
		this.errorMsg = errorMsg;
		this.time = time;
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


  	public String getService() {
    	return service;
  	}

  	public void setService(String service) {
    	this.service = service;
  	}


  	public String getParameter() {
    	return parameter;
  	}

  	public void setParameter(String parameter) {
    	this.parameter = parameter;
  	}


  	public String getErrorMsg() {
    	return errorMsg;
  	}

  	public void setErrorMsg(String errorMsg) {
    	this.errorMsg = errorMsg;
  	}


	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
}
