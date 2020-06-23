package com.bluedot.pig.pojo.domain;

import java.sql.Date;

/**
 * @author  xxbb
 */
public class PigInfo  {
	/**
 	* pigNo
 	*/
	private String pigNo;
	/**
 	* sex
 	*/
	private Integer sex;
	/**
 	* age
 	*/
	private Integer age;
	/**
 	* pigVarietyId
 	*/
	private Integer pigVarietyId;
	/**
 	* pigType
 	*/
	private Integer pigType;
	/**
 	* pigState
 	*/
	private Integer pigState;
	/**
 	* growthStage
 	*/
	private Integer growthStage;
	/**
 	* birthday
 	*/
	private Date birthday;
	/**
 	* pigRecentWeight
 	*/
	private Double pigRecentWeight;
	/**
 	* vaccinumCount
 	*/
	private Integer vaccinumCount;
	/**
 	* pigstyNo
 	*/
	private Integer pigstyNo;
	/**
 	* hogcoteNo
 	*/
	private Integer hogcoteNo;
	/**
 	* pigBasicWeight
 	*/
	private Double pigBasicWeight;
	/**
 	* enterDate
 	*/
	private Date enterDate;
	/**
 	* leaveDate
 	*/
	private Date leaveDate;

	public PigInfo() {
	}

	public PigInfo(String pigNo, Integer sex, Integer age, Integer pigVarietyId, Integer pigType, Integer pigState, Integer growthStage, Date birthday, Double pigRecentWeight, Integer vaccinumCount, Integer pigstyNo, Integer hogcoteNo, Double pigBasicWeight, Date enterDate) {
		this.pigNo = pigNo;
		this.sex = sex;
		this.age = age;
		this.pigVarietyId = pigVarietyId;
		this.pigType = pigType;
		this.pigState = pigState;
		this.growthStage = growthStage;
		this.birthday = birthday;
		this.pigRecentWeight = pigRecentWeight;
		this.vaccinumCount = vaccinumCount;
		this.pigstyNo = pigstyNo;
		this.hogcoteNo = hogcoteNo;
		this.pigBasicWeight = pigBasicWeight;
		this.enterDate = enterDate;
	}

	public PigInfo(String pigNo, Integer sex, Integer age, Integer pigVarietyId, Integer pigType, Integer pigState, Integer growthStage, Date birthday, Double pigRecentWeight, Integer vaccinumCount, Integer pigstyNo, Integer hogcoteNo, Double pigBasicWeight, Date enterDate, Date leaveDate) {
		this.pigNo = pigNo;
		this.sex = sex;
		this.age = age;
		this.pigVarietyId = pigVarietyId;
		this.pigType = pigType;
		this.pigState = pigState;
		this.growthStage = growthStage;
		this.birthday = birthday;
		this.pigRecentWeight = pigRecentWeight;
		this.vaccinumCount = vaccinumCount;
		this.pigstyNo = pigstyNo;
		this.hogcoteNo = hogcoteNo;
		this.pigBasicWeight = pigBasicWeight;
		this.enterDate = enterDate;
		this.leaveDate = leaveDate;
	}

	public String getPigNo() {
    	return pigNo;
  	}

  	public void setPigNo(String pigNo) {
    	this.pigNo = pigNo;
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


  	public Integer getPigVarietyId() {
    	return pigVarietyId;
  	}

  	public void setPigVarietyId(Integer pigVarietyId) {
    	this.pigVarietyId = pigVarietyId;
  	}


  	public Integer getPigType() {
    	return pigType;
  	}

  	public void setPigType(Integer pigType) {
    	this.pigType = pigType;
  	}


  	public Integer getPigState() {
    	return pigState;
  	}

  	public void setPigState(Integer pigState) {
    	this.pigState = pigState;
  	}


  	public Integer getGrowthStage() {
    	return growthStage;
  	}

  	public void setGrowthStage(Integer growthStage) {
    	this.growthStage = growthStage;
  	}


  	public Date getBirthday() {
    	return birthday;
  	}

  	public void setBirthday(Date birthday) {
    	this.birthday = birthday;
  	}


  	public Double getPigRecentWeight() {
    	return pigRecentWeight;
  	}

  	public void setPigRecentWeight(Double pigRecentWeight) {
    	this.pigRecentWeight = pigRecentWeight;
  	}


  	public Integer getVaccinumCount() {
    	return vaccinumCount;
  	}

  	public void setVaccinumCount(Integer vaccinumCount) {
    	this.vaccinumCount = vaccinumCount;
  	}


  	public Integer getPigstyNo() {
    	return pigstyNo;
  	}

  	public void setPigstyNo(Integer pigstyNo) {
    	this.pigstyNo = pigstyNo;
  	}


  	public Integer getHogcoteNo() {
    	return hogcoteNo;
  	}

  	public void setHogcoteNo(Integer hogcoteNo) {
    	this.hogcoteNo = hogcoteNo;
  	}


  	public Double getPigBasicWeight() {
    	return pigBasicWeight;
  	}

  	public void setPigBasicWeight(Double pigBasicWeight) {
    	this.pigBasicWeight = pigBasicWeight;
  	}


  	public Date getEnterDate() {
    	return enterDate;
  	}

  	public void setEnterDate(Date enterDate) {
    	this.enterDate = enterDate;
  	}


  	public Date getLeaveDate() {
    	return leaveDate;
  	}

  	public void setLeaveDate(Date leaveDate) {
    	this.leaveDate = leaveDate;
  	}

	@Override
	public String toString() {
		return "PigInfo{" +
				"pigNo='" + pigNo + '\'' +
				", sex=" + sex +
				", age=" + age +
				", pigVarietyId=" + pigVarietyId +
				", pigType=" + pigType +
				", pigState=" + pigState +
				", growthStage=" + growthStage +
				", birthday=" + birthday +
				", pigRecentWeight=" + pigRecentWeight +
				", vaccinumCount=" + vaccinumCount +
				", pigstyNo=" + pigstyNo +
				", hogcoteNo=" + hogcoteNo +
				", pigBasicWeight=" + pigBasicWeight +
				", enterDate=" + enterDate +
				", leaveDate=" + leaveDate +
				'}';
	}
}
