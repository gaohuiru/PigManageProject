package com.bluedot.pig.pojo.domain;


/**
 * @author  xxbb
 */
public class DiseaseJudgeStandard  {
	/**
 	* pigVarietyId
 	*/
	private String pigVarietyId;
	/**
 	* growthStage
 	*/
	private Integer growthStage;
	/**
 	* temperature
 	*/
	private Double temperature;
	/**
 	* foodIntake
 	*/
	private Double foodIntake;
	/**
 	* pigStep
 	*/
	private Integer pigStep;

  	public String getPigVarietyId() {
    	return pigVarietyId;
  	}

  	public void setPigVarietyId(String pigVarietyId) {
    	this.pigVarietyId = pigVarietyId;
  	}


  	public Integer getGrowthStage() {
    	return growthStage;
  	}

  	public void setGrowthStage(Integer growthStage) {
    	this.growthStage = growthStage;
  	}


  	public Double getTemperature() {
    	return temperature;
  	}

  	public void setTemperature(Double temperature) {
    	this.temperature = temperature;
  	}


  	public Double getFoodIntake() {
    	return foodIntake;
  	}

  	public void setFoodIntake(Double foodIntake) {
    	this.foodIntake = foodIntake;
  	}


  	public Integer getPigStep() {
    	return pigStep;
  	}

  	public void setPigStep(Integer pigStep) {
    	this.pigStep = pigStep;
  	}


}
