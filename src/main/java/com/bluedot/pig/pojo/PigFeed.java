package com.bluedot.pig.pojo;

import java.util.List;
import java.util.Map;

public class PigFeed {
    private Integer id;
    private String pigNo;
    private Double feedTake;
    private Double avgWeight;
    private Double pigRecentWeight;
    private String recordTime;

    public PigFeed(){

    }

    public PigFeed(Integer id, String pigNo, Double feedTake, Double avgWeight, Double pigRecentWeight, String recordTime) {
        this.id = id;
        this.pigNo = pigNo;
        this.feedTake = feedTake;
        this.avgWeight = avgWeight;
        this.pigRecentWeight = pigRecentWeight;
        this.recordTime = recordTime;
    }

    public PigFeed(Map<String, List<Object>> map) {
        if (map.containsKey("id")) {
            id = Integer.parseInt( map.get("id").get(0).toString());
        }
        if (map.containsKey("pigNo")) {
            pigNo = map.get("pigNo").get(0).toString();
        }
        if (map.containsKey("feedTake")) {
            feedTake = Double.parseDouble( map.get("feedTake").get(0).toString());
        }
        if (map.containsKey("avgWeight")) {
            avgWeight = Double.parseDouble( map.get("avgWeight").get(0).toString());
        }
        if (map.containsKey("pigRecentWeight")) {
            pigRecentWeight = Double.parseDouble( map.get("pigRecentWeight").get(0).toString());
        }
        if(map.containsKey("recordTime")){
            recordTime = map.get("recordTime").get(0).toString();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPigNo() {
        return pigNo;
    }

    public void setPigNo(String pigNo) {
        this.pigNo = pigNo;
    }

    public Double getfeedTake() {
        return feedTake;
    }

    public void setfeedTake(Double feedTake) {
        this.feedTake = feedTake;
    }

    public Double getAvgWeight() {
        return avgWeight;
    }

    public void setAvgWeight(Double avgWeight) {
        this.avgWeight = avgWeight;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public Double getPigRecentWeight() {
        return pigRecentWeight;
    }

    public void setPigRecentWeight(Double pigRecentWeight) {
        this.pigRecentWeight = pigRecentWeight;
    }

    @Override
    public String toString() {
        return "PigFeed{" +
                "id=" + id +
                ", pigNo='" + pigNo + '\'' +
                ", feedTake=" + feedTake +
                ", avgWeight=" + avgWeight +
                ", pigRecentWeight=" + pigRecentWeight +
                ", recordTime='" + recordTime + '\'' +
                '}';
    }

}
