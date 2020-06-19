package com.bluedot.pig.pojo.domain;

import java.util.Date;

/**
 * @author  xxbb
 */
public class AbnormalRecord  {
	/**
 	* exceptionNo
 	*/
	private Integer exceptionNo;
	/**
 	* goodsNo
 	*/
	private String goodsNo;
	/**
 	* time
 	*/
	private Date time;
	/**
 	* pMethod
 	*/
	private String pMethod;
	/**
 	* realName
 	*/
	private String realName;

  	public Integer getExceptionNo() {
    	return exceptionNo;
  	}

  	public void setExceptionNo(Integer exceptionNo) {
    	this.exceptionNo = exceptionNo;
  	}


  	public String getGoodsNo() {
    	return goodsNo;
  	}

  	public void setGoodsNo(String goodsNo) {
    	this.goodsNo = goodsNo;
  	}


  	public Date getTime() {
    	return time;
  	}

  	public void setTime(Date time) {
    	this.time = time;
  	}


  	public String getPMethod() {
    	return pMethod;
  	}

  	public void setPMethod(String pMethod) {
    	this.pMethod = pMethod;
  	}


  	public String getRealName() {
    	return realName;
  	}

  	public void setRealName(String realName) {
    	this.realName = realName;
  	}


}
