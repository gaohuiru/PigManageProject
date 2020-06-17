package com.bluedot.pig.pojo;

import java.util.List;
import java.util.Map;

public class IllnessRecord {
   private Integer id;
   private Integer pigNo;
   private Integer drugSpecies;
   private String time;
   private Integer totalAmount;
   private String illDate;
   private Integer illType;
   private String description;

    public IllnessRecord() {
    }

    public IllnessRecord(Integer id, Integer pigNo, Integer drugSpecies, String time, Integer totalAmount, String illDate, Integer illType, String description) {
        this.id = id;
        this.pigNo = pigNo;
        this.drugSpecies = drugSpecies;
        this.time = time;
        this.totalAmount = totalAmount;
        this.illDate = illDate;
        this.illType = illType;
        this.description = description;
    }
    public IllnessRecord(Map<String, List<Object>> map){
        if(map.containsKey("id"))
            id= Integer.parseInt(map.get("id").get(0).toString()) ;
        if(map.containsKey("pigNo"))
            pigNo= Integer.parseInt(map.get("pigNo").get(0).toString()) ;
        if(map.containsKey("drugSpecies"))
            drugSpecies= Integer.parseInt(map.get("drugSpecies").get(0).toString()) ;
        if(map.containsKey("time"))
            time= map.get("time").get(0).toString();
        if(map.containsKey("totalAmount"))
            totalAmount= Integer.parseInt(map.get("totalAmount").get(0).toString()) ;
        if(map.containsKey("illDate"))
            illDate= map.get("illDate").get(0).toString();
        if(map.containsKey("illType"))
            illType= Integer.parseInt(map.get("illType").get(0).toString()) ;
        if(map.containsKey("description"))
            description= map.get("description").get(0).toString() ;
    }

    @Override
    public String toString() {
        return "IllnessRecord{" +
                "id=" + id +
                ", pigNo=" + pigNo +
                ", drugSpecies=" + drugSpecies +
                ", time='" + time + '\'' +
                ", totalAmount=" + totalAmount +
                ", illDate='" + illDate + '\'' +
                ", illType=" + illType +
                ", description='" + description + '\'' +
                '}';
    }

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

    public Integer getDrugSpecies() {
        return drugSpecies;
    }

    public void setDrugSpecies(Integer drugSpecies) {
        this.drugSpecies = drugSpecies;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getIllDate() {
        return illDate;
    }

    public void setIllDate(String illDate) {
        this.illDate = illDate;
    }

    public Integer getIllType() {
        return illType;
    }

    public void setIllType(Integer illType) {
        this.illType = illType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
