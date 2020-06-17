package com.bluedot.pig.pojo;

import java.util.List;
import java.util.Map;

public class FeedStandard {
    private Integer feedSettingNo;
    private Integer pigVarietyId;
    private Integer sex;
    private Integer pigType;
    private Integer pigState;
    private Integer growthStage;
    private Double foodRate;
    private Double waterRate;
    private Double drugRate;
    private Double totalWeight;
    private Integer feedCount;
    private String feedTime;
    private String feedLastTime;
    private String feedIntervalTime;
    private Double upperWeight;
    private Double lowerWeight;
    private String realName;

    public FeedStandard(Map<String,List<Object>> map){
        if (map.containsKey("feedSettingNo")) {
            feedSettingNo =Integer.parseInt(map.get("feedSettingNo").get(0).toString());
        }
        if (map.containsKey("pigVarietyId")) {
            pigVarietyId =Integer.parseInt(map.get("pigVarietyId").get(0).toString());
        }
        if (map.containsKey("sex")) {
            sex =Integer.parseInt(map.get("sex").get(0).toString());
        }
        if (map.containsKey("pigType")) {
            pigType =Integer.parseInt(map.get("pigType").get(0).toString());
        }
        if (map.containsKey("pigState")) {
            pigState =Integer.parseInt(map.get("pigState").get(0).toString());
        }
        if (map.containsKey("growthStage")) {
            growthStage =Integer.parseInt(map.get("growthStage").get(0).toString());
        }
        if (map.containsKey("foodRate")) {
            foodRate =Double.parseDouble(map.get("foodRate").get(0).toString());
        }
        if (map.containsKey("waterRate")) {
            waterRate =Double.parseDouble(map.get("waterRate").get(0).toString());
        }
        if (map.containsKey("drugRate")) {
            drugRate =Double.parseDouble(map.get("drugRate").get(0).toString());
        }
        if (map.containsKey("totalWeight")) {
            totalWeight =Double.parseDouble(map.get("totalWeight").get(0).toString());
        }
        if (map.containsKey("feedCount")) {
            feedCount =Integer.parseInt(map.get("feedCount").get(0).toString());
        }
        if (map.containsKey("feedTime")) {
            feedTime =map.get("feedTime").get(0).toString();
        }
        if (map.containsKey("feedLastTime")) {
            feedLastTime =map.get("feedLastTime").get(0).toString();
        }
        if (map.containsKey("feedIntervalTime")) {
            feedIntervalTime =map.get("feedIntervalTime").get(0).toString();
        }
        if (map.containsKey("upperWeight")) {
            upperWeight =Double.parseDouble(map.get("upperWeight").get(0).toString());
        }
        if (map.containsKey("lowerWeight")) {
            lowerWeight =Double.parseDouble(map.get("lowerWeight").get(0).toString());
        }
        if (map.containsKey("realName")) {
            realName =map.get("realName").get(0).toString();
        }


    }








    public FeedStandard(){

    }

    public FeedStandard(Integer feedSettingNo, Integer pigVarietyId, Integer sex, Integer pigType, Integer pigState, Integer growthStage, Double foodRate, Double waterRate, Double drugRate, Double totalWeight, Integer feedCount, String feedTime, String feedLastTime,String feedIntervalTime, Double upperWeight, Double lowerWeight, String realName) {
        this.feedSettingNo = feedSettingNo;
        this.pigVarietyId = pigVarietyId;
        this.sex = sex;
        this.pigType = pigType;
        this.pigState = pigState;
        this.growthStage = growthStage;
        this.foodRate = foodRate;
        this.waterRate = waterRate;
        this.drugRate = drugRate;
        this.totalWeight = totalWeight;
        this.feedCount = feedCount;
        this.feedTime = feedTime;
        this.feedLastTime = feedLastTime;
        this.feedIntervalTime = feedIntervalTime;
        this.upperWeight = upperWeight;
        this.lowerWeight = lowerWeight;
        this.realName = realName;
    }

    public Integer getFeedSettingNo() {
        return feedSettingNo;
    }

    public void setFeedSettingNo(Integer feedSettingNo) {
        this.feedSettingNo = feedSettingNo;
    }

    public Integer getpigVarietyId() {
        return pigVarietyId;
    }

    public void setpigVarietyId(Integer pigVarietyId) {
        this.pigVarietyId = pigVarietyId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Double getFoodRate() {
        return foodRate;
    }

    public void setFoodRate(Double foodRate) {
        this.foodRate = foodRate;
    }

    public Double getWaterRate() {
        return waterRate;
    }

    public void setWaterRate(Double waterRate) {
        this.waterRate = waterRate;
    }

    public Double getDrugRate() {
        return drugRate;
    }

    public void setDrugRate(Double drugRate) {
        this.drugRate = drugRate;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Integer getFeedCount() {
        return feedCount;
    }

    public void setFeedCount(Integer feedCount) {
        this.feedCount = feedCount;
    }

    public String getFeedTime() {
        return feedTime;
    }

    public void setFeedTime(String feedTime) {
        this.feedTime = feedTime;
    }

    public String getFeedLastTime() {
        return feedLastTime;
    }

    public void setFeedLastTime(String feedLastTime) {
        this.feedLastTime = feedLastTime;
    }

    public String getFeedIntervalTime() {
        return feedIntervalTime;
    }

    public void setFeedIntervalTime(String feedIntervalTime) {
        this.feedIntervalTime = feedIntervalTime;
    }

    public Double getUpperWeight() {
        return upperWeight;
    }

    public void setUpperWeight(Double upperWeight) {
        this.upperWeight = upperWeight;
    }

    public Double getLowerWeight() {
        return lowerWeight;
    }

    public void setLowerWeight(Double lowerWeight) {
        this.lowerWeight = lowerWeight;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "FeedStandard{" +
                "feedSettingNo=" + feedSettingNo +
                ", pigVarietyId=" + pigVarietyId +
                ", sex=" + sex +
                ", pigType=" + pigType +
                ", pigState=" + pigState +
                ", growthStage=" + growthStage +
                ", foodRate=" + foodRate +
                ", waterRate=" + waterRate +
                ", drugRate=" + drugRate +
                ", totalWeight=" + totalWeight +
                ", feedCount=" + feedCount +
                ", feedTime='" + feedTime + '\'' +
                ", feedLastTime='" + feedLastTime + '\'' +
                ", feedIntervalTime='" + feedIntervalTime + '\'' +
                ", upperWeight=" + upperWeight +
                ", lowerWeight=" + lowerWeight +
                ", realName='" + realName + '\'' +
                '}';
    }
}
