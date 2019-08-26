package com.bd.pigmanage.Po;

import java.util.List;
import java.util.Map;

/**
 * @author AlwaysXu
 */
public class DiseaseJudgeSet {
    //主键1，猪只的品种编号
    private int pigVarietyId;

    //主键2，1表示哺乳阶段、2表示保育阶段，3表示生长育肥阶段
    private int growthStage;

    //温度传感器反馈的猪只体温，单位是：摄氏度
    private double temperature;

    //单位：kg（精确到0.01）
    private double foodIntake;

    //预留字段，单位：步
    private int pigStep;

    public DiseaseJudgeSet() {
    }
    public DiseaseJudgeSet(int pigVarietyId,int growthStage,double temperature,double foodIntake,int pigStep) {
        this.pigVarietyId=pigVarietyId;
        this.growthStage=growthStage;
        this.temperature=temperature;
        this.foodIntake=foodIntake;
        this.pigStep=pigStep;
    }
    public DiseaseJudgeSet(Map<String, List<Object>> map) {
        if(map.containsKey("pigVarietyId"))
            pigVarietyId= Integer.parseInt((String) map.get("pigVarietyId").get(0)) ;
        if(map.containsKey("growthStage"))
            growthStage= Integer.parseInt((String) map.get("growthStage").get(0)) ;
        if(map.containsKey("temperature"))
            temperature= Double.parseDouble((String) map.get("temperature").get(0)) ;
        if(map.containsKey("foodIntake"))
            foodIntake= Double.parseDouble((String) map.get("foodIntake").get(0));
        if(map.containsKey("pigStep"))
            pigStep= Integer.parseInt((String) map.get("pigStep").get(0)) ;

    }

}
