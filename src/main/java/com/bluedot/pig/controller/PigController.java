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

import java.util.Map;

/**
 * 猪只请求处理，页面的转发尽量避免转发到@RequestMapping的方法请求上，减少请求方法之间的耦合
 * @author xxbb
 */
@Controller
@RequestMapping("/pig")
public class PigController extends BaseController {
    /**
     * 处理猪只业务的service
     */
    @Autowired
    PigService pigService;

    /**
     * 基本的猪只数据列表查询
     * @param serviceMap 页面数据
     * @return 视图
     */
    @RequestMapping("/queryPigs")
    public ModelAndView queryPigs(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-info-list.jsp");
        return simpleRequestTemplate(pigService,serviceMap, dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping(value = "/removePig",method = RequestMethod.POST)
    public ModelAndView removePig(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-info-list.jsp");
        return simpleRequestTemplate(pigService, serviceMap,dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping(value = "/modifyPig",method = RequestMethod.POST)
    public ModelAndView modifyPig(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-info-list.jsp");
        return simpleRequestTemplate(pigService, serviceMap, dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping(value = "/addPig",method = RequestMethod.POST )
    public ModelAndView addPig(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-info-list.jsp");
        return simpleRequestTemplate(pigService, serviceMap, dispatchPath, new ControllerCallback() {});
    }
    /**
     * 基本的猪只数据列表查询
     * @param serviceMap 页面数据
     * @return 视图
     */
    @RequestMapping("/queryPigVarieties")
    public ModelAndView queryPigVarieties(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-variety-list.jsp");
        return simpleRequestTemplate(pigService,serviceMap, dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping(value = "/removePigVariety",method = RequestMethod.POST)
    public ModelAndView removePigVariety(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-variety-list.jsp");
        return simpleRequestTemplate(pigService, serviceMap,dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping(value = "/modifyPigVariety",method = RequestMethod.POST)
    public ModelAndView modifyPigVariety(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-variety-list.jsp");
        return simpleRequestTemplate(pigService, serviceMap, dispatchPath, new ControllerCallback() {});
    }
    @RequestMapping(value = "/addPigVariety",method = RequestMethod.POST )
    public ModelAndView addPigVariety(@RequestParam("map") Map<String,Object> serviceMap){
        StringBuilder dispatchPath=new StringBuilder("/pig/pig-variety-list.jsp");
        return simpleRequestTemplate(pigService, serviceMap, dispatchPath, new ControllerCallback() {});
    }

}
