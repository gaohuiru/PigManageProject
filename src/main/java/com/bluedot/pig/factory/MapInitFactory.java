package com.bluedot.pig.factory;

import com.bluedot.framework.simplespring.core.annotation.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xxbb
 */
@Repository
public class MapInitFactory {
    /**
     * 创建存储分页参数的map，为controller提供map对象
     * @param pageNo 页码
     * @param pageSize 页面大小
     * @return map
     */
    public Map<String,Object> createServiceMapForSimpleQueryList(Integer pageNo,Integer pageSize){
        //当正确传入分页参数时
        if (pageNo == null || pageSize == null) {
            pageNo = 1;
            pageSize = 10;
        }
        int pageStart=(pageNo-1)*pageSize;
        Map<String,Object> serviceMap=new HashMap<>(16);
        serviceMap.put("pageNo",pageNo);
        serviceMap.put("pageStart",pageStart);
        serviceMap.put("pageSize",pageSize);
        return serviceMap;
    }
}
