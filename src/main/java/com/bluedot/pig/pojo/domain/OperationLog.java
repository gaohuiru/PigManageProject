package com.bluedot.pig.pojo.domain;


import java.sql.Timestamp;
import java.util.Date;

/**
 * @author  xxbb
 */
public class OperationLog  {
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
 	* time
 	*/
	private Timestamp time;

	public OperationLog() {
	}

	public OperationLog(Integer employeeId, String service, String parameter, Timestamp time) {
		this.employeeId = employeeId;
		this.service = service;
		this.parameter = parameter;
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


	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
}
