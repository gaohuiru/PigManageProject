package com.bluedot.pig.pojo;

import java.util.List;
import java.util.Map;

public class PigInfo {
    private String pigNo;
    private Integer sex;
    private Integer age;
    private Integer pigVarietyId;
    private Integer pigType;
    private Integer pigState;
    private Integer growthStage;
    private String birthday;
    private Double pigRecentWeight;
    private Integer vaccinumCount;
    private Integer pigstyNo;
    private Integer hogcoteNo;
    private Double pigBasicWeight;
    private String enterDate;
    private String leaveDate;

    public PigInfo() {
    }

    public PigInfo(String pigNo, Integer sex, Integer age, Integer pigVarietyId, Integer pigType, Integer pigState, Integer growthStage, String birthday, Double pigRecentWeight, Integer vaccinumCount, Integer pigstyNo, Integer hogcoteNo, Double pigBasicWeight, String enterDate, String leaveDate) {
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

    public PigInfo(Map<String, List<Object>> map) {
        if (map.containsKey("pigNo")) {
            pigNo = map.get("pigNo").get(0).toString();
        }
        if (map.containsKey("sex")) {
            sex = Integer.parseInt(map.get("sex").get(0).toString());
        }
        if (map.containsKey("age")) {
            age = Integer.parseInt(map.get("age").get(0).toString());
        }
        if (map.containsKey("pigVarietyId")) {
            pigVarietyId = Integer.parseInt(map.get("pigVarietyId").get(0).toString());
        }
        if (map.containsKey("pigType")) {
            pigType = Integer.parseInt(map.get("pigType").get(0).toString());
        }
        if (map.containsKey("pigState")) {
            pigState = Integer.parseInt(map.get("pigState").get(0).toString());
        }
        if (map.containsKey("growthStage")) {
            growthStage = Integer.parseInt(map.get("growthStage").get(0).toString());
        }
        if (map.containsKey("birthday")) {
            birthday = map.get("birthday").get(0).toString();
        }
        if (map.containsKey("pigRecentWeight")) {
            pigRecentWeight = Double.parseDouble(map.get("pigRecentWeight").get(0).toString());
        }
        if (map.containsKey("vaccinumCount")) {
            vaccinumCount = Integer.parseInt(map.get("vaccinumCount").get(0).toString());
        }
        if (map.containsKey("pigstyNo")) {
            pigstyNo = Integer.parseInt(map.get("pigstyNo").get(0).toString());
        }
        if (map.containsKey("hogcoteNo")) {
            hogcoteNo = Integer.parseInt(map.get("hogcoteNo").get(0).toString());
        }
        if (map.containsKey("pigBasicWeight")) {
            pigBasicWeight = Double.parseDouble(map.get("pigBasicWeight").get(0).toString());
        }
        if (map.containsKey("enterDate")) {
            enterDate = map.get("enterDate").get(0).toString();
        }
        if (map.containsKey("leaveDate")) {
            leaveDate = map.get("leaveDate").get(0).toString();
        }
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
                ", birthday='" + birthday + '\'' +
                ", pigRecentWeight=" + pigRecentWeight +
                ", vaccinumCount=" + vaccinumCount +
                ", pigstyNo=" + pigstyNo +
                ", hogcoteNo=" + hogcoteNo +
                ", pigBasicWeight=" + pigBasicWeight +
                ", enterDate='" + enterDate + '\'' +
                ", leaveDate='" + leaveDate + '\'' +
                '}';
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }


}
