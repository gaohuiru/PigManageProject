package com.bd.pigmanage.Po;

import java.util.List;
import java.util.Map;

/**
 * @author AlwaysXu
 */
public class DiseaseJudgeSet {
    //主键1，猪只的品种编号
    private Integer pigVarietyId;

    //主键2，1表示哺乳阶段、2表示保育阶段，3表示生长育肥阶段
    private Integer growthStage;

    //温度传感器反馈的猪只体温，单位是：摄氏度
    private Double temperature;

    //单位：kg（精确到0.01）
    private Double foodIntake;

    //预留字段，单位：步
    private Integer pigStep;

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
            pigVarietyId= Integer.parseInt(map.get("pigVarietyId").get(0).toString()) ;
        if(map.containsKey("growthStage"))
            growthStage= Integer.parseInt(map.get("growthStage").get(0).toString()) ;
        if(map.containsKey("temperature"))
            temperature= Double.parseDouble(map.get("temperature").get(0).toString()) ;
        if(map.containsKey("foodIntake"))
            foodIntake= Double.parseDouble(map.get("foodIntake").get(0).toString());
        if(map.containsKey("pigStep"))
            pigStep= Integer.parseInt(map.get("pigStep").get(0).toString()) ;

    }

    @Override
    public String toString() {
        return "DiseaseJudgeSet{" +
                "pigVarietyId=" + pigVarietyId +
                ", growthStage=" + growthStage +
                ", temperature=" + temperature +
                ", foodIntake=" + foodIntake +
                ", pigStep=" + pigStep +
                '}';
    }
}
