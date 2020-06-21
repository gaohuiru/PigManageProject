package com.bluedot.pig.pojo.domain;

import java.sql.Date;

/**
 * @author  xxbb
 */
public class Employee  {
	/**
 	* employeeId
 	*/
	private Integer employeeId;
	/**
 	* realName
 	*/
	private String realName;
	/**
 	* sex
 	*/
	private Integer sex;
	/**
 	* age
 	*/
	private Integer age;
	/**
 	* identityNumber
 	*/
	private String identityNumber;
	/**
 	* telephone
 	*/
	private String telephone;
	/**
 	* email
 	*/
	private String email;
	/**
 	* image
 	*/
	private String image;
	/**
 	* position
 	*/
	private Integer position;
	/**
 	* address
 	*/
	private String address;
	/**
 	* entryTime
 	*/
	private Date entryTime;
	/**
 	* workingYears
 	*/
	private Integer workingYears;
	/**
 	* status
 	*/
	private Integer status;
	/**
 	* password
 	*/
	private String password;

  	public Integer getEmployeeId() {
    	return employeeId;
  	}

  	public void setEmployeeId(Integer employeeId) {
    	this.employeeId = employeeId;
  	}


  	public String getRealName() {
    	return realName;
  	}

  	public void setRealName(String realName) {
    	this.realName = realName;
  	}


  	public Integer getSex() {
    	return sex;
  	}

  	public void setSex(Integer sex) {
    	this.sex = sex;
  	}


  	public Integer getAge() {
    	return age;
  	}

  	public void setAge(Integer age) {
    	this.age = age;
  	}


  	public String getIdentityNumber() {
    	return identityNumber;
  	}

  	public void setIdentityNumber(String identityNumber) {
    	this.identityNumber = identityNumber;
  	}


  	public String getTelephone() {
    	return telephone;
  	}

  	public void setTelephone(String telephone) {
    	this.telephone = telephone;
  	}


  	public String getEmail() {
    	return email;
  	}

  	public void setEmail(String email) {
    	this.email = email;
  	}


  	public String getImage() {
    	return image;
  	}

  	public void setImage(String image) {
    	this.image = image;
  	}


  	public Integer getPosition() {
    	return position;
  	}

  	public void setPosition(Integer position) {
    	this.position = position;
  	}


  	public String getAddress() {
    	return address;
  	}

  	public void setAddress(String address) {
    	this.address = address;
  	}


  	public Date getEntryTime() {
    	return entryTime;
  	}

  	public void setEntryTime(Date entryTime) {
    	this.entryTime = entryTime;
  	}


  	public Integer getWorkingYears() {
    	return workingYears;
  	}

  	public void setWorkingYears(Integer workingYears) {
    	this.workingYears = workingYears;
  	}


  	public Integer getStatus() {
    	return status;
  	}

  	public void setStatus(Integer status) {
    	this.status = status;
  	}


  	public String getPassword() {
    	return password;
  	}

  	public void setPassword(String password) {
    	this.password = password;
  	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeeId=" + employeeId +
				", realName='" + realName + '\'' +
				", sex=" + sex +
				", age=" + age +
				", identityNumber='" + identityNumber + '\'' +
				", telephone='" + telephone + '\'' +
				", email='" + email + '\'' +
				", image='" + image + '\'' +
				", position=" + position +
				", address='" + address + '\'' +
				", entryTime=" + entryTime +
				", workingYears=" + workingYears +
				", status=" + status +
				", password='" + password + '\'' +
				'}';
	}
}
