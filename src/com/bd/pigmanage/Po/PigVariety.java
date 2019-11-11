package com.bd.pigmanage.Po;

import java.util.List;
import java.util.Map;

public class PigVariety {
    private Integer pigVarietyId;
    private String pigVariety;

    public PigVariety() {

    }
    public PigVariety(Integer pigVarietyId, String pigVariety) {
        this.pigVarietyId = pigVarietyId;
        this.pigVariety = pigVariety;
    }
    public PigVariety(Map<String, List<Object>> map) {
        if (map.containsKey("pigVarietyId")) {
            pigVarietyId = Integer.parseInt( map.get("pigVarietyId").get(0).toString());
        }
        if (map.containsKey("pigVariety")) {
            pigVariety = map.get("pigVariety").get(0).toString();
        }
    }

    public Integer getPigVarietyId() {
        return pigVarietyId;
    }

    public String getPigVariety() {
        return pigVariety;
    }

    public void setPigVarietyId(Integer pigVarietyId) {
        this.pigVarietyId = pigVarietyId;
    }

    public void setPigVariety(String pigVariety) {
        this.pigVariety = pigVariety;
    }

    @Override
    public String toString() {
        return "PigVariety{" +
                "pigVarietyId=" + pigVarietyId +
                ", pigVariety='" + pigVariety + '\'' +
                '}';
    }
}
