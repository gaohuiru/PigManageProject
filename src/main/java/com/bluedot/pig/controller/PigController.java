package com.bluedot.pig.controller;

import com.bluedot.framework.simplespring.core.annotation.Controller;
import com.bluedot.framework.simplespring.inject.annotation.Autowired;
import com.bluedot.framework.simplespring.mvc.annotation.RequestMapping;
import com.bluedot.framework.simplespring.mvc.annotation.RequestParam;
import com.bluedot.framework.simplespring.mvc.type.ModelAndView;
import com.bluedot.framework.simplespring.mvc.type.RequestMethod;
import com.bluedot.pig.controller.base.BaseController;
import com.bluedot.pig.controller.callback.ControllerCallback;
import com.bluedot.pig.service.PigService;

import javax.servlet.http.HttpServlet;
import java.util.Map;

/**
 * 猪只请求处理，页面的转发尽量避免转发到@RequestMapping的方法请求上，减少请求方法之间的耦合
 * @author xxbb
 */
@Controller
@RequestMapping("/pig")
public class PigController extends HttpServlet {
    /**
     * 处理猪只业务的service
     */
    @Autowired
    PigService pigService;
    /**
     * 提供处理请求的通用方法
     */
    @Autowired
    BaseController baseController;

    /**
     * 基本的猪只数据列表查询
     * @param serviceMap 页面数据
     * @return 视图
     */
    @RequestMapping("/queryPigs")
    public ModelAndView queryPigs(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-info-list.jsp");
        return baseController.simpleRequestTemplate(pigService,serviceMap, dispatchPath, new ControllerCallback() {
            @Override
            public void beforeDoServiceForSimpleRequest(Map<String, Object> serviceMap, StringBuilder dispatchPath) {
                serviceMap.put("service","queryPigs");
            }
        });
    }
    @RequestMapping("/removePig")
    public ModelAndView removePig(@RequestParam("map") Map<String,Object> serviceMap){

        StringBuilder dispatchPath=new StringBuilder("/pig/pig-info-list.jsp");
        return baseController.simpleRequestTemplate(pigService, serviceMap,dispatchPath, new ControllerCallback() {
            @Override
            public void beforeDoServiceForSimpleRequest(Map<String, Object> serviceMap, StringBuilder dispatchPath) {
                serviceMap.put("service","removePig");
            }
        });
    }
    @RequestMapping(value = "/modifyPig",method = RequestMethod.POST)
    public ModelAndView modifyPig(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-info-list.jsp");
        return baseController.simpleRequestTemplate(pigService, serviceMap, dispatchPath, new ControllerCallback() {
            @Override
            public void beforeDoServiceForSimpleRequest(Map<String, Object> serviceMap, StringBuilder dispatchPath) {
                serviceMap.put("service","modifyPig");
            }
        });
    }
    @RequestMapping(value = "/addPig",method = RequestMethod.POST )
    public ModelAndView addPig(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-info-list.jsp");
        return baseController.simpleRequestTemplate(pigService, serviceMap, dispatchPath, new ControllerCallback() {
            @Override
            public void beforeDoServiceForSimpleRequest(Map<String, Object> serviceMap, StringBuilder dispatchPath) {
                serviceMap.put("service","addPig");
            }
        });
    }
}
