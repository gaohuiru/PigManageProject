package com.bd.pigmanage.Po;

import java.util.List;
import java.util.Map;

public class InInformation {
    private String importNo;
    private String goodsNo;
    private String sellerSite;
    private String sellerPeople;
    private String realName;
    private String goodsCompany;

    private Double importNum;
    private String importTime;
    private String outtimeDay;
    private String birthGoods;
    private Double goodsMoney;
    private Integer expirationLimit;

    public InInformation(String importNo, String goodsNo, String sellerSite, String sellerPeople, String realName, String goodsCompany, Double importNum, String importTime, String outtimeDay, String birthGoods, Double goodsMoney, Integer expirationLimit) {
        this.importNo = importNo;
        this.goodsNo = goodsNo;
        this.sellerSite = sellerSite;
        this.sellerPeople = sellerPeople;
        this.realName = realName;
        this.goodsCompany = goodsCompany;

        this.importNum = importNum;
        this.importTime = importTime;
        this.outtimeDay = outtimeDay;
        this.birthGoods = birthGoods;
        this.goodsMoney = goodsMoney;
        this.expirationLimit = expirationLimit;
    }

    public InInformation(Map<String, List<Object>> map) {
        if(map.containsKey("importNo"))
            importNo= (String) map.get("importNo").get(0) ;
        if(map.containsKey("goodsNo"))
            goodsNo= (String) map.get("goodsNo").get(0) ;
        if(map.containsKey("sellerSite"))
            sellerSite=(String) map.get("sellerSite").get(0) ;
        if(map.containsKey("sellerPeople"))
            sellerPeople= (String) map.get("sellerPeople").get(0) ;
        if(map.containsKey("realName"))
            realName= (String) map.get("realName").get(0) ;
        if(map.containsKey("goodsCompany"))
            goodsCompany=(String) map.get("goodsCompany").get(0) ;
        if(map.containsKey("goodsNo"))
            importTime= (String) map.get("importTime").get(0) ;
        if(map.containsKey("outtimeDay"))
            outtimeDay=(String) map.get("outtimeDay").get(0) ;
        if(map.containsKey("birthGoods"))
            birthGoods=(String) map.get("birthGoods").get(0) ;
        if(map.containsKey("goodsMoney"))
            goodsMoney= Double.parseDouble((String) map.get("goodsMoney").get(0)) ;
        if(map.containsKey("importNum"))
            importNum= Double.parseDouble((String) map.get("importNum").get(0));
        if(map.containsKey("expirationLimit"))
            expirationLimit= Integer.parseInt((String) map.get("expirationLimit").get(0)) ;

    }
}
