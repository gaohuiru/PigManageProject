package com.bd.pigmanage.Po;

import java.util.List;
import java.util.Map;

public class VaccinationSet {
    private Integer id;
    private Integer vaccineSpecies;
    private String inoculationTime;
    private Integer totalAmount;
    private String inoculationExplain;
    private Integer hogcoteNo;
    private String setTime;

    public VaccinationSet(Map<String, List<Object>> map){
        if(map.containsKey("id"))
            id= Integer.parseInt(map.get("id").get(0).toString()) ;
        if(map.containsKey("vaccineSpecies"))
            vaccineSpecies= Integer.parseInt(map.get("vaccineSpecies").get(0).toString()) ;
        if(map.containsKey("inoculationTime"))
            inoculationTime= map.get("inoculationTime").get(0).toString() ;
        if(map.containsKey("totalAmount"))
            totalAmount= Integer.parseInt(map.get("totalAmount").get(0).toString());
        if(map.containsKey("inoculationExplain"))
            inoculationExplain= map.get("inoculationExplain").get(0).toString();
        if(map.containsKey("hogcoteNo"))
            totalAmount= Integer.parseInt(map.get("totalAmount").get(0).toString());
        if(map.containsKey("setTime"))
            setTime= map.get("setTime").get(0).toString();

    }

    public VaccinationSet(Integer id, Integer vaccineSpecies, String inoculationTime, Integer totalAmount, String inoculationExplain, Integer hogcoteNo, String setTime) {
        this.id = id;
        this.vaccineSpecies = vaccineSpecies;
        this.inoculationTime = inoculationTime;
        this.totalAmount = totalAmount;
        this.inoculationExplain = inoculationExplain;
        this.hogcoteNo = hogcoteNo;
        this.setTime = setTime;
    }

    public VaccinationSet() {
    }

    @Override
    public String toString() {
        return "VaccinateSet{" +
                "id=" + id +
                ", vaccineSpecies=" + vaccineSpecies +
                ", inoculationTime='" + inoculationTime + '\'' +
                ", totalAmount=" + totalAmount +
                ", inoculationExplain='" + inoculationExplain + '\'' +
                ", hogcoteNo=" + hogcoteNo +
                ", setTime='" + setTime + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVaccineSpecies() {
        return vaccineSpecies;
    }

    public void setVaccineSpecies(Integer vaccineSpecies) {
        this.vaccineSpecies = vaccineSpecies;
    }

    public String getInoculationTime() {
        return inoculationTime;
    }

    public void setInoculationTime(String inoculationTime) {
        this.inoculationTime = inoculationTime;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getInoculationExplain() {
        return inoculationExplain;
    }

    public void setInoculationExplain(String inoculationExplain) {
        this.inoculationExplain = inoculationExplain;
    }

    public Integer getHogcoteNo() {
        return hogcoteNo;
    }

    public void setHogcoteNo(Integer hogcoteNo) {
        this.hogcoteNo = hogcoteNo;
    }

    public String getSetTime() {
        return setTime;
    }

    public void setSetTime(String setTime) {
        this.setTime = setTime;
    }
}
