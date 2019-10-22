package com.bd.pigmanage.Po;

import java.util.List;
import java.util.Map;

public class VaccinationRecord {
    private Integer id;
    private Integer pigNo;
    private String inoculationTime;
    private String vaccineSpecies;
    private String inoculationReason;

    public VaccinationRecord() {
    }

    public VaccinationRecord(Integer id, Integer pigNo, String inoculationTime, String vaccineSpecies, String inoculationReason) {
        this.id = id;
        this.pigNo = pigNo;
        this.inoculationTime = inoculationTime;
        this.vaccineSpecies = vaccineSpecies;
        this.inoculationReason = inoculationReason;
    }

    public VaccinationRecord(Map<String, List<Object>> map){
        if(map.containsKey("id"))
            id= Integer.parseInt(map.get("id").get(0).toString()) ;
        if(map.containsKey("pigNo"))
            pigNo= Integer.parseInt(map.get("pigNo").get(0).toString()) ;
        if(map.containsKey("inoculationTime"))
            inoculationTime= map.get("inoculationTime").get(0).toString() ;
        if(map.containsKey("vaccineSpecies"))
            vaccineSpecies= map.get("vaccineSpecies").get(0).toString();
        if(map.containsKey("inoculationReason"))
            inoculationReason= map.get("inoculationReason").get(0).toString();

    }

    @Override
    public String toString() {
        return "VaccinateList{" +
                "id=" + id +
                ", pigNo=" + pigNo +
                ", inoculationTime='" + inoculationTime + '\'' +
                ", vaccineSpecies='" + vaccineSpecies + '\'' +
                ", inoculationReason='" + inoculationReason + '\'' +
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

    public String getInoculationTime() {
        return inoculationTime;
    }

    public void setInoculationTime(String inoculationTime) {
        this.inoculationTime = inoculationTime;
    }

    public String getVaccineSpecies() {
        return vaccineSpecies;
    }

    public void setVaccineSpecies(String vaccineSpecies) {
        this.vaccineSpecies = vaccineSpecies;
    }

    public String getInoculationReason() {
        return inoculationReason;
    }

    public void setInoculationReason(String inoculationReason) {
        this.inoculationReason = inoculationReason;
    }
}
